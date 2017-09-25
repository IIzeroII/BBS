//编辑弹窗
$(function ($) {
	//弹出
	$("#userBtn").on('click', function () {
		$("body").append("<div id='mask'></div>");
		$("#mask").addClass("mask").fadeIn("slow");
		$("#UsersBox").fadeIn("slow");
	});
	//按钮的透明度
	$("#usersEditBtn").hover(function () {
		$(this).stop().animate({
			opacity: '1'
		}, 600);
	}, function () {
		$(this).stop().animate({
			opacity: '0.8'
		}, 1000);
	});
	//关闭
	$(".close_btn").hover(function () { $(this).css({ color: 'black' }) }, function () { $(this).css({ color: '#999' }) }).on('click', function () {
		$("#UsersBox").fadeOut("fast");  //页面切换效果
		$("#mask").css({ display: 'none' });  //mask:蒙灰遮罩层
	});
});