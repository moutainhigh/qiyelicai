/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseResponse;

/**
 * ClassName: EnterpriseLoginOutResponse <br/>
 * Function: 企业_会员登出_响应对象. <br/>
 * Date: 2016年11月21日 下午7:02:04 <br/>
 *
 * @author kaiyun
 * @version 
 * @since JDK 1.7
 */
public class LoginOutCifResponse extends BaseResponse {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 会员ID
	 * 必输
	 */
	private String memberId;
	
	/**
	 * 操作员id
	 * 必输
	 */
	private String operatorId;
	
	
	public LoginOutCifResponse() {
		super();
	}
	
	public LoginOutCifResponse(String respCode) {
		super(respCode);
	}

	public LoginOutCifResponse(String respCode, String resultMsg) {
		super(respCode, resultMsg);
	}
	
	public LoginOutCifResponse(String respCode, String resultCode, String resultMsg) {
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
	
	

}
