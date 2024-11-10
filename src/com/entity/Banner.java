package com.entity;

import com.util.VeDate;

public class Banner {
	private String bannerid = "B" + VeDate.getStringId();// 生成主键编号
	private String bannername;// 栏目名称
	private String addtime;// 创建日期
	private String memo;// 备注

	public String getBannerid() {
		return bannerid;
	}

	public void setBannerid(String bannerid) {
		this.bannerid = bannerid;
	}

	public String getBannername() {
		return this.bannername;
	}

	public void setBannername(String bannername) {
		this.bannername = bannername;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Banner [bannerid=" + this.bannerid + ", bannername=" + this.bannername + ", addtime=" + this.addtime + ", memo=" + this.memo
				+ "]";
	}

}
