/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.order.dto;

import java.math.BigDecimal;

import com.zillionfortune.common.dto.BaseRequest;

/**
 * ClassName: CreateOrderRequest <br/>
 * Function: 创建订单请求参数. <br/>
 * Date: 2016年12月22日 上午9:28:15 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public class CreateOrderRequest extends BaseRequest {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * memberId:会员Id
	 */
	private String memberId;

	/**
	 * productCode:	产品编号
	 */
	private String productCode;
	
	/**
	 * amount:	购买金额
	 */
	private BigDecimal amount;
	
	/**
	 * accountsManagerTel:客户经理手机号
	 */
	private String accountsManagerTel;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAccountsManagerTel() {
		return accountsManagerTel;
	}

	public void setAccountsManagerTel(String accountsManagerTel) {
		this.accountsManagerTel = accountsManagerTel;
	}

}
