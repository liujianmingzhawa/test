package cydemotwo;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import com.everything.demo.common.HttpResult;
import com.everything.demo.util.HttpUtils;

public class TengXunYunQuery {
	
	public static void main(String[] args) throws Exception {
		String url = "";
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json;charset=utf-8");
        header.put("Accept", "application/json");
		String version = "1.0";
		String action = "querybill";
		String account = "765523";
		String password = "R@cE5917";
		Long time = System.currentTimeMillis();
		String dataDate = "2019-12-24";
		String str = "account="+account+"&password="+DigestUtils.md5Hex(password+account)+"&action="+action+"&time="+time;
		MessageDigest instance = MessageDigest.getInstance("SHA-256");	
		byte[] hash = instance.digest(str.getBytes("UTF-8"));
		String sig = Hex.encodeHexString(hash);
		String requestBody = String.format("{"+
				"\"version\": \"%s\",\n" +
				"\"action\": \"%s\",\n" +
				"\"account\": \"%s\",\n" +
				"\"time\": \"%s\",\n" +
				"\"sig\": \"%s\",\n" +
				"\"data_date\": \"%s\"\n" 
				
				+ "}", 
				version,
				action,
				account,
				time,
				sig,
				dataDate
				);
		
		long millis = System.currentTimeMillis();
		HttpResult httpResult = (new HttpUtils()).post(url, header, "UTF-8", requestBody);
		System.out.println(System.currentTimeMillis() - millis);
		System.out.println(httpResult);
	}
}
