package com.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Topic;

@Repository("topicDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface TopicDAO {

	/**
* TopicDAO 接口 可以按名称直接调用topic.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包topic.xml里的insertTopic配置 返回值0(失败),1(成功)
	public int insertTopic(Topic topic);

	// 更新数据 调用entity包topic.xml里的updateTopic配置 返回值0(失败),1(成功)
	public int updateTopic(Topic topic);

	// 删除数据 调用entity包topic.xml里的deleteTopic配置 返回值0(失败),1(成功)
	public int deleteTopic(String topicid);

	// 查询全部数据 调用entity包topic.xml里的getAllTopic配置 返回List类型的数据
	public List<Topic> getAllTopic();

	// 按照Topic类里面的值精确查询 调用entity包topic.xml里的getTopicByCond配置 返回List类型的数据
	public List<Topic> getTopicByCond(Topic topic);

	// 按照Topic类里面的值模糊查询 调用entity包topic.xml里的getTopicByLike配置 返回List类型的数据
	public List<Topic> getTopicByLike(Topic topic);

	// 按主键查询表返回单一的Topic实例 调用entity包topic.xml里的getTopicById配置
	public Topic getTopicById(String topicid);

}


