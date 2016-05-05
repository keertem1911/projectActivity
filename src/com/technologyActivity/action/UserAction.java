package com.technologyActivity.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.technologyActivity.entities.User;
import com.technologyActivity.service.UserService;
import com.technologyActivitybaseFun.baseAction;
 

public class UserAction extends baseAction<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String home(){
		ActionContext.getContext().getSession().put("power", "user");
		return "home";
	}
	public 	String loginCheck(){
		int flag=userService.loginCheck(getModel());
	 
		try {
			Map<String, String> map=new HashMap<>();
			map.put("status", String.valueOf(flag));
			String json=JSON.toJSONString(map);
			if(flag==200){
			HttpSession session = getHttpRequest().getSession();
			session.setAttribute("power", getModel().getUser_username());
			 
			}
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
	public String registerCheck(){
		String inviteNumberee=getHttpRequest().getParameter("user_inviteNumberee");
		 
		int flag=userService.registerCheck(getModel(),inviteNumberee);
		 
		try {
			Map<String, String> map=new HashMap<>();
			map.put("status", String.valueOf(flag));
			String json=JSON.toJSONString(map);

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
	public String registerCheckUsername(){
		int flag=userService.registerCheckUsername(getModel());
		try {
			Map<String, String> map=new HashMap<>();
			map.put("status", String.valueOf(flag));
			String json=JSON.toJSONString(map);
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
}
