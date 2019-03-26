/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.web.controller.authorizedperson;

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
import com.zillionfortune.t.biz.authorizedperson.AuthorizedPersonBiz;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonAuditRequest;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonPageQueryRequest;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonQueryRequest;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonStatusQueryRequest;
import com.zillionfortune.t.biz.authorizedperson.dto.AuthorizedPersonUpdateRequest;
import com.zillionfortune.t.biz.common.ShortMessageBiz;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.enums.SmsCode;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.common.util.PageBean;
import com.zillionfortune.t.web.controller.authorizedperson.check.AuthorizedPersonRequestParameterChecker;
import com.zillionfortune.t.web.controller.authorizedperson.vo.AuthorizedPersonAuditRequestVo;
import com.zillionfortune.t.web.controller.authorizedperson.vo.AuthorizedPersonPageQueryRequestVo;
import com.zillionfortune.t.web.controller.authorizedperson.vo.AuthorizedPersonQueryRequestVo;
import com.zillionfortune.t.web.controller.authorizedperson.vo.AuthorizedPersonStatusQueryRequestVo;
import com.zillionfortune.t.web.controller.authorizedperson.vo.AuthorizedPersonUpdateRequestVo;

/**
 * ClassName: AuthorizedPersonController <br/>
 * Function: 被授权人相关controller层. <br/>
 * Date: 2016年12月22日 上午11:12:14 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Controller
@RequestMapping("/authorizedpersonservice")
public class AuthorizedPersonController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private AuthorizedPersonBiz authorizedPersonBiz;
	
	@Resource
	private AuthorizedPersonRequestParameterChecker parameterChecker;

	@Resource
	private ShortMessageBiz shortMessageBiz;
	
	/**
	 * authorizedPersonUpdate:新增被授权人方法. <br/>
	 *
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/authorizedpersonupdate.json",method=RequestMethod.POST)
	public BaseWebResponse authorizedPersonUpdate(@RequestBody AuthorizedPersonUpdateRequestVo vo){
		
		log.info("AuthorizedPersonController.authorizedPersonUpdate.req:" + JSON.toJSONString(vo));
		
		BaseWebResponse resp = null; 
		
		try {
			
			//1.===参数校验
			parameterChecker.checkAuthorizedPersonRequest(vo);
			
			//2.===验证码校验
			BaseWebResponse smsResp = shortMessageBiz.verifyVerificationCode(vo.getMobile(), vo.getVerificationCode(), 
					SmsCode.NEW_AUTH.code());
			if(!RespCode.SUCCESS.code().equals(smsResp.getRespCode())
					|| !ResultCode.SUCCESS.code().equals(smsResp.getResultCode()) ){
				
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),smsResp.getResultCode(),smsResp.getResultMsg());
				return resp;
			}
			
			//3.===参数对象封装
			AuthorizedPersonUpdateRequest req = new AuthorizedPersonUpdateRequest();
			PropertyUtils.copyProperties(req, vo);
			
			//4.===调用更新授权方法
			resp = authorizedPersonBiz.authorizedPersonUpdate(req);
			
		} catch (Exception e) {
			
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		} 
		
		log.info("AuthorizedPersonController.authorizedPersonUpdate.resp:" + JSON.toJSONString(resp));
		
		return resp;
	}
	
	/**
	 * authorizedPersonUpdateAudit:更新被授权人审核状态. <br/>
	 *
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/authorizedpersonupdateaudit.json",method=RequestMethod.POST)
	public BaseWebResponse authorizedPersonUpdateAudit(AuthorizedPersonAuditRequestVo vo){
		
		log.info("AuthorizedPersonController.authorizedPersonUpdateAudit.req:" + JSON.toJSONString(vo));
		
		BaseWebResponse resp = null; 
		
		try {
			
			//1.===参数校验
			parameterChecker.checkAuthorizedPersonAuditRequest(vo);
			
			//2.===参数对象封装
			AuthorizedPersonAuditRequest req = new AuthorizedPersonAuditRequest();
			PropertyUtils.copyProperties(req, vo);
			
			//3.===调用更新方法
			resp = authorizedPersonBiz.authorizedPersonUpdateAudit(req);
			
		} catch (Exception e) {
			
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		} 
		
		log.info("AuthorizedPersonController.authorizedPersonUpdateAudit.resp:" + JSON.toJSONString(resp));
		
		return resp;
	}
	
	/**
	 * authorizedPersonQuery:查询被授权人. <br/>
	 *
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/authorizedpersonquery.json",method=RequestMethod.POST)
	public BaseWebResponse authorizedPersonQuery(AuthorizedPersonQueryRequestVo vo){
		
		log.info("AuthorizedPersonController.authorizedPersonQuery.req:" + JSON.toJSONString(vo));
		
		BaseWebResponse resp = null; 
		
		try {
			
			//1.===参数校验
			parameterChecker.checkAuthorizedPersonQueryRequest(vo);
			
			//2.===参数对象封装
			AuthorizedPersonQueryRequest req = new AuthorizedPersonQueryRequest();
			PropertyUtils.copyProperties(req, vo);
		
			//3.===调用查询方法
			resp = authorizedPersonBiz.authorizedPersonQuery(req);
			
		} catch (Exception e) {
			
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		} 
		
		log.info("AuthorizedPersonController.authorizedPersonQuery.resp:" + JSON.toJSONString(resp));
		
		return resp;
	}
	
	/**
	 * authorizedPersonStatusQuery:查询被授权人是否有审批中的. <br/>
	 *
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/authorizedpersonstatusquery.json",method=RequestMethod.POST)
	public BaseWebResponse authorizedPersonStatusQuery(@RequestBody AuthorizedPersonStatusQueryRequestVo vo){
		
		log.info("AuthorizedPersonController.authorizedPersonQuery.req:" + JSON.toJSONString(vo));
		
		BaseWebResponse resp = null; 
		
		try {
			
			//1.===参数校验
			parameterChecker.checkAuthorizedPersonStatusQueryRequest(vo);
			
			//2.===参数对象封装
			AuthorizedPersonStatusQueryRequest req = new AuthorizedPersonStatusQueryRequest();
			PropertyUtils.copyProperties(req, vo);
		
			//3.===调用查询方法
			resp = authorizedPersonBiz.authorizedPersonStatusQuery(req);
			
		} catch (Exception e) {
			
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		} 
		
		log.info("AuthorizedPersonController.authorizedPersonQuery.resp:" + JSON.toJSONString(resp));
		
		return resp;
	}
	
	/**
	 * authorizedPersonQuery:查询被授权人（分页）. <br/>
	 *
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/authorizedpersonpagequery.json",method=RequestMethod.POST)
	public BaseWebResponse authorizedPersonPageQuery(AuthorizedPersonPageQueryRequestVo vo){
		
		log.info("AuthorizedPersonController.authorizedPersonPageQuery.req:" + JSON.toJSONString(vo));
		
		BaseWebResponse resp = null; 
		
		try {
			
			//1.===参数校验
			parameterChecker.checkAuthorizedPersonPageQueryRequest(vo);
			
			//2.===参数对象封装
			AuthorizedPersonPageQueryRequest req = new AuthorizedPersonPageQueryRequest();
			PropertyUtils.copyProperties(req, vo);
		
			//3.===调用查询方法
		    if(req.getPageSize() != null && req.getCurrentPage() != null){
		    	PageBean pageBean = new PageBean(vo.getCurrentPage(), vo.getPageSize());
		    	req.setPageStart(pageBean.getPageStart());
				req.setPageSize(pageBean.getPageSize());
		    }
		  
			resp = authorizedPersonBiz.authorizedPersonPageQuery(req);
			
		} catch (Exception e) {
			
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		} 
		
		log.info("AuthorizedPersonController.authorizedPersonPageQuery.resp:" + JSON.toJSONString(resp));
		
		return resp;
	}
	
}
