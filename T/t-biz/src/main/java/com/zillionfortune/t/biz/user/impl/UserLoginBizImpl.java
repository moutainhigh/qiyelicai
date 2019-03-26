/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.user.impl;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.user.UserLoginBiz;
import com.zillionfortune.t.common.enums.CheckStatus;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.common.util.JsonUtils;
import com.zillionfortune.t.common.util.VerifyCodeUtils;
import com.zillionfortune.t.dal.entity.AuthorizedPerson;
import com.zillionfortune.t.dto.CheckVerifyCodeRequest;
import com.zillionfortune.t.dto.GenerateVerifyCodeRequest;
import com.zillionfortune.t.dto.LoginCodeRequest;
import com.zillionfortune.t.integeration.cif.UserLoginIntegration;
import com.zillionfortune.t.integeration.cif.dto.LoginAuthCifResponse;
import com.zillionfortune.t.integeration.cif.dto.LoginAuthRequest;
import com.zillionfortune.t.integeration.cif.dto.LoginCifResponse;
import com.zillionfortune.t.integeration.cif.dto.LoginOutCifResponse;
import com.zillionfortune.t.integeration.cif.dto.LoginOutRequest;
import com.zillionfortune.t.integeration.cif.dto.LoginRequest;
import com.zillionfortune.t.service.AuthorizedPersonService;

/**
 * ClassName: UserLoginServiceFacadeImpl <br/>
 * Function: 企业_会员登录接口_实现. <br/>
 * Date: 2016年11月15日 下午5:01:18 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version
 * @since JDK 1.7
 */
@Service
public class UserLoginBizImpl implements UserLoginBiz {

	private static Logger log = LoggerFactory.getLogger(UserLoginBizImpl.class);
	
	@Autowired
	UserLoginIntegration userLoginIntegration;
	
	@Autowired
	AuthorizedPersonService authorizedPersonService;
	
