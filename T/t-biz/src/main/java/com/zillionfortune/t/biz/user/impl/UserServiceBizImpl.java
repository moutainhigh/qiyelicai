/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.user.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.zillionfortune.common.dto.BaseWebResponse;
import com.zillionfortune.t.biz.user.UserServiceBiz;
import com.zillionfortune.t.biz.user.dto.UserAuthRequest;
import com.zillionfortune.t.biz.user.dto.UserRiskAsessmentRequest;
import com.zillionfortune.t.common.enums.GradeType;
import com.zillionfortune.t.common.enums.RespCode;
import com.zillionfortune.t.common.enums.ResultCode;
import com.zillionfortune.t.dal.entity.GradeScore;
import com.zillionfortune.t.dal.entity.Score;
import com.zillionfortune.t.integeration.cif.UserGradeIntegration;
import com.zillionfortune.t.integeration.cif.UserInfoIntegration;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoQueryCifResponse;
import com.zillionfortune.t.integeration.cif.dto.EnterpriseExtInfoQueryRequest;
import com.zillionfortune.t.integeration.cif.dto.UserGradeQueryCifResponse;
import com.zillionfortune.t.integeration.cif.dto.UserGradeRequest;
import com.zillionfortune.t.integeration.cif.dto.UserGradeUpdateCifResponse;
import com.zillionfortune.t.service.GradeScoreService;
import com.zillionfortune.t.service.RiskAsessmentService;
import com.zillionfortune.t.service.ScoreService;

