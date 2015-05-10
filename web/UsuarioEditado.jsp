<%-- 
    Document   : UsuarioEditado
    Created on : 31-ene-2015, 13:04:01
    Author     : Marcos
--%>

<%@page import="control.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario Editado</title>
    </head>
    <body>
        <div class="formRT">
            <%
                String user = session.getAttribute("userid").toString();
                String mail = request.getParameter("mail");
                String pass = request.getParameter("pass");
                
                if( (user != null) || (pass !=null)){
                    UsuarioDAO udao = new UsuarioDAO();
                    if(udao.editarUsuario(user, mail, pass)){
            %>
            
            <h1>Usuario editado</h1>
            <%
                    }else{
                    %>
            <h1>Usuario no editado</h1>
            <%
                    }
            } else {
            %>
            <h1>Error al editar el Usuario</h1>
            <%
                }

            %>
            <div>
                <fieldset>

                    <button class="button"><a href="inicio.jsp">volver</a></button> 
                     
                </fieldset>
            </div>
        </div>
    </body>
</html>
