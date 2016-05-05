package com.technologyActivity.service;

import com.technologyActivity.dao.AdminDao;
import com.technologyActivity.dao.UserDao;
import com.technologyActivity.entities.Admin;
 

public class AdminService {
	
	private AdminDao adminDao;
	private UserDao userDao;
	public AdminDao getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public int loginCheck(Admin model) {
		//200成功,300用户名不存在,400密码错误 -1 连接失败
		 int flag=2;
	//	String  codePassword=MD5Sacure.GetMD5Code(model.getAdmin_password());
 		 Admin admin=adminDao.findByEmail(model.getAdmin_email());
 		 System.out.println("after"+admin);
 		 if(admin!=null){
 		//	 System.out.println(codePassword+":"+admin.getAdmin_password());
 			 if(admin.getAdmin_password().equals(model.getAdmin_password().trim())){
 				 flag=200;
 			 }else{
 				 flag=400;
 			 }
 		 }else{
 			 flag=300;
 		 }
		return flag;
	}
	public void saveInviterNumber(Admin model) {
	//	adminDao.save();
		
	}
	
	
}
