package com.nj.dao;

import java.util.List;
@SuppressWarnings("all")
public interface PageDao {
//显示每页的数据
	
	List querypage(int startpage, int srecord);
	/*//显示模糊查询每页的数据
	List querysearchpage(int startpage, int srecord);*/
	//显示模糊查询每页的数据
	List querysearchpage(int startpage, int srecord, String gname);
	//分类查询
	List querygt(int startpage, int srecord, String gname);
}
