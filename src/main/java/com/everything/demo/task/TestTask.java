package com.everything.demo.task;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.common.utils.ConcurrentHashSet;
import com.everything.demo.common.AbstractFixedThread;
import com.everything.demo.common.FixedThreadPool;
import com.everything.demo.po.AllSign;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.SCPInputStream;

@Component
@Configurable
@EnableScheduling
public class TestTask {
	
	protected FixedThreadPool executorService = new FixedThreadPool(50, getClass().getSimpleName());
	
	@Scheduled(cron = "0 */1 * * * ?")
	public void dotask2() throws Exception{
		getSCPFile();
	}
	
	public static void main(String[] args) throws Exception {
		getSCPFile();
	}
	
	public static void getSCPFile() throws Exception{
		//创建远程连接，默认连接端口为22，如果不使用默认，可以使用方法
		//new Connection(ip, port)创建对象
		try {
			Connection  conn = new Connection("47.93.6.145",24522);        
			//连接远程服务器
			conn.connect();
			System.err.println(conn.authenticateWithPassword("app", "cytest@01"));
			//使用用户名和密码登录
			SCPClient sc = new SCPClient(conn);

			SCPInputStream scpInputStream = sc.get("/home/app/down/mail/20200614_1.1statistics.xlsx");
			
			InputStream fis = (InputStream)scpInputStream;
			
			Workbook workbook = WorkbookFactory.create(fis);
			System.err.println(workbook.getSheetAt(1).getSheetName());
		} catch (IOException e) {   
			System.err.printf("用户%s密码%s登录服务器%s失败！", "app", "cytest@01", "47.93.6.145");
			e.printStackTrace();
	  }
	 
	}
	
	//@Scheduled(cron = "0 09 12 * * ?")
	public void doTask1(){
		System.err.println("------------doTask1");
		Set<AllSign> set = ConcurrentHashMap.newKeySet();
		//Set<AllSign> set = new ConcurrentHashSet<>();
		AtomicLong atomic = new AtomicLong(0);
		for(int i = 0; i<500; i++){
			executorService.submit(new AllSignThread(set, i,atomic));
		}

		
		while(true){
			if(500==atomic.get()){
				break;
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		}
		
		System.err.println(set.size());
		for (AllSign allSign : set) {
			System.err.println("===="+allSign.getAspect());
		}
	}
	
	class AllSignThread extends AbstractFixedThread{

		Set<AllSign> set;
		
		AtomicLong atomic;
		
		int i;
		
		public AllSignThread(Set<AllSign> set, int i,AtomicLong atomic) {
			this.atomic = atomic;
			this.set = set;
			this.i=i;
		}
		
		@Override
		public void process() throws Exception {
			AllSign allSign = new AllSign();
			allSign.setAspect(i+"");
			set.add(allSign);
			atomic.addAndGet(1);
		}
		
		
		
	}

}
