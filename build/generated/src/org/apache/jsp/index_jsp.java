package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html >\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\"> \n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> \n");
      out.write("        <title>Login</title>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"../favicon.ico\"> \n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"http://code.jquery.com/ui/1.10.2/jquery-ui.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/newcss.css\"/>\n");
      out.write("        <script src=\"https://raw.github.com/digitalBush/jquery.maskedinput/1.3.1/dist/jquery.maskedinput.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("        <header>\n");
      out.write("                <img src=\"img/Logo.png\">\n");
      out.write("        </header>\n");
      out.write("            <section>\n");
      out.write("            <form action=\"login.jsp\">\n");
      out.write("                <h1 class=\"title\"><span>Iniciar Sesión</span> </h1>\n");
      out.write("                <p class=\"parrafo\">\n");
      out.write("                    <label for=\"login\"><i class=\"icon-user\" ></i>Usuario</label>\n");
      out.write("                    <input  class=\"texto\" type=\"text\" id=\"user\" name=\"user\" placeholder=\"Nombre de Usuario\" required>\n");
      out.write("                </p>\n");
      out.write("                </br>\n");
      out.write("                <p class=\"parrafo\">\n");
      out.write("                    <label for=\"password\"><i class=\"icon-lock\"></i>Contraseña</label>\n");
      out.write("                    <input class=\"texto\" type=\"password\" id=\"password\" name=\"password\" placeholder=\"Contraseña\" class=\"showpassword\" required>\n");
      out.write("                </p>\n");
      out.write("                </br>\n");
      out.write("                <p class=\"parrafo\"> \n");
      out.write("\n");
      out.write("                    <input type=\"submit\" name=\"submit\" value=\"Log in\">\n");
      out.write("                </p>\n");
      out.write("                </br>\n");
      out.write("                <p class=\"parrafo\">\n");
      out.write("                    <a href='RegistrarUsuario.jsp'>Usuario nuevo Registrate ahora</a>\n");
      out.write("                </p>\n");
      out.write("            </form>​​\n");
      out.write("            </section>\n");
      out.write("        </div>\n");
      out.write("        <!-- jQuery if needed -->\n");
      out.write("        <script>\n");
      out.write("            $(function () {\n");
      out.write("                $(\".showpassword\").each(function (index, input) {\n");
      out.write("                    var $input = $(input);\n");
      out.write("                    $(\"<p class='opt'/>\").append(\n");
      out.write("                            $(\"<input type='checkbox' class='showpasswordcheckbox' id='showPassword' />\").click(function () {\n");
      out.write("                        var change = $(this).is(\":checked\") ? \"text\" : \"password\";\n");
      out.write("                        var rep = $(\"<input placeholder='Password' type='\" + change + \"' />\")\n");
      out.write("                                .attr(\"id\", $input.attr(\"id\"))\n");
      out.write("                                .attr(\"name\", $input.attr(\"name\"))\n");
      out.write("                                .attr('class', $input.attr('class'))\n");
      out.write("                                .val($input.val())\n");
      out.write("                                .insertBefore($input);\n");
      out.write("                        $input.remove();\n");
      out.write("                        $input = rep;\n");
      out.write("                    })\n");
      out.write("                            ).append($(\"<label for='showPassword'/>\").text(\"Show password\")).insertAfter($input.parent());\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                $('#showPassword').click(function () {\n");
      out.write("\n");
      out.write("                    if ($(\"#showPassword\").is(\":checked\")) {\n");
      out.write("                        $('.icon-lock').addClass('icon-unlock');\n");
      out.write("                        $('.icon-unlock').removeClass('icon-lock');\n");
      out.write("\n");
      out.write("                    } else {\n");
      out.write("                        $('.icon-unlock').addClass('icon-lock');\n");
      out.write("                        $('.icon-lock').removeClass('icon-unlock');\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
