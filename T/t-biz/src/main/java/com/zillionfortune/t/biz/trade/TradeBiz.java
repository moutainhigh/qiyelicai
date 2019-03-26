/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.trade;

import java.io.OutputStream;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.integeration.trade.dto.ReconQueryExcelRequest;
import com.zillionfortune.t.integeration.trade.dto.ReconQueryRequest;

/**
 * ClassName: TradeBiz <br/>
 * Function: 交易服务接口. <br/>
 * Date: 2016年12月19日 下午8:08:33 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface TradeBiz {
	
	/**
	 * assetsQuery:对账管理列表查询(分页). <br/>
	 *
	 * @param req ReconQueryRequest
	 * @return BaseWebResponse
	 */
	public BaseWebResponse reconListByPage(ReconQueryRequest req) throws Exception,BusinessException;
	
	
	/**
	 * exportExcel:对账管理列表Excel下载. <br/>
	 *
	 * @param req ReconQueryRequest
	 * @param response HttpServletResponse
	 * @throws Exception
	 */
	public void exportExcel(ReconQueryExcelRequest req ,OutputStream os) throws Exception;

}
