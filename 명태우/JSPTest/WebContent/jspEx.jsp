<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorJSP.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <%!
    String adminID;
    String adminPW;
    
    String imgDir;
    String testServerIP;
    
    String errMsg;
    %>
    
    <%-- config 객체 사용 --%>
    <%
    adminID = config.getInitParameter("adminID");
    adminPW = config.getInitParameter("adminPW");
    %>
    
    <p>adminID : <%=adminID %></p>
    <p>adminPW : <%=adminPW %></p>
    
    <%-- application 객체 사용 --%>
    <%
    imgDir       = application.getInitParameter("imgDir");
    testServerIP = application.getInitParameter("testServerIP");
    %>
    
    <p>imgDir       : <%=imgDir %></p>
    <p>testServerIP : <%=testServerIP %></p>
    
    <%
    application.setAttribute("connectedIP",   "100.10.10.203");
    application.setAttribute("connectedUser", "TW");
    %>
    
    
    <%--out 객체 사용 --%>
    <%
    out.print("<h1>Hello~~~Test</h1>");
    %>
    
    <%--exception 객체 사용 --%>
    <%
    out.print(errMsg.toString());
    %>
    
    
    
</body>
</html>