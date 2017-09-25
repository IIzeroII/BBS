package com.bbs.service;

import java.util.List;

import com.bbs.model.Reply;

public interface ReplyService {
	/**
	  * 查询主题帖下所有回帖
	  * @param topicId  主题帖ID
	  * @return
	  * @throws Exception
	  */
	 List<Reply> list(int topicId) throws Exception;
	 /**
	  * 修改
	  * @param model
	  * @throws Exception
	  */
	 void edit(Reply model) throws Exception;
	 /**
	  * 删除
	  * @param model
	  * @throws Exception
	  */
	 void del(Reply model) throws Exception;
	 /**
	  * 搜索
	  * @param model 
	  * @return
	  * @throws Exception
	  */
	 List<Reply> search(Reply model) throws Exception;
	 /**
	  * 新增
	  * @param model
	  * @throws Exception
	  */
	 void add(Reply model) throws Exception;
}
