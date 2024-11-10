package com.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Complains;

@Repository("complainsDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface ComplainsDAO {

	/**
* ComplainsDAO 接口 可以按名称直接调用complains.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包complains.xml里的insertComplains配置 返回值0(失败),1(成功)
	public int insertComplains(Complains complains);

	// 更新数据 调用entity包complains.xml里的updateComplains配置 返回值0(失败),1(成功)
	public int updateComplains(Complains complains);

	// 删除数据 调用entity包complains.xml里的deleteComplains配置 返回值0(失败),1(成功)
	public int deleteComplains(String complainsid);

	// 查询全部数据 调用entity包complains.xml里的getAllComplains配置 返回List类型的数据
	public List<Complains> getAllComplains();

	// 按照Complains类里面的值精确查询 调用entity包complains.xml里的getComplainsByCond配置 返回List类型的数据
	public List<Complains> getComplainsByCond(Complains complains);

	// 按照Complains类里面的值模糊查询 调用entity包complains.xml里的getComplainsByLike配置 返回List类型的数据
	public List<Complains> getComplainsByLike(Complains complains);

	// 按主键查询表返回单一的Complains实例 调用entity包complains.xml里的getComplainsById配置
	public Complains getComplainsById(String complainsid);

}


