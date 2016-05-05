<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/script/jquery.js"></script>
<script type="text/javascript">
	$(function(){

		function AjaxUnit(url, params, callBack) {
			$.ajax({
				url : url,
				type : "post",
				dataType : "json",
				data : params,
				success : function(msg) {
					callBack(msg);
				}
			})
		}
		$("#createInviterNumber").click(function(){
			function callBack(msg){
				console.log(msg);
				var value=$("#inviterNumber").val(msg);
			}		
			AjaxUnit("admin_createInviterNumber.action?date="+new Date(), "",callBack);
			
			});
			$("#saveInviterNumber").click(function(){
				href="admin_saveInviterNumber?admin_inviteNumber="+$("#inviterNumber").val();
				window.open(href,"_self");
				});
		});
</script>
</head>
<body>
	<tr>
	<td>
	<input type="text" value="" disabled="disabled" id="inviterNumber"/>
	</td>
	<td>
	<input type="button" value="生成邀请码" id="createInviterNumber"/>
	</td><br/>
	<td><input type="button" value="注册" id="saveInviterNumber"/></td>
	</tr>
</body>
</html>