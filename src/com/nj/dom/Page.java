package com.nj.dom;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("all")
public class Page {
private int current;//��ǰҳ
private int total;//��ҳ
private int record;//�ܼ�¼��
private int singlerecord=4;//ÿҳ�ļ�¼��
private int end;//βҳ
private int start;//��ʼҳ
private List result=new ArrayList();//����� ��Ʒ���� limit ?,? 
public int getCurrent() {
	return current;
}
public void setCurrent(int current) {
	this.current = current;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public int getRecord() {
	return record;
}
public void setRecord(int record) {
	this.record = record;
}
public int getSinglerecord() {
	return singlerecord;
}
public void setSinglerecord(int singlerecord) {
	this.singlerecord = singlerecord;
}
public int getEnd() {
	return end;
}
public void setEnd(int end) {
	this.end = end;
}
public int getStart() {
	return start;
}
public void setStart(int start) {
	this.start = start;
}


public List getResult() {
	return result;
}
public void setResult(List result) {
	this.result = result;
}
@Override
public String toString() {
	return "Page [current=" + current + ", total=" + total + ", record="
			+ record + ", singlerecord=" + singlerecord + ", end=" + end
			+ ", start=" + start + ",result=" + result + "]";
}


}
