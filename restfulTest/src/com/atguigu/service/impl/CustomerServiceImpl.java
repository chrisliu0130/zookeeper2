package com.atguigu.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.atguigu.entity.Customer;

@Path(value = "/crm")
public class CustomerServiceImpl {

	@Path(value = "/customer/{id}")
	@GET
	@Produces("application/xml")
	public Customer getCustomerById(@PathParam("id") String id) {
		Customer customer = new Customer("1", "zhangsan", 22);
		return customer;
	}
}