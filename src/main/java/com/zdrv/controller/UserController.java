package com.zdrv.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdrv.domain.User;
import com.zdrv.service.UserService;

@Controller
@RequestMapping("/book")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/userLogin")
	public String userLogin(Model model ) {
		model.addAttribute("user", new User());
		return "userLogin";
	}
	
	@PostMapping("/userLogin")
	public String loginPost(
			HttpSession session,
			@Valid User user,
			Errors errors) {
		if(errors.hasErrors()) {
			//未入力の場合弾く
			return "userLogin";
		}
		
		User loginUser = service.getLoginUser(user);
		
		//IDまたはパスワードが違う場合
		if (loginUser == null) {
			errors.rejectValue("userLogin", "error.login", "IDまたはパスワードが不正です");
			return "userLogin";
		}
		
		//IDまたはパスワードが正しい場合
		session.setAttribute("user", loginUser);
		return "redirect:/review";
	
	}
	
	@GetMapping("/userLogout")
	public String logout(
			HttpSession session
			) {
		session.invalidate();
		return "redirect:/book/userLogin";
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
	
}
