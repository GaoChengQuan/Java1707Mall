package com.situ.mall.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车
 *
 */
public class BuyCartVO {
	// 购物项集合
	private List<CartItemVO> items = new ArrayList<CartItemVO>();

	// 继续购物，最后一次产品的id
	private Integer productId;

	public List<CartItemVO> getItems() {
		return items;
	}

	public void setItems(List<CartItemVO> items) {
		this.items = items;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "BuyCartVO [items=" + items + ", productId=" + productId + "]";
	}

}
