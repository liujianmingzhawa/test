package com.everything.demo.manager;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import com.everything.demo.common.AbstractFixedThread;
import com.everything.demo.common.FixedThreadPool;
import com.everything.demo.common.HttpResult;
import com.everything.demo.util.HttpUtils;


//@Component
public class ObserverManager {
	protected  FixedThreadPool executorService = new FixedThreadPool(50, "test");
	
	@Autowired
	private ApplicationContext  applicationContext;
	
	@PostConstruct
	public void inint(){
        for (int i = 0; i < 50; i++) {
        	String message = "您好您的验证码是"+i;
			String requestBody = String.format("{\n" + "  \"message\": \"%s\"\n" + "}", message);
            executorService.submit(new TestThread(requestBody));
        }
	}
	
	 class  TestThread extends AbstractFixedThread {
		
		private String requestBody;
		
		public TestThread(String requestBody){
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
}
