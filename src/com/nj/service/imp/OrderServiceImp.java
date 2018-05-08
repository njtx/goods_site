package com.nj.service.imp;

import java.util.List;

import com.nj.dao.CartDao;
import com.nj.dao.GoodDao;
import com.nj.dao.OrderDao;
import com.nj.dao.imp.CartDaoImp;
import com.nj.dao.imp.GoodDaoImp;
import com.nj.dao.imp.OrderDaoImp;
import com.nj.dom.Goods;
import com.nj.dom.OrderDetails;
import com.nj.dom.Orders;
import com.nj.service.OrderService;

public class OrderServiceImp implements OrderService {

	OrderDao dao=new OrderDaoImp();
	/**
	 * ��Ӷ���
	 */
	@Override
	public void addOrders(Orders orders) {
		// TODO Auto-generated method stub
		//��Ӷ�����Ͷ�����ϸ��
        dao.addOrders(orders);
		dao.addOrderDetails(orders.getOdlist());
		//��չ��ﳵ,�����û�id
		CartDao cdao=new CartDaoImp();
		cdao.clear(orders.getuId());
	}	
/**
 * ��ѯ����
 */
@Override
public List<Orders> queryOrders(int id) {
	// 1. ��ѯ���ж�����Ϣ
	List<Orders>olist= dao.queryOrders(id);
	//2 ��ѯÿ�������µ����ж�����ϸ
	for(Orders o:olist)
	{
		List<OrderDetails>odetails=dao.querydetails(o.getOrderID());
		// ����������ϸ����ѯÿ��������ϸ��Ӧ����Ʒ��Ϣ
		for(OrderDetails details:odetails)
		{
			GoodDao gooddao=new GoodDaoImp();
			Goods goods = gooddao.getById(details.getGid() + "");
			details.setGoods(goods);
		}
		o.setOdlist(odetails);
	}
	return olist;
	 
}
/*
 * ɾ������
 * @see com.nj.service.OrderService#deleteOrder(java.lang.String)
 */
@Override
public void deleteOrder(String orderid) {
	// TODO Auto-generated method stub
	
	//ɾ��������ϸ
	    dao.deleteOds(orderid);
	//ɾ������
	    dao.deleteOrder(orderid);
}
//֧��
@Override
public void updateOrder(String orderID, int orderState) {
	// TODO Auto-generated method stub
	dao.updateOrder(orderID,orderState);
}
//δ֧������
@Override
public List<Orders> queryNozhifu(int orderstate) {
	// TODO Auto-generated method stub
	// 1. ��ѯ���ж�����Ϣ
		List<Orders>olist= dao.queryNoOrders(orderstate);
		return olist;
}
// * ��ѯ��֧������
public List<Orders> queryZhifuOrders() {
	// TODO Auto-generated method stub
	// 1. ��ѯ���ж�����Ϣ
	OrderDaoImp dao=new OrderDaoImp();
		List<Orders>olist= dao.queryZhifuOrders();
		//2 ��ѯÿ�������µ����ж�����ϸ
		for(Orders o:olist)
		{
			List<OrderDetails>odetails=dao.querydetails(o.getOrderID());
			// ����������ϸ����ѯÿ��������ϸ��Ӧ����Ʒ��Ϣ
			for(OrderDetails details:odetails)
			{
				GoodDao gooddao=new GoodDaoImp();
				Goods goods = gooddao.getById(details.getGid() + "");
				details.setGoods(goods);
			}
			o.setOdlist(odetails);
		}
		return olist;
}


}
