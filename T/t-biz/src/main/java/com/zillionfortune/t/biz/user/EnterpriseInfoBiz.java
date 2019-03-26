/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.user;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoQueryRequest;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoUpdateRequest;

/**
 * ClassName: EnterpriseServiceFacade <br/>
 * Function: 企业会员信息查询接口. <br/>
 * Date: 2016年12月19日 下午5:15:39 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface EnterpriseInfoBiz {
	
	/**
	 * query:企业会员信息查询. <br/>
	 *
	 * @param req EnterpriseExtInfoQueryRequest
	 * @return BaseWebResponse
	 */
	public BaseWebResponse enterpriseInfoQuery(EnterpriseExtInfoQueryRequest req);
	
	
	/**
	 * enterpriseContactInfoUpdate:企业会员联系信息更新. <br/>
	 *
	 * @param req EnterpriseExtInfoUpdateRequest
	 * @return BaseWebResponse
	 */
	public BaseWebResponse enterpriseInfoUpdate(EnterpriseExtInfoUpdateRequest req);
	
	/**
	 * findBankAccountNo:企业银行账户是否已存在. <br/>
	 *
	 * @param bankAccountNo
	 * @return
	 */
	public boolean findBankAccountNo(String bankAccountNo) throws Exception;
	
	

}
