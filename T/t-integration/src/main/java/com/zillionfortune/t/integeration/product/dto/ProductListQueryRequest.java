/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.product.dto;

import com.zillionfortune.common.dto.BaseRequest;
import com.zillionfortune.t.common.enums.ProductStatusEnum;

/**
 * ClassName: LoginRequest <br/>
 * Function: 产品列表查询_请求参数对象. <br/>
 * Date: 2016年11月15日 下午4:31:30 <br/>
 *
 * @author kaiyun
 * @version 
 * @since JDK 1.7
 */
public class ProductListQueryRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	
	/** 默认当前页 */
	private static final String PAGE_NUM_DEFAULT = "1";
	
	/** 默认每页条数 */
	private static final String PAGE_SIZE_DEFAULT = "2";
	
	
	/**
	 * 所属产品线ID
	 */
	private String productLineId;
	
	/**
	 * 产品的类型代码，必输
	 */
	private String patternCode;
	
	/**
	 * 产品状态
	 */
	private String status = ProductStatusEnum.PRODUCT_STATUS_ON_SHELF.getCode();
	
	/**
	 * 当前页码
	 */
	private String pageNo = PAGE_NUM_DEFAULT;
	
	/**
	 * 每页显示多少条
	 */
	private String pageSize = PAGE_SIZE_DEFAULT;

	
	public ProductListQueryRequest() {
		super();
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getPatternCode() {
		return patternCode;
	}

	public void setPatternCode(String patternCode) {
		this.patternCode = patternCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProductLineId() {
		return productLineId;
	}

	public void setProductLineId(String productLineId) {
		this.productLineId = productLineId;
	}
	

}
