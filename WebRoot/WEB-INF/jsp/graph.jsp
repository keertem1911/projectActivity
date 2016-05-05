<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	 <title>一带一路图表预览</title>
	<link rel="icon" style="coclor:blue" href="${pageContext.request.contextPath}/icons/toplogo.ico" type="image/x-icon" />
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/icons/toplogo.ico">
	
	  <meta charset="UTF-8">  
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/mapview/css/style.css">
</head>
<body>
<!-- header -->
<div class="header">
	<div class="top">
		<div class="welcome">
			<span>欢迎访问</span>
			<span id="phone">手机访问
				<div class="tooltip">
				 </div>
			</span>
		</div>

		<div class="btn">
				欢迎
			<a href="#" id="login"> 
			<% if(session.getAttribute("power").equals("admin")) {%>
			<%="管理员" %>
			<%}else{ %>
			<%=session.getAttribute("power") %>			  
		  	<%} %>
		  	<a href="comment_exitLogin.action" class="flatbtn">退出 </a>
			 </a>
		</div>
	</div>
	<div class="bottom">
		<div class="logo">
			<img src="image/logo.png">
		</div>

		<ul class="nav">
			<li><a href="comment_index.action">首页</a></li>
			<li><a href="#">全球</a></li>
			<li><a href="#section-item1">省区</a></li>
			<li><a href="#section-item2">区市</a></li>
		</ul>
	</div>
</div>
<!-- section -->
<div class="section" id="section">
	<div id="section-item1">
		<div class="seat">
			<p><strong>图表</strong>>省区></p>
		</div>
		<div class="content" id="content">
			<div id="container0" class="content-map" style="height: 600px; width:1000px "></div>
       		<div id="containerl"  class="content-map" style="height: 600px; width:1000px "></div>
       		<div id="containerZ"  class="content-map" style="height: 600px; width:1000px "></div>
       		<div id="container1"  class="content-map" style="height: 600px; width:1000px "></div>
		</div>
		<div class="data" id="data">
			<div class="list">
				<span class="list-title">数据区域分布概要</span>
				<ul>
					<li class="list-content" id="showmap1">地图分布图</li>
				</ul>
			</div>

			<div class="list">
				<span class="list-title">数据区域分布详细</span>
				<ul>
					<li class="list-content" id="showLineChart">年份折线对比图</li>
					<li class="list-content" id="showBarGraph">数据区域分布柱状图</li>
				</ul>
			</div>
			<div class="list">
				<!-- <ul class="list-title"> -->
				<a class="list-link" style="color: white"href="comment_data.action">数据详情>>>>>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  </a>
				<!-- <ul>
					<li class="list-content" id="showmap1">地图分布图</li>-->
				<!-- </ul>  -->
			</div> 

			 
		</div>
	</div>

	<div id="section-item2">
		<div class="seat">
			<p><strong>数据</strong>>全球/区市></p>
		</div>
		<div class="content">
			<div id="container2" class="content-map" style="height: 600px; width:1000px "></div>
       		<div id="container3" class="content-map" style="height: 600px; width:1000px "></div>
       		<div id="container4" class="content-map" style="height: 600px; width:1000px "></div>
      		<div id="container5" class="content-map" style="height: 600px; width:1000px "></div> 
		</div>
		<div class="data">
			<div class="list">
				<span class="list-title">区市1...</span>
				<ul>
					<li class="list-content">第五个地图</li>
				</ul>
			</div>

			<div class="list">
				<span class="list-title">区市2...</span>
				<ul>
					<li class="list-content">第六个地图</li>
				</ul>
			</div>

			<div class="list">
				<span class="list-title">区市3...</span>
				<ul>
					<li class="list-content">第七个地图</li>
					<li class="list-content">第八个地图</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="selectIdx"  style="position: absolute;top:80%;left:26%;">
	<ul>	
	<li><select  style="width:150px" id="idx_11">
		<option value="-1">无省份</option>
	</select></li>
	<li>
	<select  style="width:150px" id="idx_12">
		<option value="-1">无省份</option>
	</select></li>
	<li><select  style="width:150px" id="idx_2">
		<option value="-1">无</option>
	</select>
	</li>
	<li>
	<select style="width:150px"  id="idx_3">
		<option value="-1">无</option>
	</select>
	</li>
	</ul>
	
	<input type="button" style="width:100px" value="显示" id="showbut"/>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/mapview/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/mapview/js/tab.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/mapview/map/echarts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/mapview/map/china.js"></script>
<!-- 地图 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/mapview/map/chart.js"></script>
</body>
</html>