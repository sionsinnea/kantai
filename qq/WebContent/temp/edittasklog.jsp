<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String path = request.getContextPath();%>
     <% String realPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
    <!DOCTYPE html>
    <div style="margin: 15px;">
	<form class="layui-form">
	<input type="hidden" id="taskId" name="taskId">
	<div class="layui-form-item">
			<label class="layui-form-label">任务编号</label>
			<div class="layui-input-inline">
				<input id="taskLogId" type="text" name="taskLogId" placeholder="请输入编号" lay-verify="required" autocomplete="off" class="layui-input" disabled>
			</div>
		</div>
	
		<div class="layui-form-item">
			<label class="layui-form-label">任务名称</label>
			<div class="layui-input-inline">
				<input id="name" type="text" name="name" placeholder="请输入任务名" lay-verify="required" autocomplete="off" class="layui-input">
			</div>
		</div>
		

		<div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">优先度</label>
      <div class="layui-input-inline">
        <select id="level" name="level" lay-verify="required" lay-search="">
         
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          

        </select>
      </div>
    </div>

  </div>
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">任务内容</label>
    <div class="layui-input-block">
      <textarea id="detail" name="detail" placeholder="请输入内容" class="layui-textarea" style="resize:none"></textarea>
    </div>
  </div>
  

		
		<button lay-filter="edit" lay-submit style="display: none;"></button>
	</form>
</div>