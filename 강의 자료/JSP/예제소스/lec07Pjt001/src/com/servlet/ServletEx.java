package com.servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SE")
public class ServletEx extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" -- doGet() -- ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println(" -- postConstruct() -- ");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println(" -- init() -- ");
	}
	
	@Override
	public void destroy() {
		System.out.println(" -- destroy() -- ");
	}
	
	@PreDestroy
	public void preDestory() {
		System.out.println(" -- preDestory() -- ");
		
	}

}
