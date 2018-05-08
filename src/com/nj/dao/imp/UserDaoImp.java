package com.nj.dao.imp;

import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.nj.dao.UserDao;
import com.nj.dom.User;
import com.nj.util.DBUtils;



public class UserDaoImp implements UserDao {

	@Override
	public void register(User user) {
		// 执行注册语句
		// 创建数据库访问对象
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="insert into user values (null,?,?,?,'b')";
		try {
			qr.update(sql, user.getUsername(),user.getNickname(),user.getPassword(),user.getRole());
		    //qr.update(sql, param)param作为用来更新语句的置换参数条件
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("注册用户信息失败！");
		}
		
	}
	//查询用户名的数量
			public int checkUserName(String username)
			{
				QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
				String sql="select count(0) from user where username=? ";
				try
				{
				/**
				 * qr.query(sql, rsh, params)rsh作为resultSetHandler,param作为查询语句的条件
				 *rsh作为resultSetHandler，该接口用于处理 java.sql.ResultSet，将数据按要求转换为另一种形式。
				 *  intvalue()是把object类型转换成int类型
				 */
					
					return qr.query(sql,new ScalarHandler<Long>(), username).intValue();	
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					throw new RuntimeException("根据用户名查询数量失败！");
					
				}
				
			}
	//登录
			public User login(String username,String pwd)
			{
				//创建数据库访问对象
				QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
				String sql="select * from user where username=? and password=? and role='b' ";
				try
				{
				 return qr.query(sql,new BeanHandler<User>(User.class),username,pwd);	
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					throw new RuntimeException("用户登录失败！");
				}
			}
}
