var main;
var userBtn;
var usersManage;
var sectionManage;
var reminderManage;

var status;
var uName;

$(function(){
	//初始化节点
	initDoms();
	//加载主页面
	myload();
	//设置监听事件
	setList();
});
/**
 * 初始化节点
 */
function initDoms(){
	//初始化main
	main = $(".main");
	//初始化userBtn
	userBtn = $("#userBtn");
	//全局用户名
	uName = userBtn.text();
	//初始化用户状态
	status = userBtn.attr("class");
	//初始化用户管理
	usersManage = $("#usersManage");
	//初始化版块管理
	sectionManage = $("#sectionManage");
	//初始化帮助页面管理
	reminderManage = $("#reminderManage");
}
/**
 * 设置监听事件
 */
function setList(){
	
}

/**
 * 加载主页面
 */
function myload(){
	//判断当前用户状态
	if(status == 1) {
		loadUsers();
	} else {
		loadSection();
		//去除用户管理模块
		usersManage.remove();
	}
}
/**
 * 加载帮助页面
 */
function loadReminder(){
	//背景色改变
	reminderManage.parent().children().css("background","#FFF2C6");
	//加载主体内容
	reminderManage.css("background","#F0CA4B");
	load(main, "/pc/jsp/reminder.jsp");
}
/**
 * 加载用户管理内容
 */
function loadUsers(){
	//背景色改变
	usersManage.parent().children().css("background","#FFF2C6");
	usersManage.css("background","#F0CA4B");
	//加载主体内容
	load(main, "/pc/jsp/users.jsp");
}
/**
 * 加载版块管理内容
 */
function loadSection(){
	//背景色改变
	sectionManage.parent().children().css("background","#FFF2C6");
	sectionManage.css("background","#F0CA4B");
	//加载主体内容
	load(main, "/pc/jsp/section.jsp");
}

/**
 * 加载主题帖页面
 * @param sId  版块ID
 * @param sName  版块名
 * @param uName  版主名
 */
function loadTopic(sId, sName, uName){
	load(main, "/pc/jsp/topic.jsp", function(){
		//设置全局属性
		sectionId = sId;  //版块ID
		sectionName = sName;  //版块名
		userName = uName;  //版主名
		//设置导航栏版块名
		$("#sectionName").text(sectionName);
	});
}

/**
 * 加载回帖页面
 *@param sId  //版块ID
 *@param sName  //版块名
 *@param sUName  //版主名
 *@param tId  //主题帖ID
 *@param tTitle  //主题帖标题
 *@param tContent  //主题帖内容
 *@param tUName  //主题帖创建人
 *@param p_time  //主题帖发帖时间
 */
function loadReply(sId, sName, sUName, tId, tTitle, tContent, tUName, p_time){
	load(main, "/pc/jsp/reply.jsp", function(){
		//设置全局属性  sectionId, sectionName, sUserName, topicId, topicTitle, topicContent, tUserName, post_time
		sectionId = sId;  //版块ID
		sectionName = sName;  //版块名
		sUserName = sUName;  //版主名
		topicId = tId;  //主题帖ID
		topicTitle = tTitle;  //主题帖标题
		topicContent = tContent;  //主题帖内容
		tUserName = tUName;  //主题帖创建人
		post_time = p_time;  //主题帖发帖时间
		
		//设置导航栏版块名
		$("#sectionName").text(sectionName);
		//设置导航栏主题帖内容
		$("#topicTitle").text(topicTitle);
		//设置主题帖创建用户名
		$("#userName").text("楼主："+tUserName);
		//设置主题帖创建时间
		$("#post_time").text("发帖时间："+post_time);
		//设置主题帖内容
		$("#topicContent").text(topicContent);
		
		
	});
}


/**
 * 退出
 */
function quit(){
	//初始化参数
	var url = "/quitUsers.action";
	var jsonData = {};
	ajaxData(url, jsonData, function(data){
		alert(data.msg);
		if(data.success) {
			//跳回根目录
			window.location.href = getRootPath()+"/";
		}
	});
}

/**
 * 用户信息编辑 非管理员只能修改密码
 * @param id 用户ID
 */
function usersEdit(id){
	//获取用户信息
	var userId = id;
	var userName = uName;
	var userPassword = $("#password").val();
	var rePassword = $("#rePassword").val();
	
	//校检是否存在null
	if(!validate($("#UsersBox :input"))) {
		return;
	}
	//判断二次输入密码是否一致
	if(userPassword != rePassword) {
		alert("二次输入密码不一致！");
		return;
	} 
	
	//初始化参数
	var url = "/editUsers.action";
	var jsonData = {};
	jsonData["userId"] = userId;
	jsonData["userName"] = userName;
	jsonData["userPassword"] = userPassword;
	jsonData["status"] = status;
	/*$.each(jsonData, function(i,t){
		alert(t);
	});*/
	ajaxData(url, jsonData, function(data){
		$("#UsersBox").fadeOut("fast");  //页面切换效果
		$("#mask").css({ display: 'none' });  //mask:蒙灰遮罩层
		//提示信息
		alert(data.msg);
	});
}


