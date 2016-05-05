package com.technologyActivity.service;

 
import java.util.List;
import java.util.Map;

import com.technologyActivity.dao.ProjectDao;
 
import com.technologyActivity.entities.technoloyActivity;

public class ProjectService {
	private ProjectDao projectDao;
	
	
	
	public ProjectDao getProjectDao() {
		return projectDao;
	}
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
 
	public Map<String, List<Object>> findIdxInit(technoloyActivity model) {
		Map<String, List<Object>> map=projectDao.findIdxInit(model);
		
		 return map;
	}
	public List<technoloyActivity> findIdxByProvince(technoloyActivity model){
		
		return null;
	}
	public  List<String> findIdxByAllProvince(technoloyActivity model) {
		
		return projectDao.findIdxByAllProvince(model);
	}
	public  Map<Object,Object> showMap(technoloyActivity model){
		return projectDao.showMap(model);
	}
	public List<Map<String, Object>> findAllYearValueToLineChart(technoloyActivity model) {
		
		return projectDao.findAllYearValueToLineChart(model);
	}
	
}
