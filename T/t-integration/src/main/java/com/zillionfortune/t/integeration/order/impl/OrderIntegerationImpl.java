/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.order.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.t.common.util.BeanConvertUtil;
import com.zillionfortune.t.common.util.HttpClientUtil;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.integeration.order.OrderIntegeration;
import com.zillionfortune.t.integeration.order.dto.CreateOrderRequest;
import com.zillionfortune.t.integeration.order.dto.CreateOrderResponse;

/**
 * ClassName: OrderIntegerationImpl <br/>
 * Function: 订单系统服务接口实现. <br/>
 * Date: 2016年12月22日 上午9:33:01 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
@Component
public class OrderIntegerationImpl implements OrderIntegeration {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${order.create.url}")
	private String createOrderUrl;

	/**
	 * @see com.zillionfortune.t.integeration.order.OrderIntegeration#createOrder(com.zillionfortune.t.integeration.order.dto.CreateOrderRequest)
	 */
	@Override
	public CreateOrderResponse createOrder(CreateOrderRequest req) throws Exception {
		log.info("createOrder.req:" + JSON.toJSONString(req));
		// 准备参数
		Map<String, String> paramMap = BeanConvertUtil.beanToMapWithoutNullValueMap(req);
		
		// 发送请求
		String resultJson = HttpClientUtil.sendPostRequest(createOrderUrl, paramMap);
		
		log.info("createOrder.resp:" + resultJson);
		return JsonUtils.json2Object(resultJson, CreateOrderResponse.class);
	}

}
