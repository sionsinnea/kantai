<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String path = request.getContextPath();%>
     <% String realPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
    <!DOCTYPE html>
    <div style="margin: 15px;">
	<form class="layui-form">
	
	<div class="layui-form-item">
			<label class="layui-form-label">课题编号</label>
			<div class="layui-input-inline">
				<input type="text" name="taskno" placeholder="请输入编号" lay-verify="required" autocomplete="off" class="layui-input">
			</div>
		</div>
	
		<div class="layui-form-item">
			<label class="layui-form-label">课题名称</label>
			<div class="layui-input-inline">
				<input type="text" name="name" placeholder="请输入任务名" lay-verify="required" autocomplete="off" class="layui-input">
			</div>
		</div>
		

		<div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">选择部门</label>
      <div class="layui-input-inline">
        <select id="dept" name="deptId" lay-verify="required" lay-search="">
         
          <option value="1">开发1部</option>
          <option value="2">开发2部</option>
          <option value="3">开发3部</option>
          <option value="4">海外开发部</option>
          <option value="5">开发事业部</option>

        </select>
      </div>
    </div>

  </div>
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">课题内容</label>
    <div class="layui-input-block">
      <textarea name="detail" placeholder="请输入内容" class="layui-textarea" style="resize:none"></textarea>
    </div>
  </div>
  
		<div class="layui-form-item">
			<label class="layui-form-label">启用</label>
			<div class="layui-input-inline">
				<input type="checkbox" name="is_del" lay-skin="switch" lay-text="启用|停用">
			</div>
			<div class="layui-form-mid layui-word-aux">是否开启任务</div>
		</div>
		
		<button lay-filter="edit" lay-submit style="display: none;"></button>
	</form>
</div>