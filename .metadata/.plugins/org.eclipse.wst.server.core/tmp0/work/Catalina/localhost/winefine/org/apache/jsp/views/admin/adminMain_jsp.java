/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.78
 * Generated at: 2022-05-30 03:34:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.winefine.member.model.vo.Member;

public final class adminMain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/admin/../common/adminHeader.jsp", Long.valueOf(1653847753201L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.winefine.member.model.vo.Member");
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
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- * 부트스트랩 영역 --------------------------------------------------------------------------->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Popper JS -->\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Latest compiled JavaScript -->\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("        <!-- menubar영역은 모든 페이지마다 넣어주기로 했으니 얘한테 한번 넣어두면 include 되는 모든페이지에서 쓸 수 있겠쥬 ! ☆  -->\r\n");
      out.write("\r\n");
      out.write("        <style>\r\n");
      out.write("            /* 전체 구조 잡기*/\r\n");
      out.write("            div{\r\n");
      out.write("                box-sizing: border-box;\r\n");
      out.write("            }\r\n");
      out.write("            .wrap{\r\n");
      out.write("                width: 1200px; \r\n");
      out.write("                height: 700px; \r\n");
      out.write("                margin: auto;\r\n");
      out.write("            }\r\n");
      out.write("            .w_{\r\n");
      out.write("                width: 100%;\r\n");
      out.write("            }\r\n");
      out.write("            .top{\r\n");
      out.write("                height: 150px; \r\n");
      out.write("            }\r\n");
      out.write("           .body{\r\n");
      out.write("               height: 500px;\r\n");
      out.write("           }\r\n");
      out.write("            .bottom{\r\n");
      out.write("                height: 50px;  \r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            /* 상세 항목 */\r\n");
      out.write("            body{\r\n");
      out.write("                background-color: rgb(41, 128, 185) !important;\r\n");
      out.write("                color: white;\r\n");
      out.write("            }\r\n");
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
      out.write("            .title a{\r\n");
      out.write("                font-size: 20px; \r\n");
      out.write("                font-weight: 900;\r\n");
      out.write("                color:rgb(46, 45, 45);\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("            }\r\n");
      out.write("            .title a:active{\r\n");
      out.write("                background-color: rgb(46, 45, 45);\r\n");
      out.write("                color: white;\r\n");
      out.write("            }\r\n");
      out.write("            .mainList td{\r\n");
      out.write("                width: 600px;\r\n");
      out.write("                height: 40px;\r\n");
      out.write("            }\r\n");
      out.write("            /* adminHeader 스타일 */\r\n");
      out.write("            div, table{\r\n");
      out.write("                margin: 0px;\r\n");
      out.write("                height: 100%;\r\n");
      out.write("            }\r\n");
      out.write("            .adminHeader{\r\n");
      out.write("                border-collapse: collapse;\r\n");
      out.write("                width: 100%;\r\n");
      out.write("            }\r\n");
      out.write("            .adminHeader td{\r\n");
      out.write("                padding-right: 20px;\r\n");
      out.write("                padding-left: 20px;\r\n");
      out.write("            }\r\n");
      out.write("            #header a {\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("                color: white\r\n");
      out.write("            }\r\n");
      out.write("            #header {\r\n");
      out.write("                background-color: rgb(41, 128, 185) !important;\r\n");
      out.write("            }\r\n");
      out.write("            #mainlogo {\r\n");
      out.write("                display:inline-block;\r\n");
      out.write("                width: 800px;\r\n");
      out.write("                margin: 20px;\r\n");
      out.write("            }\r\n");
      out.write("            #top_btn button {\r\n");
      out.write("                background-color : rgb(41, 128, 185);\r\n");
      out.write("                color : white;\r\n");
      out.write("                width: 80px;\r\n");
      out.write("                height: 30px;\r\n");
      out.write("                border-radius: 4px;\r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("            }\r\n");
      out.write("            #navigator{   \r\n");
      out.write("                background-color: rgb(41, 128, 185);\r\n");
      out.write("                position: relative;\r\n");
      out.write("            }\r\n");
      out.write("            #navigator label {\r\n");
      out.write("                margin : 10px 30px;\r\n");
      out.write("            }\r\n");
      out.write("            #navigator a {\r\n");
      out.write("                color: white;\r\n");
      out.write("                text-decoration : none;\r\n");
      out.write("                margin:0;\r\n");
      out.write("                text-transform:uppercase; \r\n");
      out.write("                font-size : 18px;\r\n");
      out.write("                font-weight : bold;    \r\n");
      out.write("            }\r\n");
      out.write("            #navigator a:hover {\r\n");
      out.write("                opacity : 0.7;\r\n");
      out.write("            }   \r\n");
      out.write("            .header_r{\r\n");
      out.write("                text-align: right;\r\n");
      out.write("            }\r\n");
      out.write("        \r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <body>\r\n");
      out.write("       <div class=\"wrap\">\r\n");
      out.write("\r\n");
      out.write("           <!-- top : hearder 삽입 영역 ------------------------------->\r\n");
      out.write("           <div class=\"w_ top\">\r\n");
      out.write("               <div class=\"w_\" style=\"height: 150px;\">\r\n");
      out.write("                    <!-- 헤더 START-->\r\n");
      out.write("                    ");
      out.write("\r\n");
      out.write("\r\n");

    // 메인 화면으로 이동하는 경로 뽑기
    String contextPath = request.getContextPath();

    // 서블릿에서 보낸 메세지 뽑기
	String alertMsg = (String)session.getAttribute("alertMsg");

    Member loginUser = (Member)session.getAttribute("loginUser");

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
      out.write("    div {\r\n");
      out.write("        margin: 0px;\r\n");
      out.write("        height: 100%;\r\n");
      out.write("        /* 아니 이걸 헤더에다가 넣어두면 안되지1!!!!*/\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .adminHeader{\r\n");
      out.write("        border-collapse: collapse;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: 100%;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
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
      out.write(" \r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery-->\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- * 부트스트랩 영역 --------------------------------------------------------------------------->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- Popper JS -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Latest compiled JavaScript -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <div>\r\n");
      out.write("        <table class=\"adminHeader\">\r\n");
      out.write("            <tr id=\"header\" style=\"height:70%;\">\r\n");
      out.write("                <td style=\"width:800px;\"><a href=\"");
      out.print( contextPath );
      out.write("/main.admin\"><h3 id=\"mainlogo\">ADMINISTRATOR</h3></a></td>\r\n");
      out.write("                <td class=\"header_r\">\r\n");
      out.write("                    <a href=\"");
      out.print( contextPath );
      out.write("/main.do\">Wine Fine&nbsp;</a>\r\n");
      out.write("                    <a href=\"");
      out.print( contextPath );
      out.write("/logout.me\" style=\"color:red\">로그아웃</a>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr id=\"navigator\" style=\"height:30%;\" align=\"center\">\r\n");
      out.write("                <td colspan=\"3\">\r\n");
      out.write("                    <label><a href=\"");
      out.print( contextPath );
      out.write("/memList.me?currentPage=1\">회원정보관리</a></label>\r\n");
      out.write("                    <label><a href=\"");
      out.print( contextPath );
      out.write("/orderListView.admin?currentPage=1\">주문정보관리</a></label>    \r\n");
      out.write("                    <label><a href=\"");
      out.print( contextPath );
      out.write("/productView.admin?currentPage=1\">상품관리</a></label>\r\n");
      out.write("                    <label><a href=\"");
      out.print( contextPath );
      out.write("/list.bo?currentPage=1\">게시판관리</a></label>\r\n");
      out.write("                    <label><a href=\"");
      out.print( contextPath );
      out.write("/Mmain.no\">고객센터관리</a></label>\r\n");
      out.write("                    <label><a href=\"");
      out.print( contextPath );
      out.write("/prepare.do\">통계</a></label>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table> \r\n");
      out.write("           \r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <script>\r\n");
      out.write("    	\r\n");
      out.write("        var message = \"");
      out.print( alertMsg );
      out.write("\";\r\n");
      out.write("        \r\n");
      out.write("        if(message != \"null\") { //로그인 정보가 넘어온 경우\r\n");
      out.write("            \r\n");
      out.write("            alert(message);\r\n");
      out.write("        \r\n");
      out.write("            ");
 session.removeAttribute("alertMsg"); 
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write(" \r\n");
      out.write("                    <!-- 헤더 END-->\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("               <div class=\"w_\" style=\"height: 90px;\">\r\n");
      out.write("                </div>\r\n");
      out.write("           </div>\r\n");
      out.write("    \r\n");
      out.write("           <!-- body : 바디 영역 --------------------------------------->\r\n");
      out.write("           <div class=\"w_ body\">\r\n");
      out.write("               <table class=\"mainList\" align=\"center\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td rowspan=\"4\"><h1 align=\"center\">\r\n");
      out.write("                        <p id=\"today\" style=\"color:white; text-align: left;\">\r\n");
      out.write("                        	2022년 5월 18일<br>수요일 :D</h1>\r\n");
      out.write("                        </p>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td class=\"title\"><a href=\"/winefine/orderListView.admin?currentPage=1\" style=\"text-decoration: none;\"> > 주문 확인하기</a></td>\r\n");
      out.write("                     </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                       <td class=\"title\"><a href=\"/winefine/Mmain.on\" style=\"text-decoration: none;\">> 문의내역 확인하기</a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td class=\"title\"><a href=\"/winefine/review.admin?currentPage=1\" style=\"text-decoration: none;\"> > 상품후기 확인하기</a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr style=\"border-bottom: 10px solid white;\">\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td rowspan=\"4\"></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <!-- <tr>\r\n");
      out.write("                        <td class=\"title\"><a href=\"detailPage.jsp\"> > 상품페이지수정</a></td>\r\n");
      out.write("                     </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                       <td class=\"title\"><a href=\"\"> > 베스트셀러 수정</a></td>\r\n");
      out.write("                    </tr> -->\r\n");
      out.write("               </table>\r\n");
      out.write("           </div>\r\n");
      out.write("\r\n");
      out.write("           <!-- bottom : 하단 영역 --------------------------------------->\r\n");
      out.write("           <div class=\"w_ bottom\" align=\"center\">\r\n");
      out.write("           </div>\r\n");
      out.write("\r\n");
      out.write("       \r\n");
      out.write("       </div> \r\n");
      out.write("\r\n");
      out.write("       <script>\r\n");
      out.write("           var today = new Date();\r\n");
      out.write("           var year = today.getFullYear();\r\n");
      out.write("           var month = today.getMonth() +1;\r\n");
      out.write("           var date = today.getDate();\r\n");
      out.write("           var day = today.getDay();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("           $(\"#today\").html(\"관리자님,<br><br>오늘은<br> \"+ year +\"년 \" + month + \"월 \" + date +\"일<br>입니다 :D\");\r\n");
      out.write("\r\n");
      out.write("       </script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("    </html>  \r\n");
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
