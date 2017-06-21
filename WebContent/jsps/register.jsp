<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<script type="text/javascript">
$().ready(function() {
	$("#register_patient").validate({
		rules: {
			email: {
				required: true,
				email: true
			},
			username: {
				required: true,		//验证规则起作用
				rangelength: [4,20]
			},
			name:{
				required:true
			},
			age:{
				required:true,
				range:[1,120]
			},
			password: {
				required: true,
				rangelength: [6,20]
			},
			password2: {
				required: true,
				rangelength: [6,20],
				equalTo: "#password"
			}
			
			
		},
		messages: {
			email:{
				required:"email不能为空！",
				email:"请输入有效的email地址！"
			},
			username: {
				required: "请输入用户名！",
				rangelength: "用户名长度为4—20个字符！"
			},
			name:{
				required:"请输入真实姓名！"
			},
			age:{
				required:"请输入年龄!",
				range:"请输入有效的年龄，年龄范围1-110！"
			},
			password: {
				required: "请输入密码！",
				rangelength: "密码长度为6—20个字符"
			},
			password2: {
				required: "请输入确认密码!",
				rangelength: "确认密码长度为6—20个字符",
				equalTo: "两次密码输入不一致！"
			}
			
		}});
	$("#register_doctor").validate({
		rules: {
			email: {
				required: true,
				email: true
			},
			username: {
				required: true,		//验证规则起作用
				rangelength: [4,20]
			},
			name:{
				required:true
			},
			age:{
				required:true,
				range:[1,110]
			},
			department:"required",
			jobid:"required",
			password: {
				required: true,
				rangelength: [6,20]
			},
			confirm_password: {
				required: true,
				rangelength: [6,20],
				equalTo: "#password"
			}
			
			
		},
		messages: {
			email:{
				required:"email不能为空！",
				email:"请输入有效的email地址！"
			},
			username: {
				required: "请输入用户名！",
				rangelength: "用户名长度为4—20个字符！"
			},
			name:{
				required:"请输入真实姓名！"
			},
			age:{
				required:"请输入年龄!",
				range:"请输入有效的年龄，年龄范围1-110！"
			},
			department:"请输入部门！",
			jobid:"请输入工号！",
			password: {
				required: "请输入密码！",
				rangelength: "密码长度为6—20个字符"
			},
			confirm_password: {
				required: "请输入确认密码!",
				rangelength: "确认密码长度为6—20个字符",
				equalTo: "两次密码输入不一致！"
			}
			
		}
	});
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
	
	document.getElementById("section").onchange = function(){
		
		var sectionValue = document.getElementById("section").value;
		
		//2 解析xml文件
		var docXml = loadxmlDoc("./departments.xml");
		
		var sectionXmlElements = docXml.getElementsByTagName("section");
		
	
		var departmentElement = document.getElementById("department");
		var optionsOld = departmentElement.getElementsByTagName("option");
		for(var z=optionsOld.length-1;z>0;z--){
			departmentElement.removeChild(optionsOld[z]);
		}
		
			for(var i=0;i<sectionXmlElements.length;i++){
			var sectionXmlElement = sectionXmlElements[i];
			
			var sectionXmlValue = sectionXmlElement.getAttribute("name");
			
			//5 判断页面中的省份名称与xml文件中的省份是否一致
			if(sectionValue==sectionXmlValue){
				
				var departmentXmlElements = sectionXmlElement.getElementsByTagName("department");
				
				for(var j=0;j<departmentXmlElements.length;j++){
					var departmentXmlElement = departmentXmlElements[j];					
					var departmentXmlValue = departmentXmlElement.firstChild.nodeValue;				
					var optionElement = document.createElement("option");
					optionElement.setAttribute("value",departmentXmlValue);
					var departmentText = document.createTextNode(departmentXmlValue);
					optionElement.appendChild(departmentText);
					
					departmentElement.appendChild(optionElement);
					
				}
			}
		}
	}
	
	
});

function loadxmlDoc(file){
    try{
        //IE
        xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
    }catch(e){
        ////Firefox, Mozilla, Opera, etc
        xmlDoc=document.implementation.createDocument("","",null);
    }

    try{
        xmlDoc.async=false;
        xmlDoc.load(file);//chrome没有load方法
    }catch(e){
        //针对Chrome,不过只能通过http访问,通过file协议访问会报错
        var xmlhttp = new window.XMLHttpRequest();  
        xmlhttp.open("GET",file,false);  
        xmlhttp.send(null);  
        xmlDoc = xmlhttp.responseXML.documentElement; 
    }
    return xmlDoc;
}


</script>  

