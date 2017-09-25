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
<link rel="stylesheet" type="text/css" href="pc/css/index.css" />
</head>
<body>
		
	<!-- 主体 -->
	<div id="main_title"><a href="javascript:loadUsers();">用户管理</a> > <a style="text-decoration: none;">用户修改</a></div>
	
	<div class="tab_header">
		<span>用户修改</span>
	</div>
	<div class="tab_content">
		<form id="user_form">
			<div>
				<span>权限：</span>
				<select id="power">
					<option value ="1" selected="selected">请选择</option>
					<option value ="2">版主</option>
				  	<option value ="3">普通用户</option>
				</select>
			</div>
			<div>
				<span>用户名：&nbsp;&nbsp;</span>
				<input id="userName" type="text" />
			</div>
			<div>
				<span>密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<input id="userPassword" type="password" />
			</div>
			<div>
				<span>确认密码：</span>
				<input id="rePassword" type="password" />
			</div>
			<div>
				<input id="editBtn" type="button" value="提交" />
				<input type="reset" value="重置" />
			</div>
		</form>
	</div>
			
</body>
<script type="text/javascript" src="<%=basePath%>pc/js/users_edit.js"></script>
</html>
