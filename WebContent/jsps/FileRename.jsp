<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PHR云管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
	 <li><a href="#">文件重命名</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>重命名</span></div>
    <form action="${pageContext.request.contextPath}/fileAction_rename" method="post">
    <ul class="forminfo">
    <li><label>原文件名</label><input name=""  value="${request.filename}" type="text" class="dfinput"  disabled="disabled"/></li>
    <li><label>新文件名</label><input id="name" name="name" type="text" class="dfinput" /></li>
 	<li><input type="text" id="id" name="id" value="${request.id}" style="display:none"></input></li>

    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>    
    </div>
</body>
</html>