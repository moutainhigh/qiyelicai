/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.trade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.common.util.BeanConvertUtil;
import com.zillionfortune.t.common.util.CollectionsUtil;
import com.zillionfortune.t.common.util.HttpClientUtil;
import com.zillionfortune.t.integeration.trade.TradeIntegeration;
import com.zillionfortune.t.integeration.trade.dto.Recon;
import com.zillionfortune.t.integeration.trade.dto.ReconQueryExcelRequest;
import com.zillionfortune.t.integeration.trade.dto.ReconQueryRequest;
import com.zillionfortune.t.integeration.trade.dto.ReconQueryResponse;

/**
 * ClassName: TradeIntegerationImpl <br/>
 * Function: 交易服务接口实现. <br/>
 * Date: 2016年12月19日 下午8:14:08 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class TradeIntegerationImpl implements TradeIntegeration {
	
	@Value("${qylc_recon_query_bypage_Url}")
	private String reconListByPage;
	
	@Value("${qylc_recon_query_Url}")
	private String reconListUrl;
	

	/**
	 * 对账管理列表查询(分页)
	 * @see com.zillionfortune.t.integeration.trade.TradeIntegeration#recon(com.zillionfortune.t.integeration.trade.dto.ReconQueryRequest)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public ReconQueryResponse reconListByPage(ReconQueryRequest req) throws Exception,BusinessException  {
		
		String respContent = null;
		JSONObject obj = null;
		ReconQueryResponse resp = null;
		
		// 将请求参数对象转换成Map
		Map<String, String> paramMap = BeanConvertUtil.beanToMapWithoutNullValueMap(req);
		
		// 调用远程服务
		respContent = HttpClientUtil.sendPostRequest(reconListByPage, paramMap);
		if(respContent==null){
			throw new BusinessException("对账管理查询(分页)接口调用失败！");
		}
		
		// 将json字符创转换成json对象
		obj = JSONObject.fromObject(respContent);
		
		// 判断远程URl调用是否成功
		String respCode = obj.getString("respCode");
		String resultCode = obj.getString("resultCode");
		String resultMsg = obj.getString("resultMsg");
		if (!(RespCode.SUCCESS.code()).equals(respCode)
				|| !(ResultCode.SUCCESS.code()).equals(resultCode)) {
			throw new BusinessException(resultMsg );
		}
		
		// 组装响应对象
		resp = new ReconQueryResponse();
		resp.setTotalCount(obj.getString("totalCount"));//总条数  
		resp.setTotalPage("");//总页数 
		resp.setPageNo(obj.getString("pageNo"));//当前页
		resp.setPageSize(obj.getString("pageSize"));//每页多少条
		List<Recon> reconList = new ArrayList<Recon>();
		List objList = CollectionsUtil.arrayList(obj.getJSONArray("orderList").toArray());
		JSONObject pjson = null;
		Recon recon = null;
		for(int i=0;i<objList.size();i++){
			pjson = (JSONObject)objList.get(i);
			recon = new Recon();
			recon.setPatternCode(pjson.getString("patternCode"));//产品类别 :定期、活期……
			recon.setTradeTime(pjson.getString("trxDate"));//交易时间 
			recon.setProductName(pjson.getString("productName"));//产品名称
			recon.setIncomeAmt(pjson.getString("amount"));//转入金额 
			recon.setTurnOutAmt(pjson.getString("outAmount"));//转出金额 
			recon.setTradeStatus(pjson.getString("status"));//交易状态 
			recon.setOperation(pjson.getString("operation"));//操作 
			recon.setRemark(pjson.getString("remark"));//备注
			reconList.add(recon);
		}
		resp.setReconList(reconList);
		
		
		// 返回
		return resp;
	}


	@Override
	public ReconQueryResponse reconList(ReconQueryExcelRequest req)
			throws Exception, BusinessException {
		String respContent = null;
		JSONObject obj = null;
		ReconQueryResponse resp = null;
		
		// 将请求参数对象转换成Map
		Map<String, String> paramMap = BeanConvertUtil.beanToMapWithoutNullValueMap(req);
		
		// 调用远程服务
		respContent = HttpClientUtil.sendPostRequest(reconListUrl, paramMap);
		if(respContent==null){
			throw new BusinessException("对账管理查询接口调用失败！");
		}
		
		// 将json字符创转换成json对象
		obj = JSONObject.fromObject(respContent);
		
		// 判断远程URl调用是否成功
		String respCode = obj.getString("respCode");
		String resultCode = obj.getString("resultCode");
		String resultMsg = obj.getString("resultMsg");
		if (!(RespCode.SUCCESS.code()).equals(respCode)
				|| !(ResultCode.SUCCESS.code()).equals(resultCode)) {
			throw new BusinessException(resultMsg );
		}
		
		// 组装响应对象
		resp = new ReconQueryResponse();
		List<Recon> reconList = new ArrayList<Recon>();
		List objList = CollectionsUtil.arrayList(obj.getJSONArray("orderList").toArray());
		JSONObject pjson = null;
		Recon recon = null;
		for(int i=0;i<objList.size();i++){
			pjson = (JSONObject)objList.get(i);
			recon = new Recon();
			recon.setPatternCode(pjson.getString("patternCode"));//产品类别 :定期、活期……
			recon.setTradeTime(pjson.getString("trxDate"));//交易时间 
			recon.setProductName(pjson.getString("productName"));//产品名称
			recon.setIncomeAmt(pjson.getString("amount"));//转入金额 
			recon.setTurnOutAmt(pjson.getString("outAmount"));//转出金额 
			recon.setTradeStatus(pjson.getString("status"));//交易状态 
			recon.setOperation(pjson.getString("operation"));//操作 
			recon.setRemark("");//备注
			reconList.add(recon);
		}
		resp.setReconList(reconList);
		
		
		// 返回
		return resp;
	}
	
}
