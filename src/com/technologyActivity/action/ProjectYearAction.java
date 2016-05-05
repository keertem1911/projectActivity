package com.technologyActivity.action;

 
import java.util.List;
 

import com.opensymphony.xwork2.ActionContext;
import com.technologyActivity.entities.technoloYear;
import com.technologyActivity.entities.technoloyActivity;
import com.technologyActivity.service.ProjectYearService;
import com.technologyActivitybaseFun.baseAction;

public class ProjectYearAction extends baseAction<technoloYear> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProjectYearService projectYearService;

	public String findYearByIdxId() {
		List<technoloyActivity> mapping = projectYearService.findYearByIdxId(getModel());
		ActionContext.getContext().put("yearList", mapping);

		return "findYearByIdxId";
	}

 

	public ProjectYearService getProjectYearService() {
		return projectYearService;
	}

	public void setProjectYearService(ProjectYearService projectYearService) {
		this.projectYearService = projectYearService;
	}
	
	 
	
	
}
