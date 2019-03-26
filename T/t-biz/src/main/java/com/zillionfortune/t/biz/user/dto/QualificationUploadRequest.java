/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.user.dto;

import com.zillionfortune.common.dto.BaseRequest;


/**
 * ClassName: QualificationUploadRequest <br/>
 * Function: 企业资质更新Request. <br/>
 * Date: 2016年12月20日 上午11:34:07 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public class QualificationUploadRequest extends BaseRequest {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 会员ID
	 * 必输
	 */
	private String memberId;
	
	//###########################################企业基本信息####################################
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
	
	
	//###########################################企业资质信息###############################################
	
	/**
	 * businessLicenceUrl:营业执照下载地址
	 */
	private String businessLicenceUrl;

    /**
     * organizationCodeCertificateUrl:组织机构代码证下载地址
     */
    private String organizationCodeCertificateUrl;

    /**
     * taxRegistrationCertificateUrl:税务登记证（国税）下载地址
     */
    private String taxRegistrationCertificateUrl;

    /**
     * taxRegistrationCertificateLocalUrl:税务登记证（地税）下载地址
     */
    private String taxRegistrationCertificateLocalUrl;

    /**
     * legalPersonCertificateFrontUrl:法人代表身份证正面下载地址
     */
    private String legalPersonCertificateFrontUrl;

    /**
     * legalPersonCertificateBackUrl:法人代表身份证反面下载地址
     */
    private String legalPersonCertificateBackUrl;

    /**
     * accountOpeningLicenseUrl:开户许可证下载地址
     */
    private String accountOpeningLicenseUrl;

    /**
     * powerOfAttorneyUrl:法定代表人／负责人授权委托书下载地址
     */
    private String powerOfAttorneyUrl;

    /**
     * serviceApplicationUrl:企业服务申请书下载地址
     */
    private String serviceApplicationUrl;

    /**
     * authorizedPersonCertificateFrontUrl:被授权人身份证
     */
    private String authorizedPersonCertificateFrontUrl;
    
    /**
     * authorizedPersonCertificateBackUrl:被授权人身份证反面
     */
    private String authorizedPersonCertificateBackUrl;
    
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBusinessLicenceUrl() {
		return businessLicenceUrl;
	}

	public void setBusinessLicenceUrl(String businessLicenceUrl) {
		this.businessLicenceUrl = businessLicenceUrl;
	}

	public String getOrganizationCodeCertificateUrl() {
		return organizationCodeCertificateUrl;
	}

	public void setOrganizationCodeCertificateUrl(
			String organizationCodeCertificateUrl) {
		this.organizationCodeCertificateUrl = organizationCodeCertificateUrl;
	}

	public String getTaxRegistrationCertificateUrl() {
		return taxRegistrationCertificateUrl;
	}

	public void setTaxRegistrationCertificateUrl(
			String taxRegistrationCertificateUrl) {
		this.taxRegistrationCertificateUrl = taxRegistrationCertificateUrl;
	}

	public String getTaxRegistrationCertificateLocalUrl() {
		return taxRegistrationCertificateLocalUrl;
	}

	public void setTaxRegistrationCertificateLocalUrl(
			String taxRegistrationCertificateLocalUrl) {
		this.taxRegistrationCertificateLocalUrl = taxRegistrationCertificateLocalUrl;
	}

	public String getLegalPersonCertificateFrontUrl() {
		return legalPersonCertificateFrontUrl;
	}

	public void setLegalPersonCertificateFrontUrl(
			String legalPersonCertificateFrontUrl) {
		this.legalPersonCertificateFrontUrl = legalPersonCertificateFrontUrl;
	}

	public String getLegalPersonCertificateBackUrl() {
		return legalPersonCertificateBackUrl;
	}

	public void setLegalPersonCertificateBackUrl(
			String legalPersonCertificateBackUrl) {
		this.legalPersonCertificateBackUrl = legalPersonCertificateBackUrl;
	}

	public String getAccountOpeningLicenseUrl() {
		return accountOpeningLicenseUrl;
	}

	public void setAccountOpeningLicenseUrl(String accountOpeningLicenseUrl) {
		this.accountOpeningLicenseUrl = accountOpeningLicenseUrl;
	}

	public String getPowerOfAttorneyUrl() {
		return powerOfAttorneyUrl;
	}

	public void setPowerOfAttorneyUrl(String powerOfAttorneyUrl) {
		this.powerOfAttorneyUrl = powerOfAttorneyUrl;
	}

	public String getServiceApplicationUrl() {
		return serviceApplicationUrl;
	}

	public void setServiceApplicationUrl(String serviceApplicationUrl) {
		this.serviceApplicationUrl = serviceApplicationUrl;
	}

	public String getAuthorizedPersonCertificateFrontUrl() {
		return authorizedPersonCertificateFrontUrl;
	}

	public void setAuthorizedPersonCertificateFrontUrl(
			String authorizedPersonCertificateFrontUrl) {
		this.authorizedPersonCertificateFrontUrl = authorizedPersonCertificateFrontUrl;
	}

	public String getAuthorizedPersonCertificateBackUrl() {
		return authorizedPersonCertificateBackUrl;
	}

	public void setAuthorizedPersonCertificateBackUrl(
			String authorizedPersonCertificateBackUrl) {
		this.authorizedPersonCertificateBackUrl = authorizedPersonCertificateBackUrl;
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
