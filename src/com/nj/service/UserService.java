package com.nj.service;

import com.nj.dom.User;

public interface UserService {
//用户注册的方法
	public void register(User user);
//用户登录的方法
	public User login(String username, String pwd);
//验证用户是否存在
	public int checkUserName(String username);

}
