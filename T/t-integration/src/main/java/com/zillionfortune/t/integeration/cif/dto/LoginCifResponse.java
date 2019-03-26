/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseResponse;

/**
 * ClassName: LoginResponse <br/>
 * Function: 企业_会员登入_响应对象. <br/>
 * Date: 2016年11月15日 下午4:30:08 <br/>
 *
 * @author kaiyun
 * @version 
 * @since JDK 1.7
 */
public class LoginCifResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 会员ID
	 * 必填
	 */
	private String memberId;
	
	/**
	 * 操作员ID
	 * 必填
	 */
	private String operatorId;
	
	/**
	 * 访问token
	 * 必填
	 */
	private String accessToken;
	
	/**
	 * 企业名称
	 */
	private String enterperseName;
	
	
	public LoginCifResponse() {
		super();
	}
	
	public LoginCifResponse(String respCode) {
		super(respCode);
	}

	public LoginCifResponse(String respCode, String resultMsg) {
		super(respCode, resultMsg);
	}
	
	public LoginCifResponse(String respCode, String resultCode, String resultMsg) {
		super(respCode, resultCode, resultMsg);
	}

	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getEnterperseName() {
		return enterperseName;
	}

	public void setEnterperseName(String enterperseName) {
		this.enterperseName = enterperseName;
	}

}
