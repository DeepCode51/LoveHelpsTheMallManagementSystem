package com.entity;

import com.util.VeDate;

public class Rebbs {
	private String rebbsid = "R" + VeDate.getStringId();// 生成主键编号
	private String usersid;// 回复人
	private String bbsid;// 留言
	private String contents;// 内容
	private String addtime;// 回复日期
	private String username;// 映射数据
	private String title;// 映射数据
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRebbsid() {
		return rebbsid;
	}

	public void setRebbsid(String rebbsid) {
		this.rebbsid = rebbsid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getBbsid() {
		return this.bbsid;
	}

	public void setBbsid(String bbsid) {
		this.bbsid = bbsid;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Rebbs [rebbsid=" + this.rebbsid + ", usersid=" + this.usersid + ", bbsid=" + this.bbsid + ", contents=" + this.contents
				+ ", addtime=" + this.addtime + ", username=" + this.username + ", title=" + this.title + "]";
	}

}
