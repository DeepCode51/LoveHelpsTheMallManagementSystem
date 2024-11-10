package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Fav;
@Service("favService")
public interface FavService {
	// 插入数据 调用favDAO里的insertFav配置
	public int insertFav(Fav fav);

	// 更新数据 调用favDAO里的updateFav配置
	public int updateFav(Fav fav);

	// 删除数据 调用favDAO里的deleteFav配置
	public int deleteFav(String favid);

	// 查询全部数据 调用favDAO里的getAllFav配置
	public List<Fav> getAllFav();

	// 按照Fav类里面的字段名称精确查询 调用favDAO里的getFavByCond配置
	public List<Fav> getFavByCond(Fav fav);

	// 按照Fav类里面的字段名称模糊查询 调用favDAO里的getFavByLike配置
	public List<Fav> getFavByLike(Fav fav);

	// 按主键查询表返回单一的Fav实例 调用favDAO里的getFavById配置
	public Fav getFavById(String favid);

}

