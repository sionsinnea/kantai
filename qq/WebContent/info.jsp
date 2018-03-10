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
  <link rel="stylesheet" href="<%=realPath%>layui/css/layui.css"  media="all">
</head>
<body>
          
<blockquote class="layui-elem-quote layui-text">
个人资料修改
</blockquote>
              
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>滑稽</legend>
</fieldset>
 
<input type="hidden" id="checksex" value="<%=session.getAttribute("sex")%>"> 
 
<form class="layui-form" action="<%=realPath %>ShowUser">
<input id="pic" type="hidden" name="pic" >
 <input type="hidden" name="id" value="<%=session.getAttribute("userid")%>">
<div class="layui-row">
    <div class="layui-col-xs12 layui-col-md8">
     <div class="grid-demo grid-demo-bg1">
    <div class="layui-form-item">
    <label class="layui-form-label">账号</label>
    <div class="layui-input-inline">
      <input name="userName" lay-verify="required" autocomplete="off" placeholder="请输入账号" class="layui-input" type="text" value="<%=session.getAttribute("username")%>">
    </div>
  </div>
    
		
		
		 <div class="layui-form-item">
    <label class="layui-form-label">密码</label>
    <div class="layui-input-inline">
      <input name="password" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input" type="text" value="<%=session.getAttribute("password")%>">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-inline">
      <input id="name" name="name" lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input" type="text" value="<%=session.getAttribute("name")%>">
    </div>
  </div>
  
		
	  <div class="layui-form-item">
    <label class="layui-form-label">年龄</label>
    <div class="layui-input-inline">
      <input name="age" lay-verify="" autocomplete="off" placeholder="请输入年龄" class="layui-input" type="text" value="<%=session.getAttribute("age")%>">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">手机</label>
    <div class="layui-input-inline">
      <input name="phone" lay-verify="phone" placeholder="请输入手机" autocomplete="off" class="layui-input" type="text" value="<%=session.getAttribute("phone")%>">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <input name="sex" value="男" title="男"  type="radio">
      <input name="sex" value="女" title="女" type="radio">
      <input name="sex" value="秀吉" title="秀吉" disabled="" checked="" type="radio">
    </div>
  </div>
  
<div class="layui-form-item">
    <label class="layui-form-label">地址</label>
    <div class="layui-input-block">
      <input name="address" lay-verify="" autocomplete="off" placeholder="请输入地址" class="layui-input" type="text" value="<%=session.getAttribute("address")%>">
    </div>
  </div>
	
		
	</div>	
    </div>
    <!-- 栅格左结束-->
    <div class="layui-col-xs6 layui-col-md4">
      <div class="grid-demo">
	
		<div class="layui-upload layui-input-block">
  <button type="button" class="layui-btn" id="test1">上传头像</button>
  <div class="layui-upload-list">
    <img class="layui-upload-img" id="demo1" src="<%=realPath+session.getAttribute("pic")%>" style="height:150px;width:auto;">
    <p id="demoText"></p>
  </div>
</div>   

		
		</div>
    </div>
    <div class="layui-col-xs6 layui-col-md12">
      <div class="grid-demo grid-demo-bg2"></div>
    </div>
  </div>
  
 

  
  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="update" lay-filter="demo1" >立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
 

  

<script src="<%=realPath%>layui/layui.js" charset="utf-8"></script>
<script>
layui.use('upload', function(){
  var $ = layui.jquery
  ,upload = layui.upload;
	
  //普通图片上传
  var uploadInst = upload.render({
    elem: '#test1'
    ,url: '<%=realPath%>UploadServlet'
    ,exts: 'jpg'
    ,before: function(obj){
      //预读本地文件示例，不支持ie8
      obj.preview(function(index, file, result){
        $('#demo1').attr('src', result); //图片链接（base64）
      });
    }
    ,done: function(res){
      //如果上传失败
      if(res.code > 0){
        return layer.msg('上传失败');
      }
      //上传成功
     $('#pic').val(res+".jpg");
    }
    ,error: function(){
      //演示失败状态，并实现重传
      var demoText = $('#demoText');
      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
      demoText.find('.demo-reload').on('click', function(){
        uploadInst.upload();
      });
    }
  });
  return false;
});
</script>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  //日期
  laydate.render({
    elem: '#date'
  });
  laydate.render({
    elem: '#date1'
  });
  
  //创建一个编辑器
  var editIndex = layedit.build('LAY_demo_editor');
  
  //读取性别
  var checksex = $("#checksex").val();
  if(checksex == '男'){
		$("input[name='sex']").eq(2).removeAttr("checked");
	     $("input[name='sex']").eq(0).click();
	}else if(checksex == '女'){
		$("input[name='sex']").eq(2).removeAttr("checked");
	      $("input[name='sex']").eq(1).click();
	}
  form.render('radio');
 
 
 
 
  //自定义验证规则
  form.verify({
    title: function(value){
      if(value.length < 5){
        return '标题至少得5个字符啊';
      }
    }
    ,pass: [/(.+){6,12}$/, '密码必须6到12位']
    ,content: function(value){
      layedit.sync(editIndex);
    }
  });
  
  //监听指定开关
  form.on('switch(switchTest)', function(data){
    layer.msg('开关checked：'+ (this.checked ? 'use' : 'unuse'), {
      offset: '6px'
    });
    layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
  });
  
//监听提交

	form.on('submit(demo1)', function(data){
		
		$.post("<%=realPath %>ShowUser",data.field,function(data){
			if(data){
				layer.msg("修改成功", {time: 2000});
				 var ispic = $('#mypic', parent.document);
				 var picpath = $("#demo1").attr("src");
				 var myname = $('#name').val();
				 var oldname = $('#myname',parent.document);
				 oldname.text(myname);
				ispic.attr('src',picpath);
				}else{
				layer.msg("修改失败", {time: 2000});
			}
		},'json');
		return false;
	});
  
  
});
</script>
<script type="text/javascript">
layui.use(["code"],function(){
	$=layui.jquery;  
	
	if(<%=session.getAttribute("sex")%> == '男'){
		
 		$("input[name='sex']").eq(2).removeAttr("checked");
 	     $("input[name='sex']").eq(0).click();
 	}else if(<%=session.getAttribute("sex")%> == '女'){
 		$("input[name='sex']").eq(2).removeAttr("checked");
	      $("input[name='sex']").eq(1).click();
 	}

});
</script>
</body>
</html>