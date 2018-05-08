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
		// ִ��ע�����
		// �������ݿ���ʶ���
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="insert into user values (null,?,?,?,'b')";
		try {
			qr.update(sql, user.getUsername(),user.getNickname(),user.getPassword(),user.getRole());
		    //qr.update(sql, param)param��Ϊ�������������û���������
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("ע���û���Ϣʧ�ܣ�");
		}
		
	}
	//��ѯ�û���������
			public int checkUserName(String username)
			{
				QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
				String sql="select count(0) from user where username=? ";
				try
				{
				/**
				 * qr.query(sql, rsh, params)rsh��ΪresultSetHandler,param��Ϊ��ѯ��������
				 *rsh��ΪresultSetHandler���ýӿ����ڴ��� java.sql.ResultSet�������ݰ�Ҫ��ת��Ϊ��һ����ʽ��
				 *  intvalue()�ǰ�object����ת����int����
				 */
					
					return qr.query(sql,new ScalarHandler<Long>(), username).intValue();	
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					throw new RuntimeException("�����û�����ѯ����ʧ�ܣ�");
					
				}
				
			}
	//��¼
			public User login(String username,String pwd)
			{
				//�������ݿ���ʶ���
				QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
				String sql="select * from user where username=? and password=? and role='b' ";
				try
				{
				 return qr.query(sql,new BeanHandler<User>(User.class),username,pwd);	
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					throw new RuntimeException("�û���¼ʧ�ܣ�");
				}
			}
}
