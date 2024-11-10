package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Bbs;
import com.service.BbsService;
import com.entity.Users;
import com.service.UsersService;
import com.util.PageHelper;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/bbs" , produces = "text/plain;charset=utf-8")
public class BbsController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private BbsService bbsService;
	@Autowired
	private UsersService usersService;

	// 准备添加数据
	@RequestMapping("createBbs.action")
	public String createBbs() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/addbbs";
	}
	// 添加数据
	@RequestMapping("addBbs.action")
	public String addBbs(Bbs bbs) {
		this.bbsService.insertBbs(bbs);
		return "redirect:/bbs/createBbs.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteBbs.action")
	public String deleteBbs(String id) {
		this.bbsService.deleteBbs(id);
		return "redirect:/bbs/getAllBbs.action";
	}

	// 批量删除数据
	@RequestMapping("deleteBbsByIds.action")
	public String deleteBbsByIds() {
		String[] ids = this.getRequest().getParameterValues("bbsid");
		for (String bbsid : ids) {
			this.bbsService.deleteBbs(bbsid);
		}
		return "redirect:/bbs/getAllBbs.action";
	}

	// 更新数据
	@RequestMapping("updateBbs.action")
	public String updateBbs(Bbs bbs) {
		this.bbsService.updateBbs(bbs);
		return "redirect:/bbs/getAllBbs.action";
	}

	// 显示全部数据
	@RequestMapping("getAllBbs.action")
	public String getAllBbs(String number) {
		List<Bbs> bbsList = this.bbsService.getAllBbs();
		PageHelper.getPage(bbsList, "bbs", null, null, 10, number, this.getRequest(), null);
		return "admin/listbbs";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryBbsByCond.action")
	public String queryBbsByCond(String cond, String name, String number) {
		Bbs bbs = new Bbs();
		if(cond != null){
			if ("usersid".equals(cond)) {
				bbs.setUsersid(name);
			}
			if ("title".equals(cond)) {
				bbs.setTitle(name);
			}
			if ("contents".equals(cond)) {
				bbs.setContents(name);
			}
			if ("addtime".equals(cond)) {
				bbs.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				bbs.setHits(name);
			}
			if ("repnum".equals(cond)) {
				bbs.setRepnum(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.bbsService.getBbsByLike(bbs), "bbs", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querybbs";
	}

	// 按主键查询数据
	@RequestMapping("getBbsById.action")
	public String getBbsById(String id) {
		Bbs bbs = this.bbsService.getBbsById(id);
		this.getRequest().setAttribute("bbs", bbs);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/editbbs";
	}


}
