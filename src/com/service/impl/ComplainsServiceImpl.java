package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ComplainsDAO;
import com.entity.Complains;
import com.service.ComplainsService;

@Service("complainsService")
public class ComplainsServiceImpl implements ComplainsService {
	@Autowired
	private ComplainsDAO complainsDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertComplains(Complains complains) {
		return this.complainsDAO.insertComplains(complains);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateComplains(Complains complains) {
		return this.complainsDAO.updateComplains(complains);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteComplains(String complainsid) {
		return this.complainsDAO.deleteComplains(complainsid);
	}

	@Override // 继承接口的查询全部
	public List<Complains> getAllComplains() {
		return this.complainsDAO.getAllComplains();
	}

	@Override // 继承接口的按条件精确查询
	public List<Complains> getComplainsByCond(Complains complains) {
		return this.complainsDAO.getComplainsByCond(complains);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Complains> getComplainsByLike(Complains complains) {
		return this.complainsDAO.getComplainsByLike(complains);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Complains getComplainsById(String complainsid) {
		return this.complainsDAO.getComplainsById(complainsid);
	}

}

