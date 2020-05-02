package com.everything.demo.po;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener implements ApplicationListener<OrderObservable>{

	@Override
	public void onApplicationEvent(OrderObservable event) {
		System.err.println(Thread.currentThread()+"---" + event.getMessage());
		
	}

}
