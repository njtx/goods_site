package com.nj.dao;

import com.nj.dom.User;

public interface UserDao {
//ע�᷽��
	void register(User user);
//��¼����
	User login(String username, String pwd);
	//��֤
	int checkUserName(String username);

}
