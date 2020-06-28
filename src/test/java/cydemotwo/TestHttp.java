package cydemotwo;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.everything.demo.common.HttpResult;
import com.everything.demo.util.HttpUtils;

public class TestHttp {
	
    public static void main1(String[] args) {
         String url = "http://39.105.92.229:8085/api/sms/submit";
        // String url = "http://localhost:8085/api/sms/submit";
         Map<String, String> header = new HashMap<>();
         header.put("Content-Type", "application/json;charset=utf-8");
         header.put("Accept", "application/json");
         String charset = "UTF-8";   
         String accessKey = "240jusui0PU70A45";
         String secretKey = "iUzrAbWeZmdHe80yXBeGXhsV3LP2alnBMtEKLCojZZLvfv6PQ2lXZTL8mVRm9I4e";
         String str = "燕子去了，有再来的时候；杨柳枯了，有再青的时候；桃花谢了，有再开的时候。但是，聪明的，你告诉我，我们的日子为什么一去不复返呢？——是有人偷了他们罢：那是谁？又藏在何处呢？是他们自己逃走了罢：现在又到了哪里呢?";
         String[] split = str.split("|");
         String content = "";
         for (int i=0; i<7 ; i++){
        	 Random random = new Random();
        	 content += split[random.nextInt(split.length)];
         }
         for (int i = 0; i < 1; i++) {
             String requestBody = String.format("{\n" +
                             "  \"access_key\": \"%s\",\n" +
                             "  \"timestamp\": \"%s\",\n" +
                             "  \"nonce\": \"%s\",\n" +
                             "  \"dest_number\": \"13582369300\",\n" +
                             "  \"signature\": \"测\",\n" +
                             "  \"content\": \"%s\"\n" +
 /*                            "  \"template_code\": \"q1D3CjkT2p\",\n" +
                             "  \"template_parameters\": {\"regis_url\":\"www.cykj.com\",\"pass_url\":\"www.cy.com\"}\n" +*/
                             "}",
                     accessKey,
                     DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"),
                     UUID.randomUUID().toString(),
                     content);
             String accessToken = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, secretKey).hmacHex(requestBody);
             header.put("Access-Token", accessToken);

             long millis = System.currentTimeMillis();
             HttpResult httpResult = (new HttpUtils()).post(url, header, charset, requestBody);
             System.out.println(System.currentTimeMillis() - millis);
             System.out.println(httpResult);
         }
     }
    
    public static void main2(String[] args) {
  /*  	for(int i=0; i<1; i++){
    		main1(args);
    	}*/
	}
    
    public static void main(String[] args) {
        String url = "http://39.106.42.90:8080/QXT_WebsiteSecurityCheck4/PassiveMSG?ShortURL=tmq11.cc";

        long millis = System.currentTimeMillis();
        HttpResult httpResult = (new HttpUtils()).get(url, "utf-8");
        System.out.println(httpResult);
        String httpBody = httpResult.getHttpBody();
        JSONObject parseObject = JSON.parseObject(httpBody);
    	String realUrl = parseObject.getString("RealUrl");
    	String domainName = parseObject.getString("DomainName");
    	String ip = parseObject.getString("IP");
    	boolean isLocal = parseObject.getBoolean("isLocal");
    	boolean hasICP = parseObject.getBoolean("hasICP");
    	boolean isSafe = parseObject.getBoolean("isSafe");
    	Integer status =parseObject.getInteger("status");
        System.out.println(System.currentTimeMillis() - millis);
        
        
        
	}
    
    
}	
