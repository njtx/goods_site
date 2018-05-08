package com.admin.serviceImp;

import java.util.List;

import com.admin.daoImp.LoginDaoImp;
import com.nj.dom.Goods;
import com.nj.dom.User;

public class LoginServiceImp {
//����Ա��¼
	public User login(String username, String password) {
		LoginDaoImp dao=new LoginDaoImp();
		return dao.login(username,password);
	}
//��ѯ��Ա
	public List<User> query() {
		LoginDaoImp dao=new LoginDaoImp();
		return dao.queryall();
	}
	//ɾ����Ա
	public void deleteUser(int uid) {
		
		LoginDaoImp dao=new LoginDaoImp();
		 dao.delById(uid);
	}
	//ģ����ѯ��Ʒ
	public List<User> getByuName(String name) {
		// TODO Auto-generated method stub
		LoginDaoImp dao=new LoginDaoImp();
		return dao.queryuserByName(name);
	}

}
