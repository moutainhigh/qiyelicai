/*
 * Copyright (c) ${year}, 资邦金服（上海）网络科技有限公司. All Rights Reserved.
 *
 */
package com.zillionfortune.t.dal.entity;

import java.util.Date;

/**
 * ClassName: BaseEntity <br/>
 * Function: 实体类基础封装 <br/>
 * Date: 2016年12月27日 下午5:51:27 <br/>
 *
 * @author zhengrunlong@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class BaseEntity {

    private Long id;

    private Date createTime;

    private String createBy;
    
    private Date modifyTime;

    private String modifyBy;
  
    /** 分页参数,起始序号 */
    private Integer pageStart;

    /** 分页参数,分页大小 */
    private Integer pageSize;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
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
