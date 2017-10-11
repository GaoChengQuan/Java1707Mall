package com.situ.mall.controller.front;

import java.io.StringWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;
import com.situ.mall.vo.BuyCartVO;
import com.situ.mall.vo.CartItemVO;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private IProductService productService;

	@RequestMapping("/addCart")
	public String addCart(Integer productId, Integer amount, Model model, HttpServletRequest request) {
		System.out.println("productId:" + productId);
		System.out.println("amount:" + amount);
		
		//springmvc
		ObjectMapper objectMapper = new ObjectMapper();
		
		BuyCartVO buyCartVO = null;
		Cookie[] cookies = request.getCookies();
		//1.如果cookie有这个购物车对象，那就从cookie里面取出这个购物车对象
		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if ("buy_cart_cookie".equals(cookie.getName())) {
					//之前已经有购物车
					
				}
			}
		}
		//2.如果cookie没有这个购物车对象,才需要new BuyCartVO
		if (buyCartVO == null) {
			buyCartVO = new BuyCartVO();
		}
		
		//把购物项放到购物车里面
		if (null != productId) {
			Product product = productService.findById(productId);
			CartItemVO cartItemVO = new CartItemVO();
			cartItemVO.setProduct(product);
			cartItemVO.setAmount(amount);
			
			buyCartVO.addItem(cartItemVO);
			buyCartVO.setProductId(productId);
			
			//把购物车对象BuyCartVO以json形式写到cookie里面
			StringWriter stringWriter = new StringWriter();
			
			
		}
		
		//3.将购物车放到cookie
		
		
		
		
		
		
		model.addAttribute("buyCartVO", buyCartVO);
		return "cart";
	}
}
