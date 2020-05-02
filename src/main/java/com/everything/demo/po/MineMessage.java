package com.everything.demo.po;

import java.util.Observable;
import java.util.Observer;

import org.springframework.stereotype.Component;

public class MineMessage implements Observer{
	
	private String message;
	
	public MineMessage(String message){
		this.message = message;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.err.println(message);
		
	}

}
