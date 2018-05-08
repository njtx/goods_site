package com.nj.dao.imp;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.nj.dao.EditDao;
import com.nj.dom.Cart;
import com.nj.dom.User;
import com.nj.util.DBUtils;

public class EditDaoImp implements EditDao {
	//query个人设置
	@Override
	public User info(String username) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="select * from user where username=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查看个人设置失败！");
		}
	}
	//修改个人设置
	@Override
	public void info1(User user) {
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="update user set nickname=?,password=? where username=?";
		try {
			 qr.update(sql,user.getNickname(),user.getPassword(),user.getUsername());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("修改个人设置失败！");
		}
	}

}
