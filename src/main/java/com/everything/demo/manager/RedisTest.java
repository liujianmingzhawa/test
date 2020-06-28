package com.everything.demo.manager;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everything.demo.util.RedisUtils;

//@Component
public class RedisTest {
	
	@Autowired
	private RedisUtils redisUtils;
	
	
	@PostConstruct
	public void init() throws Exception{
		Long increment = redisUtils.increment("testincrementssss", 100L, 1, TimeUnit.HOURS);
		System.err.println(increment);
		Long increment2 = redisUtils.increment("testincrementssss", (56L - 100L));
		System.err.println("in2="+increment2);
	}
		
	
}
