/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.user;

import java.io.OutputStream;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.dto.CheckVerifyCodeRequest;
import com.zillionfortune.t.dto.GenerateVerifyCodeRequest;
import com.zillionfortune.t.dto.LoginCodeRequest;
import com.zillionfortune.t.integeration.cif.dto.LoginAuthRequest;
import com.zillionfortune.t.integeration.cif.dto.LoginOutRequest;
import com.zillionfortune.t.integeration.cif.dto.LoginRequest;


/**
 * ClassName: UserLoginServiceFacade <br/>
 * Function: 企业会员登录接口. <br/>
 * Date: 2016年11月15日 下午4:30:53 <br/>
 *
 * @author kaiyun
 * @version 
 * @since JDK 1.7
 */
public interface UserLoginBiz {
	
	/**
	 * login:企业理财登录. <br/>
	 *
	 * @param req LoginRequest
	 * @return	BaseWebResponse
	 */
	public BaseWebResponse login(LoginRequest req);
	 
	/**
	 * login:企业理财登录鉴权. <br/>
	 *
	 * @param req LoginAuthRequest
	 * @return BaseWebResponse
	 * @throws Exception 
	 */
	public BaseWebResponse auth(LoginAuthRequest req) ;
	
	/**
	 * loginout:企业理财登出. <br/>
	 *
	 * @param req LoginOutRequest
	 * @return BaseWebResponse
	 */
	public BaseWebResponse loginout(LoginOutRequest req);
	
	/**
	 * getCode:获取图片验证码Token. <br/>
	 *
	 * @param verifySize 验证码长度
	 * @return BaseWebResponse
	 */
	public BaseWebResponse getLoginCode(LoginCodeRequest req);
	
	/**
	 * getCodeImage:获取图片验证码图片. <br/>
	 *
	 * @param req GenerateVerifyCodeRequest
	 * @param os OutputStream
	 * @return BaseWebResponse
	 */
	public void getLoginCodeImage(GenerateVerifyCodeRequest req, OutputStream os);
	
	/**
	 * checkCode:校验图片验证码. <br/>
	 *
	 * @param req CheckVerifyCodeRequest
	 * @return BaseWebResponse
	 */
	public BaseWebResponse checkLoginCode(CheckVerifyCodeRequest req);
	
}