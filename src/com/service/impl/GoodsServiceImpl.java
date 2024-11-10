package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.GoodsDAO;
import com.entity.Goods;
import com.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDAO goodsDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertGoods(Goods goods) {
		return this.goodsDAO.insertGoods(goods);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateGoods(Goods goods) {
		return this.goodsDAO.updateGoods(goods);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteGoods(String goodsid) {
		return this.goodsDAO.deleteGoods(goodsid);
	}

	@Override // 继承接口的查询全部
	public List<Goods> getAllGoods() {
		return this.goodsDAO.getAllGoods();
	}

	@Override // 继承接口的查询全部
	public List<Goods> getGoodsByCate(String cateid) {
		return this.goodsDAO.getGoodsByCate(cateid);
	}

	@Override // 继承接口的查询全部
	public List<Goods> getGoodsByNews() {
		return this.goodsDAO.getGoodsByNews();
	}

	@Override // 继承接口的查询全部
	public List<Goods> getGoodsByHot() {
		return this.goodsDAO.getGoodsByHot();
	}

	@Override // 继承接口的按条件精确查询
	public List<Goods> getGoodsByCond(Goods goods) {
		return this.goodsDAO.getGoodsByCond(goods);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Goods> getGoodsByLike(Goods goods) {
		return this.goodsDAO.getGoodsByLike(goods);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Goods getGoodsById(String goodsid) {
		return this.goodsDAO.getGoodsById(goodsid);
	}

}

// 
