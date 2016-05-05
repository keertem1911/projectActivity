package com.technologyActivity.service;

 
import java.util.List;
 
import com.technologyActivity.dao.ProjectYearDao;
import com.technologyActivity.entities.technoloYear;
import com.technologyActivity.entities.technoloyActivity;

public class ProjectYearService {
	private ProjectYearDao projectYearDao;
	public List<technoloyActivity> findYearByIdxId(technoloYear model){
		int idx_id=model.getIdx_id();
		return projectYearDao.findYearByIdxId(idx_id);
	}
	
	public ProjectYearDao getProjectYearDao() {
		return projectYearDao;
	}
	public void setProjectYearDao(ProjectYearDao projectYearDao) {
		this.projectYearDao = projectYearDao;
	}
	
}
