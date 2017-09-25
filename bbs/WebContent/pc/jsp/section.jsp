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
	<div id="main_title"><a href="javascript:loadSection()">所有版块</a></div>
	
	<div class="tab_header">
		<span>版块列表</span>
		<form method="post">
			<span>搜索版块</span>
			<input type="text" />
			<input id="searchBtn" type="button" value="search" />
		</form>
	</div>
	<div class="tab_content">
		<table>
			<thead>
				<tr>
					<th>版块名</th>
					<th>版块信息</th>
					<th>拥有帖子数</th>
					<th>版主名</th>
					<th id="operate">操作</th>
				</tr>
			</thead>
			<tbody id="tbody">
				
			</tbody>
		</table>
	</div>
			
</body>
<script type="text/javascript" src="<%=basePath%>pc/js/section.js"></script>
</html>
