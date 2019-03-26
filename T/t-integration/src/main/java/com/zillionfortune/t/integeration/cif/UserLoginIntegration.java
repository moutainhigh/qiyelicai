/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif;

import com.zillionfortune.t.integeration.cif.dto.LoginAuthCifResponse;
import com.zillionfortune.t.integeration.cif.dto.LoginAuthRequest;
import com.zillionfortune.t.integeration.cif.dto.LoginCifResponse;
import com.zillionfortune.t.integeration.cif.dto.LoginOutCifResponse;
import com.zillionfortune.t.integeration.cif.dto.LoginOutRequest;
import com.zillionfortune.t.integeration.cif.dto.LoginRequest;


/**
 * ClassName: UserLoginServiceFacade <br/>
 * Function: httpclient_企业会员登录接口. <br/>
 * Date: 2016年11月15日 下午4:30:53 <br/>
 *
 * @author kaiyun
 * @version 
 * @since JDK 1.7
 */
public interface UserLoginIntegration {
	
	/**
	 * login:企业理财登录. <br/>
	 *
	 * @param req LoginRequest
	 * @return LoginCifResponse
	 * @throws Exception 
	 */
	public LoginCifResponse login(LoginRequest req) throws Exception;
	
	/**
	 * login:企业理财登录鉴权. <br/>
	 *
	 * @param req LoginAuthRequest
	 * @return LoginAuthCifResponse
	 * @throws Exception 
	 */
	public LoginAuthCifResponse auth(LoginAuthRequest req) throws Exception;
	
	/**
	 * loginout:企业理财登出. <br/>
	 *
	 * @param req LoginOutRequest
	 * @return LoginOutCifResponse
	 * @throws Exception 
	 */
	public LoginOutCifResponse loginout(LoginOutRequest req) throws Exception;
	
	
	

}
