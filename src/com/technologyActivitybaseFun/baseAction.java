package com.technologyActivitybaseFun;

import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract  class baseAction<T>  extends ActionSupport
implements ModelDriven<T>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T model;
	@Override
	public  T getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	public baseAction() {
		ParameterizedType parameterizedType=(ParameterizedType) 
				getClass().getGenericSuperclass();
		@SuppressWarnings("unchecked")
		Class<T> clazz=(Class<T>) parameterizedType.getActualTypeArguments()[0];
		try {
			model =clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public HttpServletRequest getHttpRequest(){
		
		return ServletActionContext.getRequest();
	}
	public HttpServletResponse getHttpResponse(){
		return ServletActionContext.getResponse();
	}
	
}
