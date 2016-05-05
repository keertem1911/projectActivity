package com.technologyActivity.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Admin {
	private long admin_id	;	
	private Date admin_untime	;
	private String admin_inviteNumber	;
	private String admin_inviteNumberee	;	
	private String admin_email	;		
	private String admin_phone;
	private String admin_password;
	private Set<User> users=new HashSet<User>();
	public long getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(long admin_id) {
		this.admin_id = admin_id;
	}
	public Date getAdmin_untime() {
		return admin_untime;
	}
	public void setAdmin_untime(Date admin_untime) {
		this.admin_untime = admin_untime;
	}
	public String getAdmin_inviteNumber() {
		return admin_inviteNumber;
	}
	public void setAdmin_inviteNumber(String admin_inviteNumber) {
		this.admin_inviteNumber = admin_inviteNumber;
	}
	public String getAdmin_inviteNumberee() {
		return admin_inviteNumberee;
	}
	public void setAdmin_inviteNumberee(String admin_inviteNumberee) {
		this.admin_inviteNumberee = admin_inviteNumberee;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getAdmin_phone() {
		return admin_phone;
	}
	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_email=" + admin_email + ", admin_phone=" + admin_phone
				+ ", admin_password=" + admin_password + "]";
	}
	 
	
}
