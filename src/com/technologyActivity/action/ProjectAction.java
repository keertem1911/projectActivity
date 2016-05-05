package com.technologyActivity.action;

import java.io.IOException;
import java.io.PrintWriter;
 
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
 
 
import com.technologyActivity.entities.technoloyActivity;
import com.technologyActivity.service.ProjectService;
import com.technologyActivitybaseFun.baseAction;

public class ProjectAction extends baseAction<technoloyActivity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProjectService projectService;
 
	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	public String findIdxInit(){
		Map<String, List<Object>> map =projectService.findIdxInit(getModel());
		String json =JSON.toJSONString(map);
		
		PrintWriter pw =null;
		try {
			getHttpResponse().setContentType("txt/html;charset=utf-8");
			pw=getHttpResponse().getWriter();
			pw.write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String findIdxByProvince(){
		
		return null;
	}
	public 	String findIdxByAllProvince(){
		 List<String>  listIdx=projectService.findIdxByAllProvince(getModel());
		String json =JSON.toJSONString(listIdx);
		PrintWriter pw =null;
		getHttpResponse().setContentType("text/html;charset=utf-8");
		try {
			pw= getHttpResponse().getWriter();
			pw.write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pw!=null){
				pw.close();
			}
		}
		return null;
	}
	public String showMap(){
		 
		 Map<Object,Object> mapIdx=projectService.showMap(getModel());
	
		String json =JSON.toJSONString(mapIdx);
		PrintWriter pw =null;
		getHttpResponse().setContentType("text/html;charset=utf-8");
		try {
			pw= getHttpResponse().getWriter();
			pw.write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pw!=null){
				pw.flush();
				pw.close();
			}
		}
		return null;
	}
	//显示查询一个省份指标的所有年份值的折线图 
	public String findAllYearValueToLineChart(){
		List<Map<String, Object>> mapIdx=projectService.findAllYearValueToLineChart(getModel());
		String json =JSON.toJSONString(mapIdx);
		PrintWriter pw =null;
		getHttpResponse().setContentType("text/html;charset=utf-8");
		try {
			pw= getHttpResponse().getWriter();
			pw.write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pw!=null){
				pw.flush();
				pw.close();
			}
		}
		return null;
	}
}
