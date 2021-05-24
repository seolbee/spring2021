package com.yydh.myapp;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {
	private String name = "Sony 스피커";
	
	public SonySpeaker() {
		System.out.println(name+"==> 객체 생성 완료!");
	}
	
	@Override
	public void volumneDown() {
		System.out.println(name + "---볼륨을 내린다.");
		
	}

	@Override
	public void volumneUp() {
		System.out.println(name + "---볼륨을 높인다.");
	}
}
