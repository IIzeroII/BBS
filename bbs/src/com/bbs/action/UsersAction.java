package com.bbs.action;

import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bbs.model.Users;
import com.bbs.service.UsersService;
import com.bbs.utils.ReturnData;
import com.bbs.utils.ReturnJson;
import com.opensymphony.xwork2.ModelDriven;
@Controller
//也可以自定义为：@Controller(value="users")或@Controller("usersa")，这样的话，struts中的action的class就写users,否则可以写默认的usersAction
public class UsersAction implements ModelDriven<Users>{
	private Users user = new Users();
	@Override
	public Users getModel() {
		return user;
	}
	//自动装配service
	@Resource
	private UsersService usersService;
	
	/**
	 * 登录
	 * @return
	 */
	public String login() {
		try {
			System.out.println(user);
			user = usersService.login(user);
			//设置用户在线状态
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			//保存用户信息到cookie
			Cookie cookie1 = new Cookie("userName", URLEncoder.encode(user.getUserName(), "UTF-8"));
			cookie1.setMaxAge(60*60);
			Cookie cookie2 = new Cookie("userPassword", URLEncoder.encode(user.getUserPassword(), "UTF-8"));
			cookie2.setMaxAge(60*60);
			ServletActionContext.getResponse().addCookie(cookie1);
			ServletActionContext.getResponse().addCookie(cookie2);
			
			return "index";
		} catch (Exception e) {
			//控制台输出异常
			e.printStackTrace();
			//将错误信息转发到错误提示页面
			ServletActionContext.getRequest().setAttribute("msg", e.getMessage());
			return "error";
		}
	}
	
	/**
	 * 注册
	 * @return
	 */
	public String register() {
		try {
			usersService.register(user);
			//保存用户信息到cookie
			Cookie cookie1 = new Cookie("userName",URLEncoder.encode(user.getUserName(), "UTF-8"));
			cookie1.setMaxAge(60*60);
			Cookie cookie2 = new Cookie("userPassword",URLEncoder.encode(user.getUserPassword(), "UTF-8"));
			cookie1.setMaxAge(60*60);
			ServletActionContext.getResponse().addCookie(cookie1);
			ServletActionContext.getResponse().addCookie(cookie2);
			
			return "login";
		} catch (Exception e) {
			//控制台输出异常
			e.printStackTrace();
			//将错误信息转发到错误提示页面
			ServletActionContext.getRequest().setAttribute("msg", e.getMessage());
			return "error";
		}
	}
	
	/**
	 * 列表显示
	 */
	public void list() {
		//初始化返回数据对象
		ReturnData data = new ReturnData();
		try {
			data.setList(usersService.list());
			data.setMsg("查询成功！");
			data.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			//设置错误提示
			data.setMsg(e.getMessage());
			data.setSuccess(false);
		} finally {
			//转化为Json数据，并写入到输出流
			ReturnJson.writeJSON(data, ServletActionContext.getResponse());
		}
	}
	
	/**
	 * 修改
	 */
	public void edit() {
		System.out.println(user);
		//初始化返回数据对象
		ReturnData data = new ReturnData();
		try {
			usersService.edit(user);
			data.setMsg("修改成功！");
			data.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			//设置错误提示
			data.setMsg(e.getMessage());
			data.setSuccess(false);
		} finally {
			//转化为Json数据，并写入到输出流
			ReturnJson.writeJSON(data, ServletActionContext.getResponse());
		}
	}
	
	/**
	 * 删除
	 */
	public void del() {
		//初始化返回数据对象
		ReturnData data = new ReturnData();
		try {
			usersService.del(user);
			data.setMsg("删除成功！");
			data.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			//设置错误提示
			data.setMsg(e.getMessage());
			data.setSuccess(false);
		} finally {
			//转化为Json数据，并写入到输出流
			ReturnJson.writeJSON(data, ServletActionContext.getResponse());
		}
	}
	
	/**
	 * 搜索
	 */
	public void search() {
		//初始化返回数据对象
		ReturnData data = new ReturnData();
		try {
			data.setList(usersService.search(user.getKey())); 
			data.setMsg("查询成功！");
			data.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			//设置错误提示
			data.setMsg(e.getMessage());
			data.setSuccess(false);
		} finally {
			//转化为Json数据，并写入到输出流
			ReturnJson.writeJSON(data, ServletActionContext.getResponse());
		}
	}
	
	/**
	 * 查询高权限用户
	 */
	public void findHighPower() {
		//初始化返回数据对象
		ReturnData data = new ReturnData();
		try {
			data.setList(usersService.findHighPower());
			data.setMsg("查询成功！");
			data.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			//设置错误提示
			data.setMsg(e.getMessage());
			data.setSuccess(false);
		} finally {
			//转化为Json数据，并写入到输出流
			ReturnJson.writeJSON(data, ServletActionContext.getResponse());
		}
	}
	
	/**
	 * 退出登录
	 */
	public void quit() {
		System.out.println("我在这里！");
		//初始化返回数据对象
		ReturnData data = new ReturnData();
		try {
			//从session中移除当前用户
			ServletActionContext.getRequest().getSession().removeAttribute("user");
			data.setMsg("退出成功！");
			data.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			//设置错误提示
			data.setMsg(e.getMessage());
			data.setSuccess(false);
		} finally {
			//转化为Json数据，并写入到输出流
			ReturnJson.writeJSON(data, ServletActionContext.getResponse());
		}
		
		
	}
}
