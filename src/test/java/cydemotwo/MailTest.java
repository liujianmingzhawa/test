package cydemotwo;

import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSON;
import com.everything.demo.common.HttpResult;
import com.everything.demo.util.HttpUtils;
import com.google.common.collect.Maps;

public class MailTest {
	
	public static void main(String[] args){

        try {
            //钉钉机器人地址（配置机器人的webhook）
            String dingUrl = "https://oapi.dingtalk.com/robot/send?access_token=462cf70684637dc6c256e933bb166fd25b1166c40f6107d56d98b43c18f0fe6f";

            //是否通知所有人
            boolean isAtAll = true;
            //通知具体人的手机号码列表
            //List<String> mobileList = Lists.newArrayList();

            //钉钉机器人消息内容
            String content = "http://47.93.6.145:8380/download/20200101/20200101-四期统计情况.xlsx";
            //组装请求内容
            String reqStr = buildReqStr(content, isAtAll);

            //推送消息（http请求）
            //String result = HttpUtil.postJson(dingUrl, reqStr);
        	Long timestamp = System.currentTimeMillis();
        	String secret = "SECc37e9426e24e476131ea4ee315f77c15e27fa671156f8469823aa1ac36dec8ea";
        	String sign = getSign(secret, timestamp);
        	System.err.println(sign);
            Map<String, String> header = new HashMap<>();
            header.put("Content-Type", "application/json;charset=utf-8");
            header.put("Accept", "application/json");
            HttpResult httpResult = (new HttpUtils()).post(dingUrl+"&timestamp="+timestamp+"&sign="+sign, header, "UTF-8", reqStr);
            System.out.println("result == " +  httpResult);

        }catch (Exception e){
            e.printStackTrace();

        }

    }

    /**
     * 组装请求报文
     * @param content
     * @return
     */
    private static String buildReqStr(String content, boolean isAtAll) {
        //消息内容
        Map<String, String> contentMap = Maps.newHashMap();
        contentMap.put("content", content);

        //通知人
        Map<String, Object> atMap = Maps.newHashMap();
        //1.是否通知所有人
        atMap.put("isAtAll", isAtAll);
        //2.通知具体人的手机号码列表
        //atMap.put("atMobiles", mobileList);

        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put("msgtype", "text");
        reqMap.put("text", contentMap);
        //reqMap.put("at", atMap);

        return JSON.toJSONString(reqMap);
    }
    
    
    public static String getSign(String secret,Long timestamp) throws Exception{
    	String stringToSign = timestamp + "\n" + secret;
    	Mac mac = Mac.getInstance("HmacSHA256");
    	mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
    	byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
    	return URLEncoder.encode(new String(Base64.encodeBase64(signData)),"UTF-8");
    }
}


