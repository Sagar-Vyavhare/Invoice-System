package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class make_005fpayment_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\n');

    int id = Integer.parseInt(request.getParameter("id"));

      out.write("\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        getDetails();\n");
      out.write("        $(\"#submit\").click(function () {\n");
      out.write("            addpayment();\n");
      out.write("        })\n");
      out.write("    })\n");
      out.write("    function getDetails() {\n");
      out.write("        $.ajax({\n");
      out.write("            url: 'http://localhost:9090/api/invoice_detailsbyid?id=' +");
      out.print(id);
      out.write(",\n");
      out.write("            method: 'get',\n");
      out.write("            contentType: 'application/json',\n");
      out.write("            success: function (resp) {\n");
      out.write("                $(\"#invoice_id\").val(resp.invoice_id);\n");
      out.write("                $(\"#cust_name\").val(resp.customer_name);\n");
      out.write("                $(\"#invoice_date\").val(resp.invoice_date);\n");
      out.write("                $(\"#ttl_amt\").val(resp.total_ammount);\n");
      out.write("                $(\"#remaining_amt\").val(resp.remaining_ammount);\n");
      out.write("                $(\"#paid_amt\").val(resp.paid_ammount);\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("    }\n");
      out.write("    function addpayment() {\n");
      out.write("        let p_date=$(\"#payment_date\").val();\n");
      out.write("        let p_amt=$(\"#payment_amt\").val();\n");
      out.write("        let mode=$(\"#mode\").val();\n");
      out.write("        let desc=$(\"#description\").val();\n");
      out.write("        let obj={\"payment_date\":p_date,\"payment_ammount\":p_amt,\"payment_mode\":mode,\"description_print\":desc,invoice_details:{\"invoice_id\":");
      out.print(id);
      out.write("}};\n");
      out.write("        $.ajax({\n");
      out.write("            url:'http://localhost:9090/api/payments',\n");
      out.write("            method:'post',\n");
      out.write("            data:JSON.stringify(obj),\n");
      out.write("            contentType: 'application/json',\n");
      out.write("            success: function (resp) {\n");
      out.write("                        alert(resp);\n");
      out.write("                        window.location.href=\"Invoice.jsp\";\n");
      out.write("                    }\n");
      out.write("        })\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("<a href=\"Invoice.jsp\">All Invoices</a>\n");
      out.write("<div class=\"panel panel-primary\">\n");
      out.write("    <div class=\"panel-heading\">\n");
      out.write("        <h2>Make payment</h2>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"panel-body\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"\">Invoice Id</label>\n");
      out.write("                    <input type=\"text\" name=\"\" id=\"invoice_id\" class=\"form-control\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"\">Customer Name</label>\n");
      out.write("                    <input type=\"text\" name=\"\" id=\"cust_name\" class=\"form-control\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"\">Invoice Date</label>\n");
      out.write("                    <input type=\"text\" name=\"\" id=\"invoice_date\" class=\"form-control\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"\">Total Amount</label>\n");
      out.write("                    <input type=\"text\" name=\"\" id=\"ttl_amt\" class=\"form-control\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"\">Remaining amount</label>\n");
      out.write("                    <input type=\"text\" name=\"\" id=\"remaining_amt\" class=\"form-control\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"\">Paid Ammount</label>\n");
      out.write("                    <input type=\"text\" name=\"\" id=\"paid_amt\" class=\"form-control\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"\">Payment Date</label>\n");
      out.write("                    <input type=\"date\" name=\"\" id=\"payment_date\" class=\"form-control\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"\">Payment Amount</label>\n");
      out.write("                    <input type=\"text\" name=\"\" id=\"payment_amt\" class=\"form-control\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"\">Payment Mode</label>\n");
      out.write("                    <select name=\"\" id=\"mode\" class=\"form-control\">\n");
      out.write("                        <option value=\"\" selected disabled>Select payment mode</option>\n");
      out.write("                        <option value=\"Cash\">Cash</option>\n");
      out.write("                        <option value=\"UPI\">UPI</option>\n");
      out.write("                        <option value=\"Check\">Check</option>\n");
      out.write("                        <option value=\"Net Banking\">Net Banking</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"\">Description</label>\n");
      out.write("                    <input type=\"text\" name=\"\" id=\"description\" class=\"form-control\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"panel-footer\">\n");
      out.write("        <input type=\"button\" id=\"submit\" value=\"Submit\"class=\"btn btn-primary\">\n");
      out.write("    </div>\n");
      out.write("</div>\n");
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
