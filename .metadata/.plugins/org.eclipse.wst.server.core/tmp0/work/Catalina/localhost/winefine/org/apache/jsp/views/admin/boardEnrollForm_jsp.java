/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.78
 * Generated at: 2022-05-30 00:16:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.winefine.member.model.vo.Member;

public final class boardEnrollForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title> WINEFINE :D </title>\r\n");
      out.write("<style>\r\n");
      out.write("    /* 게시판 글쓰기 */\r\n");
      out.write("     #board_write {\r\n");
      out.write("        width:1000px;\r\n");
      out.write("        position:relative;\r\n");
      out.write("        margin:0 auto;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     #write_area {\r\n");
      out.write("        margin-top:20px;\r\n");
      out.write("        font-size:15px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     #in_title, #in_title1{\r\n");
      out.write("        width: 600px;\r\n");
      out.write("        height: 40px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     a { /* 색상변경 안됨 */\r\n");
      out.write("       color: black;\r\n");
      out.write("       text-decoration: none;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     #utitle {\r\n");
      out.write("        outline: none;\r\n");
      out.write("        border: none;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("     #in_title textarea {\r\n");
      out.write("        font-weight:bold;\r\n");
      out.write("        font-size:26px;\r\n");
      out.write("        color:#333;\r\n");
      out.write("        width: 900px;\r\n");
      out.write("        resize: none;\r\n");
      out.write("        outline: none;\r\n");
      out.write("        border: none;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .wi_line {\r\n");
      out.write("        border:solid 1px lightgray;\r\n");
      out.write("        margin-top:10px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     #in_content {\r\n");
      out.write("        height: 400px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     #in_content textarea {\r\n");
      out.write("        font:14px;\r\n");
      out.write("        color:#333;\r\n");
      out.write("        width: 900px;\r\n");
      out.write("        height: 400px;\r\n");
      out.write("        resize: none;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     #in_pw input {\r\n");
      out.write("        font:14px;\r\n");
      out.write("        margin-top:10px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .bt_se {\r\n");
      out.write("        margin-top:20px;\r\n");
      out.write("        text-align:center;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .bt_se button {\r\n");
      out.write("        width:100px;\r\n");
      out.write("        height:30px;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     #enroll-form input, #enroll-form textarea { \r\n");
      out.write("        width : 100%; \r\n");
      out.write("        box-sizing : border-box;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     #in_title:focus {\r\n");
      out.write("        border: none;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    h1>a:hover  {\r\n");
      out.write("        color : #1E90FF;\r\n");
      out.write("        cursor : pointer;\r\n");
      out.write("    } \r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 헤더 START-->\r\n");
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
      out.write("\r\n");
      out.write("<!-- 헤더 END-->	\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"board_write\">\r\n");
      out.write("    <br><br>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"write_area\">              \r\n");
      out.write("            <form id=\"enroll-form\" action=\"");
      out.print( contextPath );
      out.write("/insert.th\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("				\r\n");
      out.write("                <input type=\"hidden\" name=\"userNo\" value=\" ");
      out.print( loginUser.getUserNo() );
      out.write("\">\r\n");
      out.write("				\r\n");
      out.write("                <div id=\"in_title\">\r\n");
      out.write("                    <textarea name=\"title\" id=\"utitle\" rows=\"1\" cols=\"55\" placeholder=\"제목\" maxlength=\"100\" required></textarea>\r\n");
      out.write("                </div>\r\n");
      out.write("            \r\n");
      out.write("            <br>\r\n");
      out.write("                <select name=\"boardtype\" id=\"category\">\r\n");
      out.write("                    <option value=\"wine\">와인용어</option>\r\n");
      out.write("                    <option value=\"pairing\">페어링</option>\r\n");
      out.write("                    <option value=\"magazine\">매거진</option>\r\n");
      out.write("                </select>\r\n");
      out.write("               \r\n");
      out.write("\r\n");
      out.write("                <div class=\"wi_line\"></div>\r\n");
      out.write("                <br>\r\n");
      out.write("\r\n");
      out.write("             <table align=\"center\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>대표이미지</th> <!-- 미리보기 기능 -->\r\n");
      out.write("                    <td colspan=\"3\"><img id=\"titleImg\" width=\"300\" height=\"300\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("             </table>   \r\n");
      out.write("             <br>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"wi_line\"></div>\r\n");
      out.write("                <div id=\"in_content\">\r\n");
      out.write("                    <textarea name=\"content\" id=\"ucontent\" placeholder=\"내용\" required></textarea>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"file-area\">\r\n");
      out.write("                    <!-- input[type=file id=file$ name=file$]*4 + Enter -->\r\n");
      out.write("                    <!-- 대표이미지(썸네일) 은 필수 -->\r\n");
      out.write("                    <!-- onchange : input 태그의 내용물이 변경될 때 발생하는 이벤트 -->\r\n");
      out.write("                    <input type=\"file\" id=\"file1\" name=\"file1\" onchange=\"loadImg(this, 1);\" required> \r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"bt_se\">\r\n");
      out.write("                    <button type=\"submit\">저장</button>\r\n");
      out.write("                    <button type=\"reset\">취소</button>\r\n");
      out.write("                </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<br><br>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("                $(function() {\r\n");
      out.write("\r\n");
      out.write("                    $(\"#file-area\").hide();\r\n");
      out.write("                    \r\n");
      out.write("                    $(\"#titleImg\").click(function() {\r\n");
      out.write("                        $(\"#file1\").click();\r\n");
      out.write("                    });\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                function loadImg(inputFile, num) {\r\n");
      out.write("\r\n");
      out.write("                    if(inputFile.files.length == 1) {\r\n");
      out.write("                    \r\n");
      out.write("                        var reader = new FileReader();\r\n");
      out.write("\r\n");
      out.write("                        reader.readAsDataURL(inputFile.files[0]);\r\n");
      out.write("\r\n");
      out.write("                        // 파일 읽기가 완료되는 순간 실행할 함수를 정의\r\n");
      out.write("                        reader.onload = function(e) {\r\n");
      out.write("\r\n");
      out.write("                            // 각 영역에 맞춰서 이미지 미리보기\r\n");
      out.write("                            switch(num) {\r\n");
      out.write("                                case 1 : $(\"#titleImg\").attr(\"src\", e.target.result); break;\r\n");
      out.write("                            }\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                    else {\r\n");
      out.write("                        // 선택된 파일이 존재하지 않는 경우\r\n");
      out.write("                        // => 미리보기 사라지게 하기 (src 속성 제거)\r\n");
      out.write("                        switch(num){\r\n");
      out.write("                            case 1 : $(\"#titleImg\").attr(\"src\", null); break;\r\n");
      out.write("                    \r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
