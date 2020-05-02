package com.everything.demo.po;

import org.springframework.context.ApplicationEvent;

import lombok.Data;

@Data
public class OrderObservable extends ApplicationEvent{
	
	private String message;

	public OrderObservable(Object source,String message) {
		super(source);
		this.message = message;
	}
	
	@Override
	public Object getSource() {
		return super.getSource();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
