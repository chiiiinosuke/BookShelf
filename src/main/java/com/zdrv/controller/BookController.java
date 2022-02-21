package com.zdrv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
