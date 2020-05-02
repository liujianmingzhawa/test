package com.everything.demo.manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

//@Component
public class Test {
	
	@Autowired
	private String uploadExcelDir;
	
	@PostConstruct
	public void init() throws Exception{
		List<String> lines = new ArrayList<String>();
		lines.add("这是"+"\r\n");
		lines.add("一个"+"\r\n");
		lines.add("测试");
		FileOutputStream output = new FileOutputStream(new File(uploadExcelDir+"测试.txt"));
		IOUtils.writeLines(lines, "", output, "UTF-8");
		System.err.println("写完。。。。。。。。。。。。。。。");
	}
}
