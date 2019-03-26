/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.account.dto;

import java.util.List;

/**
 * ClassName: AssetQueryResponse <br/>
 * Function: 企业资产查询_响应对象. <br/>
 * Date: 2016年11月15日 下午4:30:08 <br/>
 *
 * @author kaiyun
 * @version 
 * @since JDK 1.7
 */
public class AssetQueryResponse {
	
	/**
	 * memberID
	 */
	private String memberId;
	
	/**
	 * 总资产
	 */
	private String totalAssets;	
	
	/**
	 * 在途资产
	 */
	private String onTheWayAssets;	
	
	/**
	 * 资产列表
	 */
	private List<BalanceAssertPesponse> assetsList;
	
	/**
	 * 公司名称
	 */
//	private String compayName;
	
	/**
	 * 资产单位
	 */
//	private String shareUnit;


	
	public AssetQueryResponse() {
		
	}
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(String totalAssets) {
		this.totalAssets = totalAssets;
	}

	public String getOnTheWayAssets() {
		return onTheWayAssets;
	}

	public void setOnTheWayAssets(String onTheWayAssets) {
		this.onTheWayAssets = onTheWayAssets;
	}

	public List<BalanceAssertPesponse> getAssetsList() {
		return assetsList;
	}

	public void setAssetsList(List<BalanceAssertPesponse> assetsList) {
		this.assetsList = assetsList;
	}

}
