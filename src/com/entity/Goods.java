package com.entity;

import com.util.VeDate;

public class Goods {
	private String goodsid = "G" + VeDate.getStringId();// 生成主键编号
	private String usersid;// 发布人
	private String goodsname;// 水果名称
	private String image;// 图片
	private String cateid;// 水果类型
	private String price;// 销售单价
	private String storage;// 库存数量
	private String addtime;// 发布日期
	private String hits;// 点击数
	private String sellnum;// 销量
	private String contents;// 水果详情
	private String username;// 映射数据
	private String catename;// 映射数据

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCateid() {
		return this.cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStorage() {
		return this.storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getHits() {
		return this.hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	public String getSellnum() {
		return this.sellnum;
	}

	public void setSellnum(String sellnum) {
		this.sellnum = sellnum;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Goods [goodsid=" + this.goodsid + ", usersid=" + this.usersid + ", goodsname=" + this.goodsname + ", image=" + this.image
				+ ", cateid=" + this.cateid + ", price=" + this.price + ", storage=" + this.storage + ", addtime=" + this.addtime + ", hits="
				+ this.hits + ", sellnum=" + this.sellnum + ", contents=" + this.contents + ", username=" + this.username + ", catename="
				+ this.catename + "]";
	}

}
