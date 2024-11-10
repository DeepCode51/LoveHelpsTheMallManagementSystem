package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Topic;
import com.service.TopicService;
import com.entity.Users;
import com.entity.Orders;
import com.entity.Goods;
import com.service.UsersService;
import com.service.OrdersService;
import com.service.GoodsService;
import com.util.PageHelper;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/topic" , produces = "text/plain;charset=utf-8")
public class TopicController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	private TopicService topicService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private GoodsService goodsService;

	// 准备添加数据
	@RequestMapping("createTopic.action")
	public String createTopic() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Orders> ordersList = this.ordersService.getAllOrders();
		this.getRequest().setAttribute("ordersList", ordersList);
		List<Goods> goodsList = this.goodsService.getAllGoods();
		this.getRequest().setAttribute("goodsList", goodsList);
		return "admin/addtopic";
	}
	// 添加数据
	@RequestMapping("addTopic.action")
	public String addTopic(Topic topic) {
		this.topicService.insertTopic(topic);
		return "redirect:/topic/createTopic.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteTopic.action")
	public String deleteTopic(String id) {
		this.topicService.deleteTopic(id);
		return "redirect:/topic/getAllTopic.action";
	}

	// 批量删除数据
	@RequestMapping("deleteTopicByIds.action")
	public String deleteTopicByIds() {
		String[] ids = this.getRequest().getParameterValues("topicid");
		for (String topicid : ids) {
			this.topicService.deleteTopic(topicid);
		}
		return "redirect:/topic/getAllTopic.action";
	}

	// 更新数据
	@RequestMapping("updateTopic.action")
	public String updateTopic(Topic topic) {
		this.topicService.updateTopic(topic);
		return "redirect:/topic/getAllTopic.action";
	}

	// 显示全部数据
	@RequestMapping("getAllTopic.action")
	public String getAllTopic(String number) {
		List<Topic> topicList = this.topicService.getAllTopic();
		PageHelper.getPage(topicList, "topic", null, null, 10, number, this.getRequest(), null);
		return "admin/listtopic";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryTopicByCond.action")
	public String queryTopicByCond(String cond, String name, String number) {
		Topic topic = new Topic();
		if(cond != null){
			if ("usersid".equals(cond)) {
				topic.setUsersid(name);
			}
			if ("ordersid".equals(cond)) {
				topic.setOrdersid(name);
			}
			if ("goodsid".equals(cond)) {
				topic.setGoodsid(name);
			}
			if ("num".equals(cond)) {
				topic.setNum(name);
			}
			if ("contents".equals(cond)) {
				topic.setContents(name);
			}
			if ("addtime".equals(cond)) {
				topic.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.topicService.getTopicByLike(topic), "topic", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querytopic";
	}

	// 按主键查询数据
	@RequestMapping("getTopicById.action")
	public String getTopicById(String id) {
		Topic topic = this.topicService.getTopicById(id);
		this.getRequest().setAttribute("topic", topic);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Orders> ordersList = this.ordersService.getAllOrders();
		this.getRequest().setAttribute("ordersList", ordersList);
		List<Goods> goodsList = this.goodsService.getAllGoods();
		this.getRequest().setAttribute("goodsList", goodsList);
		return "admin/edittopic";
	}


}
