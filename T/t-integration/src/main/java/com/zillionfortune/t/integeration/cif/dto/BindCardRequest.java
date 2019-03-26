/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.cif.dto;

import com.zillionfortune.common.dto.BaseRequest;


/**
 * ClassName: EnterpriseBindCardRequest <br/>
 * Function: 企业会员绑卡请求对象. <br/>
 * Date: 2016年12月13日 下午6:39:25 <br/>
 *
 * @author pengting
 * @version 
 * @since JDK 1.7
 */
public class BindCardRequest extends BaseRequest {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/** memberId */
	private String memberId;
	/**
	 * bankAccountName: 企业银行账户名称 必输 
	 */
	private String bankAccountName;
	/**
	 * bankAccountNo: 企业银行账号 必输 
	 */
	private String bankAccountNo;
	/**
	 * repeatBankAccountNo: 确认企业银行账户 必输 
	 */
	private String repeatBankAccountNo;
	/**
	 * bankAccount: 开户行支行 必输 
	 */
	private String branchBankName;
	/**
	 * bankAccountRegion: 开户行所在地区 必输
	 */
	private String bankAccountRegion;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBankAccountName() {
		return bankAccountName;
	}
	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	public String getRepeatBankAccountNo() {
		return repeatBankAccountNo;
	}
	public void setRepeatBankAccountNo(String repeatBankAccountNo) {
		this.repeatBankAccountNo = repeatBankAccountNo;
	}

	public String getBranchBankName() {
		return branchBankName;
	}
	public void setBranchBankName(String branchBankName) {
		this.branchBankName = branchBankName;
	}
	public String getBankAccountRegion() {
		return bankAccountRegion;
	}
	public void setBankAccountRegion(String bankAccountRegion) {
		this.bankAccountRegion = bankAccountRegion;
	} 
	
}
