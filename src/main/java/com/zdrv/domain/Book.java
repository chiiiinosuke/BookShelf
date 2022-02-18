package com.zdrv.domain;

import lombok.Data;

@Data
public class Book {
	
	private Integer id;
	private String loginId;
	private String bookName;
	private String author;
	private String publisher ;
	private Integer isbn;
	
}
