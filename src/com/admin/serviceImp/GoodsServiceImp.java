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
//删除商品利用商品编号
	public void deletegoodById(int gid) {
		GoodsDaoImp dao=new GoodsDaoImp();
		dao.delByodeid(gid);//删除外键
		 dao.delById(gid);
		
	}
//add goods
	public void addgoods(Goods goods) {
		GoodsDaoImp dao=new GoodsDaoImp();
		dao.addgoods(goods);
		
	}
	//检查商品名是否一致
	public int checkgoodsName(String gname) {
		GoodsDaoImp dao=new GoodsDaoImp();
		return dao.checkgname(gname);
	}
	//分类查询
	public List<Goods> querytype(String type) {
		GoodsDaoImp dao=new GoodsDaoImp();
		return dao.querygt(type);
	}
	//商品ID查询商品详细
	public Goods Infog(String gid) {
		GoodsDaoImp dao=new GoodsDaoImp();
		return dao.getById(gid);
	}
	//修改商品信息 
	public void editgoods(Goods goods, String gname) {
		GoodsDaoImp dao=new GoodsDaoImp();
		dao.editGoods(goods,gname);
		
	}


}
