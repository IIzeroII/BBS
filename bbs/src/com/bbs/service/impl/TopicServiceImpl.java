package com.bbs.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbs.dao.SectionDao;
import com.bbs.dao.TopicDao;
import com.bbs.model.Section;
import com.bbs.model.Topic;
import com.bbs.service.TopicService;
@Service
public class TopicServiceImpl implements TopicService {
	//自动装配DAO
	@Resource
	private TopicDao topicDao;
	@Resource
	private SectionDao sectionDao;

	/**
	 * 查询版块下所有
	 */
	@Override
	public List<Topic> list(int sectionId) throws Exception {
		return topicDao.findAll(sectionId);
	}

	/**
	 * 修改
	 */
	@Override
	public void edit(Topic model) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 删除
	 */
	@Override
	public void del(Topic model) throws Exception {
		//将主题帖置为删除状态
		model = topicDao.getTopic(model.getTopicId());
		model.setStatus(0);
		//更新数据库
		topicDao.updateTopic(model);
		//版块下主题帖数减一
		Section section = sectionDao.getSection(model.getSection().getSectionId());
		section.setTopicCount(section.getTopicCount()-1);
		//更新数据库
		sectionDao.updateSection(section);
		
	}

	/**
	 * 搜索
	 */
	@Override
	public List<Topic> search(Topic model) throws Exception {
		return topicDao.search(model);
	}

	/**
	 * 新增
	 */
	@Override
	public void add(Topic model) throws Exception {
		//设置回帖数
		model.setReplyCount(0);
		
		//设置发帖时间(当前时间)
		Date date = new Date();
		/*mybatis自动转换格式，不需要format
		 * SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		format.format(date);*/
		model.setPost_time(date);
		
		//设置帖子状态
		model.setStatus(1);
		
		//持久化
		topicDao.saveTopic(model);
		
		//更新主题帖数
		Section section = sectionDao.getSection(model.getSection().getSectionId());
		section.setTopicCount(section.getTopicCount()+1);
		sectionDao.updateSection(section);
	}
	
}
