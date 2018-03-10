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
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div class="layui-layout layui-layout-admin">
		
		<div class=" layui-anim layui-anim-scale" style="left: 0px">
			<div class="layui-container">
			
				<div class="layui-row">
					<div class="layui-col-xs12 layui-col-sm6 layui-col-md9" style="padding: 5px">
						
						<ul id="LAY_demo1" class="flow-default">
						</ul>
					</div>
					<div class="layui-col-xs12 layui-col-sm6 layui-col-md3" style="padding: 5px;">
						<blockquote style="margin-top: 10px; height: 300px" class="layui-elem-quote layui-text">
						 	<a href="https://image.baidu.com/search/index?tn=baiduimage&ct=201326592&lm=-1&cl=2&ie=gbk&word=%D5%DC%A1%E1%D1%A7&fr=ala&ala=1&alatpl=adress&pos=0&hs=2&xthttps=111111">学习使你快乐(勿点)哲♂学</a>
						 	  <div class="layui-form-item layui-form-text" style="margin-top:100px;">
      							<textarea id="textinfo" placeholder="请输入内容" class="layui-textarea" style="resize:none;height:150px;font-size:20px"></textarea>
  							  </div>
						</blockquote>
						<button style="margin-left:5px;" type="button" class="layui-btn layui-btn-small" id="add"><i class="layui-icon">&#xe608;</i>发表</button>
					</div>
					
				</div>
			</div>
		</div>
	 
		 	
	</div>
     
<script src="<%=realPath%>plugins/layui/layui.js" charset="utf-8"></script>

<script>
layui.use('flow', function(){
	var $ = layui.jquery; 
  var flow = layui.flow;
 
  flow.load({
    elem: '#LAY_demo1' //流加载容器
    ,done: function(page, next){ //执行下一页的回调
    	var lis = [];
      //模拟数据插入
   		
    	 //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
        $.get('<%=realPath%>ShowMessage?page='+page, 
        		function(res){
          //假设你的列表返回在data集合中
          layui.each(res.list, function(index, item){
        	  var str='<div><blockquote class="layui-elem-quote" style="margin-top: 10px;">'+item.name 

+"<font style='margin-left:30px;'>留言时间："+item.addtime 

+'</font></blockquote></div>';
				str+='<blockquote class="layui-elem-quote layui-quote-nm layui-text" style="font-size:16px;letter-spacing:2px;line-height:25px;word-wrap:break-word;">'+item.info 

+'</blockquote>';
				lis.push('<li>' + str + '</li>');
          }); 
          
          //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
          //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
          next(lis.join(''), page < res.pages);    
        },'json');
      }
    });
 
  $('#add').on('click', function() {
	  var textinfo = $("#textinfo").val();
	 
		$.get('<%=realPath%>AddMessage?textinfo='+textinfo, null, function(res) {
			if(res == true){
				parent.layer.msg("留言成功");
				var textinfo = $("#textinfo").val("");
				location.reload();
			}else{
				parent.layer.msg("留言失败");
			}
  			
		},'json');
  });
  	
  });
</script>

</body>
</html>