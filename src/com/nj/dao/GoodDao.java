package com.nj.dao;

import java.util.List;

import com.nj.dom.Goods;


public interface GoodDao {
/*//��ѯ������Ʒ�ķ���
	List<Goods> queryAll();*/
//������ƷID��ѯ��Ϣ����
	Goods getById(String id);
	//��ȡ�ܼ�¼��
	int getCount();
	/*//������Ʒ��ģ����ѯ��Ʒ
	List<Goods> querygoods(String gname);*/
	//��ȡģ����ѯ���ܼ�¼��
	int getCount(String gname);
	//�����ѯ��Ʒ��Ϣ
	List<Goods> queryRdm();
	//��ȡ�����ѯ���ܼ�¼��
	int getCountType(String gname);
	/*//�����ѯ
	List<Goods> querygt(String gt);*/
	

}
