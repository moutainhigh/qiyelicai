/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.dto;

import com.zillionfortune.common.dto.BaseRequest;


/**
 * ClassName: GenerateVerifyCodeRequest <br/>
 * Function: 校验图片验证码_请求对象. <br/>
 * Date: 2016年12月13日 上午9:49:27 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class CheckVerifyCodeRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 验证码
	 */
	String verifyCode;
	
	/**
	 * 验证码token，必输
	 */
	private String codeAuth;
	
	
	public CheckVerifyCodeRequest() {
		super();
	}
	
	public CheckVerifyCodeRequest(String verifyCode, String codeAuth) {
		super();
		this.verifyCode = verifyCode;
		this.codeAuth = codeAuth;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getCodeAuth() {
		return codeAuth;
	}

	public void setCodeAuth(String codeAuth) {
		this.codeAuth = codeAuth;
	}
	
	
	
}
