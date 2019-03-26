/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.trade;

import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.integeration.trade.dto.ReconQueryExcelRequest;
import com.zillionfortune.t.integeration.trade.dto.ReconQueryRequest;
import com.zillionfortune.t.integeration.trade.dto.ReconQueryResponse;

/**
 * ClassName: TradeIntegeration <br/>
 * Function: 交易服务接口. <br/>
 * Date: 2016年12月19日 下午8:08:33 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface TradeIntegeration {
	
	/**
	 * reconListByPage:对账管理列表查询(分页). <br/>
	 *
	 * @param req ReconQueryRequest
	 * @return ReconQueryResponse
	 */
	public ReconQueryResponse reconListByPage(ReconQueryRequest req) throws Exception,BusinessException;
	
	/**
	 * reconList:对账管理列表查询. <br/>
	 *
	 * @param req ReconQueryExcelRequest
	 * @return ReconQueryResponse
	 */
	public ReconQueryResponse reconList(ReconQueryExcelRequest req) throws Exception,BusinessException;

}
