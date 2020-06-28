package com.everything.demo.util;

import org.apache.commons.lang3.StringUtils;

public class SignUtils {
    private static final char LEFT_BRACKET = '【';
    private static final char RIGHT_BRACKET = '】';
    private static final char ENGLISH_LEFT_BRACKET = '[';
    private static final char ENGLISH_RIGHT_BRACKET = ']';
    
    
	public static boolean isContainSign(String content) {
		if (content.charAt(0) == LEFT_BRACKET || content.charAt(0) == ENGLISH_LEFT_BRACKET) { // 前置签名
			return true;
		} else if (content.charAt(content.length() - 1) == RIGHT_BRACKET
				|| (content.charAt(content.length() - 1) == ENGLISH_RIGHT_BRACKET)) { // 后置签名
			return true;
		} else {
			return false;
		}
	}
    
	public static String getSignByContent(String content){
		if(content.charAt(0) == LEFT_BRACKET){ //前置签名
			return content.substring(1,content.indexOf(RIGHT_BRACKET));
		} else if (content.charAt(content.length()-1) == RIGHT_BRACKET){ //后置签名
			return content.substring(content.lastIndexOf(LEFT_BRACKET) + 1,content.length()-1);
		} else if(content.charAt(0) == ENGLISH_LEFT_BRACKET){
			return content.substring(1,content.indexOf(ENGLISH_RIGHT_BRACKET)); 
		} else if(content.charAt(content.length()-1) == ENGLISH_RIGHT_BRACKET){
			return content.substring(content.lastIndexOf(ENGLISH_LEFT_BRACKET) + 1,content.length()-1);
		}else {
			return StringUtils.EMPTY;
		}
	}
}
