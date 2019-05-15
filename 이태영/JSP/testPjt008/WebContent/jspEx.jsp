<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
 <head>
  <meta charset="EUC-KR">
  <title>Insert title here</title>
 </head>
 <body>
 	
 	<%!
 		String adminId;
 		String adminPw;
 		
 		String imgDir;
 		String testServerIP;
 		
 		String connectedIP;
 		String connectedUser;
 		String str;
 	%>
 	
 	<% 
 		adminId = config.getInitParameter("adminId");
 		adminPw = config.getInitParameter("adminPw");
 	%>
 	
 	<p>adminId : <%= adminId %></p>
 	<p>adminPw : <%= adminPw %></p>
 	
 	<%
 		imgDir 		 = application.getInitParameter("imgDir");
 		testServerIP = application.getInitParameter("testServerIP");
 	%>
 	
 	<p>imgDir       : <%= imgDir %></p>
 	<p>testServerIP : <%= testServerIP %></p> 	
 	
 	<%
 		application.setAttribute("connectedIP",   "127.0.0.1");
 		application.setAttribute("connectedUser", "hong");
 	%>
 	
 	<%
 		connectedIP   = (String)application.getAttribute("connectedIP");
 		connectedUser = (String)application.getAttribute("connectedUser");
 	%>
 	
 	<p>connectedIP   : <%= connectedIP %></p>
 	<p>connectedUser : <%= connectedUser %></p> 	
 	
 	<%
 		out.print("<h1>Hello JAVA    World!!</h1>");
 		out.print("<h1>Hello JSP     World!!</h1>");
 		out.print("<h1>Hello Servlet World!!</h1>");
 	%>
 	
 	<%
 		out.print(str.toString());
 	%>
 </body>
</html>