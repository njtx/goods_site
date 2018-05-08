package com.admin.serviceImp;

import java.util.List;

import com.admin.daoImp.GoodsDaoImp;
import com.admin.daoImp.LoginDaoImp;
import com.nj.dao.GoodDao;
import com.nj.dao.UserDao;
import com.nj.dao.imp.GoodDaoImp;
import com.nj.dao.imp.UserDaoImp;
import com.nj.dom.Goods;

public class GoodsServiceImp {
//ɾ����Ʒ������Ʒ���
	public void deletegoodById(int gid) {
		GoodsDaoImp dao=new GoodsDaoImp();
		dao.delByodeid(gid);//ɾ�����
		 dao.delById(gid);
		
	}
//add goods
	public void addgoods(Goods goods) {
		GoodsDaoImp dao=new GoodsDaoImp();
		dao.addgoods(goods);
		
	}
	//�����Ʒ���Ƿ�һ��
	public int checkgoodsName(String gname) {
		GoodsDaoImp dao=new GoodsDaoImp();
		return dao.checkgname(gname);
	}
	//�����ѯ
	public List<Goods> querytype(String type) {
		GoodsDaoImp dao=new GoodsDaoImp();
		return dao.querygt(type);
	}
	//��ƷID��ѯ��Ʒ��ϸ
	public Goods Infog(String gid) {
		GoodsDaoImp dao=new GoodsDaoImp();
		return dao.getById(gid);
	}
	//�޸���Ʒ��Ϣ 
	public void editgoods(Goods goods, String gname) {
		GoodsDaoImp dao=new GoodsDaoImp();
		dao.editGoods(goods,gname);
		
	}


}
