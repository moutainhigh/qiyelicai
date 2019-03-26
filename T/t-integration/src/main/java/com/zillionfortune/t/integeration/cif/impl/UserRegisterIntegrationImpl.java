/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
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
import com.zillionfortune.t.common.util.BeanConvertUtil;
import com.zillionfortune.t.common.util.HttpClientUtil;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.common.util.MD5;
import com.zillionfortune.t.integeration.cif.UserRegisterIntegration;
import com.zillionfortune.t.integeration.cif.dto.CheckUserNameRegisterCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserCheckExistsCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserCheckRequest;
import com.zillionfortune.t.integeration.cif.dto.UserInfoUpdateCifRequest;
import com.zillionfortune.t.integeration.cif.dto.UserInfoUpdateCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserRegisterCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserRegisterRequest;

/**
 * ClassName: UserRegisterIntegrationImpl <br/>
 * Function: 会员注册服务. <br/>
 * Date: 2016年12月14日 下午1:45:13 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class UserRegisterIntegrationImpl implements UserRegisterIntegration{

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${cif.enterprise.register.url}")
	private String cifEnterpriceRegisterUrl;
	
	@Value("${cif.enterprise.update.url}")
	private String cifEnterpriceInfoUpdateUrl;
	
	@Value("${cif.enterprise.checkusernameregister.url}")
	private String cifEnterpriceCheckUserNameUrl;
	
	@Value("${cif.enterprise.checkcerttypeandnoexists.url}")
	private String cifCheckCertTypeAndNoExistsUrl;
	
	/**
	 * 企业用户注册.
	 * @throws Exception 
	 * @see com.zillionfortune.t.integeration.cif.UserRegisterIntegration#register(com.zillionfortune.t.integeration.cif.dto.UserRegisterRequest)
	 */
	@Override
	public UserRegisterCifResponse register(UserRegisterRequest req) throws Exception {
		
		log.info("UserRegisterIntegrationImpl.register.req:" + JSON.toJSONString(req));

		//1.===参数绑定
		Map<String,String> mapParam = new HashMap<String,String>();
		mapParam.put("mobile", req.getMobile());//手机号
		mapParam.put("password", MD5.digest(req.getPassword(), "utf-8"));//登录密码  MD5加密
		mapParam.put("certificateType", req.getCertificateType());//企业证件类型
		mapParam.put("certificateNo", req.getCertificateNo());//企业证件号码
		mapParam.put("certExpDate", req.getCertExpDate());//证件有效期
		mapParam.put("enterpriseName", req.getEnterpriseName());//企业名称
		mapParam.put("postCode", req.getPostCode());
		mapParam.put("legalPersonName", req.getLegalPersonName());//法人姓名
		mapParam.put("legalPersonCertificateType", req.getLegalPersonCertificateType());//法人证件类型
		mapParam.put("legalPersonCertificateNo", req.getLegalPersonCertificateNo());//法人证件号码
		mapParam.put("legalPersonCertExpDate", req.getLegalPersonCertExpDate());//法人证件有效期
		mapParam.put("registerAddress", req.getRegisterAddress());//企业注册地址
		mapParam.put("phone", req.getPhone());//联系电话

		//2.===发送请求
		String registerResponseContent = HttpClientUtil.sendPostRequest(cifEnterpriceRegisterUrl, mapParam);
		
		//3.===处理反馈结果
		UserRegisterCifResponse cifResp = JsonUtils.json2Object(registerResponseContent, UserRegisterCifResponse.class);;

		log.info("UserRegisterIntegrationImpl.register.resp:" + registerResponseContent);
		
		return cifResp;
	}
	
	/**
	 * 企业用户信息更新
	 * @see com.zillionfortune.t.integeration.cif.UserRegisterIntegration#enterpriseInfoUpdate(com.zillionfortune.t.integeration.cif.dto.UserInfoUpdateCifRequest)
	 */
	@Override
	public UserInfoUpdateCifResponse enterpriseInfoUpdate(UserInfoUpdateCifRequest req) throws Exception {
		log.info("UserRegisterIntegrationImpl.enterpriseInfoUpdate.req:" + JSON.toJSONString(req));

		//1.===参数绑定
		Map<String,String> mapParam = BeanConvertUtil.beanToMapWithoutNullValueMap(req);

		//2.===发送请求
		String registerResponseContent = HttpClientUtil.sendPostRequest(cifEnterpriceInfoUpdateUrl, mapParam);
		
		//3.===处理反馈结果
		UserInfoUpdateCifResponse cifResp = JsonUtils.json2Object(registerResponseContent, UserInfoUpdateCifResponse.class);;

		log.info("UserRegisterIntegrationImpl.enterpriseInfoUpdate.resp:" + registerResponseContent);
		
		return cifResp;
	}

	/**
	 * 验证登录名是否注册过.
	 * @see com.zillionfortune.t.integeration.cif.UserRegisterIntegration#CheckUserNameRegister(java.lang.String)
	 */
	@Override
	public CheckUserNameRegisterCifResponse checkUserNameRegister(String mobile) throws Exception {

		log.info("UserRegisterIntegrationImpl.checkUserNameRegister.req:" + "{mobile:"+mobile+"}");

		//1.===参数绑定
		Map<String,String> mapParam = new HashMap<String,String>();
		mapParam.put("userName", mobile);
		
		//2.===发送请求
		String cifResponseContent = HttpClientUtil.sendPostRequest(cifEnterpriceCheckUserNameUrl, mapParam);
		
		//3.===处理反馈结果
		CheckUserNameRegisterCifResponse cifResp = JsonUtils.json2Object(cifResponseContent, CheckUserNameRegisterCifResponse.class);;

		log.info("UserRegisterIntegrationImpl.checkUserNameRegister.resp:" + cifResponseContent);
		
		return cifResp;
	
	}

	/**
	 * 企业注册根据证件类型证件号码校验企业是否存在.
	 * @see com.zillionfortune.t.integeration.cif.UserRegisterIntegration#checkEnterpriseExists(com.zillionfortune.t.integeration.cif.dto.UserCheckRequest)
	 */
	@Override
	public UserCheckExistsCifResponse checkEnterpriseExists(UserCheckRequest req) throws Exception {

		log.info("UserRegisterIntegrationImpl.checkEnterpriseExists.req:" + JSON.toJSONString(req));

		//1.===参数绑定
		Map<String, String> paramMap = BeanConvertUtil.beanToMapWithoutNullValueMap(req);
		
		//2.===发送请求
		String cifResponseContent = HttpClientUtil.sendPostRequest(cifCheckCertTypeAndNoExistsUrl, paramMap);
		
		//3.===处理反馈结果
		UserCheckExistsCifResponse cifResp = JsonUtils.json2Object(cifResponseContent, UserCheckExistsCifResponse.class);;

		log.info("UserRegisterIntegrationImpl.checkEnterpriseExists.resp:" + cifResponseContent);
		
		return cifResp;
	}

}