/**
 * ClassName: UserServiceBizImpl <br/>
 * Function: 企业会员相关服务. <br/>
 * Date: 2016年12月20日 下午12:42:40 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Component
public class UserServiceBizImpl implements UserServiceBiz {

	private static Logger log = LoggerFactory.getLogger(UserServiceBizImpl.class);
	
	@Autowired
	private UserInfoIntegration userInfoIntegration;
	
	@Autowired
	private UserGradeIntegration userGradeIntegration;
	
	@Autowired
	RiskAsessmentService riskAsessmentService;
	
	@Autowired
	ScoreService scoreService;
	
	@Autowired
	GradeScoreService gradeScoreService;

	/**
	 * 企业会员身份验证.
	 * @see com.zillionfortune.t.biz.user.UserServiceBiz#auth(com.zillionfortune.t.biz.user.dto.UserAuthRequest)
	 */
	@Override
	public BaseWebResponse auth(UserAuthRequest req) {
		log.info("UserServiceBizImpl.auth.req:" + JSON.toJSONString(req));

		BaseWebResponse resp = null;

		EnterpriseExtInfoQueryCifResponse cifResp;

		try {
			// step1: 参数封装
			EnterpriseExtInfoQueryRequest enterpriseExtInfoQueryRequest = new EnterpriseExtInfoQueryRequest();
			enterpriseExtInfoQueryRequest.setMemberId(req.getMemberId());
			
			// step2: 调用cif企业会员扩展信息查询服务
			cifResp = userInfoIntegration.enterpriseQueryInfo(enterpriseExtInfoQueryRequest);

			if (cifResp != null 
					&& RespCode.SUCCESS.code().equals(cifResp.getRespCode())
					&& ResultCode.SUCCESS.code().equals(cifResp.getResultCode())) {
				// 验证企业证件号码、企业法人证件号码是否有效
				if (req.getCertificateNo().equals(cifResp.getCertificateNo())
						&& req.getLegalPersonCertificateNo().equals(cifResp.getLegalPersonCertificateNo())) {
					resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.SUCCESS.code(),
							ResultCode.SUCCESS.desc());

					Map<String, String> respMap = new HashMap<String, String>();
					respMap.put("memberId", cifResp.getMemberId());
					resp.setData(respMap);
				} else {
					resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.CUSTOMER_NOT_FOUND.code(),
							ResultCode.CUSTOMER_NOT_FOUND.desc());
					return resp;
				}
			} else {
				resp = new BaseWebResponse(cifResp.getRespCode(), cifResp.getResultCode(), cifResp.getResultMsg());
				return resp;
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);

			resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());

		} finally {
			log.info("UserServiceBizImpl.auth.resp:" + JSON.toJSONString(resp));
		}

		return resp;
	}

	/**
	 * 企业会员风险等级查询.
	 * @see com.zillionfortune.t.biz.user.UserServiceBiz#queryRiskGrade(com.zillionfortune.t.integeration.cif.dto.UserGradeRequest)
	 */
	@Override
	public BaseWebResponse queryRiskGrade(UserGradeRequest req) {
		log.info("UserServiceBizImpl.queryRiskGrade.req:" + JSON.toJSONString(req));

		BaseWebResponse resp = null;

		UserGradeQueryCifResponse cifQueryGradeResp = null;
		
		try {
			// step1: 调用cif企业会员等级查询服务
			cifQueryGradeResp = userGradeIntegration.queryGrade(req);
			
			if (!(cifQueryGradeResp != null 
					&& RespCode.SUCCESS.code().equals(cifQueryGradeResp.getRespCode())
					&& ResultCode.SUCCESS.code().equals(cifQueryGradeResp.getResultCode()))) {
				resp = new BaseWebResponse(cifQueryGradeResp.getRespCode(), cifQueryGradeResp.getResultCode(),
						cifQueryGradeResp.getResultMsg());
				return resp;
			}
			
			// step2: 根据风险等级编码查询风险等级名称
			GradeScore gradeScore = new GradeScore();
			String gradeName = ""; // 风险等级名称
			gradeScore = gradeScoreService.queryByGradeValue(Integer.valueOf(cifQueryGradeResp.getGrade()));
			if (gradeScore != null) {
				gradeName = gradeScore.getGradeName();
			}
			
			// step3: 响应参数设定
			resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.SUCCESS.code(), ResultCode.SUCCESS.desc());

			Map<String, String> respMap = new HashMap<String, String>();
			respMap.put("memberId", cifQueryGradeResp.getMemberId()); // 会员Id
			respMap.put("riskGrade", gradeName); // 风险等级名称
			respMap.put("riskGradeCode", cifQueryGradeResp.getGrade()); // 风险等级编码
			resp.setData(respMap);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());
		} finally {
			log.info("UserServiceBizImpl.queryRiskGrade.resp:" + JSON.toJSONString(resp));
		}

		return resp;
	}

	/**
	 * 企业会员风险测评.
	 * @see com.zillionfortune.t.biz.user.UserServiceBiz#riskAsessment(com.zillionfortune.t.biz.user.dto.UserRiskAsessmentRequest)
	 */
	@Override
	public BaseWebResponse riskAsessment(UserRiskAsessmentRequest req) {
		log.info("UserServiceBizImpl.riskAsessment.req:" + JSON.toJSONString(req));

		BaseWebResponse resp = null;

		UserGradeQueryCifResponse cifQueryGradeResp = null;
		
		UserGradeUpdateCifResponse cifUpdateGradeResp = null;

		try {
			// step1: 计算测评总得分
			int totalScore = riskAsessmentService.calculateTotalScore(req.getAnswers());
			
			// step2: 根据测评总得分获取会员的风险等级
			GradeScore gradeScore = riskAsessmentService.selectByTotalScore(totalScore);
			if (gradeScore == null) {
				resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.RISK_ASESSMENT_NOT_COMPLETE.code(),
						ResultCode.RISK_ASESSMENT_NOT_COMPLETE.desc());
				return resp;
			}
			
			// step3: 参数封装
			UserGradeRequest userGradeRequest = new UserGradeRequest();
			userGradeRequest.setGrade(gradeScore.getGradeValue().toString()); // 等级值
			userGradeRequest.setGradeType(Integer.valueOf(GradeType.RISK.code()).toString()); // 等级类型
			userGradeRequest.setMemberId(req.getMemberId()); // 会员Id
			
			// step4: 调用cif企业会员等级查询服务
			cifQueryGradeResp = userGradeIntegration.queryGrade(userGradeRequest);
			
			// step5： 如果新的风险等级值和当前风险等级值不一样，调用cif企业会员等级更新服务
			if (!(cifQueryGradeResp != null 
					&& RespCode.SUCCESS.code().equals(cifQueryGradeResp.getRespCode())
					&& ResultCode.SUCCESS.code().equals(cifQueryGradeResp.getResultCode()))) {
				resp = new BaseWebResponse(cifQueryGradeResp.getRespCode(), cifQueryGradeResp.getResultCode(),
						cifQueryGradeResp.getResultMsg());
				return resp;
			}
			// 会员等级更新需要与否Flg
			Boolean updateGradeFlg = false;
			// 获取当前风险等级值
			String currentRiskGrade = cifQueryGradeResp.getGrade();
			// 获取新的风险等级值
			String riskGrade = gradeScore.getGradeValue().toString();
			// 如果新的风险等级值和当前风险等级值一样，不更新企业会员的风险等级值
			if (!riskGrade.equals(currentRiskGrade)) {
				updateGradeFlg = true;
				cifUpdateGradeResp = userGradeIntegration.updateGrade(userGradeRequest);
			}
			
			// step6: 插入/更新企业会员风险测评分数记录
			if (updateGradeFlg == false
				||(cifQueryGradeResp != null 
					&& RespCode.SUCCESS.code().equals(cifQueryGradeResp.getRespCode())
					&& ResultCode.SUCCESS.code().equals(cifQueryGradeResp.getResultCode()))) {
				
				insertOrUpdateScore(req, gradeScore.getId(), totalScore);
				
			} else {
				resp = new BaseWebResponse(cifUpdateGradeResp.getRespCode(), cifUpdateGradeResp.getResultCode(),
						cifUpdateGradeResp.getResultMsg());
				return resp;
			}
			
			// step7: 响应参数设定
			resp = new BaseWebResponse(RespCode.SUCCESS.code(), ResultCode.SUCCESS.code(), ResultCode.SUCCESS.desc());

			Map<String, String> respMap = new HashMap<String, String>();
			respMap.put("memberId", req.getMemberId()); // 会员Id
			respMap.put("riskGrade", gradeScore.getGradeName()); // 风险等级名称
			respMap.put("riskGradeCode", gradeScore.getGradeValue().toString()); // 风险等级编码
			resp.setData(respMap);

		} catch (Exception e) {
			log.error(e.getMessage(), e);

			resp = new BaseWebResponse(RespCode.FAIL.code(), RespCode.FAIL.desc());

		} finally {
			log.info("UserServiceBizImpl.riskAsessment.resp:" + JSON.toJSONString(resp));
		}

		return resp;
	}
	
	private void insertOrUpdateScore(UserRiskAsessmentRequest req, Integer gradeScoreId, Integer totalScore){
		// 查询会员风险评测信息
		Score currentScore = scoreService.queryByMemberId(req.getMemberId());
		if (currentScore == null) {
			// 插入企业会员风险测评分数记录
			Score score = new Score();
			score.setMemberId(req.getMemberId()); // 会员Id
			score.setGradeScoreId(gradeScoreId); // 等级分数Id
			score.setScore(totalScore); // 风险测评总得分
			score.setSubjectAnswer(JSON.toJSONString(req.getAnswers())); // 问题和答案
			
			scoreService.insertSelective(score);
		} else {
			// 【问题和答案】与之前的记录不一样，才做更新
			if(!(JSON.toJSONString(req.getAnswers())).equals(currentScore.getSubjectAnswer())) {
				// 更新企业会员风险测评分数记录
				Score score = new Score();
				score.setMemberId(req.getMemberId()); // 会员Id
				score.setGradeScoreId(gradeScoreId); // 等级分数Id
				score.setScore(totalScore); // 风险测评总得分
				score.setSubjectAnswer(JSON.toJSONString(req.getAnswers())); // 问题和答案
				score.setModifyTime(new Date()); // 修改时间
				
				scoreService.updateByMemberIdSelective(score);
			}
		}
	}

}
