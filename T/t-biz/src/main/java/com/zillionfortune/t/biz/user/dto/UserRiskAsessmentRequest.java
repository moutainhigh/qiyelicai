/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.biz.user.dto;

import java.util.List;

import com.zillionfortune.common.dto.BaseRequest;
import com.zillionfortune.t.dal.domain.Answers;

/**
 * ClassName: UserRiskAsessmentRequest <br/>
 * Function: 企业会员风险测评用Request. <br/>
 * Date: 2016年12月21日 下午3:30:19 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class UserRiskAsessmentRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * memberId:会员Id.
	 */
	private String memberId;
	
	/**
	 * answers:所有题目的答案.
	 */
	private List<Answers> answers;

	/**
	 * 获取memberId的值.
	 *
	 * @return memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * 设置memberId的值.
	 *
	 * @param  memberId
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * 获取answers的值.
	 *
	 * @return answers
	 */
	public List<Answers> getAnswers() {
		return answers;
	}

	/**
	 * 设置answers的值.
	 *
	 * @param  answers
	 */
	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}
	
}
