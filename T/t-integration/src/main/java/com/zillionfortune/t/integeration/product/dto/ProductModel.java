package com.zillionfortune.t.integeration.product.dto;

import java.math.BigDecimal;

/**
 * 产品模型对象Domain
 *
 * @author zhangxin
 * @create 2016-12-15 11:41
 */
public class ProductModel extends BaseModel {

	/**
     * 主键ID
     */
    private Integer id;

    /**
     * 第三方产品ID
     */
    private String thirdPartyId;

    /**
     * 产品线ID
     */
    private int productLineId;

    /**
     * 产品关联的资产池ID
     */
    private String assetPoolId;

    /**
     * 产品编号
     */
    private String code;

    /**
     * 产品全称
     */
    private String fullName;

    /**
     * 产品简称
     */
    private String shortName;

    /**
     * 产品规模
     */
    private BigDecimal totalAmount;

    /**
     * 当前规模
     */
    private BigDecimal investedAmount;
    
    /**
     * 买入待确认规模(已付款的总规模)
     */
    private BigDecimal unconfirmedPurchaseAmount;

    /**
     * 当前规模(产品成立时所有购买成功的订单总额)
     */
    private BigDecimal actualInvestAmount;

    /**
     * 产品风险等级
     */
    private String riskLevel;

    /**
     * 投资人风险承受能力条件
     */
    private String investorRequirement;

    /**
     * 产品状态
     */
    private int status;

    /**
     * 产品的类型代码
     */
    private String patternCode;

    /**
     * 计量单位(1:份额, 2:人民币)
     */
    private int unit;

    /**
     * 最小申购金额
     */
    private BigDecimal minInvestAmount;

    /**
     * 最大申购金额
     */
    private BigDecimal maxInvestAmount;

    /**
     * 递增金额
     */
    private BigDecimal increaseInvestAmount;

    /**
     * 年基础计息周期(360, 365, 366三种枚举值)
     */
    private Integer basicInterestsPeriod;

    /**
     * 产品的上架时间
     */
    private String onSaleTime;

    /**
     * 是否对港澳台开放
     */
    private int isOpenHmt;

    /**
     * 日历模式
     */
    private String calendarMode;

    /**
     * 产品介绍
     */
    private String introduction;


    /*--------产品投资相关信息start-------------------------------------------------*/
    /**
     * 主键
     */
    private Integer productPeriodicRegularId;

    /**
     * 募集起始日期
     */
    private String saleStartDate;

    /**
     * 募集截止日期
     */
    private String saleEndDate;

    /**
     * 剩余募集时间
     */
    private Long restSaleTime;

    /**
     * 成立日期
     */
    private String establishDate;

    /**
     * 起息日期
     */
    private String valueDate;

    /**
     * 到期日期
     */
    private String expireDate;

    /**
     * 回款日期
     */
    private String receivePaymentDate;

    /**
     * 锁定期单位
     */
    private String lockPeriodUnit;

    /**
     * 锁定期
     */
    private int lockPeriod;

    /**
     * 最低预期收益率
     */
    private BigDecimal minYieldRate;

    /**
     * 最高预期收益率
     */
    private BigDecimal maxYieldRate;

    /**
     * 收益方式
     */
    private String incomeType;

    /**
     * 加息
     */
    private BigDecimal addedYieldRate;

    /**
     * 成立条件
     */
    private String establishCondition;

