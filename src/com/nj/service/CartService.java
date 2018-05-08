package com.nj.service;

import java.util.List;

import com.nj.dom.Cart;


public interface CartService {
	//购物车记录
 Cart queryRecord(String gid, int uid);
//查看购物车的商品
List<Cart> queryCart(int id);
//删除购物车
void deleteCart(int uid, int gid);
//更新购物车数量
void update(int uid, int gid, int carnum);



}
