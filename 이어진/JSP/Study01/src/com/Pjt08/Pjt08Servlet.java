package com.Pjt08;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Pjt08Servlet
 */
@WebServlet("/P08")
public class Pjt08Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pjt08Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		System.out.println("-- doGet() --");
		
		String name 		= request.getParameter("m_name");
		String pass 		= request.getParameter("m_pass");
		String gender 		= request.getParameter("m_gender");
		String[] hobbys 	= request.getParameterValues("m_hobby");
		String residence 	= request.getParameter("m_residence");
		
		System.out.println("m_name : " + name);
		System.out.println("m_pass : " + pass);
		System.out.println("m_gender : " + gender);
		System.out.println("m_hobbys : " + Arrays.toString(hobbys));
		System.out.println("m_residence : " + residence);
		
		/*
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String temp = (String) names.nextElement();
			System.out.println("name : " + temp);
		}
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("-- doPost() --");
		
		doGet(request, response);
	}

}
