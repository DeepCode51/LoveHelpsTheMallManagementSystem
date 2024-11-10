<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8">
<title>欢迎访问后台管理系统</title>
<link href="h-ui/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="h-ui/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="h-ui/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript">
	function checkLogin() {
		var username = document.myform.username.value;
		var password = document.myform.password.value;
		if (username == '') {
			alert('请输入用户名');
			document.myform.username.focus();
			return false;
		}
		if (password == '') {
			alert('请输入密码');
			document.myform.password.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<div class="header"></div>
	<div class="loginWraper">
		<div id="loginform" class="loginBox">
			<form class="form form-horizontal" action="admin/login.action" name="myform" method="post"
				onSubmit="return checkLogin()">
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
					<div class="formControls col-xs-8">
						<input type="text" id="username" name="username" placeholder="请输入用户名" class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
					<div class="formControls col-xs-8">
						<input type="password" id="password" name="password" placeholder="请输入密码" class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
						<input type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">版权所有</div>
</body>
</html>
