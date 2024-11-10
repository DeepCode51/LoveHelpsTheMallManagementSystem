<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<div id="VjiaFooter" class="block">
	<div class="copyRight">
		<div class="f_nav"></div>
		<div align="center">
			版权所有 &copy; <a href="admin/index.action" target="_blank">后台管理员入口</a>
		</div>
		<div class="blank"></div>
	</div>
</div>
<%
	String message = (String) session.getAttribute("message");
	if (message == null) {
		message = "";
	}
	if (!message.trim().equals("")) {
		out.println("<script language='javascript'>");
		out.println("alert('" + message + "');");
		out.println("</script>");
	}
	session.removeAttribute("message");
%>