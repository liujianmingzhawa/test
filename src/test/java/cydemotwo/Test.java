package cydemotwo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.rmi.CORBA.Stub;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.tools.ant.taskdefs.Retry;
import org.springframework.util.Base64Utils;

import com.alibaba.fastjson.JSON;
import com.everything.demo.common.AbstractFixedThread;
import com.everything.demo.common.FixedThreadPool;
import com.everything.demo.common.HttpResult;
import com.everything.demo.po.BaseObject;
import com.everything.demo.po.HttpsMo;
import com.everything.demo.po.SmsHistory;
import com.everything.demo.po.User;
import com.everything.demo.util.CNIPRecognizer;
import com.everything.demo.util.GainUrlUtils;
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
		/******
		 * test2不会冲突文件
		 */
		List<String> list = new ArrayList<String>();
		list.add("username");
		list.add("title");
		list.add("timestamp");
		list.add("type");
		Collections.sort(list);
		System.err.println(list);
		System.err.println();
	}

	public static void main7(String[] args) {
		/***************

		 * test1分支提交
		 ************/
		

		/************
		 * test3提交
		 *************/
		


		 /* test2提交文件
		 ***********/

		
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
		System.err.println("1,2,3,".substring(0,"1,2,3,".length()-1));
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
	
	
	public static void main10(String[] args) throws Exception {
		String fileUrl = "C:\\Users\\ljm\\Desktop\\测试视频短信素材\\AW超级短信文案1.txt";
		System.err.println(getFileStr(fileUrl));
	}
	
	public static void main9(String[] args) {
/*		System.err.println("123546".substring(4));
        System.out.println("8729062.com: " + CNIPRecognizer.isCNIP("202.40.137.0"));
        System.out.println("8729062.com: " + CNIPRecognizer.isCNIP("8729062.com"));
        List<String> list = new ArrayList<>();
        list.add("q");
        list.add("s");
        list.add("x");
        list.add("c");
        list.add("v");
        list.add("b");
        list.add("m");
        List<String> subList1 = list.subList(0, 2);
        List<String> subList2 = list.subList(2, 4);
        List<String> subList3= list.subList(4, 6);
        System.err.println(subList1);
        System.err.println(subList2);
        System.err.println(subList3);
		int maxCount = 2;
		int sheetCount = list.size() % maxCount == 0 ? (list.size() / maxCount) : (list.size() / maxCount + 1);
        for(int i =0; i< sheetCount; i++){
        	List<String> subList = new ArrayList<>(maxCount);
        	if(i == sheetCount - 1){
        		subList = list.subList((sheetCount - 1) * maxCount, list.size());
        	} else {
        		subList = list.subList(i * maxCount, maxCount*(i+1));
        	}
        	System.err.println(subList);
        }*/
        List<SmsHistory> list = new ArrayList<>();
		SmsHistory smsHistory5 = new SmsHistory();
		smsHistory5.setSmsSize(5);
		smsHistory5.setSmsNumber(5);
		smsHistory5.setContent("远");
		smsHistory5.setUuid("a");
		SmsHistory smsHistory1 = new SmsHistory();
		smsHistory1.setSmsSize(5);
		smsHistory1.setSmsNumber(1);
		smsHistory1.setContent("你");
		smsHistory1.setUuid("a");
		SmsHistory smsHistory3 = new SmsHistory();
		smsHistory3.setSmsSize(5);
		smsHistory3.setSmsNumber(3);
		smsHistory3.setContent("啊");
		smsHistory3.setUuid("a");
		SmsHistory smsHistory2 = new SmsHistory();
		smsHistory2.setSmsSize(5);
		smsHistory2.setSmsNumber(2);
		smsHistory2.setContent("好");
		smsHistory2.setUuid("b");
		SmsHistory smsHistory4 = new SmsHistory();
		smsHistory4.setSmsSize(5);
		smsHistory4.setSmsNumber(4);
		smsHistory4.setContent("创");
		smsHistory4.setUuid("b");
		list.add(smsHistory1);
		list.add(smsHistory2);
		list.add(smsHistory3);
		list.add(smsHistory4);
		list.add(smsHistory5);
		Map<String, List<SmsHistory>> collect = list.stream().collect(Collectors.groupingBy(SmsHistory :: getUuid));
		for(Map.Entry<String, List<SmsHistory>> entry : collect.entrySet()){
			System.err.println(entry.getKey());
			System.err.println(entry.getValue().size());
		}
		
		List<String> collect2 = list.stream().map(SmsHistory :: getContent).collect(Collectors.toList());
		System.err.println(collect2);
		String join = StringUtils.join(collect2,",");
		System.err.println(join);
		
		
/*		Map<Integer, SmsHistory> map = new HashMap<>();
		SmsHistory smsHistory5 = new SmsHistory();
		smsHistory5.setSmsSize(5);
		smsHistory5.setSmsNumber(5);
		smsHistory5.setContent("远");
		SmsHistory smsHistory1 = new SmsHistory();
		smsHistory1.setSmsSize(5);
		smsHistory1.setSmsNumber(1);
		smsHistory1.setContent("你");
		SmsHistory smsHistory3 = new SmsHistory();
		smsHistory3.setSmsSize(5);
		smsHistory3.setSmsNumber(3);
		smsHistory5.setContent("啊");
		SmsHistory smsHistory2 = new SmsHistory();
		smsHistory2.setSmsSize(5);
		smsHistory2.setSmsNumber(2);
		smsHistory5.setContent("好");
		SmsHistory smsHistory4 = new SmsHistory();
		smsHistory4.setSmsSize(5);
		smsHistory4.setSmsNumber(4);
		smsHistory5.setContent("创");
		map.put(5, smsHistory5);
		map.put(3, smsHistory3);
		map.put(1, smsHistory1);
		map.put(2, smsHistory2);
		map.put(4, smsHistory4);
		for(Map.Entry<Integer, SmsHistory> entry : map.entrySet()){
			System.err.println(entry.getKey());
		}*/

	} 
	
	private static String getFileStr(String fileUrl) throws Exception {
		
		try(FileReader fileReader = new FileReader(fileUrl);
				BufferedReader bf = new BufferedReader(fileReader);
				) {

			String str;
			String ss ="";
			// 按行读取字符串
			while ((str = bf.readLine()) != null) {
				ss +=str+ "\r\n";

		} 
		
/*		String str = null;
		try (FileInputStream input = new FileInputStream(new File(fileUrl))) {
			byte[] buffer = new byte[1024 * 4];
			int n = 0;
			while (-1 != (n = input.read(buffer))) {
				str = new String(buffer, 0, n);
			}
		}*/
		return ss;
		}
	}	
	
	public static void main1111(String[] args) throws Exception {
	/*	String str = "【和勤通信】杨文学,您有一条员工（羌文华，1906598）的入职电子流待审核，请尽快登录网址http://180.168.130.10:1111/cas/login?service=http%3A%2F%2F180.168.130.10%3A1111%2Fplatform%2Findex.html#/home/controller进行处理。";
		System.err.println(GainUrlUtils.getUrl(str));
		String ss = "(";
		for(int i=10000000;i<10005001;i++){
			ss+=i+",";
		}
		System.err.println(ss+")");*/
	/*	int ss = "数字短信测试0528-副本-预发-副本".getBytes().length;
		System.err.println(ss);
		System.err.println("数字短信测试0528-副本-预发-副本".getBytes().length);*/

		Set<String> set = new HashSet<>();
		set.add("sxc");
		set.add("qwe");
		set.add("rty");
		set.add("cvs");
		/*Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next(); 
			if(next.equals("rty")){
				iterator.remove();
			}
		}*/
		Set<String> addset = new HashSet<>(set);
		addset.add("cccc");
		System.err.println(addset);
		System.err.println(new String(Base64Utils.decodeFromString("LmNvbS9tdnBocA==")) );
		
	}
	
	
/*	public static void main(String[] args) throws Exception {
        String BLANK = "  ";
        Process process = Runtime.getRuntime().exec(
                "C:\\Users\\ljm\\Desktop\\phatomjs\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe" + BLANK //你的phantomjs.exe路径
                + "C:\\Users\\ljm\\Desktop\\phatomjs\\screenshot.js" + BLANK //就是上文中那段javascript脚本的存放路径
                + "http://s.dianwoda.cn/RVhVX9" + BLANK //你的目标url地址
                + "D:/tmp/");//你的图片输出路径

        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String tmp = "";
        while ((tmp = reader.readLine()) != null) {
            if (reader != null) {
                reader.close();
            }
            if (process != null) {
                process.destroy();
                process = null;
            }
            System.out.println("渲染成功...");
        }
	}*/

	  private static String tempPath = "D:/tmp";// 图片保存目录
	    private static String BLANK = " ";
	    // 下面内容可以在配置文件中配置
	    private static String binPath = "C:\\Users\\ljm\\Desktop\\phatomjs\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe";// 插件引入地址
	    private static String jsPath = "C:\\Users\\ljm\\Desktop\\phatomjs\\phantomjs-2.1.1-windows\\screenshot.js";// js引入地址

	    // 执行cmd命令
	    public static String cmd(String imgagePath, String url) {
	        return binPath + BLANK + jsPath + BLANK + url + BLANK + imgagePath;
	    }
	    //关闭命令
	    public static void close(Process process, BufferedReader bufferedReader) throws IOException {
	        if (bufferedReader != null) {
	            bufferedReader.close();
	        }
	        if (process != null) {
	            process.destroy();
	            process = null;
	        }
	    }
	    /**
	     * @param userId 
	     * @param url
	     * @throws IOException 
	     */
	    public static void printUrlScreen2jpg(String url) throws IOException{
	        String imgagePath = tempPath+"/"+System.currentTimeMillis()+".png";//图片路径
	        System.err.println(imgagePath);
	        //Java中使用Runtime和Process类运行外部程序
	        Process process = Runtime.getRuntime().exec(cmd(imgagePath,url));
	        InputStream inputStream = process.getInputStream();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	        String tmp = "";
	        while ((tmp = reader.readLine()) != null) {
	            close(process,reader);
	        }
	        System.out.println("success");
	    }
	    
	    public static void main(String[] args) throws IOException {
	        String url = "http://s.dianwoda.cn/RVhVX9";//以百度网站首页为例
	        Test.printUrlScreen2jpg(url);
	    }
	
}
