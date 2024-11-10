package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.FavDAO;
import com.entity.Fav;
import com.service.FavService;

@Service("favService")
public class FavServiceImpl implements FavService {
	@Autowired
	private FavDAO favDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertFav(Fav fav) {
		return this.favDAO.insertFav(fav);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateFav(Fav fav) {
		return this.favDAO.updateFav(fav);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteFav(String favid) {
		return this.favDAO.deleteFav(favid);
	}

	@Override // 继承接口的查询全部
	public List<Fav> getAllFav() {
		return this.favDAO.getAllFav();
	}

	@Override // 继承接口的按条件精确查询
	public List<Fav> getFavByCond(Fav fav) {
		return this.favDAO.getFavByCond(fav);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Fav> getFavByLike(Fav fav) {
		return this.favDAO.getFavByLike(fav);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Fav getFavById(String favid) {
		return this.favDAO.getFavById(favid);
	}

}

