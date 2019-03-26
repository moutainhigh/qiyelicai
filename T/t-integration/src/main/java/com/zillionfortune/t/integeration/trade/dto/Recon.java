package com.zillionfortune.t.integeration.trade.dto;

/**
 * ClassName: Recon <br/>
 * Function: 对账列表Model. <br/>
 * Date: 2016年12月27日 下午2:51:42 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class Recon {
	
	/**
	 * 产品类别，必输
	 */
	private String patternCode;
	
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
	 * 操作
	 */
	private String operation;
	
	/**
	 * 备注
	 */
	private String remark;

	
	/**===================Construtor===================*/
	public Recon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recon(String patternCode, String tradeTime, String productName,
			String incomeAmt, String turnOutAmt, String tradeStatus,
			String operation, String remark) {
		super();
		this.patternCode = patternCode;
		this.tradeTime = tradeTime;
		this.productName = productName;
		this.incomeAmt = incomeAmt;
		this.turnOutAmt = turnOutAmt;
		this.tradeStatus = tradeStatus;
		this.operation = operation;
		this.remark = remark;
	}

	/**===================set/get method===================*/
	public String getPatternCode() {
		return patternCode;
	}

	public void setPatternCode(String patternCode) {
		this.patternCode = patternCode;
	}

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

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
