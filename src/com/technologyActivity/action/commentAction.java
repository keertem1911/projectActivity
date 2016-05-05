package com.technologyActivity.action;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
 
import java.text.SimpleDateFormat;
 
import java.util.Date;
 
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
 
import com.technologyActivitybaseFun.baseAction;

public class commentAction extends baseAction<Object>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File upload;
	
	private String uploadFileName;

	 

	public String index(){
		return "index";
	}
	 
	public String uploadSave(){
		HttpServletRequest request = getHttpRequest();  
		HttpServletResponse response = getHttpResponse();
		PrintWriter pw=null;
			 try {
				response.setContentType("text/html;charset=utf-8;");
				request.setCharacterEncoding("utf-8");
				 
				// 设置接收的编码格式
				request.setCharacterEncoding("UTF-8");
				Date date = new Date();// 获取当前时间
				SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmss");
				 
				String newfileName = sdfFileName.format(date);// 文件名称
				 
				String realPath= ServletActionContext.getServletContext().getRealPath("")+"\\upload\\";
				String filename= newfileName+uploadFileName.substring(uploadFileName.lastIndexOf("."));
				FileInputStream  fis=new FileInputStream(upload);
				File file = new File(realPath);
				if(file.exists()==false){
					file.mkdirs();
				}
				FileOutputStream fos=new FileOutputStream(realPath+filename);
				int i =0;
				byte [] b=new byte[1024];
				while((i=fis.read(b))!=-1){
					fos.write(b, 0, i);
				}
				fos.flush();
				fos.close();
				fis.close();
				  pw = getHttpResponse().getWriter();
				pw.write("1");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				pw.write("-1");
			}
	        
		return null;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	 public String graph(){
		 return "graph";
	 }
	 public String data(){
		 return "data";
	 }
	public String loginSuccess(){
		return "loginSuccess";
	}
	public String exitLogin(){
		getHttpRequest().getSession().setAttribute("power", "");
		
		
		return "index";
	}
}
