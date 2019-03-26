/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseResponse;

/**
 * ClassName: UserCheckExistsCifResponse <br/>
 * Function: 接收cif根据证件类型证件号码校验企业是否存在反馈对象. <br/>
 * Date: 2016年12月13日 下午6:31:50 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class UserCheckExistsCifResponse extends BaseResponse {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 1L;

	private Integer certificateType;
	
	private String certificateNo;
	
	public UserCheckExistsCifResponse() {
		super();
	}

	public UserCheckExistsCifResponse(String respCode) {
		super(respCode);
	}
	
	public UserCheckExistsCifResponse(String respCode, String resultMsg) {
		super(respCode, resultMsg);
	}

	public UserCheckExistsCifResponse(String respCode, String resultCode,String resultMsg) {
		super(respCode, resultCode, resultMsg);
	}
	
	public Integer getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(Integer certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	
}
