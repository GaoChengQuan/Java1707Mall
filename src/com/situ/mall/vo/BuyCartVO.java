package com.situ.mall.vo;

import java.util.ArrayList;
import java.util.List;

import org.junit.validator.PublicClassValidator;

/**
 * 购物车
 *
 */
public class BuyCartVO {
	// 购物项集合
	private List<CartItemVO> items = new ArrayList<CartItemVO>();

	// 继续购物，最后一次产品的id
	private Integer productId;
	
	public void addItem(CartItemVO cartItemVO) {
		boolean isExist = false;
		//1.这件商品原来在购物车里面有，我们只需要更新购买数量
		for (CartItemVO item : items) {
			if (item.getProduct().getId() == cartItemVO.getProduct().getId()) {
				isExist = true;
				int amount = item.getAmount() + cartItemVO.getAmount();
				//购买这件商品的总数量应该<=product.stock
				if (amount <= item.getProduct().getStock()) {
					item.setAmount(amount);
				} else {
					//超出购买限制，最大只能购买这件商品的最大库存
					item.setAmount(item.getProduct().getStock());
				}
				break;
			}
		}
		//2.这件商品原来没有加入购物车,加入购物车
		if (isExist == false) {
			items.add(cartItemVO);
		}
		
	}

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