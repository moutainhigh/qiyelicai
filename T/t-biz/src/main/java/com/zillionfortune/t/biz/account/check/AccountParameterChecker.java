/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.account.check;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.integeration.account.dto.AssetQueryRequest;

/**
 * ClassName: EnterpriseQualityAuthParameterChecker <br/>
 * Function: 企业资产模块参数校验. <br/>
 * Date: 2016年12月16日 下午2:59:51 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class AccountParameterChecker {

	/**
	 * checkAssetsQuery:企业资产查询. <br/>
	 *
	 * @param req ProductListQueryRequest
	 * @throws BusinessException
	 */
	public void checkAssetsQuery(AssetQueryRequest req) throws BusinessException {
		// 校验请求参数
		if (req == null) {
			throw new BusinessException("请求对象不能为空");
		}
		
		if(StringUtils.isBlank(req.getMemberId())){
			throw new BusinessException("memberId不能为空！" );
		}
		
	}
	
	
}
