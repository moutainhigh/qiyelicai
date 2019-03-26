package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseResponse;


public class UserGradeUpdateCifResponse extends BaseResponse {

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

	public UserGradeUpdateCifResponse() {
		super();
	}

	public UserGradeUpdateCifResponse(String respCode) {
		super(respCode);
	}
	
	public UserGradeUpdateCifResponse(String respCode, String resultMsg) {
		super(respCode, resultMsg);
	}

	public UserGradeUpdateCifResponse(String respCode, String resultCode,String resultMsg) {
		super(respCode, resultCode, resultMsg);
	}
}
