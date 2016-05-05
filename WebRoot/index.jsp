<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
	<title>一带一路科技支撑数据库</title>
	<link rel="icon" style="coclor:blue" href="icons/toplogo.ico" type="image/x-icon" />
	<link rel="shortcut icon" href="icons/toplogo.ico">
	<link rel="Bookmark" href="icons/toplogo.ico">
	   <link rel="stylesheet" type="text/css" href="bootstrap-3.3.5-dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/cs.css">
	<script type="text/javascript" src="script/reg.js"></script>
	<script type="text/javascript" src="script/jquery-1.9.1.min.js"></script>
  	<script type="text/javascript" charset="utf-8" src="script/jquery.leanModal.min.js"></script>
	<script type="text/javascript" src="script/jj.js"></script>
	<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	
</head>
<body display="block">
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
		 
		 <% if(session.getAttribute("power")!=null&&session.getAttribute("power").equals("admin")){ %>
		 	 <a href="#" class="flatbtn" >欢迎</a>
			<a href="#" class="flatbtn" >管理员</a>  
			<a href="comment_exit.action" class="flatbtn">退出 </a>
		 	<%} else if(session.getAttribute("power")!=null&&!"".equals(session.getAttribute("power"))){%>
		 		 <a href="#" class="flatbtn"  >欢迎</a>
			<a href="#" class="flatbtn" id="login"><%=session.getAttribute("power") %></a>  
			<a href="comment_exitLogin.action" class="flatbtn">退出 </a>
		 	<%}else{ %>
			 <a href="#loginmodal" class="flatbtn" onclick="modalLogin()" id="login">登录</a>
			<a href="#registermodal" class="flatbtn" onclick="modalRegister()" id="register">注册</a>  
			<%} %>
			</div>
	</div>
	<div class="bottom">
		<div class="logo">
			<img src="img/logo.png">
		</div>

		<ul class="nav">
			<li><a href="index.jsp">首页</a></li>
			<% if(session.getAttribute("power")!=null&&!"".equals(session.getAttribute("power"))){ %>
			<li><a href="comment_graph.action" id="graph">图表</a></li>
			<li><a href="comment_data.action" id="data">数据</a></li>
			<%}else{ %>
			 
			<li><a href="#loginmodal" id="graph" onclick="modalLogin()">图表</a></li>
			<li><a href="#loginmodal" id="data" onclick="modalLogin()">数据</a></li>
			<%} %>
		</ul>
	</div>
</div>

	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="image/picture11.jpg" alt="">
      <div class="carousel-caption">
        ...
      </div>
    </div>
    <div class="item">
      <img src="image/picture4.jpg" alt="">
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
  </a>
</div>
		<div class="headline_content">
		<div class="headline34">
			<img class="headline3" src="img/headline3.png">
			<img class="headline4" src="img/headline4.png">
		</div>
		<ul>
			<li class="headline_chart">
				<img src="img/headline_chart.png">
				<p>图表</p>
				<p>
					数据分布特征直观,对比鲜明
				</p>
			</li>
			<li class="headline_data">
				<img src="img/headline_data.png">
				<p>数据</p>
				<p>
					支持各类方式查询,内容详细丰富
				</p>
			</li>
			<li class="headline_server">
				<img src="img/headline_s.png">
				<p>服务</p>
				<p style="text-align:left;font-size:0.8em;wodth:100px">
					&nbsp;&nbsp;&nbsp;&nbsp;暂未开放 &nbsp;&nbsp; 
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</p>
				
			</li>		
		</ul>
	</div>
</section>
<div class="divpw">
<section class="chart">
	<div class="chart_content">
		<h3>图表</h3>
		<div class="haha">
			<h3>可视化</h3>
			<p>包含区域分布，纵向、横向特征对比</p>
		</div>
		<% if(session.getAttribute("power")!=null&&!"".equals(session.getAttribute("power"))){  %>
			<a href="comment_graph.action">预览一下&nbsp;→</a> 
		<%} else{ %>
		<a href="#loginmodal"  onclick="modalLogin()">预览一下&nbsp;→</a>
		<%} %>
	</div>
</section>
<section class="data">
	<div class="data_content">
		<h3>数据</h3>
		<div class="haha">
			<h3>详情</h3>
			<p>指标多样，涵盖内容广阔</p>
		</div>
			<% if(session.getAttribute("power")!=null&&!"".equals(session.getAttribute("power"))){  %>
			 <a href="comment_data.action" >预览一下&nbsp;→</a> 
		<%} else{ %>
		<a href="#loginmodal"  onclick="modalLogin()">预览一下&nbsp;→</a>
		<%} %>
	</div>
</section>
<section class="server">
	<div class="server_content">
		<h3>服务</h3>
		<div class="haha">
			<h3>会员</h3>
			<p>暂未开放</p>
		</div>
		<% if(session.getAttribute("power")!=null&&!"".equals(session.getAttribute("power"))){  %>
			 <a href="javascript:void(0);" onclick="alert('该功能暂未开放');" >预览一下&nbsp;→</a> 
		<%} else{ %>
		<a href="#loginmodal"  onclick="modalLogin()">预览一下&nbsp;→</a>
		<%} %>
	</div>
</section>
</div>

<div class="footer">
	<div class="footercontent">
		<p class="footerp">西安邮电大学计算机金融与风险管理研究中心&nbsp版权所有</p>
		<p class="footerp">电话 : 029-88166704</p>
	 	<a href="http://jsjr.xupt.edu.cn" class="footera">相关链接: http://jsjr.xupt.edu.cn</a>
	</div>
</div>
<!-- 模态框 -->
<div id="overlayLogin" style="display: none;">
	<div id="loginmodal"><div class="canner" onclick="modalLogin();">X</div>
    <h1>User Login</h1>
    <form id="loginform" name="loginform" method="post" action="index.html">
      <label for="username">Username:</label>
      <input type="text" name="user_username" id="login_username" class="txtfield" tabindex="1">  
      <label for="password">Password:</label>
      <input type="password" name="user_password" id="login_password" class="txtfield" tabindex="2">
      <div class="center"><input type="submit" name="loginbtn" id="loginbtn" class="flatbtn-blu hidemodal" value="Log In" tabindex="3" ></div>
    </form>
</div>
</div>

<div id="overlayRegister" style="display: none;">
	<div id="registermodal"><div class="canner"   onclick="modalRegister()">X</div>
    <h1>User Register</h1>
    <form id="registerform" name="registerform" method="post" action="index.html">
      <label for="username">Username:</label>
      <input type="text" name="username" id="register_username" class="txtfield" tabindex="1">
      <label for="password">Password:</label>
      <input type="password" name="password" id="register_password" class="txtfield" tabindex="2">
      <label for="email">Email:</label>
      <input type="text" name="email" id="register_email" class="txtfield" tabindex="3">
      <label for="email">inviteNumberee:</label>
      <input type="text" name="inviteNumberee" id="register_inviteNumberee" class="txtfield" tabindex="3">
      <div class="center"><input type="submit" name="registerbtn" id="registerbtn" class="flatbtn-blu hidemodal" value="register" tabindex="4"></div>
    </form>
</div>

</div>
</body>
</html>