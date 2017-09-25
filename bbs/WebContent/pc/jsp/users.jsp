<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BBS论坛</title>
</head>
<body>
		
	<!-- 主体 -->
	<div id="main_title"><a href="javascript:loadUsers();">用户管理</a></div>
	
	<div class="tab_header">
		<span>用户列表</span>
		<form>
			<span>搜索</span>
			<input type="text" />
			<input id="searchBtn" type="button" value="search" />
		</form>
	</div>
	<div class="tab_content">
		<table>
			<thead>
				<tr>
					<th>用户ID</th>
					<th>用户名</th>
					<th>密码</th>
					<th>权限</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="tbody">
				
			</tbody>
		</table>
	</div>
		
</body>
<script type="text/javascript" src="<%=basePath%>pc/js/users.js"></script>
</html>
