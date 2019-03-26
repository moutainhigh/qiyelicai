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
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.t.common.util.HttpClientUtil;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.integeration.cif.UserGradeIntegration;
import com.zillionfortune.t.integeration.cif.dto.UserGradeQueryCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserGradeRequest;
import com.zillionfortune.t.integeration.cif.dto.UserGradeUpdateCifResponse;

/**
 * ClassName: UserGradeIntegrationImpl <br/>
 * Function: 企业会员等级相关服务_实现. <br/>
 * Date: 2016年12月20日 下午12:50:17 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Service
public class UserGradeIntegrationImpl implements UserGradeIntegration {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * updateGradeUrl:企业会员等级更新.
	 */
	@Value("${cif.enterprise.updateGrade.url}")
	private String updateGradeUrl;
	
	/**
	 * queryGrade:企业会员等级查询.
	 */
	@Value("${cif.enterprise.queryGrade.url}")
	private String queryGrade;
	
	/**
	 * updateGrade:企业会员等级更新. <br/>
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@Override
	public UserGradeUpdateCifResponse updateGrade(UserGradeRequest req) throws Exception {
		log.info("UserGradeIntegrationImpl.updateGrade.req:" + JSON.toJSONString(req));

		// step1：参数绑定
		Map<String,String> mapParam = new HashMap<String,String>();
		mapParam.put("memberId", req.getMemberId()); // 会员Id
		mapParam.put("grade", req.getGrade()); // 等级值
		mapParam.put("gradeType", req.getGradeType()); // 等级类型
		
		// step2：发送请求
		String responseContent = HttpClientUtil.sendPostRequest(updateGradeUrl, mapParam);
		
		// step3：处理反馈结果
		UserGradeUpdateCifResponse cifResp = JsonUtils.json2Object(responseContent, UserGradeUpdateCifResponse.class);;

		log.info("UserGradeIntegrationImpl.updateGrade.resp:" + responseContent);
		
		return cifResp;
	}

	/**
	 * 企业会员等级查询.
	 * @see com.zillionfortune.t.integeration.cif.UserGradeIntegration#queryGrade(com.zillionfortune.t.integeration.cif.dto.UserGradeRequest)
	 */
	@Override
	public UserGradeQueryCifResponse queryGrade(UserGradeRequest req) throws Exception {
		log.info("UserGradeIntegrationImpl.queryGrade.req:" + JSON.toJSONString(req));

		// step1：参数绑定
		Map<String,String> mapParam = new HashMap<String,String>();
		mapParam.put("memberId", req.getMemberId()); // 会员Id
		mapParam.put("grade", req.getGrade()); // 等级值
		mapParam.put("gradeType", req.getGradeType()); // 等级类型
		
		// step2：发送请求
		String responseContent = HttpClientUtil.sendPostRequest(queryGrade, mapParam);
		
		// step3：处理反馈结果
		UserGradeQueryCifResponse cifResp = JsonUtils.json2Object(responseContent, UserGradeQueryCifResponse.class);;

		log.info("UserGradeIntegrationImpl.queryGrade.resp:" + responseContent);
		
		return cifResp;
	}
	
}
