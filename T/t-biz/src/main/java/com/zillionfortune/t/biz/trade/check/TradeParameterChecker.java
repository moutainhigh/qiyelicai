/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.trade.check;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.integeration.trade.dto.ReconQueryExcelRequest;
import com.zillionfortune.t.integeration.trade.dto.ReconQueryRequest;

/**
 * ClassName: TradeParameterChecker <br/>
 * Function: 交易模块参数校验. <br/>
 * Date: 2016年12月16日 下午2:59:51 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class TradeParameterChecker {

	/**
	 * checkReconListQuery:企业资产查询. <br/>
	 *
	 * @param req ReconQueryRequest
	 * @throws BusinessException
	 */
	public void checkReconListQuery(ReconQueryRequest req) throws BusinessException {
		// 校验请求参数
		if (req == null) {
			throw new BusinessException("请求对象不能为空");
		}
		
		if(StringUtils.isBlank(req.getMemberId())){
			throw new BusinessException("会员ID不能为空！" );
		}
		
//		if(StringUtils.isBlank(req.getTimeInterval())){
//			throw new BusinessException("时间区间不能为空！" );
//		}
		
	}
	
	
	public void checkExportExcel(ReconQueryExcelRequest req) throws BusinessException {
		// 校验请求参数
		if (req == null) {
			throw new BusinessException("请求对象不能为空");
		}
		
		if(StringUtils.isBlank(req.getMemberId())){
			throw new BusinessException("会员ID不能为空！" );
		}
		
	}
	
	
}
