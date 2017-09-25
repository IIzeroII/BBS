<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BBS论坛</title>
<link rel="stylesheet" type="text/css" href="pc/css/index.css" />
</head>
<body>
		
	<div class="tab_content">
		<p>BBS是Bulletin Board System的缩写，即电子公告板。</p>
		<br/>
		<p>它是以文字为主的界面，为广大网友提供了一个彼此交流的空间。</p>
		<br/>
		<p>BBS与E－mail都是早期Internet最普遍的应用之一，至今仍然广泛使用。 </p>
		<br/>
		<p>BBS的每个用户都可以在上面书写，可发布信息或提出看法。大部分BBS由教育机构、研究机构或商业机构管理。像日常生活中的黑板报一样，电子公告牌按不同的主题分成很多个布告栏，布告栏的设立是以大多数BBS使用者的要求和喜好为依据的。 </p>
		<br/>
		<p>BBS站往往是由一些有志于此道的爱好者建立，对所有人都免费开放。而且，由于BBS的参与人众多，因此各方面的话题都不乏热心者。在这里，打破了交流的空间和时间限制，所有人都不用害怕暴露自己真实的社会身份，每个人都处于对等的位置，可以就任何问题进行讨论。</p>
		<br/>
		<p>BBS按照栏目不同，一般把发帖子最多的网友叫做斑竹（版主），也有一些BBS站点聘请专业的斑竹，斑竹具有相对意义上的管理权，可以删除论坛中发言。这样广大BBS网民往往会进行疯狂的灌水（留言）行为，争当斑竹（版主）。</p>
	</div>
			
</body>
</html>
