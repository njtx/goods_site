package com.nj.service.imp;

import com.nj.dao.UserDao;
import com.nj.dao.imp.UserDaoImp;
import com.nj.dom.User;
import com.nj.service.UserService;
import com.nj.util.MD5Utils;


public class UserServiceImp implements UserService {

	@Override
	public void register(User user) {
		/*// ��������м���
		String password=MD5Utils.str2MD5(user.getPassword());
        //�����ܺõ��û�����ŵ�user������
		user.setPassword(password);*/
		//����Dao,�������ݿ����
		UserDao dao=new UserDaoImp();
		dao.register(user);
	}
	/*
	 * login
	 * */
	public User login(String username,String password)
	{
		/*//��������м���
		String pwd=MD5Utils.str2MD5(password);*/
		UserDao dao=new UserDaoImp();
		return dao.login(username,password);
	}
/**
 * check
 */
	public int checkUserName(String username)
	{
		UserDao dao=new UserDaoImp();
		return dao.checkUserName(username);

	}

}
