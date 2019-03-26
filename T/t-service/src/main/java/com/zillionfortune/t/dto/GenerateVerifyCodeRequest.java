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
 * Function: 生成图片验证码_请求对象. <br/>
 * Date: 2016年12月13日 上午9:49:27 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class GenerateVerifyCodeRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 验证码token，必输
	 */
	private String codeAuth;
	
	/**
	 * 图片验证码的宽度
	 */
	private int width=100;
	
	/**
	 * 图片验证码的高度
	 */
	private int height=40;
	

	public GenerateVerifyCodeRequest() {
		super();
	}

	public GenerateVerifyCodeRequest(int width, int height, String codeAuth) {
		super();
		this.width = width;
		this.height = height;
		this.codeAuth = codeAuth;
	}


	public void setCodeAuth(String codeAuth) {
		this.codeAuth = codeAuth;
	}


	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getCodeAuth() {
		return codeAuth;
	}
	
}
