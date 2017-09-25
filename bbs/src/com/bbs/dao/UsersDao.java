package com.bbs.dao;

import java.util.List;

import com.bbs.model.Users;

public interface UsersDao {

	/**
	 * 根据ID查询单条记录
	 * @param id
	 * @return
	 */
	Users getUserById(int id);
	
	/**
	 * 根据uName查询单条记录
	 * @param name
	 * @return
	 */
	Users getUserByName(String name);
	
	/**
	 * 查询所有记录
	 * @return
	 */
	List<Users> findAll();
	
	/**
	 * 根据关键字搜索
	 * @param key
	 * @return
	 */
	List<Users> search(String key);
	
	/**
	 * 查询所有高权限用户
	 * @return
	 */
	List<Users> findHighPower();
	
	/**
	 * 插入一条记录,并自动将自增主键赋给对象的指定属性
	 * @param user
	 * @return
	 */
	int saveUser(Users user);
	
	/**
	 * 修改一条记录
	 * @param user
	 * @return
	 */
	int updateUser(Users user);
	
	/**
	 * 删除一条记录
	 * @param id
	 * @return
	 */
	int deleteUser(int id);
}
