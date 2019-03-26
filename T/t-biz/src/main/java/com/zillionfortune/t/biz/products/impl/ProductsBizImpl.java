/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.products.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.product.check.ProductParameterChecker;
import com.zillionfortune.t.biz.products.ProductsBiz;
import com.zillionfortune.t.biz.user.impl.UserLoginBizImpl;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.integeration.product.dto.ProductInfoQueryRequest;
import com.zillionfortune.t.integeration.product.dto.ProductInfoQueryResponse;
import com.zillionfortune.t.integeration.product.dto.ProductListQueryRequest;
import com.zillionfortune.t.integeration.product.dto.ProductListQueryResponse;
import com.zillionfortune.t.integeration.products.ProductsIntegeration;

/**
 * ClassName: ProductsBizImpl <br/>
 * Function: 产品接口实现. <br/>
 * Date: 2016年12月19日 下午5:54:04 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Service
public class ProductsBizImpl implements ProductsBiz {
	
	private static Logger log = LoggerFactory.getLogger(UserLoginBizImpl.class);
	
	@Autowired
	ProductsIntegeration  productsIntegeration;
	
	@Autowired
	ProductParameterChecker productParameterChecker;
	
	
	@Override
	public BaseWebResponse productListQuery(ProductListQueryRequest req) {
		log.info("ProductsBizImpl.productListQuery.req:" + JsonUtils.object2Json(req));
		
		BaseWebResponse baseResp = null;
		ProductListQueryResponse proResp = null;
		
		try {
			//校验请求参数
			productParameterChecker.checkProductListQuery(req);
			
			// 执行企业信息查询
			proResp = productsIntegeration.productListQuery(req);
			
			// 组装响应对象
			baseResp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			baseResp.setData(proResp);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				BusinessException be = (BusinessException) e;
				baseResp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),be.getMessage());
            } else {
            	baseResp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
		}
		
		log.info("ProductsBizImpl.productListQuery.req:" + JsonUtils.object2Json(baseResp));
		
		return baseResp;
	}


	@Override
	public BaseWebResponse productInfoQuery(ProductInfoQueryRequest req) {
		log.info("ProductsBizImpl.productInfoQuery.req:" + JsonUtils.object2Json(req));
		
		BaseWebResponse baseResp = null;
		ProductInfoQueryResponse proResp = null;
		
		try {
			//校验请求参数
			productParameterChecker.checkProductInfoQuery(req);
			
			// 执行企业信息查询
			proResp = productsIntegeration.productInfoQuery(req);
			
			// 组装响应对象
			baseResp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			baseResp.setData(proResp);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				BusinessException be = (BusinessException) e;
				baseResp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),be.getMessage());
            } else {
            	baseResp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
		}
		
		log.info("ProductsBizImpl.productInfoQuery.req:" + JsonUtils.object2Json(baseResp));
		
		return baseResp;
	}

}
