<%-- 
    Document   : index
    Created on : 26-12-2014, 04:54:57 PM
    Author     : alrair141
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Login</title>
        <link rel="shortcut icon" href="img/Logo.png"> 
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="CSS/newcss.css"/>
        <script src="https://raw.github.com/digitalBush/jquery.maskedinput/1.3.1/dist/jquery.maskedinput.min.js" type="text/javascript"></script>
    </head>
    <body>
        <header>
                <img src="img/Logo.png">
        </header>
        <div class="container">
            <form action="login.jsp">
                <h1 class="title"><span>Iniciar Sesión</span> </h1>
                <p class="parrafo">
                    <label for="login"><i class="icon-user" ></i>Usuario</label>
                    <input  class="texto" type="text" id="user" name="user" placeholder="Nombre de Usuario" required>
                </p>
                </br>
                <p class="parrafo">
                    <label for="password"><i class="icon-lock"></i>Contraseña</label>
                    <input class="texto" type="password" id="password" name="password" placeholder="Contraseña" class="showpassword" required>
                </p>
                </br>
                <p class="parrafo"> 

                    <input type="submit" name="submit" value="Log in">
                </p>
                </br>
                <p class="parrafo">
                    <a href='RegistrarUsuario.jsp'>Usuario nuevo Registrate ahora</a>
                </p>
            </form>​​
        </div>
        <!-- jQuery if needed -->
        <script>
            $(function () {
                $(".showpassword").each(function (index, input) {
                    var $input = $(input);
                    $("<p class='opt'/>").append(
                            $("<input type='checkbox' class='showpasswordcheckbox' id='showPassword' />").click(function () {
                        var change = $(this).is(":checked") ? "text" : "password";
                        var rep = $("<input placeholder='Password' type='" + change + "' />")
                                .attr("id", $input.attr("id"))
                                .attr("name", $input.attr("name"))
                                .attr('class', $input.attr('class'))
                                .val($input.val())
                                .insertBefore($input);
                        $input.remove();
                        $input = rep;
                    })
                            ).append($("<label for='showPassword'/>").text("Show password")).insertAfter($input.parent());
                });

                $('#showPassword').click(function () {

                    if ($("#showPassword").is(":checked")) {
                        $('.icon-lock').addClass('icon-unlock');
                        $('.icon-unlock').removeClass('icon-lock');

                    } else {
                        $('.icon-unlock').addClass('icon-lock');
                        $('.icon-lock').removeClass('icon-unlock');
                    }
                });
            });
        </script>
    </body>
</html>
