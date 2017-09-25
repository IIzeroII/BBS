<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.net.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String userName = "";
	String userPassword = "";
	Cookie[] cookies = request.getCookies();
	//如果cookie不为null，则遍历cookie
	if(cookies != null){
		for(Cookie cookie : cookies){
			if("userName".equals(cookie.getName())){
				userName = URLDecoder.decode(cookie.getValue(), "UTF-8");
			}
			if("userPassword".equals(cookie.getName())){
				userPassword = URLDecoder.decode(cookie.getValue(), "UTF-8");
			}
		}
	}
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
	    		<span id="main_span2">LOGIN&nbsp;&nbsp;用户登录</span>
	    	</div>
	    	<div id="main_middle">
		    	<div id="main_middle_left"><img src="pc/images/login_06.gif" /></div>
		    	<div id="main_middle_middle">
		    		<img src="pc/images/login_07.gif" />
		    		<form action="<%=basePath %>loginUsers.action" method="post">
			    		<div id="text_login">
			    			<font size="2">用户名：</font>
			    			<input type="text" name="userName" value="<%=userName %>" required="true" />
			    			<br />
			    			<br />
			    			<font size="2">密&nbsp;&nbsp;码：</font>
			    			<input type="password" name="userPassword" value="<%=userPassword %>" required="true" />
			    		</div>
			    		<div id="btn_login" style="margin-top: 10%">
			    			<input type="submit" value="登录"/ >
			    			<input type="button" value="注册"  onclick="window.location.href='pc/jsp/register.jsp'" />
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
</html>
