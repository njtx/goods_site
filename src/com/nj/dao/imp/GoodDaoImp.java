package com.nj.dao.imp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.nj.dao.GoodDao;
import com.nj.dom.Goods;
import com.nj.util.DBUtils;



public class GoodDaoImp implements GoodDao {

/**
 * ������ƷID��ȡ��Ʒ��Ϣ
 */
	@Override
	public Goods getById(String id) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="select * from goods where goodId=?";
		try
		{
			return qr.query(sql,new BeanHandler<Goods>(Goods.class),id);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("����ID��ѯ��Ʒ��Ϣʧ�ܣ���");
		}
		
	}
	//��ȡ��¼��
@Override
public int getCount() {
	// TODO Auto-generated method stub
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	String sql="SELECT COUNT(*) FROM goods";
	try
	{
		return qr.query(sql,new ScalarHandler<Long>()).intValue();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		throw new RuntimeException("��ѯ��Ʒ����ʧ�ܣ���");
	}
}
//��ȡģ����ѯ���ܼ�¼��
@Override
public int getCount(String gname) {
	// TODO Auto-generated method stub
 QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
 String sql="SELECT COUNT(*) FROM goods where goodName LIKE ?";
 try
 {
	/*return qr.query(sql,new ScalarHandler<Long>()).intValue();*/
	return qr.query(sql,new ScalarHandler<Long>(), "%"+gname+"%").intValue();
 }
 catch(SQLException e)
 {
	e.printStackTrace();
	throw new RuntimeException("��ѯ��Ʒ����ʧ�ܣ���");
}
}

//�����ѯ��Ʒ
@Override
public List<Goods> queryRdm() {
	// TODO Auto-generated method stub
	//�������ݿ����Ӷ���
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());

	String sql="SELECT * FROM goods ORDER BY RAND() LIMIT 3";
	try
	{
		return qr.query(sql,new BeanListHandler<Goods>(Goods.class));
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		throw new RuntimeException("�����ѯ��Ʒ��Ϣʧ�ܣ���");
	}
			
}
//�����ѯ�ܼ�¼��
@Override
public int getCountType(String gname) {
	// TODO Auto-generated method stub
	 QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
	 String sql="SELECT COUNT(*) FROM goods where goodType=?";
	 try
	 {
		return qr.query(sql,new ScalarHandler<Long>(), gname).intValue();
	 }
	 catch(SQLException e)
	 {
		e.printStackTrace();
		throw new RuntimeException("�����ѯ��Ʒ����ʧ�ܣ���");
	}
}
//�����ѯ
/*@Override
public List<Goods> querygt(String gt) {
	// TODO Auto-generated method stub
	QueryRunner qr=new QueryRunner(DBUtils.getDataSource());

	String sql="SELECT * FROM goods WHERE goodType=?";
	try
	{
		return qr.query(sql,new BeanListHandler<Goods>(Goods.class),gt);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		throw new RuntimeException("�����ѯ��Ʒ��Ϣʧ�ܣ���");
	}
			
}
*/



}
