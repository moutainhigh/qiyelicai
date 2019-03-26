/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.account.impl;

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
import com.zillionfortune.t.integeration.account.AssetIntegeration;
import com.zillionfortune.t.integeration.account.dto.AssetQueryRequest;
import com.zillionfortune.t.integeration.account.dto.AssetQueryResponse;
import com.zillionfortune.t.integeration.account.dto.BalanceAssertPesponse;

/**
 * ClassName: AssetintegerationImpl <br/>
 * Function: 企业资产服务接口实现. <br/>
 * Date: 2016年12月19日 下午8:14:08 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class AssetIntegerationImpl implements AssetIntegeration {
	
	@Value("${qylc_balance_query_url}")
	private String AssetQueryUrl;

	@SuppressWarnings("unchecked")
	@Override
	public AssetQueryResponse assetsQuery(AssetQueryRequest req) throws Exception,BusinessException  {
		
		String respContent = null;
		JSONObject obj = null;
		AssetQueryResponse resp = null;
		
		// 将请求参数对象转换成Map
		Map<String, String> paramMap = BeanConvertUtil.beanToMapWithoutNullValueMap(req);
		
		// 调用远程服务
		respContent = HttpClientUtil.sendPostRequest(AssetQueryUrl, paramMap);
		if(respContent==null){
			throw new BusinessException("企业资产查询接口调用失败！");
		}
		
		// 将json字符创转换成json对象
		obj = JSONObject.fromObject(respContent);
		
		// 判断远程URl调用是否成功
		String respCode = obj.getString("respCode");
		String resultCode = obj.getString("resultCode");
		String resultMsg = obj.getString("resultMsg");
		if (!(RespCode.SUCCESS.code()).equals(respCode)
				|| !(ResultCode.SUCCESS.code()).equals(resultCode)) {
			if("9005".equalsIgnoreCase(resultCode)){
				resp = new AssetQueryResponse();
				resp.setMemberId("");
				resp.setTotalAssets("");
				resp.setOnTheWayAssets("");
				List<BalanceAssertPesponse> assetsList = null;
				resp.setAssetsList(assetsList);
				return resp;
			}
			throw new BusinessException(resultMsg );
		}
		
		// 组装响应对象
		resp = new AssetQueryResponse();
		resp.setMemberId(req.getMemberId());//会员Id
		resp.setTotalAssets(obj.getString("totalShare"));//总资产
		resp.setOnTheWayAssets(obj.getString("availableShare"));//在途资产（可用资产）
		List<BalanceAssertPesponse> assetsList = CollectionsUtil.arrayList(obj.getJSONArray("assetsList").toArray());
		resp.setAssetsList(assetsList);//资产列表
//		resp.setShareUnit(obj.getString("shareUnit"));//资产单位
//		resp.setCompayName(obj.getString("name"));//公司名称名称
		
		// 返回
		return resp;
	}
	
}
