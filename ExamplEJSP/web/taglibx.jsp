<%-- 
    Document   : check
    Created on : 19-Jan-2025, 2:09:41 pm    
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="is_error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:set var="name" value=" This is a example of taglib"></c:set>
        <c:out value="${name}"></c:out>  
        <c:if test="${3>2}">
            <h1>
                yes this is true
            </h1>
        </c:if>
        <%
            int n=100;
            int m=0;
            
            %>
            <%
            int division=n/m;
                    %>
        <h1>division =<%=division %></h1>
    </body> 
</html>
