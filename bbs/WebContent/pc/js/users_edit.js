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
	editBtn.click(function(){  //userName userPassword status userId
		//校检是否存在null
		if(!validate($(":input"))) {
			return false;
		}
		//判断权限是否选中
		if($("#power :selected").text() == "请选择") {
			alert("请选择权限！");
			$("#power").focus();
			return false;
		}
		
		var userId = $("#userName").attr("class");
		var userName = $("#userName").val();
		var userPassword = $("#userPassword").val();
		var rePassword = $("#rePassword").val();
		var status;
		//根据权限判断状态
		status = $("#power").val();
		//判断二次密码输入是否一致
		if(userPassword != rePassword) {
			alert("二次密码输入不一致！");
			return false;
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
			alert(data.msg);
			if(data.success) {  //修改成功
				loadUsers();
			} 
		});
	});
}

