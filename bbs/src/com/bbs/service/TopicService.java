package com.bbs.service;

import java.util.List;

import com.bbs.model.Topic;

public interface TopicService {
	 /**
	  * 查询版块下所有
	  * @param sectionId  版块ID
	  * @return
	  * @throws Exception
	  */
	 List<Topic> list(int sectionId) throws Exception;
	 /**
	  * 修改
	  * @param model
	  * @throws Exception
	  */
	 void edit(Topic model) throws Exception;
	 /**
	  * 删除
	  * @param model
	  * @throws Exception
	  */
	 void del(Topic model) throws Exception;
	 /**
	  * 搜索
	  * @param model 
	  * @return
	  * @throws Exception
	  */
	 List<Topic> search(Topic model) throws Exception;
	 /**
	  * 新增
	  * @param model
	  * @throws Exception
	  */
	 void add(Topic model) throws Exception;
}
