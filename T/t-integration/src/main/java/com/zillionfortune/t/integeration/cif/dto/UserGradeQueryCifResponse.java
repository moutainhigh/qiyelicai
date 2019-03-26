package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseResponse;


public class UserGradeQueryCifResponse extends BaseResponse {

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
