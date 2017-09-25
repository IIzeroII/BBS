package com.bbs.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbs.dao.ReplyDao;
import com.bbs.dao.TopicDao;
import com.bbs.model.Reply;
import com.bbs.model.Topic;
import com.bbs.service.ReplyService;
@Service
public class ReplyServiceImpl implements ReplyService {
	
	//自动装配DAO
	@Resource
	private ReplyDao replyDao;
	@Resource
	private TopicDao topicDao;
	
	/**
	 * 列表显示
	 */
	@Override
	public List<Reply> list(int topicId) throws Exception {
		return replyDao.findAll(topicId);
	}

	@Override
	public void edit(Reply model) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void del(Reply model) throws Exception {
		//根据ID获取reply记录
		model = replyDao.getReply(model.getReplyId());
		//根据ID获取topic记录
		Topic topic = topicDao.getTopic(model.getTopic().getTopicId());
		
		//将回帖置为删除状态，并更新数据库
		model.setStatus(0);
		replyDao.updateReply(model);
		
		//主题帖回帖数减一，并更新数据库
		topic.setReplyCount(topic.getReplyCount()-1);
		topicDao.updateTopic(topic);
	}

	@Override
	public List<Reply> search(Reply model) throws Exception {
		return replyDao.search(model);
	}

	@Override
	public void add(Reply model) throws Exception {
		//设置回帖时间
		model.setReply_time(new Date());
		//设置帖子状态
		model.setStatus(1);
		//持久化
		replyDao.saveReply(model);
		
		//更新主题帖回帖数量属性
		Topic topic = topicDao.getTopic(model.getTopic().getTopicId());
		topic.setReplyCount(topic.getReplyCount()+1);
		topicDao.updateTopic(topic);
	}

}
