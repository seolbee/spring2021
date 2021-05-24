package com.yydh.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV{
	private String name = "삼성 TV";
	//추가
	@Autowired
	@Qualifier("apple")
	private Speaker speaker;
	
	public SamsungTV() {
		System.out.println("객체 생성 완료!!");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("객체 생성 완료 222");
		this.speaker = speaker;
	}
	
	@Override
	public void powerOff() {
		System.out.println(name + "---전원을 끈다.");
	}
	
	@Override
	public void powerOn() {
		System.out.println(name + "---전원을 켠다 ");
	}
	
	@Override
	public void volumneDown() {
		speaker.volumneDown();
	}
	
	@Override
	public void volumneUp() {
		speaker.volumneUp();
	}
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리..");
	}
	
	public void destoryMethod() {
		System.out.println("객체 삭제 전에 처리할 로직");
	}
}
