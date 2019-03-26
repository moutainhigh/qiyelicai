package com.zillionfortune.t.integeration.product.dto;

public class ProductModelConvert {
	
	/**
	 * 产品Id
	 */
	private String productId;
	
	/**
	 * 产品编码
	 */
	private String productCode;
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 预期年化率
	 */
	private String anualRate;
	
	/**
	 * 投资期限
	 */
	private String investmentTerm;
	
	/**
	 * 起投金额
	 */
	private String startingInvestmentamt;
	
	
	public ProductModelConvert() {
		super();
	}
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getAnualRate() {
		return anualRate;
	}

	public void setAnualRate(String anualRate) {
		this.anualRate = anualRate;
	}

	public String getInvestmentTerm() {
		return investmentTerm;
	}

	public void setInvestmentTerm(String investmentTerm) {
		this.investmentTerm = investmentTerm;
	}

	public String getStartingInvestmentamt() {
		return startingInvestmentamt;
	}

	public void setStartingInvestmentamt(String startingInvestmentamt) {
		this.startingInvestmentamt = startingInvestmentamt;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

}
