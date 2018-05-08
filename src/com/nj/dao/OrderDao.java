package com.nj.dao;

import java.util.List;

import com.nj.dom.OrderDetails;
import com.nj.dom.Orders;

public interface OrderDao {
//��Ӷ���
	void addOrders( Orders orders);
	//��Ӷ�����ϸ��
	void addOrderDetails(List<OrderDetails> list);
	//�鿴������ϸ��
	 List<OrderDetails> querydetails(String orderID);
	  //�鿴������Ϣ
	List<Orders> queryOrders(int id);
	
	//ɾ��������ϸ��
	void deleteOds(String orderid);
	
	//ɾ��������Ϣ
	void deleteOrder(String orderid);
	//֧��
	void updateOrder(String orderID, int orderState);
	//δ֧��
	List<Orders> queryNoOrders(int orderstate);

}
