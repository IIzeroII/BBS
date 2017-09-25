package com.bbs.model;

import java.io.Serializable;
import java.util.List;

public class Section implements Serializable{
	private Integer sectionId;  //版块ID
	private String sectionName;  //版块名   
	private String sectionRemarks;  //备注
	private Integer topicCount;  //主题帖数
	private Users user;  //用户
	private List<Topic> topicList;  //主题帖
	private Integer status;  //版块状态
	
	private String key;  //关键字
	
	public Section() {
		super();
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionRemarks() {
		return sectionRemarks;
	}

	public void setSectionRemarks(String sectionRemarks) {
		this.sectionRemarks = sectionRemarks;
	}

	public Integer getTopicCount() {
		return topicCount;
	}

	public void setTopicCount(Integer topicCount) {
		this.topicCount = topicCount;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Topic> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
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
		return "Section [sectionId=" + sectionId + ", sectionName=" + sectionName + ", sectionRemarks=" + sectionRemarks
				+ ", topicCount=" + topicCount + ", user=" + user + ", topicList=" + topicList + ", status=" + status
				+ ", key=" + key + "]";
	}
	
	
	
}
