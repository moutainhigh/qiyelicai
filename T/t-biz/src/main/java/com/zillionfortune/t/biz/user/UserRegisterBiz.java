/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.biz.user;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.integeration.cif.dto.UserCheckRequest;
import com.zillionfortune.t.integeration.cif.dto.UserRegisterRequest;

/**
 * ClassName: UserRegisterBiz <br/>
 * Function: 企业会员注册接口. <br/>
 * Date: 2016年12月13日 下午6:20:59 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface UserRegisterBiz {
	
	/**
	 * register:企业注册. <br/>
	 *
	 * @param req
	 * @return BaseWebResponse
	 * @throws 
	 */
	public BaseWebResponse register(UserRegisterRequest req);
	
	/**
	 * checkEnterpriseExists:企业注册根据证件类型证件号码校验企业是否存在. <br/>
	 *
	 * @param req
	 * @return BaseWebResponse
	 * @throws 
	 */
	public BaseWebResponse checkEnterpriseExists(UserCheckRequest req);
	
}
