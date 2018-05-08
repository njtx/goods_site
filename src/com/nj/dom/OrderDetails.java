package com.nj.dom;

public class OrderDetails {
	private String oid;
	private int gid;
	private int carNum;
	private Goods goods;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getCarNum() {
		return carNum;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "OrderDetails [oid=" + oid + ", gid=" + gid + ", carNum="
				+ carNum + "]";
	}
	

}
