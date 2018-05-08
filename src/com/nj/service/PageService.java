package com.nj.service;

import java.util.List;

import com.nj.dom.Goods;
import com.nj.dom.Page;
import com.nj.dom.Searchgoods;

public interface PageService {
//查询分页对象
	void queryPage(Page page);
/*//模糊查询分页对象
	void searchqueryPage(Page page);
    */
	//模糊查询分页对象
	void searchqueryPage(Searchgoods s);
	//分类查询
	void querygt(Searchgoods s);
}
