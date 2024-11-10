<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href=".">首页</a>
			<code> &gt; </code>
			我的订单
		</div>
	</div>
	<div class="blank"></div>

	<div class="blank"></div>
	<div class="block clearfix">

		<div class="AreaL">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox">
						<jsp:include page="usermenu.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>
		<div class="AreaR">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox boxCenterList clearfix" style="_height: 1%;">
						<h5>
							<span>我的订单</span>
						</h5>
						<div class="blank"></div>
						<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
							<tr>
								<td align="center" bgcolor="#ffffff">订单号</td>
								<td align="center" bgcolor="#ffffff">商品</td>
								<td align="center" bgcolor="#ffffff">价格</td>
								<td align="center" bgcolor="#ffffff">数量</td>
								<td align="center" bgcolor="#ffffff">总计</td>
								<td align="center" bgcolor="#ffffff">状态</td>
								<td align="center" bgcolor="#ffffff">生成日期</td>
								<td align="center" bgcolor="#ffffff">操作</td>
							</tr>
							<c:forEach items="${ordersList}" var="orders">
								<tr>
									<td align="center" bgcolor="#ffffff">${orders.ordercode}</td>
									<td align="center" bgcolor="#ffffff">${orders.goodsname}</td>
									<td align="center" bgcolor="#ffffff">${orders.price}</td>
									<td align="center" bgcolor="#ffffff">${orders.num}</td>
									<td align="center" bgcolor="#ffffff">${orders.total}</td>
									<td align="center" bgcolor="#ffffff">${orders.status}</td>
									<td align="center" bgcolor="#ffffff">${orders.addtime}</td>
									<td align="center" bgcolor="#ffffff"><c:if test="${orders.status eq '未退货'}">
											<a href="index/prePay.action?id=${orders.ordersid}">付款</a>
										</c:if> <c:if test="${orders.status eq '已发货'}">
											<a href="index/over.action?id=${orders.ordersid}">确认收货</a>
										</c:if> <c:if test="${orders.status eq '已收货'}">
											<a href="index/preTopic.action?id=${orders.ordersid}">确认退货</a>
										</c:if></td>
								</tr>
							</c:forEach>
						</table>
						<div class="blank5"></div>
						<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
							<tr>
								<td align="center" bgcolor="#ffffff">${html}</td>
							</tr>
						</table>

					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="blank"></div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
