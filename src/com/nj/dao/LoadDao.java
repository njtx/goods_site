package com.nj.dao;

import java.util.List;

import com.nj.dom.PCD;


public interface LoadDao {
/**
 * 利用pid查询省市的集合
 * @param pid
 * @return
 */
	List<PCD> load(String pid);

}
