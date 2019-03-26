/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillionfortune.t.dal.dao.AnswerDao;
import com.zillionfortune.t.dal.dao.GradeScoreDao;
import com.zillionfortune.t.dal.dao.ScoreDao;
import com.zillionfortune.t.dal.domain.Answers;
import com.zillionfortune.t.dal.entity.Answer;
import com.zillionfortune.t.dal.entity.GradeScore;
import com.zillionfortune.t.service.RiskAsessmentService;

/**
 * ClassName: RiskAsessmentServiceImpl <br/>
 * Function: 风险测评操作Service 实现. <br/>
 * Date: 2016年12月20日 下午5:44:18 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
@Service
public class RiskAsessmentServiceImpl implements RiskAsessmentService {
	
	@Autowired
	private ScoreDao scoreDao;
	
	@Autowired
	private AnswerDao answerDao;
	
	@Autowired
	private GradeScoreDao gradeScoreDao;

	/**
	 * 计算风险测评总得分.
	 * @see com.zillionfortune.t.service.RiskAsessmentService#calculateTotalScore(java.util.List)
	 */
	@Override
	public int calculateTotalScore(List<Answers> answers) {
		int totalScore = 0;
		for (Answers answer: answers) {
			Integer subjectSerialNo = answer.getSubjectSerialNo(); // 问题编号
			String answerSerialNo = answer.getAnswerSerialNo(); // 答案编号
			Answer currentAnswer = answerDao.selectBySubjectSerialNoAndAnswerSerialNo(subjectSerialNo, answerSerialNo);
			if(currentAnswer != null){
				totalScore = totalScore + currentAnswer.getScore();
			}
		}
		return totalScore;
	}

	/**
	 * 根据总得分查询等级信息.
	 * @see com.zillionfortune.t.service.RiskAsessmentService#selectByTotalScore(java.lang.Integer)
	 */
	@Override
	public GradeScore selectByTotalScore(Integer totalScore) {
		GradeScore gradeScore = gradeScoreDao.selectByTotalScore(totalScore);
		return gradeScore;
	}
	
}
