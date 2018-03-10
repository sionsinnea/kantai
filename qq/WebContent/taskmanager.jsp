<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String path = request.getContextPath();%>
     <% String realPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <link rel="stylesheet" href="<%=realPath %>layui/css/layui.css" media="all">
  <style>
    body{margin: 10px;}
    .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
  </style>
</head>
<body>



 			<blockquote class="layui-elem-quote">
				
				<div class="demoTable">
				<a href="javascript:;" class="layui-btn layui-btn-small" id="addtask">
					<i class="layui-icon">&#xe608;</i> 新建课题
				</a>

				任务编号:
				  <div class="layui-inline">
				  <input class="layui-input" name="id" id="demoReload" autocomplete="off" placeholder="(:3[▓▓]快醒醒开学了"  >
				  </div>
 					<a href="javascript:;" class="layui-btn layui-btn-small" data-type="reload">
					<i class="layui-icon">&#xe615;</i> 搜索
				</a>
				</div>
				
			</blockquote>
			<table class="layui-hide" id="test" lay-filter="demo"></table>
 
   <script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail"><i class="layui-icon">&#xe60a;</i></a>
  <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="add"><i class="layui-icon">&#xe654;</i></a>
  <a class="layui-btn layui-btn-xs" lay-event="edit"><i class="layui-icon">&#xe642;</i></a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i></a>
</script>
               
   


  
<script src="<%=realPath %>layui/layui.js"></script>
<script>
layui.config({
  version: '1515376178709' 
});
 
layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element','form'], function(){
	
					var $ = layui.jquery
				  ,laypage = layui.laypage //分页
				  ,layer = layui.layer //弹层
				  ,form = layui.form
				  ,layerTips = parent.layer === undefined ? layui.layer : parent.layer //获取父窗口的layer对象
				  ,table = layui.table //表格
				  ,element = layui.element; //元素操作
				  
				  layer.msg('開始你的表演');
				  
				  //监听Tab切换
				  element.on('tab(demo)', function(data){
				    layer.msg('切换了：'+ this.innerHTML);
				    console.log(data);
				  });
				  
				  //执行一个 table 实例
				  table.render({
				    elem: '#test'
				//  ,height: 450
				    ,url: '<%=realPath%>ListTask' 
				    ,page: true //开启分页
				    ,cols: [[ //表头
				       {field: 'taskno', title: '课题编号', fixed: 'left',width:150}
				      ,{field: 'name', title: '课题名称',width:150}
				      ,{field: 'detail', title: '课题详细',width:350}
				      ,{field: 'deptName', title: '执行部门',width:150} 
				      ,{field: 'createtime', title: '创建时间',width:200}
				      ,{field: 'status', title: '状态',width:100	}
				      ,{field: 'deptId', title: '部门id'}
				      ,{field: 'taskId', title: '任务id'}
				      ,{title:'操作', align:'center', toolbar: '#barDemo',fixed:'right',width:200}
				      
				    ]]
				      ,id:"taskId"
				     ,text:{
				    		    none: '这里什么都没有' 
				    		  }
				     , done: function(){
				    	 
				     	 $('table').children('thead').children('tr:first-child').find("th:eq(7)").hide();
				    	 $('table').children('tbody').children('tr').find("td:eq(7)").hide();
				    	 $('table').children('thead').children('tr:first-child').find("th:eq(6)").hide();
				    	 $('table').children('tbody').children('tr').find("td:eq(6)").hide(); 
				     	 $('table').children('tbody').children('tr').each(function (){
				    		 if($(this).children("td:eq(5)").text() == "0"){
				    		  	 $(this).children("td:eq(5)").children('div').html("任务已创建") 
				    		  	 
				    		 }else if($(this).children("td:eq(5)").text() == "10"){
				    			 $(this).children("td:eq(5)").children('div').html("任务进行中") 
				    			 
				    		 }else if($(this).children("td:eq(5)").text() == "20"){
				    			 $(this).children("td:eq(5)").children('div').html("任务已完成") 
				    			 
				    		 }else{
				    			 $(this).children("td:eq(5)").children('div').html("任务异常") 
				    		 }
				    			 
				    			
				    		 
				    	 }); 
				    	 
				    	  }
				     
				  });
				  
				  //监听工具条
				  table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
				    var data = obj.data //获得当前行数据
				    ,layEvent = obj.event; //获得 lay-event 对应的值
				    
				    if(layEvent === 'detail'){
				    	if(data.status < 20){
				    	 window.location.href='<%=realPath %>tasklog.jsp?taskId='+data.taskId; 
				    	}else{
				    		layer.alert('此任务已完成', {
				    			  icon: 2,
				    			  skin: 'layer-ext-moon' 
				    			})
				    	}
				     
				    } else if(layEvent === 'del'){
				      layer.confirm('删除此课题？', function(index){
				    	   
						    	if(data.status < 10){
						    	      //向服务端发送删除指令
						            $.get("<%=realPath %>DelTask?taskId="+index,null,function(data){
										
										if(data == true){
											parent.layer.msg("课题已删除", {time: 2000});
											location.reload();
											}else{
											parent.layer.msg("删除失败", {time: 2000});
										}
									},'json'); 
						    	}else{
						    		layer.alert('此任务进行中或已完成不可删除', {
						    			  icon: 2,
						    			  skin: 'layer-ext-moon' 
						    			})
						    	}
				       
				  
				      });
				    } else if(layEvent === 'edit'){
				    	//编辑
				    	
				    	if(data.status == 0){
					    	if(addBoxIndex !== -1)
								return;
							 $.get('<%=realPath%>temp/edittask.jsp', null, function(form) { 
								addBoxIndex = layer.open({
									type: 1,
									title: '编辑课题',
									content: form,//
									btn: ['保存', '取消'],
									shade: false,
									offset: ['100px', '30%'],
									area: ['600px', '500px'],
									zIndex: 19950924,
									maxmin: true,
									yes: function(index) {
										//触发表单的提交事件
										$('form.layui-form').find('button[lay-filter=edit]').click();
									},
									full: function(elem) {
										var win = window.top === window.self ? window : parent.window;
										$(win).on('resize', function() {
											var $this = $(this);
											elem.width($this.width()).height($this.height()).css({
												top: 0,
												left: 0
											});
											elem.children('div.layui-layer-content').height($this.height() - 95);
										});
									},
									success: function(layero, index) {
										//弹出窗口成功后渲染表单
										var form = layui.form
										form.render();
	        							$(document).ready(function(){
											$("#taskId").val(data.taskId);
											$("#taskno").val(data.taskno);
											$("#name").val(data.name);
											$("#detail").val(data.detail);
											$("#dept option[value="+data.deptId+"]").attr('selected', true);
											form.render(); 
										
								});
										form.on('submit(edit)', function(data) {
											
											$.post("<%=realPath %>UpdTask",data.field,function(data){
												
											if(data == true){
												parent.layer.msg("修改成功", {time: 2000});
												location.reload();
												}else{
												parent.layer.msg("修改失败编号重复", {time: 2000});
												layer.close(index);
											}
										},'json');
											return false; 									
										});
										//console.log(layero, index);
									},
									end: function() {
										addBoxIndex = -1;
									}
								});
							});
				    	}else{
				    		//询问框
				    		layer.confirm('已经有人开始做任务了你知道吗？', {
				    		  btn: ['知道','不知道'] //按钮
				    		}, function(){
				    		  layer.msg('要改需求请联系系统管理员', {icon: 1});
				    		}, function(){
				    		  layer.msg('现在知道了吧', {
				    		    time: 20000, //20s后自动关闭
				    		    btn: ['明白了', '知道了']
				    		  });
				    		});
				    	}
 
				    }else if(layEvent === 'add'){
				    	//新增小任务
				    	if(data.status < 20){
					    	if(addBoxIndex !== -1)
								return;
							 $.get('<%=realPath%>temp/addtasklog.jsp', null, function(form) { 
								addBoxIndex = layer.open({
									type: 1,
									title: '创建子任务',
									content: form,//
									btn: ['保存', '取消'],
									shade: false,
									offset: ['100px', '30%'],
									area: ['600px', '450px'],
									zIndex: 19950924,
									maxmin: true,
									yes: function(index) {
										//触发表单的提交事件
										$('form.layui-form').find('button[lay-filter=add]').click();
									},
									full: function(elem) {
										var win = window.top === window.self ? window : parent.window;
										$(win).on('resize', function() {
											var $this = $(this);
											elem.width($this.width()).height($this.height()).css({
												top: 0,
												left: 0
											});
											elem.children('div.layui-layer-content').height($this.height() - 95);
										});
									},
									success: function(layero, index) {
										//弹出窗口成功后渲染表单
										var form = layui.form
										form.render();
	        							$(document).ready(function(){
											$("#taskId").val(data.taskId);
										
								});
										form.on('submit(add)', function(data) {
											
											$.post("<%=realPath %>CreatTaskLog",data.field,function(data){
												
											if(data == true){
												parent.layer.msg("新增成功", {time: 2000});
												layer.close(index);
												}else{
												parent.layer.msg("新增失败", {time: 2000});
												layer.close(index);
											}
										},'json');
											return false; 									
										});
										//console.log(layero, index);
									},
									end: function() {
										addBoxIndex = -1;
									}
								});
							}); 
					    	}else{
					    		layer.alert('此任务已完成，不可新增', {
					    			  icon: 2,
					    			  skin: 'layer-ext-moon' 
					    			})
					    	}

				    }
				  });
  
  				//重载
				   var $ = layui.$, active = {
						    reload: function(){
						      var demoReload = $('#demoReload');
						      
						      //执行重载
						      table.reload('taskId', {
						        page: {
						          curr: 1 //重新从第 1 页开始
						        }
						        ,where: {
						        
						            taskno: demoReload.val()
						          
						        }
						      });
						    }
						  };
						  
						  $('.demoTable .layui-btn').on('click', function(){
						    var type = $(this).data('type');
						    active[type] ? active[type].call(this) : '';
						  }); 
  
				
  
  
  
					//新增課題監聽
						var addBoxIndex = -1;
						$('#addtask').on('click', function() {
							if(addBoxIndex !== -1)
								return;
							 $.get('<%=realPath%>temp/addtask.jsp', null, function(form) { 
								addBoxIndex = layer.open({
									type: 1,
									title: '新增课题',
									content: form,//
									btn: ['保存', '取消'],
									shade: false,
									offset: ['100px', '30%'],
									area: ['600px', '500px'],
									zIndex: 19950924,
									maxmin: true,
									yes: function(index) {
										//触发表单的提交事件
										$('form.layui-form').find('button[lay-filter=edit]').click();
									},
									full: function(elem) {
										var win = window.top === window.self ? window : parent.window;
										$(win).on('resize', function() {
											var $this = $(this);
											elem.width($this.width()).height($this.height()).css({
												top: 0,
												left: 0
											});
											elem.children('div.layui-layer-content').height($this.height() - 95);
										});
									},
									success: function(layero, index) {
										//弹出窗口成功后渲染表单
										var form = layui.form
										form.render();
										form.on('submit(edit)', function(data) {
											
											$.post("<%=realPath %>CreatTask",data.field,function(data){
												
											if(data == true){
												parent.layer.msg("新增成功", {time: 2000});
												location.reload();
												}else{
												parent.layer.msg("新增失败编号重复", {time: 2000});
											}
										},'json');
											return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。									
										});
										//console.log(layero, index);
									},
									end: function() {
										addBoxIndex = -1;
									}
								});
							}); 
						});
					  

});
</script>
</body>
</html>        