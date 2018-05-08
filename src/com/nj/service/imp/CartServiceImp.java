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
	 * 根据用户Id查询购物车的商品信息
	 */
	@Override
	public List<Cart> queryCart(int id) {
		// TODO Auto-generated method stub
		//先查询购物车信息
		List<Cart>clist=dao.queryCart(id);
		//如果购物车里没有商品对象，需要遍历查询商品信息
		for (Cart cart:clist)
		{
			int gid=cart.getGid();
			Goods g=goodDao.getById(gid+"");
			cart.setGoods(g);
			
		}
		return clist;
		
		
		
	}
/**
 * 删除购物车的商品
 */
	@Override
	public void deleteCart(int uid, int gid) {
		// TODO Auto-generated method stub
		CartDao dao=new CartDaoImp();
		 dao.deleteCart(uid,gid);
	}
/*
 * 更新购物车数量
 * @see service.CartService#update(int, int, int)
 */
@Override
public void update(int uid, int gid, int carnum) {
     CartDao dao=new CartDaoImp();
     //创建购物车对象
     Cart cart=new Cart();
     cart.setCartNum(carnum);
     cart.setGid(gid);
     cart.setUid(uid);
     dao.updateCart(cart);
}



	
}
