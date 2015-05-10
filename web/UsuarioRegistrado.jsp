<%-- 
    Document   : UsuarioRegistrado
    Created on : 30-ene-2015, 12:24:16
    Author     : Marcos
--%>

<%@page import="control.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario Registrado</title>
    </head>
   <body>    
        <div class="formRT">

            <%
                String usrname = request.getParameter("usrname");
                String mail = request.getParameter("mail");
                String password = request.getParameter("pass");
                UsuarioDAO udao = new UsuarioDAO();
                boolean a = udao.ingresarUsuario(usrname, mail, password);
                if (a != false) {
            %>
            <h1>Usuario Registrado</h1>
            <div>
                <fieldset>                                            
                    <button class="button"><a href="inicio.jsp">Volver</a></button> 
                    <button class="button"><a href="RegistrarTrabajador.jsp">Registrar otro Usuario</a></button>
                </fieldset>
            </div>
            <%
                }else{
                    %>
                    <h1>Usuario No Registrado</h1>
            <div>
                <fieldset>                                            
                    <button class="button"><a href="RegistrarUsuario.jsp">Volver</a></button> 
                </fieldset>
            </div>
            <%
                }
            %>
        </div>
    </body>
</html>
