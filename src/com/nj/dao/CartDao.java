package com.nj.dao;

import java.util.List;

import com.nj.dom.Cart;


public interface CartDao {
//���ﳵ��¼
	Cart quertRecord(String gid, int uid);
//������Ʒ
	void addCart(Cart c);
	//������Ʒ����
	void updateCart(Cart c);
	//�鿴���ﳵ
	List<Cart> queryCart(int id);
	//ɾ����Ʒ
	void deleteCart(int uid, int gid);
	//��չ��ﳵ
	void clear(int getuId);

}
