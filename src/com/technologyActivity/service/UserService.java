package com.technologyActivity.service;

import java.util.List;

import com.technologyActivity.dao.UserDao;
import com.technologyActivity.entities.User;

public class UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public int loginCheck(User model) {
		//200成功,300用户名不存在,400密码错误 -1 连接失败
		 int flag=2;
	 		 User user=userDao.findByName(model.getUser_username());
 		 
 		 if(user!=null){
 	 		 if(user.getUser_password().equals(model.getUser_password().trim())){
 				 flag=200;
 			 }else{
 				 flag=400;
 			 }
 		 }else{
 			 flag=300;
 		 }
		return flag;
	}

	public int registerCheck(User model,String inviteNumberee) {
		// 状态码 200 为注册成功  500为邀请码失败
		 
		//	String  codePassword=MD5Sacure.GetMD5Code(model.getAdmin_password());
		return userDao.registerCheck(model,inviteNumberee);
		 
	}

	public int registerCheckUsername(User model) {
		//状态码200 成功 300 用户名存在 500 网络异常
		int flag=500;
		List<User> list=userDao.registerCheckUsername(model.getUser_username());
		if(list.size()==0||list==null){
			flag=200;
		}else{
			flag=300;
		}
		return flag;
	}
	
}
