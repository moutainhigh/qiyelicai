/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif;

import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoQueryCifResponse;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoQueryRequest;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoUpdateCifResponse;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoUpdateRequest;

/**
 * ClassName: UserInfoIntegration <br/>
 * Function: 企业用户信息服务接口. <br/>
 * Date: 2016年12月19日 下午6:56:35 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface UserInfoIntegration {
	
	/**
	 * query:企业会员信息查询. <br/>
	 *
	 * @param req EnterpriseExtInfoQueryRequest
	 * @return EnterpriseExtInfoQueryCifResponse
	 */
	public EnterpriseExtInfoQueryCifResponse enterpriseQueryInfo(EnterpriseExtInfoQueryRequest req) throws Exception;
	
	
	/**
	 * enterpriseContactInfoUpdate:企业会员联系信息更新. <br/>
	 *
	 * @param req EnterpriseExtInfoUpdateRequest
	 * @return EnterpriseExtInfoUpdateCifResponse
	 */
	public EnterpriseExtInfoUpdateCifResponse enterpriseInfoUpdate(EnterpriseExtInfoUpdateRequest req) throws Exception;
	

}
