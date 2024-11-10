package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Rebbs;
@Service("rebbsService")
public interface RebbsService {
	// 插入数据 调用rebbsDAO里的insertRebbs配置
	public int insertRebbs(Rebbs rebbs);

	// 更新数据 调用rebbsDAO里的updateRebbs配置
	public int updateRebbs(Rebbs rebbs);

	// 删除数据 调用rebbsDAO里的deleteRebbs配置
	public int deleteRebbs(String rebbsid);

	// 查询全部数据 调用rebbsDAO里的getAllRebbs配置
	public List<Rebbs> getAllRebbs();

	// 按照Rebbs类里面的字段名称精确查询 调用rebbsDAO里的getRebbsByCond配置
	public List<Rebbs> getRebbsByCond(Rebbs rebbs);

	// 按照Rebbs类里面的字段名称模糊查询 调用rebbsDAO里的getRebbsByLike配置
	public List<Rebbs> getRebbsByLike(Rebbs rebbs);

	// 按主键查询表返回单一的Rebbs实例 调用rebbsDAO里的getRebbsById配置
	public Rebbs getRebbsById(String rebbsid);

}

