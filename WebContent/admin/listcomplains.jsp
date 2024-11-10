<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>用户举报管理 <span class="c-gray en">&gt;</span>
		用户举报列表 <a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"> <i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="7">在线助手列表</th>
				</tr>
				<tr class="text-c">
					<th>姓名人</th>
					<th>标题</th>
					<th>日期</th>
					<th>状态</th>
					<th>管理员回复</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${complainsList}" var="complains">
				<tr class="text-c">
					<td>${complains.username}</td>
					<td>${complains.title}</td>
					<td>${complains.addtime}</td>
					<td>${complains.status}</td>
					<td>${complains.reps}</td>
					<td><c:if test="${complains.status eq '未回复' }">
							<a href="complains/getComplainsById.action?id=${complains.complainsid}">回复</a>&nbsp;&nbsp;</c:if><a
						href="complains/deleteComplains.action?id=${complains.complainsid}"
						onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="r">${html } </span>
		</div>
	</div>
</body>
</html>

