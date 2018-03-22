package com.atguigu.webservice;

public class HelloWorldImpl implements HelloWorld {

	@Override
	public String sayHello(String name, int age) {
		return "Hello, " + name + "(" + age + " years old)";
	}

}
