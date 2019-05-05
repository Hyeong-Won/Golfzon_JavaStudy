package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HS")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
	    
	    out.print("<html>");
	    out.print("<head>");
	    out.print("</head>");
	    out.print("<body>");
	    out.print("HelloServlet!!");
	    out.print("</body>");
	    out.print("</html>");
	    
	    System.out.println("doGet()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@PostConstruct
    public void postConstruct() {
        System.out.println("-- postConstruct() --");
    }
    
	@Override
	public void init() throws ServletException {
	    System.out.println("-- init() --");
	}

    @Override
    public void destroy() {
        System.out.println("-- destroy() --");
    }
    
    @PreDestroy
    public void preDestroy() {
        System.out.println("-- preDestroy() --");
    }
    
}
