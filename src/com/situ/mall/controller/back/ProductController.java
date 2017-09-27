package com.situ.mall.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService productService;

	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<Product> list = productService.findAll();
		model.addAttribute("list", list);
		System.out.println(list);
		return "product_list";
	}
	
	@RequestMapping("/deletById")
	public String deletById(int id) {
		productService.deletById(id);
		return "redirect:/product/findAll.action";
	}
	
	
	@RequestMapping("/getAddPage")
	public String getAddPage(Model model){
		return "product_add";
	}
	
	@RequestMapping("/add")
	public String add(Product product){
		productService.add(product);
		return "redirect:/product/findAll.action";
	}
	
}
