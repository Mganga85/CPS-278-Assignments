package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class firstJSP_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html><head>\n");
      out.write("<meta http-equiv=\"content-type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("\n");
      out.write("<title> gettysburg home page </title>\n");
      out.write("</head>\n");
      out.write("<body bgcolor=\"#FFFF99\">\n");
      out.write("<center>\n");
      out.write("  <table bgcolor=\"#FFCC66\" bordercolor=\"#000000\" border=\"4\">\n");
      out.write("    <tr><td>\n");
      out.write("<h2>Gettysburg</h2>\n");
      out.write("</td></tr></table>\n");
      out.write("<h2><a href=\"http://wccnet.edu\">Wcc Home Page</a></h2>\n");
      out.write("\n");
      out.write("<p>Current Time = \n");
 
//start of java
  java.util.Date d= new java.util.Date(); 
  out.println(d.toString());
//end  of java
    
      out.write("\n");
      out.write("</p>\n");
      out.write("\n");
      out.write("<h2><img src=\"sunset.jpg\" width=\"388\" height=\"294\"></h2>\n");
      out.write("<h2><img src=\"cemetary.jpg\" width=\"270\" height=\"180\"></h2>\n");
      out.write("<h2>&nbsp;</h2>\n");
      out.write("</center>\n");
      out.write("\n");
      out.write("</body></html>\n");
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
