package com.zhangjiawei;

import java.util.Random;

/** 

* @author ���� zjw: 

* @version ����ʱ�䣺2019��11��18�� ����10:30:12 

*/
public class RandomUtil {
	
	/**
	 * ������ɳ���Ϊ40�������ַ���
	 * @param n
	 * @return
	 */
	private static int getRandomNumber(int n) {
		Random random = new Random();
		int r = random.nextInt(100000);
		return r;
	}
	
	/**
	 * ������ɳ���Ϊ11�������ַ���
	 * @param n
	 * @return
	 */
	private static int getRandomNumber2(int n) {
		Random random = new Random();
		int r = random.nextInt(11);
		return r;
	}
	
	/**
	 * ������ɳ���Ϊ11�������ַ���
	 * @param n
	 * @return
	 */
	public static int getTid(int n) {
		Random random = new Random();
		int r = random.nextInt(11);
		return r+1;
	}
	
	public static int getCapital() {
		int i = getRandomNumber(1);
		
		if (i<10000) {
			i=10000;
			return i;
		}else {
			return i;
		}
	}
	
	public static String getRegist_no() {
		String str = "1101";
		for (int j = 1; j <= 8; j++) {
			int i = getRandomNumber2(1);
			str = str+i;
		}
		
		return str;
	}
}
