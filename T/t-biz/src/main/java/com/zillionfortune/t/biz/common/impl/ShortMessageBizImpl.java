/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.biz.common.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.common.ShortMessageBiz;
import com.zillionfortune.t.biz.common.ShortMessageRedisUtils;
import com.zillionfortune.t.common.constants.CommonConstants;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.common.util.DynamicCodeUtils;
import com.zillionfortune.t.integeration.cif.UserRegisterIntegration;
import com.zillionfortune.t.integeration.cif.dto.CheckUserNameRegisterCifResponse;
import com.zillionfortune.t.integeration.sms.ShortMessageIntegration;
import com.zillionfortune.t.integeration.sms.dto.ShortMessageServiceRequest;
import com.zillionfortune.t.integeration.sms.dto.ShortMessageServiceResponse;

/**
 * ClassName: ShortMessageBizImpl <br/>
 * Function: 短信服务BizImpl. <br/>
 * Date: 2016年12月16日 下午1:33:46 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */

@Component
public class ShortMessageBizImpl implements ShortMessageBiz {

	@Resource
	private ShortMessageIntegration shortMessageIntegration;
	
	@Resource
	private ShortMessageRedisUtils shortMessageRedisUtils;
	
	@Resource
	private UserRegisterIntegration userRegisterIntegration;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 短信发送验证码.
	 * @see com.zillionfortune.t.biz.common.ShortMessageBiz#send(java.lang.String, java.lang.Integer)
	 */
	@Override
	public BaseWebResponse sendVerificationCode(String mobile,String smsCode) {
		
		log.info("ShortMessageBizImpl.send.req:{mobile:" + mobile +",smsCode:"+smsCode+"}" );
		
		BaseWebResponse resp = null;
		
		ShortMessageServiceResponse smsResp;
		
		try {
			
			//1.===请求参数封装
			ShortMessageServiceRequest req = new ShortMessageServiceRequest();
			req.setMobile(mobile);
			req.setSmsCode(smsCode);
			req.setSysCode(CommonConstants.SMS_SYS_CODE);
			Map<String,String> content = new HashMap<String,String>();
			String code = DynamicCodeUtils.generate(CommonConstants.SMS_CODE_LENGTH, CommonConstants.SMS_CONTAINS_CHAR);
			content.put("code", code);
			req.setContent(content);
			
			//2.===验证码存入redis
			shortMessageRedisUtils.setCodeIntoRedis(smsCode+"_"+mobile, code);
			
			//3.===调用sms发送服务	
			smsResp = shortMessageIntegration.send(req);
			log.info("短信系统返回对象"+smsResp);
			
			//4.===处理反馈结果
			if(CommonConstants.SMS_SUCCESS_RESP_CODE != smsResp.getRespCode()
					|| CommonConstants.SMS_SUCCESS_RESULT_CODE != smsResp.getResultCode() ){
				
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),
						"SMS"+String.valueOf(smsResp.getResultCode()),smsResp.getResultDesc());
				
				return resp;
			}
			
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			
			Map<String,String> respMap = new HashMap<String,String>();
			respMap.put("mobile",mobile);
			resp.setData(respMap);
				
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		}finally{
			
			log.info("ShortMessageBizImpl.send.resp:" + JSON.toJSONString(resp));
		}
	
		return resp;
	
	}

	/**
	 * TODO 发送公共码值方法.
	 * @see com.zillionfortune.t.biz.common.ShortMessageBiz#sendCommonCode(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public BaseWebResponse sendCommonCode(String mobile, String smsCode,String code) {
		
		log.info("ShortMessageBizImpl.sendCommonCode.req:{mobile:" + mobile +",smsCode:"+smsCode+"}" );
		
		BaseWebResponse resp = null;
		
		ShortMessageServiceResponse smsResp;
		
		try {
			
			//1.===请求参数封装
			ShortMessageServiceRequest req = new ShortMessageServiceRequest();
			req.setMobile(mobile);
			req.setSmsCode(smsCode);
			req.setSysCode(CommonConstants.SMS_SYS_CODE);
			Map<String,String> content = new HashMap<String,String>();
			content.put("code", code);
			req.setContent(content);
		
			//2.===调用sms发送服务	
			smsResp = shortMessageIntegration.send(req);
			log.info("短信系统返回对象"+smsResp);
			
			//3.===处理反馈结果
			if(CommonConstants.SMS_SUCCESS_RESP_CODE != smsResp.getRespCode()
					|| CommonConstants.SMS_SUCCESS_RESULT_CODE != smsResp.getResultCode() ){
				
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),
						"SMS"+String.valueOf(smsResp.getResultCode()),smsResp.getResultDesc());
				
				return resp;
				
			}
			
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			
			Map<String,String> respMap = new HashMap<String,String>();
			respMap.put("mobile",mobile);
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
			log.info("ShortMessageBizImpl.sendCommonCode.resp:" + JSON.toJSONString(resp));
		}
		
		return resp;
	
	}

	/**
	 * 发送短信内容方法.
	 * @see com.zillionfortune.t.biz.common.ShortMessageBiz#sendCommonMessage(java.lang.String, java.lang.String)
	 */
	@Override
	public BaseWebResponse sendCommonMessage(String mobile, String smsCode) {

		log.info("ShortMessageBizImpl.sendCommonMessage.req:{mobile:" + mobile +",smsCode:"+smsCode+"}" );
		
		BaseWebResponse resp = null;
		
		ShortMessageServiceResponse smsResp;
		
		try {
			
			//1.===请求参数封装
			ShortMessageServiceRequest req = new ShortMessageServiceRequest();
			req.setMobile(mobile);
			req.setSmsCode(smsCode);
			req.setSysCode(CommonConstants.SMS_SYS_CODE);
			
			//2.===调用sms发送服务	
			smsResp = shortMessageIntegration.send(req);
			log.info("短信系统返回对象"+smsResp);
			
			//3===处理反馈结果
			if(CommonConstants.SMS_SUCCESS_RESP_CODE != smsResp.getRespCode()
					|| CommonConstants.SMS_SUCCESS_RESULT_CODE != smsResp.getResultCode() ){
				
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),
						"SMS"+String.valueOf(smsResp.getResultCode()),smsResp.getResultDesc());
				
				return resp;
			}
			
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			
			Map<String,String> respMap = new HashMap<String,String>();
			respMap.put("mobile",mobile);
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
			log.info("ShortMessageBizImpl.sendCommonMessage.resp:" + JSON.toJSONString(resp));
		}
	
		return resp;
	
	}
	
	/**
	 * 校验短信验证码.
	 * @see com.zillionfortune.t.biz.common.ShortMessageBiz#verify(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public BaseWebResponse verifyVerificationCode(String mobile, String code, String smsCode) {
		log.info("ShortMessageBizImpl.verifyVerificationCode.req:{mobile:" + mobile +",smsCode:" + smsCode + ",code: " + code + "}" );
	
		BaseWebResponse resp = null;
		
		try {
			
			//1.===从redis中取出验证码进行比较
			String existsCode = shortMessageRedisUtils.getCodeFromRedis(smsCode+"_"+mobile);
			
			if(StringUtils.isBlank(existsCode)){
				
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.VERIFICATION_CODE_TIMEOUT.code(),
						ResultCode.VERIFICATION_CODE_TIMEOUT.desc());
				
				return resp;
			}
			
			if(!code.equals(existsCode)){
				
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.VERIFICATION_CODE_ERROR.code(),
						ResultCode.VERIFICATION_CODE_ERROR.desc());
				
				return resp;
			}
		
			//2.===反馈结果
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			
			Map<String,String> respMap = new HashMap<String,String>();
			respMap.put("mobile",mobile);
			resp.setData(respMap);
				
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		} finally {
			log.info("ShortMessageBizImpl.verifyVerificationCode.resp:" + JSON.toJSONString(resp));
		}
	
		return resp;
	
	}

	/**
	 * 发送短信之前校验手机号码是否注册过.
	 * @see com.zillionfortune.t.biz.common.ShortMessageBiz#checkUserNameRegister(java.lang.String)
	 */
	@Override
	public BaseWebResponse checkUserNameRegister(String mobile) {
		
		log.info("ShortMessageBizImpl.checkUserNameRegister.req:{mobile:" + mobile + "}" );
	
		BaseWebResponse resp = null;
		
		CheckUserNameRegisterCifResponse cifResp = null;
		
		try {
			
			//1.===调用cif接口校验手机号码是否注册过
			cifResp = userRegisterIntegration.checkUserNameRegister(mobile);
			
			//2.===处理反馈结果
			if(!RespCode.SUCCESS.code().equals(cifResp.getRespCode())
					|| !ResultCode.SUCCESS.code().equals(cifResp.getResultCode()) ){
				
			    resp = new BaseWebResponse(RespCode.SUCCESS.code(),cifResp.getResultCode(), cifResp.getResultMsg());
				return resp;
			}
			
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			
			Map<String,Boolean> respMap = new HashMap<String,Boolean>();
			respMap.put("existFlag",cifResp.isExistFlag());
			resp.setData(respMap);
				
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		} finally {
			log.info("ShortMessageBizImpl.checkUserNameRegister.resp:" + JSON.toJSONString(resp));
		}
	
		return resp;

	}

}