/**
 * 返回根目录
 * @returns
 */
function getRootPath() {
	var webProjectName = undefined;
	
	// 获取当前网址，如：http://localhost:8080/supermarket/user.do?method=query
	//var currentWwwPath = window.document.location.href;
	
	// 获取主机地址之后的目录，如：/supermarket/user.do(注意：不包括?后面传递的参数)
	var pathName = window.document.location.pathname;

	// 获取/supermarket中/的位置(也就是主机地址后面的/)，这里是：21
	//var position = currentWwwPath.indexOf(pathName);

	// 获取主机地址，如：http://localhost:8080
	//var localhostPath = currentWwwPath.substring(0, position);

	// 获取带"/"的项目名，如：/supermarket
	webProjectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);

	return webProjectName;
}
/**
 * 自定义ajax方法
 */
function ajaxData(url, jsonData, callfun, async) {
	//拼接url
	var ajaxUrl = getRootPath() + url;
	//是否为异步(默认异步)
	var ajaxAsync = true;
	if(async != undefined) {
		ajaxAsync = async;
	}
	//发送请求
	$.ajax({
		type : "POST",
		timeout: 5000, //超时设置，单位：毫秒
		url : ajaxUrl,
		async : ajaxAsync,
		dataType : "json",
		data : jsonData,
		//traditional: true,  //传数组时去掉键名尾随的[]
		success : function(data) {
			//访问成功，回调函数
			callfun(data);
		},
		error : function(data) {
			//访问失败
			alert("访问失败！");
		}
	});
}

/**
 * 遍历，判断是否输入为null
 * @param all
 * @returns {Boolean}
 */
function validate(all) {
	var flag = true;
	all.each(function(){
	 	if($(this).val().trim().length < 1) {
	 		alert("输入不能为空！");
	 	 	$(this).focus();
	 	 	flag = false;
	 	 	//$(this).after("<span id='reminder' style='color: red;'>输入不能为空!</span>");
	 	 	return false;
 	    }
 	});
	return flag;
 }

/**
 * 自定义load方法(加载页面)
 * 原生load方法可以附加参数，封装了$.ajax
 * 如果参数是对象（比如json），会使用post请求方式；
 * 如果没有参数或者参数不是对象（字符串或数值），则使用get请求方式。
 * load(url,data,function(response,status,xhr))
 * response - 包含来自请求的结果数据
 * status - 包含请求的状态（"success", "notmodified", "error", "timeout" 或 "parsererror"）
 * xhr - 包含 XMLHttpRequest 对象
 * @param obj 节点对象
 * @param url  资源地址     
 * @param data  传递数据 
 * @param callfun  回调函数
 */
function load(obj, url, data, callfun){
	//不缓存请求数据
	$.ajaxSetup({cache: false });
	//拼接url
	url = getRootPath() + url;
	obj.load(url, data, function(response,status,xhr){
		if(status == "success") {  //访问成功
			if(callfun) {  //调用传入的回调函数
				callfun(response, xhr);
			}
		} else {
			alert("访问失败！");
		}
	});
}

/**
 *.replace(/[\r\n]/g,"")  去掉回车换行
 *.replace(/-/g, '')  去掉"-"号
 *.replace(/(^\s+)|(\s+$)/g,"") or trim()  去掉前后空格
 *.replace(/\s/g,"")  去掉所有空格
 * @param str  字符串
 * @param g  去除所有空格
 * @param e  去除换行
 * @returns
 */
function Trim(str, g, e) {
	var result;
	//去除前后空格
    result = str.trim();
    //去除所有空格
    if(g.toLowerCase() == "g") {
        result = result.replace(/\s/g,"");
    }
    //去除换行
    if(e.toLowerCase() == "e") {
    	result = result.replace(/[\r\n]/g,"");
    }

    return result;
}

