package com.nj.dao;

import com.nj.dom.User;

public interface UserDao {
//注册方法
	void register(User user);
//登录方法
	User login(String username, String pwd);
	//验证
	int checkUserName(String username);

}