</head>

<body>
	<div  class="place">
    <span > <font size="50">PHR用户注册界面</font></span>
    <ul class="placeul">
    <li><a href="${pageContext.request.contextPath }/jsps/login.jsp">返回登录页面</a></li>   
    </ul>
    </div>
	
    
   
    
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">患者注册</a></li> 
    <li><a href="#tab2">医生注册</a></li> 
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">Hi，欢迎您注册，请填写注册信息！</div>
    
    <form id="register_patient" action="userAction_register" method="post">
    
    <ul class="forminfo">
    <li><label>email<b>*</b></label><input id="email" name="email" type="text" class="dfinput"   style="width:350px;"/><i>请输入有效的email地址</i></li>
      <li><label>用户名<b>*</b></label><input id="username" name="username" type="text" class="dfinput"  style="width:350px;"/><i>4—20个字符，支持英文字母、数字或其他特殊符号，不支持中文</i></li>
       <li><label>姓名<b>*</b></label><input id="name" name="name" type="text" class="dfinput"   style="width:350px;"/></li>
       <li><label>年龄<b>*</b></label><input id="age" name="age" type="text" class="dfinput"   style="width:350px;"/><i>年龄范围：1-110</i></li>
      <li><label>密码<b>*</b></label><input id="password" name="password" type="password" class="dfinput"   style="width:350px;"/><i>6—20个字符，支持字母、数字或其他特殊符号</i></li>
    <li><label>确认密码<b>*</b></label><input id="password2" name="password2" type="password" class="dfinput"   style="width:350px;"/></li>
    <li><label>性别</label>
     <div class="vocation">
     <select id="gender" name="gender" class="select1" style="width:100px;"><option value="0">女</option><option value="1">男</option></select>
     </div>
     </li>   
    <li><br/><br/></li>
    <li ><label>&nbsp; </label><input  name="" type="submit" class="btn"   value="注册"/>
    <label>&nbsp;</label><input name="" type="reset" class="btn" value="重置"/>
    </li>
    </ul>
    </form>
    
    </div> 
    
 <div id="tab2" class="tabson">
    
    <div class="formtext">Hi，欢迎您注册，请填写注册信息！</div>
    
    <form id="register_doctor" action="doctorAction_register" method="post">
    <ul class="forminfo">
    <li><label>email<b>*</b></label><input id="email" name="email" type="text" class="dfinput"   style="width:350px;"/><i>请输入有效的email地址</i></li>
      <li><label>用户名<b>*</b></label><input id="username" name="username" type="text" class="dfinput"   style="width:350px;"/><i>4—20个英文字符或数字，不支持中文</i></li>
       <li><label>姓名<b>*</b></label><input id="name" name="name" type="text" class="dfinput"  style="width:350px;"/><i>请输入真实姓名</i></li></li>
       <li><label>年龄<b>*</b></label><input id="age" name="age" type="text" class="dfinput"   style="width:350px;"/><i>年龄范围：1——110</i></li></li>
        <li><label>部门<b>*</b></label>
        <div class="usercity">
      <div class="cityleft">
    <select class="select2"  name="section" id="section">
    <option value="">请选择...</option>
    <option value="外科">外科</option>
     <option value="内科">内科</option>
     <option value="骨科">骨科</option>
     <option value="传染科">传染科</option>
     <option value="五官科">五官科</option>
    </select>
    </div>
    
    <div class="cityright">
    <select class="select2" name="department" id="department">
    <option>请选择...</option>
    </select>
    </div>
    </div>    
        </li>
         <li><label>工号<b>*</b></label><input id="jobid" name="jobid" type="text" class="dfinput"   style="width:350px;"/><i>请输入真实工号</i></li>
      <li><label>密码<b>*</b></label><input id="password" name="password" type="password" class="dfinput"   style="width:350px;"/><i>6—20个字符，支持字母、数字或其他特殊符号</i></li>
    <li><label>确认密码<b>*</b></label><input id="password2" name="password2" type="password" class="dfinput"   style="width:350px;"/></li>
     <li><label>性别</label>
     <div class="vocation">
     <select id="gender" name="gender" class="select1" style="width:100px;"><option value="0">女</option><option value="1">男</option></select>
     </div>
     </li>  
      <li><br/><br/></li>
    <li ><label>&nbsp;</label><input align="right" name="" type="submit"  class="btn" value="注册"/>
    <label>&nbsp;</label><input name="" type="reset" class="btn" value="重置"/>
    </li>
    </ul>
    </form>
    </div>     
        
	</div> 
 
	
    
    </div>

<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
 </script>

</body>
</html>
