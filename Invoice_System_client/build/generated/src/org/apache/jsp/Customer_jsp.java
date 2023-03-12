package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Customer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Header.jsp");
    _jspx_dependants.add("/Footer.jsp");
  }

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
      response.setContentType("text/html");
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
      out.write("    \n");
      out.write("        <!DOCTYPE html>\n");
      out.write("        <html>\n");
      out.write("\n");
      out.write("        <head>\n");
      out.write("            <meta http-equiv =\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("            <title>hello</title>\n");
      out.write("            <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("            <script src=\"js/jquery.min.js\"></script>\n");
      out.write("            <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        </head>\n");
      out.write("\n");
      out.write("        <body>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"navbar navbar-inverse\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li><a href=\"#\">Invoice System</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-3\">\n");
      out.write("                        <ul class=\"list-group\">\n");
      out.write("                            <li class=\"list-group-item\"><a href=\"Dashbord.jsp\">Dashboard</a></li>\n");
      out.write("                            <li class=\"list-group-item\"><a href=\"Customer.jsp\">Customer</a></li>\n");
      out.write("                            <li class=\"list-group-item\"><a href=\"Item.jsp\">Item</a></li>\n");
      out.write("                            <li class=\"list-group-item\"><a href=\"Invoice.jsp\">Invoice</a></li>\n");
      out.write("                            <li class=\"list-group-item\"><a href=\"Reports.jsp\">Report</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-9\">\n");
      out.write("                        <div style=\"height:650px;width: 100%;\">");
      out.write("\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        Getallcustomers();\n");
      out.write("        $(\"#btnsubmit\").click(function () {\n");
      out.write("            $(\"#btnsubmit\").prop('disabled', true);\n");
      out.write("            Addcustomer();\n");
      out.write("        })\n");
      out.write("        $(\"#btnaddcudtomer\").click(function () {\n");
      out.write("            $(\"#btnsubmit\").prop('disabled', false);\n");
      out.write("            $(\"#customermodal\").modal(\"show\");\n");
      out.write("        })\n");
      out.write("    })\n");
      out.write("    function deletcust(id) {\n");
      out.write("        console.log(\"sagar\");\n");
      out.write("        $.ajax({\n");
      out.write("            url: 'http://localhost:9090/api/customerbyid?id=' + id,\n");
      out.write("            method: 'delete',\n");
      out.write("            contentType: 'application/json',\n");
      out.write("            success: function (resp) {\n");
      out.write("                Getallcustomers();\n");
      out.write("                alert(\"customer deleted\");\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        })\n");
      out.write("    }\n");
      out.write("    function Getallcustomers() {\n");
      out.write("        $.ajax({\n");
      out.write("            url: 'http://localhost:9090/api/customer',\n");
      out.write("            method: 'get',\n");
      out.write("            contentType: 'application/json',\n");
      out.write("            success: function (resp) {\n");
      out.write("                $(\"#tbldata\").empty();\n");
      out.write("                $.each(resp, function (i, d) {\n");
      out.write("                    $(\"#tbldata\").append(\"<tr><td>\" + (i + 1) + \"</td><td>\" + d.customer_name + \"</td><td>\" + d.city + \"</td><td>\" + d.email + \"</td><td>\" + d.mobile_number + \"</td><td><input type='button' class='btn btn-danger btn-xs' value='delete' onclick='deletcust(\" + d.customer_id + \")'></td></tr>\");\n");
      out.write("                })\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        })\n");
      out.write("    }\n");
      out.write("    function Addcustomer() {\n");
      out.write("        var name = $(\"#customer_name\").val();\n");
      out.write("        var city = $(\"#city\").val();\n");
      out.write("        var email = $(\"#email\").val();\n");
      out.write("        var m_number = $(\"#mobile_number\").val();\n");
      out.write("        var obj = {\"customer_name\": name, \"city\": city, \"email\": email, \"mobile_number\": m_number};\n");
      out.write("        $.ajax({\n");
      out.write("            url: 'http://localhost:9090/api/customer',\n");
      out.write("            method: 'post',\n");
      out.write("            data: JSON.stringify(obj),\n");
      out.write("            contentType: 'application/json',\n");
      out.write("            success: function (resp) {\n");
      out.write("                Getallcustomers();\n");
      out.write("                $(\"#customermodal\").modal(\"hide\");\n");
      out.write("                document.getElementById(\"alert\").style.display = \"block\";\n");
      out.write("                $(\"#customer_name\").val(\"\");\n");
      out.write("                $(\"#city\").val(\"\");\n");
      out.write("                $(\"#email\").val(\"\");\n");
      out.write("                $(\"#mobile_number\").val(\"\");\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        })\n");
      out.write("    }\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("<h2>Customer</h2>\n");
      out.write("<p class=\"alert alert-success\" id=\"alert\" style=\"display:none;\">Customer added</p>\n");
      out.write("<input type=\"button\" value=\"form\" id=\"btnaddcudtomer\" class=\"btn btn-primary\">\n");
      out.write("<div class=\"modal fade\" id=\"customermodal\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <button type=\"button\" data-dismiss=\"modal\" class=\"close\"><span>&times;</span></button>\n");
      out.write("                <h4>Customer Form</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Customer Id</label>\n");
      out.write("                            <input type=\"text\" id=\"customer_id\" class=\"form-control\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Customer name</label>\n");
      out.write("                            <input type=\"text\" id=\"customer_name\" class=\"form-control\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>City</label>\n");
      out.write("                            <input type=\"text\" id=\"city\" class=\"form-control\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Email Address</label>\n");
      out.write("                            <input type=\"text\" id=\"email\" class=\"form-control\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Mobile Number</label>\n");
      out.write("                            <input type=\"text\" id=\"mobile_number\" class=\"form-control\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <input type=\"button\" value=\"Submit\" id=\"btnsubmit\" class=\"btn btn-primary\" disabled>\n");
      out.write("                <input type=\"button\" class=\"btn btn-warning\" data-dismiss=\"modal\" value=\"close\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<table class=\"table table-bordered\">\n");
      out.write("    <thead>\n");
      out.write("        <tr class=\"success\">\n");
      out.write("            <td>Customer Id</td>\n");
      out.write("            <td>Customer Name</td>\n");
      out.write("            <td>City</td>\n");
      out.write("            <td>Email</td>\n");
      out.write("            <td>Mobile Number</td>\n");
      out.write("            <td>Action</td>\n");
      out.write("        </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody id=\"tbldata\">\n");
      out.write("\n");
      out.write("    </tbody>\n");
      out.write("</table>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<hr>\n");
      out.write("<div>\n");
      out.write("    @copyright<a href=\"https://www.ciitinstitute.com\">ciit training institute</a>\n");
      out.write("</div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    \n");
      out.write("\n");
      out.write("</body>\n");
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
