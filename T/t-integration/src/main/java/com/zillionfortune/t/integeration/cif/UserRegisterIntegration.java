/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.integeration.cif;

import com.zillionfortune.t.integeration.cif.dto.CheckUserNameRegisterCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserCheckExistsCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserCheckRequest;
import com.zillionfortune.t.integeration.cif.dto.UserInfoUpdateCifRequest;
import com.zillionfortune.t.integeration.cif.dto.UserInfoUpdateCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserRegisterCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserRegisterRequest;

/**
 * ClassName: UserRegisterIntegration <br/>
 * Function:用户注册integration. <br/>
 * Date: 2016年12月16日 下午1:54:56 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface UserRegisterIntegration {
	
	/**
	 * register:企业用户注册. <br/>
	 *
	 * @throws 
	 * @param req
	 * @return UserRegisterResponse
	 */
	public UserRegisterCifResponse register(UserRegisterRequest req) throws Exception;
	
	/**
	 * register:企业注册根据证件类型证件号码校验企业是否存在. <br/>
	 *
	 * @throws 
	 * @param req
	 * @return UserCheckExistsCifResponse
	 */
	public UserCheckExistsCifResponse checkEnterpriseExists(UserCheckRequest req) throws Exception;
	
	/**
	 * enterpriseInfoUpdate:企业用户信息更新. <br/>
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public UserInfoUpdateCifResponse enterpriseInfoUpdate(UserInfoUpdateCifRequest req) throws Exception;
	
	/**
	 * CheckUserNameRegister:验证登录名是否注册过. <br/>
	 *
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public CheckUserNameRegisterCifResponse checkUserNameRegister(String mobile) throws Exception;
}
