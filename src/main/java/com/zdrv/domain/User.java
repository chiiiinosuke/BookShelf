package com.zdrv.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.zdrv.validation.AddGroup;
import com.zdrv.validation.LoginGroup;

import lombok.Data;


@Data
public class User {
	
	private Integer id;
	
	@NotBlank (groups={AddGroup.class,LoginGroup.class})
	@Size(max=10, groups={AddGroup.class,LoginGroup.class})
	private String loginId;
	
	@NotBlank (groups={AddGroup.class,LoginGroup.class})
	@Size(min = 6, groups={AddGroup.class,LoginGroup.class})
	@Size(max=50, groups={AddGroup.class,LoginGroup.class})
	private String loginPass;
	
	@NotBlank (groups={AddGroup.class})
	@Size(max=20)
	private String name;
	
	@NotBlank (groups={AddGroup.class})
	@Email
	private String email;
	
	
	private Integer level;
	
	
	private String status;
	
	
	
}
