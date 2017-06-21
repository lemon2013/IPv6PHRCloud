<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/jsps/public/header.jspf" %>
<html>
<script type="text/javascript">
$().ready(function() {

	$("#login_form").validate({
		rules: {
			email: {
				required: true,
				email: true
			},
			
			password: {
				required: true,
			}
			
			
		},
		messages: {
			email:{
				required:"email不能为空！",
				email:"请输入有效的email地址！"
			},
			
			password: {
				required: "请输入密码！",
			}			
		}
	});

});
function setFormAction(){
	var loginForm=document.forms[0];
	var role=document.getElementById("role").value;
	if(role=="user"){
		loginForm.setAttribute("action", "${pageContext.request.contextPath}/userAction_login");
		}
	else if(role=="doctor"){
		loginForm.setAttribute("action", "${pageContext.request.contextPath}/doctorAction_login");
	}	
}

</script>
<head>
<title>PHR云管理系统登陆界面</title>
</head>
<body >
<h1 color="blue">欢迎登录PHR云管理界面</h1>
<br/>
<hr>
<br/>
<br/> 
<br>
 <table align="center">
 <tr>
 <td></td>
 <td>
 <span color="red"><s:fielderror fieldName="error"></s:fielderror></span>
<form id="login_form" action="" method="POST">
<div >Email：<input type="text"  name="email" /></div><br>
<div>密码：<input type="password" name="password"  /></div><br>
<div>身份：<select id="role" name="role"><option value="user">患者</option><option value="doctor">医生</option></select></div><br>
	


<div ><input type="submit" id="login" value="登录" onclick="setFormAction()"></input>
	<input type="reset" value="重置">
</div><br/>        		
					        		
</form>

<a href="${pageContext.request.contextPath}/jsps/register.jsp">用户注册</a>

 </tr>

</table>


</body>

<div style="height:50px; line-height:50px; text-align:center;  repeat-x;position:absolute; bottom:0; width:100%; color:#0b3a58;">版权所有  2017 湖南大学  仅供学习交流，勿用于任何商业用途</div>
</html>