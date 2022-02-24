package com.zdrv.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class User {
	
	private Integer id;
	
	@NotBlank
	@Size(max=10)
	private String loginId;
	
	@NotBlank
	@Size(min = 6)
	@Size(max=50)
	private String loginPass;
	
	@NotBlank
	@Size(max=20)
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	
	private Integer level;
	
	
	private String status;
	
	
	
}
