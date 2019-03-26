/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseRequest;

/**
 * ClassName: UserGradeRequest <br/>
 * Function: 企业会员等级相关服务用Request. <br/>
 * Date: 2016年12月21日 下午3:47:58 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class UserGradeRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * memberId:会员Id.
	 */
	private String memberId;
	
	/**
	 * grade:等级值.
	 */
	private String grade;
	
	/**
	 * gradeType:等级类型.
	 */
	private String gradeType;

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
	 * 获取grade的值.
	 *
	 * @return grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * 设置grade的值.
	 *
	 * @param  grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * 获取gradeType的值.
	 *
	 * @return gradeType
	 */
	public String getGradeType() {
		return gradeType;
	}

	/**
	 * 设置gradeType的值.
	 *
	 * @param  gradeType
	 */
	public void setGradeType(String gradeType) {
		this.gradeType = gradeType;
	}
	
}
