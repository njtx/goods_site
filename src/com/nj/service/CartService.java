package com.nj.service;

import java.util.List;

import com.nj.dom.Cart;


public interface CartService {
	//���ﳵ��¼
 Cart queryRecord(String gid, int uid);
//�鿴���ﳵ����Ʒ
List<Cart> queryCart(int id);
//ɾ�����ﳵ
void deleteCart(int uid, int gid);
//���¹��ﳵ����
void update(int uid, int gid, int carnum);



}
