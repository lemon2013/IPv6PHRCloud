<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<title>登陆成功</title>
	<%@ include file="/jsps/public/header.jspf" %>
	<link href="${pageContext.request.contextPath}/style/blue/logout.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<table border=0 cellspacing=0 cellpadding=0 width=100% height=100%>
		<tr>
			<td align=center>
				<div id=Logout>
					<div id=AwokeMsg><img id=LogoutImg src="${pageContext.request.contextPath}/style/blue/images/logout/logout.gif" border=0 /><font size="5" color="blue">注册成功！</font></div>
					<div id=LogoutOperate>
						<img src="${pageContext.request.contextPath}/style/blue/images/logout/logout2.gif" border=0 /> 
						
						<%-- 这个超链接不适用<s:a>标签！！ --%>
						<a href="${pageContext.request.contextPath}/jsps/login.jsp">返回登录页面</a>

						<!--
			window.close(); 可以关闭IE6~9
			window.open('', '_self'); window.close(); 可以半闭 chrome
			FireFox不可以关闭
						-->
                    <img src="${pageContext.request.contextPath}/style/blue/images/logout/logout3.gif" border=0 /> <a href="javascript:window.open('', '_self'); window.close();">关闭当前窗口</a>
                    </div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
	