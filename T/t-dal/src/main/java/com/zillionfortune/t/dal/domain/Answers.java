/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.dal.domain;

/**
 * ClassName: UserRiskAsessmentRequestVo <br/>
 * Function: 题目对应的答案实体类. <br/>
 * Date: 2016年12月21日 下午1:46:51 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class Answers {
	
	/**
	 * subjectSerialNo:问题编号.
	 */
	private Integer subjectSerialNo;
	
	/**
	 * answerSerialNo:答案编号.
	 */
	private String answerSerialNo;
	
	public Answers() {

	}
	
	public Answers(Integer subjectSerialNo, String answerSerialNo) {
		super();
		this.subjectSerialNo = subjectSerialNo;
		this.answerSerialNo = answerSerialNo;
	}

	/**
	 * 获取subjectSerialNo的值.
	 *
	 * @return subjectSerialNo
	 */
	public Integer getSubjectSerialNo() {
		return subjectSerialNo;
	}

	/**
	 * 设置subjectSerialNo的值.
	 *
	 * @param  subjectSerialNo
	 */
	public void setSubjectSerialNo(Integer subjectSerialNo) {
		this.subjectSerialNo = subjectSerialNo;
	}

	/**
	 * 获取answerSerialNo的值.
	 *
	 * @return answerSerialNo
	 */
	public String getAnswerSerialNo() {
		return answerSerialNo;
	}

	/**
	 * 设置answerSerialNo的值.
	 *
	 * @param  answerSerialNo
	 */
	public void setAnswerSerialNo(String answerSerialNo) {
		this.answerSerialNo = answerSerialNo;
	}
	
}
