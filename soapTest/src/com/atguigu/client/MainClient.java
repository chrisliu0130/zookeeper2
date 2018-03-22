package com.atguigu.client;

import com.atguigu.webservice.HelloWorld;
import com.atguigu.webservice.HelloWorldImplService;

public class MainClient {

	public static void main(String[] args) {
		HelloWorld helloWorld = new HelloWorldImplService().getHelloWorldImplPort();
		helloWorld.sayHello("awd", 22);
	}

}
