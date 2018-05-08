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
 * 查询所有的商品
 *//*
	@Override
	public List<Goods> queryall() {
		// TODO Auto-generated method stub
		GoodDao dao=new GoodDaoImp();
		return dao.queryAll();
	}*/
/**
 *商品ID查询信息
 */
@Override
public Goods getById(String id) {
	// TODO Auto-generated method stub
	GoodDao dao=new GoodDaoImp();
	return dao.getById(id);
}
/**
 * 购买商品
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
/*//根据商品名模糊查询商品
@Override
public List<Goods> getByName(String gname) {
	// TODO Auto-generated method stub
	GoodDao dao=new GoodDaoImp();
	return dao.querygoods(gname);
}*/

//随机查询商品信息
@Override
public List<Goods> queryrandom() {
	// TODO Auto-generated method stub
	GoodDao dao=new GoodDaoImp();
	return dao.queryRdm();
}
/*//分类查询
@Override
public List<Goods> querygt(String gt) {
	// TODO Auto-generated method stub
	GoodDao dao=new GoodDaoImp();
	return dao.querygt(gt);
}*/


}
