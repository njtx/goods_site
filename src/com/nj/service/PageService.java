package com.nj.service;

import java.util.List;

import com.nj.dom.Goods;
import com.nj.dom.Page;
import com.nj.dom.Searchgoods;

public interface PageService {
//��ѯ��ҳ����
	void queryPage(Page page);
/*//ģ����ѯ��ҳ����
	void searchqueryPage(Page page);
    */
	//ģ����ѯ��ҳ����
	void searchqueryPage(Searchgoods s);
	//�����ѯ
	void querygt(Searchgoods s);
}
