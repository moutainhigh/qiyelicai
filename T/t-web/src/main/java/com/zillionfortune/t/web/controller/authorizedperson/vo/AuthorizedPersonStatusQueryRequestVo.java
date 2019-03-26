/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.web.controller.authorizedperson.vo;

import com.zillionfortune.common.dto.BaseRequest;

/**
 * ClassName: AuthorizedPersonQueryRequestVo <br/>
 * Function: 查询被授权人请求参数对象（审批状态）. <br/>
 * Date: 2016年12月13日 下午6:29:44 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class AuthorizedPersonStatusQueryRequestVo extends BaseRequest {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 1L;

	/** 会员Id */
	private String memberId;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
}
