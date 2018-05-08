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
			throw new RuntimeException("ɾ�����ʧ�ܣ�");
		}
		
	}
	//ɾ����Ʒ������Ʒ���
	public void delById(int gid) {
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="delete from goods where goodId=? ";
		try {
			 qr.update(sql,gid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("ɾ����Ʒʧ�ܣ�");
		}
		
	}
	//add goods
	public void addgoods(Goods goods) {
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="insert into goods values (null,?,?,?,?,?,?,?)";
		try {
			qr.update(sql, goods.getGoodName(),goods.getGoodPrice(),goods.getGoodYprice(),
					goods.getGoodPath(),goods.getGoodDescript(),goods.getGoodNum(),goods.getGoodType());
		    //qr.update(sql, param)param��Ϊ�������������û���������
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("�����Ʒ��Ϣʧ�ܣ�");
		}
		
	}
	
	//�����Ʒ���Ƿ�һ��
	public int checkgname(String gname) {
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="select count(0) from goods where goodName=? ";
		try
		{
		/**
		 * qr.query(sql, rsh, params)rsh��ΪresultSetHandler,param��Ϊ��ѯ��������
		 *rsh��ΪresultSetHandler���ýӿ����ڴ��� java.sql.ResultSet�������ݰ�Ҫ��ת��Ϊ��һ����ʽ��
		 *  intvalue()�ǰ�object����ת����int����
		 */
			
			return qr.query(sql,new ScalarHandler<Long>(), gname).intValue();	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("������Ʒ����ѯ����ʧ�ܣ�");
			
		}
	}
	//�����ѯ
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
			throw new RuntimeException("�����ѯ��Ʒ��Ϣʧ�ܣ���");
		}
	}
	//��ƷID��ѯ��Ʒ��ϸ
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
			throw new RuntimeException("����ID��ѯ��Ʒ��Ϣʧ�ܣ���");
		}
	}
	//�޸���Ʒ��Ϣ 
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
			throw new RuntimeException("�޸���Ʒ��Ϣʧ�ܣ�");
		}
		
	}
	
	/*//ģ����ѯ��Ʒ
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
			throw new RuntimeException("������Ʒ��ģ����ѯ��Ʒ��Ϣʧ�ܣ���");
		}
	}*/



}
