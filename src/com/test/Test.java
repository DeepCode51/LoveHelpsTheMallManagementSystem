package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.AdminDAO;
import com.entity.Admin;
import com.util.VeDate;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext resource = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
		AdminDAO adminDAO = (AdminDAO) resource.getBean(AdminDAO.class);
		Admin admin = new Admin();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setRealname("admin");
		admin.setContact("-");
		admin.setAddtime(VeDate.getStringDateShort());
		adminDAO.insertAdmin(admin);
	}
}
