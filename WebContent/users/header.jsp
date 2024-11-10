<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<link href="themes/ecmoban_benlai/style.css" rel="stylesheet" type="text/css" />

<div class="top_nav">
	<div class="block">
		<div class="bookmail">
			<div id="append_parent"></div>
		</div>
		<div class="user_control">
			<c:if test="${sessionScope.userid == null }">
				<font id="ECS_MEMBERZONE"> 欢迎光临本站，<a href="index/preLogin.action">[用户登录]</a>&nbsp;<a
					href="index/preReg.action">[用户注册]</a>
				</font>
			</c:if>

			<c:if test="${sessionScope.userid != null }">
				<font id="ECS_MEMBERZONE"> 欢迎光临本站${sessionScope.username }， <a href="index/cart.action">[购物车]</a>&nbsp;<a
					href="index/usercenter.action">[用户中心]</a>&nbsp; <a href="index/exit.action">[退出系统]</a>
				</font>
			</c:if>
		</div>
	</div>
</div>
<div class="clearfix">
	<div class="block header">
		<div class="top clearfix">
			<a href="index.jsp" class="logo" style="font-size: 26px;
    font-weight: bold;
    color: #00c2de;
    border: 0;">“互惠生活”爱心助力系统</a>
			<div class="head_r" style="padding-top: 10px;">
				<form id="searchForm" name="searchForm" method="post" action="index/query.action"
					style="_position: relative; top: 5px;">
					<div class="headSearch_input">
						<input name="name" type="text" id="name" class="keyword" value="" required="required" /> <input value=""
							id="seachbtn" type="submit" />
					</div>
				</form>
				<div class="top_search">
					<div class="vjia-suggest-container">
						<div class="vjia-suggest-content"></div>
					</div>
					<div style="clear: both"></div>
				</div>
			</div>
			<div class="sales_num">
				<div class="clearfix"></div>
			</div>

		</div>
	</div>
</div>
<div style="clear: both"></div>

<div class="menu_box clearfix">
	<div class="block main_menu">
		<div class="menu">
			<a href="index.jsp" class="cur">首页</a>
			<c:forEach items="${bannerList}" var="banner">
				<a href="index/article.action?id=${banner.bannerid}" class="cur">${banner.bannername }</a>
			</c:forEach>
			<a href="index/all.action" class="cur">闲置交易</a> <a href="index/bbs.action" class="cur">留言交流</a>
		</div>
	</div>
</div>