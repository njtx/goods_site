package com.nj.service.imp;

import com.nj.dao.EditDao;
import com.nj.dao.imp.EditDaoImp;
import com.nj.dom.User;
import com.nj.service.EditService;

public class EditServiceImp implements EditService {
	//query��������
	@Override
	public User queryInfo(String username) {
		// TODO Auto-generated method stub
		EditDao dao=new EditDaoImp();
		return dao.info(username);
	}
	//�޸ĸ�������
	@Override
	public void editInfo(User user) {
		EditDao dao=new EditDaoImp();
		 dao.info1(user );
		
	}
	
}
