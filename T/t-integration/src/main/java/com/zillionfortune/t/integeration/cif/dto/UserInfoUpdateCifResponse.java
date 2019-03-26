package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseResponse;


public class UserInfoUpdateCifResponse extends BaseResponse {

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

	public UserInfoUpdateCifResponse() {
		super();
	}

	public UserInfoUpdateCifResponse(String respCode) {
		super(respCode);
	}
	
	public UserInfoUpdateCifResponse(String respCode, String resultMsg) {
		super(respCode, resultMsg);
	}

	public UserInfoUpdateCifResponse(String respCode, String resultCode,String resultMsg) {
		super(respCode, resultCode, resultMsg);
	}
}
