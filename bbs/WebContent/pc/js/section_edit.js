var editBtn;  //提交按钮
//JSON.stringify(list)

$(function(){
	//初始化节点
	initDoms();
	//设置监听事件
	setList();
});
/**
 * 初始化节点
 */
function initDoms(){
	//初始化提交按钮
	editBtn = $("#editBtn");
}
/**
 * 设置监听事件
 */
function setList(){
	//搜索按钮点击事件
	setEditBtnClick();
}

/**
 * 编辑按钮点击事件
 */
function setEditBtnClick(){
	editBtn.click(function(){  //sectionId sectionName sectionRemarks topicCount userId status
		//校检是否存在null
		if(!validate($(":text"))) {
			return false;
		}
		
		var sectionId = $("#sectionName").attr("class");
		var sectionName = $("#sectionName").val();
		var sectionRemarks = $("#sectionRemarks").val(); 
		var topicCount = $("#topicCount").val(); 
		var userId = $("#userName").val(); 
		var status = 1;
		
		//初始化参数
		var url = "/editSection.action";
		var jsonData = {};
		var obj = {};
		obj["userId"] = userId;
		
		jsonData["sectionId"] = sectionId;
		jsonData["sectionName"] = sectionName;
		jsonData["sectionRemarks"] = sectionRemarks;
		jsonData["topicCount"] = topicCount;
		
		//序列化，将js对象转化为符合Json格式的字符串
		jsonData["user"] = JSON.stringify(obj);
		
		jsonData["status"] = status;
		/*$.each(jsonData, function(i,t){
			alert(t);
		});*/
		ajaxData(url, jsonData, function(data){
			//提示信息
			alert(data.msg);
			if(data.success) {  //修改成功
				loadSection();
			} 
		});
	});
}

