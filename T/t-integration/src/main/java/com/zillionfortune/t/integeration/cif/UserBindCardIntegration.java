/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif;

import com.zillionfortune.t.integeration.cif.dto.BindCardQueryResponse;
import com.zillionfortune.t.integeration.cif.dto.BindCardRequest;
import com.zillionfortune.t.integeration.cif.dto.BindCardResponse;
import com.zillionfortune.t.integeration.cif.dto.FindBankAccountNoResponse;


/**
 * ClassName: UserBindCardIntegration <br/>
 * Function: 企业会员绑定银行账户接口. <br/>
 * Date: 2016年12月13日 下午6:38:36 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public interface UserBindCardIntegration {

	/**
	 * bindCard:企业会员绑定银行账户. <br/>
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public BindCardResponse bindCard(BindCardRequest req) throws Exception;
	
	/**
	 * unBindCard:企业会员解绑银行账户. <br/>
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public BindCardResponse unBindCard(BindCardRequest req) throws Exception;
	
	/**
	 * queryEnterpriseBindCard:企业会员查询已绑定银行账户. <br/>
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public BindCardQueryResponse queryEnterpriseBindCard(BindCardRequest req) throws Exception;
	
	/**
	 * findBankAccountNo: 查找银行账号是否存在. <br/>
	 *
	 * @param bankAccountNo
	 * @return
	 */
	public FindBankAccountNoResponse findBankAccountNo(String bankAccountNo) throws Exception;
}
