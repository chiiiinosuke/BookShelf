package com.zdrv.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdrv.domain.User;

@Controller
@RequestMapping("/book")
public class UserController {
	
	@GetMapping("/userLogin")
	public String userLogin() {
		return "userLogin";
	}
	
	@GetMapping("/userAdd")
	public String userAdd(Model model) {
		var user = new User();
		model.addAttribute("user",user);
		return "userAdd";
	}
	
	@PostMapping("/userAdd")
	public String send(
			@Valid
			@ModelAttribute("user") User user,
			Errors errors,
			Model model
			) {
		System.out.println(user);
		
		if(errors.hasErrors()) {
			return "/userAdd";
		}
		
		//新規登録者情報の送信
		return "userAddDone";
	}
	
	@GetMapping("/userLogout")
	public String userLogout() {
		return "userLogout";
	}
	
}
