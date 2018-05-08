package com.nj.dao;

import com.nj.dom.User;

public interface EditDao {
	//query个人设置
	User info(String username);
	//修改个人设置
	void info1(User user);

}
