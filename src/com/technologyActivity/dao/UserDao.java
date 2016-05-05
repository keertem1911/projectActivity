package com.technologyActivity.dao;

 
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

 
import com.technologyActivity.entities.User;
import com.technologyActivitybaseFun.baseDao;

public class UserDao extends baseDao<User> {

	public User findByName(String user_username) {
		 
			Query query=getSession().createQuery("from User where user_username=?");
			query.setString(0, user_username);
			
			return (User) query.uniqueResult(); 
		 
	}

	public int registerCheck(User model, String inviteNumberee) {
		// 状态码 200 为注册成功  500为邀请码失败
		
		Query query=getSession().createQuery("select a.admin_inviteNumber from Admin a");
		 @SuppressWarnings("rawtypes")
		Iterator it = query.iterate();
		int flag=400;
		while(it.hasNext()){
			 String inviteNumber=(String) it.next();;
			if(inviteNumber.equals(inviteNumberee.trim())){
				save(model);
				flag=200;
				break;
			}else{
				flag=500;
			}
		}
		 
		return flag;
	}

	@SuppressWarnings("unchecked")
	public List<User> registerCheckUsername(String user_username) {
		Query query=getSession().createQuery("from User where user_username='"+user_username+"'");
		
		return query.list();
	}

}
