package com.zdrv.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdrv.domain.User;
import com.zdrv.mapper.UserMapper;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	//ログインID確認のために使用可能にしておく
	@Autowired
	private UserMapper mapper;
	
	@Override
	public User getLoginUser(User loginInfo) {
		//ログインIDが正しいかの確認
		User user = mapper.findByLoginId(loginInfo.getLoginId());
		if (user == null) {
		  System.out.println("ログインIDが不正です");
		  return null;
		}
		
		
		//パスワードが正しいかの確認
		if(!BCrypt.checkpw(loginInfo.getLoginPass(), user.getLoginPass())) {
			System.out.println("パスワードが不正です");
			return null;
		}
		
		//ログインIDとパスワードが正しい処理
		return user;
		
		
	}
	
	
	
	
}
