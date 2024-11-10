package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Article;
import com.entity.Banner;
import com.entity.Bbs;
import com.entity.Cart;
import com.entity.Cate;
import com.entity.Complains;
import com.entity.Fav;
import com.entity.Goods;
import com.entity.Orders;
import com.entity.Rebbs;
import com.entity.Topic;
import com.entity.Users;
import com.service.ArticleService;
import com.service.BannerService;
import com.service.BbsService;
import com.service.CartService;
import com.service.CateService;
import com.service.ComplainsService;
import com.service.FavService;
import com.service.GoodsService;
import com.service.OrdersService;
import com.service.RebbsService;
import com.service.TopicService;
import com.service.UsersService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/index")
public class IndexController extends BaseController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private BannerService bannerService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CateService cateService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CartService cartService;
	@Autowired
	private FavService favService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private ComplainsService complainsService;
	@Autowired
	private BbsService bbsService;
	@Autowired
	private RebbsService rebbsService;

	// 公共方法 提供公共查询数据
	private void front() {
		this.getRequest().setAttribute("title", "“互惠生活”爱心助力系统");
		List<Banner> bannerList = this.bannerService.getAllBanner();
		this.getRequest().setAttribute("bannerList", bannerList);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		List<Goods> hotList = this.goodsService.getGoodsByHot();
		this.getRequest().setAttribute("hotList", hotList);
	}

	// 首页显示
	@RequestMapping("index.action")
	public String index() {
		this.front();
		List<Cate> cateList = this.cateService.getCateFront();
		List<Cate> frontList = new ArrayList<Cate>();
		for (Cate cate : cateList) {
			List<Goods> goodsList = this.goodsService.getGoodsByCate(cate.getCateid());
			cate.setGoodsList(goodsList);
			frontList.add(cate);
		}
		this.getRequest().setAttribute("frontList", frontList);
		return "users/index";
	}

	// 新闻公告
	@RequestMapping("article.action")
	public String article(String id, String number) {
		this.front();
		Article article = new Article();
		article.setBannerid(id);
		List<Article> articleList = this.articleService.getArticleByCond(article);
		PageHelper.getIndexPage(articleList, "article", "article", id, 10, number, this.getRequest());
		Banner banner = this.bannerService.getBannerById(id);
		this.getRequest().setAttribute("banner", banner);
		return "users/article";
	}

	// 阅读公告
	@RequestMapping("read.action")
	public String read(String id) {
		this.front();
		Article article = this.articleService.getArticleById(id);
		article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
		this.articleService.updateArticle(article);
		this.getRequest().setAttribute("article", article);
		return "users/read";
	}

	// 准备登录
	@RequestMapping("preLogin.action")
	public String prelogin() {
		this.front();
		return "users/login";
	}

	// 用户登录
	@RequestMapping("login.action")
	public String login() {
		this.front();
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		Users u = new Users();
		u.setUsername(username);
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			this.getSession().setAttribute("message", "用户名不存在");
			return "redirect:/index/preLogin.action";
		} else {
			Users users = usersList.get(0);
			if ("锁定".equals(users.getStatus())) {
				this.getSession().setAttribute("message", "账户被锁定");
				return "redirect:/index/preLogin.action";
			}
			if (password.equals(users.getPassword())) {
				this.getSession().setAttribute("userid", users.getUsersid());
				this.getSession().setAttribute("username", users.getUsername());
				this.getSession().setAttribute("users", users);
				this.getSession().setAttribute("role", users.getRole());
				return "redirect:/index/index.action";
			} else {
				this.getSession().setAttribute("message", "密码错误");
				return "redirect:/index/preLogin.action";
			}
		}
	}

	// 准备注册
	@RequestMapping("preReg.action")
	public String preReg() {
		this.front();
		return "users/register";
	}

	// 用户注册
	@RequestMapping("register.action")
	public String register(Users users) {
		this.front();
		Users u = new Users();
		u.setUsername(users.getUsername());
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			users.setStatus("解锁");
			users.setRegdate(VeDate.getStringDateShort());
			this.usersService.insertUsers(users);
		} else {
			this.getSession().setAttribute("message", "用户名已存在");
			return "redirect:/index/preReg.action";
		}

		return "redirect:/index/preLogin.action";
	}

	// 退出登录
	@RequestMapping("exit.action")
	public String exit() {
		this.front();
		this.getSession().removeAttribute("userid");
		this.getSession().removeAttribute("username");
		this.getSession().removeAttribute("users");
		return "redirect:/index/index.action";
	}

	// 准备修改密码
	@RequestMapping("prePwd.action")
	public String prePwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/editpwd";
	}

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		String password = this.getRequest().getParameter("password");
		String repassword = this.getRequest().getParameter("repassword");
		Users users = this.usersService.getUsersById(userid);
		if (password.equals(users.getPassword())) {
			users.setPassword(repassword);
			this.usersService.updateUsers(users);
		} else {
			this.getSession().setAttribute("message", "旧密码错误");
			return "redirect:/index/prePwd.action";
		}
		return "redirect:/index/prePwd.action";
	}

	@RequestMapping("usercenter.action")
	public String usercenter() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/usercenter";
	}

	@RequestMapping("userinfo.action")
	public String userinfo() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		this.getSession().setAttribute("users", this.usersService.getUsersById(userid));
		return "users/userinfo";
	}

	@RequestMapping("personal.action")
	public String personal(Users users) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.usersService.updateUsers(users);
		return "redirect:/index/userinfo.action";
	}

	// 留言板
	@RequestMapping("bbs.action")
	public String bbs() {
		this.front();
		List<Bbs> bbsList = this.bbsService.getAllBbs();
		this.getRequest().setAttribute("bbsList", bbsList);
		return "users/bbs";
	}

	// 发布留言
	@RequestMapping("addbbs.action")
	public String addbbs() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Bbs bbs = new Bbs();
		bbs.setAddtime(VeDate.getStringDate());
		bbs.setContents(getRequest().getParameter("contents"));
		bbs.setHits("0");
		bbs.setRepnum("0");
		bbs.setTitle(getRequest().getParameter("title"));
		bbs.setUsersid(userid);
		this.bbsService.insertBbs(bbs);
		return "redirect:/index/bbs.action";
	}

	// 查看留言
	@RequestMapping("readbbs.action")
	public String readbbs() {
		this.front();
		Bbs bbs = this.bbsService.getBbsById(getRequest().getParameter("id"));
		bbs.setHits("" + (Integer.parseInt(bbs.getHits()) + 1));
		this.bbsService.updateBbs(bbs);
		this.getRequest().setAttribute("bbs", bbs);
		Rebbs rebbs = new Rebbs();
		rebbs.setBbsid(bbs.getBbsid());
		List<Rebbs> rebbsList = this.rebbsService.getRebbsByCond(rebbs);
		this.getRequest().setAttribute("rebbsList", rebbsList);
		return "users/readbbs";
	}

	// 回复留言
	@RequestMapping("rebbs.action")
	public String rebbs() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Rebbs rebbs = new Rebbs();
		rebbs.setAddtime(VeDate.getStringDate());
		rebbs.setContents(getRequest().getParameter("contents"));
		rebbs.setBbsid(getRequest().getParameter("bbsid"));
		rebbs.setUsersid(userid);
		this.rebbsService.insertRebbs(rebbs);
		Bbs bbs = this.bbsService.getBbsById(rebbs.getBbsid());
		bbs.setRepnum("" + (Integer.parseInt(bbs.getRepnum()) + 1));
		this.bbsService.updateBbs(bbs);
		String path = "redirect:/index/readbbs.action?id=" + bbs.getBbsid();
		return path;
	}

	// 添加产品到购物车
	@RequestMapping("addcart.action")
	public String addcart() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Cart cart = new Cart();
		cart.setAddtime(VeDate.getStringDateShort());
		cart.setGoodsid(getRequest().getParameter("goodsid"));
		cart.setNum(getRequest().getParameter("num"));
		cart.setPrice(getRequest().getParameter("price"));
		cart.setUsersid(userid);
		this.cartService.insertCart(cart);
		return "redirect:/index/cart.action";
	}

	// 查看购物车
	@RequestMapping("cart.action")
	public String cart() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Cart cart = new Cart();
		cart.setUsersid(userid);
		List<Cart> cartList = this.cartService.getCartByCond(cart);
		this.getRequest().setAttribute("cartList", cartList);
		return "users/cart";
	}

	// 删除购物车中的产品
	@RequestMapping("deletecart.action")
	public String deletecart(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.cartService.deleteCart(id);
		return "redirect:/index/cart.action";
	}

	// 结算
	@RequestMapping("checkout.action")
	public String checkout() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Cart cart1 = new Cart();
		cart1.setUsersid(userid);
		List<Cart> cartList = this.cartService.getCartByCond(cart1);
		if (cartList.size() == 0) {
			this.getRequest().setAttribute("message", "请选购水果");
			return "redirect:/index/cart.action";
		} else {
			for (Cart cart : cartList) {
				Goods goods = this.goodsService.getGoodsById(cart.getGoodsid());
				goods.setSellnum("" + (Integer.parseInt(goods.getSellnum()) + Integer.parseInt(cart.getNum())));
				goods.setStorage("" + (Integer.parseInt(goods.getStorage()) - Integer.parseInt(cart.getNum())));
				this.goodsService.updateGoods(goods);
				String ordercode = "PD" + VeDate.getStringId();
				double total = VeDate
						.getDouble(Double.parseDouble(cart.getNum()) * Double.parseDouble(cart.getPrice()));
				Orders orders = new Orders();
				orders.setOrdercode(ordercode);
				orders.setAddtime(VeDate.getStringDateShort());
				orders.setGoodsid(goods.getGoodsid());
				orders.setNum(cart.getNum());
				orders.setPrice(cart.getPrice());
				orders.setStatus("未退货");
				orders.setTotal("" + total);
				orders.setUsersid(cart.getUsersid());
				this.ordersService.insertOrders(orders);
				this.cartService.deleteCart(cart.getCartid());
			}
		}
		return "redirect:/index/showOrders.action";
	}

	// 查看订购
	@RequestMapping("showOrders.action")
	public String showOrders(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Orders orders = new Orders();
		orders.setUsersid(userid);
		List<Orders> tempList = this.ordersService.getOrdersByCond(orders);
		PageHelper.getIndexPage(tempList, "orders", "showOrders", null, 10, number, this.getRequest());
		return "users/orderlist";
	}

	@RequestMapping("mySell.action")
	public String mySell(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Orders orders = new Orders();
		orders.setSellerid(userid);
		List<Orders> tempList = this.ordersService.getOrdersByCond(orders);
		PageHelper.getIndexPage(tempList, "orders", "mySell", null, 10, number, this.getRequest());
		return "users/sorderlist";
	}

	@RequestMapping("send.action")
	public String send(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
		orders.setStatus("已发货");
		this.ordersService.updateOrders(orders);
		return "redirect:/index/mySell.action";
	}

	// 准备付款
	@RequestMapping("prePay.action")
	public String prePay(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.getRequest().setAttribute("id", id);
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("orders", orders);
		return "users/pay";
	}

	// 付款
	@RequestMapping("pay.action")
	public String pay(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
		orders.setStatus("已付款");
		this.ordersService.updateOrders(orders);
		return "redirect:/index/showOrders.action";
	}

	// 确认收货
	@RequestMapping("over.action")
	public String over(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
		orders.setStatus("已收货");
		this.ordersService.updateOrders(orders);
		return "redirect:/index/showOrders.action";
	}

	// 取消订单
	@RequestMapping("cancel.action")
	public String cancel(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
		orders.setStatus("已取消");
		this.ordersService.updateOrders(orders);
		return "redirect:/index/showOrders.action";
	}

	// 按分类查询
	@RequestMapping("cate.action")
	public String cate(String id, String number) {
		this.front();
		Goods goods = new Goods();
		goods.setCateid(id);
		List<Goods> tempList = this.goodsService.getGoodsByCond(goods);
		PageHelper.getIndexPage(tempList, "goods", "cate", id, 12, number, this.getRequest());
		return "users/list";
	}

	// 全部产品
	@RequestMapping("all.action")
	public String all(String number) {
		this.front();
		List<Goods> tempList = this.goodsService.getAllGoods();
		PageHelper.getIndexPage(tempList, "goods", "all", null, 12, number, this.getRequest());
		return "users/list";
	}

	// 查询水果
	@RequestMapping("query.action")
	public String query(String name) {
		this.front();
		Goods goods = new Goods();
		goods.setGoodsname(name);
		List<Goods> goodsList = this.goodsService.getGoodsByLike(goods);
		this.getRequest().setAttribute("goodsList", goodsList);
		return "users/list";
	}

	// 水果详情
	@RequestMapping("detail.action")
	public String detail(String id) {
		this.front();
		Goods goods = this.goodsService.getGoodsById(id);
		goods.setHits("" + (Integer.parseInt(goods.getHits()) + 1));
		this.goodsService.updateGoods(goods);
		this.getRequest().setAttribute("goods", goods);
		Topic topic = new Topic();
		topic.setGoodsid(id);
		List<Topic> topicList = this.topicService.getTopicByCond(topic);
		this.getRequest().setAttribute("topicList", topicList);
		this.getRequest().setAttribute("tnum", topicList.size());
		return "users/detail";
	}

	// 添加收藏
	@RequestMapping("addfav.action")
	public String addfav(Fav fav) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) getRequest().getSession().getAttribute("userid");
		fav.setAddtime(VeDate.getStringDateShort());
		fav.setGoodsid(getRequest().getParameter("id"));
		fav.setUsersid(userid);
		this.favService.insertFav(fav);
		return "redirect:/index/myfav.action";
	}

	// 我的收藏
	@RequestMapping("myfav.action")
	public String myfav(String number) {
		this.front();
		if (getRequest().getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Fav fav = new Fav();
		fav.setUsersid(userid);
		List<Fav> favList = this.favService.getFavByCond(fav);
		PageHelper.getIndexPage(favList, "fav", "myfav", null, 10, number, this.getRequest());
		return "users/myfav";
	}

	// 删除收藏
	@RequestMapping("deletefav.action")
	public String deletefav() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.favService.deleteFav(this.getRequest().getParameter("id"));
		return "redirect:/index/myfav.action";
	}

	@RequestMapping("preComplains.action")
	public String preComplains() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/addComplains";
	}

	@RequestMapping("addComplains.action")
	public String addComplains(Complains complains) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		complains.setAddtime(VeDate.getStringDateShort());
		complains.setStatus("未回复");
		complains.setUsersid(userid);
		this.complainsService.insertComplains(complains);
		return "redirect:/index/preComplains.action";
	}

	@RequestMapping("myComplains.action")
	public String myComplains(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Complains complains = new Complains();
		complains.setUsersid(userid);
		List<Complains> complainsList = this.complainsService.getComplainsByCond(complains);
		PageHelper.getIndexPage(complainsList, "complains", "myComplains", null, 10, number, this.getRequest());
		return "users/myComplains";
	}

	@RequestMapping("preGoods.action")
	public String preGoods() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/addGoods";
	}

	@RequestMapping("addGoods.action")
	public String addGoods(Goods goods) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		goods.setAddtime(VeDate.getStringDateShort());
		goods.setUsersid(userid);
		goods.setHits("0");
		goods.setSellnum("0");
		this.goodsService.insertGoods(goods);
		return "redirect:/index/preGoods.action";
	}

	@RequestMapping("myGoods.action")
	public String myGoods(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Goods goods = new Goods();
		goods.setUsersid(userid);
		List<Goods> tempList = this.goodsService.getGoodsByCond(goods);
		PageHelper.getIndexPage(tempList, "goods", "myGoods", null, 10, number, this.getRequest());
		return "users/myGoods";
	}

	@RequestMapping("preEditGoods.action")
	public String preEditGoods(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Goods goods = this.goodsService.getGoodsById(id);
		this.getRequest().setAttribute("goods", goods);
		return "users/editGoods";
	}
	
	@RequestMapping("preEdit.action")
	public String preEdit(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Goods goods = this.goodsService.getGoodsById(id);
		this.getRequest().setAttribute("goods", goods);
		return "users/editGoods";
	}

	@RequestMapping("updateGoods.action")
	public String updateGoods(Goods goods) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "redirect:/index/myGoods.action";
	}

	@RequestMapping("deleteGoods.action")
	public String deleteGoods(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.goodsService.deleteGoods(id);
		return "redirect:/index/myGoods.action";
	}

	@RequestMapping("preTopic.action")
	public String preTopic(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("id", id);
		this.getRequest().setAttribute("orders", orders);
		return "users/addTopic";
	}

	@RequestMapping("addTopic.action")
	public String addTopic(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(id);
		orders.setStatus("已退货");
		this.ordersService.updateOrders(orders);
		Topic topic = new Topic();
		topic.setAddtime(VeDate.getStringDateShort());
		topic.setUsersid(orders.getUsersid());
		topic.setGoodsid(orders.getGoodsid());
		topic.setOrdersid(orders.getOrdersid());
		topic.setNum(this.getRequest().getParameter("num"));
		topic.setContents(this.getRequest().getParameter("contents"));
		topic.setOrdersid(id);
		this.topicService.insertTopic(topic);
		return "redirect:/index/showOrders.action";
	}
}
