/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.web.controller.common.vo;

import com.zillionfortune.common.dto.BaseRequest;

/**
 * ClassName: ShortMessageVerifyRequestVo <br/>
 * Function: 短信验证接收参数对象. <br/>
 * Date: 2016年12月19日 下午2:14:10 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class ShortMessageVerifyRequestVo extends BaseRequest {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 1L;

	/**  手机号  必输  */
	private String mobile;
	
	/**  短信编码即业务类型  必输  */
	private String businessType;
	
	/**  验证吗  必输  */
	private String verificationCode;
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	
}
