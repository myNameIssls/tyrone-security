package cn.tyrone.security.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.google.gson.Gson;

/**
 * 字符串工具类
 * @author Tyrone.Shang
 *
 */
public class StringUtil {
	
	/**
	 * 获取UUID,不加中划线
	 * @author Tyrone.Shang
	 * @date 2016-04-15
	 * @return
	 */
	public static String getUUID(){
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}
	
	/**
	 * 循环遍历codes集合，使其中的每一个元素按照SplitStr字符串的长度开始截取到最后，得出一个新的集合B
	 * 生成指定num位数的随机数b且该随机数不存在于集合B中,最后返回【SplitStr + b】
	 * @author Tyrone.Shang
	 * @date 2016-03-22
	 * @param codes
	 * @param beginSplitIndex
	 * @param num
	 * @return
	 */
	public static String getRandomCode(List<String> codes,String splitStr,int num){
		int splitIndex = splitStr == null || "".equals(splitStr) ? 0 : splitStr.length();
		List<String> tmpCodes = null;
		if(codes != null && codes.size() > 0){
			tmpCodes = new ArrayList<String>();
			for(String code : codes){
				tmpCodes.add(code.substring(splitIndex, code.length()));
			}
			return splitStr + getRandomCode(tmpCodes, num);
		}
		return splitStr + getRandomCode(num);
	}
	
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
	 * 判断字符串是否为空,且该字符串是否等于另一个字符串
	 * @author Tyrone.Shang
	 * @date 2016-03-18
	 * @param str
	 * @param a
	 * @return
	 */
	public static boolean isNotEmpty(String str,String a){
		
		if(str != null && !"".equals(str)){
			if(str.equals(a))
				return true;
		}
		return false;
		
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
		
		System.out.println(getUUID());
		
//		List<String> dictKeyList = Arrays.asList(new String[]{"001001","001002","001003"});
//		for(int i = 0 ; i < 20; i ++){
//			String randomCode = getRandomCode(dictKeyList, "001", 3);
//			System.out.println("第" + (i + 1) + "次生成：" + randomCode);
//		}
		
//		boolean notEmpty = isNotEmpty("123", "123");
//		System.out.println(notEmpty);
		
//		List<String> codes = new ArrayList<String>();
//		codes.add("001");
//		codes.add("100");
//		codes.add("112");
//		
//		String randomCode = getRandomCode(codes,-1);
//		System.out.println(randomCode);
	}
	
}
