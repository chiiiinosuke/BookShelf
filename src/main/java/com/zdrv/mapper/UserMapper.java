package com.zdrv.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zdrv.domain.User;

@Mapper
public interface UserMapper {
	
	//1つのユーザーのログイン情報を取得
	User findByLoginId(String loginId);
	
	// ユーザーの追加
	void insert(User user);
	
	
	//ユーザーリストをすべて取得
	//List<User> findAll();
	
	//1つのユーザーのログインIDとパスワードを取得(ログイン時に使用)
	// User findByLoginAndPass(String loginId, String loginPass);
	
	
}
