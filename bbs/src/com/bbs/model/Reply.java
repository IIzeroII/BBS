package com.bbs.model;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable{
	private Integer replyId; //回帖ID
	private String replyContent; //回帖内容
	private Topic topic;  //主题帖
	private Users user; //用户
	private Date reply_time; //回帖时间
	private Integer status; //回帖状态
	
	private String key;  //关键字
	
	public Reply() {
		super();
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Date getReply_time() {
		return reply_time;
	}

	public void setReply_time(Date reply_time) {
		this.reply_time = reply_time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", replyContent=" + replyContent + ", topic=" + topic + ", user=" + user
				+ ", reply_time=" + reply_time + ", status=" + status + ", key=" + key + "]";
	}

	
	
}
