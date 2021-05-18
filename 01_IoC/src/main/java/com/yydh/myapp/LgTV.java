package com.yydh.myapp;

public class LgTV implements TV{
	private String name="LgTV";
	@Override
	public void powerOff() {
		System.out.println(name + "---전원이 꺼집니다.");
		
	}
	
	@Override
	public void powerOn() {
		System.out.println(name + "---전원이 켜집니다.");
		
	}
	
	@Override
	public void volumneDown() {
		System.out.println(name + "---볼륨을 낮춥니다.");
		
	}
	
	@Override
	public void volumneUp() {
		System.out.println(name + "---볼륨을 높입니다.");
		
	}
}
