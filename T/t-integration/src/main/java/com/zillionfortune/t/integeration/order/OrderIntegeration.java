/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.order;

import com.zillionfortune.t.integeration.order.dto.CreateOrderRequest;
import com.zillionfortune.t.integeration.order.dto.CreateOrderResponse;

/**
 * ClassName: OrderIntegeration <br/>
 * Function: 订单系统服务接口. <br/>
 * Date: 2016年12月22日 上午9:26:50 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public interface OrderIntegeration {

	/**
	 * createOrder:创建订单_. <br/>
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public CreateOrderResponse createOrder(CreateOrderRequest req) throws Exception;
}
