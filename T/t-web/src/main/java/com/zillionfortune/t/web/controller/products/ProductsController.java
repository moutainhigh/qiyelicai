/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.web.controller.products;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.products.ProductsBiz;
import com.zillionfortune.t.integeration.product.dto.ProductInfoQueryRequest;
import com.zillionfortune.t.integeration.product.dto.ProductListQueryRequest;

/**
 * ClassName: EnterpriseUserLoginController <br/>
 * Function: 企业理财_产品_contorller. <br/>
 * Date: 2016年12月13日 下午6:42:07 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Controller
@RequestMapping(value = "/productservice")
public class ProductsController {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductsBiz productsBiz;
	
	
	/**
	 * productListQuery:理财产品列表查询. <br/>
	 * http://localhost:8080/t-web/productservice/productListQuery.json
	 *
	 * @param vo
	 * @return
	 */
    @RequestMapping(value = "/productListQuery", method = RequestMethod.POST)
    @ResponseBody
    public BaseWebResponse productListQuery(@RequestBody ProductListQueryRequest vo) {
    	log.info("ProductsController.productListQuery.req:" + JSON.toJSONString(vo));
    	
    	BaseWebResponse resp = null;
    	try {
    		resp = productsBiz.productListQuery(vo);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
    	
    	log.info("ProductsController.productListQuery.resp:" + JSON.toJSONString(resp));
    	
    	return resp;
    }
    
    /**
     * productInfoQuery:产品详情查询. <br/>
     * http://localhost:8080/t-web/productservice/productInfoQuery.json
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "/productInfoQuery", method = RequestMethod.POST)
    @ResponseBody
    public BaseWebResponse productInfoQuery(@RequestBody ProductInfoQueryRequest vo) {
    	log.info("ProductsController.productListQuery.req:" + JSON.toJSONString(vo));
    	
    	BaseWebResponse resp = null;
    	try {
    		resp = productsBiz.productInfoQuery(vo);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
    	
    	log.info("ProductsController.productListQuery.resp:" + JSON.toJSONString(resp));
    	
    	return resp;
    }
    
}
