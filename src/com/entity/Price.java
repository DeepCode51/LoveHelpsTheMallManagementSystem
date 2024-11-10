package com.entity;

import com.util.VeDate;

public class Price {
	private String priceid = "P" + VeDate.getStringId();// 生成主键编号
	private String cateid;// 农产品类型
	private String goodsid;// 农产品
	private String price;// 价格
	private String addtime;// 日期
	private String catename;// 映射数据
	private String goodsname;// 映射数据

	public String getPriceid() {
		return priceid;
	}

	public void setPriceid(String priceid) {
		this.priceid = priceid;
	}

	public String getCateid() {
		return this.cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
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

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
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
		return "Price [priceid=" + this.priceid + ", cateid=" + this.cateid + ", goodsid=" + this.goodsid + ", price=" + this.price
				+ ", addtime=" + this.addtime + ", catename=" + this.catename + ", goodsname=" + this.goodsname + "]";
	}

}

/**
 * 
 */
