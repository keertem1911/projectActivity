 package com.technologyActivity.dao;

 
import java.util.List;
 

import org.hibernate.Query;

import com.technologyActivity.entities.technoloYear;
import com.technologyActivity.entities.technoloyActivity;
import com.technologyActivitybaseFun.baseDao;

public class ProjectYearDao extends baseDao<technoloYear>{
	
	@SuppressWarnings("unchecked")
	public List<technoloyActivity> findYearByIdxId(int idx_id){
	 
		Query query = getSession().createQuery("from technoloyActivity where idx_7='科技活动' and idx_id="+idx_id);
		return query.list() ;
	}
	
}
