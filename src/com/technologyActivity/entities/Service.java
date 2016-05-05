package com.technologyActivity.entities;

 
public class Service {
	private long ser_id	;				
	private String ser_type	;
	private String ser_param1;
	private String ser_param2;		
	private double ser_price;
 
	public long getSer_id() {
		return ser_id;
	}
	public void setSer_id(long ser_id) {
		this.ser_id = ser_id;
	}
	public String getSer_type() {
		return ser_type;
	}
	public void setSer_type(String ser_type) {
		this.ser_type = ser_type;
	}
	public String getSer_param1() {
		return ser_param1;
	}
	public void setSer_param1(String ser_param1) {
		this.ser_param1 = ser_param1;
	}
	public String getSer_param2() {
		return ser_param2;
	}
	public void setSer_param2(String ser_param2) {
		this.ser_param2 = ser_param2;
	}
	public double getSer_price() {
		return ser_price;
	}
	public void setSer_price(double ser_price) {
		this.ser_price = ser_price;
	}
 
	
}
