package cn.tyrone.security.core.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 用于解析properties文件的util
 * @author sls
 *
 */
public class PropertiesUtil {
	private static Properties properties = null;
	
	/**
	 * 获取指定properties文件指定key的value值
	 * @param key properties的key值
	 * @param propertyName properties 文件名称
	 * @return 返回value值
	 */
	public static String getValue(String propertyName,String key) {
		try{
			if(properties == null){
				properties = new Properties();				
			}
			properties.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(propertyName), "UTF-8"));
		}catch(IOException e){
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}
}
