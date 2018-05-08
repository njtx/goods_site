package com.nj.dao;

import java.util.List;

import com.nj.dom.OrderDetails;
import com.nj.dom.Orders;

public interface OrderDao {
//添加订单
	void addOrders( Orders orders);
	//添加订单明细表
	void addOrderDetails(List<OrderDetails> list);
	//查看订单明细表
	 List<OrderDetails> querydetails(String orderID);
	  //查看订单信息
	List<Orders> queryOrders(int id);
	
	//删除订单明细表
	void deleteOds(String orderid);
	
	//删除订单信息
	void deleteOrder(String orderid);
	//支付
	void updateOrder(String orderID, int orderState);
	//未支付
	List<Orders> queryNoOrders(int orderstate);

}
