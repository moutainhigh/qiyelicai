package com.zillionfortune.t.integeration.product.dto;

import com.zillionfortune.common.dto.BaseResponse;

/**
 * ClassName: ProductInfoQueryResponse <br/>
 * Function: 产品详情查询_响应参数. <br/>
 * Date: 2016年12月22日 下午4:51:52 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class ProductInfoQueryResponse extends BaseResponse{

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 1L;
	
	
//	private ProductModel productModel;
	
	
	/**
	 * 产品Id
	 */
	private String productId;
	
	/**
	 * 产品编号
	 */
	private String code;
	
	/**
	 * 产品名称全称
	 */
	private String fullName;
	
	/**
	 * 产品规模
	 */
	private String totalAmount;
	
	/**
	 * 最高购买金额
	 */
	private String maxInvestAmount;
	
	/**
	 * 已投资金额
	 */
	private String investedAmount;
	
	/**
	 * 计量单位(1:份额, 2:人民币)
	 */
	private String unit;
	
	/**
	 * 起购金额
	 */
	private String minInvestAmount;
	
	/**
	 * 产品介绍
	 */
	private String introduction;
	
	/**
	 * 募集起始日期
	 */
	private String saleStartDate;
	
	/**
	 * 募集截止日期
	 */
	private String saleEndDate;
	
	/**
	 * 起息日期
	 */
	private String valueDate;
	
	/**
	 * 到期日期
	 */
	private String expireDate;
	
	/**
	 * 剩余募集时间（剩余时间）
	 */
	private String restSaleTime;
	
	/**
	 * 递增金额
	 */
	private String increaseInvestAmount;
	
	/**
	 * 最低预期收益率（预期年化收益率）
	 */
	private String minYieldRate;
	
	/**
	 * 锁定期（理财期限）
	 */
	private String lockPeriod;
	

    public ProductInfoQueryResponse() {
        super();
    }

    public ProductInfoQueryResponse(String respCode, String resultMsg) {
        super(respCode, resultMsg);
    }

    public ProductInfoQueryResponse(String respCode, String resultCode, String resultMsg) {
        super(respCode, resultCode, resultMsg);
    }

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getMaxInvestAmount() {
		return maxInvestAmount;
	}

	public void setMaxInvestAmount(String maxInvestAmount) {
		this.maxInvestAmount = maxInvestAmount;
	}

	public String getInvestedAmount() {
		return investedAmount;
	}

	public void setInvestedAmount(String investedAmount) {
		this.investedAmount = investedAmount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMinInvestAmount() {
		return minInvestAmount;
	}

	public void setMinInvestAmount(String minInvestAmount) {
		this.minInvestAmount = minInvestAmount;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getSaleStartDate() {
		return saleStartDate;
	}

	public void setSaleStartDate(String saleStartDate) {
		this.saleStartDate = saleStartDate;
	}

	public String getSaleEndDate() {
		return saleEndDate;
	}

	public void setSaleEndDate(String saleEndDate) {
		this.saleEndDate = saleEndDate;
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getRestSaleTime() {
		return restSaleTime;
	}

	public void setRestSaleTime(String restSaleTime) {
		this.restSaleTime = restSaleTime;
	}

	public String getIncreaseInvestAmount() {
		return increaseInvestAmount;
	}

	public void setIncreaseInvestAmount(String increaseInvestAmount) {
		this.increaseInvestAmount = increaseInvestAmount;
	}

	public String getMinYieldRate() {
		return minYieldRate;
	}

	public void setMinYieldRate(String minYieldRate) {
		this.minYieldRate = minYieldRate;
	}

	public String getLockPeriod() {
		return lockPeriod;
	}

	public void setLockPeriod(String lockPeriod) {
		this.lockPeriod = lockPeriod;
	}


}