	@Autowired
	RedisTemplate<String, String> redisTemplate;
	
    
	/**
	 * 登录.
	 * @see com.zillionfortune.t.biz.user.UserLoginBiz#login(com.zillionfortune.t.integeration.cif.dto.LoginRequest)
	 */
	@Override
	public BaseWebResponse login(LoginRequest loginReq) {
		log.info("UserLoginBizImpl.login.req:" + JsonUtils.object2Json(loginReq));

		BaseWebResponse resp = null;
		LoginCifResponse loginCifResponse = null;
		LoginAuthRequest authReq = null;
		LoginAuthCifResponse authCifResp = null;
		try {
			//=========登入
			//登入
			loginCifResponse = userLoginIntegration.login(loginReq);
			//判断登入是否成功
			if (!(RespCode.SUCCESS.code()).equals(loginCifResponse.getRespCode())
					|| !(ResultCode.SUCCESS.code()).equals(loginCifResponse.getResultCode())) {
				resp = new BaseWebResponse(loginCifResponse.getRespCode(),loginCifResponse.getResultCode(),loginCifResponse.getResultMsg());
				log.info("UserLoginBizImpl.login.resp:" + JsonUtils.object2Json(resp));
				return resp;
			}
			
			//=========鉴权
			//鉴权
			authReq = new LoginAuthRequest( loginCifResponse.getMemberId(), loginCifResponse.getOperatorId(), loginCifResponse.getAccessToken() );
			authCifResp = userLoginIntegration.auth(authReq);
			//判断鉴权是否成功
			if (!(RespCode.SUCCESS.code()).equals(authCifResp.getRespCode())
					|| !(ResultCode.SUCCESS.code()).equals(authCifResp.getResultCode())) {
				if(authCifResp.getResultCode().equals("9008")){
					authCifResp.setResultCode(ResultCode.AUTH_FAIL.code());
				}
				resp = new BaseWebResponse(authCifResp.getRespCode(),authCifResp.getResultCode(),authCifResp.getResultMsg());
				log.info("UserLoginBizImpl.login.resp:" + JsonUtils.object2Json(resp));
				return resp;
			}
			
			// 查授权人信息
			AuthorizedPerson authorizedPerson = authorizedPersonService.selectByMemberIdAndStatus(loginCifResponse.getMemberId(), CheckStatus.CHECK_PASS_REVIEW_PASS.code());
			String authorizedMobile = null;
			if(authorizedPerson!=null ){
				authorizedMobile = authorizedPerson.getMobile();
			}
			
			// 存userName值
			redisTemplate.opsForValue().set("username_"+loginCifResponse.getOperatorId(), loginReq.getLoginName());
			
			//组装响应对象
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			Map<String,String> respMap = new HashMap<String,String>();
			respMap.put("memberId", loginCifResponse.getMemberId());
			respMap.put("operatorId", loginCifResponse.getOperatorId());
			respMap.put("accessToken", loginCifResponse.getAccessToken());
			respMap.put("enterperseName", authCifResp.getEnterperseName());
			respMap.put("mobile", authCifResp.getMobile());//操作员手机号
			respMap.put("authorizedPersonMobile", authorizedMobile);//被授权人手机号
			respMap.put("authStatus", authCifResp.getAuthStatus());//会员认证状态,0：待认证；1：认证中；2：认证失败；3：已认证
			resp.setData(respMap);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				BusinessException be = (BusinessException) e;
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),be.getMessage());
            } else {
            	resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
		}
		
		log.info("UserLoginBizImpl.login.resp:" + JsonUtils.object2Json(resp));
		
		return resp;
	}
	
	/**
	 * 登录鉴权.
	 * @see com.zillionfortune.t.biz.user.UserLoginBiz#auth(com.zillionfortune.t.integeration.cif.dto.LoginAuthRequest)
	 */
	@Override
	public BaseWebResponse auth(LoginAuthRequest req) {
		BaseWebResponse resp = null;
		LoginAuthCifResponse authCifResp = null;
		try {
			// 执行登入鉴权
			authCifResp = userLoginIntegration.auth(req);
			// 判断是否调用成功
			if (!(RespCode.SUCCESS.code()).equals(authCifResp.getRespCode())
					|| !(ResultCode.SUCCESS.code()).equals(authCifResp.getResultCode())) {
				if(authCifResp.getResultCode().equals("9008")){
					authCifResp.setResultCode(ResultCode.AUTH_FAIL.code());
				}
				resp = new BaseWebResponse(authCifResp.getRespCode(),authCifResp.getResultCode(),authCifResp.getResultMsg());
				log.info("UserLoginBizImpl.auth.resp:" + JsonUtils.object2Json(resp));
				return resp;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				BusinessException be = (BusinessException) e;
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),be.getMessage());
            } else {
            	resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
		}
		resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
		resp.setData(authCifResp);
		return resp;
	}

	/**
	 * 登出.
	 * @see com.zillionfortune.t.biz.user.UserLoginBiz#loginout(com.zillionfortune.t.integeration.cif.dto.LoginOutRequest)
	 */
	@Override
	public BaseWebResponse loginout(LoginOutRequest loutReq) {
		log.info("UserLoginBizImpl.loginout.req:" + JsonUtils.object2Json(loutReq));
		
		BaseWebResponse resp = null;
		LoginOutCifResponse loutCifresp = null;
		try {
			//登出
			loutCifresp = userLoginIntegration.loginout(loutReq);
			
			//判断登入鉴权请求是否成功
			if (!(RespCode.SUCCESS.code()).equals(loutCifresp.getRespCode())
					|| !(ResultCode.SUCCESS.code()).equals(loutCifresp.getResultCode())) {
				if(loutCifresp.getResultCode().equals("9008")){
					loutCifresp.setResultCode(ResultCode.AUTH_FAIL.code());
				}
				resp = new BaseWebResponse(loutCifresp.getRespCode(),loutCifresp.getResultCode(),loutCifresp.getResultMsg());
				log.info("UserLoginBizImpl.loginout.resp:" + JsonUtils.object2Json(resp));
				return resp;
			}
			
			// 删除userName值（redis）
			if(StringUtils.isNotEmpty(loutCifresp.getOperatorId())){
				redisTemplate.delete("username_" + loutCifresp.getOperatorId());
			}
			
			//组装响应对象
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			Map<String,String> respMap = new HashMap<String,String>();
			respMap.put("memberId", loutCifresp.getMemberId());
			respMap.put("operatorId", loutCifresp.getOperatorId());
			resp.setData(respMap);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				BusinessException be = (BusinessException) e;
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),be.getMessage());
            } else {
            	resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
		}
		
		log.info("UserLoginBizImpl.loginout.resp:" + JsonUtils.object2Json(resp));
		
		return resp;
	}

	/**
	 * 获取验证码Token.
	 * @see com.zillionfortune.t.biz.user.UserLoginBiz#getLoginCode(com.zillionfortune.t.dto.GenerateVerifyCodeRequest)
	 */
	@Override
	public BaseWebResponse getLoginCode(LoginCodeRequest req) {
		log.info("UserLoginBizImpl.getLoginCode.req:" + JsonUtils.object2Json(req));
		
		BaseWebResponse resp = null;
		try {
			//设置verifySize默认值
			int verifySize = req.getVerifySize();
			if(verifySize==0){
				verifySize = 4;
			}
			
			//生成指定长度的验证码
			String verifyCode = VerifyCodeUtils.generateVerifyCode(verifySize);
			
			//存储验证码字符串,过期时间为1分钟
//			String encCode = DesUtil.strEnc(verifyCode+"_"+System.currentTimeMillis(), "1", "2", "3");
			String encCode = verifyCode+"_"+System.currentTimeMillis();
			redisTemplate.opsForValue().set(encCode, verifyCode);
			redisTemplate.expire(encCode, 5, TimeUnit.MINUTES);
			
			//组装响应对象
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			Map<String,String> respMap = new HashMap<String,String>();
			respMap.put("encCode", encCode);
			resp.setData(respMap);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				BusinessException be = (BusinessException) e;
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),be.getMessage());
            } else {
            	resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
		}
		
		log.info("UserLoginBizImpl.getLoginCode.resp:" + JsonUtils.object2Json(resp));
		return resp;
	}
	
	/**
	 * 获取验证码图片.
	 * @see com.zillionfortune.t.biz.user.UserLoginBiz#getLoginCodeImage(com.zillionfortune.t.dto.GenerateVerifyCodeRequest, java.io.OutputStream)
	 */
	@Override
	public void getLoginCodeImage(GenerateVerifyCodeRequest req, OutputStream os) {
		log.info("UserLoginBizImpl.getLoginCodeImage.req:" + JsonUtils.object2Json(req));
		
		BaseWebResponse resp = null;
		
		try {
			//校验请求参数
			if(StringUtils.isBlank(req.getCodeAuth())){
				throw new Exception("图片验证码token为空或过期！");
			}
			
			//生成图片验证码
			String verifyCode = redisTemplate.opsForValue().get(req.getCodeAuth());
			//生成验证码图片
			VerifyCodeUtils.outputImage(req.getWidth(), req.getHeight(), os, verifyCode);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		log.info("UserLoginBizImpl.getLoginCodeImage.resp:" + JsonUtils.object2Json(resp));
	}

	/**
	 * 校验图片验证码.
	 * @see com.zillionfortune.t.biz.user.UserLoginBiz#checkLoginCode(com.zillionfortune.t.dto.CheckVerifyCodeRequest)
	 */
	@Override
	public BaseWebResponse checkLoginCode(CheckVerifyCodeRequest req) {
		log.info("UserLoginBizImpl.checkLoginCode.req:" + JsonUtils.object2Json(req));
		
		BaseWebResponse resp = null;
		boolean bl = false;
		try {
			//校验请求参数
			if(StringUtils.isBlank(req.getVerifyCode())){
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.PIC_VERIFY_CODE_NULL.code(),ResultCode.PIC_VERIFY_CODE_NULL.desc());
				log.info("UserLoginBizImpl.checkLoginCode.resp:" + JsonUtils.object2Json(resp));
				return resp;
			}
			if(StringUtils.isBlank(req.getCodeAuth())){
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.PIC_VERIFY_CODE_TOKEN_NULL.code(),ResultCode.PIC_VERIFY_CODE_TOKEN_NULL.desc());
				log.info("UserLoginBizImpl.checkLoginCode.resp:" + JsonUtils.object2Json(resp));
				return resp;
			}
			
			//获取会话session信息
			String verifyCodeN = redisTemplate.opsForValue().get(req.getCodeAuth());
			
			//校验验证码(忽略大小写)
			if(req.getVerifyCode().equalsIgnoreCase(verifyCodeN)){
				bl = true;
			}else{
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.PIC_VERIFY_CODE_ERROR.code(),ResultCode.PIC_VERIFY_CODE_ERROR.desc());
				log.info("UserLoginBizImpl.checkLoginCode.resp:" + JsonUtils.object2Json(resp));
				return resp;
			}
			
			//组装响应对象
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				BusinessException be = (BusinessException) e;
				resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),be.getMessage());
            } else {
            	resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
            }
		}
		
		Map<String,Boolean> respMap = new HashMap<String,Boolean>();
		respMap.put("result", bl);
		resp.setData(respMap);
		
		log.info("UserLoginBizImpl.checkLoginCode.resp:" + JsonUtils.object2Json(resp) );
		
		return resp;
	}
	
}
