%<-- 
    Document   : logout
    Created on : 28-ene-2015, 22:47:52
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <%
        session.setAttribute("userid", null);
        session.invalidate();
        response.sendRedirect("index.jsp");
        %>
    </body>
</html>
