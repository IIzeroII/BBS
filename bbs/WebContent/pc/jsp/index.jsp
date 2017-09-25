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
<link rel="stylesheet" type="text/css" href="pc/css/usersBox.css" />
</head>
<body>
	<!--编辑弹窗开始-->
    <div id="UsersBox">
        <div class="rows1">
            编辑<a href="javascript:void(0)" title="关闭窗口" class="close_btn" id="closeBtn">×</a>
        </div>
        <div class="rows">
            用户名: &nbsp;&nbsp;&nbsp;&nbsp;<span class="inputBox">
                <input type="text" class="txtName" value="${sessionScope.user.userName }" readonly="readonly"  />
            </span>
        </div>
        <div class="rows">
            密码: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="inputBox">
                <input id="password" type="password" class="txtPwd" placeholder="请输入密码" />
            </span>
        </div>
        <div class="rows">
            重复密码: <span class="inputBox">
                <input id="rePassword" type="password" class="txtPwd" placeholder="请再次输入密码" />
            </span>
        </div>
        <div class="rows">
            <a href="javascript: usersEdit(${sessionScope.user.userId });" id="usersEditBtn">提交</a>
        </div>
    </div>
    <!--编辑弹窗结束-->
	
	<div class="container">
		<!-- 头部 -->
		<div class="header">
			<span id="header_span1">BBS论坛</span>
			<span id="header_span2">
				欢迎
				<a id="userBtn" class="${sessionScope.user.status }" href="javascript:void(0)">${sessionScope.user.userName }</a>丨
				<a href="javascript:quit();">退出</a>
			</span>
			<ul>
				<!-- href="javascript:" 里的代码，他的作用域是全局的，所以写this，它不知道到底是那个元素 -->
				<li id="usersManage"><a href="javascript:loadUsers();">用户管理</a></li>
				<li id="sectionManage"><a href="javascript:loadSection();">论坛</a></li>
				<li id="reminderManage"><a href="javascript:loadReminder();">帮助</a></li>
			</ul>
		</div>
		
		<!-- 主体 -->
		<div class="main">
			
		</div>
		
		<!-- 尾部 -->
		<div class="footer">
			<span id="footer_span1">&copy;2017</span>
			<span id="footer_span2">版本&nbsp;2017V1.0</span>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=basePath%>pc/js/jQuery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>pc/js/global.js"></script>
<script type="text/javascript" src="<%=basePath%>pc/js/index.js"></script>
<script type="text/javascript" src="<%=basePath%>pc/js/usersBox.js"></script>
</html>
