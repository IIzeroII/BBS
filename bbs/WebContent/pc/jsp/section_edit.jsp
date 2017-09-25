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
	<div id="main_title"><a href="javascript:loadSection();">所有版块</a> > <a style="text-decoration: none;">版块修改</a></div>
	
	<div class="tab_header">
		<span>版块修改</span>
	</div>
	<div class="tab_content">
		<form id="user_form">
			<div>
				<span>版块名：</span>
				<input id="sectionName" type="text" />
			</div>
			<div>
				<span>版块信息：</span>
				<input id="sectionRemarks" type="text" />
			</div>
			<div>
				<span>拥有帖子数：</span>
				<input id="topicCount" type="text" readonly="readonly" />
			</div>
			<div>
				<span>版主：</span>
				<select id="userName">
					<option value ="0" selected="selected">请选择</option>
				</select>
			</div>
			<div>
				<input id="editBtn" type="button" value="提交" />
			</div>
		</form>
	</div>
			
</body>
<script type="text/javascript" src="<%=basePath%>pc/js/section_edit.js"></script>
</html>
