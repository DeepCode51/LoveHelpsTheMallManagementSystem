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
<link href="themes/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="ckeditor/ckeditor.js">
	
</script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="index/index.action">首页</a>
			<code> &gt; </code>
			${bbs.title }
		</div>
	</div>
	<div class="blank"></div>
	<div class="block">
		<div class="box">
			<div class="box_1">
				<div class="t t2" style="border-top: 0">
					<table cellspacing="0" cellpadding="0" width="100%" align="center">
						<tr>
							<td class="h"><b>主题:</b> ${bbs.title }</td>
							<td class="h" style="text-align: right;"></td>
						</tr>
					</table>
					<table cellspacing="0" cellpadding="0" width="100%" align="center">
						<tr class="tr1 do_not_catch">
							<th width="20%" rowspan="2" class="r_two"><font color="#000066" face="Gulim"><b>${bbs.username }</b> </font>
								<div style="padding: 10px 0;">
									<table width="98%" cellspacing="0" cellpadding="0" style="border: 0">
										<tr>
											<td class="tac" style="overflow: hidden; border: 0;"><img src="${bbs.image }" width="170" height="200" border="0" /></td>
										</tr>
									</table>
								</div></th>
							<th height="100%" valign="top" style="padding: 5px 15px 0 15px; border: 0; width: 80%; overflow: hidden">
								<table width="100%" align="center" cellspacing="0" cellpadding="0" style="WORD-WRAP: break-word; height: 100%;">
									<tr style="height: 100%">
										<td bgcolor="" valign="top">
											<div class="tiptop"></div>
											<h4>${bbs.title }</h4>
											<div class="tips" style="width: auto"></div>
											<div class="c"></div> <br />
											<div class="tpc_content do_not_catch">${bbs.contents }</div>
										</td>
									</tr>
								</table>
							</th>
						</tr>
						<tr class="tr1">
							<th style="vertical-align: bottom; padding-left: 1.5%; border: 0">
								<div class="tipad">
									<span style="float: right"> </span> 发布日期:${bbs.addtime }
								</div>
							</th>
						</tr>
					</table>
				</div>
				<c:forEach items="${rebbsList}" var="rebbs">
					<div class="t t2" style="border-top: 0">
						<table cellspacing="0" cellpadding="0" width="100%" align="center">
							<tr class="tr1 do_not_catch">
								<th width="20%" rowspan="2" class="r_two"><font color="#000066" face="Gulim"><b>${rebbs.username }</b> </font>
									<div style="padding: 10px 0;">
										<table width="98%" cellspacing="0" cellpadding="0" style="border: 0">
											<tr>
												<td class="tac" style="overflow: hidden; border: 0;"><img src="${rebbs.image }" width="170" height="200" border="0" /></td>
											</tr>
										</table>
									</div></th>
								<th height="100%" valign="top" style="padding: 5px 15px 0 15px; border: 0; width: 80%; overflow: hidden">
									<table width="100%" align="center" cellspacing="0" cellpadding="0" style="WORD-WRAP: break-word; height: 100%;">
										<tr style="height: 100%">
											<td bgcolor="" valign="top">
												<div class="tiptop"></div>
												<div class="tips" style="width: auto"></div>
												<div class="c"></div> <br />
												<div class="tpc_content do_not_catch">${rebbs.contents }</div>
											</td>
										</tr>
									</table>
								</th>
							</tr>
							<tr class="tr1">
								<th style="vertical-align: bottom; padding-left: 1.5%; border: 0">
									<div class="tipad">
										<span style="float: right"> </span> 回复日期:${rebbs.addtime }
									</div>
								</th>
							</tr>
						</table>
					</div>
				</c:forEach>
				<c:if test="${sessionScope.userid != null }">
					<form method="post" action="index/rebbs.action">
						<div class="t">
							<table cellpadding="0" cellspacing="0" align="center">
								<tbody>
									<tr>
										<td class="h" colspan="3"><b>回复帖子</b></td>
									</tr>
								</tbody>
								<tbody>
									<tr class="tr3 f_two">
										<th width="20%" class="t_one"><b>内容</b></th>
										<th colspan="2">
											<div class="wysiwyg" style="padding: 0x; border: 1px solid #DDDDDD; margin-bottom: 5px;">
												<textarea cols="80" id="contents" name="contents" rows="10">在此添加内容</textarea>
												<script type="text/javascript">
													CKEDITOR
															.replace(
																	'contents',
																	{
																		language : 'zh-cn'
																	});
												</script>
												<input type="hidden" name="bbsid" style="width: 160px" id="title" value="${bbs.bbsid }" />
											</div>
										</th>
									</tr>
								</tbody>
							</table>
						</div>
						<div style="margin: 15px 0 15px 0; text-align: center;">
							<input class="btn" type="submit" value="提 交" name="Submit" tabindex="3" />
						</div>
					</form>
				</c:if>
			</div>
		</div>
		<div class="blank5"></div>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
