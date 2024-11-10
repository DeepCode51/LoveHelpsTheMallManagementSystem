package com.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Banner;

@Repository("bannerDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface BannerDAO {

	/**
* BannerDAO 接口 可以按名称直接调用banner.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包banner.xml里的insertBanner配置 返回值0(失败),1(成功)
	public int insertBanner(Banner banner);

	// 更新数据 调用entity包banner.xml里的updateBanner配置 返回值0(失败),1(成功)
	public int updateBanner(Banner banner);

	// 删除数据 调用entity包banner.xml里的deleteBanner配置 返回值0(失败),1(成功)
	public int deleteBanner(String bannerid);

	// 查询全部数据 调用entity包banner.xml里的getAllBanner配置 返回List类型的数据
	public List<Banner> getAllBanner();

	// 按照Banner类里面的值精确查询 调用entity包banner.xml里的getBannerByCond配置 返回List类型的数据
	public List<Banner> getBannerByCond(Banner banner);

	// 按照Banner类里面的值模糊查询 调用entity包banner.xml里的getBannerByLike配置 返回List类型的数据
	public List<Banner> getBannerByLike(Banner banner);

	// 按主键查询表返回单一的Banner实例 调用entity包banner.xml里的getBannerById配置
	public Banner getBannerById(String bannerid);

}


