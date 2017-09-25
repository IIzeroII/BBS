package com.bbs.action;


import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bbs.model.Section;
import com.bbs.model.Topic;
import com.bbs.model.Users;
import com.bbs.service.TopicService;
import com.bbs.utils.ReturnData;
import com.bbs.utils.ReturnJson;
import com.opensymphony.xwork2.ModelDriven;
@Controller
public class TopicAction  implements ModelDriven<Topic>{
	private Topic topic = new Topic();
	@Override
	public Topic getModel() {
		return topic;
	}
	//自动装配service
	@Resource
	private TopicService topicService;
	
	/**
	 * 版块下主题帖列表显示
	 */
	public void list() {
		//初始化返回数据对象
		ReturnData data = new ReturnData();
		try {
			//获取版块ID
			int sectionId = Integer.parseInt(ServletActionContext.getRequest().getParameter("sectionId"));
			data.setList(topicService.list(sectionId));
			data.setMsg("查询成功！");
			data.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			//设置错误提示
			data.setMsg(e.getMessage());
			data.setSuccess(false);
		} finally {
			//转化为Json格式的字符串，并写入到输出流
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
			//反序列化JSON格式的字符串为JAVA对象
			String section = ServletActionContext.getRequest().getParameter("section");
			topic.setSection(JSONObject.parseObject(section, Section.class));
			data.setList(topicService.search(topic));
			data.setMsg("查询成功！");
			data.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			//设置错误提示
			data.setMsg(e.getMessage());
			data.setSuccess(false);
		} finally {
			//转化为Json格式的字符串，并写入到输出流
			ReturnJson.writeJSON(data, ServletActionContext.getResponse());
		}
	}
	
	/**
	 * 新增主题帖
	 */
	public void add() {  //topicTitle topicContent replyCount sectionId userId post_time status
		//初始化返回数据对象
		ReturnData data = new ReturnData();
		try {
			//反序列化JSON格式的字符串为JAVA对象
			String section = ServletActionContext.getRequest().getParameter("section");
			topic.setSection(JSON.parseObject(section, Section.class));
			//获取当前用户
			Users user = (Users)ServletActionContext.getRequest().getSession().getAttribute("user");
			topic.setUser(user);
			topicService.add(topic);
			data.setMsg("发帖成功！");
			data.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			//设置错误提示
			data.setMsg(e.getMessage());
			data.setSuccess(false);
		} finally {
			//转化为Json格式的字符串，并写入到输出流
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
			topicService.del(topic);
			data.setMsg("删除成功！");
			data.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			//设置错误提示
			data.setMsg(e.getMessage());
			data.setSuccess(false);
		} finally {
			//转化为Json格式的字符串，并写入到输出流
			ReturnJson.writeJSON(data, ServletActionContext.getResponse());
		}
	}
}