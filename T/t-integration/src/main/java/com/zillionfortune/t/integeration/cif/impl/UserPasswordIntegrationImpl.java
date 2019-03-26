/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.t.common.util.HttpClientUtil;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.common.util.MD5;
import com.zillionfortune.t.integeration.cif.UserPasswordIntegration;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordModifyCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordModifyRequest;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordRetrieveCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordRetrieveRequest;
import com.zillionfortune.t.integeration.cif.dto.UserTradePasswordModifyCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserTradePasswordRetrieveCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserTradePasswordSetCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserTradePasswordVerifyCifResponse;

/**
 * ClassName: UserPasswordIntegrationImpl <br/>
 * Function: 企业会员登录密码、交易密码服务. <br/>
 * Date: 2016年12月15日 下午1:26:09 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class UserPasswordIntegrationImpl implements UserPasswordIntegration{

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	/**
	 * cifEnterpriseRetrieveLoginPasswordUrl:企业会员重置登录密码调用远程URL请求地址.
	 */
	@Value("${cif.enterprise.retrieveloginpassword.url}")
	private String cifEnterpriseRetrieveLoginPasswordUrl;
	
	/**
	 * cifEnterpriseModifyLoginPasswordUrl:企业会员更新登录密码调用远程URL请求地址.
	 */
	@Value("${cif.enterprise.modifyloginpassword.url}")
	private String cifEnterpriseModifyLoginPasswordUrl;
	
	/**
	 * cifEnterpriseRetrieveTradePasswordUrl:企业会员重置交易密码调用远程URL请求地址.
	 */
	@Value("${cif.enterprise.retrievetradepassword.url}")
	private String cifEnterpriseRetrieveTradePasswordUrl;
	
	/**
	 * cifEnterpriseModifyTradePasswordUrl:企业会员更新交易密码调用远程URL请求地址.
	 */
	@Value("${cif.enterprise.modifytradepassword.url}")
	private String cifEnterpriseModifyTradePasswordUrl;
	
	/**
	 * cifEnterpriseVerifyTradePasswordUrl:企业会员验证交易密码调用远程URL请求地址.
	 */
	@Value("${cif.enterprise.verifytradepassword.url}")
	private String cifEnterpriseVerifyTradePasswordUrl;
	
	/**
	 * cifEnterpriseSetTradePasswordUrl:企业会员设置交易密码调用远程URL请求地址.
	 */
	@Value("${cif.enterprise.settradepassword.url}")
	private String cifEnterpriseSetTradePasswordUrl;
	
	/**
	 * setTradePasswordUrl:设置交易密码URL.
	 */
	@Value("${cif.enterprise.settradepassword.url}")
	private String setTradePasswordUrl;
	
	/**
	 * 企业会员重置登录密码.
	 * @see com.zillionfortune.t.integeration.cif.UserPasswordIntegration#retrieveLoginPassword(com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordRetrieveRequest)
	 */
	@Override
	public UserLoginPasswordRetrieveCifResponse retrieveLoginPassword(UserLoginPasswordRetrieveRequest req)
			throws Exception {
		log.info("UserPasswordIntegrationImpl.retrieveLoginPassword.req:" + JSON.toJSONString(req));

		// step1：参数绑定
		Map<String,String> mapParam = new HashMap<String,String>();
		mapParam.put("customerNo", req.getCustomerNo()); // 商户号
		mapParam.put("userName", req.getUserName()); // 用户名
		mapParam.put("newPassword", MD5.digest(req.getNewPassword(), "utf-8")); // 新密码   MD5加密

		// step2：发送请求
		String responseContent = HttpClientUtil.sendPostRequest(cifEnterpriseRetrieveLoginPasswordUrl, mapParam);
		
		// step3：处理反馈结果
		UserLoginPasswordRetrieveCifResponse cifResp = JsonUtils.json2Object(responseContent, UserLoginPasswordRetrieveCifResponse.class);;

		log.info("UserPasswordIntegrationImpl.retrieveLoginPassword.resp:" + responseContent);
		
		return cifResp;
	}

	/**
	 * 企业会员更新登录密码.
	 * @see com.zillionfortune.t.integeration.cif.UserPasswordIntegration#modifyLoginPassword(com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordModifyRequest)
	 */
	@Override
	public UserLoginPasswordModifyCifResponse modifyLoginPassword(UserLoginPasswordModifyRequest req)
			throws Exception {
		log.info("UserPasswordIntegrationImpl.modifyLoginPassword.req:" + JSON.toJSONString(req));

		// step1：参数绑定
		Map<String,String> mapParam = new HashMap<String,String>();
		mapParam.put("memberId", req.getMemberId()); // 会员Id
		mapParam.put("operatorId", req.getOperatorId()); // 操作员Id
		mapParam.put("newPassword", MD5.digest(req.getNewPassword(), "utf-8")); // 新密码   MD5加密
		mapParam.put("orgiPassword", MD5.digest(req.getOrgiPassword(), "utf-8")); // 原密码   MD5加密

		// step2：发送请求
		String responseContent = HttpClientUtil.sendPostRequest(cifEnterpriseModifyLoginPasswordUrl, mapParam);
		
		// step3：处理反馈结果
		UserLoginPasswordModifyCifResponse cifResp = JsonUtils.json2Object(responseContent, UserLoginPasswordModifyCifResponse.class);;

		log.info("UserPasswordIntegrationImpl.modifyLoginPassword.resp:" + responseContent);
		
		return cifResp;
	}

	/**
	 * 企业会员重置交易密码.
	 * @see com.zillionfortune.t.integeration.cif.UserPasswordIntegration#retrieveTradePassword(java.lang.String, java.lang.String)
	 */
	@Override
	public UserTradePasswordRetrieveCifResponse retrieveTradePassword(String memberId, String newPassword)
			throws Exception {
		log.info("UserPasswordIntegrationImpl.retrieveTradePassword.req:{memberId:" + memberId + "newPassword:" + newPassword + "}" );

		// step1：参数绑定
		Map<String,String> mapParam = new HashMap<String,String>();
		mapParam.put("memberId", memberId); // 会员Id
		mapParam.put("newPassword", MD5.digest(newPassword, "utf-8")); // 新密码   MD5加密

		// step2：发送请求
		String responseContent = HttpClientUtil.sendPostRequest(cifEnterpriseRetrieveTradePasswordUrl, mapParam);
		
		// step3：处理反馈结果
		UserTradePasswordRetrieveCifResponse cifResp = JsonUtils.json2Object(responseContent, UserTradePasswordRetrieveCifResponse.class);;

		log.info("UserPasswordIntegrationImpl.retrieveTradePassword.resp:" + responseContent);
		
		return cifResp;
	}

	/**
	 * 企业会员更新交易密码.
	 * @see com.zillionfortune.t.integeration.cif.UserPasswordIntegration#modifyTradePassword(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public UserTradePasswordModifyCifResponse modifyTradePassword(String memberId, String newPassword,
			String orgiPassword) throws Exception {
		log.info("UserPasswordIntegrationImpl.modifyTradePassword.req:{memberId:" + memberId + "newPassword:" + newPassword + "orgiPassword:" + orgiPassword + "}" );

		// step1：参数绑定
		Map<String,String> mapParam = new HashMap<String,String>();
		mapParam.put("memberId", memberId); // 会员Id
		mapParam.put("newPassword", MD5.digest(newPassword, "utf-8")); // 新密码  MD5加密
		mapParam.put("orgiPassword", MD5.digest(orgiPassword, "utf-8")); // 原密码  MD5加密

		// step2：发送请求
		String responseContent = HttpClientUtil.sendPostRequest(cifEnterpriseModifyTradePasswordUrl, mapParam);
		
		// step3：处理反馈结果
		UserTradePasswordModifyCifResponse cifResp = JsonUtils.json2Object(responseContent, UserTradePasswordModifyCifResponse.class);;

		log.info("UserPasswordIntegrationImpl.modifyTradePassword.resp:" + responseContent);
		
		return cifResp;
	}

	/**
	 * 企业会员验证交易密码.
	 * @see com.zillionfortune.t.integeration.cif.UserPasswordIntegration#verifyTradePassword(java.lang.String, java.lang.String)
	 */
	@Override
	public UserTradePasswordVerifyCifResponse verifyTradePassword(String memberId, String password)
			throws Exception {
		log.info("UserPasswordIntegrationImpl.verifyTradePassword.req:{memberId:" + memberId + "password:" + password + "}" );

		// step1：参数绑定
		Map<String,String> mapParam = new HashMap<String,String>();
		mapParam.put("memberId", memberId); // 会员Id
		mapParam.put("password", MD5.digest(password, "utf-8")); // 交易密码  MD5加密

		// step2：发送请求
		String responseContent = HttpClientUtil.sendPostRequest(cifEnterpriseVerifyTradePasswordUrl, mapParam);
		
		// step3：处理反馈结果
		UserTradePasswordVerifyCifResponse cifResp = JsonUtils.json2Object(responseContent, UserTradePasswordVerifyCifResponse.class);;

		log.info("UserPasswordIntegrationImpl.verifyTradePassword.resp:" + responseContent);
		
		return cifResp;
	}

	/**
	 * 企业会员设置交易密码.
	 * @see com.zillionfortune.t.integeration.cif.UserPasswordIntegration#setTradePassword(java.lang.String, java.lang.String)
	 */
	@Override
	public UserTradePasswordSetCifResponse setTradePassword(String memberId, String password) throws Exception {
		log.info("UserPasswordIntegrationImpl.setTradePassword.req:{memberId:" + memberId + "password:" + password + "}" );
		
		// step1：参数绑定
		Map<String,String> mapParam = new HashMap<String,String>();
		mapParam.put("memberId", memberId); // 会员Id
		mapParam.put("password", MD5.digest(password, "utf-8")); // 交易密码  MD5加密

		// step2：发送请求
		String responseContent = HttpClientUtil.sendPostRequest(cifEnterpriseSetTradePasswordUrl, mapParam);
		
		// step3：处理反馈结果
		UserTradePasswordSetCifResponse cifResp = JsonUtils.json2Object(responseContent, UserTradePasswordSetCifResponse.class);;

		log.info("UserPasswordIntegrationImpl.setTradePassword.resp:" + responseContent);
		
		return cifResp;
	}

}
