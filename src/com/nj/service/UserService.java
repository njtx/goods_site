package com.nj.service;

import com.nj.dom.User;

public interface UserService {
//�û�ע��ķ���
	public void register(User user);
//�û���¼�ķ���
	public User login(String username, String pwd);
//��֤�û��Ƿ����
	public int checkUserName(String username);

}
