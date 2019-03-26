/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.web.controller.common;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.common.ShortMessageBiz;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.web.controller.common.check.ShortMessageParameterChecker;
import com.zillionfortune.t.web.controller.common.vo.ShortMessageSendRequestVo;
import com.zillionfortune.t.web.controller.common.vo.ShortMessageVerifyRequestVo;

/**
 * ClassName: SendMobileMsgController <br/>
 * Function: 短信服务接口. <br/>
 * Date: 2016年12月16日 上午11:00:46 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Controller
@RequestMapping("/smsservice")
public class ShortMessageController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private ShortMessageBiz shortMessageBiz; 
	
	@Resource
	private ShortMessageParameterChecker paramChecker;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	/**
	 * sendVerificationCode:验证码短信发送controller. <br/>
	 *
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/sendverificationcode",method=RequestMethod.POST)
	public BaseWebResponse sendVerificationCode (@RequestBody ShortMessageSendRequestVo vo){
		
		log.info("ShortMessageController.sendVerificationCode.req:" + JSON.toJSONString(vo));

		BaseWebResponse resp = null;
		
		try {
			
			//1.===参数校验
			paramChecker.checkSendRequest(vo);
		
			//2.===调用发送服务
			resp = shortMessageBiz.sendVerificationCode(vo.getMobile(),vo.getBusinessType());
			
		} catch (Exception e) {
			
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		} finally {
			
			log.info("ShortMessageController.sendVerificationCode.resp:" + JSON.toJSONString(resp));
		}
		
		return resp;
	}
	
	/**
	 * sendCommonMessage:公用短信发送controller. <br/>
	 *
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/sendcommonmessage",method=RequestMethod.POST)
	public BaseWebResponse sendCommonMessage (@RequestBody ShortMessageSendRequestVo vo){
		
		log.info("ShortMessageController.sendCommonMessage.req:" + JSON.toJSONString(vo));

		BaseWebResponse resp = null;
		
		try {
			
			//1.===参数校验
			paramChecker.checkSendRequest(vo);
			
			//2.===调用发送服务
			resp = shortMessageBiz.sendCommonMessage(vo.getMobile(),vo.getBusinessType());
			
		} catch (Exception e) {
			
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		} finally {
			
			log.info("ShortMessageController.sendCommonMessage.resp:" + JSON.toJSONString(resp));
		}
		
		return resp;
	}
	
	/**
	 * verify:短信验证controller. <br/>
	 *
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/verify",method=RequestMethod.POST)
	public BaseWebResponse verify (@RequestBody ShortMessageVerifyRequestVo vo){
		
		log.info("ShortMessageController.verify.req:" + JSON.toJSONString(vo));

		BaseWebResponse resp = null;
		
		try {
			
			//1.===参数校验
			paramChecker.checkVerifyRequest(vo);
			
			//2.===调用验证服务
			resp = shortMessageBiz.verifyVerificationCode(vo.getMobile(),vo.getVerificationCode(),vo.getBusinessType());
			
		} catch (Exception e) {
			
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		} 
		
		log.info("ShortMessageController.verify.resp:" + JSON.toJSONString(resp));
		
		return resp;
	}
	
	/**
	 * verifyRegisterMobile:短信发送之前校验手机号是否注册过. <br/>
	 *
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/verifyregistermobile",method=RequestMethod.POST)
	public BaseWebResponse verifyRegisterMobile (@RequestBody JSONObject jsonObject){
		
		log.info("ShortMessageController.verifyRegisterMobile.req:" + JSON.toJSONString(jsonObject));

		BaseWebResponse resp = null;
		
		try {
			
			//1.===获取参数值
			if(jsonObject == null) {
				throw new BusinessException("请求参数对象不能为空");
			}
		
			String mobile = jsonObject.getString("mobile");
			
			if(StringUtils.isBlank(mobile)){
				throw new BusinessException("手机号码不能为空");
			}
			
			//3.===手机号码校验
			resp = shortMessageBiz.checkUserNameRegister(mobile);
		
		} catch (Exception e) {
			
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		} finally {
			
			log.info("ShortMessageController.verifyRegisterMobile.resp:" + JSON.toJSONString(resp));
			
		}
		
		return resp;
	}
	
	/**
	 * verifyLoginMobile:短信发送之前校验手机号是否登录过. <br/>
	 *
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/verifyloginmobile",method=RequestMethod.POST)
	public BaseWebResponse verifyLoginMobile (@RequestBody JSONObject jsonObject){
		
		log.info("ShortMessageController.verifyLoginMobile.req:" + JSON.toJSONString(jsonObject));

		BaseWebResponse resp = null;
		
		try {
			
			//1.===获取参数值
			if(jsonObject == null) {
				throw new BusinessException("请求参数对象不能为空");
			}
		
			String mobile = jsonObject.getString("mobile");
			Long operatorId = jsonObject.getLong("operatorId");
			
			if(StringUtils.isBlank(mobile)){
				throw new BusinessException("手机号码不能为空");
			}
			
			if(operatorId == null){
				throw new BusinessException("操作员id不能为空");
			}
			
			//2.===手机号码校验
			boolean flag = verifyMobile(mobile,operatorId);
			/*
			if(!flag){
				 resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SMS_VERIFY_MOBILE_ERROR.code(),
						 ResultCode.SMS_VERIFY_MOBILE_ERROR.desc());
				return resp;
			}
			*/
			//3.===封装反馈
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			Map<String,Boolean> respMap = new HashMap<String,Boolean>();
			respMap.put("existFlag",flag);
			resp.setData(respMap);
			
		} catch (Exception e) {
			
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		} finally {
			
			log.info("ShortMessageController.verifyLoginMobile.resp:" + JSON.toJSONString(resp));
		}
		
		return resp;
	}
	
	public boolean verifyMobile(String mobile,Long operatorId){
		
		if(StringUtils.isBlank(mobile) || operatorId == null){
			return true;
		}
		
		String loginName = redisTemplate.opsForValue().get("username_"+operatorId);
		
		return mobile.equals(loginName);
	}
	
}
