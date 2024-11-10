package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Complains;
import com.service.ComplainsService;
import com.entity.Users;
import com.service.UsersService;
import com.util.PageHelper;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/complains" , produces = "text/plain;charset=utf-8")
public class ComplainsController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private ComplainsService complainsService;
	@Autowired
	private UsersService usersService;

	// 准备添加数据
	@RequestMapping("createComplains.action")
	public String createComplains() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/addcomplains";
	}
	// 添加数据
	@RequestMapping("addComplains.action")
	public String addComplains(Complains complains) {
		this.complainsService.insertComplains(complains);
		return "redirect:/complains/createComplains.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteComplains.action")
	public String deleteComplains(String id) {
		this.complainsService.deleteComplains(id);
		return "redirect:/complains/getAllComplains.action";
	}

	// 批量删除数据
	@RequestMapping("deleteComplainsByIds.action")
	public String deleteComplainsByIds() {
		String[] ids = this.getRequest().getParameterValues("complainsid");
		for (String complainsid : ids) {
			this.complainsService.deleteComplains(complainsid);
		}
		return "redirect:/complains/getAllComplains.action";
	}

	// 更新数据
	@RequestMapping("updateComplains.action")
	public String updateComplains(Complains complains) {
		this.complainsService.updateComplains(complains);
		return "redirect:/complains/getAllComplains.action";
	}

	// 更新状态
	@RequestMapping("status.action")
	public String status(String id) {
		String status = "";
		Complains complains = this.complainsService.getComplainsById(id);
		if (status.equals(complains.getStatus())) {
			status = "";
		}
		complains.setStatus(status);
		this.complainsService.updateComplains(complains);
		return "redirect:/complains/getAllComplains.action";
	}

	// 显示全部数据
	@RequestMapping("getAllComplains.action")
	public String getAllComplains(String number) {
		List<Complains> complainsList = this.complainsService.getAllComplains();
		PageHelper.getPage(complainsList, "complains", null, null, 10, number, this.getRequest(), null);
		return "admin/listcomplains";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryComplainsByCond.action")
	public String queryComplainsByCond(String cond, String name, String number) {
		Complains complains = new Complains();
		if(cond != null){
			if ("usersid".equals(cond)) {
				complains.setUsersid(name);
			}
			if ("title".equals(cond)) {
				complains.setTitle(name);
			}
			if ("contents".equals(cond)) {
				complains.setContents(name);
			}
			if ("addtime".equals(cond)) {
				complains.setAddtime(name);
			}
			if ("status".equals(cond)) {
				complains.setStatus(name);
			}
			if ("reps".equals(cond)) {
				complains.setReps(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.complainsService.getComplainsByLike(complains), "complains", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querycomplains";
	}

	// 按主键查询数据
	@RequestMapping("getComplainsById.action")
	public String getComplainsById(String id) {
		Complains complains = this.complainsService.getComplainsById(id);
		this.getRequest().setAttribute("complains", complains);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/editcomplains";
	}


}
