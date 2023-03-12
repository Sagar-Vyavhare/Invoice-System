package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Invoice_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<a href=\"New_Invoice.jsp\">New Invoice</a>\n");
      out.write("<h2>Invoice</h2>\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        getInvoiceId();\n");
      out.write("    })\n");
      out.write("    function getInvoiceId() {\n");
      out.write("        $.ajax({\n");
      out.write("            url: 'http://localhost:9090/api/allinvoices',\n");
      out.write("            method: 'get',\n");
      out.write("            contentType: 'application/json',\n");
      out.write("            success: function (resp) {\n");
      out.write("                $(\"#tbldata\").empty();\n");
      out.write("                $.each(resp, function (i, d) {\n");
      out.write("                    let data=\"\";\n");
      out.write("                    if(d.status==\"Paid\"){\n");
      out.write("                        data=\"<tr><td>\" +(i+1)+ \"</td><td>\" + d.customer_name + \"</td><td>\" + d.invoice_date + \"</td><td>\" + d.total_ammount + \"</td><td>\" + d.paid_ammount  + \"</td><td>\" + d.remaining_ammount + \"</td><td>\" + d.status + \"</td><td><a href='viewinvoice.jsp?id=\"+d.invoice_id+\"'>View Invoice<a/></td></tr>\"\n");
      out.write("                    }\n");
      out.write("                    else{\n");
      out.write("                        data=\"<tr><td>\" +(i+1)+ \"</td><td>\" + d.customer_name + \"</td><td>\" + d.invoice_date + \"</td><td>\" + d.total_ammount + \"</td><td>\" + d.paid_ammount  + \"</td><td>\" + d.remaining_ammount + \"</td><td>\" + d.status + \"</td><td><a href='make_payment.jsp?id=\"+d.invoice_id+\"'>Make payment<a/></td></tr>\"\n");
      out.write("                    }\n");
      out.write("        $(\"#tbldata\").append(data)\n");
      out.write("                })\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("<table class=\"table table-bordered\">\n");
      out.write("    <thead>\n");
      out.write("        <tr class=\"bg-primary\">\n");
      out.write("            <td>Sr no</td>\n");
      out.write("            <td>Customer Name</td>\n");
      out.write("            <td>Invoice Date</td>\n");
      out.write("            <td>Total Ammount</td>\n");
      out.write("            <td>Paid Ammount</td>\n");
      out.write("            <td>Reamaning Ammount</td>\n");
      out.write("            <td>Status</td>\n");
      out.write("            <td>Action</td>\n");
      out.write("        </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody id=\"tbldata\">\n");
      out.write("\n");
      out.write("    </tbody>\n");
      out.write("</table>\n");
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
