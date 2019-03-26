/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif;

import com.zillionfortune.t.integeration.cif.dto.UserAuditRequest;
import com.zillionfortune.t.integeration.cif.dto.UserAuditResponse;


/**
 * ClassName: UserAuditIntegration <br/>
 * Function: 企业会员认证信息审核接口. <br/>
 * Date: 2016年12月27日 下午5:50:17 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public interface UserAuditIntegration {

	/**
	 * audit:企业会员认证信息审核. <br/>
	 *
	 * @param req
	 * @return
	 */
	public UserAuditResponse audit(UserAuditRequest req) throws Exception;
}
