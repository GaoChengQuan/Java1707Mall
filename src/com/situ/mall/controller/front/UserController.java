package com.situ.mall.controller.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/getLoginPage")
	public String getLoginPage() {
		return "login_layer";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public ServerResponse login(String name, String password, HttpServletRequest request) {
		System.out.println("name:" + name);
		System.out.println("password:" + password);
		if (null != name && name.equals("gao")) {
			HttpSession session = request.getSession();
			session.setAttribute("name", "gao");
			return ServerResponse.createSuccess("登录成功");
		}
		return ServerResponse.createError("登录失败");
	}
}
