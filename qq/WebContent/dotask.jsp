<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String path = request.getContextPath();%>
     <% String realPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>进行中任务</title>
  <link rel="stylesheet" href="<%=realPath %>layui/css/layui.css" media="all">
  <style>
    body{margin: 10px;}
    .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
  </style>
</head>
<body>




				
			
			<table class="layui-hide" id="test" lay-filter="demo"></table>
 
   <script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs layui-btn-normal"   lay-event="done"><i class="layui-icon">&#xe616;</i></a>

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
				    ,url: '<%=realPath%>ListMyTask'
				    ,page: true //开启分页
				    ,cols: [[ //表头
				       {field: 'taskingNo', title: '课题-任务编号', fixed: 'left',width:200}
				      ,{field: 'name', title: '任务名称',width:200}
				      ,{field: 'detail', title: '任务详细',width:350}
				      ,{field: 'level', title: '任务等级',width:100}
				      ,{field: 'createtime', title: '创建时间',width:200}
				      ,{field: 'taskId', title: '课题编号',width:200}
				      ,{title:'操作', align:'center', toolbar: '#barDemo',fixed:'right',width:120}
				      
				    ]]
				      ,done:function(){
				
					     	 $('table').children('thead').children('tr:first-child').find("th:eq(5)").hide();
					    	 $('table').children('tbody').children('tr').find("td:eq(5)").hide();  
				      }
				      ,text:{
				    		    none: '这里什么都没有' 
				    		  }
				  });
				  
				  //监听工具条
				  table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
				    var data = obj.data //获得当前行数据
				    ,layEvent = obj.event; //获得 lay-event 对应的值
				    
				 if(layEvent === 'done'){
				    	var array = data.taskingNo.split("-");
				    	
			 			$.get("<%=realPath %>DoneTask?taskLogId="+array[1]+'&taskId='+data.taskId,null,function(data){
							
							if(data == true){
								parent.layer.msg("任务完成", {time: 2000});
								location.reload();
								}else if(data == 0){
									parent.layer.msg("本课题已完成", {time: 2000});
									location.reload();
								}else{
								parent.layer.msg("出现异常", {time: 2000});
								layer.close(index);
							}
						},'json');	 
				    	
 
				    }
				  });
	
					  

});
</script>
</body>
</html>        