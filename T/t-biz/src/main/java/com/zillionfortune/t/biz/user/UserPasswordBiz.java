/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.user;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordModifyRequest;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordRetrieveRequest;

/**
 * ClassName: UserPasswordBiz <br/>
 * Function: 企业会员登录密码、交易密码业务处理. <br/>
 * Date: 2016年12月14日 上午10:56:13 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface UserPasswordBiz {
	
	/**
	 * retrieveLoginPassword:企业会员重置登录密码. <br/>
	 *
	 * @param req
	 * @return
	 */
	public BaseWebResponse retrieveLoginPassword(UserLoginPasswordRetrieveRequest req); 
	
	/**
	 * modifyLoginPassword:企业会员更新登录密码. <br/>
	 *
	 * @param req
	 * @return
	 */
	public BaseWebResponse modifyLoginPassword(UserLoginPasswordModifyRequest req);
	
	/**
	 * retrieveTradePassword:企业会员重置交易密码. <br/>
	 *
	 * @throws 
	 * @param memberId
	 * @param newPassword
	 * @return EnterpriseTradePasswordRetrieveResponse
	 */
	public BaseWebResponse retrieveTradePassword(String memberId,String newPassword);
	
	/**
	 * modifyTradePassword:企业会员更新交易密码. <br/>
	 *
	 * @throws 
	 * @param memberId
	 * @param newPassword
	 * @param orgiPassword
	 * @return EnterpriseTradePasswordModifyResponse
	 */
	public BaseWebResponse modifyTradePassword(String memberId,String newPassword,String orgiPassword);
	
	/**
	 * verifyTradePassword:企业会员验证交易密码. <br/>
	 *
	 * @throws 
	 * @param memberId
	 * @param password
	 * @return EnterpriseTradePasswordVerifyResponse
	 */
	public BaseWebResponse verifyTradePassword(String memberId,String password);
	
	/**
	 * setTradePassword:企业会员设置交易密码. <br/>
	 *
	 * @throws 
	 * @param memberId
	 * @param password
	 * @return EnterpriseTradePasswordSetResponse
	 */
	public BaseWebResponse setTradePassword(String memberId,String password);
}
