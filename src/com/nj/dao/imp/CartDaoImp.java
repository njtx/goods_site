package com.nj.dao.imp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.nj.dao.CartDao;
import com.nj.dom.Cart;
import com.nj.util.DBUtils;



public class CartDaoImp implements CartDao {

	@Override
	public Cart quertRecord(String gid, int uid) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="select * from cart where uid=? and gid=?";
		try {
			return qr.query(sql, new BeanHandler<Cart>(Cart.class),uid,gid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询购物记录失败！");
		}
	}
/**
 * 购买商品
 */
	@Override
	public void addCart(Cart c) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="insert into cart values(?,?,?)";
		try {
			 qr.update(sql,c.getUid(),c.getGid(),c.getCartNum());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("添加购物车失败！");
		}
	}
	/**
	 * 更新
	 */
@Override
public void updateCart(Cart c) {
	// TODO Auto-generated method stub
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	String sql="update cart set cartNum=? where uid=? and gid=?";
	try {
		 qr.update(sql,c.getCartNum(),c.getUid(),c.getGid());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("更新购物车失败！");
	}
}
/**
 * 查看购物车
 */
@Override
public List<Cart> queryCart(int id) {
	// TODO Auto-generated method stub
	//声明数据库访问对象
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	String sql="select * from cart where uid=?";
	
	try {
		return qr.query(sql, new BeanListHandler<Cart>(Cart.class),id);
	} catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("查看购物车失败！");
	}
}
/**
 * 清空购物车
 */
@Override
public void deleteCart(int uid, int gid) {
    QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
    String sql="delete from cart where uid=? and gid=?";
	try {
		qr.update(sql, uid,gid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("删除购物车商品失败！");
	}
}
/**
 * 清空购物车
 */
@Override
public void clear(int getuId) {
	// TODO Auto-generated method stub
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	String sql="delete from cart where uid=?";
	try {
		qr.update(sql, getuId);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
