<%@ page language="java" contentType="text/html; charset=EUC-KR" 
   pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="EUC-KR">
        <title>Insert title here</title>
    </head>
    <body>
		
		<%
		
			Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies) {
				out.print("name : " + c.getName() + "</br>");
				out.print("value : " + c.getValue() + "</br></br>");
			}
		
		%>
		
    </body>
</html>