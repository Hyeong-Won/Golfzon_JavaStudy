<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <%!
    String   strName;
    String   strPassWord;
    String[] arrHobby;
    %>
    
    <%-- Request --%>
    <%
    strName = request.getParameter("txtName");
    strPassWord = request.getParameter("txtPassWord");
    arrHobby = request.getParameterValues("ckbHobby");
    %>
    
    <%-- 출력 --%>
    이름 : <%=strName %></br>
    암호 : <%=strPassWord %></br>
    취미 : 
    <%
    for (int i = 0; i < arrHobby.length; i++) {
    %>
        <%=arrHobby[i] %></br>
    <%
    }
    %>
    
    
</body>
</html>