package com.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Fav;

@Repository("favDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface FavDAO {

	/**
* FavDAO 接口 可以按名称直接调用fav.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包fav.xml里的insertFav配置 返回值0(失败),1(成功)
	public int insertFav(Fav fav);

	// 更新数据 调用entity包fav.xml里的updateFav配置 返回值0(失败),1(成功)
	public int updateFav(Fav fav);

	// 删除数据 调用entity包fav.xml里的deleteFav配置 返回值0(失败),1(成功)
	public int deleteFav(String favid);

	// 查询全部数据 调用entity包fav.xml里的getAllFav配置 返回List类型的数据
	public List<Fav> getAllFav();

	// 按照Fav类里面的值精确查询 调用entity包fav.xml里的getFavByCond配置 返回List类型的数据
	public List<Fav> getFavByCond(Fav fav);

	// 按照Fav类里面的值模糊查询 调用entity包fav.xml里的getFavByLike配置 返回List类型的数据
	public List<Fav> getFavByLike(Fav fav);

	// 按主键查询表返回单一的Fav实例 调用entity包fav.xml里的getFavById配置
	public Fav getFavById(String favid);

}


