package com.Pjt07;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Pjt07Servlet
 */
@WebServlet("/P07")
public class Pjt07Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pjt07Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @PostConstruct
    private void funcPc() {
		// TODO Auto-generated method stub
    	System.out.println("-- @PostConstruct --");
	}
    
    @PreDestroy
    private void funPd() {
		// TODO Auto-generated method stub
    	System.out.println("-- @PreDestroy --");
	}
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("-- doGet () --");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doGet(req, resp);
    }
    
    @Override
    public void init() throws ServletException{
    	System.out.println("-- init () --");
    }

	@Override
	public void destroy() {
    	System.out.println("-- destroy () --");
	}
}
