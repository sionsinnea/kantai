<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="<%=path%>/plugins/layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

          
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>选完文件后不自动上传</legend>
</fieldset>
 
<div class="layui-upload">
  <button type="button" class="layui-btn layui-btn-normal" id="test8">选择文件</button>
  <button type="button" class="layui-btn" id="test9">开始上传</button>
</div>
<script src="<%=path%>/plugins/layui/layui.js"></script>
<script>
layui.use('upload', function(){
	  var $ = layui.jquery
	  ,upload = layui.upload;
   
	//选完文件后不自动上传
	  upload.render({
	    elem: '#test8'
	    ,url: '/upload/'
	    ,auto: false
	    //,multiple: true
	    ,bindAction: '#test9'
	    ,done: function(res){
	      console.log(res)
	    }
	  });
});
</script>
</body>
</html>