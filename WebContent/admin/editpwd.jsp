<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="h-ui/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/style.css" />
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="js/pwd.js"></script>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span>
		修改密码 <a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="admin/prePwd.action"
			title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<article class="page-container">
		<form class="form form-horizontal" id="form-article-add" action="admin/editpwd.action" name="myform" method="post">
			<div class="row cl">
				<label class="form-label col-xs-6 col-sm-2">登录名：</label>
				<div class="formControls col-xs-6 col-sm-9">
					<%=session.getAttribute("adminname")%>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text" name="password" id="password" placeholder="请输入密码">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">新密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text" name="newpassword" id="newpassword" placeholder="请输入新密码">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">确认密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text" name="repassword" id="repassword" placeholder="请输入确认密码">
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
					<button id="sub" class="btn btn-secondary radius" type="submit">
						<i class="Hui-iconfont">&#xe632;</i>提交保存
					</button>
					<button class="btn btn-default radius" id="res" type="reset">
						<i class="Hui-iconfont">&#xe68f;</i>取消重置
					</button>
				</div>
			</div>
		</form>
	</article>

</body>
</html>