<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
tr {
	width: 800px;
	height: 30px;
}
td{
	width: 100px;
	 
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$("#exportYearInformExcel").click(function(){
			var href="projectYear_exportYearInformExcel.action?idx_id="+$("#id").val();
			 window.location.href=href;
			});
		});
</script>
</head>
<body>
	<table align="center" border="1" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
					<td>编号</td>
					<td>省份/市</td>
 					<td>指标名称</td>
 					<td>类型1</td>
 					<td>类型2</td>
 					<td>类型3</td>
 					<td>更新频率</td>
 					<td>来源</td>
 					 
				<td>年份</td>
				<td>数值</td>
				<td>单位</td>
			</tr>
		</thead>
		<tbody>
		
			<s:iterator value="#yearList" id="project">
			<s:iterator value="#project.technoloYears" id="year">
				<input type="hidden" id="id" value="${project.idx_id }" />
				<tr>
					<td><s:property value="#project.idx_id" /></td>
					<td><s:property value="idx_1" /></td>
					<td><s:property value="idx_2" /></td>
					<td><s:property value="idx_3" /></td>
					<td><s:property value="idx_4" /></td>
					<td><s:property value="idx_5" /></td>
					<td><s:property value="idx_freq" /></td>
					<td><s:property value="idx_source" /></td>
					 
					<td><s:property value="idx_year"/></td>
					<td><s:property value="idx_value"/></td>
				
					<td><s:property value="idx_unit" /></td>
				</tr>
					</s:iterator>
			</s:iterator>
		</tbody>
	</table>
	<a  id="exportYearInformExcel" href="javascript:void(0)">导出数据</a>
</body>
</html>