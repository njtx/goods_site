package com.nj.service;

import com.nj.dom.User;

public interface EditService {
	//�鿴��������
	User queryInfo(String username);
	//�޸ĸ�������
	void editInfo(User user);



}
