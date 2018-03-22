package com.atguigu.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HelloWorldServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		int port2=request.getLocalPort();
		if(session.getAttribute("userid")==null){
			 String userid= String.valueOf(new Random().nextInt(100)) ;
			 session.setAttribute("userid", userid);
			 response.getWriter().append("Hello, "+userid+",this is "+port2+ " port");
		}else{
			String userid=(String)session.getAttribute("userid");
			response.getWriter().append("Welcome back, "+userid+", this is "+port2+" port") ;
		}
 
	}
}
