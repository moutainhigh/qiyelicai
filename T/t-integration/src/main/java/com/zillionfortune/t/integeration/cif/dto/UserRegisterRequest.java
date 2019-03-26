/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseRequest;

/**
 * ClassName: UserRegisterRequest <br/>
 * Function: 用户注册请求参数对象. <br/>
 * Date: 2016年12月13日 下午6:29:44 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class UserRegisterRequest extends BaseRequest {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 1L;

	/**  手机号  必输  */
	private String mobile;
	
	/**  验证吗  必输  */
	private String verificationCode;
	
	/**  登录密码  必输  */
	private String password;
	
	/**  确认登录密码  必输  */
	private String repeatPwd;
	
	/**  企业名称  必输  */
	private String enterpriseName;
	
	/**  企业证件类型  必输  */
	private String certificateType;

	/**  企业证件号码  必输  */
	private String certificateNo;
	
	/**  证件有效期   */
	private String certExpDate;
	
	/**  法人姓名   */
	private String legalPersonName;
	
	/**  法人证件类型   */
	private String legalPersonCertificateType;
	
	/**  法人证件号码   */
	private String legalPersonCertificateNo;
	
	/**  法人证件有效期   */
	private String legalPersonCertExpDate;
	
	/**  企业注册地址   */
	private String registerAddress;
	
	/**  联系电话  */
	private String phone;

	/** 企业邮政编码   */
	private String postCode;
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPwd() {
		return repeatPwd;
	}

	public void setRepeatPwd(String repeatPwd) {
		this.repeatPwd = repeatPwd;
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

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}	
	
}
