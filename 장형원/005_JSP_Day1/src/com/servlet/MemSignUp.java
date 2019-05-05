package com.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemSignUp
 */
@WebServlet("/MSU")
public class MemSignUp extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" -- doGet() -- ");

        String m_name      = request.getParameter("m_name");
        String m_pass      = request.getParameter("m_pass");
        String m_gender    = request.getParameter("m_gender");
        String[] m_hobbys  = request.getParameterValues("m_hobby");
        String m_residence = request.getParameter("m_residence");

        System.out.println("m_name : " + m_name);
        System.out.println("m_pass : " + m_pass);
        System.out.println("m_gender : " + m_gender);
        System.out.println("m_hobbys : " + Arrays.toString(m_hobbys));
        System.out.println("m_residence : " + m_residence);

        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            System.out.println("name : " + name);
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
