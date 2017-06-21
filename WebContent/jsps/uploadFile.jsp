<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PHR云管理系统</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
</head>
<script type="text/javascript">
$().ready(function(){
	$("#encrypt").click(
		function(){
			var uploadfile=$("#uploadfile").val();
			var accessPolicy=$("#accessPolicy").val();
			if(uploadfile==null||uploadfile==""){
				alert("请选择文件");
				return false;
			}			
			else if(accessPolicy==null||accessPolicy==""){
				alert("请输入访问策略")
				return false;
			}else
				return true;
			
		}	
	);
});
</script>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
	 <li><a href="#">加密上传界面</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>加密上传</span></div>
    <form id="uploadForm" action="${pageContext.request.contextPath}/fileAction_upload" method="post" enctype="multipart/form-data">
    <ul class="forminfo">
    <li><label>文件</label><input id="uploadfile" type="file" name="uploadfile" class="dfinput" value="浏览"/><i>上传类型：txt</i></li>
    <li><label>访问策略</label><input type="text" id="accessPolicy" name="accessPolicy" class="dfinput"/></li>
 	<li><i>访问策略输入格式：例如，若访问策略为“外科或内科”，则格式为：“部门：外科 部门：内科   1of2”</i></li>

    <li><label>&nbsp;</label><input id="encrypt" type="submit" class="btn" value="加密并上传"/></li>
    </ul>
    </form>    
    </div>
</body>
</html>