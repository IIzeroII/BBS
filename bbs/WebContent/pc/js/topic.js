var searchBtn;  //搜索按钮
var tbody;  //主体内容
var addBtn;  //提交按钮
var topicTitle; //主贴名
var topicContent;  //主贴内容

var sectionId;  //版块ID
var sectionName;  //版块名
var userName;  //版主名

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
	//初始化提交按钮
	addBtn = $("#note_footer_input1");
	//初始化主题帖名
	topicTitle = $("#topicTitle");
	//初始化主题帖内容
	topicContent = $("#topicContent");
	
}
/**
 * 设置监听事件
 */
function setList(){
	//搜索按钮点击事件
	setSearchBtnClick();
	//新增按钮点击事件
	setAddBtnClick();
}

/**
 * 搜索按钮点击事件
 */
function setSearchBtnClick(){
	searchBtn.click(function(){
		//获取搜索关键字,去除所有空格和换行
		var key = Trim(searchBtn.prev().val(), "g", "e");
		//初始化参数
		var url = "/searchTopic.action";
		var jsonData = {};
		var obj = {};
		obj["sectionId"] = sectionId;
		jsonData["key"] = key;
		//将obj序列化为符合JSON格式的字符串
		jsonData["section"] = JSON.stringify(obj);
		//发送请求
		search(url, jsonData);
	});
}

/**
 * 新增按钮点击事件
 */
function setAddBtnClick(){
	addBtn.click(function(){  
		//校检是否存在null
		if(!validate($(".tab_content :text,.tab_content textarea"))) {
			return false;
		}
		//初始化参数
		var url = "/addTopic.action";
		var jsonData = {};
		var obj = {};
		obj["sectionId"] = sectionId;
		jsonData["topicTitle"] = $("#topicTitle").val();
		jsonData["topicContent"] = $("#topicContent").val();
		//序列化为JSON格式的字符串
		jsonData["section"] = JSON.stringify(obj);
		ajaxData(url, jsonData, function(data){
			alert(data.msg);
			if(data.success) {  //新增成功
				//刷新列表
				loadAll();
			} 
		});
	});
}


/**
 * 加载主体内容
 */
function loadAll(){ 
	var url = "/listTopic.action";
	var jsonData = {};
	jsonData["sectionId"] = sectionId;
	//发送请求
	search(url, jsonData);
}

/**
 * 删除
 */
function del(index){
	//获取主题帖ID
	var topicId = $("#topic"+index).attr("class");
	
	//初始化参数
	var jsonData = {};
	var url = "/delTopic.action";
	jsonData["topicId"] = topicId;
	
	//发送请求
	ajaxData(url, jsonData, function(data){
		alert(data.msg);
		if(data.success) {  //删除成功
			$("#topic"+index).remove();
			
			//判断是否还存在操作选项
			var flag = 0;
			tbody.find("a").each(function(){
				if($(this).text() == "删除") {
					flag = 1;
				}
			});
			if(flag == 0) {  //移除操作栏
				$("#operate").remove();
			}
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
			var flag = 0;
			$.each(data.list, function(index, item){
				
				str += "<tr id='topic"+index+"' class='"+item.topicId+"'>";
				str += "<td class='topicTitle' id='"+item.topicContent+"'><a href='javascript:loadR("+index+");'>"+item.topicTitle+"</a></td>";
				str += "<td class='userName'>"+item.user.userName+"</td>";
				str += "<td class='post_time'>"+item.post_time+"</td>";
				str += "<td class='replyCount'>"+item.replyCount+"</td>";
				//判断用户权限  管理员 帖子创建者 该版版主
				if(status == 1 || uName == item.user.userName || uName == userName) {
					flag = 1;
					str += "<td><a href='javascript:del("+index+");'>删除</a></td>";
				}
				
				str += "</tr>";
				
			});
			//移除操作栏
			if(flag == 0) {
				$("#operate").remove();
			} else if($("#operate").text() == "") {
				 $("#topic_operate").append("<th id='operate'>操作</th>");
			}
			//添加内容
			tbody.children().remove();
			tbody.append(str);
		} else { //查询失败
			alert(data.msg);
		}
		
	});
}

/**
 * 调用全局方法 加载主题帖页面
 */
function loadT(){
	loadTopic(sectionId, sectionName, userName);
}

/**
 * 调用全局方法 加载回帖页面
 * @param index
 */
function loadR(index){
	//获取topicId、topicTitle、topicContent、userName、post_time
	var topicId = $("#topic"+index).attr("class");  
	var topicTitle = $("#topic"+index).children(".topicTitle").children().text();
	var topicContent = $("#topic"+index).children(".topicTitle").attr("id");
	var tUserName = $("#topic"+index).children(".userName").text();
	var post_time = $("#topic"+index).children(".post_time").text();
	loadReply(sectionId, sectionName, userName, topicId, topicTitle, topicContent, tUserName, post_time);
}
