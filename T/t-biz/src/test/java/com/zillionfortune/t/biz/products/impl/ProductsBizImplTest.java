/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.products.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.products.ProductsBiz;
import com.zillionfortune.t.integeration.product.dto.ProductInfoQueryRequest;
import com.zillionfortune.t.integeration.product.dto.ProductListQueryRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-basic.xml")
@ActiveProfiles("dev")
public class ProductsBizImplTest {
	
	@Autowired
	ProductsBiz productsBiz;
	
	/**
	 * 产品列表查询. <br/>
	 *
	 */
	@Test
	public void productListQuery(){
		String patternCode = "02";//产品的类型代码 01:活期, 02:定期类, 03:净值型
		ProductListQueryRequest req = new ProductListQueryRequest();
		req.setPatternCode(patternCode);
		req.setPageNo("1");
		req.setPageSize("2");
		BaseWebResponse resp = productsBiz.productListQuery(req);
		System.out.println(JSON.toJSONString(resp));
		
	}
	
	/**
	 * productInfoQuery:产品详情查询. <br/>
	 *
	 */
	@Test
	public void productInfoQuery(){
		String productId = "1";//产品ID
		ProductInfoQueryRequest req = new ProductInfoQueryRequest();
		//req.setProductId(productId);
		BaseWebResponse resp = productsBiz.productInfoQuery(req);
		System.out.println(JSON.toJSONString(resp));
	}

}
