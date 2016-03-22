package cn.tyrone.security.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 字符串工具类
 * @author Tyrone.Shang
 *
 */
public class StringUtil {
	
	/**
	 * 生成指定位数的随机数且该随机数不存在指定集合中
	 * @author Tyrone.Shang
	 * @date 2016-03-22
	 * @param num 指定的位数，如果小于等于0，默认为1
	 * @return
	 */
	public static String getRandomCode(List<String> codes,int num){
		
		String randomCode = getRandomCode(num);
		
		if(codes != null && codes.size() > 0){
			if(codes.contains(randomCode)){
				getRandomCode(codes, num);
			}
		}
		
		return randomCode;
	}
	
	/**
	 * 生成指定位数的随机数
	 * @author Tyrone.Shang
	 * @date 2016-03-22
	 * @param num 指定的位数，如果小于等于0，默认为1
	 * @return
	 */
	public static String getRandomCode(int num){
		
		String randomCode = "";
		
		Random random = new Random();
		
		num = num <= 0 ? 1 : num;
		
		for(int i = 0 ; i < num; i ++){
			randomCode += random.nextInt(10);
		}
		
		return randomCode;
	}
	
	
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
	
	public static void main(String[] args) {
		
		List<String> codes = new ArrayList<String>();
		codes.add("001");
		codes.add("100");
		codes.add("112");
		
		String randomCode = getRandomCode(codes,-1);
		System.out.println(randomCode);
	}
	
}
