package com.technologyActivity.dao;

 
import java.lang.reflect.Field;
 
import java.lang.reflect.Method;
 
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
 

import org.hibernate.Query;

import com.technologyActivity.entities.IdexFind;
import com.technologyActivity.entities.technoloyActivity;
import com.technologyActivitybaseFun.baseDao;

public class ProjectIdxDao extends baseDao<Object> {

	public Map<String, Object> findListByIdxs(IdexFind model,String idx_begin,String idx_end) {
		Class<? extends IdexFind> clazz = model.getClass();
		Field[] fields = clazz.getDeclaredFields();
		StringBuffer stringBuffer = new StringBuffer();
	 
		for (int i = 0; i < fields.length; i++) {
			String idx = null;
			String upperName = fields[i].getName().substring(0, 1).toUpperCase() + fields[i].getName().substring(1);

			try {
				Method method = clazz.getDeclaredMethod("get" + upperName);
				idx = (String) method.invoke(model);

				if (!idx.equals("-1")) {

					stringBuffer.append(" and " + fields[i].getName());
					stringBuffer.append(" = '");
					stringBuffer.append(idx + "' ");
					stringBuffer.append(" ");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 
		StringBuffer buffer=new StringBuffer();
		buffer.append("");
		String join="";
		if(!"".equals(idx_begin.trim())&&!"".equals(idx_end.trim())){
 	 		join=" inner join fetch t.technoloYears as y";
			buffer.append(" and    y.idx_year between "+idx_begin+" and "+idx_end);
		}
		Query query = getSession().createQuery("from technoloyActivity as t "+join+" where idx_7='科技活动'  " +
		stringBuffer.toString()+buffer.toString());
		@SuppressWarnings("unchecked")
		List<technoloyActivity> activities = query.list();
		Map<String, Object> map = new HashMap<>();
		map.put("ListA", activities);
	 
		return map;
	}

	public Object[] findMaxAndMinYear(String hql) {
	 	Query query = getSession().createQuery(
				"select min(idx_year), max(idx_year) " + "	from technoloYear where idx_id in (" + hql + ")");

		@SuppressWarnings("unchecked")
		Iterator<Object[]> it = query.list().iterator();
		Object[] MaMiYear = null;

		if (it.hasNext()) {
			MaMiYear = (Object[]) it.next();
		}
		 
		return MaMiYear;
	}

}
