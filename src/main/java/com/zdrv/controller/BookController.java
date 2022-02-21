package com.zdrv.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdrv.domain.Book;

@Controller
@RequestMapping("/book/user")
public class BookController {
	
	@GetMapping("/list")
	public String list() {
		
		return "bookList";
		
	}

	@GetMapping("/add")
	public String add() {
		
		return "bookListAdd";
	}
	
	
	@PostMapping("/add")
	public String addPost(
			@Valid Book book,
			Errors errors ) {
		
		//バリデーション
		if (errors.hasErrors()) {
			return "bookListAdd";
		}
		
		//データがOKな場合追加データを表示
		System.out.println(book);
		
		return "redirect:/book/user";
	}
	
	@GetMapping("/search")
	public String search() {
		return "bookSearch";
	}
	
	@GetMapping("/search/result")
	public String searchResult() {
		return "bookSearchResult";
	}
	
	@GetMapping("/detail")
	public String detail() {
		return "bookDetail";
	}
	
	@GetMapping("/edit")
	public String edit() {
		return "bookEdit";
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "bookDelete";
	}
	
	
}
