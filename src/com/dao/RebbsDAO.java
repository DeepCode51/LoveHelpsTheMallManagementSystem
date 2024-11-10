package com.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Rebbs;

@Repository("rebbsDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface RebbsDAO {

	/**
* RebbsDAO 接口 可以按名称直接调用rebbs.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包rebbs.xml里的insertRebbs配置 返回值0(失败),1(成功)
	public int insertRebbs(Rebbs rebbs);

	// 更新数据 调用entity包rebbs.xml里的updateRebbs配置 返回值0(失败),1(成功)
	public int updateRebbs(Rebbs rebbs);

	// 删除数据 调用entity包rebbs.xml里的deleteRebbs配置 返回值0(失败),1(成功)
	public int deleteRebbs(String rebbsid);

	// 查询全部数据 调用entity包rebbs.xml里的getAllRebbs配置 返回List类型的数据
	public List<Rebbs> getAllRebbs();

	// 按照Rebbs类里面的值精确查询 调用entity包rebbs.xml里的getRebbsByCond配置 返回List类型的数据
	public List<Rebbs> getRebbsByCond(Rebbs rebbs);

	// 按照Rebbs类里面的值模糊查询 调用entity包rebbs.xml里的getRebbsByLike配置 返回List类型的数据
	public List<Rebbs> getRebbsByLike(Rebbs rebbs);

	// 按主键查询表返回单一的Rebbs实例 调用entity包rebbs.xml里的getRebbsById配置
	public Rebbs getRebbsById(String rebbsid);

}


