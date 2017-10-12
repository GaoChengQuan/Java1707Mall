package com.situ.mall.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.mall.pojo.Product;
import com.situ.mall.pojo.Shipping;
import com.situ.mall.pojo.User;
import com.situ.mall.service.IProductService;
import com.situ.mall.vo.BuyCartVO;
import com.situ.mall.vo.CartItemVO;

/*@Controller
@RequestMapping("/order")*/
public class FrontOrderController {
	@Autowired
	private IShippingService shippingService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IProductService productService;

	@RequestMapping("/prepareOrder")
	public String prepareOrder(Model model) {
		//1.获得User对象从Session中
		User user = Session;
		//2.通过User得到收货地址
		Shipping shipping = shippingService.findByUserId(user.getId());
		model.addAttribute("shipping", shipping);

		//3.从Cookie中得到购物车
		BuyCartVO buyCart = getBuyCartFromCooki();
		
		// 将购物车装满Product，而不是只是装Product的id
		List<CartItemVO> items = buyCart.getItems();
		for (CartItemVO item : items) {
			Product product = productService.findById(item.getProduct().getId());
			item.setProduct(product);
		}

		model.addAttribute("buyCart", buyCart);
		
		return "order";
	}
	
	@RequestMapping("/addOrder")
	public String addOrder(...,Model model) {
		//1.创建订单对象
		Order order = new Order();
		//yyyySSS
		order.setOrderNo("201710121640111");
		//.....
		//2.将订单插入数据库
		orderService.add(order);
		
		//3.从Cookie中得到购物车
		BuyCartVO buyCart = getBuyCartFromCooki();
		List<CartItemVO> items = buyCart.getItems();
		for (CartItemVO item : items) {
			OrderItem orderItem = new OrderItem();
			Product product =productService.findById(item.getProduct().getId())
			orderItem.setProductName(product.getName());
			orderItem.setProductImage(product.getMainImage());
			orderService.addOrderItem(orderItem);
		}
		return "";
	}
}
