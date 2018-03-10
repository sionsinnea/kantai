<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String path = request.getContextPath();%>
     <% String realPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
   <!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="<%=realPath %>assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=realPath %>assets/css/stylesheet.css" rel="stylesheet">
</head>
<body>
    <div id="particles-js"></div>

    <div class="content text-md-center">
        <div class="inner">
            <div class="timeblock">
                <h6 class="date"></h6>
                <h1 class="time"></h1>
                <h4 class="seconds">60s</h4>
            </div>
        </div>

    </div>

    <script src="<%=realPath %>assets/js/jquery-3.1.1.min.js"></script>
    <script src="<%=realPath %>assets/js/bootstrap.min.js"></script>
    <script src="<%=realPath %>assets/js/particles.min.js"></script>
    <script src="<%=realPath %>assets/js/app.js"></script>
</body>
</html>