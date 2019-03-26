/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseRequest;

/**
 * ClassName: EnterpriseExtInfoQueryRequest <br/>
 * Function: 企业信息更新_请求参数对象. <br/>
 * Date: 2016年12月19日 下午7:09:40 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class EnterpriseExtInfoUpdateRequest extends BaseRequest {
	
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 会员ID，必输
	 */
	private String memberId;
	
	/**
	 * 企业名称
	 */
	private String enterpriseName;
	
	/**
	 * 营业执照类型,必输
	 */
	private String certificateType;
	
	/**
	 * 营业执照号,必输
	 */
	private String certificateNo;
	
	/**
	 * 营业执照有效期
	 */
	private String certExpDate;
	
	/**
	 * 法定代表人姓名
	 */
	private String legalPersonName;
	
	/**
	 * 法定代表人证件类型
	 */
	private String legalPersonCertificateType;
	
	/**
	 * 法定代表人证件号码
	 */
	private String legalPersonCertificateNo;
	
	/**
	 * 法定代表人证件有效期
	 */
	private String legalPersonCertExpDate;
	
	/**
	 * 企业通讯地址
	 */
	private String registerAddress;
	
	/**
	 * 邮政编码
	 */
	private String postCode;
	
	/**
	 * 联系电话
	 */
	private String phone;
	
	
	
	public EnterpriseExtInfoUpdateRequest() {
		super();
	}

	public EnterpriseExtInfoUpdateRequest(String memberId) {
		super();
		this.memberId = memberId;
	}
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
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

	public String getCertExpDate() {
		return certExpDate;
	}

	public void setCertExpDate(String certExpDate) {
		this.certExpDate = certExpDate;
	}

	public String getLegalPersonCertExpDate() {
		return legalPersonCertExpDate;
	}

	public void setLegalPersonCertExpDate(String legalPersonCertExpDate) {
		this.legalPersonCertExpDate = legalPersonCertExpDate;
	}

	public String getRegisterAddress() {
		return registerAddress;
	}

	public void setRegisterAddress(String registerAddress) {
		this.registerAddress = registerAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
