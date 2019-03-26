/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.dal.entity;

import java.util.Date;

public class AuthorizedPerson extends BaseEntity {
	
    private String memberId;

    private String name;

    private Integer certificateType;

    private String certificateNo;

    private Date certificateExpireDate;

    private String mobile;

    private Integer status;

    private Date createTime;

    private Date modifyTime;

    private String certificateFrontUrl;

    private String certificateBackUrl;

    private String authorizationUrl;

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo == null ? null : certificateNo.trim();
    }

    public Date getCertificateExpireDate() {
        return certificateExpireDate;
    }

    public void setCertificateExpireDate(Date certificateExpireDate) {
        this.certificateExpireDate = certificateExpireDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCertificateFrontUrl() {
        return certificateFrontUrl;
    }

    public void setCertificateFrontUrl(String certificateFrontUrl) {
        this.certificateFrontUrl = certificateFrontUrl == null ? null : certificateFrontUrl.trim();
    }

    public String getCertificateBackUrl() {
        return certificateBackUrl;
    }

    public void setCertificateBackUrl(String certificateBackUrl) {
        this.certificateBackUrl = certificateBackUrl == null ? null : certificateBackUrl.trim();
    }

    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    public void setAuthorizationUrl(String authorizationUrl) {
        this.authorizationUrl = authorizationUrl == null ? null : authorizationUrl.trim();
    }
}