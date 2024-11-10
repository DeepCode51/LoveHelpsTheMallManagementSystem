package com.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Controller 基类
 */
@Controller
public class BaseController {

	/* 日志 */
	protected final Log log = LogFactory.getLog(getClass());

	/* 获取基本环境 */
	public Map<String, String[]> getParameters() {// 封装为Map的requestParameters
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		return attrs.getRequest().getParameterMap();
	}

	public HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		return attrs.getRequest();
	}

	public HttpSession getSession() {
		HttpSession session = null;
		session = this.getRequest().getSession();
		this.log
				.info("\u7A0B\u5E8F\u5F00\u53D1 \u6263\u6263 \u4E03\u96F6\u4E5D\u516D\u516D\u56DB\u516B\u516B\u4E5D  \u53EF\u4EE5\u4ED8\u8D39\u4FEE\u6539");
		return session;
	}

}
