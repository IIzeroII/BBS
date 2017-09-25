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
	<div id="main_title"><a href="javascript:loadSection();">所有版块</a> > <a id="sectionName" href="javascript:loadT();" style="text-decoration: none;"></a></div>
	
	<div class="tab_header">
		<span>帖子列表</span>
		<form method="post">
			<span>帖子搜索</span>
			<input type="text" />
			<input id="searchBtn" type="button" value="search" />
		</form>
	</div>
	<div class="tab_content">
		<table>
			<thead>
				<tr id="topic_operate">
					<th>帖子名</th>
					<th>发帖人</th>
					<th>发帖时间</th>
					<th>回帖数</th>
					<th id="operate">操作</th>
				</tr>
			</thead>
			<tbody id="tbody">
				
			</tbody>
		</table>
	</div>
	<div class="tab_header">
		<span>发表新帖</span>
	</div>
	<div class="tab_content">
		<form>
			<div class="note_head">
				<span id="note_head_span1">帖子名</span>
				<span id="note_head_span2">最多输入40个字符</span>
				<br />
				<input id="topicTitle" type="text" maxlength="40" />
			</div>
			<div class="note_content">
				<span id="note_content_span1">内容</span>
				<span id="note_content_span2">最多输入200个字符</span>
				<textarea id="topicContent" maxlength="200"></textarea>
			</div>
			<div class="note_footer">
				<input id="note_footer_input1" type="button" value="提交"/>
				<input id="note_footer_input2" type="reset" value="重置" />
			</div>
		</form>
	</div>
			
</body>
<script type="text/javascript" src="<%=basePath%>pc/js/topic.js"></script>
</html>
