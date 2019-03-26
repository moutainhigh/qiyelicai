/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseResponse;

/**
 * ClassName: UserLoginPasswordModifyCifResponse <br/>
 * Function: 接收cif企业会员更新登录密码业务用Response. <br/>
 * Date: 2016年12月14日 下午2:04:03 <br/>
 *
 * @author wangzinan_tech@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class UserLoginPasswordModifyCifResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	/**
	 * memberId:会员Id.
	 */
	private String memberId;
	
	/**
	 * operatorId:操作员Id.
	 */
	private Long operatorId;

	/**
	 * 构造方法.
	 *
	 * @param respCode
	 * @param resultCode
	 * @param resultMsg
	 */
	public UserLoginPasswordModifyCifResponse(String respCode, String resultCode, String resultMsg) {
		super(respCode, resultCode, resultMsg);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 构造方法.
	 *
	 * @param respCode
	 */
	public UserLoginPasswordModifyCifResponse(String respCode) {
		super(respCode);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 构造方法.
	 *
	 */
	public UserLoginPasswordModifyCifResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 构造方法.
	 *
	 * @param respCode
	 * @param resultMsg
	 */
	public UserLoginPasswordModifyCifResponse(String respCode,
			String resultMsg) {
		super(respCode, resultMsg);
		// TODO Auto-generated constructor stub
	}

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
	 * 获取operatorId的值.
	 *
	 * @return operatorId
	 */
	public Long getOperatorId() {
		return operatorId;
	}

	/**
	 * 设置operatorId的值.
	 *
	 * @param  operatorId
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

}
