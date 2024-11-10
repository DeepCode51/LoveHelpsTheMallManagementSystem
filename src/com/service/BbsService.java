package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Bbs;
@Service("bbsService")
public interface BbsService {
	// 插入数据 调用bbsDAO里的insertBbs配置
	public int insertBbs(Bbs bbs);

	// 更新数据 调用bbsDAO里的updateBbs配置
	public int updateBbs(Bbs bbs);

	// 删除数据 调用bbsDAO里的deleteBbs配置
	public int deleteBbs(String bbsid);

	// 查询全部数据 调用bbsDAO里的getAllBbs配置
	public List<Bbs> getAllBbs();

	// 按照Bbs类里面的字段名称精确查询 调用bbsDAO里的getBbsByCond配置
	public List<Bbs> getBbsByCond(Bbs bbs);

	// 按照Bbs类里面的字段名称模糊查询 调用bbsDAO里的getBbsByLike配置
	public List<Bbs> getBbsByLike(Bbs bbs);

	// 按主键查询表返回单一的Bbs实例 调用bbsDAO里的getBbsById配置
	public Bbs getBbsById(String bbsid);

}

