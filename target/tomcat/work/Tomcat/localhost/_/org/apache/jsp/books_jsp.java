/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2018-05-29 06:11:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class books_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>展示图书信息</title>\r\n");
      out.write("    <script src=\"js/jquery-2.1.1.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<table id=\"tab\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\" width=\"600px\" align=\"center\">\r\n");
      out.write("    <thead style=\"background-color: cornsilk;\">\r\n");
      out.write("    <th height=\"35px\">编号</th>\r\n");
      out.write("    <th>书名</th>\r\n");
      out.write("    <th>作者</th>\r\n");
      out.write("    <th>价格</th>\r\n");
      out.write("    <th>封面</th>\r\n");
      out.write("    </thead>\r\n");
      out.write("    <tbody align=\"center\">\r\n");
      out.write("    </tbody>\r\n");
      out.write("    <tfoot><tr>\r\n");
      out.write("        <td colspan=\"5\" align=\"center\">首页|上一页|下一页|最后一页|第\r\n");
      out.write("            <select><option>1</option><option>2</option></select>页|共？页</td>\r\n");
      out.write("    </tr></tfoot>\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    $.post(\"findBooks.action\",function (list) {\r\n");
      out.write("        $(\"#tab tbody\").empty();\r\n");
      out.write("        $.each(list,function (index,book) {\r\n");
      out.write("            var tr = $(\"<tr>\");\r\n");
      out.write("            tr.append($(\"<td>\"+book.id+\"</td>\"))\r\n");
      out.write("                .append($(\"<td>\"+book.name+\"</td>\"))\r\n");
      out.write("                .append($(\"<td>\"+book.price+\"</td>\"))\r\n");
      out.write("                .append($(\"<td>\"+book.author+\"</td>\"))\r\n");
      out.write("                .append($(\"<td width='90px'><img src='images/\"+book.cover+\"' width=\\\"85px\\\" height=\\\"100px\\\"/></td>\"))\r\n");
      out.write("            ;\r\n");
      out.write("            $(\"#tab tbody\").append(tr);\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    },\"json\");\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
