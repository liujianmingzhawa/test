package com.everything.demo.manager;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.everything.demo.common.AbstractFixedThread;
import com.everything.demo.common.FixedThreadPool;
import com.everything.demo.mapper.FixedSignRouteMapper;
import com.everything.demo.po.FixedSignRoute;

//@Component
public class FixedSignRouteMannager {
	protected FixedThreadPool executorService = new FixedThreadPool(50, getClass().getSimpleName());
	
	@Autowired
	private FixedSignRouteMapper fixedSignRouteMapper;
	
	@PostConstruct
	private void inint() throws Exception{
		String[] readLine = IOUtils.readLines(new File("C:\\Users\\ljm\\Desktop\\1022\\正常签名.txt"));
		List<String> list = Arrays.asList(readLine);
		System.err.println(list.size());
		for (String str : list) {
			if(StringUtils.isEmpty(str)){
				continue;
			}
			executorService.submit(new SaveFixedSign(str));

		}
	}
	
	class SaveFixedSign extends AbstractFixedThread {
		
		private String str;
		
		public SaveFixedSign(String str){
			this.str = str;
		}
		
		@Override
		public void process() throws Exception {
			String[] split = str.split("\\s+");
			FixedSignRoute record = new FixedSignRoute();
			Date now = new Date();
			record.setDestChannel("sdyd1069067710");
			record.setExtendCode(split[0]);
			record.setIsValid(1);
			record.setSignature(split[1]);
			record.setId(null);
			record.setGmtCreate(now);
			record.setGmtModified(now);
			if(fixedSignRouteMapper.insert(record)!=1){
				System.err.println(split[0]+"----"+split[1]);
			}
			
		}
		
	}
}
