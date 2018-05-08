package com.nj.service.imp;

import java.util.List;

import com.nj.dao.CartDao;
import com.nj.dao.GoodDao;
import com.nj.dao.imp.CartDaoImp;
import com.nj.dao.imp.GoodDaoImp;
import com.nj.dom.Cart;
import com.nj.dom.Goods;
import com.nj.service.GoodService;



public class GoodServiceImp implements GoodService {

/**
 * ��ѯ���е���Ʒ
 *//*
	@Override
	public List<Goods> queryall() {
		// TODO Auto-generated method stub
		GoodDao dao=new GoodDaoImp();
		return dao.queryAll();
	}*/
/**
 *��ƷID��ѯ��Ϣ
 */
@Override
public Goods getById(String id) {
	// TODO Auto-generated method stub
	GoodDao dao=new GoodDaoImp();
	return dao.getById(id);
}
/**
 * ������Ʒ
 */
@Override
public void addCart(Cart c) {
	// TODO Auto-generated method stub
	CartDao dao=new CartDaoImp();
	dao.addCart(c);
}
@Override
public void updateCart(Cart c) {
	// TODO Auto-generated method stub
	CartDao dao=new CartDaoImp();
	dao.updateCart(c);
}
/*//������Ʒ��ģ����ѯ��Ʒ
@Override
public List<Goods> getByName(String gname) {
	// TODO Auto-generated method stub
	GoodDao dao=new GoodDaoImp();
	return dao.querygoods(gname);
}*/

//�����ѯ��Ʒ��Ϣ
@Override
public List<Goods> queryrandom() {
	// TODO Auto-generated method stub
	GoodDao dao=new GoodDaoImp();
	return dao.queryRdm();
}
/*//�����ѯ
@Override
public List<Goods> querygt(String gt) {
	// TODO Auto-generated method stub
	GoodDao dao=new GoodDaoImp();
	return dao.querygt(gt);
}*/


}
