/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.web.controller.user.vo;

import com.zillionfortune.common.dto.BaseRequest;

/**
 * ClassName: UserCheckRequestVo <br/>
 * Function: 用户注册时通过证件类型证件号码查询企业信息请求参数对象. <br/>
 * Date: 2016年12月13日 下午6:29:44 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class UserCheckRequestVo extends BaseRequest {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 1L;

	/**  企业证件类型  必输  */
	private String certificateType;

	/**  企业证件号码  必输  */
	private String certificateNo;
	
	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

}
