package com.nj.service.imp;

import java.util.List;

import com.nj.dao.CartDao;
import com.nj.dao.GoodDao;
import com.nj.dao.imp.CartDaoImp;
import com.nj.dao.imp.GoodDaoImp;
import com.nj.dom.Cart;
import com.nj.dom.Goods;
import com.nj.service.CartService;


public class CartServiceImp implements CartService {
	CartDao dao=new CartDaoImp();
	GoodDao goodDao=new GoodDaoImp();
	public  Cart queryRecord(String gid, int uid)
	 {
		
		return dao.quertRecord(gid,uid);
	 }
	/**
	 * �����û�Id��ѯ���ﳵ����Ʒ��Ϣ
	 */
	@Override
	public List<Cart> queryCart(int id) {
		// TODO Auto-generated method stub
		//�Ȳ�ѯ���ﳵ��Ϣ
		List<Cart>clist=dao.queryCart(id);
		//������ﳵ��û����Ʒ������Ҫ������ѯ��Ʒ��Ϣ
		for (Cart cart:clist)
		{
			int gid=cart.getGid();
			Goods g=goodDao.getById(gid+"");
			cart.setGoods(g);
			
		}
		return clist;
		
		
		
	}
/**
 * ɾ�����ﳵ����Ʒ
 */
	@Override
	public void deleteCart(int uid, int gid) {
		// TODO Auto-generated method stub
		CartDao dao=new CartDaoImp();
		 dao.deleteCart(uid,gid);
	}
/*
 * ���¹��ﳵ����
 * @see service.CartService#update(int, int, int)
 */
@Override
public void update(int uid, int gid, int carnum) {
     CartDao dao=new CartDaoImp();
     //�������ﳵ����
     Cart cart=new Cart();
     cart.setCartNum(carnum);
     cart.setGid(gid);
     cart.setUid(uid);
     dao.updateCart(cart);
}



	
}
