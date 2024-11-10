package com.entity;

import com.util.VeDate;

public class Fav {
	private String favid = "F" + VeDate.getStringId();// 生成主键编号
	private String usersid;// 用户
	private String goodsid;// 水果
	private String addtime;// 收藏日期
	private String username;// 映射数据
	private String goodsname;// 映射数据
	private String image;
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFavid() {
		return favid;
	}

	public void setFavid(String favid) {
		this.favid = favid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
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

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Fav [favid=" + this.favid + ", usersid=" + this.usersid + ", goodsid=" + this.goodsid + ", addtime=" + this.addtime
				+ ", username=" + this.username + ", goodsname=" + this.goodsname + "]";
	}

}
