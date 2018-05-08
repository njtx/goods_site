package com.nj.dao;

import java.util.List;

import com.nj.dom.Cart;


public interface CartDao {
//购物车记录
	Cart quertRecord(String gid, int uid);
//购买商品
	void addCart(Cart c);
	//更新商品数量
	void updateCart(Cart c);
	//查看购物车
	List<Cart> queryCart(int id);
	//删除商品
	void deleteCart(int uid, int gid);
	//清空购物车
	void clear(int getuId);

}
