package com.zillionfortune.t.common.enums;

/**
 * ClassName: ProductStatusCodeEnum <br/>
 * Function: 产品的类型代码枚举. <br/>
 * Date: 2016年12月6日 下午4:45:22 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public enum PatternCodeTypeEnum {
	
	/** CASH_MANAGEMENT：现金管理(01) **/
	CASH_MANAGEMENT("01", "现金管理"),
	
	/** PERIODIC_REGULAR：定期类(02) **/
	PERIODIC_REGULAR("02", "定期类"),
	
	/** NET_ASSET：净值型(03) **/
    NET_ASSET("03", "净值型");

	private String code;
	private String desc;

	PatternCodeTypeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
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
	public static PatternCodeTypeEnum getEnumItem(String code) {
		for (PatternCodeTypeEnum item : values()) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}

    /**
     * 判断是否是定期类ENUM
     * @param code
     * @return
     */
    public static boolean isPeriodicRegular(String code){
        if(PatternCodeTypeEnum.PERIODIC_REGULAR.getCode().equals(code)){
            return true;
        }
        return false;
    }

}
