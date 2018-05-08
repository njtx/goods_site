package com.nj.service.imp;

import com.nj.dao.UserDao;
import com.nj.dao.imp.UserDaoImp;
import com.nj.dom.User;
import com.nj.service.UserService;
import com.nj.util.MD5Utils;


public class UserServiceImp implements UserService {

	@Override
	public void register(User user) {
		/*// 对密码进行加密
		String password=MD5Utils.str2MD5(user.getPassword());
        //将加密好的用户密码放到user对象中
		user.setPassword(password);*/
		//调用Dao,进行数据库操作
		UserDao dao=new UserDaoImp();
		dao.register(user);
	}
	/*
	 * login
	 * */
	public User login(String username,String password)
	{
		/*//对密码进行加密
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
