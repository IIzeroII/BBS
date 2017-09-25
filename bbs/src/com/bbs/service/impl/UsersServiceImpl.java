package com.bbs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbs.dao.SectionDao;
import com.bbs.dao.UsersDao;
import com.bbs.model.Section;
import com.bbs.model.Users;
import com.bbs.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	//自动装配DAO
	@Resource
	private UsersDao usersDao;
	@Resource
	private SectionDao sectionDao;

	/**
	 * 登录
	 */
	@Override
	public Users login(Users model) throws Exception {
		//根据用户名查询数据库
		Users user = usersDao.getUserByName(model.getUserName());
		if(null == user) {
			throw new Exception("该用户不存在！");
		}
		if(!user.getUserPassword().equals(model.getUserPassword())) {
			throw new Exception("密码错误！");
		}
		return user;
	}

	/**
	 * 注册
	 */
	@Override
	public void register(Users model) throws Exception {
		Users user = usersDao.getUserByName(model.getUserName());
		if(null != user) {
			throw new Exception("该用户已存在！");
		}
		//设置权限为普通用户
		model.setStatus(3);
		//保存用户信息到数据库
		usersDao.saveUser(model);
	}

	/**
	 * 列表显示
	 */
	@Override
	public List<Users> list() throws Exception {
		return usersDao.findAll();
	}

	/**
	 * 修改
	 */
	@Override
	public void edit(Users model) throws Exception {
		usersDao.updateUser(model);
	}

	/**
	 * 删除
	 */
	@Override
	public void del(Users model) throws Exception {
		Users user = usersDao.getUserById(model.getUserId());
		//将关联版块置为删除状态
		List<Section> sectionList = user.getSectionList();
		if(null != sectionList) {
			for(Section section : sectionList) {
				section.setStatus(0);
				sectionDao.updateSection(section);
			}
		}
		//将用户置为删除状态
		user.setStatus(0);
		usersDao.updateUser(user);
		
	}

	/**
	 * 搜索
	 */
	@Override
	public List<Users> search(String key) throws Exception {
		return usersDao.search(key);
	}

	/**
	 * 查询高权限用户
	 */
	@Override
	public List<Users> findHighPower() throws Exception {
		return usersDao.findHighPower();
	}

	
	 
}
