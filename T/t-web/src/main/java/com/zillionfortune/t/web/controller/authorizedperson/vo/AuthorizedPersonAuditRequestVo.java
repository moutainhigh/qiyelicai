/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.web.controller.authorizedperson.vo;

import com.zillionfortune.common.dto.BaseRequest;

/**
 * ClassName: AuthorizedPersonUpdateRequest <br/>
 * Function: 更新被授权人审核状态参数对象. <br/>
 * Date: 2016年12月13日 下午6:29:44 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class AuthorizedPersonAuditRequestVo extends BaseRequest {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 1L;

	/**  memberId  必输  */
	private String memberId;
	
	/**  当前被授权人的主键id 必输  */
	private Long authorizedPersonId;
	
	/**  被授权人的审核状态  必输  */
	private Integer status;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Long getAuthorizedPersonId() {
		return authorizedPersonId;
	}

	public void setAuthorizedPersonId(Long authorizedPersonId) {
		this.authorizedPersonId = authorizedPersonId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
