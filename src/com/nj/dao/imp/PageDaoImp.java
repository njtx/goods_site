package com.nj.dao.imp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.nj.dao.PageDao;
import com.nj.dom.Goods;
import com.nj.util.DBUtils;
@SuppressWarnings("all")
public class PageDaoImp implements PageDao {
	@Override
	public List querypage(int startpage, int srecord) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="SELECT * FROM goods LIMIT ?,?";
		try {
			return qr.query(sql, new BeanListHandler<Goods>(Goods.class),startpage,srecord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("显示的每页数据失败！！");
		}
	}
//模糊查询
	@Override
	public List querysearchpage(int startpage, int srecord, String gname) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql="SELECT * FROM goods WHERE goodName LIKE ? LIMIT ?,? ";
		try {
			/*return qr.query(sql, new BeanListHandler<Goods>(Goods.class),startpage,srecord,
					"%"+gname+"%");*/
			return qr.query(sql, new BeanListHandler<Goods>(Goods.class),"%"+gname+"%",
					startpage,srecord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("搜索显示的每页数据失败！！");
		}
	}
//分类查询
	@Override
	public List querygt(int startpage, int srecord, String gname) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
		String sql=" SELECT * FROM goods WHERE goodType=? LIMIT ?,?";
		try {

			return qr.query(sql, new BeanListHandler<Goods>(Goods.class),gname,
					startpage,srecord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("搜索显示的每页数据失败！！");
		}
	}



}
