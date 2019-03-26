package com.zillionfortune.t.integeration.account.dto;

/**
 * ClassName: BalanceAssertPesponse <br/>
 * Function: 企业资产查询中列表model. <br/>
 * Date: 2016年12月26日 上午10:24:28 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class BalanceAssertPesponse {
	
	/**
	 * 资产名称
	 */
	
	private String assetsType;
	/**
	 * 资产金额
	 */
	private String assets;
	
	
	public String getAssetsType() {
		return assetsType;
	}
	public void setAssetsType(String assetsType) {
		this.assetsType = assetsType;
	}
	public String getAssets() {
		return assets;
	}
	public void setAssets(String assets) {
		this.assets = assets;
	}

}
