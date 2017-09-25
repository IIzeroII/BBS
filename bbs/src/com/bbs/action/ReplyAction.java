package com.bbs.action;


import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bbs.model.Reply;
import com.bbs.model.Topic;
import com.bbs.model.Users;
import com.bbs.service.ReplyService;
import com.bbs.utils.ReturnData;
import com.bbs.utils.ReturnJson;
import com.opensymphony.xwork2.ModelDriven;
@Controller
public class ReplyAction implements ModelDriven<Reply>{
	private Reply reply = new Reply();
	@Override
	public Reply getModel() {
		return reply;
	}

	//自动装配service
	@Resource
	private ReplyService replyService;
	
	/**
	 * 列表显示
	 */
	public void list() {
		//初始化返回数据对象
		ReturnData data = new ReturnData();
		try {
			//获取版块ID
			int topicId = Integer.parseInt(ServletActionContext.getRequest().getParameter("topicId"));
			data.setList(replyService.list(topicId));
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
			String topic = ServletActionContext.getRequest().getParameter("topic");
			reply.setTopic(JSONObject.parseObject(topic, Topic.class));
			data.setList(replyService.search(reply));
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
	 * 新增回帖
	 */
	public void add() {  //replyContent 回帖内容 、topic 主题帖、user 用户、reply_time 回帖时间、status 回帖状态
		//初始化返回数据对象
		ReturnData data = new ReturnData();
		try {
			//反序列化JSON格式的字符串为JAVA对象
			String topic = ServletActionContext.getRequest().getParameter("topic");
			reply.setTopic(JSON.parseObject(topic, Topic.class));
			//获取当前用户
			Users user = (Users)ServletActionContext.getRequest().getSession().getAttribute("user");
			reply.setUser(user);
			replyService.add(reply);
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
			replyService.del(reply);
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
