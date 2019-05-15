package com.helloPjt;

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
//Java Annotation을 이용한 맵핑
@WebServlet("/EXGet")
//요청, 응답을 위한 HttpServlet 상속
public class ServletEXGet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEXGet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        String connectedIP   = (String)getServletContext().getAttribute("connectedIP");
        String connectedUser = (String)getServletContext().getAttribute("connectedUser");
        
        PrintWriter out = response.getWriter();
        out.print("<p>connectedIP   : " + connectedIP + "</p>");
        out.print("<p>connectedUser : " + connectedUser + "</p>");
        
	}

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
