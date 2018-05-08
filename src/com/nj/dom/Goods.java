package com.nj.dom;


public class Goods {

private String goodId;//商品编号
private String goodName;//商品名
private double goodPrice;//市场价
private double goodYprice;//优惠价
private String goodPath;//商品路径
private String goodDescript;//商品描述
private int goodNum;//库存量
private String goodType;//商品类别
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
