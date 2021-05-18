package com.yydh.myapp;

public class SamsungTV implements TV{
	private String name = "삼성 TV";
	//추가
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("객체 생성 완료!!");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("객체 생성 완료 222");
		this.speaker = speaker;
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("==> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("==> setPrice() 호출");
		this.price = price;
	}

	public SamsungTV(Speaker speaker, int price) {
		System.out.println("객체 생성 완료 333");
		this.speaker = speaker;
		this.price = price;//추가
	}
	
	@Override
	public void powerOff() {
		System.out.println(name + "---전원을 끈다.");
	}
	
	@Override
	public void powerOn() {
		System.out.println(name + "---전원을 켠다 (가격 : " + price + ")");
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
