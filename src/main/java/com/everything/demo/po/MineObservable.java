package com.everything.demo.po;

import java.util.Observable;

import org.springframework.stereotype.Component;

@Component
public class MineObservable extends Observable{
	
	public void update(){
		setChanged();
		notifyObservers();
	}
	
	public static void main(String[] args) {
		MineObservable mineObservable = new MineObservable();
		mineObservable.addObserver(new MineMessage("您好您的验证码是123456"));
		mineObservable.update();
	}
}
