package com.zdrv.service;

import com.zdrv.domain.User;

public interface UserService {
	
	User getLoginUser(User loginInfo);
	
	void addUser(User userInfo);
	
}
