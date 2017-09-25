var registerForm;  //注册表单
var registerBtn;  //注册按钮

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
	//初始化注册表单
	registerForm = $("#registerForm");
	//初始化注册按钮
	registerBtn = $("#registerBtn");
}
/**
 * 设置监听事件
 */
function setList(){
	//设置注册按钮点击事件
	setRegisterBtnClick();
}

/**
 * 设置注册按钮点击事件
 */
function setRegisterBtnClick(){
	registerBtn.click(function(){
		var userPassword = $("input[name='userPassword']").val();
		var rePassword = $("input[name='rePassword']").val();
		//校检是否存在null
		if(!validate($(":input"))) {
			return;
		}
		//判断二次输入密码是否一致
		if(userPassword == rePassword) {
			//提交表单
			registerForm.submit();
		} else {
			alert("二次输入密码不一致！");
		}
	});
}