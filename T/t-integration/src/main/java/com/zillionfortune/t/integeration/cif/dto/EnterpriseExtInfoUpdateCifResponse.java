/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseResponse;

/**
 * ClassName: EnterpriseExtInfoUpdateCifResponse <br/>
 * Function: 企业信息更新_响应对象. <br/>
 * Date: 2016年12月21日 上午10:52:12 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class EnterpriseExtInfoUpdateCifResponse extends BaseResponse {

	private static final long serialVersionUID = 1L; 
	
	/**
	 *memberId
	 * 必输
	 */
	private String memberId;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public EnterpriseExtInfoUpdateCifResponse() {
		super();
	}

	public EnterpriseExtInfoUpdateCifResponse(String respCode) {
		super(respCode);
	}
	
	public EnterpriseExtInfoUpdateCifResponse(String respCode, String resultMsg) {
		super(respCode, resultMsg);
	}

	public EnterpriseExtInfoUpdateCifResponse(String respCode, String resultCode,String resultMsg) {
		super(respCode, resultCode, resultMsg);
	}
}
