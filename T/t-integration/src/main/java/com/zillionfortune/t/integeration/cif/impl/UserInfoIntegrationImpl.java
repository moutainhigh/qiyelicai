/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zillionfortune.t.common.util.BeanConvertUtil;
import com.zillionfortune.t.common.util.HttpClientUtil;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.integeration.cif.UserInfoIntegration;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoQueryCifResponse;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoQueryRequest;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoUpdateCifResponse;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoUpdateRequest;

/**
 * ClassName: UserInfoIntegrationImpl <br/>
 * Function: 企业用户信息服务接口实现. <br/>
 * Date: 2016年12月19日 下午7:00:08 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Service
public class UserInfoIntegrationImpl implements UserInfoIntegration {
	
	@Value("${cif.enterprise.queryInfo.url}")
	private String enterpriseQueryInfoUrl;
	
	@Value("${cif.enterprise.infoUpdate.url}")
	private String enterpriseInfoUpdateUrl;

	@Override
	public EnterpriseExtInfoQueryCifResponse enterpriseQueryInfo(EnterpriseExtInfoQueryRequest req) throws Exception {
		EnterpriseExtInfoQueryCifResponse resp = null;
		// 请求参数
		Map<String, String> paramMap = BeanConvertUtil.beanToMapWithoutNullValueMap(req);
		// 企业信息查询
		String respContent;
		respContent = HttpClientUtil.sendPostRequest(enterpriseQueryInfoUrl, paramMap);
		resp = JsonUtils.json2Object(respContent, EnterpriseExtInfoQueryCifResponse.class);
		//返回响应
		return resp;
	}

	@Override
	public EnterpriseExtInfoUpdateCifResponse enterpriseInfoUpdate(EnterpriseExtInfoUpdateRequest req) throws Exception {
		EnterpriseExtInfoUpdateCifResponse resp = null;
		// 请求参数
		Map<String, String> paramMap = BeanConvertUtil.beanToMapWithoutNullValueMap(req);
		// 企业信息查询
		String respContent;
		respContent = HttpClientUtil.sendPostRequest(enterpriseInfoUpdateUrl, paramMap);
		resp = JsonUtils.json2Object(respContent, EnterpriseExtInfoUpdateCifResponse.class);
		//返回响应
		return resp;
	}

}
