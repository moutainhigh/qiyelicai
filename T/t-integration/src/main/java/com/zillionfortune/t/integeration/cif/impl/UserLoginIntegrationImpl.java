/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zillionfortune.t.common.util.BeanConvertUtil;
import com.zillionfortune.t.common.util.HttpClientUtil;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.common.util.MD5;
import com.zillionfortune.t.integeration.cif.UserLoginIntegration;
import com.zillionfortune.t.integeration.cif.dto.LoginAuthCifResponse;
import com.zillionfortune.t.integeration.cif.dto.LoginAuthRequest;
import com.zillionfortune.t.integeration.cif.dto.LoginCifResponse;
import com.zillionfortune.t.integeration.cif.dto.LoginOutCifResponse;
import com.zillionfortune.t.integeration.cif.dto.LoginOutRequest;
import com.zillionfortune.t.integeration.cif.dto.LoginRequest;

/**
 * ClassName: UserLoginServiceFacadeImpl <br/>
 * Function: httpclient_企业_会员登录接口_实现. <br/>
 * Date: 2016年11月15日 下午5:01:18 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version
 * @since JDK 1.7
 */
@Service
public class UserLoginIntegrationImpl implements UserLoginIntegration {
	
	@Value("${cif.enterprise.login.url}")
	private String loginUrl;
	
	@Value("${cif.enterprise.auth.url}")
	private String authUrl;
	
	@Value("${cif.enterprise.loginout.url}")
	private String loginoutUrl;

	@Override
	public LoginCifResponse login(LoginRequest req) throws Exception {
		LoginCifResponse loginResp = null;
		
		req.setPassword(MD5.digest(req.getPassword(),"utf-8"));
		// 请求参数
		Map<String, String> paramMap = BeanConvertUtil.beanToMapWithoutNullValueMap(req);
		// 获取AccessToken
		String loginResponseContent;
		loginResponseContent = HttpClientUtil.sendPostRequest(loginUrl, paramMap);
		loginResp = JsonUtils.json2Object(loginResponseContent, LoginCifResponse.class);

		return loginResp;
	}
	
	@Override
	public LoginAuthCifResponse auth(LoginAuthRequest req) throws Exception {
		LoginAuthCifResponse authResp = null;
		// 请求参数
		Map<String, String> paramMap = BeanConvertUtil.beanToMapWithoutNullValueMap(req);
		// 鉴权AccessToken
		String authResponseContent = HttpClientUtil.sendPostRequest(authUrl, paramMap);
		authResp = JsonUtils.json2Object(authResponseContent, LoginAuthCifResponse.class);
		
		return authResp;
	}

	@Override
	public LoginOutCifResponse loginout(LoginOutRequest req) throws Exception {
		LoginOutCifResponse logoutResp = null;
			// 请求参数
			Map<String, String> paramMap = BeanConvertUtil.beanToMapWithoutNullValueMap(req);
			// 获取AccessToken
			String logoutResponseContent = HttpClientUtil.sendPostRequest(loginoutUrl, paramMap);
			logoutResp = JsonUtils.json2Object(logoutResponseContent, LoginOutCifResponse.class);
			
		return logoutResp;
	}


}
