package com.nj.dom;

import java.util.Date;
import java.util.List;

public class Orders {
private String orderID;//订单编号
private int uId;//用户编号
private Date orderTime;//下单时间
private double orderMoney;//订单金额
private String orderAddress;//收货地址
private int orderState;//订单状态：1代付款 ；2 已付款；3 已过期
private User user;
private List<OrderDetails> odlist;//订单明细表

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getOrderID() {
	return orderID;
}
public void setOrderID(String orderID) {
	this.orderID = orderID;
}
public int getuId() {
	return uId;
}
public void setuId(int uId) {
	this.uId = uId;
}
public Date getOrderTime() {
	return orderTime;
}
public void setOrderTime(Date orderTime) {
	this.orderTime = orderTime;
}
public double getOrderMoney() {
	return orderMoney;
}
public void setOrderMoney(double orderMoney) {
	this.orderMoney = orderMoney;
}
public String getOrderAddress() {
	return orderAddress;
}
public void setOrderAddress(String orderAddress) {
	this.orderAddress = orderAddress;
}
public int getOrderState() {
	return orderState;
}
public void setOrderState(int orderState) {
	this.orderState = orderState;
}

public List<OrderDetails> getOdlist() {
	return odlist;
}
public void setOdlist(List<OrderDetails> odlist) {
	this.odlist = odlist;
}


@Override
public String toString() {
	return "Orders [orderID=" + orderID + ", uId=" + uId + ", orderTime="
			+ orderTime + ", orderMoney=" + orderMoney + ", orderAddress="
			+ orderAddress + ", orderState=" + orderState + ", user=" + user
			+ ", odlist=" + odlist + "]";
}

}
