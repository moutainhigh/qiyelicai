/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.web.controller.order;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.authorizedperson.AuthorizedPersonBiz;
import com.zillionfortune.t.biz.common.ShortMessageBiz;
import com.zillionfortune.t.biz.order.UserReserveOrderBiz;
import com.zillionfortune.t.biz.order.dto.ReserveRequest;
import com.zillionfortune.t.biz.user.UserPasswordBiz;
import com.zillionfortune.t.common.constants.Constants;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.enums.SmsCode;
import com.zillionfortune.t.common.exception.BusinessException;

/**
 * ClassName: UserReserveOrderController <br/>
 * Function: 用户订购产品. <br/>
 * Date: 2016年12月20日 上午9:39:27 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
@Controller
@RequestMapping(value = "/orderservice")
public class UserReserveOrderController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserPasswordBiz userPasswordBiz;
	@Autowired
	private ShortMessageBiz shortMessageBiz;
	@Autowired
	private UserReserveOrderBiz userReserveOrderBiz;
	@Autowired
	private AuthorizedPersonBiz authorizedPersonBiz;
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	/**
	 * reserve:预约订购. <br/>
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value= "/reserve")
	public BaseWebResponse reserve(@RequestBody ReserveRequest vo, HttpServletRequest request) {
		log.info("reserve.req:" + JSON.toJSONString(vo));
		
		BaseWebResponse resp = null;
		
		try {
			//1.===参数校验
			inputParamCheck(vo);
			
			// 2.校验手机号 
			boolean rsFlg = authorizedPersonBiz.verifyAuthorizePersonMobile(vo.getMemberId(), vo.getAuthorizedPersonMobile());
			// 手机号码不正确
			if (!rsFlg) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.AUTHORIZE_PERSON_MOBILE_ERROR.code(), 
						ResultCode.AUTHORIZE_PERSON_MOBILE_ERROR.desc());
				return resp;
			}
			
			//3.验证短信码
			resp = shortMessageBiz.verifyVerificationCode(vo.getAuthorizedPersonMobile(), vo.getSmsCode(), SmsCode.APP_FPP.code());
			if(resp == null || !RespCode.SUCCESS.code().equals(resp.getRespCode())
					|| !ResultCode.SUCCESS.code().equals(resp.getResultCode()) ){
				return resp;
			}
			
			//4.校验交易密码
			resp = userPasswordBiz.verifyTradePassword(vo.getMemberId(), vo.getTradePwd());
			if(resp == null || !RespCode.SUCCESS.code().equals(resp.getRespCode())
					|| !ResultCode.SUCCESS.code().equals(resp.getResultCode()) ){
				return resp;
			}
			
			// 获取登录名 即 操作员手机号
			String operatorId = request.getHeader(Constants.OPERATORID);
			String loginName = redisTemplate.opsForValue().get("username_"+operatorId);
			vo.setOperatorMobile(loginName);
			
			//5.===调用业务服务
			resp = userReserveOrderBiz.reserve(vo);
			
		}catch (BusinessException e){
			log.error(e.getMessage(), e);
            resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.FAIL.code(),
                		e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
		} finally {
			log.info("reserve.resp:" + JSON.toJSONString(resp));
		}
		return resp;
	}
	
	/**
	 * inputParamCheck:请求入参校验. <br/>
	 *
	 * @param vo
	 * @throws BusinessException 
	 */
	private void inputParamCheck(ReserveRequest vo) throws BusinessException {
		if (null == vo) {
			throw new BusinessException("请求对象不能为空");
		}
		if (null == vo.getReserveAmt()) {
			throw new BusinessException("预约金额不能为空");
		}
		if (StringUtils.isBlank(vo.getTradePwd())) {
			throw new BusinessException("交易密码不能为空");
		}
		if (StringUtils.isBlank(vo.getAuthorizedPersonMobile())) {
			throw new BusinessException("被授权人手机号码不能为空");
		}
		if (StringUtils.isBlank(vo.getSmsCode())) {
			throw new BusinessException("验证码不能为空");
		}
		if (StringUtils.isBlank(vo.getProductCode())) {
			throw new BusinessException("productCode不能为空");
		}
	}
}
