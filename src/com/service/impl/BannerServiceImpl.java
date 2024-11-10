package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.BannerDAO;
import com.entity.Banner;
import com.service.BannerService;

@Service("bannerService")
public class BannerServiceImpl implements BannerService {
	@Autowired
	private BannerDAO bannerDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertBanner(Banner banner) {
		return this.bannerDAO.insertBanner(banner);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateBanner(Banner banner) {
		return this.bannerDAO.updateBanner(banner);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteBanner(String bannerid) {
		return this.bannerDAO.deleteBanner(bannerid);
	}

	@Override // 继承接口的查询全部
	public List<Banner> getAllBanner() {
		return this.bannerDAO.getAllBanner();
	}

	@Override // 继承接口的按条件精确查询
	public List<Banner> getBannerByCond(Banner banner) {
		return this.bannerDAO.getBannerByCond(banner);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Banner> getBannerByLike(Banner banner) {
		return this.bannerDAO.getBannerByLike(banner);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Banner getBannerById(String bannerid) {
		return this.bannerDAO.getBannerById(bannerid);
	}

}

