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
			留言板
		</div>
	</div>
	<div class="blank"></div>
	<div class="block">
		<div class="box">
			<div class="box_1">
				<div class="boxCenterList">
					<div class="t" style="margin: 3px auto">
						<table cellspacing="0" cellpadding="0" width="100%" id="ajaxtable">
							<tbody style="table-layout: fixed;">
								<tr class="tr2">
									<td style="width: 62%" class="tac">文章</td>
									<td style="width: 10%" class="y-style">发布日期</td>
									<td style="width: 6%" class="y-style">点击数</td>
									<td style="width: 17%" class="y-style">回复数</td>
								</tr>
								<c:forEach items="${bbsList}" var="bbs">
									<tr align="center" class="tr3 t_one">
										<td style="text-align: left;"><a href="index/readbbs.action?id=${bbs.bbsid }" target="_blank" title="标题：${bbs.title }"><font
												style="font-weight: normal; font-size: 16px;"> ${bbs.title }</font> </a></td>
										<td class="tal y-style">
											<div class="f10">${bbs.addtime }</div> ${bbs.username }
										</td>
										<td class="tal f10 y-style">${bbs.hits }</td>
										<td class="tal y-style">${bbs.repnum }</td>
									</tr>
								</c:forEach>
								<tr>
									<td style="height: 8px"></td>
								</tr>
							</tbody>
						</table>
						<c:if test="${sessionScope.userid != null }">
							<form method="post" action="index/addbbs.action">
								<div class="t">
									<table cellpadding="0" cellspacing="0" align="center">
										<tbody>
											<tr>
												<td class="h" colspan="3"><b>发表帖子</b></td>
											</tr>
										</tbody>
										<tbody>
											<tr class="tr3 f_one">
												<th width="20%" class="t_one"><b>标题</b></th>
												<th><input class="input" name="title" id='title' size="60" value="" tabindex="1"
													style="font: 14px Tahoma; padding-left: 2px" /></th>
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
			</div>
			<div class="blank5"></div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
