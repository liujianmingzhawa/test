package com.everything.demo.po;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestMessage {
	
	@JsonProperty("message")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
