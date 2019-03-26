/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.product.check;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.zillionfortune.t.common.enums.PatternCodeTypeEnum;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.integeration.product.dto.ProductInfoQueryRequest;
import com.zillionfortune.t.integeration.product.dto.ProductListQueryRequest;

/**
 * ClassName: EnterpriseQualityAuthParameterChecker <br/>
 * Function: 企业产品模块参数校验. <br/>
 * Date: 2016年12月16日 下午2:59:51 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class ProductParameterChecker {

	/**
	 * checkProductListQuery:理财产品列表. <br/>
	 *
	 * @param req ProductListQueryRequest
	 * @throws BusinessException
	 */
	public void checkProductListQuery(ProductListQueryRequest req) throws BusinessException {
		// 校验请求参数
		if (req == null) {
			throw new BusinessException("请求对象不能为空");
		}
		if(StringUtils.isBlank(req.getPatternCode())){
			throw new BusinessException("产品的类型代码字段的参数值不能为空");
		}
		if (PatternCodeTypeEnum.getEnumItem(req.getPatternCode()) == null){
        	throw new BusinessException("产品的类型代码字段的参数值不在约定的范围");
        }
	}
	
	/**
	 * checkProductInfoQuery:产品详情查询. <br/>
	 *
	 * @throws BusinessException
	 */
	public void checkProductInfoQuery(ProductInfoQueryRequest req) throws BusinessException {
		// 校验请求参数
		if (req == null) {
			throw new BusinessException("请求对象不能为空");
		}
		if(StringUtils.isBlank(req.getProductCode())){
			throw new BusinessException("产品编号不能为空");
		}
	}
	
	
}
