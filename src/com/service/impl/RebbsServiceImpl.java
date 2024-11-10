package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.RebbsDAO;
import com.entity.Rebbs;
import com.service.RebbsService;

@Service("rebbsService")
public class RebbsServiceImpl implements RebbsService {
	@Autowired
	private RebbsDAO rebbsDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertRebbs(Rebbs rebbs) {
		return this.rebbsDAO.insertRebbs(rebbs);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateRebbs(Rebbs rebbs) {
		return this.rebbsDAO.updateRebbs(rebbs);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteRebbs(String rebbsid) {
		return this.rebbsDAO.deleteRebbs(rebbsid);
	}

	@Override // 继承接口的查询全部
	public List<Rebbs> getAllRebbs() {
		return this.rebbsDAO.getAllRebbs();
	}

	@Override // 继承接口的按条件精确查询
	public List<Rebbs> getRebbsByCond(Rebbs rebbs) {
		return this.rebbsDAO.getRebbsByCond(rebbs);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Rebbs> getRebbsByLike(Rebbs rebbs) {
		return this.rebbsDAO.getRebbsByLike(rebbs);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Rebbs getRebbsById(String rebbsid) {
		return this.rebbsDAO.getRebbsById(rebbsid);
	}

}

