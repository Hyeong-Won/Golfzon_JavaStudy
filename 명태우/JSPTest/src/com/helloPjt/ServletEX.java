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
@WebServlet("/EX")
//요청, 응답을 위한 HttpServlet 상속
public class ServletEX extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEX() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String adminID = getServletConfig().getInitParameter("adminID");
        String adminPW = getServletConfig().getInitParameter("adminPW");
        
        PrintWriter out = response.getWriter();
        out.print("<p>adminID : " + adminID + "</p>");
        out.print("<p>adminPW : " + adminPW + "</p>");
        
        String imgDir       = getServletContext().getInitParameter("imgDir");
        String testServerIP = getServletContext().getInitParameter("testServerIP");
        
        out.print("<p>imgDir       : " + imgDir + "</p>");
        out.print("<p>testServerIP : " + testServerIP + "</p>");
        
        getServletContext().setAttribute("connectedIP",   "100.10.10.203");
        getServletContext().setAttribute("connectedUser", "TW");
        
	}

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
