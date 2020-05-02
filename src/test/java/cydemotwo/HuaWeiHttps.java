package cydemotwo;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.util.Base64Utils;
import com.everything.demo.common.HttpResult;
import com.everything.demo.util.HttpUtils;

public class HuaWeiHttps {

    public static void main1(String[] args) throws Exception {
       // String url = "https://localhost:7086/sms/sendMessage";
       // String url = "https://39.105.92.229:7086/sms/sendMessage";
        String url = "https://api.sxcyinfo.com/sms/sendMessage";
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json;charset=utf-8");
        header.put("Accept", "application/json");
        String charset = "UTF-8";
       // String accessKey = "rdgVDU9364H5c7Av";
        //String accessKey = "81mL2jO55CV6wzup";
        String accessKey = "Q7BM3D24TwwUCoAx";
       // String secretKey = "p1Xrlv1c9orxjHUs5M5NqXDHkQphjq1efjHs3o23f02RJ8xXlZrOjwFwIASqGget";
        //String secretKey = "X5b6HOg9S6CBqrm2K3hf7M1CCgsueGCL5fuRVbomP4RkBX6utKBWntM0mSVWb4Bn";
        String secretKey = "jNwo5Qc0B12iZJ3nW3yYBFjVV8vOWPwlJkAh9K2hOM5DX33XLf4LG8PcESxXVQqI";
        String transactionId = UUID.randomUUID().toString();
        String timestamp = String.valueOf(System.currentTimeMillis());
        String requestBody = String.format("{\n" +
                        "  \"transactionId\": \"%s\",\n" +
                        "  \"phoneNumber\": [\"+8613582369300\""
  //                      + "\"008618237143715\""
                        + "],\n" +
                        "  \"spNumber\": \"106919878820567\",\n" +
                        "  \"message\": \"【测试】您好您的验证码是123456\",\n" +
                        "  \"contentType\": \"1\"\n" +
                        "}",
                        transactionId);		
	        Map<String, Object> paramMap = new HashMap<>();
	        paramMap.put("transactionId", transactionId);
	        paramMap.put("phoneNumber", StringUtils.join(new String[]{"+8613582369300"},","));
	        		
	        paramMap.put("spNumber", "106919878820567");
	        paramMap.put("message", "【测试】您好您的验证码是123456");
	        paramMap.put("contentType", "1");
	        List<String> list = new ArrayList<String>(paramMap.keySet());
	        Collections.sort(list);
	        StringBuilder builder = new StringBuilder();
	        for(int p =0; p<list.size(); p++){
	        	String paramName = list.get(p);
	        	Object value = paramMap.get(paramName);
				if(value == null){
					continue;
				}
				builder.append(URLEncoder.encode(paramName,"UTF-8")).append("=").append(URLEncoder.encode(value.toString(),"UTF-8"));
				if(p < list.size() -1){
					builder.append("&");
				}
			}
			StringBuilder builder1 = new StringBuilder();
			String stringToSign = builder1.append("POST").append("&").append("/sms/sendMessage").append("&").append(builder.toString()).append("&").
					append(requestBody).append("&appid="+accessKey).append("&timestamp="+timestamp).toString();
	        System.err.println(stringToSign);
            String signature = Base64Utils.encodeToString(new HmacUtils(HmacAlgorithms.HMAC_SHA_256, secretKey).hmacHex(stringToSign).getBytes("UTF-8"));
            String authorization = "HMAC-SHA256 appid="+accessKey+", timestamp="+timestamp+", signature="+signature;
            header.put("Authorization", authorization);
         
            long millis = System.currentTimeMillis();
            HttpResult httpResult = (new HttpUtils()).post(url, header, charset, requestBody);
            System.out.println(System.currentTimeMillis() - millis);
            System.out.println(httpResult);
       
    }

    public static void main2(String[] args) throws Exception {
        //String url = "http://localhost:8085/sms/getReportMessage";
        //String url = "http://39.105.92.229:8085/sms/getReportMessage";
        String url = "https://api.sxcyinfo.com/sms/getReportMessage";
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json;charset=utf-8");
        header.put("Accept", "application/json");
        String charset = "UTF-8";
        //String accessKey = "rdgVDU9364H5c7Av";
       // String accessKey = "81mL2jO55CV6wzup";
        String accessKey = "Q7BM3D24TwwUCoAx";
        //String secretKey = "p1Xrlv1c9orxjHUs5M5NqXDHkQphjq1efjHs3o23f02RJ8xXlZrOjwFwIASqGget";
        //String secretKey = "X5b6HOg9S6CBqrm2K3hf7M1CCgsueGCL5fuRVbomP4RkBX6utKBWntM0mSVWb4Bn";
        String secretKey = "jNwo5Qc0B12iZJ3nW3yYBFjVV8vOWPwlJkAh9K2hOM5DX33XLf4LG8PcESxXVQqI";
        String transactionId = UUID.randomUUID().toString();
        String timestamp = String.valueOf(System.currentTimeMillis());
        Integer maxSize = 20;
        for (int i = 0; i < 1; i++) {
            String requestBody = String.format("{\n" +
                            "  \"transactionId\": \"%s\",\n" +
                            "  \"maxSize\": \"%s\"\n" +
                            "}",
                            transactionId,
                            maxSize);
            Map<String, Object> paramMap = new HashMap<>();
	        paramMap.put("transactionId", transactionId);
	        paramMap.put("maxSize", maxSize);
	        List<String> list = new ArrayList<String>(paramMap.keySet());
	        Collections.sort(list);
	        StringBuilder builder = new StringBuilder();
	        for(int p =0; p<list.size(); p++){
	        	String paramName = list.get(p);
	        	Object value = paramMap.get(paramName);
				if(value == null){
					continue;
				}
				builder.append(URLEncoder.encode(paramName,"UTF-8")).append("=").append(URLEncoder.encode(value.toString(),"UTF-8"));
				if(p < list.size() -1){
					builder.append("&");
				}
			}
			StringBuilder builder1 = new StringBuilder();
			String stringToSign = builder1.append("POST").append("&").append("/sms/getReportMessage").append("&").append(builder.toString()).append("&").
					append(requestBody).append("&appid="+accessKey).append("&timestamp="+timestamp).toString();
	        System.err.println(stringToSign);
            String signature = Base64Utils.encodeToString(new HmacUtils(HmacAlgorithms.HMAC_SHA_256, secretKey).hmacHex(stringToSign).getBytes("UTF-8"));
            String authorization = "HMAC-SHA256 appid="+accessKey+", timestamp="+timestamp+", signature="+signature;
            header.put("Authorization", authorization);

            long millis = System.currentTimeMillis();
            HttpResult httpResult = (new HttpUtils()).post(url, header, charset, requestBody);
            System.out.println(System.currentTimeMillis() - millis);
            System.out.println(httpResult);
        }
    }
    
