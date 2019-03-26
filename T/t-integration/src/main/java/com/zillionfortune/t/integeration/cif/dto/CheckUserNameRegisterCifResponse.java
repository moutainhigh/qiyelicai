package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseResponse;

public class CheckUserNameRegisterCifResponse extends BaseResponse {

	private static final long serialVersionUID = 1L; 
	
	/** existFlag 必输 */
	private boolean existFlag;
	
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isExistFlag() {
		return existFlag;
	}

	public void setExistFlag(boolean existFlag) {
		this.existFlag = existFlag;
	}

	public CheckUserNameRegisterCifResponse() {
		super();
	}

	public CheckUserNameRegisterCifResponse(String respCode) {
		super(respCode);
	}
	
	public CheckUserNameRegisterCifResponse(String respCode, String resultMsg) {
		super(respCode, resultMsg);
	}

	public CheckUserNameRegisterCifResponse(String respCode, String resultCode,String resultMsg) {
		super(respCode, resultCode, resultMsg);
	}
}
