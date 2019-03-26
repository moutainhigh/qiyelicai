/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseResponse;

/**
 * ClassName: UserTradePasswordVerifyCifResponse <br/>
 * Function: 接收cif企业会员验证交易密码Response. <br/>
 * Date: 2016年12月14日 下午3:29:53 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class UserTradePasswordVerifyCifResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	/**
	 * memberId:会员Id.
	 */
	private String memberId;

	public UserTradePasswordVerifyCifResponse() {
		super();
	}

	public UserTradePasswordVerifyCifResponse(String respCode,String resultCode, String resultMsg) {
		super(respCode, resultCode, resultMsg);
	}

	public UserTradePasswordVerifyCifResponse(String respCode,String resultMsg) {
		super(respCode, resultMsg);
	}

	public UserTradePasswordVerifyCifResponse(String respCode) {
		super(respCode);
	}

	/**
	 * 获取memberId的值.
	 *
	 * @return memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * 设置memberId的值.
	 *
	 * @param  memberId
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}
