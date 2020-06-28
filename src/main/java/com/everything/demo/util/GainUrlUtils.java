package com.everything.demo.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;


public class GainUrlUtils {
	
    private static final String UCS_CHAR = "[" +
            "\u00A0-\uD7FF" +
            "\uF900-\uFDCF" +
            "\uFDF0-\uFFEF" +
            "\uD800\uDC00-\uD83F\uDFFD" +
            "\uD840\uDC00-\uD87F\uDFFD" +
            "\uD880\uDC00-\uD8BF\uDFFD" +
            "\uD8C0\uDC00-\uD8FF\uDFFD" +
            "\uD900\uDC00-\uD93F\uDFFD" +
            "\uD940\uDC00-\uD97F\uDFFD" +
            "\uD980\uDC00-\uD9BF\uDFFD" +
            "\uD9C0\uDC00-\uD9FF\uDFFD" +
            "\uDA00\uDC00-\uDA3F\uDFFD" +
            "\uDA40\uDC00-\uDA7F\uDFFD" +
            "\uDA80\uDC00-\uDABF\uDFFD" +
            "\uDAC0\uDC00-\uDAFF\uDFFD" +
            "\uDB00\uDC00-\uDB3F\uDFFD" +
            "\uDB44\uDC00-\uDB7F\uDFFD" +
            "&&[^\u00A0[\u2000-\u200A]\u2028\u2029\u202F\u3000]]";
	
    private static final String LABEL_CHAR = "a-zA-Z0-9" + UCS_CHAR;

    private static final String TLD_CHAR = "a-zA-Z" + UCS_CHAR;

    private static final String IRI_LABEL =
            "[" + LABEL_CHAR + "](?:[" + LABEL_CHAR + "\\-]{0,61}[" + LABEL_CHAR + "]){0,1}";

    private static final String PUNYCODE_TLD = "xn\\-\\-[\\w\\-]{0,58}\\w";

    private static final String TLD = "(" + PUNYCODE_TLD + "|" + "[" + TLD_CHAR + "]{2,63}" +")";

    private static final String HOST_NAME = "(" + IRI_LABEL + "\\.)+" + TLD;
    
    private static final int MAX_SIZE = 100;
    
    public static final Pattern IP_ADDRESS
    = Pattern.compile(
        "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4]"
        + "[0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]"
        + "[0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}"
        + "|[1-9][0-9]|[0-9]))");

    public static final Pattern DOMAIN_NAME
        = Pattern.compile("(" + HOST_NAME + "|" + IP_ADDRESS + ")");

    private static final String PROTOCOL = "(?i:http|https|rtsp):\\/\\/";

   
    private static final String WORD_BOUNDARY = "(?:\\b|$|^)";

    private static final String USER_INFO = "(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)"
            + "\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_"
            + "\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@";

    private static final String PORT_NUMBER = "\\:\\d{1,5}";

    private static final String PATH_AND_QUERY = "\\/(?:(?:[" + LABEL_CHAR
            + "\\;\\/\\?\\:\\@\\&\\=\\#\\~" 
            + "\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*";
    
    private static final String CN_REGX = "[\u4e00-\u9fa5]";
    
    private static final String BRACKETS = "[（）() {} 【】 \\[ \\] ！ ! ]";
    
    public static final Pattern WEB_URL = Pattern.compile("("
            + "("
            + "(?:" + PROTOCOL + "(?:" + USER_INFO + ")?" + ")?"
            + "(?:" + DOMAIN_NAME + ")"
            + "(?:" + PORT_NUMBER + ")?"
            + ")"
            + "(" + PATH_AND_QUERY + ")?"
            + WORD_BOUNDARY
            + ")");
   
    public static String getUrl(String str){
    	try {
        	String sign = SignUtils.getSignByContent(str);
        	Matcher smatcher = WEB_URL.matcher(sign);
        	if(smatcher.find()){
        		return smatcher.group();
        	}
        	str = getRemoveSpotStr(str);
    	    Matcher matcher = WEB_URL.matcher(str);
    	    String url = StringUtils.EMPTY;
    	    if (matcher.find()){
    	    	url = matcher.group();
    	    }
    	    Pattern pat = Pattern.compile(CN_REGX);
    	    matcher = pat.matcher(url);
            if(matcher.find()){
            	String replaceAll = matcher.replaceAll(" ");
            	List<String> asList = Arrays.asList(replaceAll.split("\\s+"));
            	for (String data : asList) {
    				if(WEB_URL.matcher(data).find()){
    					url = data.replaceAll(BRACKETS, "");
    				}
    			}
            }
            
            if(pat.matcher(url).find()){
            	return "";
            }
            
            return url.replaceAll(BRACKETS, "");
		} catch (Exception e) {
			return StringUtils.EMPTY;
		}

    }

	private static String getRemoveSpotStr(String str) {
		int indexOf = str.indexOf(".");
		if(indexOf < 0){
			return str;
		}
		for(int i = 0 ; i< MAX_SIZE; i++){	
			indexOf = str.indexOf(".");
			char charAt = str.charAt(indexOf+1);
			Pattern pata = Pattern.compile(CN_REGX);
			if(!pata.matcher(String.valueOf(charAt)).find()){
				return str;
			} else {
				str = str.substring(indexOf+1,str.length());
			}
		}
		return str;
	}
    
}
