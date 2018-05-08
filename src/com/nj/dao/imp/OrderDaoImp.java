package com.nj.dao.imp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.nj.dao.OrderDao;
import com.nj.dom.OrderDetails;
import com.nj.dom.Orders;
import com.nj.util.DBUtils;

public class OrderDaoImp implements OrderDao {
/**
 * 添加订单
 */
@Override
public void addOrders(Orders orders) {
	// TODO Auto-generated method stub
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	String sql="insert into orders values(?,?,?,?,?,?)";
	try {
		qr.update(sql, orders.getOrderID(),orders.getuId(),
				orders.getOrderTime(),orders.getOrderMoney(),orders.getOrderAddress(),
				orders.getOrderState());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//添加订单明细表

@Override
public void addOrderDetails( List<OrderDetails> list) {
	// TODO Auto-generated method stub
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	String sql="insert into orderdetails VALUES (?,?,?)";
	for(OrderDetails o:list)
	{
		try {
			qr.update(sql,o.getOid(),o.getGid(),o.getCarNum());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("添加订单明细信息失败！");
		}
	}
	

}
/**
 * 查看订单明细
 */
@Override
public List<OrderDetails> querydetails(String orderID) {
	// TODO Auto-generated method stub
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	String sql="SELECT * FROM orderdetails WHERE oId=?";
	try {
		return qr.query(sql, new BeanListHandler<OrderDetails>(OrderDetails.class), orderID);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("查看订单明细信息失败！");
	}
}
/**
 * 查看订单信息
 */
@Override
public List<Orders> queryOrders(int id) {
	// TODO Auto-generated method stub
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	String sql="SELECT * FROM orders WHERE uId=? and orderState=1 ORDER BY orderTime DESC";
	try {
		return qr.query(sql, new BeanListHandler<Orders>(Orders.class), id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("查看订单信息失败！");
	}
}

/**
 * 删除订单明细
 */
@Override
public void deleteOds(String orderid) {
	// TODO Auto-generated method stub
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	String sql="DELETE FROM orderdetails WHERE oId=? ";
    try {
		qr.update(sql, orderid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("删除订单明细失败！");
	}
}
/**
 * 删除订单信息
 */
@Override
public void deleteOrder(String orderid) {
	// TODO Auto-generated method stub
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	String sql="DELETE FROM orders WHERE orderID=? ";
    try {
		qr.update(sql, orderid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("删除订单失败！");
	}
	
}
//支付
@Override
public void updateOrder(String orderID, int orderState) {
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	String sql="update orders set orderState=? where orderID=?";

    try {
		qr.update(sql, orderState,orderID);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("支付订单失败！");
	}// TODO Auto-generated method stub
	
	
}
//未支付
@Override
public List<Orders> queryNoOrders(int orderstate) {
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	String sql="SELECT * FROM orders WHERE orderState=? ORDER BY orderTime DESC";
	try {
		return qr.query(sql, new BeanListHandler<Orders>(Orders.class), orderstate);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("查看订单信息失败！");
	}
}
//已支付订单
public List<Orders> queryZhifuOrders() {
	// TODO Auto-generated method stub
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	String sql="SELECT * FROM orders WHERE orderState=2 ORDER BY orderTime DESC";
	try {
		return qr.query(sql, new BeanListHandler<Orders>(Orders.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("查看订单信息失败！");
	}
}

}
