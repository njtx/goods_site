package com.nj.service;

import java.util.List;

import com.nj.dom.Orders;

public interface OrderService {
   //��Ӷ����Լ�������ϸ����
	void addOrders(Orders orders);
  //��ѯ����
	List<Orders> queryOrders(int id);
	//ɾ������
	void deleteOrder(String orderid);
	//֧��
	void updateOrder(String orderID, int orderState);
	//δ֧������
	List<Orders> queryNozhifu(int orderstate);

}
