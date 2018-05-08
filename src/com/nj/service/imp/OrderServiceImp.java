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
	 * 添加订单
	 */
	@Override
	public void addOrders(Orders orders) {
		// TODO Auto-generated method stub
		//添加订单表和订单明细表
        dao.addOrders(orders);
		dao.addOrderDetails(orders.getOdlist());
		//清空购物车,根据用户id
		CartDao cdao=new CartDaoImp();
		cdao.clear(orders.getuId());
	}	
/**
 * 查询订单
 */
@Override
public List<Orders> queryOrders(int id) {
	// 1. 查询所有订单信息
	List<Orders>olist= dao.queryOrders(id);
	//2 查询每个订单下的所有订单明细
	for(Orders o:olist)
	{
		List<OrderDetails>odetails=dao.querydetails(o.getOrderID());
		// 遍历订单明细，查询每个订单明细对应的商品信息
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
 * 删除订单
 * @see com.nj.service.OrderService#deleteOrder(java.lang.String)
 */
@Override
public void deleteOrder(String orderid) {
	// TODO Auto-generated method stub
	
	//删除订单明细
	    dao.deleteOds(orderid);
	//删除订单
	    dao.deleteOrder(orderid);
}
//支付
@Override
public void updateOrder(String orderID, int orderState) {
	// TODO Auto-generated method stub
	dao.updateOrder(orderID,orderState);
}
//未支付订单
@Override
public List<Orders> queryNozhifu(int orderstate) {
	// TODO Auto-generated method stub
	// 1. 查询所有订单信息
		List<Orders>olist= dao.queryNoOrders(orderstate);
		return olist;
}
// * 查询已支付订单
public List<Orders> queryZhifuOrders() {
	// TODO Auto-generated method stub
	// 1. 查询所有订单信息
	OrderDaoImp dao=new OrderDaoImp();
		List<Orders>olist= dao.queryZhifuOrders();
		//2 查询每个订单下的所有订单明细
		for(Orders o:olist)
		{
			List<OrderDetails>odetails=dao.querydetails(o.getOrderID());
			// 遍历订单明细，查询每个订单明细对应的商品信息
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
