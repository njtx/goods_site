package com.admin.serviceImp;

import java.util.List;

import com.admin.daoImp.OrdersDaoImp;
import com.nj.dom.Orders;
import com.nj.dom.OrdersAndUser;

public class OrdersServiceImp {
	//�鿴����
	public List<OrdersAndUser> queryOrder() {
		// TODO Auto-generated method stub
		OrdersDaoImp dao=new OrdersDaoImp();
		List<OrdersAndUser>olist= dao.queryOrders();
		return olist;
	}

	public List<OrdersAndUser> getByuName(String name) {
		OrdersDaoImp dao=new OrdersDaoImp();
		List<OrdersAndUser>olist= dao.queryByuname(name);
		return olist;
	}


}
