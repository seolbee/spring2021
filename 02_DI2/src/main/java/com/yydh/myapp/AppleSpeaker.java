package com.yydh.myapp;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{
	
	private String name = "Apple 스피커";
	
	public AppleSpeaker() {
		System.out.println(name+"==> 객체 생성 완료!");
	}
	
	public void volumneDown() {
		System.out.println(name + "---볼륨을 내린다.");
	}

	public void volumneUp() {
		System.out.println(name + "---볼륨을 높인다.");
	}
}
