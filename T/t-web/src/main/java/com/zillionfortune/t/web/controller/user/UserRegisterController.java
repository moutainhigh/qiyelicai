/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.web.controller.user;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.common.ShortMessageBiz;
import com.zillionfortune.t.biz.user.UserRegisterBiz;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.enums.SmsCode;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.integeration.cif.dto.UserCheckRequest;
import com.zillionfortune.t.integeration.cif.dto.UserRegisterRequest;
import com.zillionfortune.t.web.controller.user.check.UserRegisterParameterChecker;
import com.zillionfortune.t.web.controller.user.vo.UserCheckRequestVo;
import com.zillionfortune.t.web.controller.user.vo.UserRegisterRequestVo;

/**
 * ClassName: UserRegisterController <br/>
 * Function: 企业客户注册接口 <br/>
 * Date: 2016年12月13日 下午5:31:26 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Controller
@RequestMapping("/enterpriseservice")
public class UserRegisterController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private UserRegisterParameterChecker parameterChecker;
	
	@Resource
	private UserRegisterBiz userRegisterBiz; 
	
	@Resource
	private ShortMessageBiz shortMessageBiz;
	
	/**
	 * register:企业会员注册. <br/>
	 *
	 * @param 
	 * @return 
	 * @throws 
	 */
	@ResponseBody
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public BaseWebResponse register(@RequestBody UserRegisterRequestVo vo){
		log.info("UserRegisterController.register.req:" + JSON.toJSONString(vo));
		
		UserRegisterRequest req = null;
		BaseWebResponse resp = null; 
		
		try {
			
			//1.===参数校验
			parameterChecker.checkUserRegisterRequest(vo);
			
			//2.===验证码校验
			BaseWebResponse smsResp = shortMessageBiz.verifyVerificationCode(vo.getMobile(), vo.getVerificationCode(), 
					SmsCode.REG.code());
			if(!RespCode.SUCCESS.code().equals(smsResp.getRespCode())
					|| !ResultCode.SUCCESS.code().equals(smsResp.getResultCode()) ){
				
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),smsResp.getResultCode(),smsResp.getResultMsg());
				return resp;
			}
			
			//3.===参数对象封装
			req = new UserRegisterRequest();
			PropertyUtils.copyProperties(req, vo);
			
			//4.===调用注册服务
			resp = userRegisterBiz.register(req);
			
		} catch (Exception e) {
			
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		} finally {
			log.info("UserRegisterController.register.resp:" + JSON.toJSONString(resp));
		}
	
		return resp;
	}
	
	/**
	 * checkEnterpriseExists:企业注册根据证件类型证件号码校验企业是否存在. <br/>
	 *
	 * @param 
	 * @return 
	 * @throws 
	 */
	@ResponseBody
	@RequestMapping(value="/checkenterpriseexists",method=RequestMethod.POST)
	public BaseWebResponse checkEnterpriseExists(@RequestBody UserCheckRequestVo vo){
		log.info("UserRegisterController.checkEnterpriseExists.req:" + JSON.toJSONString(vo));
		
		UserCheckRequest req = null;
		BaseWebResponse resp = null; 
		
		try {
			
			//1.===参数校验
			parameterChecker.checkEnterpriseExistsRequest(vo);
			
			//2.===参数对象封装
			req = new UserCheckRequest();
			PropertyUtils.copyProperties(req, vo);
			
			//3.===调用注册服务
			resp = userRegisterBiz.checkEnterpriseExists(req);
			
		} catch (Exception e) {
			
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		} finally {
			log.info("UserRegisterController.checkEnterpriseExists.resp:" + JSON.toJSONString(resp));
		}
	
		return resp;
	}
	
}
