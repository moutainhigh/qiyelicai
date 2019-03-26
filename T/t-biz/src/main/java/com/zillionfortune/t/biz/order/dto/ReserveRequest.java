/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.order.dto;

import java.math.BigDecimal;

import com.zillionfortune.common.dto.BaseRequest;

/**
 * ClassName: ReserveRequest <br/>
 * Function: 前端页面预约订购产品Request. <br/>
 * Date: 2016年12月20日 上午9:45:25 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public class ReserveRequest extends BaseRequest{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * memberId:会员Id
	 */
	private String memberId;
	/**
	 * productCode:	产品编码
	 */
	private String productCode;
	/**
	 * reserveAmt:预约金额
	 */
	private BigDecimal reserveAmt;
	/**
	 * recommendedMobile:	推荐客户经理手机号
	 */
	private String  recommendedMobile;
	
	/**
	 * mobile:被授权人手机号 用于接受验证码
	 */
	private String authorizedPersonMobile;
	/**
	 * tradePwd:	交易密码
	 */
	private String tradePwd;
	/**
	 * smsCode:	（被授权人手机）验证码
	 */
	private String smsCode;
	
	/**
	 * operatorMobile:操作员手机号
	 */
	private String operatorMobile;
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
	public BigDecimal getReserveAmt() {
		return reserveAmt;
	}
	public void setReserveAmt(BigDecimal reserveAmt) {
		this.reserveAmt = reserveAmt;
	}
	public String getRecommendedMobile() {
		return recommendedMobile;
	}
	public void setRecommendedMobile(String recommendedMobile) {
		this.recommendedMobile = recommendedMobile;
	}
	public String getTradePwd() {
		return tradePwd;
	}
	public void setTradePwd(String tradePwd) {
		this.tradePwd = tradePwd;
	}
	public String getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	public String getAuthorizedPersonMobile() {
		return authorizedPersonMobile;
	}
	public void setAuthorizedPersonMobile(String authorizedPersonMobile) {
		this.authorizedPersonMobile = authorizedPersonMobile;
	}
	public String getOperatorMobile() {
		return operatorMobile;
	}
	public void setOperatorMobile(String operatorMobile) {
		this.operatorMobile = operatorMobile;
	}
}
