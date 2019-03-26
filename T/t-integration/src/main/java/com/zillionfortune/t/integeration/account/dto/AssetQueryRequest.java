/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.account.dto;

import com.zillionfortune.common.dto.BaseRequest;

/**
 * ClassName: AssetQueryRequest <br/>
 * Function: 企业资产查询_请求参数对象. <br/>
 * Date: 2016年11月15日 下午4:31:30 <br/>
 *
 * @author kaiyun
 * @version 
 * @since JDK 1.7
 */
public class AssetQueryRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 会员ID，必输
	 */
	private String memberId;
	
	
	public AssetQueryRequest() {
		super();
	}

	public AssetQueryRequest(String memberId) {
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
