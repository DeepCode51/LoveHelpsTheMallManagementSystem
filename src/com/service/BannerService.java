package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Banner;
@Service("bannerService")
public interface BannerService {
	// 插入数据 调用bannerDAO里的insertBanner配置
	public int insertBanner(Banner banner);

	// 更新数据 调用bannerDAO里的updateBanner配置
	public int updateBanner(Banner banner);

	// 删除数据 调用bannerDAO里的deleteBanner配置
	public int deleteBanner(String bannerid);

	// 查询全部数据 调用bannerDAO里的getAllBanner配置
	public List<Banner> getAllBanner();

	// 按照Banner类里面的字段名称精确查询 调用bannerDAO里的getBannerByCond配置
	public List<Banner> getBannerByCond(Banner banner);

	// 按照Banner类里面的字段名称模糊查询 调用bannerDAO里的getBannerByLike配置
	public List<Banner> getBannerByLike(Banner banner);

	// 按主键查询表返回单一的Banner实例 调用bannerDAO里的getBannerById配置
	public Banner getBannerById(String bannerid);

}

