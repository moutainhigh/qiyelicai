package com.zillionfortune.common.dto;

/**
 * ClassName: BasePageResponse <br/>
 * Function: 相应对象基础类封装. <br/>
 * Date: 2016年11月8日 上午9:48:40 <br/>
 *
 * @author Administrators
 * @version 
 * @since JDK 1.7
 */
public class BasePageResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	
	/** 结果集总数 */
    private Integer total;

    /** 总页数 */
    private Integer totalPage;
    
    /** 每页条数 */
    private Integer pageSize;
    
    /** 当前页 */
    private Integer currentPage;
  
    public BasePageResponse() {

    }

    public BasePageResponse(String respCode) {
		super(respCode);
	}
    
    public BasePageResponse(String respCode, String resultMsg) {
		super(respCode, resultMsg);
	}
    
	public BasePageResponse(String respCode, String resultCode, String resultMsg) {
		super(respCode, resultCode, resultMsg);
	}

	public BasePageResponse(String respCode, String resultCode, String resultMsg,
			Integer total, Integer totalPage, Integer pageSize,
			Integer currentPage) {
		
		super(respCode, resultCode, resultMsg);
		this.total = total;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

}
