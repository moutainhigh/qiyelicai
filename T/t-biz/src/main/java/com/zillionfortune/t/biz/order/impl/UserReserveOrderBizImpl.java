/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.order.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.common.ShortMessageBiz;
import com.zillionfortune.t.biz.order.UserReserveOrderBiz;
import com.zillionfortune.t.biz.order.dto.ReserveRequest;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.enums.SmsCode;
import com.zillionfortune.t.integeration.cif.UserInfoIntegration;
import com.zillionfortune.t.integeration.order.OrderIntegeration;
import com.zillionfortune.t.integeration.order.dto.CreateOrderRequest;
import com.zillionfortune.t.integeration.order.dto.CreateOrderResponse;

/**
 * ClassName: UserReserveOrderBizImpl <br/>
 * Function: 用户下单 服务实现. <br/>
 * Date: 2016年12月21日 下午3:36:40 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
@Component
public class UserReserveOrderBizImpl implements UserReserveOrderBiz {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Value("${bank.account.name}")
	private String bankAccoutnName;
	@Value("${bank.account.no}")
	private String bankAccountNo;
	@Value("${refister.bank.name}")
	private String registerBankName; // 开户行
	
	@Autowired
	private OrderIntegeration orderIntegeration;
	@Autowired
	private ShortMessageBiz shortMessageBiz;
	@Autowired
	private UserInfoIntegration userInfoIntegration;

	/**
	 * @see com.zillionfortune.t.biz.order.UserReserveOrderBiz#reserve(com.zillionfortune.t.biz.order.dto.ReserveRequest)
	 */
	@Override
	public BaseWebResponse reserve(ReserveRequest req) {
		log.info("reserve.req:" + JSON.toJSONString(req));
		BaseWebResponse resp = null;
		try {
			CreateOrderRequest orderReq = new CreateOrderRequest();
			orderReq.setMemberId(req.getMemberId());
			orderReq.setProductCode(req.getProductCode());
			orderReq.setAmount(req.getReserveAmt());
			orderReq.setAccountsManagerTel(req.getRecommendedMobile());
			
			// 下单
			CreateOrderResponse result = orderIntegeration.createOrder(orderReq);
			if(!RespCode.SUCCESS.code().equals(result.getRespCode()) 
					|| !ResultCode.SUCCESS.code().equals(result.getResultCode()) ) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), result.getResultCode(), result.getResultMsg());
				return resp;
			}
			
			// 预约码发送短信
			resp = shortMessageBiz.sendCommonCode(req.getOperatorMobile(), SmsCode.SEND_APP_FPP_CODE.code(), result.getResCode());
			if(!RespCode.SUCCESS.code().equals(resp.getRespCode()) 
					|| !ResultCode.SUCCESS.code().equals(resp.getResultCode()) ) {
				return resp;
			}
			
			// 处理成功 封装返回结果
			resp = new BaseWebResponse(RespCode.SUCCESS.code(),ResultCode.SUCCESS.code(),ResultCode.SUCCESS.desc());
			Map<String, Object> rsData = new HashMap<String, Object>();
            rsData.put("memberId", req.getMemberId());
            rsData.put("productCode", req.getProductCode());
            // 汇款账户名
            rsData.put("remittanceBankAccountName", new String(bankAccoutnName.getBytes("iso-8859-1"),"utf-8"));
            // 汇款银行账号
            rsData.put("remittanceBankAccountNo", bankAccountNo);
            // 汇款银行
            rsData.put("remittanceBank", new String(registerBankName.getBytes("iso-8859-1"),"utf-8"));
            // 转入预约码
            rsData.put("reserveCode", result.getResCode());
            resp.setData(rsData);
            
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            resp = new BaseWebResponse(RespCode.FAIL.code(),RespCode.FAIL.desc());
		} finally {
			log.info("reserve.resp:" + JSON.toJSONString(resp));
		}
		return resp;
	}

}
