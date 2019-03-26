/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.web.controller.common.vo;

import com.zillionfortune.common.dto.BaseRequest;

/**
 * ClassName: ShortMessageSendRequestVo <br/>
 * Function: 短信发送接收参数对象. <br/>
 * Date: 2016年12月19日 下午2:14:10 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class ShortMessageSendRequestVo extends BaseRequest {
	
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * operatorId:操作员Id.
	 */
	private Long operatorId;
	
	/**  短信编码即业务类型  必输  */
	private String businessType;
	
	/**  手机号  必输  */
	private String mobile;
	
	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取operatorId的值.
	 *
	 * @return operatorId
	 */
	public Long getOperatorId() {
		return operatorId;
	}

	/**
	 * 设置operatorId的值.
	 *
	 * @param  operatorId
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	
}
