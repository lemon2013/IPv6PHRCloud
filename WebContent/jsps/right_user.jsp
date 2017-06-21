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

<script type="text/javascript">
$(document).ready(function(){
  $("#add").click(function(){
  window.location.href="${pageContext.request.contextPath}/jsps/uploadFile.jsp";
  });
  $("#update").click(function(){
	  window.location.href="${pageContext.request.contextPath}/jsps/uploadFile.jsp";
	  });
  $("#delete").click(function(){
	  window.location="tab.html";
	  });
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});
	$("a[name=del]").each(function(index, dom){
		$(dom).click(
				function(){				
					var bool=window.confirm("确定删除？");
					if(!bool){
						return false;
					}
					else{
						return true;
					}
				}
		);
		
	});
  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});


</script>


</head>


<body>

	<div class="place">
    <span>我的网盘：</span>
    <ul class="placeul">
    <li><a>我的文件</a></li>
    
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
          <li id="add"><span><img src="${pageContext.request.contextPath }/images/t01.png" /></span>加密上传</li>
       
        
       	<li> <form action="${pageContext.request.contextPath}/userAction_searchFile">
	 		 文件名：<input type="text"  name="filename" id="filename" class="dfinput"  style="width:150px;"/> 
	 		 <input type="submit" value="查询">
	 		<form>
	 	</li>
        </ul>
        
        
     
    
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>文件名<i class="sort"><img src="${pageContext.request.contextPath }/images/px.gif" /></i></th>       
        <th>文件类型</th>
        <th>大小</th>
        <th>上传时间</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
     
         <s:iterator var="myFile" value="#request.myFileList">
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td><s:property value="#myFile.name"></s:property></td>       
        <td><s:property value="#myFile.type"></s:property></td>
        <td><s:property value="#myFile.size"></s:property> KB</td>
        <td><s:property value="#myFile.createDate"></s:property></td>      
        <td> <a name="del"  href="${pageContext.request.contextPath}/fileAction_deleteFile?fileID=<s:property value="#myFile.id"/>" class="tablelink">删除</a>
	    <a href="${pageContext.request.contextPath}/fileAction_to_rename?fileID=<s:property value="#myFile.id"/>" class="tablelink">重命名</a>
	    <a href="${pageContext.request.contextPath}/fileAction_open?fileID=<s:property value="#myFile.id"/>" class="tablelink">下载</a></td>
       
        </tr>
        </s:iterator>
        </tr>            
        </tbody>
    </table>
    
   
    <div class="pagin">
    	<div class="message">共 <i class="blue"><s:property value="#size"/></i> 条记录，当前显示第&nbsp;<i class="blue">1&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem current"><a href="javascript:;">1</a></li>
        <li class="paginItem "><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="${pageContext.request.contextPath }/images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>


</body>
</html>
    