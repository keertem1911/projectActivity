package com.technologyActivity.entities;

 
import java.util.HashSet;
 
import java.util.Set;

/**
 * 科技活动
 */
public class technoloyActivity {
	//id 号
	private int idx_id;
	//更新频率
	private String idx_freq;
	//信息来源
	private String idx_source;
	//单位
	private String idx_unit;
	//第一导航
	private String idx_1;
	//第二导航
	private String idx_2;
	//第三导航
	private String idx_3;
	//第四导航
	private String idx_4;
	//第五导航
	private String idx_5;
	
	private String idx_6;
	
	private String idx_7;
	//对应的年份指标
	private Set<technoloYear> technoloYears=new HashSet<technoloYear>();
	//对应的月份指标
	private Set<technoloMonth> technoloMonths=new HashSet<technoloMonth>();
	
	public Set<technoloMonth> getTechnoloMonths() {
		return technoloMonths;
	}
	public void setTechnoloMonths(Set<technoloMonth> technoloMonths) {
		this.technoloMonths = technoloMonths;
	}
	public int getIdx_id() {
		return idx_id;
	}
	public void setIdx_id(int idx_id) {
		this.idx_id = idx_id;
	}
	public String getIdx_freq() {
		return idx_freq;
	}
	public void setIdx_freq(String idx_freq) {
		this.idx_freq = idx_freq;
	}
	public String getIdx_source() {
		return idx_source;
	}
	public void setIdx_source(String idx_source) {
		this.idx_source = idx_source;
	}
	public String getIdx_unit() {
		return idx_unit;
	}
	public void setIdx_unit(String idx_unit) {
		this.idx_unit = idx_unit;
	}
	public String getIdx_1() {
		return idx_1;
	}
	public void setIdx_1(String idx_1) {
		this.idx_1 = idx_1;
	}
	public String getIdx_2() {
		return idx_2;
	}
	public void setIdx_2(String idx_2) {
		this.idx_2 = idx_2;
	}
	public String getIdx_3() {
		return idx_3;
	}
	public void setIdx_3(String idx_3) {
		this.idx_3 = idx_3;
	}
	public String getIdx_4() {
		return idx_4;
	}
	public void setIdx_4(String idx_4) {
		this.idx_4 = idx_4;
	}
	public String getIdx_5() {
		return idx_5;
	}
	public void setIdx_5(String idx_5) {
		this.idx_5 = idx_5;
	}
	 
	public String getIdx_6() {
		return idx_6;
	}
	public void setIdx_6(String idx_6) {
		this.idx_6 = idx_6;
	}
	public String getIdx_7() {
		return idx_7;
	}
	public void setIdx_7(String idx_7) {
		this.idx_7 = idx_7;
	}
	public technoloyActivity() {
	}
	public Set<technoloYear> getTechnoloYears() {
		return technoloYears;
	}
	public void setTechnoloYears(Set<technoloYear> technoloYears) {
		this.technoloYears = technoloYears;
	}
	@Override
	public String toString() {
		return "technoloyActivity [idx_id=" + idx_id + ", idx_freq=" + idx_freq + ", idx_source=" + idx_source
				+ ", idx_unit=" + idx_unit + ", idx_1=" + idx_1 + ", idx_2=" + idx_2 + ", idx_3=" + idx_3 + ", idx_4="
				+ idx_4 + ", idx_5=" + idx_5 + ", idx_6=" + idx_6 + ", idx_7=" + idx_7 + ", technoloYears="
				+ technoloYears + "]";
	}
	
	 
	
}
