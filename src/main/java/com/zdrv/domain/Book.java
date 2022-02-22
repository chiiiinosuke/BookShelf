package com.zdrv.domain;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
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
	
	@NotNull
	@Digits(integer = 13, fraction = 0)
	private long isbn;
	
	@NotNull
	@PastOrPresent
	private Date publicationAt;
	
	@NotNull
	private Integer price;
	
}