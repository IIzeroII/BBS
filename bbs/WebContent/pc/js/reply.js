var searchBtn;  //搜索按钮
var tbody;  //主体内容
var addBtn;  //提交按钮
var replyContent;  //主贴内容

var sectionId;  //版块ID
var sectionName;  //版块名
var sUserName;  //版主名
var topicId;  //主题帖ID
var topicTitle;  //主题帖标题
var topicContent;  //主题帖内容
var tUserName;  //主题帖创建人
var post_time;  //主题帖发帖时间

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
	//初始化回帖内容
	replyContent = $("#replyContent");
	
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
		var url = "/searchReply.action";
		var jsonData = {};
		var obj = {};
		obj["topicId"] = topicId;
		jsonData["key"] = key;
		//将obj序列化为符合JSON格式的字符串
		jsonData["topic"] = JSON.stringify(obj);
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
		if(!validate($(".tab_content textarea"))) {
			return false;
		}
		//初始化参数
		var url = "/addReply.action";
		var jsonData = {};
		var obj = {};
		obj["topicId"] = topicId;
		jsonData["replyContent"] = $("#replyContent").val();
		//序列化为JSON格式的字符串
		jsonData["topic"] = JSON.stringify(obj);
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
	var url = "/listReply.action";
	var jsonData = {};
	jsonData["topicId"] = topicId;
	//发送请求
	search(url, jsonData);
}

/**
 * 删除
 */
function del(index){
	//获取回帖ID
	var replyId = $("#reply"+index).attr("class");
	
	//初始化参数
	var jsonData = {};
	var url = "/delReply.action";
	jsonData["replyId"] = replyId;
	//发送请求
	ajaxData(url, jsonData, function(data){
		alert(data.msg);
		var i = index;
		if(data.success) {  //删除成功
			$("#reply"+index).nextAll("[id^='reply']").each(function(){
				$(this).find("span").text(++i);
			});
			$("#reply"+index).next().remove();
			$("#reply"+index).remove();
			
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
				
				str += "<tr id='reply"+index+"' class='"+item.replyId+"'>";
				str += "<th><span>"+(index+1)+"</span>楼: "+item.user.userName+"</th>";
				str += "<th>发帖时间："+item.reply_time+"</th>";
				
				//判断用户权限  管理员 版主 主题帖创建者 回帖本人
				if(status == 1 || uName == sUserName || uName == tUserName || uName == item.user.userName) {
					flag = 1;
					str += "<th><a href='javascript:del("+index+");'>删除</a></th>";
				}
				
				str += "</tr>";
				str += "<tr style='text-align:left;'>";
				str += "<td colspan='3'>"+item.replyContent+"</td>";
				str += "</tr>";
				
			});
			//移除操作栏目
			if(flag == 0) {
				$("#operate").remove();
			} else if($("#operate").text() == "") {
				 $("#reply_operate").append("<th id='operate'>操作</th>");
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
	loadTopic(sectionId, sectionName, sUserName);
}
/**
 * 调用全局方法 加载回帖页面
 */
function loadR(){
	loadReply(sectionId, sectionName, sUserName, topicId, topicTitle, topicContent, tUserName, post_time);
}
