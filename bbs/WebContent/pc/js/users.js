var searchBtn;  //搜索按钮
var tbody;  //主体内容


//JSON.stringify(list)
//on绑定点击事件:
/*$(".main").on("click", 'button', function(){
	alert("111");
	alert($("button").html());
});
//主动触发某个<li>的click事件
$("button").trigger("click");*/ 

/*$("body").on('change','.main',function () {
    alert("111");
});*/


$(function(){
	//初始化节点
	initDoms();
	//加载主体内容
	loadAll();
	//设置监听事件
	setList();
});
/**
 * 初始化节点
 */
function initDoms(){
	//初始化搜索按钮
	searchBtn = $("#searchBtn");
	//初始化主体内容
	tbody = $("#tbody");
}
/**
 * 设置监听事件
 */
function setList(){
	//搜索按钮点击事件
	setSearchBtnClick();
}

/**
 * 搜索按钮点击事件
 */
function setSearchBtnClick(){
	searchBtn.click(function(){
		//获取搜索关键字,去除所有空格和换行
		var key = Trim(searchBtn.prev().val(), "g", "e");
		//初始化参数
		var url = "/searchUsers.action";
		var jsonData = {};
		if(key == "版主") {
			key = 2;
		} else if(key == "普通用户") {
			key = 3;
		}
		jsonData["key"] = key;
		//发送请求
		search(url, jsonData);
	});
}

/**
 * 加载主体内容
 */
function loadAll(){ 
	var url = "/listUsers.action";
	var jsonData = {};
	//发送请求
	search(url, jsonData);
}

/**
 * 编辑
 */
function edit(index) {
	//获取用户信息
	var user = $("#user"+index);
	var userId = user.children(".userId").text();
	var userName = user.children(".userName").text();
	var userPassword = user.children(".userPassword").text();
	var power = user.children(".power").text();
	//加载编辑页面(异步加载,回调函数可以取得对象)
	load(main, "/pc/jsp/users_edit.jsp", function(){
		$("#userName").addClass(userId);
		$("#userName").val(userName);
		$("#userPassword").val(userPassword);
		//判断用户权限
		$("#power").children().each(function(){
			if($(this).text() == power) {
				$(this).attr("selected","selected");
			}
		});
	});
	
}

/**
 * 删除
 */
function del(index){
	//获取用户账号
	var userId = $("#user"+index).children(".userId").text();
	
	//初始化参数
	var jsonData = {};
	var url = "/delUsers.action";
	jsonData["userId"] = userId;
	
	//发送请求
	ajaxData(url, jsonData, function(data){
		alert(data.msg);
		if(data.success) {  //删除成功
			$("#user"+index).remove();
		} 
	});
}

/**
 * 搜索方法
 * @param url
 * @param jsonData
 */
function search(url, jsonData){
	ajaxData(url, jsonData, function(data){
		 //发送请求成功
		if(data.success) { //查询成功  
			var str = "";
			$.each(data.list, function(index, item){
				//根据状态判断用户权限
				var power;
				if(item.status == 2) {
					power = "版主";
				} else {
					power = "普通用户";
				}
				str += "<tr id='user"+index+"'>";
				str += "<td class='userId'>"+item.userId+"</td>";
				str += "<td class='userName'>"+item.userName+"</td>";
				str += "<td class='userPassword'>"+item.userPassword+"</td>";
				str += "<td class='power'>"+power+"</td>";
				str += "<td><a href='javascript:edit("+index+");' style='margin-right: 5%;'>修改</a><a href='javascript:del("+index+");'>删除</a></td>";
				str += "</tr>";
				
			});
			//添加内容
			tbody.children().remove();
			tbody.append(str);
		} else { //查询失败
			alert(data.msg);
		}
		
	});
}