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
 
<script type="text/html" id="state">
<div class="layui-progress layui-progress-big" lay-showpercent="true">
  <div class="layui-progress-bar" lay-percent="{{d.process}}"></div>
</div>
</script>
               
   


  
<script src="<%=realPath %>layui/layui.js"></script>
<script>
layui.config({
  version: '1515376178709' 
});
 
layui.use(['laydate', 'laypage', 'layer', 'table', 'element'], function(){
	
					var $ = layui.jquery
				  ,laypage = layui.laypage //分页
				  ,layer = layui.layer //弹层
		
				  ,layerTips = parent.layer === undefined ? layui.layer : parent.layer //获取父窗口的layer对象
				  ,table = layui.table //表格
				  ,element = layui.element; //元素操作
				  
				
				  
				  //监听Tab切换
				  element.on('tab(demo)', function(data){
				    layer.msg('切换了：'+ this.innerHTML);
				    console.log(data);
				  });
				  
				  //执行一个 table 实例
				  table.render({
				    elem: '#test'
				//  ,height: 450
				    ,url: '<%=realPath%>ShowAllTask' 
				    ,page: true //开启分页
				    ,even: true
				    ,skin: 'line' 
				    ,size: 'lg'
				    ,cols: [[ //表头
				       {field: 'taskno', title: '课题编号', fixed: 'left', sort: true}
				      ,{field: 'name', title: '课题名称'}
				      ,{field: 'deptName', title: '执行部门'} 
				      ,{field: 'createtime', title: '创建时间', sort: true}
				      ,{field: 'overtime', title: '完成时间', sort: true}
				      ,{field: 'process', title: '进度', sort: true, align:'center', fixed: 'right',width:100,style:'background-color: #1BF199; color: #fff;'}
				
				    
				      
				    ]]
				      ,id:"taskId"
				     ,text:{
				    		    none: '这里什么都没有' 
				    		  }
				     , done: function(){
	
				    	 
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
  
				
  
  

					  

});
</script>
</body>
</html>        