/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.web.controller.trade;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

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
import com.zillionfortune.t.biz.trade.TradeBiz;
import com.zillionfortune.t.integeration.trade.dto.ReconQueryExcelRequest;
import com.zillionfortune.t.integeration.trade.dto.ReconQueryRequest;

/**
 * ClassName: TradeController <br/>
 * Function: 企业理财_交易_contorller. <br/>
 * Date: 2016年12月13日 下午6:42:07 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Controller
@RequestMapping(value = "/tradeservice")
public class TradeController {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TradeBiz tradeBiz;
	
	
	/**
	 * reconListQuery:对账管理列表查询. <br/>
	 * http:// locathost:8080/tradeservice/recon.json
	 *
	 * @param req ReconQueryRequest
	 * @return BaseWebResponse
	 */
	@ResponseBody
    @RequestMapping(value = "/recon", method = RequestMethod.POST)
    public BaseWebResponse reconListQuery(@RequestBody ReconQueryRequest req) {
    	log.info("TradeController.reconListQuery.req:" + JSON.toJSONString(req));
    	
    	BaseWebResponse  resp = null;
    	try {
    		resp = tradeBiz.reconListByPage(req);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} 
    	
    	log.info("TradeController.reconListQuery.resp:" + JSON.toJSONString(resp));
    	
    	return resp;
    }
    
    
    /**
	 * 导出Excel_产品部_通用_优化
	 */
	@ResponseBody
	@RequestMapping(value = "/reconfiledownload",method = RequestMethod.GET)
	public void exportExcel(ReconQueryExcelRequest req ,HttpServletResponse response) {
		log.info("TradeController.exportExcel.req:" + JSON.toJSONString(req));
		
		try {
			// 下载文件命名
			String fileName = "trade_"+System.currentTimeMillis()+".xls";
						
			// 设置头信息
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("content-Disposition","attachment;filename="+URLEncoder.encode(fileName,"utf-8"));
			
			tradeBiz.exportExcel(req, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("TradeController.exportExcel.req:" + JSON.toJSONString(req));
		
	}
    
}
