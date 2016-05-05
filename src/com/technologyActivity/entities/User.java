package com.technologyActivity.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {
	private long user_id ;
	private Vip vip;
	private double user_balance;
	private Date user_untime	;
	private String user_username;	
	private String user_password;
	private String user_email;
	private String user_phone;
	private Admin admin;
	private String user_detail	;
	private String user_picture	; 
	private Set<BuyLog> buyLogs=new HashSet<BuyLog>();
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public Vip getVip() {
		return vip;
	}
	public void setVip(Vip vip) {
		this.vip = vip;
	}
	public double getUser_balance() {
		return user_balance;
	}
	public void setUser_balance(double user_balance) {
		this.user_balance = user_balance;
	}
	public Date getUser_untime() {
		return user_untime;
	}
	public void setUser_untime(Date user_untime) {
		this.user_untime = user_untime;
	}
	public String getUser_username() {
		return user_username;
	}
	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getUser_detail() {
		return user_detail;
	}
	public void setUser_detail(String user_detail) {
		this.user_detail = user_detail;
	}
	public String getUser_picture() {
		return user_picture;
	}
	public void setUser_picture(String user_picture) {
		this.user_picture = user_picture;
	}
	public Set<BuyLog> getBuyLogs() {
		return buyLogs;
	}
	public void setBuyLogs(Set<BuyLog> buyLogs) {
		this.buyLogs = buyLogs;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", vip=" + vip + ", user_balance=" + user_balance + ", user_untime="
				+ user_untime + ", user_username=" + user_username + ", user_password=" + user_password
				+ ", user_email=" + user_email + ", user_phone=" + user_phone + ", admin=" + admin + ", user_detail="
				+ user_detail + ", user_picture=" + user_picture + ", buyLogs=" + buyLogs + "]";
	}
	
	
}
