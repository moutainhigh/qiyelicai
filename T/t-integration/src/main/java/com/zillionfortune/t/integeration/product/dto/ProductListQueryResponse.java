package com.zillionfortune.t.integeration.product.dto;

import java.util.List;

import com.zillionfortune.common.dto.BaseResponse;

/**
 * ClassName: ProductListQueryResponse <br/>
 * Function: 产品列表查询_响应参数. <br/>
 * Date: 2016年12月22日 下午4:53:02 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class ProductListQueryResponse extends BaseResponse{

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 总条数
	 */
	private String totalCount;
	
	/**
	 * 产品列表
	 */
	private List<ProductModelConvert> productModelList;
	
	

    public ProductListQueryResponse() {
        super();
    }

    public ProductListQueryResponse(String respCode, String resultMsg) {
        super(respCode, resultMsg);
    }

    public ProductListQueryResponse(String respCode, String resultCode, String resultMsg) {
        super(respCode, resultCode, resultMsg);
    }

	public List<ProductModelConvert> getProductModelList() {
		return productModelList;
	}

	public void setProductModelList(List<ProductModelConvert> productModelList) {
		this.productModelList = productModelList;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

}
