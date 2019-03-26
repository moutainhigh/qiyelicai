/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.biz.authorizedperson.dto;

import com.zillionfortune.common.dto.BaseRequest;

/**
 * ClassName: AuthorizedPersonUpdateRequest <br/>
 * Function: 被授权人请求参数对象. <br/>
 * Date: 2016年12月13日 下午6:29:44 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class AuthorizedPersonUpdateRequest extends BaseRequest {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 1L;

	/** 被授权人id */
	private Long authorizedPersonId;
	
	/**  memberId  必输  */
	private String memberId;
	
	/**  name  必输  */
	private String name;
	
	/**  被授权人证件类型  必输  */
	private String certificateType;
	
	/**  被授权人证件号码  必输  */
	private String certificateNo;
	
	/**  被授权人证件有效期  必输  */
	private String certExpDate;
	
	/**  被授权人联系电话  必输  */
	private String mobile;
	
	/**  授权委托书Url */
	private String authorizationUrl;
	
	/**  被授权人证件正面URL */
	private String certificateFrontUrl;
	
	/**  被授权人证件反面URl  */
	private String certificateBackUrl;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCertExpDate() {
		return certExpDate;
	}

	public void setCertExpDate(String certExpDate) {
		this.certExpDate = certExpDate;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAuthorizationUrl() {
		return authorizationUrl;
	}

	public void setAuthorizationUrl(String authorizationUrl) {
		this.authorizationUrl = authorizationUrl;
	}

	public String getCertificateFrontUrl() {
		return certificateFrontUrl;
	}

	public void setCertificateFrontUrl(String certificateFrontUrl) {
		this.certificateFrontUrl = certificateFrontUrl;
	}

	public String getCertificateBackUrl() {
		return certificateBackUrl;
	}

	public void setCertificateBackUrl(String certificateBackUrl) {
		this.certificateBackUrl = certificateBackUrl;
	}

	public Long getAuthorizedPersonId() {
		return authorizedPersonId;
	}

	public void setAuthorizedPersonId(Long authorizedPersonId) {
		this.authorizedPersonId = authorizedPersonId;
	}
	
}
