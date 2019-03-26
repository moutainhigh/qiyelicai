/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.t.common.util.BeanConvertUtil;
import com.zillionfortune.t.common.util.HttpClientUtil;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.integeration.cif.UserAuditIntegration;
import com.zillionfortune.t.integeration.cif.dto.UserAuditRequest;
import com.zillionfortune.t.integeration.cif.dto.UserAuditResponse;

/**
 * ClassName: UserAuditIntegrationImpl <br/>
 * Function: 企业会员认证信息审核接口 实现. <br/>
 * Date: 2016年12月28日 下午2:25:34 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
@Component
public class UserAuditIntegrationImpl implements UserAuditIntegration {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${cif.user.audit.url}")
	private String userAuditUrl;
	
	/**
	 * @see com.zillionfortune.t.integeration.cif.UserAuditIntegration#audit(com.zillionfortune.t.integeration.cif.dto.UserAuditRequest)
	 */
	@Override
	public UserAuditResponse audit(UserAuditRequest req) throws Exception {
		log.info("audit.req:" + JSON.toJSONString(req));
		// 准备参数
		Map<String, String> paramMap = BeanConvertUtil.beanToMapWithoutNullValueMap(req);
		
		// 发送请求
		String resultJson = HttpClientUtil.sendPostRequest(userAuditUrl, paramMap);
		
		log.info("audit.resp:" + resultJson);
		return JsonUtils.json2Object(resultJson, UserAuditResponse.class);
	}

}
