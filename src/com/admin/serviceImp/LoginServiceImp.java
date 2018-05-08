package com.admin.serviceImp;

import java.util.List;

import com.admin.daoImp.LoginDaoImp;
import com.nj.dom.Goods;
import com.nj.dom.User;

public class LoginServiceImp {
//管理员登录
	public User login(String username, String password) {
		LoginDaoImp dao=new LoginDaoImp();
		return dao.login(username,password);
	}
//查询会员
	public List<User> query() {
		LoginDaoImp dao=new LoginDaoImp();
		return dao.queryall();
	}
	//删除会员
	public void deleteUser(int uid) {
		
		LoginDaoImp dao=new LoginDaoImp();
		 dao.delById(uid);
	}
	//模糊查询商品
	public List<User> getByuName(String name) {
		// TODO Auto-generated method stub
		LoginDaoImp dao=new LoginDaoImp();
		return dao.queryuserByName(name);
	}

}
