<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String path = request.getContextPath();%>
    <% String realPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
	<%String name = request.getParameter("name");
		if(name == null){
			name = "";
		}
	 %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>btable</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="<%=realPath%>plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=realPath%>plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=realPath%>css/btable.css" />
</head>

<body style=" background-color: gainsboro;">

    <div style="margin:0px; background-color: white; margin:0 10px;">
        <blockquote class="layui-elem-quote">
            <button type="button" class="layui-btn layui-btn-small" > ㊣</button>
           <form class="layui-form" style="float:right;">
                    <div class="layui-form-item" style="margin:0;">
                        <label class="layui-form-label">姓名</label>
                        <div class="layui-input-inline">
                            <input type="text" id="name" name="name" placeholder="(:3[▓▓]快醒醒开学了" autocomplete="off" class="layui-input" value="<%=name%>">
                        </div>
                        <div class="layui-form-mid layui-word-aux" style="padding:0;">
                            <button lay-filter="search" class="layui-btn" lay-submit><i class="fa fa-search" aria-hidden="true"></i> 查询</button>
                        </div>
                    </div>
                </form>
        </blockquote>
        <div id="content" style="width: 100%;height: 533px;"></div>
    </div>
    <script type="text/javascript" src="<%=realPath%>plugins/layui/layui.js"></script>
    <script>
    
        layui.config({
            base: 'js/'
        }).use(['btable'], function () {
        	
            var btable = layui.btable(),
                $ = layui.jquery,
                layerTips = parent.layer === undefined ? layui.layer : parent.layer, //获取父窗口的layer对象
                layer = layui.layer; //获取当前窗口的layer对象;
                var name = $("#name").val();
            btable.set({
                openWait:true,
                elem: '#content',
                url: '<%=realPath%>ListUser',
                pageSize: 20,
                params: {
                    searchname:name
                    
                },
                columns: [{
                    fieldName: '姓名',
                    field: 'name'
                }, {
                    fieldName: '年龄',
                    field: 'age'
                }, {
                    fieldName: '手机',
                    field: 'phone'
                }, {
                    fieldName: '地址',
                    field: 'address'
                }, {
                    fieldName: '性别',
                    field: 'sex'
                }, {
                    fieldName: '部门',
                    field: 'deptName'
                }, {
                    fieldName: '职位',
                    field: 'degName'
                }],
                even: true,
                field: 'id', 
                //skin: 'row',
                checkbox: false,
                paged: true,
                singleSelect: false,
                onSuccess: function ($elem) {
                    $elem.children('tr').each(function () {
                        $(this).children('td:last-child').children('input').each(function () {
                            var $that = $(this);
                            var action = $that.data('action');
                            var id = $that.data('id');
                            $that.on('click', function () {
                                switch (action) {
                                    case 'edit':
                                        layerTips.msg(action + ":" + id);
                                        
                                        break;
                                    case 'del': //删除
                                        /* layerTips.msg(action + ":" + id); 
                                        var name = $that.parent('td').siblings('td[data-field=name]').text();
                                        /* layerTips.confirm('确定要删除[ <span style="color:red;">' + name + '</span> ] ？', { icon: 3, title: '系统提示' }, function (index) {
                                            $that.parent('td').parent('tr').remove(); 
                                            layerTips.msg('删除成功.');
                                        }); */
                                        $.get("<%=realPath %>DelUser?delid="+id,null,function(data){
        									
            								if(data == true){
            									parent.layer.msg("删除成功", {time: 2000});
            									location.reload();
            									}else{
            									parent.layer.msg("删除失败", {time: 2000});
            								}
            							},'json');
                                        break;
                                }
                            });
                        });
                    });
                }
            });
            btable.render();
            var addBoxIndex = -1;
			$('#add').on('click', function() {
				if(addBoxIndex !== -1)
					return;
				//本表单通过ajax加载 --以模板的形式，当然你也可以直接写在页面上读取
				$.get('<%=realPath%>temp/adduser.jsp', null, function(form) {
					addBoxIndex = layer.open({
						type: 1,
						title: '新增员工',
						content: form,
						btn: ['保存', '取消'],
						shade: false,
						offset: ['10px', '20%'],
						area: ['600px', '400px'],
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
							var form = layui.form();
							form.render();
							form.on('submit(edit)', function(data) {
								
								$.post("<%=realPath %>AddUser",data.field,function(data){
									
								if(data == true){
									parent.layer.msg("新增成功", {time: 2000});
									location.reload();
									}else{
									parent.layer.msg("新增失败", {time: 2000});
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
			  
            //监听搜索表单的提交事件
            form.on('submit(search)', function (data) {
                btable.get(data.field);
                return false;
            });
            $(window).on('resize', function (e) {
                var $that = $(this);
                $('#content').height($that.height() - 92);
            }).resize();
        });
    </script>
</body>
</html>