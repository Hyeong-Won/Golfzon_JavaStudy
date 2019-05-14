package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pjt12_00
 */
public class pjt12_00 extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String adminId = getServletConfig().getInitParameter("adminId");
		String adminPw = getServletConfig().getInitParameter("adminPw");
		
		PrintWriter out = response.getWriter();
		out.print("<p>adminId : " + adminId + "</p>");
		out.print("<p>adminPw : " + adminPw + "</p>");
		
		String dir = getServletContext().getInitParameter("imgDir");
		String IP = getServletContext().getInitParameter("testServerIP");
		out.print("<p>dir : " + dir + "</p>");
		out.print("<p>IP : " + IP + "</p>");		
		
		getServletContext().setAttribute("test", "test12");
		String test = (String)getServletContext().getAttribute("test");
		out.print("<p>test : " + test + "</p>");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
