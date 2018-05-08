package com.admin.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.nj.dom.Orders;
import com.nj.dom.OrdersAndUser;
import com.nj.util.DBUtils;

public class OrdersDaoImp {

	public List<OrdersAndUser> queryOrders() {
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		
		String sql="SELECT o.* ,u.username FROM orders o INNER JOIN  USER u ON o.uId=u.`id` ";
		//String sql="SELECT * FROM orders  ORDER BY orderTime DESC";
		try {
			return qr.query(sql, new BeanListHandler<OrdersAndUser>(OrdersAndUser.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查看订单信息失败！");
		}
	}

	public List<OrdersAndUser> queryByuname(String name) {
QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		
		String sql="SELECT o.* ,u.username FROM orders o INNER JOIN  USER u ON o.uId=u.`id` where u.username like ?";
		//String sql="SELECT * FROM orders  ORDER BY orderTime DESC";
		try {
			return qr.query(sql, new BeanListHandler<OrdersAndUser>(OrdersAndUser.class),"%"+name+"%");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查看订单信息失败！");
		}
	}

}
