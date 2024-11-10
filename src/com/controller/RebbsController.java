package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Rebbs;
import com.service.RebbsService;
import com.entity.Users;
import com.entity.Bbs;
import com.service.UsersService;
import com.service.BbsService;
import com.util.PageHelper;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/rebbs" , produces = "text/plain;charset=utf-8")
public class RebbsController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private RebbsService rebbsService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private BbsService bbsService;

	// 准备添加数据
	@RequestMapping("createRebbs.action")
	public String createRebbs() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Bbs> bbsList = this.bbsService.getAllBbs();
		this.getRequest().setAttribute("bbsList", bbsList);
		return "admin/addrebbs";
	}
	// 添加数据
	@RequestMapping("addRebbs.action")
	public String addRebbs(Rebbs rebbs) {
		this.rebbsService.insertRebbs(rebbs);
		return "redirect:/rebbs/createRebbs.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteRebbs.action")
	public String deleteRebbs(String id) {
		this.rebbsService.deleteRebbs(id);
		return "redirect:/rebbs/getAllRebbs.action";
	}

	// 批量删除数据
	@RequestMapping("deleteRebbsByIds.action")
	public String deleteRebbsByIds() {
		String[] ids = this.getRequest().getParameterValues("rebbsid");
		for (String rebbsid : ids) {
			this.rebbsService.deleteRebbs(rebbsid);
		}
		return "redirect:/rebbs/getAllRebbs.action";
	}

	// 更新数据
	@RequestMapping("updateRebbs.action")
	public String updateRebbs(Rebbs rebbs) {
		this.rebbsService.updateRebbs(rebbs);
		return "redirect:/rebbs/getAllRebbs.action";
	}

	// 显示全部数据
	@RequestMapping("getAllRebbs.action")
	public String getAllRebbs(String number) {
		List<Rebbs> rebbsList = this.rebbsService.getAllRebbs();
		PageHelper.getPage(rebbsList, "rebbs", null, null, 10, number, this.getRequest(), null);
		return "admin/listrebbs";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryRebbsByCond.action")
	public String queryRebbsByCond(String cond, String name, String number) {
		Rebbs rebbs = new Rebbs();
		if(cond != null){
			if ("usersid".equals(cond)) {
				rebbs.setUsersid(name);
			}
			if ("bbsid".equals(cond)) {
				rebbs.setBbsid(name);
			}
			if ("contents".equals(cond)) {
				rebbs.setContents(name);
			}
			if ("addtime".equals(cond)) {
				rebbs.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.rebbsService.getRebbsByLike(rebbs), "rebbs", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryrebbs";
	}

	// 按主键查询数据
	@RequestMapping("getRebbsById.action")
	public String getRebbsById(String id) {
		Rebbs rebbs = this.rebbsService.getRebbsById(id);
		this.getRequest().setAttribute("rebbs", rebbs);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Bbs> bbsList = this.bbsService.getAllBbs();
		this.getRequest().setAttribute("bbsList", bbsList);
		return "admin/editrebbs";
	}


}
