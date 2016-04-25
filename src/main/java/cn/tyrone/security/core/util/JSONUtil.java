package cn.tyrone.security.core.util;

import com.google.gson.Gson;

public class JSONUtil {
	
	/**
	 * 获取Json字符串
	 * @author Tyrone Shang
	 * @date 2016-04-21
	 * @param obj
	 * @return
	 */
	public static String getJson(Object obj) {
		if (obj != null) {
			Gson gson = new Gson();
			return gson.toJson(obj);
		}
		return null;
	}
}
