package com.technologyActivitybaseFun;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class baseDao <T>{
	private SessionFactory sessionFactory;
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public baseDao(){
		ParameterizedType parameterizedType= 
				(ParameterizedType) getClass().getGenericSuperclass();
		clazz=(Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public T findById(long id){
		return (T) getSession().load(clazz, id);
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public void save(T obj){
		getSession().save(obj);
	}
	public void delete(long id){
		T obj=findById(id);
		getSession().delete(obj);
	}
	public void saveOrUpdate(T obj){
		getSession().saveOrUpdate(obj);
	}
	
}
