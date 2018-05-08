package com.nj.dom;

public class Cart {
private int uid;
private int gid;
private int cartNum;
private Goods goods;
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getGid() {
	return gid;
}
public void setGid(int gid) {
	this.gid = gid;
}
public int getCartNum() {
	return cartNum;
}
public void setCartNum(int cartNum) {
	this.cartNum = cartNum;
}
public Goods getGoods() {
	return goods;
}
public void setGoods(Goods goods) {
	this.goods = goods;
}
@Override
public String toString() {
	return "Cart [uid=" + uid + ", gid=" + gid + ", " +
			"cartNum=" + cartNum + ",goods="+goods+"]";
}


}
