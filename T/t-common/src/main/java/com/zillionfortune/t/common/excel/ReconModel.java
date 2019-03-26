package com.zillionfortune.t.common.excel;

/**
 * ClassName: Recon <br/>
 * Function: 对账列表_Excel_Model. <br/>
 * Date: 2016年12月27日 下午2:51:42 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class ReconModel {
	
	/**
	 * 交易时间
	 */
	private String tradeTime;
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 转入金额
	 */
	private String incomeAmt;
	
	/**
	 * 转出金额
	 */
	private String turnOutAmt;
	
	/**
	 * 交易状态
	 */
	private String tradeStatus;
	
	/**
	 * 备注
	 */
	private String remark;

	
	/**===================Construtor===================*/
	public ReconModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReconModel(String tradeTime, String productName, String incomeAmt,
			String turnOutAmt, String tradeStatus, String remark) {
		super();
		this.tradeTime = tradeTime;
		this.productName = productName;
		this.incomeAmt = incomeAmt;
		this.turnOutAmt = turnOutAmt;
		this.tradeStatus = tradeStatus;
		this.remark = remark;
	}


	/**===================set/get method===================*/
	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getIncomeAmt() {
		return incomeAmt;
	}

	public void setIncomeAmt(String incomeAmt) {
		this.incomeAmt = incomeAmt;
	}

	public String getTurnOutAmt() {
		return turnOutAmt;
	}

	public void setTurnOutAmt(String turnOutAmt) {
		this.turnOutAmt = turnOutAmt;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
