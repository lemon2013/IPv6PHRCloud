<%@ page language="java" contentType="text/html;utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PHR云管理系统</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath }/js/jquery.js"></script>



</head>

<body style="background:url(${pageContext.request.contextPath }/images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="" target="_parent"><img height="75px" width="220" src="${pageContext.request.contextPath }/images/logo.png" title="系统首页" /></a>
    </div>
        
   
            
    <div class="topright">    
    <ul>
    <li><span><img src="${pageContext.request.contextPath }/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="${pageContext.request.contextPath}/doctorAction_logout" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>${doctor.name }</span>
    <i>消息</i>
    
    </div>    
    
    </div>


</body>
</html>