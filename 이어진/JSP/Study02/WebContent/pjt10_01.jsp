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
String name;
String pass;
String[] hobbies;
%>

<%
name = request.getParameter("name");
pass = request.getParameter("pass");
hobbies = request.getParameterValues("hobby");
%>

name = <%= name %> <br>
pass = <%= name %> <br>
hobby = <% for(int i=0; i<hobbies.length; i++) {%><%= hobbies[i]%> <%} %>
</body>
</html>