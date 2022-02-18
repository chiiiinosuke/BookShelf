package com.zdrv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class UserController {
	
	@GetMapping("/userLogin")
	public String userLogin() {
		return "userLogin";
	}
	
	@GetMapping("/userAdd")
	public String userAdd() {
		return "userAdd";
	}
	
	@GetMapping("/userLogout")
	public String userLogout() {
		return "userLogout";
	}
	
}
