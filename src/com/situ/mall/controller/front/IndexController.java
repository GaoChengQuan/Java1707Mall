package com.situ.mall.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index.shtml")
	public String index() {
		
		
		return "index";
	}

	// 商品身体
	/*@RequestMapping(value = "/list.shtml")
	public String productMain() {

		
	}*/

}
