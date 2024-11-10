package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Banner;
import com.service.BannerService;
import com.util.PageHelper;
import com.util.VeDate;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/banner" , produces = "text/plain;charset=utf-8")
public class BannerController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private BannerService bannerService;

	// 准备添加数据
	@RequestMapping("createBanner.action")
	public String createBanner() {
		return "admin/addbanner";
	}
	// 添加数据
	@RequestMapping("addBanner.action")
	public String addBanner(Banner banner) {
		banner.setAddtime(VeDate.getStringDateShort());
		this.bannerService.insertBanner(banner);
		return "redirect:/banner/createBanner.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteBanner.action")
	public String deleteBanner(String id) {
		this.bannerService.deleteBanner(id);
		return "redirect:/banner/getAllBanner.action";
	}

	// 批量删除数据
	@RequestMapping("deleteBannerByIds.action")
	public String deleteBannerByIds() {
		String[] ids = this.getRequest().getParameterValues("bannerid");
		for (String bannerid : ids) {
			this.bannerService.deleteBanner(bannerid);
		}
		return "redirect:/banner/getAllBanner.action";
	}

	// 更新数据
	@RequestMapping("updateBanner.action")
	public String updateBanner(Banner banner) {
		this.bannerService.updateBanner(banner);
		return "redirect:/banner/getAllBanner.action";
	}

	// 显示全部数据
	@RequestMapping("getAllBanner.action")
	public String getAllBanner(String number) {
		List<Banner> bannerList = this.bannerService.getAllBanner();
		PageHelper.getPage(bannerList, "banner", null, null, 10, number, this.getRequest(), null);
		return "admin/listbanner";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryBannerByCond.action")
	public String queryBannerByCond(String cond, String name, String number) {
		Banner banner = new Banner();
		if(cond != null){
			if ("bannername".equals(cond)) {
				banner.setBannername(name);
			}
			if ("addtime".equals(cond)) {
				banner.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				banner.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.bannerService.getBannerByLike(banner), "banner", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querybanner";
	}

	// 按主键查询数据
	@RequestMapping("getBannerById.action")
	public String getBannerById(String id) {
		Banner banner = this.bannerService.getBannerById(id);
		this.getRequest().setAttribute("banner", banner);
		return "admin/editbanner";
	}


}
