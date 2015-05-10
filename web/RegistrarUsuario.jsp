<%-- 
    Document   : RegistrarUsuario
    Created on : 30-ene-2015, 12:09:52
    Author     : Marcos
--%>


<%@page import="control.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Registrar Usuario</title>
    </head>
    <body>    
        <%
            UsuarioDAO uDao = new UsuarioDAO();
        %>
        <form action="UsuarioRegistrado.jsp" class="formRT" enctype='multipart/form-data'>
            <h1>Registrar Trabajador</h1>
            <fieldset class="row6">
                <legend>Datos Personales
                </legend>
                <p>
                    <label>Nombre de Usuario
                    </label>
                    <input type="text" id="usrname" />
                </p>
                <p>
                    <label>Correo
                    </label>
                    <input type="text" id="mail" />
                </p>                
                <p>
                    <label>New Password
                    </label>
                    <input type="password" id="pass" name="pass" />
                </p>
                <p hidden>
                    <label>Confirm Password
                    </label>
                    <input type="password" id="passw" name="passw"/>
                </p>
            </fieldset>
            <fieldset class="row1">
                <div><button class="button" id="butreg">Registrar &raquo;</button></div>
                <input hidden type="text" id="valrango" name="valrango" >
            </fieldset>
        </form>         
    </body>
</html>
