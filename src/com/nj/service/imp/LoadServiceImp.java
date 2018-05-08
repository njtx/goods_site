package com.nj.service.imp;

import java.util.List;

import com.nj.dao.LoadDao;
import com.nj.dao.imp.LoadDaoImp;
import com.nj.dom.PCD;
import com.nj.service.LoadService;



public class LoadServiceImp implements LoadService {
	public List<PCD> load(String pid) {
		// TODO Auto-generated method stub
		LoadDao dao=new LoadDaoImp();
		return dao.load(pid);
	}
}
