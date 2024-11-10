<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="js/users.js"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="index/index.action">首页</a>
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
							<span>个人资料</span>
						</h5>
						<div class="blank"></div>
						<form name="formEdit" action="index/personal.action" method="post">
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">用户名：</td>
									<td width="76%" align="left" bgcolor="#FFFFFF">${sessionScope.users.username }<input type="hidden"
										name="username" id="username" value="${sessionScope.users.username }" /> <input type="hidden" name="password"
										id="password" value="${sessionScope.users.password }" /> <input type="hidden" name="usersid" id="usersid"
										value="${sessionScope.users.usersid }" /><input type="hidden" name="regdate" id="regdate"
										value="${sessionScope.users.regdate }" /><input type="hidden" name="status" id="status"
										value="${sessionScope.users.status }" /><input type="hidden" name="role" id="role"
										value="${sessionScope.users.role }" />
									</td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">姓名：</td>
									<td width="76%" align="left" bgcolor="#FFFFFF"><input name="realname" type="text" size="25"
										class="inputBg" id="realname" value="${sessionScope.users.realname }" /></td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">性别：</td>
									<td width="76%" align="left" bgcolor="#FFFFFF"><input type="radio" name="sex" value="男" title="男" id="sex"
										${users.sex == "男"?"checked":""} />男&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="女" title="女"
										id="sex" ${users.sex == "女"?"checked":""} />女</td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">出生日期：</td>
									<td width="76%" align="left" bgcolor="#FFFFFF"><input name="birthday" type="text" size="25"
										class="inputBg" id="birthday" onclick="WdatePicker()" readonly="readonly"
										value="${sessionScope.users.birthday }" /></td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">联系方式：</td>
									<td width="76%" align="left" bgcolor="#FFFFFF"><input name="contact" type="text" size="25" class="inputBg"
										id="contact" value="${sessionScope.users.contact }" /></td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">用户状态：</td>
									<td width="76%" align="left" bgcolor="#FFFFFF">${sessionScope.users.status }</td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">角色：</td>
									<td width="76%" align="left" bgcolor="#FFFFFF">${sessionScope.users.role }</td>
								</tr>
								<tr>
									<td width="28%" align="right" bgcolor="#FFFFFF">用户头像：</td>
									<td width="76%" align="left" bgcolor="#FFFFFF"><input type="text" size="25" class="inputBg" name="image"
										id="image" onclick="selimage();" value="${sessionScope.users.image }" readonly="readonly" /></td>
								</tr>
								<tr>
									<td colspan="2" align="center" bgcolor="#FFFFFF"><input type="submit" class="bnt_blue_1"
										style="border: none;" value="确认修改" id="sub" /></td>
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
