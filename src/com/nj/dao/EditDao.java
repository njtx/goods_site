package com.nj.dao;

import com.nj.dom.User;

public interface EditDao {
	//query��������
	User info(String username);
	//�޸ĸ�������
	void info1(User user);

}
