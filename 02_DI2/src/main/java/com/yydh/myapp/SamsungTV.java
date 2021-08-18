package com.yydh.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV{
	
	@Autowired
	@Qualifier("apple")
	private Speaker speaker;
	
	public SamsungTV() {
		System.out.println("객체 생성 완료!!");
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV---전원을 켠다");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV---전원을 끈다");
		
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();		//추가
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();	//추가
	}
	
	
	
}
