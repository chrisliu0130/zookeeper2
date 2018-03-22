package com.atguigu.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

	public Customer() {
	}

	private String id;
	private String name;
	private Integer age;

	public Customer(String id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
