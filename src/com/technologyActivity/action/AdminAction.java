package com.technologyActivity.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.technologyActivity.entities.Admin;
import com.technologyActivity.service.AdminService;
import com.technologyActivitybaseFun.InviteNumber;
import com.technologyActivitybaseFun.MD5Sacure;
import com.technologyActivitybaseFun.baseAction;

public class AdminAction extends baseAction<Admin>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public 	String loginCheck(){
		int flag=adminService.loginCheck(getModel());
	 
		try {
			Map<String, String> map=new HashMap<>();
			map.put("status", String.valueOf(flag));
			String json=JSON.toJSONString(map);
			ActionContext.getContext().getSession().put("power", "admin");
			PrintWriter pw = getHttpResponse().getWriter();
			pw.write(json);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String register(){
		
		return "AdminRegister";
	}
	public String createInviterNumber(){
		System.out.println(MD5Sacure.GetMD5Code("12345"));
		String number=InviteNumber.getInviteNumber();
		System.out.println(number);
		try {
			getHttpResponse().getWriter().write(number);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String saveInviterNumber(){
		adminService.saveInviterNumber(getModel());
		return "saveInviterNumber";
	}
	public String home(){
		ActionContext.getContext().put("power", "admin");
		return "home";
	}
	
}
