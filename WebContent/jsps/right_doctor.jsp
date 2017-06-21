<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PHR云管理系统</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/select-ui.min.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
  <script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>

</head>

<body>

	<div class="place">
    <span>您好, ${doctor.name }</span>
   
    </div>
    
    <div class="formbody">   
    <div id="usual1" class="usual">   
    
  	<div id="tab2" class="tabson">  
  	<form  name="form1" action="${pageContext.request.contextPath}/myFileExdAction_search" method="post">
    <ul class="seachform">    
    <li><label>文件名:</label><input name="name" id="fileName" type="text" class="scinput" /></li>   
    <li><label>患者姓名:</label><input  name="owner" id="userName" type="text" class="scinput" /></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"/></li>
    <li><label>&nbsp;</label><input name="" type="reset" class="scbtn" value="重置"/></li>
    </ul>
    </form>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        
        <th>文件名</th>
        <th>所有者</th>
        <th>文件大小</th>
        <th>上传时间</th>       
        <th>操作</th>
        </tr>
        </thead>
        
        <tbody>
        
        <s:iterator var="myFile" value="#request.myFileList">
	    <tr>   
	    <td><input name="" type="checkbox" value="" /></td>
	    <td><s:property value="#myFile.name"></s:property></td>
	    <td><s:property value="#myFile.owner"></s:property></td>
	    <td><s:property value="#myFile.size"></s:property> KB</td>
	    <td><s:property value="#myFile.createDate"></s:property></td>
	    <td><a href="${pageContext.request.contextPath}/fileAction_download?fileID=<s:property value="#myFile.id"/>" class="tablelink">解密并下载</a>
	    <a href="${pageContext.request.contextPath}/fileAction_open?fileID=<s:property value='#myFile.id'/>" class="tablelink">下载</a></td>
	    </tr> 
	    </s:iterator>   
   
        </tbody>
    </table>   
    </div>  
       
	</div> 
 
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
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script> 
    </div>
</body>

</html>    