/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif;

import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordModifyCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordModifyRequest;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordRetrieveCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordRetrieveRequest;
import com.zillionfortune.t.integeration.cif.dto.UserTradePasswordModifyCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserTradePasswordRetrieveCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserTradePasswordSetCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserTradePasswordVerifyCifResponse;

/**
 * ClassName: UserPasswordIntegration <br/>
 * Function: 企业会员登录密码、交易密码服务. <br/>
 * Date: 2016年12月15日 下午3:43:22 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface UserPasswordIntegration {
	
	/**
	 * retrieveLoginPassword:企业会员重置登录密码. <br/>
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public UserLoginPasswordRetrieveCifResponse retrieveLoginPassword(UserLoginPasswordRetrieveRequest req) throws Exception;
	
	/**
	 * modifyLoginPassword:企业会员更新登录密码. <br/>
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public UserLoginPasswordModifyCifResponse modifyLoginPassword(UserLoginPasswordModifyRequest req) throws Exception;
	
	/**
	 * retrieveTradePassword:企业会员重置交易密码. <br/>
	 *
	 * @param memberId
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	public UserTradePasswordRetrieveCifResponse retrieveTradePassword(String memberId,String newPassword) throws Exception;
	
	/**
	 * modifyTradePassword:企业会员更新交易密码. <br/>
	 *
	 * @param memberId
	 * @param newPassword
	 * @param orgiPassword
	 * @return
	 * @throws Exception
	 */
	public UserTradePasswordModifyCifResponse modifyTradePassword(String memberId,String newPassword,String orgiPassword) throws Exception;
	
	/**
	 * verifyTradePassword:企业会员验证交易密码. <br/>
	 *
	 * @param memberId
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public UserTradePasswordVerifyCifResponse verifyTradePassword(String memberId,String password) throws Exception;
	
	/**
	 * setTradePassword:企业会员设置交易密码. <br/>
	 *
	 * @param memberId
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public UserTradePasswordSetCifResponse setTradePassword(String memberId,String password) throws Exception;
	
}
