<%@ page language="java" contentType="text/html; charset=EUC-KR" 
   pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="EUC-KR">
        <title>Insert title here</title>
    </head>
    <body>
		
		<%!
			String connectedIP;
			String connectedUser;
			
		%>
		
		<!-- application 객체 -->
		<%
			connectedIP = (String)application.getAttribute("connectedIP");
			connectedUser = (String)application.getAttribute("connectedUser");
		%>
		
		<p>connectedIP : <%= connectedIP %></p>
		<p>connectedUser : <%= connectedUser %></p>
		
    </body>
</html>