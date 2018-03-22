package com.atguigu.service.impl;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

public class MainService {

	public static void main(String[] args) {
		JAXRSServerFactoryBean jAXRSServerFactoryBean = new JAXRSServerFactoryBean();
		jAXRSServerFactoryBean.setAddress("localhost:9988/customer");
		jAXRSServerFactoryBean.setResourceClasses(CustomerServiceImpl.class);
		jAXRSServerFactoryBean.create().start();

	}

}
