package com.atguigu.service;

import org.apache.log4j.Logger;


public class UserServiceImpl
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	
	public void getUserInfo()
	{
		
			logger.debug("getUserInfo() - start");
		
		
		
			logger.debug("getUserInfo() - end");
	
	}
	
	
	public static void main(String[] args)
	{
		int age = 10;
		int result = 0;
		try
		{
			logger.debug("111111111111111");
			result = age/0;
			logger.debug("-----result: "+result);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error(e,e.getCause());
		}
	}

}
