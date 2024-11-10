package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Goods;

@Service("goodsService")
public interface GoodsService {
	// 插入数据 调用goodsDAO里的insertGoods配置
	public int insertGoods(Goods goods);

	// 更新数据 调用goodsDAO里的updateGoods配置
	public int updateGoods(Goods goods);

	// 删除数据 调用goodsDAO里的deleteGoods配置
	public int deleteGoods(String goodsid);

	// 查询全部数据 调用goodsDAO里的getAllGoods配置
	public List<Goods> getAllGoods();

	public List<Goods> getGoodsByNews();

	public List<Goods> getGoodsByHot();

	public List<Goods> getGoodsByCate(String cateid);

	// 按照Goods类里面的字段名称精确查询 调用goodsDAO里的getGoodsByCond配置
	public List<Goods> getGoodsByCond(Goods goods);

	// 按照Goods类里面的字段名称模糊查询 调用goodsDAO里的getGoodsByLike配置
	public List<Goods> getGoodsByLike(Goods goods);

	// 按主键查询表返回单一的Goods实例 调用goodsDAO里的getGoodsById配置
	public Goods getGoodsById(String goodsid);

}
