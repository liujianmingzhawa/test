package cydemotwo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.util.Base64Utils;

import com.everything.demo.common.HttpResult;
import com.everything.demo.po.ALMmsUploadResource;
import com.everything.demo.po.HttpMmsSubmit;
import com.everything.demo.po.UploadResourcesMms;
import com.everything.demo.util.HttpUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpMms {

	public static void main1(String[] args) throws Exception {
		// String url =
		// "http://localhost:8085/api/mms/al/dyCheckSave/synSaveMms";
		String url = "http://120.192.248.130:8085/api/mms/upload/resources";// 正式环境
		Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json;charset=utf-8");
		header.put("Accept", "application/json");
		String charset = "UTF-8";
		/*
		 * String accessKey = "81W05fJOi5yRDBL8"; String secretKey =
		 * "aVUJ0cwFJ3BblHT6nD09WhG9xceA8ZGr5KHGE1UhRIO0ewndavP7m2Q0o9wXP96k";
		 */
		String accessKey = "311L96s6Akk1Cm9W";
		String secretKey = "jtSlRxxubMp4jjjRzAeVIug4sMLy8Z04B1cunhkWbKUVRhgoICgbBGlEj7YGiGhU";
		String nonce = UUID.randomUUID().toString();
		String timestamp = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		String title = "视频短信测试";

		UploadResourcesMms upload = new UploadResourcesMms();
		upload.setAccessKey(accessKey);
		upload.setNonce(nonce);
		upload.setResourceList(getResourceList());
		upload.setTimestamp(timestamp);
		upload.setTitle(title);
		ObjectMapper mapper = new ObjectMapper();
		String requestBody = mapper.writeValueAsString(upload);

		String accessToken = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, secretKey).hmacHex(requestBody);
		System.err.println(accessToken);
		header.put("Access-Token", accessToken);
		long millis = System.currentTimeMillis();
		HttpResult httpResult = (new HttpUtils()).post(url, header, charset, requestBody);
		System.out.println(System.currentTimeMillis() - millis);
		System.out.println(httpResult);
	}

	private static List<Map<String, String>> getResourceList() throws Exception {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> headjpg = new HashMap<>();
		headjpg.put("name", "激战head.jpg");
		headjpg.put("type", "jpg");
		String headjpgurl = "C:\\Users\\ljm\\Desktop\\测试视频短信素材\\改01头.jpg";
		headjpg.put("content", getEncodeBase64Str(headjpgurl));
		Map<String, String> file = new HashMap<>();
		file.put("name", "激战.txt");
		file.put("type", "txt");
		String fileUrl = "C:\\Users\\ljm\\Desktop\\测试视频短信素材\\AW超级短信文案.txt";
		file.put("content", getFileStr(fileUrl));
		Map<String, String> video = new HashMap<>();
		video.put("name", "激战.mp4");
		video.put("type", "mp4");
		String videoUrl = "C:\\Users\\ljm\\Desktop\\测试视频短信素材\\AW大客户超级短信.mp4";
		video.put("content", getEncodeBase64Str(videoUrl));
		Map<String, String> endjpg = new HashMap<>();
		endjpg.put("name", "激战end.jpg");
		endjpg.put("type", "jpg");
		String endjpgUrl = "C:\\Users\\ljm\\Desktop\\测试视频短信素材\\改02尾.jpg";
		endjpg.put("content", getEncodeBase64Str(endjpgUrl));
		list.add(headjpg);
		list.add(file);
		list.add(video);
		list.add(endjpg);
		return list;
	}

	private static String getFileStr(String fileUrl) throws Exception {
		String str = null;
		try (FileInputStream input = new FileInputStream(new File(fileUrl))) {
			byte[] buffer = new byte[1024 * 4];
			int n = 0;
			while (-1 != (n = input.read(buffer))) {
				str = new String(buffer, 0, n);
			}
		}
		return str;
	}

	private static String getEncodeBase64Str(String url) throws Exception {
		byte[] byteArray;
		try (FileInputStream input = new FileInputStream(new File(url));
				ByteArrayOutputStream output = new ByteArrayOutputStream()) {
			byte[] buffer = new byte[1024 * 4];
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
		// String url =
		// "http://localhost:8085/api/mms/al/dyCheckSave/synSaveMms";
		String url = "http://120.192.248.130:8085/api/mms/submit/send";// 正式环境
		Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json;charset=utf-8");
		header.put("Accept", "application/json");
		String charset = "UTF-8";
		/*
		 * String accessKey = "81W05fJOi5yRDBL8"; String secretKey =
		 * "aVUJ0cwFJ3BblHT6nD09WhG9xceA8ZGr5KHGE1UhRIO0ewndavP7m2Q0o9wXP96k";
		 */
		String accessKey = "311L96s6Akk1Cm9W";
		String secretKey = "jtSlRxxubMp4jjjRzAeVIug4sMLy8Z04B1cunhkWbKUVRhgoICgbBGlEj7YGiGhU";
		String nonce = UUID.randomUUID().toString();
		String timestamp = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		String templateId = "0b3f2693-2464-4200-9611-4b86e5d9f3c1"; //TODO 每次需要更换
		HttpMmsSubmit submit = new HttpMmsSubmit();
		submit.setAccessKey(accessKey);
		submit.setCountryCode("86");
		submit.setDestNumber("17600240000,17600240001,17600240002,17600240003,17600240004,17600240005,17600240006,17600240007,17600240008,17600240009,17600240010,17600240011,17600240012,17600240013,17600240014,17600240015,17600240016,17600240017,17600240018,17600240019,17600240020,17600240021,17600240022,17600240023,17600240024,17600240025,17600240026,17600240027,17600240028,17600240029,17600240030,17600240031,17600240032,17600240033,17600240034,17600240035,17600240036,17600240037,17600240038,17600240039,17600240040,17600240041,17600240042,17600240043,17600240044,17600240045,17600240046,17600240047,17600240048,17600240049,17600240050,17600240051,17600240052,17600240053,17600240054,17600240055,17600240056,17600240057,17600240058,17600240059,17600240060,17600240061,17600240062,17600240063,17600240064,17600240065,17600240066,17600240067,17600240068,17600240069,17600240070,17600240071,17600240072,17600240073,17600240074,17600240075,17600240076,17600240077,17600240078,17600240079,17600240080,17600240081,17600240082,17600240083,17600240084,17600240085,17600240086,17600240087,17600240088,17600240089,17600240090,17600240091,17600240092,17600240093,17600240094,17600240095,17600240096,17600240097,17600240098,17600240099");
		submit.setExtendCode("6688");
		submit.setNonce(nonce);
		submit.setTemplateId(templateId);
		submit.setTimestamp(timestamp);
		ObjectMapper mapper = new ObjectMapper();
		String requestBody = mapper.writeValueAsString(submit);
		String accessToken = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, secretKey).hmacHex(requestBody);
		System.err.println(accessToken);
		header.put("Access-Token", accessToken);
		long millis = System.currentTimeMillis();
		HttpResult httpResult = (new HttpUtils()).post(url, header, charset, requestBody);
		System.out.println(System.currentTimeMillis() - millis);
		System.out.println(httpResult);

	}
	
	public static void main(String[] args) throws Exception {
	   main2(args);
	   //main1(args);
		
	}
}
