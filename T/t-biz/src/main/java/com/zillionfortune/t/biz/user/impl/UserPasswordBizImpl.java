/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.user.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.user.UserPasswordBiz;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.integeration.cif.UserPasswordIntegration;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordModifyCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordModifyRequest;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordRetrieveCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordRetrieveRequest;
import com.zillionfortune.t.integeration.cif.dto.UserTradePasswordModifyCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserTradePasswordRetrieveCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserTradePasswordSetCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserTradePasswordVerifyCifResponse;

/**
 * ClassName: UserPasswordBizImpl <br/>
 * Function: 企业会员登录密码、交易密码业务处理. <br/>
 * Date: 2016年12月7日 上午10:04:10 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class UserPasswordBizImpl implements UserPasswordBiz {

	private static Logger log = LoggerFactory.getLogger(UserPasswordBizImpl.class);
	
	@Autowired
	private UserPasswordIntegration userPasswordIntegration;

	/**
	 * 企业会员重置登录密码.
	 * @see com.zillionfortune.t.biz.user.UserPasswordBiz#retrieveLoginPassword(com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordRetrieveRequest)
	 */
	@Override
	public BaseWebResponse retrieveLoginPassword(UserLoginPasswordRetrieveRequest req) {
		log.info("UserPasswordBizImpl.retrieveLoginPassword.req:" + JSON.toJSONString(req));

		BaseWebResponse resp = null;

		UserLoginPasswordRetrieveCifResponse cifResp;

		try {
			// 调用cif企业会员重置登录密码服务
			cifResp = userPasswordIntegration.retrieveLoginPassword(req);

			if (cifResp != null 
					&& RespCode.SUCCESS.code().equals(cifResp.getRespCode())
					&& ResultCode.SUCCESS.code().equals(cifResp.getResultCode())) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.SUCCESS.code(), ResultCode.SUCCESS.desc());
				
				Map<String,String> respMap = new HashMap<String,String>();
				respMap.put("memberId", cifResp.getMemberId());
				resp.setData(respMap);
			} else {
				resp = new BaseWebResponse(cifResp.getRespCode(), cifResp.getResultCode(), cifResp.getResultMsg());
				return resp;
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());
		} finally {
			log.info("UserPasswordBizImpl.retrieveLoginPassword.resp:" + JSON.toJSONString(resp));
		}

		return resp;
	}

	/**
	 * 企业会员更新登录密码.
	 * @see com.zillionfortune.t.biz.user.UserPasswordBiz#modifyLoginPassword(com.zillionfortune.t.integeration.cif.dto.UserLoginPasswordModifyRequest)
	 */
	@Override
	public BaseWebResponse modifyLoginPassword(UserLoginPasswordModifyRequest req) {
		log.info("UserPasswordBizImpl.modifyLoginPassword.req:" + JSON.toJSONString(req));

		BaseWebResponse resp = null;

		UserLoginPasswordModifyCifResponse cifResp;

		try {
			// 调用cif企业会员更新登录密码服务
			cifResp = userPasswordIntegration.modifyLoginPassword(req);

			if (cifResp != null 
					&& RespCode.SUCCESS.code().equals(cifResp.getRespCode())
					&& ResultCode.SUCCESS.code().equals(cifResp.getResultCode())) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.SUCCESS.code(), ResultCode.SUCCESS.desc());
				
				Map<String,String> respMap = new HashMap<String,String>();
				respMap.put("memberId", cifResp.getMemberId());
				resp.setData(respMap);
			} else {
				resp = new BaseWebResponse(cifResp.getRespCode(), cifResp.getResultCode(), cifResp.getResultMsg());
				return resp;
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);

			resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());
		} finally {
			log.info("UserPasswordBizImpl.modifyLoginPassword.resp:" + JSON.toJSONString(resp));
		}

		return resp;
	}

	/**
	 * 企业会员重置交易密码.
	 * @see com.zillionfortune.t.biz.user.UserPasswordBiz#retrieveTradePassword(java.lang.String, java.lang.String)
	 */
	@Override
	public BaseWebResponse retrieveTradePassword(String memberId, String newPassword) {
		log.info("UserPasswordBizImpl.retrieveTradePassword.req:{memberId:" + memberId + "newPassword:" + newPassword + "}" );

		BaseWebResponse resp = null;

		UserTradePasswordRetrieveCifResponse cifResp;

		try {
			// 调用cif企业会员重置交易密码服务
			cifResp = userPasswordIntegration.retrieveTradePassword(memberId, newPassword);

			if (cifResp != null 
					&& RespCode.SUCCESS.code().equals(cifResp.getRespCode())
					&& ResultCode.SUCCESS.code().equals(cifResp.getResultCode())) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.SUCCESS.code(), ResultCode.SUCCESS.desc());
				
				Map<String,String> respMap = new HashMap<String,String>();
				respMap.put("memberId", cifResp.getMemberId());
				resp.setData(respMap);
			} else {
				resp = new BaseWebResponse(cifResp.getRespCode(), cifResp.getResultCode(), cifResp.getResultMsg());
				return resp;
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);

			resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());
		} finally {
			log.info("UserPasswordBizImpl.retrieveTradePassword.resp:" + JSON.toJSONString(resp));
		}

		return resp;
	}

	/**
	 * 企业会员更新交易密码.
	 * @see com.zillionfortune.t.biz.user.UserPasswordBiz#modifyTradePassword(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public BaseWebResponse modifyTradePassword(String memberId, String newPassword, String orgiPassword) {
		log.info("UserPasswordBizImpl.modifyTradePassword.req:{memberId:" + memberId + "newPassword:" + newPassword + "orgiPassword:" + orgiPassword + "}" );

		BaseWebResponse resp = null;

		UserTradePasswordModifyCifResponse cifResp;

		try {
			// 调用cif企业会员更新交易密码服务
			cifResp = userPasswordIntegration.modifyTradePassword(memberId, newPassword, orgiPassword);

			if (cifResp != null 
					&& RespCode.SUCCESS.code().equals(cifResp.getRespCode())
					&& ResultCode.SUCCESS.code().equals(cifResp.getResultCode())) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.SUCCESS.code(), ResultCode.SUCCESS.desc());
				
				Map<String,String> respMap = new HashMap<String,String>();
				respMap.put("memberId", cifResp.getMemberId());
				resp.setData(respMap);
			} else {
				resp = new BaseWebResponse(cifResp.getRespCode(), cifResp.getResultCode(), cifResp.getResultMsg());
				return resp;
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);

			resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());
		} finally {
			log.info("UserPasswordBizImpl.modifyTradePassword.resp:" + JSON.toJSONString(resp));
		}

		return resp;
	}

	/**
	 * 企业会员验证交易密码.
	 * @see com.zillionfortune.t.biz.user.UserPasswordBiz#verifyTradePassword(java.lang.String, java.lang.String)
	 */
	@Override
	public BaseWebResponse verifyTradePassword(String memberId, String password) {
		log.info("UserPasswordBizImpl.verifyTradePassword.req:{memberId:" + memberId + "password:" + password + "}" );

		BaseWebResponse resp = null;

		UserTradePasswordVerifyCifResponse cifResp;

		try {
			// 调用cif企业会员验证交易密码服务
			cifResp = userPasswordIntegration.verifyTradePassword(memberId, password);

			if (cifResp != null 
					&& RespCode.SUCCESS.code().equals(cifResp.getRespCode())
					&& ResultCode.SUCCESS.code().equals(cifResp.getResultCode())) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.SUCCESS.code(), ResultCode.SUCCESS.desc());
				
				Map<String,String> respMap = new HashMap<String,String>();
				respMap.put("memberId", cifResp.getMemberId());
				resp.setData(respMap);
			} else {
				resp = new BaseWebResponse(cifResp.getRespCode(), cifResp.getResultCode(), cifResp.getResultMsg());
				return resp;
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);

			resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());
		} finally {
			log.info("UserPasswordBizImpl.verifyTradePassword.resp:" + JSON.toJSONString(resp));
		}

		return resp;
	}

	/**
	 * 企业会员设置交易密码.
	 * @see com.zillionfortune.t.biz.user.UserPasswordBiz#setTradePassword(java.lang.String, java.lang.String)
	 */
	@Override
	public BaseWebResponse setTradePassword(String memberId, String password) {
		log.info("UserPasswordBizImpl.setTradePassword.req:{memberId:" + memberId + "password:" + password + "}" );

		BaseWebResponse resp = null;

		UserTradePasswordSetCifResponse cifResp;

		try {
			// 调用cif企业会员设置交易密码服务
			cifResp = userPasswordIntegration.setTradePassword(memberId, password);

			if (cifResp != null 
					&& RespCode.SUCCESS.code().equals(cifResp.getRespCode())
					&& ResultCode.SUCCESS.code().equals(cifResp.getResultCode())) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.SUCCESS.code(), ResultCode.SUCCESS.desc());
				
				Map<String,String> respMap = new HashMap<String,String>();
				respMap.put("memberId", cifResp.getMemberId());
				resp.setData(respMap);
			} else {
				resp = new BaseWebResponse(cifResp.getRespCode(), cifResp.getResultCode(), cifResp.getResultMsg());
				return resp;
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);

			resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());
		} finally {
			log.info("UserPasswordBizImpl.setTradePassword.resp:" + JSON.toJSONString(resp));
		}

		return resp;
	}

}
