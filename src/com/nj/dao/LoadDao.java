package com.nj.dao;

import java.util.List;

import com.nj.dom.PCD;


public interface LoadDao {
/**
 * ����pid��ѯʡ�еļ���
 * @param pid
 * @return
 */
	List<PCD> load(String pid);

}
