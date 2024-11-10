package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Topic;
@Service("topicService")
public interface TopicService {
	// 插入数据 调用topicDAO里的insertTopic配置
	public int insertTopic(Topic topic);

	// 更新数据 调用topicDAO里的updateTopic配置
	public int updateTopic(Topic topic);

	// 删除数据 调用topicDAO里的deleteTopic配置
	public int deleteTopic(String topicid);

	// 查询全部数据 调用topicDAO里的getAllTopic配置
	public List<Topic> getAllTopic();

	// 按照Topic类里面的字段名称精确查询 调用topicDAO里的getTopicByCond配置
	public List<Topic> getTopicByCond(Topic topic);

	// 按照Topic类里面的字段名称模糊查询 调用topicDAO里的getTopicByLike配置
	public List<Topic> getTopicByLike(Topic topic);

	// 按主键查询表返回单一的Topic实例 调用topicDAO里的getTopicById配置
	public Topic getTopicById(String topicid);

}

