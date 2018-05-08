package com.nj.service;

import com.nj.dom.User;

public interface EditService {
	//查看个人设置
	User queryInfo(String username);
	//修改个人设置
	void editInfo(User user);



}
