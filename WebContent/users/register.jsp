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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
			用户注册
		</div>
	</div>
	<div class="blank"></div>
	<div class="block">
		<div class="box">
			<div class="box_1">
				<h3>
					<span>用户注册</span>
				</h3>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr valign="top">
						<td bgcolor="#FFFFFF" align="center">
							<form action="index/register.action" method="post" name="myform">
								<table width="60%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
									<tr>
										<td width="28%" align="right" bgcolor="#FFFFFF">用户名：</td>
										<td width="76%" align="left" bgcolor="#FFFFFF"><input type="text" name="username" size="25"
											class="inputBg" id="username" placeholder="请输入用户名" /></td>
									</tr>
									<tr>
										<td width="28%" align="right" bgcolor="#FFFFFF">密码：</td>
										<td width="76%" align="left" bgcolor="#FFFFFF"><input name="password" type="password" size="25"
											class="inputBg" id="password" placeholder="请输入密码" /></td>
									</tr>
									<tr>
										<td width="28%" align="right" bgcolor="#FFFFFF">姓名：</td>
										<td width="76%" align="left" bgcolor="#FFFFFF"><input name="realname" type="text" size="25"
											class="inputBg" id="realname" placeholder="请输入姓名" /></td>
									</tr>
									<tr>
										<td width="28%" align="right" bgcolor="#FFFFFF">性别：</td>
										<td width="76%" align="left" bgcolor="#FFFFFF"><input type="radio" name="sex" value="男" title="男"
											id="sex" checked />男&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="女" title="女" id="sex" />女</td>
									</tr>
									<tr>
										<td width="28%" align="right" bgcolor="#FFFFFF">出生日期：</td>
										<td width="76%" align="left" bgcolor="#FFFFFF"><input name="birthday" type="text" size="25"
											class="inputBg" id="birthday" onclick="WdatePicker()" readonly="readonly" placeholder="请输入出生日期" /></td>
									</tr>
									<tr>
										<td width="28%" align="right" bgcolor="#FFFFFF">联系方式：</td>
										<td width="76%" align="left" bgcolor="#FFFFFF"><input name="contact" type="text" size="25"
											class="inputBg" id="contact" placeholder="请输入联系方式" /></td>
									</tr>
									<tr>
										<td width="28%" align="right" bgcolor="#FFFFFF">联系地址：</td>
										<td width="76%" align="left" bgcolor="#FFFFFF"><input name="address" type="text" size="25"
											class="inputBg" id="address" placeholder="请输入联系地址" /></td>
									</tr>
									<tr>
										<td width="28%" align="right" bgcolor="#FFFFFF">角色：</td>
										<td width="76%" align="left" bgcolor="#FFFFFF"><input type="radio" name="role" value="募捐人" title="募捐人"
											id="role" checked />募捐人&nbsp;&nbsp;&nbsp;<input type="radio" name="role" value="用户" title="用户" id="sex" />用户</td>
									</tr>
									<tr>
										<td width="28%" align="right" bgcolor="#FFFFFF">头像：</td>
										<td width="76%" align="left" bgcolor="#FFFFFF"><input type="text" size="25" class="inputBg" name="image"
											id="image" onclick="selimage();" placeholder="请选择图片" readonly="readonly" /></td>
									</tr>
									<tr>
										<td colspan="2" align="center" bgcolor="#FFFFFF"><input type="submit" class="bnt_blue_1"
											style="border: none;" value="确认注册" id="sub" /></td>
									</tr>
								</table>
							</form>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="blank5"></div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
