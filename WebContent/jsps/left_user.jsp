<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PHR云管理系统</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath }/js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
<%  
java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy年MM月dd日");  
java.util.Date currentTime = new java.util.Date();//得到当前系统时间  
String str_date1 = formatter.format(currentTime); //将日期时间格式化  
String str_date2 = str_date1.toString(); //将Date型日期时间转换成字符串形式  
 %>  

                    

</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span> 
	 
     <%=str_date2 %>
    </div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath }/images/leftico01.png" /></span>全部文件
    </div>
    	<ul class="menuson">
        
        <li class="active"><cite></cite><a href="${pageContext.request.contextPath }/fileAction_listAll" target="rightFrame">文档</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/jsps/error_user.jsp" target="rightFrame">图片</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/jsps/error_user.jsp"" target="rightFrame">视频</a><i></i></li>
       <li><cite></cite><a href="${pageContext.request.contextPath }/jsps/error_user.jsp"" target="rightFrame">回收站</a><i></i></li>
        </ul>    
    </dd>
    
    </dl>
    

</body>
</html>