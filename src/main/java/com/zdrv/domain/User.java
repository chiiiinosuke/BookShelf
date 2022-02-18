package com.zdrv.domain;

import lombok.Data;

@Data
public class User {
	
	private Integer id;
	private String loginId;
	private String loginPass;
	private String name;
	private String email;
	private Integer level;
	private String status ;
	
}
