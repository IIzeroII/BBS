package com.bbs.service;

import java.util.List;

import com.bbs.model.Users;

public interface UsersService {
	/**
	 * 登录
	 * @param model
	 * @return
	 * @throws Exception
	 */
	 Users login(Users model) throws Exception;
	 /**
	  * 注册
	  * @param model
	  * @throws Exception
	  */
	 void register(Users model) throws Exception;
	 /**
	  * 查询所有
	  * @return
	  * @throws Exception
	  */
	 List<Users> list() throws Exception;
	 /**
	  * 查询高权限用户
	  * @return
	  * @throws Exception
	  */
	 List<Users> findHighPower() throws Exception;
	 /**
	  * 修改
	  * @param model
	  * @throws Exception
	  */
	 void edit(Users model) throws Exception;
	 /**
	  * 删除
	  * @param model
	  * @throws Exception
	  */
	 void del(Users model) throws Exception;
	 /**
	  * 搜索
	  * @param key 关键字
	  * @return
	  * @throws Exception
	  */
	 List<Users> search(String key) throws Exception;
}
