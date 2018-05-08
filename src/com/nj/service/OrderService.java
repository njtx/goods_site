package com.nj.service;

import java.util.List;

import com.nj.dom.Orders;

public interface OrderService {
   //添加订单以及订单明细集合
	void addOrders(Orders orders);
  //查询订单
	List<Orders> queryOrders(int id);
	//删除订单
	void deleteOrder(String orderid);
	//支付
	void updateOrder(String orderID, int orderState);
	//未支付订单
	List<Orders> queryNozhifu(int orderstate);

}
