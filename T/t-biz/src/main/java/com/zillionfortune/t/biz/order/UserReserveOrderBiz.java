/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.order;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.order.dto.ReserveRequest;

/**
 * ClassName: UserReserveOrderBiz <br/>
 * Function: 用户预约订单. <br/>
 * Date: 2016年12月21日 下午3:31:17 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public interface UserReserveOrderBiz {

	public BaseWebResponse reserve(ReserveRequest req);
}
