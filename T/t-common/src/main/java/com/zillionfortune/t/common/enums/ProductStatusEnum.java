package com.zillionfortune.t.common.enums;

/**
 * ClassName: ProductStatusEnum <br/>
 * Function: 产品状态枚举. <br/>
 * Date: 2016年12月6日 下午4:45:22 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public enum ProductStatusEnum {
	
	/** PRODUCT_STATUS_UNSCHEDULED：未排期(100) **/
	PRODUCT_STATUS_UNSCHEDULED("100", "未排期"),
	
	/** PRODUCT_STATUS_SCHEDULED：已排期(101) **/
	PRODUCT_STATUS_SCHEDULED("101", "已排期"),
	
	/** PRODUCT_STATUS_ON_SHELF：上架(102) **/
	PRODUCT_STATUS_ON_SHELF("102", "上架"),
	
	/** PRODUCT_STATUS_OFF_SHELF：下架(103) **/
	PRODUCT_STATUS_OFF_SHELF("103", "下架"),
	
	/** PRODUCT_STATUS_SELL_OUT：已售罄(104) **/
	PRODUCT_STATUS_SELL_OUT("104", "已售罄"),
	
	/** PRODUCT_STATUS_TO_BE_ESTABLISHED：待成立(105) **/
	PRODUCT_STATUS_TO_BE_ESTABLISHED("105", "待成立"),
	
	/** PRODUCT_STATUS_RAISE_FAILED：募集失败(106) **/
	PRODUCT_STATUS_RAISE_FAILED("106", "募集失败"),
	
	/** PRODUCT_STATUS_DURATION_PERIOD：存续期(107) **/
	PRODUCT_STATUS_DURATION_PERIOD("107", "存续期"),
	
	/** PRODUCT_STATUS_FAILED_TO_BE_SOLD：流标(108) **/
	PRODUCT_STATUS_FAILED_TO_BE_SOLD("108", "流标"),
	
	/** PRODUCT_STATUS_MATURE：到期(109) **/
	PRODUCT_STATUS_MATURE("109", "到期"),
	
	/** PRODUCT_STATUS_TERMINAL_TO_BE_SOLD：流标终止(110) **/
	PRODUCT_STATUS_TERMINAL_TO_BE_SOLD("110", "流标终止"),
	
	/** PRODUCT_STATUS_PLACE_ON_FILE：到期完成(111) **/
	PRODUCT_STATUS_PLACE_ON_FILE("111", "到期完成");
	
	/**
	 * 会员状态code
	 */
	private String code;
	
	/**
	 * 会员状态code描述
	 */
	private String desc;

	ProductStatusEnum(String code,String desc){
        this.code=code;
        this.desc=desc;
    }

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
	/**
	 * 通过code获取enum对象
	 * 
	 * @param code
	 * @return
	 */
	public static ProductStatusEnum getEnum(String code) {
		for (ProductStatusEnum item : values()) {
			if (item.getCode() == code) {
				return item;
			}
		}
		return null;
	}

}
