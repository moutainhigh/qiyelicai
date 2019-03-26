/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.product.dto;

import com.zillionfortune.common.dto.BaseRequest;

/**
 * ClassName: LoginRequest <br/>
 * Function: 产品详情查询_请求参数对象. <br/>
 * Date: 2016年11月15日 下午4:31:30 <br/>
 *
 * @author kaiyun
 * @version 
 * @since JDK 1.7
 */
public class ProductInfoQueryRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 产品编号，必输
	 */
	private String productCode;
	
	
	public ProductInfoQueryRequest() {
		super();
	}

	public ProductInfoQueryRequest(String productCode) {
		super();
		this.productCode = productCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}




}
