/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.service;

import java.util.List;

import com.zillionfortune.t.dal.domain.Answers;
import com.zillionfortune.t.dal.entity.GradeScore;

/**
 * ClassName: RiskAsessmentService <br/>
 * Function: 风险测评操作Service. <br/>
 * Date: 2016年12月20日 下午5:35:28 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface RiskAsessmentService {
	/**
	 * calculateTotalScore:计算风险测评总得分. <br/>
	 *
	 * @param score
	 */
	public int calculateTotalScore (List<Answers> answers);
	
	/**
     * selectByTotalScore:根据总得分查询等级信息. <br/>
     *
     * @param score
     * @return
     */
	public GradeScore selectByTotalScore(Integer totalScore);
}
