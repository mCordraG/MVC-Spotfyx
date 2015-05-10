<%-- 
    Document   : inicio
    Created on : 26-12-2014, 05:42:15 PM
    Author     : alrair141
--%>

<%@page import="control.UsuarioDAO"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <%
            if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
        %>
        <div class="formDC">
            <h2>Usuario No registrado</h2> 
            <button class="button"><a href="index.jsp">volver</a></button>
        </div>
        <%        
            } else {
                String user = session.getAttribute("userid").toString();
                if(user != null){
                    Usuario u = null;
                    UsuarioDAO udao = new UsuarioDAO();
                    u = udao.consultarUsuario(user);
                        %>
        <div class="formDC">
            <h1>Bienvenido <%=session.getAttribute("userid")%></h1> 
            <br>
            <input type="text" id="userhide" name="userhide" value="<%=user%>">
            <p>
                <a href='EditarUsuario.jsp'>Modificar Usuario</a>
            </p>
            <p>
                <a href="ListPlay.jsp">Mis Listas</a>
            </p>
            <p>
                <a href='logout.jsp'>Terminar Sesion</a>
            </p>
                   
        </div> 
                      
                      <%
                    }
                }
        %>



    </body>
</html>
