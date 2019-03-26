/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.web.controller.user.vo;

import com.zillionfortune.common.dto.BaseRequest;


/**
 * ClassName: UserImproveInfo <br/>
 * Function: 用户完善资料 对象. <br/>
 * Date: 2016年12月15日 下午2:14:29 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public class UserImproveInfoRequestVo extends BaseRequest {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * memberId: memberId
	 */
	private String memberId;
	/**
	 * tradePassword: 交易密码 必输 
	 */
	private String tradePassword;
	/**
	 * repeatPwd: 确认交易密码 必输
	 */
	private String repeatPwd; 
	/**
	 * bankAccountName: 企业银行账户名称 必输 
	 */
	private String bankAccountName;
	/**
	 * bankAccountNo: 企业银行账号 必输 
	 */
	private String bankAccountNo;
	/**
	 * repeatBankAccountNo: 确认企业银行账户 必输 
	 */
	private String repeatBankAccountNo;
	/**
	 * bankAccount: 开户行 必输 
	 */
	private String bankAccount;
	/**
	 * bankAccountRegion: 开户行所在地区 必输
	 */
	private String bankAccountRegion; 
	/**
	 * enterpriseType: 企业类型 必输 
	 */
	private Integer enterpriseType;
	/**
	 * industry: 所属行业 必输 
	 */
	private Integer industry;
	/**
	 * authorizedPersonName: 被授权人姓名 必输 
	 */
	private String authorizedPersonName;
	/**
	 * authorizedPersonCertificateNo: 被授权人证件号码 必输 
	 */
	private String authorizedPersonCertificateNo;
	/**
	 * authorizedPersonCertificateType: 被授权人证件类型 必输 
	 */
	private Integer authorizedPersonCertificateType;
	/**
	 * authorizedPersonCertExpDate: 被授权人证件有效期 必输 
	 */
	private String authorizedPersonCertExpDate;
	/**
	 * authorizedPersonMobile: 被授权人联系电话 必输 
	 */
	private String authorizedPersonMobile;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getTradePassword() {
		return tradePassword;
	}
	public void setTradePassword(String tradePassword) {
		this.tradePassword = tradePassword;
	}
	public String getRepeatPwd() {
		return repeatPwd;
	}
	public void setRepeatPwd(String repeatPwd) {
		this.repeatPwd = repeatPwd;
	}
	public String getBankAccountName() {
		return bankAccountName;
	}
	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	public String getRepeatBankAccountNo() {
		return repeatBankAccountNo;
	}
	public void setRepeatBankAccountNo(String repeatBankAccountNo) {
		this.repeatBankAccountNo = repeatBankAccountNo;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getBankAccountRegion() {
		return bankAccountRegion;
	}
	public void setBankAccountRegion(String bankAccountRegion) {
		this.bankAccountRegion = bankAccountRegion;
	}
	public Integer getEnterpriseType() {
		return enterpriseType;
	}
	public void setEnterpriseType(Integer enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	public Integer getIndustry() {
		return industry;
	}
	public void setIndustry(Integer industry) {
		this.industry = industry;
	}
	public String getAuthorizedPersonName() {
		return authorizedPersonName;
	}
	public void setAuthorizedPersonName(String authorizedPersonName) {
		this.authorizedPersonName = authorizedPersonName;
	}
	public String getAuthorizedPersonCertificateNo() {
		return authorizedPersonCertificateNo;
	}
	public void setAuthorizedPersonCertificateNo(
			String authorizedPersonCertificateNo) {
		this.authorizedPersonCertificateNo = authorizedPersonCertificateNo;
	}
	public Integer getAuthorizedPersonCertificateType() {
		return authorizedPersonCertificateType;
	}
	public void setAuthorizedPersonCertificateType(
			Integer authorizedPersonCertificateType) {
		this.authorizedPersonCertificateType = authorizedPersonCertificateType;
	}
	public String getAuthorizedPersonCertExpDate() {
		return authorizedPersonCertExpDate;
	}
	public void setAuthorizedPersonCertExpDate(String authorizedPersonCertExpDate) {
		this.authorizedPersonCertExpDate = authorizedPersonCertExpDate;
	}
	public String getAuthorizedPersonMobile() {
		return authorizedPersonMobile;
	}
	public void setAuthorizedPersonMobile(String authorizedPersonMobile) {
		this.authorizedPersonMobile = authorizedPersonMobile;
	}
	
}
