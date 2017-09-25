package com.bbs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbs.dao.SectionDao;
import com.bbs.model.Section;
import com.bbs.service.SectionService;
@Service
public class SectionServiceImpl implements SectionService {

	//自动装配DAO
	@Resource
	private SectionDao sectionDao;
	
	/**
	 * 查询所有
	 */
	@Override
	public List<Section> list() throws Exception {
		return sectionDao.findAll();
	}

	/**
	 * 编辑
	 */
	@Override
	public void edit(Section model) throws Exception {
		sectionDao.updateSection(model);
	}

	/**
	 * 删除
	 */
	@Override
	public void del(Section model) throws Exception {
		Section section = sectionDao.getSection(model.getSectionId());
		//将版块置为删除状态
		section.setStatus(0);
		sectionDao.updateSection(section);
	}

	/**
	 * 搜索
	 */
	@Override
	public List<Section> search(String key) throws Exception {
		return sectionDao.search(key);
	}

}