    public static void main3(String[] args) throws Exception {
        String url = "https://api.sxcyinfo.com/sms/getDeliverMessage";
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json;charset=utf-8");
        header.put("Accept", "application/json");
        String charset = "UTF-8";
        //String accessKey = "rdgVDU9364H5c7Av";
      //  String accessKey = "81mL2jO55CV6wzup";
        String accessKey = "Q7BM3D24TwwUCoAx";
        //String secretKey = "p1Xrlv1c9orxjHUs5M5NqXDHkQphjq1efjHs3o23f02RJ8xXlZrOjwFwIASqGget";
       // String secretKey = "X5b6HOg9S6CBqrm2K3hf7M1CCgsueGCL5fuRVbomP4RkBX6utKBWntM0mSVWb4Bn";
        String secretKey = "jNwo5Qc0B12iZJ3nW3yYBFjVV8vOWPwlJkAh9K2hOM5DX33XLf4LG8PcESxXVQqI";
        String transactionId = UUID.randomUUID().toString();
        String timestamp = String.valueOf(System.currentTimeMillis());
        Integer maxSize = 501;
        for (int i = 0; i < 1; i++) {
            String requestBody = String.format("{\n" +
                            "  \"transactionId\": \"%s\",\n" +
                            "  \"maxSize\": \"%s\"\n" +
                            "}",
                            transactionId,
                            maxSize);
            Map<String, Object> paramMap = new HashMap<>();
	        paramMap.put("transactionId", transactionId);
	        paramMap.put("maxSize", maxSize);
	        List<String> list = new ArrayList<String>(paramMap.keySet());
	        Collections.sort(list);
	        StringBuilder builder = new StringBuilder();
	        for(int p =0; p<list.size(); p++){
	        	String paramName = list.get(p);
	        	Object value = paramMap.get(paramName);
				if(value == null){
					continue;
				}
				builder.append(URLEncoder.encode(paramName,"UTF-8")).append("=").append(URLEncoder.encode(value.toString(),"UTF-8"));
				if(p < list.size() -1){
					builder.append("&");
				}
			}
			StringBuilder builder1 = new StringBuilder();
			String stringToSign = builder1.append("POST").append("&").append("/sms/getDeliverMessage").append("&").append(builder.toString()).append("&").
					append(requestBody).append("&appid="+accessKey).append("&timestamp="+timestamp).toString();
	        System.err.println(stringToSign);
            String signature = Base64Utils.encodeToString(new HmacUtils(HmacAlgorithms.HMAC_SHA_256, secretKey).hmacHex(stringToSign).getBytes("UTF-8"));
            String authorization = "HMAC-SHA256 appid="+accessKey+", timestamp="+timestamp+", signature="+signature;
            header.put("Authorization", authorization);

            long millis = System.currentTimeMillis();
            HttpResult httpResult = (new HttpUtils()).post(url, header, charset, requestBody);
            System.out.println(System.currentTimeMillis() - millis);
            System.out.println(httpResult);
        }
    }
    
    public static void main4(String[] args) {
        String url = "http://localhost:8085/api/sms/query/surplus";
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json;charset=utf-8");
        header.put("Accept", "application/json");
        String charset = "UTF-8";
        String accessKey = "rdgVDU9364H5c7Av";
        String secretKey = "p1Xrlv1c9orxjHUs5M5NqXDHkQphjq1efjHs3o23f02RJ8xXlZrOjwFwIASqGget";
        for (int i = 0; i < 1; i++) {
            String requestBody = String.format("{\n" +
                            "  \"access_key\": \"%s\",\n" +
                            "  \"timestamp\": \"%s\",\n" +
                            "  \"nonce\": \"%s\"\n" +
                            "}",
                    accessKey,
                    DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"),
                    UUID.randomUUID().toString());
            String accessToken = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, secretKey).hmacHex(requestBody);
            header.put("Access-Token", accessToken);

            long millis = System.currentTimeMillis();
            HttpResult httpResult = (new HttpUtils()).post(url, header, charset, requestBody);
            System.out.println(System.currentTimeMillis() - millis);
            System.out.println(httpResult);
        }
    }
    
    public static void main(String[] args) throws Exception {
        //main3(args);	
    	//main1(args);
       // main2(args);
    	//main4(args);
    }
}
