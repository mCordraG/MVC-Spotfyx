<%-- 
    Document   : login
    Created on : 28-ene-2015, 19:05:16
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<%
    String userid = request.getParameter("user");    
    String pwd = request.getParameter("password");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/softwspotify","root", "1234");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from usuario where nombre='" + userid + "' and password='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("userid", userid);
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        System.out.print(userid);
        response.sendRedirect("inicio.jsp");
        
    } else {
        out.println("Invalid password <a href='index.jsp'>try again</a>");
    }
%>
</html>
