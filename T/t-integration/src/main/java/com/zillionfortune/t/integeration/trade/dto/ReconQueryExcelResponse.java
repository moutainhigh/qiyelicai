/*
 * Copyright (c) 2016, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 *
 *
 */
package com.zillionfortune.t.integeration.trade.dto;

import java.util.List;


/**
 * ClassName: ReconQueryResponse <br/>
 * Function: 对账查询_响应对象. <br/>
 * Date: 2016年11月15日 下午4:30:08 <br/>
 *
 * @author kaiyun
 * @version 
 * @since JDK 1.7
 */
public class ReconQueryExcelResponse {
	
	
	/**
	 * 对账列表
	 */
	private List<Recon> reconList ;
	
	
	/**===================Construtor===================*/
	public ReconQueryExcelResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**===================set/get method===================*/

	public List<Recon> getReconList() {
		return reconList;
	}

	public void setReconList(List<Recon> reconList) {
		this.reconList = reconList;
	}

}
