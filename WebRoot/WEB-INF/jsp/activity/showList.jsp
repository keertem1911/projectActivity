<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示页面</title>
<style type="text/css">
tr {
	width: 400px;
	height: 30px;
}
.showList1{
	width: 200px;
	height: 30px;
}
</style>
</head>
<body>
	 
	
	 
	  <table cellspacing="0" cellpadding="0" class="TableStyle">
     
		
		 
        <tbody id="TableData" class="dataContainer" >
  
	    
	 
        	<s:iterator value="#technoloyActivities"  id="project">
				<tr align=center valign="middle">
					<td><s:property value="idx_id" /></td>
					<td><s:property value="idx_source" /></td>
					<td><s:property value="idx_unit" /></td>
					<td><s:property value="idx_freq" /></td>
					<td><s:property value="idx_1" /></td>
					<td><s:property value="idx_2" /></td>
					<s:iterator value="technoloYears"  id="year">
					<td><s:property value="idx_value" /></td>
					</s:iterator>
				</tr>
			</s:iterator>
        </tbody>
    </table>
    
</body>
</html>