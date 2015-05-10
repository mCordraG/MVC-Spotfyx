<%-- 
    Document   : ListPlay
    Created on : 08-may-2015, 2:19:00
    Author     : Marcos
--%>

<%@page import="control.CancionDAO"%>
<%@page import="java.util.List"%>
<%@page import="control.ListaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/Estilo.css"/>
        <title>Listas de Reproduccion</title>
    </head>
    <body>
        <div class="left">
            <table class="trabajadores">
                <thead>
                    <tr>
                        <th class="rut">Nombre Lista</th>
                        <th ></th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        ListaDAO ldao = new ListaDAO();

                        String nombre = ""; 
                        int i = 0;
                        String[] list = ldao.verListasUsuario(session.getAttribute("userid").toString());
                       
                        for (String l : list) {
                    %>
                    <tr>
                        <td><%=l%></td>
                        <td><button id="boton">Seleccionar</button></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <button value="Agregar">Agregar Lista</button>
            <button value="Eliminar">Eliminar Lista</button>
        </div>

        <div class="right">
             <table class="trabajadores">
                <thead>
                    <tr>
                        <th class="rut">Nombre Lista</th>
                        <th ></th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        CancionDAO cdao = new CancionDAO();

                        String cnombre = ""; 
                        i = 0;
                        String[] clist = ldao.verListasUsuario(session.getAttribute("userid").toString());
                       
                        for (String l : list) {
                    %>
                    <tr>
                        <td><%=l%></td>
                        <td><button id="boton">Seleccionar</button></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <button value="Agregar">Agregar Cancion</button>
            <button value="Eliminar">Eliminar Cancion</button>
        </div>

    </body>
</html>
