<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="EUC-KR"%>
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
String realServerIP;

String test;
String test2;
%>

<%
adminId = config.getInitParameter("adminId");
adminPw = config.getInitParameter("adminPw");

imgDir = application.getInitParameter("imgDir");
testServerIP = application.getInitParameter("testServerIP");
realServerIP = application.getInitParameter("realServerIP");

application.setAttribute("test1", "test11");

test = (String)application.getAttribute("test1");
%>

<p>ID : <%= adminId %></p>
<p>PW : <%= adminPw %></p>

<p>Dir : <%= imgDir %></p>
<p>IP : <%= testServerIP %>, <%= realServerIP %></p>

<p> <%= test %></p>
<%out.print(test2.toString()); %>
</body>
</html>