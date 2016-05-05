package com.technologyActivity.entities;
/**
 * 年份对应的指标值
 * @author Administrator
 *
 */
public class technoloYear {
	private int id;
	private int idx_id;
	private String idx_year;
	private String idx_value;
	private technoloyActivity technoloyActivity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdx_id() {
		return idx_id;
	}
	public void setIdx_id(int idx_id) {
		this.idx_id = idx_id;
	}
	public String getIdx_year() {
		return idx_year;
	}
	public void setIdx_year(String idx_year) {
		this.idx_year = idx_year;
	}
	public String getIdx_value() {
		return idx_value;
	}
	public void setIdx_value(String idx_value) {
		this.idx_value = idx_value;
	}
	public technoloYear() {
		// TODO Auto-generated constructor stub
	}
	public technoloyActivity getTechnoloyActivity() {
		return technoloyActivity;
	}
	public void setTechnoloyActivity(technoloyActivity technoloyActivity) {
		this.technoloyActivity = technoloyActivity;
	}
	@Override
	public String toString() {
		return "technoloYear [id=" + id + ", idx_id=" + idx_id + ", idx_year=" + idx_year + ", idx_value=" + idx_value
				+ ", technoloyActivity=" + technoloyActivity + "]";
	}
	
}
