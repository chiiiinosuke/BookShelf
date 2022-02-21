package com.zdrv.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Book {
	
	@NotBlank
	@Size(max=50)
	private String bookName;
	
	@NotBlank
	@Size(max=20)
	private String author;
	
	@NotBlank
	@Size(max=20)
	private String publisher;
	
	@NotBlank
	private int isbn;
	
}
