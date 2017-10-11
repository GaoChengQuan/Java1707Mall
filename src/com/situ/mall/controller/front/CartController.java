package com.situ.mall.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

	@RequestMapping("/addCart")
	public String addCart(Integer productId, Integer amount) {
		System.out.println("productId:" + productId);
		System.out.println("amount:" + amount);
		
		return "cart";
	}
}
