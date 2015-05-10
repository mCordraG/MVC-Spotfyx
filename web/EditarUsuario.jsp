<%-- 
    Document   : EditarUsuario
    Created on : 31-ene-2015, 13:03:52
    Author     : Marcos
--%>
<%@page import="control.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
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
            String nameus = session.getAttribute("userid").toString();
            String pass = "";
            String mail = "";
            int rango = 0;
            String[] datos = null;

            if (nameus != null) {
                UsuarioDAO udao = new UsuarioDAO();
                datos = udao.consultarDatosUsuario(nameus);
            } else {
                nameus = "";
            }
            if (datos != null) {
        %>
        <form action="UsuarioEditado.jsp" class="formRT" enctype='multipart/form-data'>
            <h1>Editar Trabajador</h1>
            <fieldset class="row6">
                <legend>Datos Personales
                </legend>
                <p>
                    <label>Nombre de Usuario
                    </label>
                    <input disabled type="text" id="usrname" value="<%=datos[0]%>"/>
                </p>
                <p>
                    <label>Correo
                    </label>
                    <input type="text" id="mail" name="mail" value="<%=datos[1]%>"/>
                </p>
                <p>
                    <label>Password
                    </label>
                    <input type="password" id="pass" name="pass" value="<%=datos[2]%>"/>
                </p>
            </fieldset>
            <fieldset class="row1">
                <div><button class="button" id="butreg">Editar &raquo;</button></div>
            </fieldset>
        </form>
        <%
        } else {%>
            <h1>Error con los datos de Usuario</h1>
        <%
                response.sendRedirect("index.jsp");
                }
            }
        %>            
    </body>
</html>
