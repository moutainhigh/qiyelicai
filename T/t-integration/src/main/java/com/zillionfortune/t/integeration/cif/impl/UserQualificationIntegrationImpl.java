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
import com.zillionfortune.t.integeration.cif.UserQualificationIntegration;
import com.zillionfortune.t.integeration.cif.dto.UserQualificationUpdateRequest;
import com.zillionfortune.t.integeration.cif.dto.UserQualificationUpdateResponse;

/**
 * ClassName: UserQualificationIntegrationImpl <br/>
 * Function: 企业资质信息接口服务 实现. <br/>
 * Date: 2016年12月20日 下午2:14:36 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
@Component
public class UserQualificationIntegrationImpl implements UserQualificationIntegration {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${cif.enterprise.qualificationupdate.url}")
	private String qualificationUpdateUrl;

	/**
	 * 
	 * @see com.zillionfortune.t.integeration.cif.UserQualificationIntegration#qualificationUpdate(com.zillionfortune.t.integeration.cif.dto.UserQualificationUpdateRequest)
	 */
	@Override
	public UserQualificationUpdateResponse qualificationUpdate(UserQualificationUpdateRequest req) throws Exception {
		log.info("qualificationUpdate.req:" + JSON.toJSONString(req));
		// 准备参数
		Map<String, String> paramMap = BeanConvertUtil.beanToMapWithoutNullValueMap(req);
		
		// 发送请求
		String resultJson = HttpClientUtil.sendPostRequest(qualificationUpdateUrl, paramMap);
		
		log.info("qualificationUpdate.resp:" + resultJson);
		return JsonUtils.json2Object(resultJson, UserQualificationUpdateResponse.class);
	}

}
