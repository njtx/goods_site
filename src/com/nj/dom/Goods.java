package com.nj.dom;


public class Goods {

private String goodId;//��Ʒ���
private String goodName;//��Ʒ��
private double goodPrice;//�г���
private double goodYprice;//�Żݼ�
private String goodPath;//��Ʒ·��
private String goodDescript;//��Ʒ����
private int goodNum;//�����
private String goodType;//��Ʒ���
public String getGoodId() {
	return goodId;
}
public void setGoodId(String goodId) {
	this.goodId = goodId;
}
public String getGoodName() {
	return goodName;
}
public void setGoodName(String goodName) {
	this.goodName = goodName;
}
public double getGoodPrice() {
	return goodPrice;
}
public void setGoodPrice(double goodPrice) {
	this.goodPrice = goodPrice;
}
public double getGoodYprice() {
	return goodYprice;
}
public void setGoodYprice(double goodYprice) {
	this.goodYprice = goodYprice;
}
public String getGoodPath() {
	return goodPath;
}
public void setGoodPath(String goodPath) {
	this.goodPath = goodPath;
}
public String getGoodDescript() {
	return goodDescript;
}
public void setGoodDescript(String goodDescript) {
	this.goodDescript = goodDescript;
}
public int getGoodNum() {
	return goodNum;
}
public void setGoodNum(int goodNum) {
	this.goodNum = goodNum;
}
public String getGoodType() {
	return goodType;
}
public void setGoodType(String goodType) {
	this.goodType = goodType;
}
@Override
public String toString() {
	return "Goods [goodId=" + goodId + ", goodName=" + goodName
			+ ", goodPrice=" + goodPrice + ", goodYprice=" + goodYprice
			+ ", goodPath=" + goodPath + ", goodDescript=" + goodDescript
			+ ", goodNum=" + goodNum + ", goodType=" + goodType + "]";
}


}
