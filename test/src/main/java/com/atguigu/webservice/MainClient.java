package com.atguigu.webservice;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class MainClient {

	public static void main(String[] args) {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setAddress("http://localhost:8888/WSTest");
		jaxWsProxyFactoryBean.setServiceClass(HelloWorld.class);
		HelloWorld helloWorld = (HelloWorld) jaxWsProxyFactoryBean.create();
		String word = helloWorld.sayHello("lisi", 30);
		System.out.println(word);
	}

}
