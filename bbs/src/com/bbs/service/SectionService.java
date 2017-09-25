package com.bbs.service;

import java.util.List;

import com.bbs.model.Section;

public interface SectionService {
	 /**
	  * 查询所有
	  * @return
	  * @throws Exception
	  */
	 List<Section> list() throws Exception;
	 /**
	  * 修改
	  * @param model
	  * @throws Exception
	  */
	 void edit(Section model) throws Exception;
	 /**
	  * 删除
	  * @param model
	  * @throws Exception
	  */
	 void del(Section model) throws Exception;
	 /**
	  * 搜索
	  * @param key 关键字
	  * @return
	  * @throws Exception
	  */
	 List<Section> search(String key) throws Exception;
}
