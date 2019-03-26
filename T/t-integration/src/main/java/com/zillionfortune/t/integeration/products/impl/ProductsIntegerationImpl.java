/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.products.impl;

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
import com.zillionfortune.t.integeration.product.dto.ProductInfoQueryRequest;
import com.zillionfortune.t.integeration.product.dto.ProductInfoQueryResponse;
import com.zillionfortune.t.integeration.product.dto.ProductListQueryRequest;
import com.zillionfortune.t.integeration.product.dto.ProductListQueryResponse;
import com.zillionfortune.t.integeration.product.dto.ProductModelConvert;
import com.zillionfortune.t.integeration.products.ProductsIntegeration;

/**
 * ClassName: ProductsIntegerationImpl <br/>
 * Function: 产品服务接口实现. <br/>
 * Date: 2016年12月19日 下午7:48:53 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class ProductsIntegerationImpl implements ProductsIntegeration {
	
	@Value("${qylc_product_list_url}")
	private String productListUrl;
	
	@Value("${qylc_product_detail_url}")
	private String productDetailUrl;
	
	

	@SuppressWarnings("rawtypes")
	@Override
	public ProductListQueryResponse productListQuery(ProductListQueryRequest req) throws Exception {
		ProductListQueryResponse resp = null;
		String respContent = null;
		JSONObject obj = null;
		
		
		// 将请求参数对象转换成 Map
		Map<String, String> paramMap = BeanConvertUtil.beanToMapWithoutNullValueMap(req);
		
		// 调用远程服务
		respContent = HttpClientUtil.sendPostRequest(productListUrl, paramMap);
		
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
		resp = new ProductListQueryResponse();
		resp.setTotalCount(obj.getString("totalCount")+"");//总记录数 
		List<ProductModelConvert> proConvertList = new ArrayList<ProductModelConvert>();
		List objList = CollectionsUtil.arrayList(obj.getJSONArray("productModelList").toArray());
		for(int i=0;i<objList.size();i++){
			JSONObject pjson = (JSONObject)objList.get(i);
			ProductModelConvert proConvert = new ProductModelConvert();
			proConvert.setProductId(pjson.getString("id")+"");//产品Id
			proConvert.setProductCode(pjson.getString("code")+"");//产品编码
			proConvert.setProductName(pjson.getString("fullName")+"");//产品名称
			proConvert.setAnualRate(pjson.getString("minYieldRate")+"");//预期年化率
			proConvert.setInvestmentTerm(pjson.getString("lockPeriod")+"");//投资期限
			proConvert.setStartingInvestmentamt(pjson.getString("minInvestAmount")+"");//起投金额
			proConvertList.add(proConvert);
		}
		resp.setProductModelList(proConvertList);
		return resp;
	}


	@Override
	public ProductInfoQueryResponse productInfoQuery(ProductInfoQueryRequest req) throws Exception {
		ProductInfoQueryResponse resp = null;
		JSONObject obj = null;
		
		// 请求参数
		Map<String, String> paramMap = BeanConvertUtil.beanToMapWithoutNullValueMap(req);
		
		// 企业信息查询
		String respContent;
		respContent = HttpClientUtil.sendPostRequest(productDetailUrl, paramMap);
		
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
		resp = new ProductInfoQueryResponse();
		JSONObject objPro = obj.getJSONObject("productModel");
		resp.setProductId(objPro.getString("id"));//产品Id
		resp.setCode(objPro.getString("code"));//产品编号
		resp.setFullName(objPro.getString("fullName"));//产品名称全称
		resp.setTotalAmount(objPro.getString("totalAmount"));//产品规模
		resp.setMaxInvestAmount(objPro.getString("maxInvestAmount"));//最高购买金额
		resp.setInvestedAmount(objPro.getString("investedAmount"));//已投资金额?????
		resp.setUnit(objPro.getString("unit"));//计量单位(1:份额, 2:人民币)
		resp.setMinInvestAmount(objPro.getString("minInvestAmount"));//起购金额
		resp.setIntroduction(objPro.getString("introduction"));//产品介绍
		resp.setSaleStartDate(objPro.getString("saleStartDate"));//募集起始日期
		resp.setSaleEndDate(objPro.getString("saleEndDate"));//募集截止日期
		resp.setValueDate(objPro.getString("valueDate"));//起息日期
		resp.setExpireDate(objPro.getString("expireDate"));//到期日期
		resp.setRestSaleTime(objPro.getString("restSaleTime"));//剩余募集时间（剩余时间）
		resp.setIncreaseInvestAmount(objPro.getString("increaseInvestAmount"));//递增金额		
		resp.setMinYieldRate(objPro.getString("minYieldRate"));//最低预期收益率（预期年化收益率）
		resp.setLockPeriod(objPro.getString("lockPeriod"));//锁定期（理财期限）
		
		return resp;
	}

}
