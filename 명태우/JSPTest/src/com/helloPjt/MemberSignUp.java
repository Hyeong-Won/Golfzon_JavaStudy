package com.helloPjt;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberSignUp
 */
@WebServlet("/mSignUp")
public class MemberSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        System.out.println("-- doGet --");
        
        request.setCharacterEncoding("UTF-8");
        System.out.println("모든 Request Parameter Names");
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = (String)names.nextElement();
            System.out.println("name : " + name);
        }
        
        
        String   mName      = request.getParameter("txtName");
        String   mPassWord  = request.getParameter("txtPassWord");
        String   mGender    = request.getParameter("rdoGender");
        String[] mHobbys    = request.getParameterValues("ckbHobby");   //배열
        String   mResidence = request.getParameter("selResidence");
        
        System.out.println();
        System.out.printf("Name : %s, PassWord : %s, Gander : %s, Hobbys : %s, Residence : %s", mName, mPassWord, mGender, Arrays.toString(mHobbys), mResidence);
        System.out.println();
        
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append("Name      : " + mName).append(System.lineSeparator());
        response.getWriter().append("PassWord  : " + mPassWord).append(System.lineSeparator());
        response.getWriter().append("Gander    : " + mGender).append(System.lineSeparator());
        response.getWriter().append("Hobbys    : " + Arrays.toString(mHobbys)).append(System.lineSeparator());
        response.getWriter().append("Residence : " + mResidence).append(System.lineSeparator());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        System.out.println("-- doPost --");
        
        doGet(request, response);
	}

}
