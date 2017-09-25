package com.bbs.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 封装关于原生HTTP的对象的操作
 *  
 *
 */
public class ReturnJson {

	/**
	 * 返回一个json对象
	 * 
	 * @param o
	 */
	public static void writeJSON(Object o, HttpServletResponse response) {
		if(null == o){
			return;
		}
		PrintWriter pt = null;
		try {
			// 获取输出流
			pt = response.getWriter();
			// 序列化，将java对象转化为符合json格式的字符串
			String json = JSON.toJSONStringWithDateFormat(o,
					"yyyy-MM-dd HH:mm:ss",
					SerializerFeature.DisableCircularReferenceDetect);
			// 写入对象
			pt.write(json);
			pt.flush();
			pt.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭
			pt.close();
		}
	}

}
