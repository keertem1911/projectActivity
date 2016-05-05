package com.technologyActivity.service;

import java.lang.reflect.Method;
 
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
 
import com.technologyActivity.dao.ProjectIdxDao;
import com.technologyActivity.entities.IdexFind;
import com.technologyActivity.entities.technoloYear;
import com.technologyActivity.entities.technoloyActivity;

public class ProjectIdxService {
	private ProjectIdxDao projectIdxDao;

	public ProjectIdxDao getProjectIdxDao() {
		return projectIdxDao;
	}

	public void setProjectIdxDao(ProjectIdxDao projectIdxDao) {
		this.projectIdxDao = projectIdxDao;
	}

	@SuppressWarnings("unchecked")
	public List<technoloyActivity> findListByIdxs(IdexFind model,String idx_begin,String idx_end) {
		
		return (List<technoloyActivity>) projectIdxDao.findListByIdxs(model,idx_begin,idx_end).get("ListA");
	}
	public int [] findMaxAndMinYearService(Object [] MaxMinYear){

		int [] value=new int[MaxMinYear.length];
		for (int i = 0; i < MaxMinYear.length; i++) {
			value[i]= Integer.parseInt(String.valueOf(MaxMinYear[i]));
		}
		return value;
	}
	public HSSFWorkbook exportActivityAndYearInformExcel(IdexFind model,String idx_begin,String idx_end){
				//头属性名称
				String [] headNameAct={"省份","指标名称","类型","更新频率",
						"来源","单位"}; 
				//起始年份与终止年份
				int beginYear=Integer.parseInt(idx_begin);
				int endYear=Integer.parseInt(idx_end);
				//每列属性对应的方法名称(科技活动)
				final String [] valueNameAct={"Idx_1","Idx_2","Idx_3","Idx_4","Idx_5"
						,"Idx_6","Idx_freq","Idx_source","Idx_unit"};
				Map<String, Object> map=projectIdxDao.findListByIdxs(model,idx_begin,idx_end);
				@SuppressWarnings("unchecked")
				List<technoloyActivity> activities= 
						(List<technoloyActivity>) map.get("ListA");
				HSSFWorkbook workbook=new HSSFWorkbook();
				HSSFSheet sheet=workbook.createSheet();
				HSSFCellStyle style=workbook.createCellStyle();
				style.setFillBackgroundColor(HSSFColor.YELLOW.index2);
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				HSSFCell cell=null;
				HSSFRow row=sheet.createRow(0);
				int i1=0;
				for(;i1<headNameAct.length;++i1){
					 cell=row.createCell(i1, Cell.CELL_TYPE_STRING);
					cell.setCellStyle(style);
					cell.setCellValue(headNameAct[i1]);
				}
			 
				for(int k=0;k<endYear-beginYear+1;++k){
					 cell=row.createCell(i1++, Cell.CELL_TYPE_NUMERIC);
					cell.setCellStyle(style);
					cell.setCellValue(beginYear+k);
				}
				Class<technoloyActivity> clazzA=technoloyActivity.class;
			 
				for (int i = 0; i < activities.size(); i++) {
					
					technoloyActivity teActivity=activities.get(i);
				
					row=sheet.createRow(i+1);
					 Set<technoloYear> technoloYears =teActivity.getTechnoloYears();
					 int k = 0;
					 try {
						for (int begin =0; begin < valueNameAct.length;k++) {
							cell=row.createCell(k);
							cell.setCellStyle(style);
							
							switch(k){
							case 2:
								StringBuilder builder=new StringBuilder();
								 
								while(begin<6){
									Method method=clazzA.getDeclaredMethod("get"+valueNameAct[begin]);
									String value=(String) method.invoke(teActivity);
									if(value!=null)
									builder.append(value);
								 
									if(k!=5&&value!=null||"".equals(value.trim()))
										builder.append(":");
									begin++;
								}
								Pattern pattern = Pattern.compile("[:]+$");
								String target=builder.toString();
								String[] results = pattern.split(target);
								
								if(results.length!=0)	
								cell.setCellValue(results[0]+":科技活动");
								else
									cell.setCellValue("");
								break;
							default :
							Method method=clazzA.getDeclaredMethod("get"+valueNameAct[begin++]);
							String value=(String) method.invoke(teActivity);
							cell.setCellValue(value);
							 
							}
							
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 Iterator<technoloYear> it=technoloYears.iterator();
						for(int l=0;l<(endYear-beginYear+1)&&it.hasNext();++l){
							technoloYear year=it.next();
							 
					 	cell=row.createCell(k++);
								cell.setCellStyle(style);
								cell.setCellValue(year.getIdx_value());
						}
				}
				return workbook;
	}
	
}
