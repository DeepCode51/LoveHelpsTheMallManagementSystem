package com.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Bbs;

@Repository("bbsDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface BbsDAO {

	/**
* BbsDAO 接口 可以按名称直接调用bbs.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包bbs.xml里的insertBbs配置 返回值0(失败),1(成功)
	public int insertBbs(Bbs bbs);

	// 更新数据 调用entity包bbs.xml里的updateBbs配置 返回值0(失败),1(成功)
	public int updateBbs(Bbs bbs);

	// 删除数据 调用entity包bbs.xml里的deleteBbs配置 返回值0(失败),1(成功)
	public int deleteBbs(String bbsid);

	// 查询全部数据 调用entity包bbs.xml里的getAllBbs配置 返回List类型的数据
	public List<Bbs> getAllBbs();

	// 按照Bbs类里面的值精确查询 调用entity包bbs.xml里的getBbsByCond配置 返回List类型的数据
	public List<Bbs> getBbsByCond(Bbs bbs);

	// 按照Bbs类里面的值模糊查询 调用entity包bbs.xml里的getBbsByLike配置 返回List类型的数据
	public List<Bbs> getBbsByLike(Bbs bbs);

	// 按主键查询表返回单一的Bbs实例 调用entity包bbs.xml里的getBbsById配置
	public Bbs getBbsById(String bbsid);

}


