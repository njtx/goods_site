package com.nj.dom;

import java.util.ArrayList;
import java.util.List;

public class Searchgoods {
	private Page page;
	private String gname;
	private List list=new ArrayList();
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	

}