    /*--------产品投资相关信息end-------------------------------------------------*/


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThirdPartyId() {
        return thirdPartyId;
    }

    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }

    public int getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(int productLineId) {
        this.productLineId = productLineId;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getInvestedAmount() {
        return investedAmount;
    }

    public void setInvestedAmount(BigDecimal investedAmount) {
        this.investedAmount = investedAmount;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getInvestorRequirement() {
        return investorRequirement;
    }

    public void setInvestorRequirement(String investorRequirement) {
        this.investorRequirement = investorRequirement;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPatternCode() {
        return patternCode;
    }

    public void setPatternCode(String patternCode) {
        this.patternCode = patternCode;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public BigDecimal getMinInvestAmount() {
        return minInvestAmount;
    }

    public void setMinInvestAmount(BigDecimal minInvestAmount) {
        this.minInvestAmount = minInvestAmount;
    }

    public BigDecimal getMaxInvestAmount() {
        return maxInvestAmount;
    }

    public void setMaxInvestAmount(BigDecimal maxInvestAmount) {
        this.maxInvestAmount = maxInvestAmount;
    }

    public BigDecimal getIncreaseInvestAmount() {
        return increaseInvestAmount;
    }

    public void setIncreaseInvestAmount(BigDecimal increaseInvestAmount) {
        this.increaseInvestAmount = increaseInvestAmount;
    }

    public int getIsOpenHmt() {
        return isOpenHmt;
    }

    public void setIsOpenHmt(int isOpenHmt) {
        this.isOpenHmt = isOpenHmt;
    }

    public String getCalendarMode() {
        return calendarMode;
    }

    public void setCalendarMode(String calendarMode) {
        this.calendarMode = calendarMode;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getProductPeriodicRegularId() {
        return productPeriodicRegularId;
    }

    public void setProductPeriodicRegularId(Integer productPeriodicRegularId) {
        this.productPeriodicRegularId = productPeriodicRegularId;
    }

    public String getOnSaleTime() {
		return onSaleTime;
	}

	public void setOnSaleTime(String onSaleTime) {
		this.onSaleTime = onSaleTime;
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

	public String getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
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

	public String getReceivePaymentDate() {
		return receivePaymentDate;
	}

	public void setReceivePaymentDate(String receivePaymentDate) {
		this.receivePaymentDate = receivePaymentDate;
	}

	public String getLockPeriodUnit() {
        return lockPeriodUnit;
    }

    public void setLockPeriodUnit(String lockPeriodUnit) {
        this.lockPeriodUnit = lockPeriodUnit;
    }

    public int getLockPeriod() {
        return lockPeriod;
    }

    public void setLockPeriod(int lockPeriod) {
        this.lockPeriod = lockPeriod;
    }

    public BigDecimal getMinYieldRate() {
        return minYieldRate;
    }

    public void setMinYieldRate(BigDecimal minYieldRate) {
        this.minYieldRate = minYieldRate;
    }

    public BigDecimal getMaxYieldRate() {
        return maxYieldRate;
    }

    public void setMaxYieldRate(BigDecimal maxYieldRate) {
        this.maxYieldRate = maxYieldRate;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    public BigDecimal getAddedYieldRate() {
        return addedYieldRate;
    }

    public void setAddedYieldRate(BigDecimal addedYieldRate) {
        this.addedYieldRate = addedYieldRate;
    }

    public String getEstablishCondition() {
        return establishCondition;
    }

    public void setEstablishCondition(String establishCondition) {
        this.establishCondition = establishCondition;
    }

    public Long getRestSaleTime() {
        return restSaleTime;
    }

    public void setRestSaleTime(Long restSaleTime) {
        this.restSaleTime = restSaleTime;
    }

    public String getAssetPoolId() {
        return assetPoolId;
    }

    public void setAssetPoolId(String assetPoolId) {
        this.assetPoolId = assetPoolId;
    }

    public Integer getBasicInterestsPeriod() {
        return basicInterestsPeriod;
    }

    public void setBasicInterestsPeriod(Integer basicInterestsPeriod) {
        this.basicInterestsPeriod = basicInterestsPeriod;
    }

	public BigDecimal getUnconfirmedPurchaseAmount() {
		return unconfirmedPurchaseAmount;
	}

	public void setUnconfirmedPurchaseAmount(BigDecimal unconfirmedPurchaseAmount) {
		this.unconfirmedPurchaseAmount = unconfirmedPurchaseAmount;
	}

	public BigDecimal getActualInvestAmount() {
		return actualInvestAmount;
	}

	public void setActualInvestAmount(BigDecimal actualInvestAmount) {
		this.actualInvestAmount = actualInvestAmount;
	}
}
