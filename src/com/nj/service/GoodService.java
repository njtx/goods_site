package com.nj.service;

import java.util.List;

import com.nj.dom.Cart;
import com.nj.dom.Goods;


public interface GoodService {
/*//��ѯ���е���Ʒ��Ϣ
	List<Goods> queryall();*/
//������ƷID��ѯ��Ϣ�ķ���
	Goods getById(String id);
	//�����Ʒ
	void addCart(Cart c);
	//������Ʒ����
	void updateCart(Cart c);
	/*//������Ʒ��ģ����ѯ��Ʒ
	List<Goods> getByName(String gname);*/
	//�����ѯ��Ʒ��Ϣ
	List<Goods> queryrandom();
	/*//�����ѯ
	List<Goods> querygt(String gt);*/
	
}
