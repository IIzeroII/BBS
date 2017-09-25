package com.bbs.dao;

import java.util.List;

import com.bbs.model.Topic;

public interface TopicDao {
	/**
	 * 根据ID查询单条记录
	 * @param id
	 * @return
	 */
	Topic getTopic(int id);
	
	/**
	 * 查询所有记录
	 * @sectionId
	 * @return
	 */
	List<Topic> findAll(int sectionId);
	
	/**
	 * 根据关键字搜索
	 * @param topic
	 * @return
	 */
	List<Topic> search(Topic topic);
	
	/**
	 * 插入一条记录,并自动将自增主键赋给对象的指定属性
	 * @param topic
	 * @return
	 */
	int saveTopic(Topic topic);
	
	/**
	 * 修改一条记录
	 * @param topic
	 * @return
	 */
	int updateTopic(Topic topic);
	
	/**
	 * 删除一条记录
	 * @param id
	 * @return
	 */
	int deleteTopic(int id);
}
