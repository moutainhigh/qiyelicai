/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseResponse;

/**
 * ClassName: UserRegisterResponse <br/>
 * Function: 接收cif会员注册反馈对象. <br/>
 * Date: 2016年12月13日 下午6:31:50 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class UserRegisterCifResponse extends BaseResponse {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 1L;

	/** customerId 必输 */
	private String customerId;
	
	/** memberId 必输 */
	private String memberId;
	
	/** 商户号 必输 */
	private String customerNo;

	/** 操作员Id 必输 */
	private Long operatorId;
	
	public UserRegisterCifResponse() {
		super();
	}

	public UserRegisterCifResponse(String respCode) {
		super(respCode);
	}
	
	public UserRegisterCifResponse(String respCode, String resultMsg) {
		super(respCode, resultMsg);
	}

	public UserRegisterCifResponse(String respCode, String resultCode,String resultMsg) {
		super(respCode, resultCode, resultMsg);
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	
}
