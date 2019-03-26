/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.t.common.util.BeanConvertUtil;
import com.zillionfortune.t.common.util.HttpClientUtil;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.integeration.cif.UserBindCardIntegration;
import com.zillionfortune.t.integeration.cif.dto.BindCardQueryResponse;
import com.zillionfortune.t.integeration.cif.dto.BindCardRequest;
import com.zillionfortune.t.integeration.cif.dto.BindCardResponse;
import com.zillionfortune.t.integeration.cif.dto.FindBankAccountNoResponse;

/**
 * ClassName: UserBindCardIntegrationImpl <br/>
 * Function: 会员绑卡相关服务http请求. <br/>
 * Date: 2016年12月15日 下午3:48:49 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
@Component
public class UserBindCardIntegrationImpl implements UserBindCardIntegration {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${cif.enterprise.bindcard.url}")
	private String bindCardUrl;
	@Value("${cif.find.bank.accountno.url}")
	private String findBankAccountUrl;

	/**
	 * @see com.zillionfortune.t.integeration.cif.UserBindCardIntegration#bindCard(com.zillionfortune.t.integeration.cif.dto.BindCardRequest)
	 */
	@Override
	public BindCardResponse bindCard(BindCardRequest req) throws Exception{
		log.info("bindCard.req:" + JSON.toJSONString(req));
		// 准备参数
		Map<String, String> paramMap = BeanConvertUtil.beanToMapWithoutNullValueMap(req);
		
		// 发送请求
		String resultJson = HttpClientUtil.sendPostRequest(bindCardUrl, paramMap);
		
		log.info("bindCard.resp:" + resultJson);
		return JsonUtils.json2Object(resultJson, BindCardResponse.class);
	}

	/**
	 * @see com.zillionfortune.t.integeration.cif.UserBindCardIntegration#unBindCard(com.zillionfortune.t.integeration.cif.dto.BindCardRequest)
	 */
	@Override
	public BindCardResponse unBindCard(BindCardRequest req) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see com.zillionfortune.t.integeration.cif.UserBindCardIntegration#queryEnterpriseBindCard(com.zillionfortune.t.integeration.cif.dto.BindCardRequest)
	 */
	@Override
	public BindCardQueryResponse queryEnterpriseBindCard(BindCardRequest req) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public FindBankAccountNoResponse findBankAccountNo(String bankAccountNo) throws Exception {
		log.info("findBankAccountNo.req: bankAccountNo=" + bankAccountNo);
		// 准备参数
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("bankAccountNo", bankAccountNo);
		
		// 发送请求
		String resultJson = HttpClientUtil.sendPostRequest(findBankAccountUrl, paramMap);
		
		log.info("findBankAccountNo.resp:" + resultJson);
		return JsonUtils.json2Object(resultJson, FindBankAccountNoResponse.class);
	}

}
