package com.bbs.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.bbs.model.Section;
import com.bbs.model.Users;
import com.bbs.service.SectionService;
import com.bbs.utils.ReturnData;
import com.bbs.utils.ReturnJson;
import com.opensymphony.xwork2.ModelDriven;
@Controller
public class SectionAction implements ModelDriven<Section>{
	private Section section = new Section();
	
	@Override
	public Section getModel() {
		return section;
	}
	//自动装配service
	@Resource
	private SectionService sectionService;
	
	/**
	 * 列表显示
	 */
	public void list() {
		//初始化返回数据对象
		ReturnData data = new ReturnData();
		try {
			System.out.println(sectionService.list());
			data.setList(sectionService.list());
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
	 * 搜索
	 */
	public void search() {
		//初始化返回数据对象
		ReturnData data = new ReturnData();
		try {
			data.setList(sectionService.search(section.getKey()));
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
	 * 删除
	 */
	public void del() {
		//初始化返回数据对象
		ReturnData data = new ReturnData();
		try {
			sectionService.del(section);
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
	 * 修改
	 */
	public void edit() {
		//初始化返回数据对象
		ReturnData data = new ReturnData();
		try {
			//将json格式的字符串反序列化为java对象
			String user = ServletActionContext.getRequest().getParameter("user");
			section.setUser(JSONObject.parseObject(user, Users.class));
			System.out.println(section);
			sectionService.edit(section);
			data.setMsg("修改成功！");
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
