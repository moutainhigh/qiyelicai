/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.dto;

import com.zillionfortune.common.dto.BaseResponse;


/**
 * ClassName: GenerateVerifyCodeResponse <br/>
 * Function: 生成图片验证码_响应对象. <br/>
 * Date: 2016年12月13日 上午9:57:11 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class GenerateVerifyCodeResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	public GenerateVerifyCodeResponse(String respCode, String resultCode, String resultMsg) {
		super(respCode, resultCode, resultMsg);
	}

	public GenerateVerifyCodeResponse(String respCode, String resultMsg) {
		super(respCode, resultMsg);
	}
	
}
