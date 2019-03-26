/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.trade.impl;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.trade.TradeBiz;
import com.zillionfortune.t.biz.trade.check.TradeParameterChecker;
import com.zillionfortune.t.biz.user.impl.UserLoginBizImpl;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.excel.ExportExcel;
import com.zillionfortune.t.common.excel.ReconModel;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.integeration.trade.TradeIntegeration;
import com.zillionfortune.t.integeration.trade.dto.Recon;
import com.zillionfortune.t.integeration.trade.dto.ReconQueryExcelRequest;
import com.zillionfortune.t.integeration.trade.dto.ReconQueryRequest;
import com.zillionfortune.t.integeration.trade.dto.ReconQueryResponse;

/**
 * ClassName: TradeBizImpl <br/>
 * Function: 交易服务接口实现. <br/>
 * Date: 2016年12月19日 下午8:14:08 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class TradeBizImpl implements TradeBiz {
	
	private static Logger log = LoggerFactory.getLogger(UserLoginBizImpl.class);
	
	@Autowired
	TradeIntegeration tradeIntegeration;
	
	@Autowired
	TradeParameterChecker tradingParameterChecker;
	
	
	@Override
	public BaseWebResponse reconListByPage(ReconQueryRequest req) throws Exception,BusinessException  {
		
		log.info("TradeBizImpl.recon.req:" + JsonUtils.object2Json(req));
		
		BaseWebResponse resp = null;
		ReconQueryResponse reconQueryResp = null;
		
		try {
			//校验请求参数
			tradingParameterChecker.checkReconListQuery(req);
			
			// 执行对账管理查询
			reconQueryResp = tradeIntegeration.reconListByPage(req);
			
			// 组装响应对象
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			resp.setData(reconQueryResp);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				BusinessException be = (BusinessException) e;
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),be.getMessage());
            } else {
            	resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
		}
		
		log.info("TradeBizImpl.recon.req:" + JsonUtils.object2Json(resp));
		
		return resp;
	}


	@Override
	public void exportExcel(ReconQueryExcelRequest req ,OutputStream os) throws Exception {
		log.info("TradeBizImpl.exportExcel.req:" + JsonUtils.object2Json(req));
		
		BaseWebResponse resp = null;
		ReconQueryResponse reconQueryResp = null;
		List<Recon> reconList = null;
		
		try {
			//校验请求参数
			tradingParameterChecker.checkExportExcel(req);
			
			// 获取列表
			reconQueryResp = tradeIntegeration.reconList(req);
			reconList = reconQueryResp.getReconList();
			
			// 
			ExportExcel<ReconModel> ex = new ExportExcel<ReconModel>();
			List<ReconModel> dataset = new ArrayList<ReconModel>();
			if(reconList!=null){
				for(Recon recon : reconList)
				{
					dataset.add(new ReconModel(recon.getTradeTime(),recon.getProductName(),recon.getIncomeAmt(),recon.getTurnOutAmt(),recon.getTradeStatus(),recon.getRemark()) );
				}
			}
			String[] headers = {"交易时间","产品名称","转入金额","转出金额","交易状态","备注"};
			
			ex.exportExcel("对账管理记录", headers, dataset, os, "yyyy-MM-dd HH:mm:ss");
			
			os.close();
			
			// 组装响应对象
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			resp.setData(reconQueryResp);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				BusinessException be = (BusinessException) e;
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),be.getMessage());
            } else {
            	resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
		}
		
		
		
		log.info("TradeBizImpl.exportExcel.req:" + JsonUtils.object2Json(resp));
	}


}
