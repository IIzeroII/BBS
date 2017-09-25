package com.bbs.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Topic implements Serializable{
	private Integer topicId;  //主题帖ID
	private String topicTitle;  //主题帖标题
	private String topicContent;  //主题帖内容
	private Integer replyCount;  //回帖数
	private Section section;  //版块
	private Users user;  //用户
	private List<Reply> replyList;  //回帖
	private Date post_time;  //发帖时间
	private Integer status ;  //主题帖状态
	
	private String key;  //关键字
	
	public Topic() {
		super();
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public String getTopicContent() {
		return topicContent;
	}

	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}

	public Date getPost_time() {
		return post_time;
	}

	public void setPost_time(Date post_time) {
		this.post_time = post_time;
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
		return "Topic [topicId=" + topicId + ", topicTitle=" + topicTitle + ", topicContent=" + topicContent
				+ ", replyCount=" + replyCount + ", section=" + section + ", user=" + user + ", replyList=" + replyList
				+ ", post_time=" + post_time + ", status=" + status + ", key=" + key + "]";
	}
	
	
	
}
