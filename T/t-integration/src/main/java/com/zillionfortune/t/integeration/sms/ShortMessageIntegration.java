/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.integeration.sms;

import com.zillionfortune.t.integeration.sms.dto.ShortMessageServiceRequest;
import com.zillionfortune.t.integeration.sms.dto.ShortMessageServiceResponse;

/**
 * ClassName: ShortMessageIntegration <br/>
 * Function: 短信服务integration. <br/>
 * Date: 2016年12月16日 下午1:55:29 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface ShortMessageIntegration {
	
	/**
	 * send:发送短信. <br/>
	 *
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public ShortMessageServiceResponse send(ShortMessageServiceRequest req) throws Exception;
	
}
