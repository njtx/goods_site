package com.nj.service;

import java.util.List;

import com.nj.dom.PCD;


public interface LoadService {
/**
 * ����pid��ѯ�Ӽ�����
 * @param pid
 * @return
 */
	List<PCD> load(String pid);

}
