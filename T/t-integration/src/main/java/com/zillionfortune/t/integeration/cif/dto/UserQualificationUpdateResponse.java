/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseResponse;

/**
 * ClassName: UserQualificationUpdateResponse <br/>
 * Function: 企业资质更新Response. <br/>
 * Date: 2016年12月20日 上午11:34:07 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public class UserQualificationUpdateResponse extends BaseResponse {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private String memberId;
	
	public UserQualificationUpdateResponse(String respCode) {
		super(respCode);
	}
	
	public UserQualificationUpdateResponse(String respCode, String resultCode, String resultMsg) {
		super(respCode, resultCode, resultMsg);
	}

	public UserQualificationUpdateResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserQualificationUpdateResponse(String respCode, String resultMsg) {
		super(respCode, resultMsg);
		// TODO Auto-generated constructor stub
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	
}
