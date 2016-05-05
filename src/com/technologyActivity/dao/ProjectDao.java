package com.technologyActivity.dao;

 



import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

 
import com.technologyActivity.entities.technoloyActivity;
import com.technologyActivitybaseFun.baseDao;

public class ProjectDao  extends baseDao<technoloyActivity>{
	
	private ProjectIdxDao projectIdxDao;
	 
	public ProjectIdxDao getProjectIdxDao() {
		return projectIdxDao;
	}
	public void setProjectIdxDao(ProjectIdxDao projectIdxDao) {
		this.projectIdxDao = projectIdxDao;
	}
 
	 
	public Map<String, List<Object>> findIdxInit(technoloyActivity model) {
		Map<String, List<Object>> map=new HashMap<>();
		
		Class<technoloyActivity> clazz=technoloyActivity.class;
		Field [] fields=clazz.getDeclaredFields();
		StringBuffer buffer=new StringBuffer();
		
		if(model!=null){
			
			for (int i = 1; i < fields.length-1; i++) {
				try {
					String lowerName=fields[i].getName();
					String upperName=lowerName.substring(0, 1).toUpperCase()+lowerName.substring(1);
					Method method=clazz.getDeclaredMethod("get"+upperName);
					String value;
					if(fields[i].getType()==String.class)
					value= (String) method.invoke(model);
					else
						value="";
					if(value!=null&&!"".equals(value.trim())&&value!=""&&!"-1".equals(value.trim())){
						buffer.append(" and "+lowerName+"='"+value+" '");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		 
		for (int i = 1; i < fields.length-2; i++) {
			if(!fields[i].getName().equals("idx_freq")&&!fields[i].getName().equals("idx_unit")){
			Query query=getSession().createQuery("select distinct "+fields[i].getName()+
					" from technoloyActivity where  "+fields[i].getName()+" not in('') "+buffer.toString()+" and idx_7='科技活动'");
			map.put(fields[i].getName(), query.list());
			
			} 
			}
		 Object [] object=projectIdxDao.findMaxAndMinYear("select idx_id from technoloyActivity where 1=1  "+buffer.toString()+" and idx_7='科技活动'");
		 List<Object> years=new ArrayList<>();
		 years.add(object[0]);
		 years.add(object[1]);
		 map.put("MaxAndMinYear",years);
		return map;
		}
 
	 
	public List<String> findIdxByAllProvince(technoloyActivity model) {
		StringBuffer buffer=new StringBuffer(); 
		buffer.append("");
		String selectIdx="idx_2";
		if(!model.getIdx_2().equals("-1")&&model.getIdx_2()!=null){
			buffer.append(" and idx_2='"+model.getIdx_2()+"' ");
			selectIdx="idx_3";
		}
		 
		Query query=getSession().createQuery("select distinct "+selectIdx+"   from technoloyActivity "
				+ "where  idx_7='科技活动' and idx_1 in"
				+"('安徽','新疆','北京','福建','甘肃','广东','广西','贵州','海南','河南','黑龙江','湖北','湖南','吉林','江苏','江西','辽宁',"
				+"'内蒙古','宁夏','青海','山东','山西','陕西','四川','天津','西藏','云南','浙江','重庆','上海','河北')"
				+buffer.toString()
				+" group by idx_2,idx_3 having count(idx_2)>30");
		return query.list();
	}
	public  Map<Object,Object> showMap(technoloyActivity model){
		StringBuffer buffer=new StringBuffer();
		 
		if(!model.getIdx_2().equals("-1")){
			buffer.append("  and  idx_2='"+model.getIdx_2()+"' ");
			if(!model.getIdx_3().equals("-1")){
				buffer.append("and idx_3='"+model.getIdx_3()+"' ");
			}
		}
		 
		Query query=getSession().createQuery("select  sum(idx_value), y.technoloyActivity.idx_1, y.technoloyActivity.idx_unit  from   technoloYear y "
				+ "  where  y.idx_id in (select   idx_id  from technoloyActivity "
				+ "where idx_7='科技活动' and idx_1 in"
				+"('安徽','新疆','北京','福建','甘肃','广东','广西','贵州','海南','河南','黑龙江','湖北','湖南','吉林','江苏','江西','辽宁',"
				+"'内蒙古','宁夏','青海','山东','山西','陕西','四川','天津','西藏','云南','浙江','重庆','上海','河北')"
				+buffer.toString()
				+")  group by idx_id");
		  
		Iterator list = query.iterate();
		 Map<Object,Object> map=new HashMap<>();
		while(list.hasNext()){
			Object [] object=(Object[]) list.next();
			Object [] object1={object[0],object[2]};
			map.put(object[1],object1);
			
		}
		return map;
	}
	 
	public List<Map<String, Object>> findAllYearValueToLineChart(technoloyActivity model) {
		String [] idx=model.getIdx_1().split(":");
		StringBuffer buffer=new StringBuffer(); 
		if(!model.getIdx_2().equals("-1")){
			buffer.append(" and y.technoloyActivity.idx_2='");
			buffer.append(model.getIdx_2()+"' ");
			if(!model.getIdx_3().equals("-1")){
				buffer.append(" and y.technoloyActivity.idx_3='");
				buffer.append(model.getIdx_3()+"'");
			}
		}
		 
		List<Map<String,Object>> idxlist=new ArrayList<Map<String,Object>>();
		for(int i=0;i<idx.length;++i){
		Query query=getSession().createQuery("select y.idx_year,sum(y.idx_value),y.technoloyActivity.idx_unit"
				+ " from technoloYear y  where y.technoloyActivity.idx_7='科技活动' and y.technoloyActivity.idx_1 ='"+idx[i]+"'"
				+ buffer.toString()
				+ " group by y.idx_year order by y.idx_year");
		Iterator it=query.iterate();
		Map<String, Object> map=new HashMap<>();
		List<Object[]> list=new ArrayList<>();
		while(it.hasNext()){
			Object [] obj=(Object[]) it.next();
			 list.add(obj);
		}
		map.put("name", idx[i]);
		map.put("value", list);
		idxlist.add(map);
		}
		return idxlist;
	}
}

