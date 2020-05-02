package com.everything.demo.manager;

import java.util.Date;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everything.demo.common.AbstractFixedThread;
import com.everything.demo.common.FixedThreadPool;
import com.everything.demo.mapper.HttpsMoMapper;
import com.everything.demo.mapper.HttpsRptMapper;
import com.everything.demo.po.HttpsMo;
import com.everything.demo.po.HttpsRpt;
//@Component
public class HttpsRptMannager {
	protected FixedThreadPool executorService = new FixedThreadPool(100, getClass().getSimpleName());
	
	@Autowired
	private HttpsRptMapper httpsRptMapper;
	
	@Autowired
	private HttpsMoMapper httpsMoMapper;
	
	@PostConstruct
	public void inint(){
		for (long i=0; i<10000 ; i++) {
/*			HttpsRpt httpsRpt = new HttpsRpt();
			httpsRpt.setCode("DELIVRD");
			httpsRpt.setDestNumber("13582369300");
			httpsRpt.setUuid(UUID.randomUUID().toString());
			httpsRpt.setGmtReport(new Date());
			executorService.submit(new SaveHttpsRpt(httpsRpt));*/
			HttpsMo httpsMo = new HttpsMo();
			httpsMo.setContent("测试");
			httpsMo.setDestChannel("httptest");
			httpsMo.setGmtCreate(new Date());
			httpsMo.setExtendCode("123");
			executorService.submit(new SaveHttpsMo(httpsMo));
		}
	}
	
	class SaveHttpsRpt extends AbstractFixedThread{
		
		private HttpsRpt httpsRpt;
		
		public SaveHttpsRpt(HttpsRpt httpsRpt) {
			this.httpsRpt = httpsRpt;
		}

		@Override
		public void process() throws Exception {
			httpsRptMapper.insertSelective(httpsRpt);			
		}			
	}
	
	class SaveHttpsMo extends AbstractFixedThread{
		
		private HttpsMo httpsMo;
		
		public SaveHttpsMo(HttpsMo httpsMo) {
			this.httpsMo = httpsMo;
		}
		
		@Override
		public void process() throws Exception {
			httpsMoMapper.insertSelective(httpsMo);
			
		}
		
	}
}
