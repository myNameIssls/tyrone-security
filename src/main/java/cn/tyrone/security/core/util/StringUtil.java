package cn.tyrone.security.core.util;

/**
 * 字符串工具类
 * @author Tyrone.Shang
 *
 */
public class StringUtil {
	
	/**
	 * 判断字符串是否为空
	 * @author Tyrone.Shang
	 * @date 2016-03-18
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if(str != null && !"".equals(str)){
			return true;
		}
		return false;
	}
}
