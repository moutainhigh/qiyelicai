/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.web.controller.user.vo;

import com.zillionfortune.common.dto.BaseRequest;

/**
 * ClassName: UserTradePasswordRetrieveRequestVo <br/>
 * Function: 前端页面企业会员重置交易密码业务Request. <br/>
 * Date: 2016年12月14日 下午2:01:17 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class UserTradePasswordRetrieveRequestVo extends BaseRequest {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * memberId:会员Id.
	 */
	private String memberId;
	
	/**
	 * newPassword:新密码.
	 */
	private String newPassword;
	
	/**
	 * repeatPwd:确认新密码.
	 */
	private String repeatPwd;
	
	/**
	 * accessToken:访问token.
	 */
	private String accessToken;

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
	 * 获取newPassword的值.
	 *
	 * @return newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * 设置newPassword的值.
	 *
	 * @param  newPassword
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * 获取accessToken的值.
	 *
	 * @return accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * 设置accessToken的值.
	 *
	 * @param  accessToken
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * 获取repeatPwd的值.
	 *
	 * @return repeatPwd
	 */
	public String getRepeatPwd() {
		return repeatPwd;
	}

	/**
	 * 设置repeatPwd的值.
	 *
	 * @param  repeatPwd
	 */
	public void setRepeatPwd(String repeatPwd) {
		this.repeatPwd = repeatPwd;
	}
	
}
