package com.zdrv.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdrv.domain.Book;

@Controller
@RequestMapping("/book/user")
public class BookController {
	
	@InitBinder
	public void initBinderForm(WebDataBinder binder) {
		var sdf = new SimpleDateFormat("y-MM-dd");
		binder.registerCustomEditor(Date.class, "publicationAt", new CustomDateEditor(sdf, true));
	}
	
	@GetMapping({"", "/list"})
	public String list() {
		return "bookList";
	}

	@GetMapping("/add")
	public String show(Model model) {
		var book = new Book();
		model.addAttribute("book",book);
		return "bookListAdd";
	}
	
	@PostMapping("/add")
	public String send(
			@Valid
			@ModelAttribute("book") Book book,
			Errors errors,
			Model model
			) {
		System.out.println(book);
		
		if(errors.hasErrors()) {
			System.out.println("-- エラー内容の補足 --");
			for (ObjectError e : errors.getAllErrors()) {
				System.out.println(e);
			}
			
			return "bookListAdd";
		}
		
		//追加書籍情報を送信
		return "bookListAddDone";
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
