package com.situ.mall.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;
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
	@ResponseBody
	public ServerResponse add(Product product){
		return productService.add(product);
	}
	
	@RequestMapping("/findAllJson")
	@ResponseBody
	public ServerResponse<List<Product>> findAllJson(Model model) {
		return productService.findAllJson();
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public ServerResponse show(Integer id) {
		return productService.show(id);
	}
	
}
