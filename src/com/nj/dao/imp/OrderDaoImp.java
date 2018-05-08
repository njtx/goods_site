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
 * ��Ӷ���
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
//��Ӷ�����ϸ��

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
			throw new RuntimeException("��Ӷ�����ϸ��Ϣʧ�ܣ�");
		}
	}
	

}
/**
 * �鿴������ϸ
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
		throw new RuntimeException("�鿴������ϸ��Ϣʧ�ܣ�");
	}
}
/**
 * �鿴������Ϣ
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
		throw new RuntimeException("�鿴������Ϣʧ�ܣ�");
	}
}

/**
 * ɾ��������ϸ
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
		throw new RuntimeException("ɾ��������ϸʧ�ܣ�");
	}
}
/**
 * ɾ��������Ϣ
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
		throw new RuntimeException("ɾ������ʧ�ܣ�");
	}
	
}
//֧��
@Override
public void updateOrder(String orderID, int orderState) {
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	String sql="update orders set orderState=? where orderID=?";

    try {
		qr.update(sql, orderState,orderID);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("֧������ʧ�ܣ�");
	}// TODO Auto-generated method stub
	
	
}
//δ֧��
@Override
public List<Orders> queryNoOrders(int orderstate) {
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	String sql="SELECT * FROM orders WHERE orderState=? ORDER BY orderTime DESC";
	try {
		return qr.query(sql, new BeanListHandler<Orders>(Orders.class), orderstate);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("�鿴������Ϣʧ�ܣ�");
	}
}
//��֧������
public List<Orders> queryZhifuOrders() {
	// TODO Auto-generated method stub
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	String sql="SELECT * FROM orders WHERE orderState=2 ORDER BY orderTime DESC";
	try {
		return qr.query(sql, new BeanListHandler<Orders>(Orders.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("�鿴������Ϣʧ�ܣ�");
	}
}

}
