/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.78
 * Generated at: 2022-05-20 01:21:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class oneqnaInsertView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/admin/../common/adminHeader.jsp", Long.valueOf(1652972913296L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    <!DOCTYPE html>\r\n");
      out.write("    <html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title> WINEFINE :D </title>\r\n");
      out.write("        <style>\r\n");
      out.write("            /* 전체 구조 잡기*/\r\n");
      out.write("            div{\r\n");
      out.write("                \r\n");
      out.write("                box-sizing: border-box;\r\n");
      out.write("            }\r\n");
      out.write("            .wrap{\r\n");
      out.write("                width: 1200px; \r\n");
      out.write("                height: 1000px; \r\n");
      out.write("                margin: auto;\r\n");
      out.write("            }\r\n");
      out.write("            .w_{\r\n");
      out.write("                width: 100%;\r\n");
      out.write("            }\r\n");
      out.write("            .top{\r\n");
      out.write("                height: 240px; /* height: 240px */\r\n");
      out.write("            }\r\n");
      out.write("            .body{\r\n");
      out.write("                height: 600px; /* height: 600px */\r\n");
      out.write("            }\r\n");
      out.write("            .bottom{\r\n");
      out.write("                height: 100px;  /* height: 100px */\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            /* 상세 항목 */\r\n");
      out.write("            td{\r\n");
      out.write("                padding-right: 20px;\r\n");
      out.write("                padding-left: 20px;\r\n");
      out.write("            }\r\n");
      out.write("            .bottom{\r\n");
      out.write("                font-size: 14px;\r\n");
      out.write("                font-weight: 600;\r\n");
      out.write("            }\r\n");
      out.write("            .btn{\r\n");
      out.write("            	margin:5px 10px;\r\n");
      out.write("            }\r\n");
      out.write("            .detailTable{\r\n");
      out.write("                width: 80%;\r\n");
      out.write("                height: 90%;\r\n");
      out.write("                margin: 50px 120px;\r\n");
      out.write("            }\r\n");
      out.write("            .menuTitle, .menuTitle>a{\r\n");
      out.write("                color: lightgray;\r\n");
      out.write("                font-size: 22px;\r\n");
      out.write("                font-weight: 600;\r\n");
      out.write("            }\r\n");
      out.write("            .menuTitle>a:hover{\r\n");
      out.write("                color: black;\r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("            }\r\n");
      out.write("            .tableTitle{\r\n");
      out.write("                width: 18%;\r\n");
      out.write("                font-size: 20px;\r\n");
      out.write("                font-weight: 500;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("            }\r\n");
      out.write("            textarea{\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                height: 80%;\r\n");
      out.write("            }\r\n");
      out.write("            /* 상단버튼 */\r\n");
      out.write("            #top_btn button {\r\n");
      out.write("                background-color : rgb(41, 128, 185);\r\n");
      out.write("                color : white;\r\n");
      out.write("                width: 80px;\r\n");
      out.write("                height: 30px;\r\n");
      out.write("                border-radius: 4px;\r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("            }\r\n");
      out.write("            #Insert-form input, #Insert-form textarea { \r\n");
      out.write("                width: 70%;\r\n");
      out.write("                height: 100%;\r\n");
      out.write("                box-sizing: border-box;    \r\n");
      out.write("            }\r\n");
      out.write("            #bottom_btn>button {\r\n");
      out.write("                background-color : rgb(41, 128, 185);\r\n");
      out.write("                color : white;\r\n");
      out.write("                width: 80px;\r\n");
      out.write("                height: 30px;\r\n");
      out.write("                border-radius: 4px;\r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("            }\r\n");
      out.write("            #bottom_btn a, #top_btn a {\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            color: white\r\n");
      out.write("            }\r\n");
      out.write("            #bottom_btn button:hover, #top_btn button:hover {\r\n");
      out.write("                opacity : 0.7;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("       <div class=\"wrap\">\r\n");
      out.write("\r\n");
      out.write("           <!-- top : hearder 삽입 영역 ------------------------------->\r\n");
      out.write("           <div class=\"w_ top\">\r\n");
      out.write("               <div class=\"w_\" style=\"height: 150px;\">\r\n");
      out.write("                    <!-- 헤더 START-->\r\n");
      out.write("                    ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- * 부트스트랩 영역 --------------------------------------------------------------------------->\r\n");
      out.write(" <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- Popper JS -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Latest compiled JavaScript -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write(" <!-- menubar영역은 모든 페이지마다 넣어주기로 했으니 얘한테 한번 넣어두면 include 되는 모든페이지에서 쓸 수 있겠쥬 ! ☆  -->\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("    div, table{\r\n");
      out.write("        margin: 0px;\r\n");
      out.write("        height: 100%;\r\n");
      out.write("    }\r\n");
      out.write("    .adminHeader{\r\n");
      out.write("        border-collapse: collapse;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("    }\r\n");
      out.write("    .adminHeader td{\r\n");
      out.write("        padding-right: 20px;\r\n");
      out.write("        padding-left: 20px;\r\n");
      out.write("    }\r\n");
      out.write("    #header {\r\n");
      out.write("        background-color: gray;\r\n");
      out.write("    }\r\n");
      out.write("    #header a {\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("        color: white\r\n");
      out.write("    }\r\n");
      out.write("    #mainlogo {\r\n");
      out.write("        display:inline-block;\r\n");
      out.write("        width: 800px;\r\n");
      out.write("        margin: 20px;\r\n");
      out.write("    }\r\n");
      out.write("    #top_btn button {\r\n");
      out.write("        background-color : rgb(41, 128, 185);\r\n");
      out.write("        color : white;\r\n");
      out.write("        width: 80px;\r\n");
      out.write("        height: 30px;\r\n");
      out.write("        border-radius: 4px;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("    }\r\n");
      out.write("    #navigator{\r\n");
      out.write("            \r\n");
      out.write("        background-color: rgb(41, 128, 185);\r\n");
      out.write("        position: relative;\r\n");
      out.write("    }\r\n");
      out.write("    #navigator label {\r\n");
      out.write("        margin : 10px 30px;\r\n");
      out.write("    }\r\n");
      out.write("    #navigator a {\r\n");
      out.write("        color: white;\r\n");
      out.write("        text-decoration : none;\r\n");
      out.write("        margin:0;\r\n");
      out.write("        text-transform:uppercase; \r\n");
      out.write("        font-size : 18px;\r\n");
      out.write("        font-weight : bold;    \r\n");
      out.write("    }\r\n");
      out.write("    #navigator a:hover {\r\n");
      out.write("        opacity : 0.7;\r\n");
      out.write("    }   \r\n");
      out.write("    .header_r{\r\n");
      out.write("        text-align: right;\r\n");
      out.write("    }\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <div>\r\n");
      out.write("        <table class=\"adminHeader\">\r\n");
      out.write("            <tr id=\"header\" style=\"height:70%;\">\r\n");
      out.write("                <td style=\"width:800px;\"><a href=\"\"><h3 id=\"mainlogo\" >ADMINISTRATOR</h3></a></td>\r\n");
      out.write("                <td class=\"header_r\">\r\n");
      out.write("                    <a href=\"\">Wine Fine&nbsp;</a>\r\n");
      out.write("                    <a href=\"\" style=\"color:red\">로그아웃</a>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr id=\"navigator\" style=\"height:30%;\" align=\"center\">\r\n");
      out.write("                <td colspan=\"3\">\r\n");
      out.write("                    <label><a href=\"\">회원정보관리</a></label>\r\n");
      out.write("                    <label><a href=\"\">주문정보관리</a></label>    \r\n");
      out.write("                    <label><a href=\"\">재고관리</a></label>\r\n");
      out.write("                    <label><a href=\"\">게시판관리</a></label>\r\n");
      out.write("                    <label><a href=\"noticeMainView.jsp\">고객센터관리</a></label>\r\n");
      out.write("                    <label><a href=\"\">통계</a></label>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table> \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("                    <!-- 헤더 END-->\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("               <div class=\"w_\" style=\"height: 90px;\">\r\n");
      out.write("               		<br>\r\n");
      out.write("                    <table>\r\n");
      out.write("                    <tr id=\"top_btn\">\r\n");
      out.write("                            <td style=\"width:480px; font-size: 22px; font-weight: 600\">1:1문의 작성</td>\r\n");
      out.write("                            <td colspan=\"2\" style=\"width: 720px;\" align=\"right\">\r\n");
      out.write("			                    <button type=\"button\"><a href=\"noticeMainView.jsp\">공지사항</a></button>\r\n");
      out.write("                    			<button type=\"button\"><a href=\"eventMainView.jsp\">이벤트</a></button>\r\n");
      out.write("                    			<button type=\"button\"><a href=\"oneqnaMainView.jsp\">1:1문의</a></button>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td colspan=\"2\"><hr></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        </table>\r\n");
      out.write("                </div>\r\n");
      out.write("           </div>\r\n");
      out.write("    \r\n");
      out.write("           <!-- body : 바디 영역 --------------------------------------->\r\n");
      out.write("           <div class=\"w_ body\">\r\n");
      out.write("\r\n");
      out.write("            <div outer=\"outer\" align=\"center\">\r\n");
      out.write("                <br>\r\n");
      out.write("                <form id=\"Insert-form\" action=\"\" method=\"post\">\r\n");
      out.write("                    <table>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th width=\"200\" align=\"right\">아이디</th>\r\n");
      out.write("                            <td width=\"500\">\r\n");
      out.write("                                <input type=text name=\"userId\" value=\"입력받음\" required></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th width=\"200\" align=\"right\">전화번호</th>\r\n");
      out.write("                            <td width=\"500\"><input type=text name=\"phone\" value=\"입력받음\" required></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th width=\"200\" align=\"right\">제목</th>\r\n");
      out.write("                            <td width=\"500\"><input type=text name=\"title\" value=\"입력받음\" required></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th width=\"200\" align=\"right\">내용</th>\r\n");
      out.write("                            <td height=\"200\"><textarea name=\"content\" placeholder=\"내용을 입력하세요.\" style=\"resize:none;\" required>입력받음</textarea></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th width=\"200\" align=\"right\">답변</th>\r\n");
      out.write("                            <td height=\"200\"><textarea name=\"reply\" placeholder=\"답변을 입력하세요.\" style=\"resize:none;\" required>ㅇㅇㅇㅇㅇㅇ</textarea></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                      \r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </table>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <div id=\"bottom_btn\" align=\"center\">\r\n");
      out.write("                        <button type=\"submit\">답변하기</button>\r\n");
      out.write("                        <button type=\"button\">뒤로가기</button>    \r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("           </div>\r\n");
      out.write("\r\n");
      out.write("           <!-- bottom : 하단 영역 --------------------------------------->\r\n");
      out.write("           \r\n");
      out.write("       \r\n");
      out.write("       </div> \r\n");
      out.write("       \r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("    </html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
