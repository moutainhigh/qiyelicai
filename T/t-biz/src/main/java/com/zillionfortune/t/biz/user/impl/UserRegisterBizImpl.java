/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.biz.user.impl;

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
import com.zillionfortune.t.biz.user.UserRegisterBiz;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.enums.SmsCode;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.integeration.cif.UserRegisterIntegration;
import com.zillionfortune.t.integeration.cif.dto.UserCheckExistsCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserCheckRequest;
import com.zillionfortune.t.integeration.cif.dto.UserRegisterCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserRegisterRequest;

/**
 * ClassName: UserRegisterBizImpl <br/>
 * Function: 企业会员注册接口实现. <br/>
 * Date: 2016年12月13日 下午6:21:33 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class UserRegisterBizImpl implements UserRegisterBiz{

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private UserRegisterIntegration userRegisterIntegration;
	
	@Resource
	private ShortMessageBiz shortMessageBiz;
	
	/**
	 * 企业注册.
	 * @see com.zillionfortune.t.biz.user.UserRegisterBiz#register(com.zillionfortune.t.integeration.cif.dto.UserRegisterRequest)
	 */
	@Override
	public BaseWebResponse register(UserRegisterRequest req) {
		
		log.info("UserRegisterBizImpl.register.req:" + JSON.toJSONString(req));
		
		BaseWebResponse resp = null;
		
		UserRegisterCifResponse cifResp = null;
		
		UserCheckExistsCifResponse userCheckExistsCifResponse = null;
		try {
			
			//0.===校验证件类型证件号码是否重复注册
			UserCheckRequest userCheckRequest = new UserCheckRequest();
			userCheckRequest.setCertificateNo(req.getCertificateNo());
			userCheckRequest.setCertificateType(req.getCertificateType());
			userCheckExistsCifResponse = userRegisterIntegration.checkEnterpriseExists(userCheckRequest);
			if(RespCode.FAIL.code().equals(userCheckExistsCifResponse.getRespCode()) 
					|| ResultCode.FAIL.code().equals(userCheckExistsCifResponse.getResultCode())){
				
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(), ResultCode.FAIL.desc());
				return resp;
			}
			
			if(RespCode.SUCCESS.code().equals(userCheckExistsCifResponse.getRespCode())
					&& ResultCode.SUCCESS.code().equals(userCheckExistsCifResponse.getResultCode()) ){
				
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.EXISTS_CERTTYPE_AND_CERTNO.code(),
						ResultCode.EXISTS_CERTTYPE_AND_CERTNO.desc());
				return resp;
			}
			
			//1.===调用cif注册服务	
			cifResp = userRegisterIntegration.register(req);
			
			//2.===处理反馈结果
			if(!RespCode.SUCCESS.code().equals(cifResp.getRespCode())
					|| !ResultCode.SUCCESS.code().equals(cifResp.getResultCode()) ){
				
			    resp = new BaseWebResponse(RespCode.SUCCESS.code(),cifResp.getResultCode(), cifResp.getResultMsg());
				return resp;
			}
			
			//3.===注册成功后发送商户号到客户手机
			BaseWebResponse smsResp = shortMessageBiz.sendCommonCode(req.getMobile(), SmsCode.PUSH_EP_NO.code(), 
					cifResp.getCustomerNo());
			log.info("UserRegisterBizImpl.register.sendCommonCode:" + JSON.toJSONString(smsResp));
			
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			
			Map<String,String> respMap = new HashMap<String,String>();
			respMap.put("memberId", cifResp.getMemberId());
			respMap.put("customerId", cifResp.getCustomerId());
			respMap.put("customerNo", cifResp.getCustomerNo());
			respMap.put("operatorId", String.valueOf(cifResp.getOperatorId()));
		
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
			log.info("UserRegisterBizImpl.register.resp:" + JSON.toJSONString(resp));
		}
	
		return resp;
	}

	/**
	 * 企业注册根据证件类型证件号码校验企业是否存在.
	 * @see com.zillionfortune.t.biz.user.UserRegisterBiz#checkEnterpriseExists(com.zillionfortune.t.integeration.cif.dto.UserCheckRequest)
	 */
	@Override
	public BaseWebResponse checkEnterpriseExists(UserCheckRequest req) {

		log.info("UserRegisterBizImpl.checkEnterpriseExists.req:" + JSON.toJSONString(req));
		
		BaseWebResponse resp = null;
		
		UserCheckExistsCifResponse cifResp = null;
		
		try {
			
			//1.===调用cif注册服务	
			cifResp = userRegisterIntegration.checkEnterpriseExists(req);
			
			//2.===处理反馈结果
			if(RespCode.FAIL.code().equals(cifResp.getRespCode()) 
					|| ResultCode.FAIL.code().equals(cifResp.getResultCode())){
				
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(), ResultCode.FAIL.desc());
				return resp;
			}
			
			Map<String,Boolean> dataMap = new HashMap<String,Boolean>();
			if(RespCode.SUCCESS.code().equals(cifResp.getRespCode())
					&& ResultCode.SUCCESS.code().equals(cifResp.getResultCode()) ){
				
				dataMap.put("existsFlag", true);
			}else{
				
				dataMap.put("existsFlag", false);
			}
			
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			resp.setData(dataMap);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			if (e instanceof BusinessException) {
				
                resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
                
            } else {
            	
                resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
			
		} finally {
			log.info("UserRegisterBizImpl.checkEnterpriseExists.resp:" + JSON.toJSONString(resp));
		}
	
		return resp;
	
	}

}
