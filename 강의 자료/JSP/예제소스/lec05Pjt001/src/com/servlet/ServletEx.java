package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
//@WebServlet(name="servletEx", urlPatterns= {"/Hello", "/SE"})
public class ServletEx extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>ServletEX</title></head>");
		out.print("<body>");
		out.print("Hello Servlet~");
		out.print("</body>");
		out.print("</html>");
	}

}