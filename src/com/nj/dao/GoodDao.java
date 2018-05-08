package com.nj.dao;

import java.util.List;

import com.nj.dom.Goods;


public interface GoodDao {
/*//查询所有商品的方法
	List<Goods> queryAll();*/
//根据商品ID查询信息方法
	Goods getById(String id);
	//获取总记录数
	int getCount();
	/*//根据商品名模糊查询商品
	List<Goods> querygoods(String gname);*/
	//获取模糊查询的总记录数
	int getCount(String gname);
	//随机查询商品信息
	List<Goods> queryRdm();
	//获取分类查询的总记录数
	int getCountType(String gname);
	/*//分类查询
	List<Goods> querygt(String gt);*/
	

}
