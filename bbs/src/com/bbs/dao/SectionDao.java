package com.bbs.dao;

import java.util.List;

import com.bbs.model.Section;

public interface SectionDao {
	/**
	 * 根据ID查询单条记录
	 * @param id
	 * @return
	 */
	Section getSection(int id);
	
	/**
	 * 查询所有记录
	 * @return
	 */
	List<Section> findAll();
	
	/**
	 * 根据关键字搜索
	 * @param key
	 * @return
	 */
	List<Section> search(String key);
	
	/**
	 * 插入一条记录,并自动将自增主键赋给对象的指定属性
	 * @param section
	 * @return
	 */
	int saveSection(Section section);
	
	/**
	 * 修改一条记录
	 * @param section
	 * @return
	 */
	int updateSection(Section section);
	
	/**
	 * 删除一条记录
	 * @param id
	 * @return
	 */
	int deleteSection(int id);
}
