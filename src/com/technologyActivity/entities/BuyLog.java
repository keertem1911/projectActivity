package com.technologyActivity.entities;
 

public class BuyLog {
	private long buy_id	;	
	private User user;
	private Service ser	;
	private long buy_count;
 
	public long getBuy_id() {
		return buy_id;
	}
	public void setBuy_id(long buy_id) {
		this.buy_id = buy_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Service getSer() {
		return ser;
	}
	public void setSer(Service ser) {
		this.ser = ser;
	}
	public long getBuy_count() {
		return buy_count;
	}
	public void setBuy_count(long buy_count) {
		this.buy_count = buy_count;
	}
	 
 
}
