  $(function(){
	  var flag=[1,1,1,1];
	  $("#login_username").blur(function(){
		if($(this).val()==null){
			alert("用户名不为空");
		//	$("#login_username").focus();
			flag[0]=0;
		} 
		
	  });
	  $("#login_password,#register_password").blur(function(){
		  if($(this).val()==null){
		  alert("密码不为空");
		//	$(this).focus();
			flag[1]=0;
		  }
	  });
   $('#loginform').submit (function(){
		var name=$("#login_username").val();
		var passwd=$("#login_password").val();
		var power="user";
		if(regObject.isIllegalEmail(name)){
			power='admin';
		}
		
		var username="";
		if(flag[0]&&flag[1]){
			href=power+"_loginCheck.action";
			var param ={};
			if(power=="admin"){
			param[power+"_email"]=name;
			username="_email=";
			}
			else{
				param[power+"_username"]=name;
				username="_username=";
			}
			
			param[power+"_password"]=passwd;
			$.ajax({
				url:href,
				type:"post",
				data :param,
				dataType:"json",
				success:function(msg){
					if(msg["status"]=="200"){
						alert("登陆成功");
						 
					  	window.open("comment_index.action","_self");
						}else if(msg["status"]=="300"){
							alert("登陆失败用户名不存在");
							$("#login_username").focus();
							}else if(msg["status"]=="400"){
								alert("登陆失败密码错误");
								$("#login_password").focus();
								}else{
									alert("网络异常请重新登陆");
									location.reload();
									}
					}
				});
			}
		return false;
	});
   $("#register_username").blur(function(){
	   var thiz=this;
	   if($(this).val()==""){
		   alert("用户名不为空");
			$("#register_username").empty();
		//	$("#register_username").focus();
			flag[0]=0;
	   }else if(regObject.isNotAllNumberAndNotIllegalChart($(this).val())==null
					||$(this).val().length<=5){
		   var flag=1;
		   if(flag&&$(this).val().length<=5){
				alert("用户名长度小于6位");
				flag[1]=0;
			}
			if(flag[1])
			alert("用户名名称格式不正确数字字母组成(以字母开头)");
			$("#register_username").empty();
		//	$("#register_username").focus();
			flag[1]=0;
	   }else {
		   $.ajax({
			   url:"user_registerCheckUsername.action",
			   data:{"user_username":$(this).val()},
			   dataType:"json",
			   type:"get",
			   success:function(msg){
				   if(msg["status"]=="200"){
						alert("用户名验证成功");
						flag[0]=1;
						}else if(msg["status"]=="300"){
							alert("用户名存在");
						//	$(thiz).focus();
							flag[0]=1;
							}else {
									alert("网络异常请重新登陆");
									location.reload();
									flag[0]=1;
									}
			   }
		   });
		   
	   }
   });
   
	$("#register_email").blur(function(){
	   if($(this).val()==""){
		   alert("邮箱不能为空");
		//	$(this).focus();
			flag[2]=0;
	   }else if(!regObject.isIllegalEmail($("#register_email").val())){
			alert("邮箱格式不正确");
	//		$(this).focus();
			flag[2]=0;
	   }else{
		   flag[2]=1;
	   }			  
	});
	$("#register_inviteNumberee").blur(function(){
		if(inviteNumberee==""){
			alert("邀请码不能为空");
		//	$(this).focus();
			flag[3]=0;
		}else{
			flag[3]=1;
		}
	});
	 
   $('#registerform').submit (function(){
		var name=$("#register_username").val();
		var passwd=$("#register_password").val();
		var email=$("#register_email").val();
		var inviteNumberee=$("#register_inviteNumberee").val();
		var power="user";
		  
			if(flag[0]&&flag[1]&&flag[2]&&flag[3]){
			href=power+"_registerCheck.action";
			var param ={};
		 	param[power+"_username"]=name;
			param[power+"_password"]=passwd;
			param[power+"_email"]=email;
			param[power+"_inviteNumberee"]=inviteNumberee;
			 
			$.ajax({
				url:href,
				type:"post",
				data :param,
				dataType:"json",
				success:function(msg){
					if(msg["status"]=="200"){
						alert("注册成功");
					  	window.open("comment_loginSuccess.action","_self");
						}else if(msg["status"]=="500"){
							alert("注册失败邀请码不存在");
							 var inpus =$("#registerform > input");
							 $("#register_inviteNumberee").val("");
							$("#register_inviteNumberee").focus();
							}else{
									alert("网络异常请重新登陆");
									location.reload();
							}
					}
				});
			}
	 
		return false;
	});
 
    });
	function modalLogin(){
		var mod = document.getElementById('overlayLogin');
	 	mod.style.display =  (mod.style.display== "block") ? "none" : "block";
	 	document.getElementById("login_username").value="";
	 	document.getElementById("login_password").value="";
	}
	function modalRegister(){
		var mod = document.getElementById('overlayRegister');
	 	mod.style.display =  (mod.style.display== "block") ? "none" : "block";
		document.getElementById("register_username").value="";
	 	document.getElementById("register_password").value="";
		document.getElementById("register_email").value="";
	 	document.getElementById("register_inviteNumberee").value="";
	}
	