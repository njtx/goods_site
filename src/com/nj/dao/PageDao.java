package com.nj.dao;

import java.util.List;
@SuppressWarnings("all")
public interface PageDao {
//��ʾÿҳ������
	
	List querypage(int startpage, int srecord);
	/*//��ʾģ����ѯÿҳ������
	List querysearchpage(int startpage, int srecord);*/
	//��ʾģ����ѯÿҳ������
	List querysearchpage(int startpage, int srecord, String gname);
	//�����ѯ
	List querygt(int startpage, int srecord, String gname);
}
