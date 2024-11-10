package com.entity;

import com.util.VeDate;

public class Cart {
	private String cartid = "C" + VeDate.getStringId();// 生成主键编号
	private String usersid;// 用户
	private String goodsid;// 水果
	private String price;// 单价
	private String num;// 数量
	private String addtime;// 加入日期
	private String username;// 映射数据
	private String goodsname;// 映射数据
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
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

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
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
		return "Cart [cartid=" + this.cartid + ", usersid=" + this.usersid + ", goodsid=" + this.goodsid + ", price=" + this.price + ", num="
				+ this.num + ", addtime=" + this.addtime + ", username=" + this.username + ", goodsname=" + this.goodsname + "]";
	}

}
