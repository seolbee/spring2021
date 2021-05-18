package com.yydh.myapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
//		POJO방식
//		TV tv = new SamsungTV();
//		tv.powerOn();
//		tv.volumneUp();
//		tv.volumneDown();
//		tv.powerOff();
//		POJO End
		
		/*
		 * IoC-XML 방식
		 */
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv = (TV) factory.getBean("tv");
		
		factory.close();
	}
}
