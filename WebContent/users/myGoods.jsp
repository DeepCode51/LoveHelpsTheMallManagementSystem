<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
			用户中心
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
							<span>我的商品</span>
						</h5>
						<div class="blank"></div>
						<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
							<tr align="center" bgcolor="#ffffff">
								<td align="center" bgcolor="#ffffff">商品名称</td>
								<td align="center" bgcolor="#ffffff">商品类型</td>
								<td align="center" bgcolor="#ffffff">单价</td>
								<td align="center" bgcolor="#ffffff">上架日期</td>
								<td align="center" bgcolor="#ffffff">库存数</td>
								<td align="center" bgcolor="#ffffff">销量</td>
								<td align="center" bgcolor="#ffffff">点击数</td>
								<td align="center" bgcolor="#ffffff" width="10%">操作</td>
							</tr>
							<c:forEach items="${goodsList}" var="goods">
								<tr align="center" bgcolor="#ffffff">
									<td align="center" bgcolor="#ffffff">${goods.goodsname}</td>
									<td align="center" bgcolor="#ffffff">${goods.catename}</td>
									<td align="center" bgcolor="#ffffff">${goods.price}</td>
									<td align="center" bgcolor="#ffffff">${goods.addtime}</td>
									<td align="center" bgcolor="#ffffff">${goods.storage}</td>
									<td align="center" bgcolor="#ffffff">${goods.sellnum}</td>
									<td align="center" bgcolor="#ffffff">${goods.hits}</td>
									<td align="center" bgcolor="#ffffff"><a href="index/preEdit.action?id=${goods.goodsid}">编辑</a>&nbsp;&nbsp;<a
										href="index/deleteGoods.action?id=${goods.goodsid}"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a></td>
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
