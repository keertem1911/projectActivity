<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
	<title>一带一路数据详情</title>
	<link rel="icon" style="coclor:blue" href="${pageContext.request.contextPath}/icons/toplogo.ico" type="image/x-icon" />
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/icons/toplogo.ico">
	<link rel="Bookmark" href="${pageContext.request.contextPath}/icons/toplogo.ico">
	
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<style type="text/css">
tr select {
	width: 70%;
	height: 25px;
	align:center;
	 text-align: center;
}
tr {
	width: 200px;
	height: 30px;
	align:center;
}
 #submit{
 	 position: absolute;
 	left:3.8%;
 	width:100px;
 }
 #viewchart{
    position: absolute;
 	left:3.8%;
 	width:100px;
 	height:22px;
 	color:white;
 	background-color:blue;
 	border: 0;
 }
 #exportYearInformExcel{
  position: absolute;
 	left:250px;
 }
 td{
   text-align:center; 
 	color: black;
 	 
 }
 .showList1{
 	height:35px;
 }
 .showList1:HOVER{
 	 background-color:silver;
 	  font-stretch: expanded;
 	 font-family: Fantasy ;
		text-decoration: none;
		line-height:50px;
		
 } 
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/data.js">	</script>
<body>
<!-- header -->
<div class="header">
	<div class="top">
		<div class="welcome">
			<span>欢迎访问</span>
			<span id="phone">手机访问
				<div class="tooltip">
					<p>敬请期待，或者加入一个二维码</p>
				</div>
			</span>
		</div>

		<div class="btn">
			欢迎
			<a href="" id="login">
			<% if(session.getAttribute("power").equals("admin")) {%>
			<%="管理员" %>
			<%}else{ %> 
			<%=session.getAttribute("power") %>			  
		  	<%} %>
			</a>
			<a href="comment_exitLogin.action" class="flatbtn">退出 </a>
			 
		</div>
	</div>
	<div class="bottom">
		<div class="logo">
			<img   src="${pageContext.request.contextPath}/image/logo.png">
		 
		</div>

		<ul class="nav">
			<li><a href="comment_index.action">首页</a></li>
			<li><a href="#">全球</a></li>
			<li><a href="#">省区</a></li>
			<li><a href="#">区市</a></li>
		</ul>
	</div>
</div>
<!-- section -->
<div class="section">
	<div class="seat">
		<p><strong>数据</strong>>省区></p>
	</div>
	 
	<div class="data">
			<table id="htable" width="100%" align="center" border="0" cellpadding="1" cellspacing="1">
			<tr>
				<td><select class="idx_n" id="idx_1">
						<option value="-1">无</option>
				</select></td> 
			</tr>
			<tr><td ><select id="idx_2" class="idx_n">
						<option value="-1">无</option>
				</select></td>
			</tr>
			<tr>	<td ><select id="idx_3" class="idx_n">
						<option value="-1">无</option>
				</select></td>
			</tr>
			<tr>
				<td  ><select id="idx_4" class="idx_n">
						<option value="-1">无</option>
				</select></td>
			</tr>
			<tr>
				<td ><select id="idx_5" class="idx_n">
						<option value="-1">无</option>
				</select></td>
				</tr>
				<tr>
				<td ><select id="idx_6" class="idx_n">
						<option value="-1">无</option>
				</select></td>
				</tr>
				  <tr style="display: none">
				  <td  ><select style="display: none;" id="idx_7" class="idx_n">
						<option value="-1">无</option>
				</select></td>  
				</tr> 
				<tr>
				<td ><select id="idx_source" class="idx_n">
						<option value="-1">无</option>
				</select></td>
				</tr>
				<tr>
				<td  ><select style="width:31.3%" id="idx_begin">
						<option value="-1">起始年份</option>
				</select> --- 
					<select style="width:31.3%" id="idx_end">
						<option value="-1">终止年份</option>
				</select>
				</td>
				</tr>
				<TR>
				<td><div><input type="button" style="width:280px" id="submit"   value="查询" /></div></td>
				</TR>
				<TR><td><div><input type="button" style="width:280px" id="viewchart"   onclick="window.location.href='comment_graph.action'"value="<<<<图表预览" /></div></td>
				</TR>
				<tr><td>
				<form action="comment_uploadSave.action" method="post"  enctype="multipart/form-data" id="form" style="margin-top:12px" >
				
				<label style="width: 100px;position: absolute;left:44px">上传数据 :</label> 
				 <input type="file" style="position: absolute;left:150px;" name="upload" value="" id="upload" /> <br/> 
				<input type="button" style="position: absolute;width:280px;left:60px;margin-top:5px" value="保存" id="uploadsubmit"/>
			  	 </form>
			  	
				 </td></tr>
				  <% if(session.getAttribute("power").equals("admin")) { %>
					<tr><td>
				   <a  style="color: white;position: absolute;top:85%;" id="exportYearInformExcel" href="javascript:void(0)">导出数据</a></td>
				  	</tr>
				  <%} %>
					
		</table>
	</div>
	<div class="content" style="background-color: white;">
	<table style="background-color:gray;height:10%;width:100%;font-size: 1.2em;" >
				<tr>
					<td width="12%">省份</td>
					<td width="20%">指标名称</td>
					<td width="15%">类型</td>
					<td width="8%">更新频率</td>
					<td width="10%">来源</td>
					<td width="10%" >单位</td>
					<td width="10%">年份</td>
					<td width="15%">数值</td>

				</tr>
			</table>
	<div style="height: 644px;overflow: scroll;">
	
		<table class="showtable" align="center" style="width:100%;" border="1"   cellpadding="0"
			cellspacing="0">
			 
			
			<tbody id="showList" style="width:100%;" >
			</tbody>
		</table>
	</div>
	</div>
	 
</div>
<!-- footer -->
<div class="footer">
	<div class="footercontent">
		<p class="footerp">西安邮电大学计算机金融与风险管理研究中心&nbsp版权所有</p>
		<p class="footerp">电话 : 029-88166704</p>
	 	<a href="http://jsjr.xupt.edu.cn" class="footera">相关链接: http://jsjr.xupt.edu.cn</a>
	</div>
</div>
</body>
</html>