package cydemotwo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.tools.ant.taskdefs.Retry;

import com.alibaba.fastjson.JSON;
import com.everything.demo.common.AbstractFixedThread;
import com.everything.demo.common.FixedThreadPool;
import com.everything.demo.common.HttpResult;
import com.everything.demo.po.BaseObject;
import com.everything.demo.po.HttpsMo;
import com.everything.demo.po.User;
import com.everything.demo.util.HttpUtils;

public class Test {
	public static FixedThreadPool executorService = new FixedThreadPool(10, "test");

	public static void main1(String[] args) throws Exception {
		for (int i = 0; i < 1000; i++) {
			String message = "您好您的验证码是" + i;
			String requestBody = String.format("{\n" + "  \"message\": \"%s\"\n" + "}", message);
			executorService.submit(new TestThread(requestBody));
		}
	}

	static class TestThread extends AbstractFixedThread {

		private String requestBody;

		public TestThread(String requestBody) {
			this.requestBody = requestBody;
		}

		@Override
		public void process() throws Exception {
			String url = "http://localhost:8866/doEvent";
			Map<String, String> header = new HashMap<>();
			header.put("Content-Type", "application/json;charset=utf-8");
			header.put("Accept", "application/json");
			String charset = "UTF-8";
			long millis = System.currentTimeMillis();
			HttpResult httpResult = (new HttpUtils()).post(url, header, charset, requestBody);
			System.out.println(System.currentTimeMillis() - millis);
			System.out.println(httpResult);

		}

	}

	public static void main2(String[] args) throws Exception {
		/*
		 * String str2 =
		 * "signature=NjAzNjY2ZTk4ZGQwYjhhYWIxZjNiZDZjYjhlYTFmZjRmYjgyNGU0YWYwYjNkZWRjYzRmY2NmODIzYTNlZmY3ZA==";
		 * int signIndexOf = str2.indexOf("="); String signature =
		 * str2.substring(signIndexOf+1,str2.length()).trim();
		 * System.err.println(signature); String[] arry = new
		 * String[]{"13582369300","13582369301"};
		 * System.err.println(StringUtils.join(arry,",")); String extendCode =
		 * null; System.err.println(extendCode.substring(5));
		 */

		try {
			int xx = 1 / 0;

		} catch (Exception e) {

			retry(0);

		}

	}

	public static void retry(int tryTimes) {
		if (tryTimes == 3) {
			System.err.println("重试次数达到" + tryTimes + "次");
			return;
		}
		try {
			int xx = 1 / 1;
			System.err.println("重试" + tryTimes);
		} catch (Exception e) {
			tryTimes++;
			retry(tryTimes);
		}
		return;
	}

	public static void main3(String[] args) throws Exception {
		System.err.println("y".getBytes("UnicodeBigUnmarked").length);
		Byte b = null;
		if (b == null) {
			System.err.println("----");
		}
		System.err.println("[test]ninhaonindeyanzhengmashi1234,qingtuoshanbaoguan,diulehouguozifu.".length());
		System.err.println("[test]ninhaonindeyanzhengmashi1234,qingtuoshanbaoguan,diulehouguozifu.jlda"
				.getBytes("ISO-8859-1").length);
	}

	public static void main4(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("username");
		list.add("title");
		list.add("timestamp");
		list.add("type");
		Collections.sort(list);
		System.err.println(list);
		System.err.println();
	}

	public static void main(String[] args) {
		/***************
		 * test1分支提交
		 ************/
		
		
/*		for (int m = 1; m <= 12; m++) {
			for (int d = 1; d <= 31; d++) {				
				String sql = "alter table sms_history_" + String.format("%1$02d%2$02d", m,d) + " modify content varchar(5000);";
				System.err.println(sql);
			}
		}*/
		
/*		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map1 = new HashMap<>();
		map1.put("name", "map1");
		map1.put("type", "map1Type");
		Map<String, String> map2 = new HashMap<>();
		map2.put("name", "map2");
		map2.put("type", "map2Type");
		
		list.add(map1);
		list.add(map2);
		System.err.println(JSON.toJSONString(list));*/
		
		
/*		User user = new User();
		user.setAccess("113");
		user.setPassword("lll");
		HttpsMo mo = new HttpsMo();
		BaseObject baseObject = new BaseObject();
		isBaseObject(user);*/
		String xx = "mobile is empty";
		System.err.println(isNumeric(xx));
		List<String> list = new ArrayList<>();
		list.add("1352863900");
		list.add("1352863902");
		list.add("1352863901");
		list.add("1352863904");
		String join = StringUtils.join(list,",");
		System.err.println(join);
		System.err.println(RandomStringUtils.randomAlphanumeric(24));
	}

	private static void isBaseObject(BaseObject baseObject) {
		if(baseObject instanceof User){
			User user =(User)baseObject;
			System.err.println(user.toString());
		}
		
	}
	public static boolean isNumeric(String str){  
		  for (int i = str.length();--i>=0;){    
		   if (!Character.isDigit(str.charAt(i))){  
		    return false;  
		   }  
		  }  
		  return true;  
		} 
// 测试合并到主干
	
	// 测试合并2
}
