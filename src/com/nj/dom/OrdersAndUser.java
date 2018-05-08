package com.nj.dom;


public class OrdersAndUser extends Orders {

private String username;

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
@Override
public String toString() {
	return "OrdersAndUser [order=" + ", username=" + username+ "]";
}


}
