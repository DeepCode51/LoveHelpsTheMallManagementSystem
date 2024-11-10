package com.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Orders;
import com.entity.Topic;
import com.service.OrdersService;
import com.service.TopicService;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/chart", produces = "text/plain;charset=utf-8")
public class ChartController extends BaseController {
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private TopicService topicService;

	@RequestMapping("chartline.action")
	@ResponseBody
	public String chartline() throws JSONException {
		String start = this.getRequest().getParameter("start");
		String end = this.getRequest().getParameter("end");
		long days = VeDate.getDays(end, start) + 1;
		JSONArray total = new JSONArray();
		JSONArray count = new JSONArray();// 定义count存放数值
		JSONArray day = new JSONArray(); // 存放名称
		for (int i = 0; i < days; i++) {
			String nxtDay = VeDate.getNextDay(start, "" + i);
			System.out.println(nxtDay);
			Orders orders = new Orders();
			orders.setAddtime(nxtDay);
			List<Orders> list = this.ordersService.getOrdersByCond(orders);
			double sellTotal = 0;
			double sellCount = 0;
			for (Orders x : list) {
				sellTotal += Double.parseDouble(x.getTotal());
			}
			sellCount = list.size();
			total.put(VeDate.getDouble(sellTotal));
			count.put(sellCount);
			day.put(nxtDay);
		}
		JSONArray cate = new JSONArray();
		cate.put("订单收入");
		JSONObject json = new JSONObject();
		json.put("sellTotal", total.toString());
		json.put("days", day.toString().replaceAll("\"", ""));
		json.put("cate", cate.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}

	@RequestMapping("chartPie.action")
	@ResponseBody
	public String chartPie() throws JSONException {
		JSONArray names = new JSONArray();
		JSONArray count = new JSONArray();// 定义count存放数值
		int stars1 = 0;
		int stars2 = 0;
		int stars3 = 0;
		int stars4 = 0;
		int stars5 = 0;
		names.put("非常满意");
		names.put("满意");
		names.put("一般");
		names.put("不满意");
		names.put("非常不满意");
		List<Topic> topicList = this.topicService.getAllTopic();
		for (Topic topic : topicList) {
			if ("1".equals(topic.getNum())) {
				stars1++;
			}
			if ("2".equals(topic.getNum())) {
				stars2++;
			}
			if ("3".equals(topic.getNum())) {
				stars3++;
			}
			if ("4".equals(topic.getNum())) {
				stars4++;
			}
			if ("5".equals(topic.getNum())) {
				stars5++;
			}

		}
		count.put(stars5);
		count.put(stars4);
		count.put(stars3);
		count.put(stars2);
		count.put(stars1);
		JSONObject json = new JSONObject();
		json.put("count", count.toString());
		json.put("names", names.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}
}
