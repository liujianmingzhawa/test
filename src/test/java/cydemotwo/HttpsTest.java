package cydemotwo;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.everything.demo.common.HttpResult;
import com.everything.demo.util.HttpUtils;

public class HttpsTest {
    public static void main1(String destNumber,String sign,String content ) {
        String url = "http://localhost:8085/api/sms/submit";//测试环境
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json;charset=utf-8");
        header.put("Accept", "application/json");
        String charset = "UTF-8";
       String accessKey = "rdgVDU9364H5c7Av";
       //String accessKey = "rdgVDU9364H5c7Av";
       String secretKey = "p1Xrlv1c9orxjHUs5M5NqXDHkQphjq1efjHs3o23f02RJ8xXlZrOjwFwIASqGget";
      // String secretKey = "p1Xrlv1c9orxjHUs5M5NqXDHkQphjq1efjHs3o23f02RJ8xXlZrOjwFwIASqGget";
        for (int i = 0; i < 1; i++) {
            String requestBody = String.format("{\n" +
                            "  \"access_key\": \"%s\",\n" +
                            "  \"timestamp\": \"%s\",\n" +
                            "  \"nonce\": \"%s\",\n" +
                            "  \"dest_number\": \"%s\",\n" +
                            "  \"signature\": \"%s\",\n" +
                            "  \"content\": \"%s\"\n" +
//                            "  \"extend_code\": \"%s\"\n" +
                            //"  \"template_code\": \"q1D3CjkT2p\",\n" +
                            //"  \"template_parameters\": {\"regis_url\":\"www.cykj.com\",\"pass_url\":\"www.cy.com\"}\n" +
                            "}",
                    accessKey,
                    DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"),
                    UUID.randomUUID().toString(),
                    destNumber,
                    sign,
                    content
                    );
            String accessToken = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, secretKey).hmacHex(requestBody);
            header.put("Access-Token", accessToken);

            long millis = System.currentTimeMillis();
            HttpResult httpResult = (new HttpUtils()).post(url, header, charset, requestBody);
            System.out.println(System.currentTimeMillis() - millis);
            System.out.println(httpResult);
        }
    }
    
    public static void main(String[] args) throws Exception {
    	List<String> list = getSignAndExcode();
    	String destNumber = "18253266094";
    	System.err.println(list.size()+"===============");
    	for (String str : list) {
			String sign = str;
			String content = str;			
			main1(destNumber,sign,content);
			System.err.println(str);
			Thread.sleep(1000);
		}
		
		
		
	}

	private static List<String> getSignAndExcode() throws Exception {
		String[] readLine = IOUtils.readLines(new File("C:\\Users\\ljm\\Desktop\\下发.txt"));
		List<String> list = Arrays.asList(readLine);
		return list;
	}
}
