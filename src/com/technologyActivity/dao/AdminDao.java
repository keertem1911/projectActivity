package com.technologyActivity.dao;

import org.hibernate.Query;

import com.technologyActivity.entities.Admin;
import com.technologyActivitybaseFun.baseDao;

public class AdminDao extends baseDao<Admin> {
	
	public Admin findByEmail(String email){
		Query query=getSession().createQuery("from Admin where admin_email=?");
		query.setString(0, email);
		
		return (Admin) query.uniqueResult(); 
	}
}
