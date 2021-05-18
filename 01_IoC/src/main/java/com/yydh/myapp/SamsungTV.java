package com.yydh.myapp;

public class SamsungTV implements TV{
	private String name = "삼성 TV";
	
	public SamsungTV() {
		System.out.println("객체 생성 완료!!");
	}

	
	@Override
	public void powerOff() {
		System.out.println(name + "---전원을 끈다.");
		
	}
	
	@Override
	public void powerOn() {
		System.out.println(name + "---전원을 켠다.");
		
	}
	
	@Override
	public void volumneDown() {
		System.out.println(name + "---볼륨을 내린다.");
		
	}
	
	@Override
	public void volumneUp() {
		System.out.println(name + "---볼륨을 높인다.");
	}
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리..");
	}
	
	public void destoryMethod() {
		System.out.println("객체 삭제 전에 처리할 로직");
	}
}
