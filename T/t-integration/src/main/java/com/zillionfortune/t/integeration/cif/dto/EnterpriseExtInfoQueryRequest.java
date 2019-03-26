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
 * Function: 企业信息_请求参数对象. <br/>
 * Date: 2016年12月19日 下午7:09:40 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class EnterpriseExtInfoQueryRequest extends BaseRequest {
	
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 会员ID，必输
	 */
	private String memberId;
	
	
	
	public EnterpriseExtInfoQueryRequest() {
		super();
	}

	public EnterpriseExtInfoQueryRequest(String memberId) {
		super();
		this.memberId = memberId;
	}
	
	

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}
