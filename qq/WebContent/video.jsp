<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String path = request.getContextPath();%>
     <% String realPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
    <!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<title>H5播放器</title>
	</head>
	<body>
		<video width="98%" height="85%" autoplay controls="controls" >
			<source src="<%=realPath %>video/Kantai.mp4" type="video/mp4"></source>
			<span>当前浏览器不支持 video直接播放，点击这里下载视频：</span> <a href="<%=realPath %>video/Kantai.mp4">下载视频</a>
		</video>
	</body>
</html>
    