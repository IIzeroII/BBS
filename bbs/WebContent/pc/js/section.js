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
		var url = "/searchSection.action";
		var jsonData = {};
		jsonData["key"] = key;
		//发送请求
		search(url, jsonData);
	});
}

/**
 * 加载主体内容
 */
function loadAll(){ 
	var url = "/listSection.action";
	var jsonData = {};
	//发送请求
	search(url, jsonData);
}

/**
 * 编辑
 */
function edit(index) {
	//获取版块信息
	var section = $("#section"+index);
	var sectionId = section.attr("class");
	var sectionName = section.children(".sectionName").text();
	var sectionRemarks = section.children(".sectionRemarks").text();
	var topicCount = section.children(".topicCount").text();
	var userName = section.children(".userName").text();
	//加载编辑页面(异步加载,回调函数可以取得对象)
	load(main, "/pc/jsp/section_edit.jsp", function(){
		//编辑页面默认显示
		$("#sectionName").addClass(sectionId);
		$("#sectionName").val(sectionName);
		$("#sectionRemarks").val(sectionRemarks);
		$("#topicCount").val(topicCount);
		//初始化参数
		var url = "/findHighPowerUsers.action";
		var jsonData = {};
		//发送请求
		ajaxData(url, jsonData, function(data){
			if(data.success) {  //查询成功
				var str = "";
				$.each(data.list, function(index, item){
					if(userName == item.userName) {  //默认选中
						str += "<option value ='"+item.userId+"' selected='selected'>"+item.userName+"</option>";
					} else {
						str += "<option value ='"+item.userId+"'>"+item.userName+"</option>";
					}
				});
				//添加元素至下拉框
				$("#userName").append(str);
			}
		});
		
		
	});
	
}

/**
 * 删除
 */
function del(index){
	//获取用户账号
	var sectionId = $("#section"+index).attr("class");
	
	//初始化参数
	var jsonData = {};
	var url = "/delSection.action";
	jsonData["sectionId"] = sectionId;
	
	//发送请求
	ajaxData(url, jsonData, function(data){
		alert(data.msg);
		if(data.success) {  //删除成功
			$("#section"+index).remove();
			
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
				
				str += "<tr id='section"+index+"' class='"+item.sectionId+"'>";
				str += "<td class='sectionName'><a href='javascript:loadT("+index+");'>"+item.sectionName+"</a></td>";
				str += "<td class='sectionRemarks'>"+item.sectionRemarks+"</td>";
				str += "<td class='topicCount'>"+item.topicCount+"</td>";
				str += "<td class='userName'>"+item.user.userName+"</td>";
				//判断用户权限
				if(status == 1 || (status == 2 && uName == item.user.userName)) {
					flag = 1;
					str += "<td><a href='javascript:edit("+index+");' style='margin-right: 5%;'>修改</a><a href='javascript:del("+index+");'>删除</a></td>";
				} 
				
				str += "</tr>";
				
			});
			//移除操作
			if(flag == 0) {
				$("#operate").remove();
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
 * @param index
 */
function loadT(index){
	//获取sectionId、sectionName
	var sectionId = $("#section"+index).attr("class");
	var sectionName = $("#section"+index).children(".sectionName").children().text();
	var userName = $("#section"+index).children(".userName").text();
	loadTopic(sectionId, sectionName, userName);
}