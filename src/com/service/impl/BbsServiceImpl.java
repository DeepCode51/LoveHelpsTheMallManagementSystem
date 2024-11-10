package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.BbsDAO;
import com.entity.Bbs;
import com.service.BbsService;

@Service("bbsService")
public class BbsServiceImpl implements BbsService {
	@Autowired
	private BbsDAO bbsDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertBbs(Bbs bbs) {
		return this.bbsDAO.insertBbs(bbs);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateBbs(Bbs bbs) {
		return this.bbsDAO.updateBbs(bbs);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteBbs(String bbsid) {
		return this.bbsDAO.deleteBbs(bbsid);
	}

	@Override // 继承接口的查询全部
	public List<Bbs> getAllBbs() {
		return this.bbsDAO.getAllBbs();
	}

	@Override // 继承接口的按条件精确查询
	public List<Bbs> getBbsByCond(Bbs bbs) {
		return this.bbsDAO.getBbsByCond(bbs);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Bbs> getBbsByLike(Bbs bbs) {
		return this.bbsDAO.getBbsByLike(bbs);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Bbs getBbsById(String bbsid) {
		return this.bbsDAO.getBbsById(bbsid);
	}

}

