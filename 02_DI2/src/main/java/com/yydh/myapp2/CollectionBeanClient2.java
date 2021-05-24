package com.yydh.myapp2;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient2 {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext4.xml");
		CollectionBean2 bean = (CollectionBean2) factory.getBean("CollectionBean2");
		Map<String, String> addressList = bean.getAddressList();
		for(String key: addressList.keySet()) {
			System.out.println(addressList.get(key));
		}
	}
}
