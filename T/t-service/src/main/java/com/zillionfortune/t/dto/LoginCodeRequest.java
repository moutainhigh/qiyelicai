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
public class LoginCodeRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 验证码token，必输
	 */
	private Integer verifySize;
	
	

	public LoginCodeRequest() {
		super();
	}



	public Integer getVerifySize() {
		return verifySize;
	}



	public void setVerifySize(Integer verifySize) {
		this.verifySize = verifySize;
	}



}
