package com.nj.service;

import java.util.List;

import com.nj.dom.Cart;
import com.nj.dom.Goods;


public interface GoodService {
/*//查询所有的商品信息
	List<Goods> queryall();*/
//根据商品ID查询信息的方法
	Goods getById(String id);
	//添加商品
	void addCart(Cart c);
	//更新商品数量
	void updateCart(Cart c);
	/*//根据商品名模糊查询商品
	List<Goods> getByName(String gname);*/
	//随机查询商品信息
	List<Goods> queryrandom();
	/*//分类查询
	List<Goods> querygt(String gt);*/
	
}
