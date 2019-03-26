/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.web.controller.user.check;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.web.controller.user.vo.UserLoginPasswordModifyRequestVo;
import com.zillionfortune.t.web.controller.user.vo.UserLoginPasswordRetrieveRequestVo;
import com.zillionfortune.t.web.controller.user.vo.UserTradePasswordModifyRequestVo;
import com.zillionfortune.t.web.controller.user.vo.UserTradePasswordRetrieveRequestVo;
import com.zillionfortune.t.web.controller.user.vo.UserTradePasswordSetRequestVo;
import com.zillionfortune.t.web.controller.user.vo.UserTradePasswordVerifyRequestVo;

/**
 * ClassName: UserControllerParameterChecker <br/>
 * Function: 企业会员登录密码、交易密码业务 请求参数校验. <br/>
 * Date: 2016年12月15日 上午10:30:47 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class UserPasswordParameterChecker {

	/**
	 * checkUserLoginPasswordRetrieveRequestVo:企业会员重置登录密码业务 请求参数校验. <br/>
	 *
	 * @param vo
	 * @throws Exception
	 */
	public void checkUserLoginPasswordRetrieveRequestVo(UserLoginPasswordRetrieveRequestVo vo)
			throws Exception {
		// 校验请求参数
		if (vo == null) {
			throw new BusinessException("请求对象不能为空");
		}

		if (StringUtils.isBlank(vo.getCustomerNo())
			|| StringUtils.isBlank(vo.getUserName())
			|| StringUtils.isBlank(vo.getNewPassword())
			|| StringUtils.isBlank(vo.getRepeatPwd())) {
			throw new BusinessException("customerNo,userName,newPassword,repeatPwd皆不能为空");
		}
	}

	/**
	 * checkUserLoginPasswordModifyRequest:企业会员更新登录密码业务 请求参数校验. <br/>
	 *
	 * @param req
	 * @throws Exception
	 */
	public void checkUserLoginPasswordModifyRequest(UserLoginPasswordModifyRequestVo vo) throws Exception {
		// 校验请求参数
		if (vo == null) {
			throw new BusinessException("请求对象不能为空");
		}

		if (StringUtils.isBlank(vo.getMemberId())
			|| StringUtils.isBlank(vo.getOperatorId())
			|| StringUtils.isBlank(vo.getOrgiPassword())
			|| StringUtils.isBlank(vo.getNewPassword())
			|| StringUtils.isBlank(vo.getRepeatPwd())) {
			throw new BusinessException("memberId,operatorId,orgiPassword,newPassword,repeatPwd字段皆不能为空");
		}
	}
	
	/**
	 * checkUserTradePasswordRetrieveRequest:企业会员重置交易密码业务 请求参数校验. <br/>
	 *
	 * @param req
	 * @throws Exception
	 */
	public void checkUserTradePasswordRetrieveRequest(UserTradePasswordRetrieveRequestVo vo) throws Exception {
		// 校验请求参数
		if (vo == null) {
			throw new BusinessException("请求对象不能为空");
		}

		if (StringUtils.isBlank(vo.getMemberId())
			|| StringUtils.isBlank(vo.getNewPassword())
			|| StringUtils.isBlank(vo.getRepeatPwd())) {
			throw new BusinessException("memberId,newPassword,repeatPwd字段皆不能为空");
		}
	}
	
	/**
	 * checkUserTradePasswordModifyRequest:企业会员更新交易密码业务 请求参数校验. <br/>
	 *
	 * @param req
	 * @throws Exception
	 */
	public void checkUserTradePasswordModifyRequest(UserTradePasswordModifyRequestVo vo) throws Exception {
		// 校验请求参数
		if (vo == null) {
			throw new BusinessException("请求对象不能为空");
		}

		if (StringUtils.isBlank(vo.getMemberId())
			|| StringUtils.isBlank(vo.getNewPassword())
			|| StringUtils.isBlank(vo.getRepeatPwd())
			|| StringUtils.isBlank(vo.getOrgiPassword())) {
			throw new BusinessException("memberId,newPassword,orgiPassword,repeatPwd字段皆不能为空");
		}
	}
	
	/**
	 * checkUserTradePasswordVerifyRequest:企业会员验证交易密码业务 请求参数校验. <br/>
	 *
	 * @param req
	 * @throws Exception
	 */
	public void checkUserTradePasswordVerifyRequest(UserTradePasswordVerifyRequestVo vo) throws Exception {
		// 校验请求参数
		if (vo == null) {
			throw new BusinessException("请求对象不能为空");
		}

		if (StringUtils.isBlank(vo.getMemberId())
			|| StringUtils.isBlank(vo.getPassword())) {
			throw new BusinessException("memberId,password字段皆不能为空");
		}
	}
	
	/**
	 * checkUserTradePasswordSetRequest:企业会员设置交易密码业务 请求参数校验. <br/>
	 *
	 * @param req
	 * @throws Exception
	 */
	public void checkUserTradePasswordSetRequest(UserTradePasswordSetRequestVo vo) throws Exception {
		// 校验请求参数
		if (vo == null) {
			throw new BusinessException("请求对象不能为空");
		}

		if (StringUtils.isBlank(vo.getMemberId())
			|| StringUtils.isBlank(vo.getPassword())
			|| StringUtils.isBlank(vo.getRepeatPwd())) {
			throw new BusinessException("memberId,password,repeatPwd字段皆不能为空");
		}
	}

}
