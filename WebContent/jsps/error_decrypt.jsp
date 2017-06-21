<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PHR云管理系统</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<style type="">
.error{background:url(${pageContext.request.contextPath }/images/404.png) no-repeat; width:490px; margin-top:75px;padding-top:65px;}
</style>
<script language="javascript">
	$(function(){
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
	$(window).resize(function(){  
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
    })  
});  
	

</script> 


</head>


<body style="background:#edf6fa;">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    
    <li><a href="#">错误提示</a></li>
    </ul>
    </div>
    
    <div class="error">
  
    <h2>解密失败，属性不满足访问策略！</h2>
   
    <div class="reindex"><a id="main" href="${pageContext.request.contextPath }/jsps/disk_doctor.jsp" target="_parent">返回主页</a></div>
    
    </div>



</body>
</html>