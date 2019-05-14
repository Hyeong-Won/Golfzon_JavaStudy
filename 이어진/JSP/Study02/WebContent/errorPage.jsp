<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="EUC-KR"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Error</title>
</head>
<body>
<%
response.setStatus(200);
String msg = exception.getMessage();
%>
<%=msg %>
</body>
</html>