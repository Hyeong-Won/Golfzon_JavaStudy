<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <%-- 선언 태그 : Java 맴버변수 또는 메서드 선언 --%>
    <%!
    int num = 10;
    String str = "jsp";
    ArrayList<String> list = new ArrayList<String>();
    
    public void jspMethod() {
        System.out.println(" jspMethod() ");
    }
    %>
    
    <!-- html 주석 태그 -->
    <%--jsp 주석 태그 --%>
    
    <%-- 스크립트릿 태그 : Java 코드 사용 --%>
    <%
    if (num > 0 ) {
    %>
    <p>num > 0</p>
    
    <%
    } else {
    %>
    <p>num <= 0</p>
    <%
    }
    %>
    
    <%-- 표션식 태그 : Java 변수 및 메서드 반환값 출력 --%>
    num = <%=num %>
    
    <%-- 지시어 --%>
    <%--
    1. page : 기본 설정 --> <% page 속성 = "속성값" >
    2. include : include file 설정 --> <% include file = "파일명" >
    3. taglib : 외부라이브러리 태그 설정 --> <% taglib uri = "uri" prefix = "네임스페이스명" >
     --%>
    
    
    <%@ include file="includeTest.jsp" %>
</body>
</html>