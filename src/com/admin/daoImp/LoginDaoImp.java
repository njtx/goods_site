package com.admin.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.nj.dom.Goods;
import com.nj.dom.User;
import com.nj.util.DBUtils;

public class LoginDaoImp {
	//管理员登录
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="select * from user where username=? and password=? and role='a'";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class), username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("管理员登录失败！");
		}
	}
	//查询会员
	public List<User> queryall() {
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="select * from user where role='b'";
		try {
			return qr.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询会员失败！");
		}
	}
	//删除会员
	public void delById(int uid) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="delete from user where id=? ";
		try {
			 qr.update(sql,uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除会员失败！");
		}
	}
	
	//模糊查询用户名
	public List<User> queryuserByName(String name) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="SELECT * FROM user WHERE username LIKE ? ";
		try
		{
			return qr.query(sql,new BeanListHandler<User>(User.class),"%"+name+"%");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("根据用户名模糊查询用户信息失败！！");
		}
	}

}
