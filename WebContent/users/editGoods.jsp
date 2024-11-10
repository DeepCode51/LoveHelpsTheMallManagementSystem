<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>
<script type="text/javascript" src="js/jquery-1.3.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="js/ajax.js" charset="utf-8"></script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="<%=basePath%>">首页</a>
			<code> &gt; </code>
			编辑商品
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
							<span>编辑商品</span>
						</h5>
						<div class="blank"></div>
						<form action="index/updateGoods.action" name="myform" method="post">
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">商品名称：</td>
									<td width="85%" align="left" bgcolor="#FFFFFF"><input name="goodsname" type="text" size="25"
										class="inputBg" id="goodsname" value="${goods.goodsname }" /> <input name="goodsid" type="hidden"
										id="goodsid" value="${goods.goodsid }" /> <input name="addtime" type="hidden" id="addtime"
										value="${goods.addtime }" /> <input name="sellnum" type="hidden" id="sellnum" value="${goods.sellnum }" /> <input
										name="hits" type="hidden" id="hits" value="${goods.hits }" /> <input name="usersid" type="hidden"
										id="usersid" value="${goods.usersid }" /></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">商品类型：</td>
									<td width="85%" align="left" bgcolor="#FFFFFF"><select name="cateid" class="inputBg" id="cateid"><c:forEach
												items="${cateList}" var="cate">
												<option value="${cate.cateid}">${cate.catename }</option>
											</c:forEach></select></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">图片：</td>
									<td width="85%" align="left" bgcolor="#FFFFFF"><input name="image" type="text" size="25" class="inputBg"
										id="image" onclick="selimage();" value="${goods.image }" readonly="readonly" /></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">单价：</td>
									<td width="85%" align="left" bgcolor="#FFFFFF"><input name="price" type="text" size="25" class="inputBg"
										id="price" value="${goods.price }" /></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">库存数：</td>
									<td width="85%" align="left" bgcolor="#FFFFFF"><input name="storage" type="text" size="25" class="inputBg"
										id="storage" value="${goods.storage }" /></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">商品介绍：</td>
									<td align="left" bgcolor="#FFFFFF"><script type="text/javascript" src="ckeditor/ckeditor.js"></script> <textarea
											cols="80" name="contents" id="contents" rows="10">${goods.contents } </textarea> <script
											type="text/javascript">
												CKEDITOR.replace('contents', {
													language : 'zh-cn'
												});
											</script></td>
								</tr>
								<tr>
									<td colspan="2" align="center" bgcolor="#FFFFFF"><input type="hidden" name="id" id="id" value="${id }">
										<input type="submit" class="bnt_blue_1" style="border: none;" value="确认发布" /></td>
								</tr>
							</table>
						</form>

					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="blank"></div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
