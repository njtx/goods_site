package com.admin.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.nj.dom.Goods;
import com.nj.util.DBUtils;

public class GoodsDaoImp {

	public void delByodeid(int gid) {
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="DELETE FROM orderdetails WHERE gid=? ";
		try {
			 qr.update(sql,gid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除外键失败！");
		}
		
	}
	//删除商品利用商品编号
	public void delById(int gid) {
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="delete from goods where goodId=? ";
		try {
			 qr.update(sql,gid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除商品失败！");
		}
		
	}
	//add goods
	public void addgoods(Goods goods) {
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="insert into goods values (null,?,?,?,?,?,?,?)";
		try {
			qr.update(sql, goods.getGoodName(),goods.getGoodPrice(),goods.getGoodYprice(),
					goods.getGoodPath(),goods.getGoodDescript(),goods.getGoodNum(),goods.getGoodType());
		    //qr.update(sql, param)param作为用来更新语句的置换参数条件
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("添加商品信息失败！");
		}
		
	}
	
	//检查商品名是否一致
	public int checkgname(String gname) {
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="select count(0) from goods where goodName=? ";
		try
		{
		/**
		 * qr.query(sql, rsh, params)rsh作为resultSetHandler,param作为查询语句的条件
		 *rsh作为resultSetHandler，该接口用于处理 java.sql.ResultSet，将数据按要求转换为另一种形式。
		 *  intvalue()是把object类型转换成int类型
		 */
			
			return qr.query(sql,new ScalarHandler<Long>(), gname).intValue();	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("根据商品名查询数量失败！");
			
		}
	}
	//分类查询
	public List<Goods> querygt(String type) {
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());

		String sql="SELECT * FROM goods WHERE goodType=?";
		try
		{
			return qr.query(sql,new BeanListHandler<Goods>(Goods.class),type);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("分类查询商品信息失败！！");
		}
	}
	//商品ID查询商品详细
	public Goods getById(String gid) {
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="select * from goods where goodId=?";
		try
		{
			return qr.query(sql,new BeanHandler<Goods>(Goods.class),gid);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("根据ID查询商品信息失败！！");
		}
	}
	//修改商品信息 
	public void editGoods(Goods goods,String gname) {
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="update goods set goodPrice=?,goodYprice=?," +
				"goodDescript=?,goodNum=?,goodType=? where goodName=?";
		try {
			 qr.update(sql,goods.getGoodPrice(),goods.getGoodYprice(),
					   goods.getGoodDescript(),goods.getGoodNum(),goods.getGoodType(), gname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("修改商品信息失败！");
		}
		
	}
	
	/*//模糊查询商品
	public List<Goods> queryuserByName(String name) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="SELECT * FROM goods WHERE goodName LIKE ? ";
		try
		{
			return qr.query(sql,new BeanListHandler<Goods>(Goods.class),"%"+name+"%");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("根据商品名模糊查询商品信息失败！！");
		}
	}*/



}
