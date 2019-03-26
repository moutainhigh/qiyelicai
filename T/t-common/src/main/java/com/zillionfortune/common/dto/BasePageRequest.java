package com.zillionfortune.common.dto;

/**
 * ClassName: BasePageRequest <br/>
 * Function: 请求对象基础类封装. <br/>
 * Date: 2016年11月8日 上午9:48:40 <br/>
 *
 * @author Administrators
 * @version 
 * @since JDK 1.7
 */
public class BasePageRequest extends BaseRequest {

	private static final long serialVersionUID = 1L;

	/** 当前页数 */
	private Integer currentPage;
	
	/** 起始序号  */
    private Integer pageStart;

    /** 每页条数 */
    private Integer pageSize;

    public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
