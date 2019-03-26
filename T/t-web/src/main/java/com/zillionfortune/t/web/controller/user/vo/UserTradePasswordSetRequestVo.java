/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.web.controller.user.vo;

import com.zillionfortune.common.dto.BaseRequest;

/**
 * ClassName: UserTradePasswordSetRequestVo <br/>
 * Function: 前端页面企业会员设置交易密码业务Request. <br/>
 * Date: 2016年12月14日 下午2:01:17 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class UserTradePasswordSetRequestVo extends BaseRequest {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * memberId:会员Id.
	 */
	private String memberId;
	
	/**
	 * password:交易密码.
	 */
	private String password;
	
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
	 * 获取password的值.
	 *
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置password的值.
	 *
	 * @param  password
	 */
	public void setPassword(String password) {
		this.password = password;
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
