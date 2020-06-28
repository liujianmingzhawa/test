package cydemotwo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.springframework.util.Base64Utils;

import com.alibaba.dubbo.common.utils.ConcurrentHashSet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.everything.demo.common.HttpResult;
import com.everything.demo.po.ALMmsSubmit;
import com.everything.demo.po.ALMmsUploadResource;
import com.everything.demo.po.AllSign;
import com.everything.demo.util.HttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AlHttpMms {
	
	public static void main1(String[] args) throws Exception {
        //String url = "http://localhost:8085/api/mms/al/dyCheckSave/synSaveMms";
		String url = "http://120.192.248.130:8085/api/mms/al/dyCheckSave/synSaveMms";//正式环境
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json;charset=utf-8");
        header.put("Accept", "application/json");
        String charset = "UTF-8";
 /*       String accessKey = "81W05fJOi5yRDBL8";
        String secretKey = "aVUJ0cwFJ3BblHT6nD09WhG9xceA8ZGr5KHGE1UhRIO0ewndavP7m2Q0o9wXP96k";*/
        String accessKey = "0eP58dfebH7e0C71";
        String secretKey = "XhEeJhyB9bxug2WaEOvgakG8zFd5Nc05BEJjXliEiAvR8MUUjo8N9KsK6SZ80UGV";
        
        ALMmsUploadResource alMmsUploadResource = new ALMmsUploadResource();
        alMmsUploadResource.setAccessKey(accessKey);
        alMmsUploadResource.setTemplateId(UUID.randomUUID().toString());
        alMmsUploadResource.setTimestamp(String.valueOf(System.currentTimeMillis()));
        alMmsUploadResource.setTitle("视频短信测试");
        List<List<Map<String, String>>> resourceList =  getResourceList();
        alMmsUploadResource.setResourceList(JSON.toJSONString(resourceList));
        alMmsUploadResource.setSign(getAlTmplateUploadSign(alMmsUploadResource,url,secretKey,accessKey));
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(alMmsUploadResource);
        //System.err.println(requestBody);
        long millis = System.currentTimeMillis();
        HttpResult httpResult = (new HttpUtils()).post(url, header, charset, requestBody);
        System.out.println(System.currentTimeMillis() - millis);
        System.out.println(httpResult);
	}

	private static String getAlTmplateUploadSign(ALMmsUploadResource resource,String url,String secretKey, String accessKey) throws Exception {
		StringBuilder builder = new StringBuilder();
		builder.append(secretKey).append(new URL(url).getPath()).append("?").append("timestamp=")
		.append(resource.getTimestamp()).append("&title=").append(resource.getTitle())
		.append("&type=").append(resource.getTemplateId()).append("&username=").append(accessKey);
		return DigestUtils.md5Hex(builder.toString()).toLowerCase();
	}

/*	private static List<Map<String, String>> getResourceList() throws Exception {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> headjpg = new HashMap<>();
		headjpg.put("name", "激战head.jpg");
		String headjpgurl = "C:\\Users\\ljm\\Desktop\\测试视频短信素材\\改01头.jpg";
		headjpg.put("content",getEncodeBase64Str(headjpgurl));
		Map<String, String> file = new HashMap<>();
		file.put("name", "激战.txt");
		String fileUrl = "C:\\Users\\ljm\\Desktop\\测试视频短信素材\\AW超级短信文案.txt";
		file.put("content", getFileStr(fileUrl));
		Map<String, String> video = new HashMap<>();
		video.put("name", "激战.mp4");
		String videoUrl = "C:\\Users\\ljm\\Desktop\\测试视频短信素材\\AW大客户超级短信.mp4";
		video.put("content", getEncodeBase64Str(videoUrl));
		Map<String, String> endjpg = new HashMap<>();
		endjpg.put("name", "激战end.jpg");
		String endjpgUrl = "C:\\Users\\ljm\\Desktop\\测试视频短信素材\\改02尾.jpg";
		endjpg.put("content",  getEncodeBase64Str(endjpgUrl));
		Map<String, String> endjpgq = new HashMap<>();
		endjpgq.put("name", "激战end.jpg");
		String endjpgUrlq = "C:\\Users\\ljm\\Desktop\\测试视频短信素材\\改02尾.jpg";
		endjpgq.put("content",  getEncodeBase64Str(endjpgUrlq));
		list.add(headjpg);
		list.add(file);
		list.add(video);
		list.add(endjpg);
		list.add(endjpgq);
		return list;
	}*/
	private static List<List<Map<String, String>>> getResourceList() throws Exception {
		List<List<Map<String, String>>> list = new ArrayList<>();
		List<Map<String, String>> list1 = new ArrayList<>();
		List<Map<String, String>> list2 = new ArrayList<>();
		Map<String, String> headjpg = new HashMap<>();
		headjpg.put("name", "激战head.jpg");
		String headjpgurl = "C:\\Users\\ljm\\Desktop\\测试视频短信素材\\改01头.jpg";
		headjpg.put("content",getEncodeBase64Str(headjpgurl));
		Map<String, String> file = new HashMap<>();
		file.put("name", "激战.txt");
		String fileUrl = "C:\\Users\\ljm\\Desktop\\测试视频短信素材\\AW超级短信文案.txt";
		file.put("content", getFileStr(fileUrl));
		Map<String, String> video = new HashMap<>();
		video.put("name", "激战.mp4");
		String videoUrl = "C:\\Users\\ljm\\Desktop\\测试视频短信素材\\AW大客户超级短信.mp4";
		video.put("content", getEncodeBase64Str(videoUrl));
		Map<String, String> endjpg = new HashMap<>();
		endjpg.put("name", "激战end.jpg");
		String endjpgUrl = "C:\\Users\\ljm\\Desktop\\测试视频短信素材\\改02尾.jpg";
		endjpg.put("content",  getEncodeBase64Str(endjpgUrl));
		Map<String, String> endjpgq = new HashMap<>();
		endjpgq.put("name", "激战end.jpg");
		String endjpgUrlq = "C:\\Users\\ljm\\Desktop\\测试视频短信素材\\改02尾.jpg";
		endjpgq.put("content",  getEncodeBase64Str(endjpgUrlq));
		list1.add(file);
		list2.add(headjpg);
		list2.add(video);
		list2.add(endjpg);
		list2.add(endjpgq);
		list.add(list1);
		list.add(list2);
		return list;
	}
	
	private static String getFileStr(String fileUrl) throws Exception {
		String str = null;
		try(FileInputStream input = new FileInputStream(new File(fileUrl))) {
			byte[] buffer = new byte[1024*4];
		    int n = 0;
		    while (-1 != (n = input.read(buffer))) {
		       str =  new String(buffer,0,n);
		    }
		} 
		return str;
	}

	private static String getEncodeBase64Str(String url) throws Exception{
		byte[] byteArray;
		try (FileInputStream input = new FileInputStream(new File(url));
				ByteArrayOutputStream  output = new ByteArrayOutputStream()
				){
				byte[] buffer = new byte[1024*4];
			    int n = 0;
			    while (-1 != (n = input.read(buffer))) {
			        output.write(buffer, 0, n);
			    }
			    byteArray = output.toByteArray();
		} 
		String encodeToString = Base64Utils.encodeToString(byteArray);
		System.err.println(encodeToString.length());
		return encodeToString;
	}
	
	public static void main2(String[] args) throws Exception {
        //String url = "http://localhost:8085/api/mms/al/send/sendMessage";
        String url = "http://120.192.248.130:8085/api/mms/al/send/sendMessage";//正式环境
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json;charset=utf-8");
        header.put("Accept", "application/json");
        String charset = "UTF-8";
/*        String accessKey = "81W05fJOi5yRDBL8";
        String secretKey = "aVUJ0cwFJ3BblHT6nD09WhG9xceA8ZGr5KHGE1UhRIO0ewndavP7m2Q0o9wXP96k";*/
        String accessKey = "0eP58dfebH7e0C71";
        String secretKey = "XhEeJhyB9bxug2WaEOvgakG8zFd5Nc05BEJjXliEiAvR8MUUjo8N9KsK6SZ80UGV";
        
        String destNumber = "13582369300";
        String sequenceNumber = UUID.randomUUID().toString();
        String templateId = "3";//TODO
        String timestamp = String.valueOf(System.currentTimeMillis());
        
        ALMmsSubmit submit = new ALMmsSubmit();
        submit.setAccessKey(accessKey);
        submit.setDestNumber(destNumber);
        submit.setSequenceNumber(sequenceNumber);
        submit.setTemplateId(templateId);
        submit.setTimestamp(timestamp);  
        submit.setSign(getAlSubmitSign(submit,url,secretKey,accessKey));
        submit.setExtNum("666");//TODO 扩展码
        
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(submit);
        //System.err.println(requestBody);
        long millis = System.currentTimeMillis();
        HttpResult httpResult = (new HttpUtils()).post(url, header, charset, requestBody);
        System.out.println(System.currentTimeMillis() - millis);
        System.out.println(httpResult);
         
	}

	private static String getAlSubmitSign(ALMmsSubmit submit, String url, String secretKey, String accessKey) throws Exception {
		StringBuilder builder = new StringBuilder();
		builder.append(secretKey).append(new URL(url).getPath()).append("?").append("id=").append(submit.getTemplateId())
		.append("&sequenceNumber=").append(submit.getSequenceNumber()).append("&timestamp=").append(submit.getTimestamp())
		.append("&userNumber=").append(submit.getDestNumber()).append("&username=").append(accessKey);
		return DigestUtils.md5Hex(builder.toString()).toLowerCase();
	}
	
	
	public static void main(String[] args) throws Exception {
		// 上传资源
		//main1(args);
		//下发
		//main2(args);
		
		//账户名生成规则
	/*	String RANDOM_CHARS = "0123456789";
		System.err.println(RandomStringUtils.random(6, RANDOM_CHARS));*/
		
	}
}
