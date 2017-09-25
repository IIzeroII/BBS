package com.bbs.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ReturnData implements Serializable{
	private String msg = "消息为初始化！";
	private Boolean success = false;
	private Object obj = new Object();
	private List list = new ArrayList();
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public ReturnData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReturnData(String msg, Boolean success, Object obj, List list) {
		super();
		this.msg = msg;
		this.success = success;
		this.obj = obj;
		this.list = list;
	}
	@Override
	public String toString() {
		return "ReturnData [msg=" + msg + ", success=" + success + ", obj="
				+ obj + ", list=" + list + "]";
	}
	
	
}
