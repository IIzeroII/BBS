package com.bbs.dao;

import java.util.List;

import com.bbs.model.Reply;

public interface ReplyDao {
	/**
	 * 根据ID查询单条记录
	 * @param id
	 * @return
	 */
	Reply getReply(int id);
	
	/**
	 * 查询所有记录
	 * @param topicId 主题帖ID
	 * @return
	 */
	List<Reply> findAll(int topicId);
	
	/**
	 * 根据关键字搜索
	 * @param reply
	 * @return
	 */
	List<Reply> search(Reply reply);
	
	/**
	 * 插入一条记录,并自动将自增主键赋给对象的指定属性
	 * @param reply
	 * @return
	 */
	int saveReply(Reply reply);
	
	/**
	 * 修改一条记录
	 * @param reply
	 * @return
	 */
	int updateReply(Reply reply);
	
	/**
	 * 删除一条记录
	 * @param id
	 * @return
	 */
	int deleteReply(int id);
}
