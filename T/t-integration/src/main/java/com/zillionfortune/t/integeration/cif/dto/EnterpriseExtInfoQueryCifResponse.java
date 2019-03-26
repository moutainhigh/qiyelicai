/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseResponse;

/**
 * ClassName: EnterpriseExtInfoQueryResponse <br/>
 * Function: 企业会员扩展信息. <br/>
 * Date: 2016年11月21日 上午10:07:46 <br/>
 *
 * @author pengting
 * @version
 * @since JDK 1.7
 */
@SuppressWarnings("serial")
public class EnterpriseExtInfoQueryCifResponse extends BaseResponse {

	/**
	 * 会员ID
	 */
	private String memberId;
	
	/**
	 * 客户ID
	 */
	private String customerId;
	
	/**
     * 商户号
     */
    private String customerNo;

	/**
	 * 企业名称
	 */
    private String enterpriseName;

    /**
     * 企业证件类型
     */
	private String certificateType;
	
	/**
	 * 企业证件号码
	 */
	private String certificateNo;
	
	/**
	 * 营业执照有效期
	 */
	private String certificateExpireDate;

	/**
	 * 企业法人姓名
	 */
    private String legalPersonName;

    /**
     * 企业法人证件类型
     */
    private String legalPersonCertificateType;

    /**
     * 企业法人证件号码
     */
    private String legalPersonCertificateNo;
    
    /**
     * 法人证件有效期
     */
    private String legalPersonCertificateExpireDate;

    /**
     * 企业经营地址
     */
    private String enterpriseRegisterAddr;
    
    /**
     * postCode:邮编
     */
    private String postCode;
    
    /**
     * phoneNo:电话
     */
    private String phoneNo;
    
    /**
     * branchBankName:开户行分支行
     */
    private String branchBankName;
    
    /**
     * bankAccountNo:银行账号
     */
    private String bankAccountNo;
    
    
    
	public EnterpriseExtInfoQueryCifResponse() {
		super();
	}
	public EnterpriseExtInfoQueryCifResponse(String respCode, String resultMsg) {
		super(respCode, resultMsg);
	}

	public EnterpriseExtInfoQueryCifResponse(String respCode, String resultCode,
			String resultMsg) {
		super(respCode, resultCode, resultMsg);
	}
	

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public String getLegalPersonCertificateType() {
		return legalPersonCertificateType;
	}

	public void setLegalPersonCertificateType(String legalPersonCertificateType) {
		this.legalPersonCertificateType = legalPersonCertificateType;
	}

	public String getLegalPersonCertificateNo() {
		return legalPersonCertificateNo;
	}

	public void setLegalPersonCertificateNo(String legalPersonCertificateNo) {
		this.legalPersonCertificateNo = legalPersonCertificateNo;
	}

	public String getEnterpriseRegisterAddr() {
		return enterpriseRegisterAddr;
	}

	public void setEnterpriseRegisterAddr(String enterpriseRegisterAddr) {
		this.enterpriseRegisterAddr = enterpriseRegisterAddr;
	}

	public String getCertificateExpireDate() {
		return certificateExpireDate;
	}

	public void setCertificateExpireDate(String certificateExpireDate) {
		this.certificateExpireDate = certificateExpireDate;
	}

	public String getLegalPersonCertificateExpireDate() {
		return legalPersonCertificateExpireDate;
	}

	public void setLegalPersonCertificateExpireDate(
			String legalPersonCertificateExpireDate) {
		this.legalPersonCertificateExpireDate = legalPersonCertificateExpireDate;
	}
	public String getBranchBankName() {
		return branchBankName;
	}
	public void setBranchBankName(String branchBankName) {
		this.branchBankName = branchBankName;
	}
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
}
