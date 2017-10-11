package com.situ.mall.controller.front;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String addCart(Integer productId, Integer amount, Model model, 
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("productId:" + productId);
		System.out.println("amount:" + amount);
		
		//springmvc
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Inclusion.NON_NULL);
		
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
			Product product = new Product();
			product.setId(productId);
			CartItemVO cartItemVO = new CartItemVO();
			cartItemVO.setProduct(product);
			cartItemVO.setAmount(amount);
			
			buyCartVO.addItem(cartItemVO);
			buyCartVO.setProductId(productId);
			
			//把购物车对象BuyCartVO以json形式写到cookie里面
			StringWriter stringWriter = new StringWriter();
			try {
				objectMapper.writeValue(stringWriter, buyCartVO);
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//将购物车json数据放到cookie里面
			Cookie cookie = new Cookie("buy_cart_cookie", stringWriter.toString());
			//默认关闭浏览器cookie销毁
			cookie.setMaxAge(60 * 60 * 24);
			
			cookie.setPath("/");
			
			//将cookie发送给浏览器
			response.addCookie(cookie);
		}
		
		//3.将购物车放到cookie
		
		
		
		
		
		
		model.addAttribute("buyCartVO", buyCartVO);
		return "cart";
	}
}
