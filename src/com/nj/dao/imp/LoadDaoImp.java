package com.nj.dao.imp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.nj.dao.LoadDao;
import com.nj.dom.PCD;
import com.nj.util.DBUtils;



public class LoadDaoImp implements LoadDao {

	@Override
	public List<PCD> load(String pid) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="select * from pcd where pid=?";
		try {
			return 	qr.query(sql, new BeanListHandler<PCD>(PCD.class), pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询省市县失败！！");
		}
		
	}

}
