package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Complains;
@Service("complainsService")
public interface ComplainsService {
	// 插入数据 调用complainsDAO里的insertComplains配置
	public int insertComplains(Complains complains);

	// 更新数据 调用complainsDAO里的updateComplains配置
	public int updateComplains(Complains complains);

	// 删除数据 调用complainsDAO里的deleteComplains配置
	public int deleteComplains(String complainsid);

	// 查询全部数据 调用complainsDAO里的getAllComplains配置
	public List<Complains> getAllComplains();

	// 按照Complains类里面的字段名称精确查询 调用complainsDAO里的getComplainsByCond配置
	public List<Complains> getComplainsByCond(Complains complains);

	// 按照Complains类里面的字段名称模糊查询 调用complainsDAO里的getComplainsByLike配置
	public List<Complains> getComplainsByLike(Complains complains);

	// 按主键查询表返回单一的Complains实例 调用complainsDAO里的getComplainsById配置
	public Complains getComplainsById(String complainsid);

}

