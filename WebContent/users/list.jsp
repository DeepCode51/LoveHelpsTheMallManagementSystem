<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="index.jsp">首页</a>
			<code> &gt; </code>
			商品列表
		</div>
	</div>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="AreaL">
			<div id="category_tree">
				<div class="tit">所有商品分类</div>
				<dl class="clearfix" style="overflow: hidden;">
					<c:forEach items="${cateList}" var="cate">
						<div class="box1 cate" id="cate">
							<h1 style="border-top: none">
								<a href="index/cate.action?id=${cate.cateid }" class="  f_l">${cate.catename }</a>
							</h1>
						</div>
						<div style="clear: both"></div>
					</c:forEach>
				</dl>
			</div>
			<div class="blank"></div>
			<div class="box" id='history_div'>
				<div class="box_1">
					<h3>
						<span>热门商品</span>
					</h3>
					<div class="boxCenterList clearfix" id='history_list'>
						<c:forEach items="${hotList}" var="goods">
							<ul class="clearfix">
								<li class="goodsimg"><a href="index/detail.action?id=${goods.goodsid }" target="_blank"><img
										src="${goods.image }" alt="${goods.goodsname }" class="B_blue" /> </a></li>
								<li><a href="index/detail.action?id=${goods.goodsid }" target="_blank" title="${goods.goodsname }">${goods.goodsname }</a>
									<br />价格：<font class="f1">￥${goods.price }元</font><br /></li>
							</ul>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="blank5"></div>
		</div>
		<div class="AreaR">
			<div class="box">
				<div class="box_1">
					<h3>
						<span>商品列表</span>
					</h3>
					<div class="clearfix goodsBox" style="border: none; padding: 11px 0 10px 0px;">
						<c:forEach items="${goodsList}" var="goods">
							<div class="goodsItem">
								<a href="index/detail.action?id=${goods.goodsid }"><img src="${goods.image }" alt="${goods.goodsname }"
									class="goodsimg" /> </a> <br />
								<p class="f1">
									<a href="index/detail.action?id=${goods.goodsid }" title="${goods.goodsname }">${goods.goodsname }</a>
								</p>
								销售价：<font class="f1"> ￥${goods.price }元 </font>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="blank5"></div>
			<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
				<tr>
					<td align="center" bgcolor="#ffffff">${html}</td>
				</tr>
			</table>
		</div>

	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
