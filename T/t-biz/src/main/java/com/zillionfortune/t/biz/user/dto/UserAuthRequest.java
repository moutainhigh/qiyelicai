/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.user.dto;

import com.zillionfortune.common.dto.BaseRequest;

/**
 * ClassName: UserAuthRequestVo <br/>
 * Function: 企业会员身份验证业务用Request. <br/>
 * Date: 2016年12月20日 上午10:48:09 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class UserAuthRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * memberId:会员Id.
	 */
	private String memberId;
	
	/**
	 * certificateNo:营业执照号/统一社会信用代码号.
	 */
	private String certificateNo;
	
	/**
	 * legalPersonCertificateNo:法定代表人/负责人身份证号.
	 */
	private String legalPersonCertificateNo;

	/**
	 * 获取memberId的值.
	 *
	 * @return memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * 设置memberId的值.
	 *
	 * @param  memberId
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * 获取certificateNo的值.
	 *
	 * @return certificateNo
	 */
	public String getCertificateNo() {
		return certificateNo;
	}

	/**
	 * 设置certificateNo的值.
	 *
	 * @param  certificateNo
	 */
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	/**
	 * 获取legalPersonCertificateNo的值.
	 *
	 * @return legalPersonCertificateNo
	 */
	public String getLegalPersonCertificateNo() {
		return legalPersonCertificateNo;
	}

	/**
	 * 设置legalPersonCertificateNo的值.
	 *
	 * @param  legalPersonCertificateNo
	 */
	public void setLegalPersonCertificateNo(String legalPersonCertificateNo) {
		this.legalPersonCertificateNo = legalPersonCertificateNo;
	}
	
}
