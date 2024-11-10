<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用后台管理系统</title>
<link rel="stylesheet" type="text/css" href="h-ui/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/style.css" />
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="js/complains.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>物流信息管理 <span class="c-gray en">&gt;</span> 回复物流信息<a
			class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px"
			href="complains/getComplainsById.action?id=${complains.complainsid }" title="刷新"> <i class="Hui-iconfont">&#xe68f;</i></a> &nbsp;&nbsp;
		&nbsp;<a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="complains/getAllComplains.action" title="返回">
			<i class="Hui-iconfont">&#xe66b;</i>
		</a>
	</nav>
	<article class="page-container">
		<form class="form form-horizontal" id="form-article-add" action="complains/updateComplains.action" name="myform" method="post">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">内容</label>
				<div class="formControls col-xs-8 col-sm-9">
					${complains.contents}<input type="hidden" name="contents" class="input-text" id="contents" value="${complains.contents}" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">回复</label>
				<div class="formControls col-xs-8 col-sm-9">
					<textarea class="textarea" name="reps" id="reps" style="height: 120px"> </textarea>
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
					<input type="hidden" name="complainsid" id="complainsid" value="${complains.complainsid}" /><input type="hidden" name="usersid"
						id="usersid" value="${complains.usersid}" /> <input type="hidden" name="title" id="title" value="${complains.title}" /> <input
						type="hidden" name="addtime" id="addtime" value="${complains.addtime}" /> <input type="hidden" name="status" id="status" value="已回复" />
					<input type="hidden" id="basepath" value="<%=basePath%>" />
					<button id="sub" class="btn btn-secondary radius" type="submit">
						<i class="Hui-iconfont">&#xe632;</i>提交保存
					</button>
					<button id="res" class="btn btn-default radius" type="reset">
						<i class="Hui-iconfont">&#xe68f;</i>取消重置
					</button>
				</div>
			</div>
		</form>
	</article>
</body>
</html>


