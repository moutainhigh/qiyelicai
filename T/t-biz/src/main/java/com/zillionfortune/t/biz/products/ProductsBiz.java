/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.products;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.integeration.product.dto.ProductInfoQueryRequest;
import com.zillionfortune.t.integeration.product.dto.ProductListQueryRequest;

/**
 * ClassName: ProductsBiz <br/>
 * Function: 产品业务接口. <br/>
 * Date: 2016年12月19日 下午5:53:35 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface ProductsBiz {
	
	/**
	 * productListQuery:理财产品列表. <br/>
	 *
	 * @return
	 */
	public BaseWebResponse productListQuery(ProductListQueryRequest req);
	
	/**
	 * productInfoQuery:产品详情查询. <br/>
	 *
	 * @param req ProductInfoQueryRequest
	 * @return BaseWebResponse
	 */
	public BaseWebResponse productInfoQuery(ProductInfoQueryRequest req);
	
}
