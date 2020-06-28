package com.everything.demo.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everything.demo.mapper.TimeLimitMapper;
import com.everything.demo.po.MineMessage;
import com.everything.demo.po.MineObservable;
import com.everything.demo.po.OrderObservable;
import com.everything.demo.po.TestMessage;
import com.everything.demo.po.TimeLimit;
import com.fasterxml.jackson.databind.ObjectMapper;

import freemarker.core.Macro;

@RestController
public class DemoController {

	@Autowired
	private TimeLimitMapper timeLimitMapper;

	@Autowired
	private String uploadExcelDir;

	/*
	 * @Autowired private ApplicationContext applicationContext;
	 */

	@Autowired
	private MineObservable mineObservable;

	@RequestMapping("/test")
	public String test() {
		TimeLimit timeLimit = timeLimitMapper.selectByPrimaryKey(10L);
		return "测试============" + timeLimit.getChannelName();
	}
	
	@RequestMapping("/doEvent")
	public String doEvent(HttpServletRequest request) throws Exception {
		String requestBody = getRequestBody(request);
		ObjectMapper mapper = new ObjectMapper();
		TestMessage message = mapper.readValue(requestBody, TestMessage.class);
		mineObservable.addObserver(new MineMessage(message.getMessage()));
		return "doEvent......";
	}

	private String getRequestBody(HttpServletRequest request) throws IOException {
		StringBuilder builder = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
			int length;
			char[] buffer = new char[256];
			while ((length = reader.read(buffer)) != -1) {
				builder.append(buffer, 0, length);
			}
		}
		String requestBody = builder.toString();
		System.err.println(requestBody);
		return requestBody;
	}

	@RequestMapping("/upload")
	public void upload(HttpServletResponse response, HttpServletRequest request) {
		InputStream inputStream = null;
		ServletOutputStream servletOutputStream = null;
		try {
			String filename = "统计.txt";
			String path = "测试.txt";
			// Resource resource = new ClassPathResource(uploadExcelDir + path);

			response.setContentType("application/vnd.ms-excel");
			response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.addHeader("charset", "utf-8");
			response.addHeader("Pragma", "no-cache");
			String encodeName = URLEncoder.encode(filename, StandardCharsets.UTF_8.toString());
			response.setHeader("Content-Disposition",
					"attachment; filename=\"" + encodeName + "\"; filename*=utf-8''" + encodeName);

			inputStream = new FileInputStream(new File(uploadExcelDir + path));
			servletOutputStream = response.getOutputStream();
			IOUtils.copy(inputStream, servletOutputStream);
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (servletOutputStream != null) {
					servletOutputStream.close();
					servletOutputStream = null;
				}
				if (inputStream != null) {
					inputStream.close();
					inputStream = null;
				}
				// 召唤jvm的垃圾回收器
				System.gc();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	@RequestMapping("/template/result")
	public Map<String, Object> tempalteResult(HttpServletResponse response, HttpServletRequest request) throws Exception{
		String requestBody = getRequestBody(request);
		System.err.println(requestBody);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", 0);
		map.put("submitSequenceNumber", "123456");		
		return map;
	}
	
	@RequestMapping("/report/result")
	public Map<String, Object> reportResult(HttpServletResponse response, HttpServletRequest request) throws Exception{
		String requestBody = getRequestBody(request);
		System.err.println(requestBody);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("message", "123456");		
		return map;
	}
		
	
}
