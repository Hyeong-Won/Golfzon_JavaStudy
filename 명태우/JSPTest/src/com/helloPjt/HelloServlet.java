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
@WebServlet("/Hello")
//요청, 응답을 위한 HttpServlet 상속
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-- doGet : Servlet 실행 --");
        
        // TODO Auto-generated method stub
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append("Served at: ").append(request.getContextPath());
        
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<head>");
        out.print("<title>HelloServlet</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<p>Hello Servlet~~</p>");
        out.print("</body>");
        out.print("</html>");
	}

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-- doPost : Servlet 실행 --");
        
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    
    
    //생명 주기
    @PostConstruct
    public void fnPostConstuct() {
        System.out.println("-- PostConstruct : Servlet 생성 전 --");
    }
    
    @Override
    public void init() throws ServletException {
        System.out.println("-- init : Servlet 초기화 --");
    }
    
    @Override
    public void destroy() {
        System.out.println("-- destroy : Servlet 제거 --");
    }
    
    @PreDestroy
    public void fnPreDestroy() {
        System.out.println("-- PreDestroy : Servlet 제거 후 --");
    }
    

}
