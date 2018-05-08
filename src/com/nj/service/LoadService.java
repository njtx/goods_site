package com.nj.service;

import java.util.List;

import com.nj.dom.PCD;


public interface LoadService {
/**
 * 根据pid查询子级区域
 * @param pid
 * @return
 */
	List<PCD> load(String pid);

}
