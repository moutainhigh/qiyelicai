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
public class ReconQueryResponse {
	
	/**
	 * 总条数
	 */
	private String totalCount;
	
	/**
	 * 总页数
	 */
	private String totalPage;
	
	/**
	 * 当前页
	 */
	private String pageNo;
	
	/**
	 * 每页多少条
	 */
	private String pageSize;
	
	/**
	 * 对账列表
	 */
	private List<Recon> reconList ;
	
	
	/**===================Construtor===================*/
	public ReconQueryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReconQueryResponse(String totalCount, String totalPage,
			String pageNo, String pageSize, List<Recon> reconList) {
		super();
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.reconList = reconList;
	}


	/**===================set/get method===================*/
	public String getTotalPage() {
		return totalPage;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public List<Recon> getReconList() {
		return reconList;
	}

	public void setReconList(List<Recon> reconList) {
		this.reconList = reconList;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

}
