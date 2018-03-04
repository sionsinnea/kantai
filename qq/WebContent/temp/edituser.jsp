<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String path = request.getContextPath();%>
     <% String realPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
    <!DOCTYPE html>
    <div style="margin: 15px;">
	<form class="layui-form">
	<input type="hidden" name="id" id="id">
		<div class="layui-form-item">
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-inline">
				<input id="myname" type="text" name="name" placeholder="请输入姓名" lay-verify="required" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">年龄</label>
			<div class="layui-input-inline">
				<input id="age" type="text" name="age" required lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input">
			</div>
			
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">手机</label>
			<div class="layui-input-inline">
				<input id="phone" type="text" name="phone" required lay-verify="phone" placeholder="请输入手机" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label  class="layui-form-label">地址</label>
			<div class="layui-input-inline">
				<input id="address" type="text" name="address" required lay-verify="" placeholder="请输入地址" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">单选框</label>
			<div class="layui-input-block">
				<input id="boy" type="radio" name="sex" value="男" title="男" >
				<input type="radio" name="sex" value="女" title="女" >
				<input type="radio" name="sex" value="秀吉" title="秀吉" disabled checked>
			</div>
		</div>
		
		
		<button lay-filter="edit" lay-submit style="display: none;"></button>
	</form>
</div>
