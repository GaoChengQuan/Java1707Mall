package com.situ.mall.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;

/**
 * 
 * 商品列表品和商品详情
 */
@Controller
@RequestMapping("/product")
public class FrontProductController {
	@Autowired
	private IProductService productService;
	
	@RequestMapping("/product_list.shtml")
	public String getProductLis(Integer id, Model model) {
		List<Product> list = productService.findCategoryListById(id);
		model.addAttribute("list", list);
		return "product_list";
	}
	
	
	@RequestMapping("/detail.shtml")
	public String getProductDetail(Integer id, Model model) {
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		return "product_detail";
	}
	
}
