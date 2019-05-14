<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <%@ include file="header.jsp" %>

    <%!
    int num = 100;
    String str = "jsp";
    %>
    
    <%!
    public void jspMethod() {
        System.out.println("jspMethod()");
    }
    %>
    
    <%
    jspMethod();
    %>
    
    <%@ include file="footer.jsp" %>
    
    <%
    response.sendRedirect("header.jsp");
    %>
</body>
</html>