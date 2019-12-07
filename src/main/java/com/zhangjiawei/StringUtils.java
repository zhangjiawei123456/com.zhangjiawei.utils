package com.zhangjiawei;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author zhuzg
 *
 */
public class StringUtils {
	
	/**
	 * 判断一个字符串是否为空，空字符串也认为是空
	 * @param str
	 * @return 为空返回true，否则返回false
	 */
	public static boolean isBlank(String str) {
		
		return (str == null|| str.trim().equals(""));
	}
	
	public static String generateChineseName() {
		return getRandomCn(3);
	}
	
	/**
	 *  判断一个字符串是否有值
	 * @param str 非空返回的是true 空或字符串返回false
	 * @return
	 */
	public static boolean haveValue(String str) {
		
		return !(str == null|| str.trim().equals(""));
	}
	
	/**
	 * 是否电话
	 * @return
	 */
	public static boolean isMobile(String str) {
		
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		Pattern p =  Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		return matcher.find();
			
	}
	
	/**
	 * 是否邮件
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		
		String regex="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		Pattern p =  Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		return matcher.find();
		
	}
	
	
	
	/**
	 * 验证是否是URL
	 * @param url
	 * @return
	 */
	public static boolean isHttpUrl(String str){
		
		 //转换为小写
        str = str.toLowerCase();
        String regex = "^((https|http|ftp|rtsp|mms)?://)"  //https、http、ftp、rtsp、mms
                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
               + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 例如：199.194.52.184               
                 + "|" // 允许IP和DOMAIN（域名） 或单域名
                 + "[0-9a-z]*"  // 或单域名
                 + "|" // 允许IP和DOMAIN（域名） 或单域名
                 + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.  
                 + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名  
                + "[a-z]{2,6})" // first level domain- .com or .museum  
                + "(:[0-9]{1,5})?" // 端口号最大为65535,5位数
                + "((/?)|" // a slash isn't required if there is no file name  
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
        return  str.matches(regex);	
	}
	
	/**
	 * 获取  长度为n的  随机字符串
	 * 大写字母   
	 */
	public static String getRandomStr(int n) {
		
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			char c = (char)('A' +  random.nextInt(26));
			sb.append(c);
		}
		return sb.toString();
	}
	
	/**
	 * 获取随机字符串  仅仅包含字符串
	 * @param n
	 * @return
	 */
public static String getRandomNumber(int n) {
		
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			char c = (char)('0' +  random.nextInt(10));
			sb.append(c);
		}
		return sb.toString();
	}
	
	/**
	 * 随机字符串  仅仅包含大写字母 和 数字  生成的长度为  n
	 */
	public static String getRandomStr2(int n) {
		
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			int r = random.nextInt(36);
			if(r<26) {
				char c = (char)('A' +  r );
				sb.append(c);
			}else {
				sb.append(r-26);
			}
			
		}
		return sb.toString();
	}
	
	/**
	 * 生成长度为n 的中文字符串
	 * @return
	 */
	public static String getRandomCn(int n ) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(getRandomCn());
		}
		return sb.toString();
	}
	
	
	/**
	 * 生成一个随机的中文字符串 
	 * @return
	 */
	private static char getRandomCn() {
		
		String str = "";
        int hightPos; //
        int lowPos;
        Random random = new Random();

        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出现异常");
        }

        return str.charAt(0);
	}
}
