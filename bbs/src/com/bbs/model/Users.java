package com.bbs.model;

import java.io.Serializable;
import java.util.List;

public class Users implements Serializable{
	private Integer userId;  //用户ID
	private String userName;  //用户名
	private String userPassword;  //用户密码
	private Integer status;  //用户状态(权限分级)
	private List<Section> sectionList;  //版块
	private List<Topic> topicList;  //主题帖
	private List<Reply> replyList;  //回帖
	
	private String key;  //关键字
	
	public Users() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Section> getSectionList() {
		return sectionList;
	}

	public void setSectionList(List<Section> sectionList) {
		this.sectionList = sectionList;
	}

	public List<Topic> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", status="
				+ status + ", sectionList=" + sectionList + ", topicList=" + topicList + ", replyList=" + replyList
				+ ", key=" + key + "]";
	}
	
	
}
