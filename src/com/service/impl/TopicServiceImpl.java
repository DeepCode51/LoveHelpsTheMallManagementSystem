package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.TopicDAO;
import com.entity.Topic;
import com.service.TopicService;

@Service("topicService")
public class TopicServiceImpl implements TopicService {
	@Autowired
	private TopicDAO topicDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertTopic(Topic topic) {
		return this.topicDAO.insertTopic(topic);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateTopic(Topic topic) {
		return this.topicDAO.updateTopic(topic);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteTopic(String topicid) {
		return this.topicDAO.deleteTopic(topicid);
	}

	@Override // 继承接口的查询全部
	public List<Topic> getAllTopic() {
		return this.topicDAO.getAllTopic();
	}

	@Override // 继承接口的按条件精确查询
	public List<Topic> getTopicByCond(Topic topic) {
		return this.topicDAO.getTopicByCond(topic);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Topic> getTopicByLike(Topic topic) {
		return this.topicDAO.getTopicByLike(topic);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Topic getTopicById(String topicid) {
		return this.topicDAO.getTopicById(topicid);
	}

}

