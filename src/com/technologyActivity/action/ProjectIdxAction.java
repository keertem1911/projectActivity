package com.technologyActivity.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.alibaba.fastjson.JSON;
import com.technologyActivity.entities.IdexFind;
import com.technologyActivity.entities.technoloyActivity;
import com.technologyActivity.service.ProjectIdxService;
import com.technologyActivitybaseFun.baseAction;

public class ProjectIdxAction extends baseAction<IdexFind> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProjectIdxService projectIdxService;
	private String idx_begin;
	private String idx_end;
	/**
	 * 通过索引集合查找 科技活动信息
	 * 
	 * @return
	 */
	public String findListByIdxs() {
		
		List<technoloyActivity> activities = projectIdxService.findListByIdxs(getModel(),idx_begin,idx_end);
		HttpServletResponse response = getHttpResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			String json = JSON.toJSONString(activities);
			System.out.println(json);
			pw.write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ProjectIdxService getProjectIdxService() {
		return projectIdxService;
	}

	public void setProjectIdxService(ProjectIdxService projectIdxService) {
		this.projectIdxService = projectIdxService;
	}
	
	public String getIdx_begin() {
		return idx_begin;
	}

	public void setIdx_begin(String idx_begin) {
		this.idx_begin = idx_begin;
	}

	public String getIdx_end() {
		return idx_end;
	}

	public void setIdx_end(String idx_end) {
		this.idx_end = idx_end;
	}

	public String exportActivityAndYearInformExcel(){
	 
		
		HSSFWorkbook workbook=projectIdxService.exportActivityAndYearInformExcel(getModel(),idx_begin,idx_end);
		HttpServletResponse response = getHttpResponse();
		String excelName="科技活动表.xls";
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		try {
			
			response.setHeader("Content-Disposition", "attachment;filename="+new String(excelName.getBytes("gb2312"), "ISO8859-1"));
			// 创建输出流对象
			OutputStream out = response.getOutputStream();
			// 将创建的Excel对象利用二进制流的形式强制输出到客户端去
			workbook.write(out);
			// 强制将数据从内存中保存
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
