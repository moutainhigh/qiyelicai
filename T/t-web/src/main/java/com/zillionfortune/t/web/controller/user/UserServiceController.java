/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.web.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.user.UserServiceBiz;
import com.zillionfortune.t.biz.user.dto.UserAuthRequest;
import com.zillionfortune.t.biz.user.dto.UserRiskAsessmentRequest;
import com.zillionfortune.t.common.enums.GradeType;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.common.exception.BusinessException;
import com.zillionfortune.t.integeration.cif.dto.UserGradeRequest;
import com.zillionfortune.t.web.controller.user.check.UserServiceParameterChecker;
import com.zillionfortune.t.web.controller.user.vo.UserAuthRequestVo;
import com.zillionfortune.t.web.controller.user.vo.UserQueryRiskGradeRequestVo;
import com.zillionfortune.t.web.controller.user.vo.UserRiskAsessmentRequestVo;

/**
 * ClassName: UserServiceController <br/>
 * Function: 企业相关服务Controller. <br/>
 * Date: 2016年12月21日 上午9:52:17 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Controller
@RequestMapping(value = "/enterpriseservice")
public class UserServiceController {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserServiceBiz userServiceBiz;
    
    @Autowired
	private UserServiceParameterChecker parameterChecker;
    
    /**
     * auth:企业会员身份验证. <br/>
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    @ResponseBody
    public BaseWebResponse auth(@RequestBody UserAuthRequestVo vo) {
    	
    	log.info("UserServiceController.auth.req:" + vo);
    	
    	BaseWebResponse resp;
    	try {
    		// step1: 参数校验
			parameterChecker.checkUserAuthRequestVo(vo);
			
			// step2: 参数对象封装
			UserAuthRequest req = new UserAuthRequest();
			req.setMemberId(vo.getMemberId()); // 会员Id
			req.setCertificateNo(vo.getCertificateNo()); // 营业执照号/统一社会信用代码号
			req.setLegalPersonCertificateNo(vo.getLegalPersonCertificateNo()); // 法定代表人/负责人身份证号
			
	    	// step3： 企业会员身份认证处理
	    	resp = userServiceBiz.auth(req);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.FAIL.code(), e.getMessage());
			} else {
				resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());
			}
		}
    	
    	log.info("UserServiceController.auth.resp:" + JSON.toJSONString(resp));
    	return resp;
    }
    
    /**
     * queryRiskGrade:风险等级查询. <br/>
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "/riskgradequery", method = RequestMethod.POST)
    @ResponseBody
    public BaseWebResponse queryRiskGrade(@RequestBody UserQueryRiskGradeRequestVo vo) {
    	
    	log.info("UserServiceController.queryRiskGrade.req:" + vo);
    	
    	BaseWebResponse resp;
    	try {
    		// step1: 参数校验
			parameterChecker.checkUserQueryRiskGradeRequestVo(vo);
			
			// step2: 参数对象封装
			UserGradeRequest req = new UserGradeRequest();
			req.setGradeType(Integer.valueOf(GradeType.RISK.code()).toString()); // 等级类型
			req.setMemberId(vo.getMemberId()); // 会员Id
			
	    	// step3： 企业会员风险等级查询处理
	    	resp = userServiceBiz.queryRiskGrade(req);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.FAIL.code(), e.getMessage());
			} else {
				resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());
			}
		}
    	
    	log.info("UserServiceController.queryRiskGrade.resp:" + JSON.toJSONString(resp));
    	return resp;
    }    
    
    /**
     * riskAsessment:企业会员风险测评. <br/>
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "/riskassessment", method = RequestMethod.POST)
    @ResponseBody
    public BaseWebResponse riskAsessment(@RequestBody UserRiskAsessmentRequestVo vo) {
    	
    	log.info("UserServiceController.riskAsessment.req:" + vo);
    	
    	BaseWebResponse resp;
    	try {
    		// step1: 参数校验
			parameterChecker.checkUserRiskAsessmentRequestVo(vo);
			
			// step2: 参数对象封装
			UserRiskAsessmentRequest req = new UserRiskAsessmentRequest();
			req.setMemberId(vo.getMemberId()); // 会员Id
			req.setAnswers(vo.getAnswers()); // 所有题目的答案
			
	    	// step3： 企业会员风险测评处理
	    	resp = userServiceBiz.riskAsessment(req);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.FAIL.code(), e.getMessage());
			} else {
				resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());
			}
		}
    	
    	log.info("UserServiceController.riskAsessment.resp:" + JSON.toJSONString(resp));
    	return resp;
    }    
    
}
