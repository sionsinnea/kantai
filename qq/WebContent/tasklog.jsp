<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String path = request.getContextPath();%>
     <% String realPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
     <% int taskId = Integer.parseInt(request.getParameter("taskId")); %>
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
				<a href="javascript:;" class="layui-btn layui-btn-small" id="back">
					<i class="layui-icon">&#xe608;</i> 返回
				</a>
				<a href="javascript:;" class="layui-btn layui-btn-small layui-btn-normal" id="opentask">
					<i class="layui-icon">&#xe623;</i> 开始任务
				</a>
				</div>
				
			</blockquote>
			<table class="layui-hide" id="test" lay-filter="demo"></table>
 
   <script type="text/html" id="barDemo">
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
				  
				  var addBoxIndex = -1;
				  
				
				  
				  //执行一个 table 实例
				  table.render({
				    elem: '#test'
				//  ,height: 450
				    ,url: '<%=realPath%>ListTaskLog?taskId='+<%=taskId%> 
				    ,page: true //开启分页
				    ,cols: [[ //表头
				       {field: 'taskno', title: '课题编号', fixed: 'left',width:150}
				      ,{field: 'taskLogId', title: '任务编号',width:110}
				      ,{field: 'name', title: '任务名称',width:100}
				      ,{field: 'detail', title: '任务详细',width:350}
				      ,{field: 'level', title: '任务等级',width:100}
				      ,{field: 'createtime', title: '创建时间',width:200}
				      ,{field: 'status', title: '状态',width:100	}
				      ,{title:'操作', align:'center', toolbar: '#barDemo',fixed:'right',width:200}
				      
				    ]]
				      ,done:function(){
				    	
				    		 $('table').children('tbody').children('tr').each(function (){
				    			 
					    		 if($(this).children("td:eq(6)").text() == "0"){
					    		  	 $(this).children("td:eq(6)").children('div').html("未完成") 
					    		  	 
					    		 }else if($(this).children("td:eq(6)").text() == "20"){
					    			 $(this).children("td:eq(6)").children('div').html("已完成") 
					    			 
					    		 }else{
					    			 $(this).children("td:eq(6)").children('div').html("任务异常") 
					    		 }
					    			 
					    			
					    		 
					    	 });  
				      }
				      ,text:{
				    		    none: '这里什么都没有' 
				    		  }
				  });
				  
				  //监听工具条
				  table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
				    var data = obj.data //获得当前行数据
				    ,layEvent = obj.event; //获得 lay-event 对应的值
				    
				    if(layEvent === 'del'){
				      layer.confirm('删除子任务？', function(index){
				       
				        //向服务端发送删除指令
			             $.get("<%=realPath %>DelTaskLog?taskLogId="+data.taskLogId,null,function(data){
							
							if(data == true){
								parent.layer.msg("子任务已删除", {time: 2000});
								location.reload();
								}else{
								parent.layer.msg("删除失败", {time: 2000});
							}
						},'json'); 
				      });
				    } else if(layEvent === 'edit'){
				    	//编辑
				    	
				    
					    	if(addBoxIndex !== -1)
								return;
							 $.get('<%=realPath%>temp/edittasklog.jsp', null, function(form) { 
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
											$("#taskLogId").val(data.taskLogId);
											$("#name").val(data.name);
											$("#detail").val(data.detail);
											$("#level option[value="+data.level+"]").attr('selected', true);
											form.render(); 
										
								});
										form.on('submit(edit)', function(data) {
											
											$.post("<%=realPath %>UpdTaskLog",data.field,function(data){
												
											if(data == true){
												parent.layer.msg("修改成功", {time: 2000});
												location.reload();
												}else{
												parent.layer.msg("修改失败", {time: 2000});
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
				    	
 
				    }
				  });
					
				  		//返回
						$('#back').on('click', function() {
							history.go(-1);

						});
				  		//开始任务
						$('#opentask').on('click', function() {
							
							$.get("<%=realPath %>StartTask?taskId="+<%=taskId%>,null,function(data){
								
								if(data == true){
									parent.layer.msg("开启任务成功", {time: 2000});
									history.go(-1);
									}else{
									parent.layer.msg("开启任务失败", {time: 2000});
									layer.close(index);
								}
							},'json');	
						});
					  

});
</script>
</body>
</html>        