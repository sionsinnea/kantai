<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String path = request.getContextPath();%>
     <% String realPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
    <!DOCTYPE html>
    <div style="margin: 15px;">
	<form class="layui-form">
	
	<div class="layui-form-item">
			
			<div class="layui-input-inline">
				<input id="taskId" type="hidden" name="taskId" lay-verify="" autocomplete="off" class="layui-input">
			</div>
		</div>
	
		<div class="layui-form-item">
			<label class="layui-form-label">任务名称</label>
			<div class="layui-input-inline">
				<input  type="text" name="name" placeholder="请输入任务名" lay-verify="required" autocomplete="off" class="layui-input">
			</div>
		</div>
  
	  <div class="layui-form-item layui-form-text">
	    <label class="layui-form-label">任务内容</label>
	    <div class="layui-input-block">
	      <textarea  name="detail" placeholder="请输入内容" class="layui-textarea" style="resize:none" lay-verify="required"></textarea>
	    </div>
	  </div>
	  		<div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">优先度</label>
      <div class="layui-input-inline">
        <select  name="level"  lay-search="">
         
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>


        </select>
      </div>
      <div class="layui-form-mid layui-word-aux">1 优先度最高</div>
    </div>

  </div>
  

		
		<button lay-filter="add" lay-submit style="display: none;"></button>
	</form>
</div>