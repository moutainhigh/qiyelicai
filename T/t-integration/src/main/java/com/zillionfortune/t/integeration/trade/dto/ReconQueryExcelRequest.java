/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.trade.dto;

import com.zillionfortune.common.dto.BaseRequest;
import com.zillionfortune.t.common.enums.TimeIntervalEnum;

/**
 * ClassName: ReconQueryRequest <br/>
 * Function: 对账查询_请求参数对象. <br/>
 * Date: 2016年11月15日 下午4:31:30 <br/>
 *
 * @author kaiyun
 * @version 
 * @since JDK 1.7
 */
public class ReconQueryExcelRequest extends BaseRequest {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 会员ID，必输
	 */
	private String memberId;
	
	/**
	 * 时间区间，默认当天
	 * 1：当天；2：最近一周；3：最近一个月；4：最近三个月；5：最近半年；6：最近一年	 * 
	 */
	private String timeInterval = TimeIntervalEnum.CURRENT_DAY.code();
	
	/**
	 * 起始交易时间
	 */
	private String beginTradeTime;
	
	/**
	 * 结束交易时间
	 */
	private String endTradeTime;
	
	public ReconQueryExcelRequest() {
		super();
	}

	public ReconQueryExcelRequest(String memberId) {
		super();
		this.memberId = memberId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}

	public String getBeginTradeTime() {
		return beginTradeTime;
	}

	public void setBeginTradeTime(String beginTradeTime) {
		this.beginTradeTime = beginTradeTime;
	}

	public String getEndTradeTime() {
		return endTradeTime;
	}

	public void setEndTradeTime(String endTradeTime) {
		this.endTradeTime = endTradeTime;
	}

}
