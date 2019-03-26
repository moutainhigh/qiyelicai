/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.order.dto;

import com.zillionfortune.common.dto.BaseResponse;

/**
 * ClassName: CreateOrderResponse <br/>
 * Function: 创建订单请求响应. <br/>
 * Date: 2016年12月22日 上午9:28:15 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public class CreateOrderResponse extends BaseResponse {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * resCode:预约码
	 */
	private String resCode;

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
}
