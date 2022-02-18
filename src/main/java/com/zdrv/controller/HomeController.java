package com.zdrv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/book")
@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String Home() {
		return "index";
	}
	
	
}
