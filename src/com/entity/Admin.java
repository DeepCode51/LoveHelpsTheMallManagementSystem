package com.entity;

import com.util.VeDate;

public class Admin {
	private String adminid = "A" + VeDate.getStringId();// 生成主键编号
	private String username;// 用户名
	private String password;// 密码
	private String realname;// 姓名
	private String contact;// 联系方式
	private String addtime;// 创建日期

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Admin [adminid=" + this.adminid + ", username=" + this.username + ", password=" + this.password + ", realname=" + this.realname
				+ ", contact=" + this.contact + ", addtime=" + this.addtime + "]";
	}

}
