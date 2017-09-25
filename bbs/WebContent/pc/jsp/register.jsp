<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BBS论坛</title>
<link rel="stylesheet" type="text/css" href="pc/css/login.css" />
</head>
<body>
	<div class="container">
		<!-- 左边背景 -->
		<div id="left"><img src="pc/images/login_03.gif" /></div>
	    
	    <!-- 主体 -->
	    <div id="main">
	    	<div id="main_top">
	    		<img src="pc/images/login_04.gif" />
	    		<span id="main_span1"><img src="pc/images/main_01.jpg" /></span>
	    		<span id="main_span2">REGISTER&nbsp;&nbsp;用户注册</span>
	    	</div>
	    	<div id="main_middle">
		    	<div id="main_middle_left"><img src="pc/images/login_06.gif" /></div>
		    	<div id="main_middle_middle">
		    		<img src="pc/images/login_07.gif" />
		    		<form id="registerForm" action="<%=basePath %>registerUsers.action" method="post">
			    		<div id="text_login">
			    			<font size="2">用户名：</font>
			    			<input type="text" name="userName" />
			    			<br />
			    			<font size="2">密&nbsp;&nbsp;码：</font>
			    			<input type="password" name="userPassword" />
			    			<br />
			    			<font size="2">重复密码：</font>
			    			<input type="password" name="rePassword" />
			    		</div>
			    		<div id="btn_login" style="margin-top: 2%;">
			    			<input id="registerBtn" type="button" value="提交" / >
			    			<input type="reset" value="重置" />
			    		</div>
		    		</form>
		    	</div>
		    	<div id="main_middle_right"><img src="pc/images/login_08.gif" /></div>
	    	</div>
	    	<div id="main_bottom"><img src="pc/images/login_09.gif" /></div>
	    </div>
	 	
	 	<!-- 右边背景 -->
	 	<div id="right"><img src="pc/images/login_03.gif" /></div>
	 </div>
</body>
<script type="text/javascript" src="<%=basePath%>pc/js/jQuery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>pc/js/global.js"></script>
<script type="text/javascript" src="<%=basePath%>pc/js/register.js"></script>
</html>
