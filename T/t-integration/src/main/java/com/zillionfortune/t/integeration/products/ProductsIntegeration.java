/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.products;

import com.zillionfortune.t.integeration.product.dto.ProductInfoQueryRequest;
import com.zillionfortune.t.integeration.product.dto.ProductInfoQueryResponse;
import com.zillionfortune.t.integeration.product.dto.ProductListQueryRequest;
import com.zillionfortune.t.integeration.product.dto.ProductListQueryResponse;

/**
 * ClassName: ProductsIntegeration <br/>
 * Function: 产品服务接口. <br/>
 * Date: 2016年12月19日 下午5:53:35 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface ProductsIntegeration {
	
	/**
	 * productListQuery:理财产品列表. <br/>
	 *
	 * @param req ProductListQueryRequest
	 * @return ProductListQueryResponse
	 * @throws Exception
	 */
	public ProductListQueryResponse productListQuery(ProductListQueryRequest req) throws Exception;
	
	/**
	 * productInfoQuery:产品详情查询. <br/>
	 *
	 * @param req ProductInfoQueryRequest
	 * @return ProductInfoQueryResponse
	 * @throws Exception
	 */
	public ProductInfoQueryResponse productInfoQuery(ProductInfoQueryRequest req) throws Exception;

}
