package com.entity;

import com.util.VeDate;

public class Users {
	private String usersid = "U" + VeDate.getStringId();// 生成主键编号
	private String username;// 用户名
	private String password;// 密码
	private String realname;// 姓名
	private String sex;// 性别
	private String birthday;// 出生日期
	private String contact;// 联系方式
	private String address;// 联系地址
	private String image;// 头像
	private String role;// 角色
	private String status;// 状态
	private String regdate;// 注册日期

	public String getUsersid() {
		return usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
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

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegdate() {
		return this.regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Users [usersid=" + this.usersid + ", username=" + this.username + ", password=" + this.password + ", realname=" + this.realname
				+ ", sex=" + this.sex + ", birthday=" + this.birthday + ", contact=" + this.contact + ", address=" + this.address + ", image="
				+ this.image + ", role=" + this.role + ", status=" + this.status + ", regdate=" + this.regdate + "]";
	}

}
