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
<title></title>
<link rel="stylesheet" type="text/css" href="h-ui/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/style.css" />
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript">
	function selok() {
		opener.document.getElementById("image").value = myform.p.value;
		window.close();
	}
</script>
</head>
<body>
	<article class="page-container">
		<form class="form form-horizontal" id="form-article-add" action="upload/image.action" name="myform" method="post"
			enctype="multipart/form-data">
			<div class="row cl">
				<div class="formControls col-xs-9 col-sm-9">
					<input type="file" name="image" class="layui-input" id="image" />
				</div>
			</div>
			<c:if test="${imageFileName ne null }">
				<div class="row cl">
					<label class="form-label col-xs-12">${imageFileName }</label>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-12">
					<input type="hidden" name="p" value="upfiles/${imageFileName }" id="p" />
						<button class="btn btn-secondary radius" type="button" onclick="selok();">
							<i class="Hui-iconfont">&#xe632;</i>保存图片
						</button>
					</div>
				</div>
			</c:if>
			<c:if test="${imageFileName eq null }">
				<div class="row cl">
					<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
						<button id="sub" class="btn btn-secondary radius" type="submit">
							<i class="Hui-iconfont">&#xe632;</i>上传图片
						</button>
					</div>
				</div>
			</c:if>
		</form>
	</article>
</body>
</html>