/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.78
 * Generated at: 2022-05-23 12:03:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.oneqna;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.winefine.member.model.vo.Member;

public final class oneqnaListView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/views/oneqna/../common/footer.jsp", Long.valueOf(1652178392000L));
    _jspx_dependants.put("/views/oneqna/../common/header.jsp", Long.valueOf(1653273810112L));
    _jspx_dependants.put("/views/oneqna/../common/category-notice.jsp", Long.valueOf(1653294038653L));
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
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("    /* 전체 구조 잡기*/\r\n");
      out.write("    div{\r\n");
      out.write("        box-sizing: border-box;\r\n");
      out.write("    }\r\n");
      out.write("    .wrap{\r\n");
      out.write("            width: 1200px;\r\n");
      out.write("            height: 1500px;\r\n");
      out.write("            margin: auto;\r\n");
      out.write("    }\r\n");
      out.write("    .w_{\r\n");
      out.write("        width: 100%;\r\n");
      out.write("    }\r\n");
      out.write("    .top{\r\n");
      out.write("       height: 10%;\r\n");
      out.write("    }\r\n");
      out.write("    .body{\r\n");
      out.write("        height: 70%;\r\n");
      out.write("    }\r\n");
      out.write("    .bottom{\r\n");
      out.write("        height: 20%;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    /* - 구조 : body 영역_ 좌측 & 우측 분할 */\r\n");
      out.write("    .sortArea{\r\n");
      out.write("        height: 3%;\r\n");
      out.write("        padding-right: 100px;\r\n");
      out.write("    }\r\n");
      out.write("    .store_body{\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: 70%;\r\n");
      out.write("    }\r\n");
      out.write("    .store_body td.body_l{\r\n");
      out.write("        width: 20%;\r\n");
      out.write("        vertical-align: top;\r\n");
      out.write("    }\r\n");
      out.write("    .store_body td.body_r{\r\n");
      out.write("        width: 80%;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    /* 상세 항목 */\r\n");
      out.write("    .sort{\r\n");
      out.write("        float: right;\r\n");
      out.write("        height: 100%;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .delete{\r\n");
      out.write("        padding-left: 5%;\r\n");
      out.write("        width: 90%;\r\n");
      out.write("        height: 100%;\r\n");
      out.write("    }\r\n");
      out.write("    /* body_r 영역 */\r\n");
      out.write("    #oneQna-form {\r\n");
      out.write("       margin: auto;\r\n");
      out.write("       width: 700px;   \r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    #oneQna-form input, #oneQna-form textarea, #oneQna-form select {\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        box-sizing: border-box;\r\n");
      out.write("        margin:10px\r\n");
      out.write("        \r\n");
      out.write("    }\r\n");
      out.write("    .btn1{\r\n");
      out.write("        background-color : rgb(107, 50, 91);\r\n");
      out.write("        color : white;\r\n");
      out.write("        cursor : pointer;\r\n");
      out.write("        width: 90px;\r\n");
      out.write("        height: 50px;\r\n");
      out.write("        font-size:medium;\r\n");
      out.write("        \r\n");
      out.write("    }   \r\n");
      out.write("    </style>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("    <div class=\"wrap\">\r\n");
      out.write("        <!-- top : hearder 삽입 영역 ------------------------------->\r\n");
      out.write("        <div class=\"w_ top\">\r\n");
      out.write("\r\n");
      out.write("            <!-- 헤더 START-->\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("\r\n");
 
	// 로그인한 사용자 정보 뽑기
	Member loginUser = (Member)session.getAttribute("loginUser"); 
	// 서블릿에서 보낸 메세지 뽑기
	String alertMsg = (String)session.getAttribute("alertMsg");
	// 메인 화면으로 이동하는 경로 뽑기
	String contextPath = request.getContextPath();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title> WINEFINE :D </title>\r\n");
      out.write("\r\n");
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
      out.write(" <!-- menubar영역은 모든 페이지마다 넣어주기로 했으니 얘한테 한번 넣어두면 include 되는 모든페이지에서 쓸 수 있겠쥬 ! ☆  -->\r\n");
      out.write("\r\n");
      out.write("<!-- swiper.js -->\r\n");
      out.write("<link\r\n");
      out.write("  rel=\"stylesheet\"\r\n");
      out.write("  href=\"https://unpkg.com/swiper@8/swiper-bundle.min.css\"\r\n");
      out.write("/>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://unpkg.com/swiper@8/swiper-bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    .logo {\r\n");
      out.write("        width: 400px;\r\n");
      out.write("        float: left;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .logo>a {\r\n");
      out.write("        margin-left: 50px; /* 로고의 왼쪽 여백 설정 */\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .top_right_menu { float: right;}\r\n");
      out.write("\r\n");
      out.write("    .top_right_menu li{\r\n");
      out.write("        list-style-type: none;\r\n");
      out.write("        float: left;\r\n");
      out.write("        margin-right: 10px;\r\n");
      out.write("        padding-right: 10px;\r\n");
      out.write("        padding-left: 5px;\r\n");
      out.write("    }\r\n");
      out.write("    #top_service>a { margin-right: 50px;} /* 우측 상단 아이콘의 오른쪽 여백 설정 */\r\n");
      out.write("\r\n");
      out.write("    .menu {\r\n");
      out.write("        display: table-cell;\r\n");
      out.write("        height: 50px;\r\n");
      out.write("        width: 200px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .menu a {\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("        color: black;\r\n");
      out.write("        font-size: 20px;\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("        display: block; \r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: 100%;\r\n");
      out.write("        line-height: 50px; /* 장평조절: 위~ 아래에서 가운데 조정 */\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .menu a:hover {\r\n");
      out.write("        color:#6B325B;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .menu:after {\r\n");
      out.write("            display:block;\r\n");
      out.write("            content: '';\r\n");
      out.write("            border-bottom: solid 5px #6B325B;  \r\n");
      out.write("            transform: scaleX(0);  \r\n");
      out.write("            transition: transform 250ms ease-in-out;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .menu:hover:after { transform: scaleX(0.6); }\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"top\" >\r\n");
      out.write("        <div class=\"logo\">\r\n");
      out.write("            <a href=\"");
      out.print( contextPath );
      out.write("/main.do\"><img src=\"");
      out.print( contextPath );
      out.write("/resources/images/winefine_logo.png\" width=\"250px\"></a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <ul class=\"top_right_menu\">\r\n");
      out.write("            <li id=\"top_search\"><img src=\"");
      out.print( contextPath );
      out.write("/resources/images/icon_search.png\" class=\"btn\" data-toggle=\"modal\" data-target=\"#searchModal\"\r\n");
      out.write("                style=\"padding:0px\"></li>\r\n");
      out.write("            ");
 if(loginUser == null) { 
      out.write("\r\n");
      out.write("                <li id=\"top_cart\"><a href=\"");
      out.print( contextPath );
      out.write("/loginForm.me\"><img src=\"");
      out.print( contextPath );
      out.write("/resources/images/icon_cart.png\"></a></li>\r\n");
      out.write("            ");
 }
               else { 
      out.write("\r\n");
      out.write("                <li id=\"top_cart\"><a href=\"");
      out.print( contextPath );
      out.write("/cart.me\"><img src=\"");
      out.print( contextPath );
      out.write("/resources/images/icon_cart.png\"></a></li>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            <!-- 로그인 된 상태가 아니라면 보일것-->\r\n");
      out.write("            ");
 if(loginUser == null) { 
      out.write("\r\n");
      out.write("            	<li id=\"top_mypage\"><a href=\"");
      out.print( contextPath );
      out.write("/loginForm.me\"><img src=\"");
      out.print( contextPath );
      out.write("/resources/images/icon_mypage.png\"></a></li>\r\n");
      out.write("            ");
 }
               else if(!loginUser.getUserId().equals("admin")) { 
      out.write("\r\n");
      out.write("	            <!-- 로그인한 사람이 admin이 아니라면 보일것-->\r\n");
      out.write("	            <li id=\"top_mypage\"><a href=\"");
      out.print( contextPath );
      out.write("/myPage.me\"><img src=\"");
      out.print( contextPath );
      out.write("/resources/images/icon_mypage.png\"></a></li>\r\n");
      out.write("	        ");
 }
               else { 
      out.write("\r\n");
      out.write("	            <!-- 만약 로그인한 사람이 admin이라면 보일것 -->\r\n");
      out.write("	            <li id=\"top_mypage\"><a href=\"");
      out.print( contextPath );
      out.write("/views/admin/adminMain.jsp\"><img src=\"");
      out.print( contextPath );
      out.write("/resources/images/icon_mypage.png\"></a></li>\r\n");
      out.write("	        ");
 } 
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            <li id=\"top_service\"><a href=\"");
      out.print( contextPath );
      out.write("/list.no\"><img src=\"");
      out.print( contextPath );
      out.write("/resources/images/icon_center.png\"></a></li>\r\n");
      out.write("            <li><a href=\"");
      out.print( contextPath );
      out.write("/logout.me\">로그아웃</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <br clear=\"both\">\r\n");
      out.write("    <br>\r\n");
      out.write("\r\n");
      out.write("       \r\n");
      out.write("    <div class=\"nav-area\" align=\"center\">\r\n");
      out.write("        <div class=\"menu\"><a href=\"");
      out.print( contextPath );
      out.write("/views/store/viewAll.jsp\">와인스토어</a></div>\r\n");
      out.write("        <div class=\"menu\"><a href=\"\">소울와인찾기</a></div>\r\n");
      out.write("        <div class=\"menu\"><a href=\"");
      out.print( contextPath );
      out.write("/views/board/terminologyAll.jsp\">게시판</a></div>\r\n");
      out.write("        <div class=\"menu\"><a href=\"");
      out.print( contextPath );
      out.write("/list.no\">고객센터</a></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <!-- The Modal -->\r\n");
      out.write("    <div class=\"modal fade\" id=\"searchModal\" style=\"background-color: white; \">\r\n");
      out.write("        <div class=\"modal-dialog modal-xl\">\r\n");
      out.write("        <div class=\"modal-content\" style=\"border-color: white;\">\r\n");
      out.write("        \r\n");
      out.write("            <!-- Modal Header -->\r\n");
      out.write("            <div class=\"modal-header\" style=\"border-color: white;\">\r\n");
      out.write("            <h4 class=\"modal-title\"></h4>\r\n");
      out.write("            <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <!-- Modal body -->\r\n");
      out.write("            <form>\r\n");
      out.write("                <div class=\"modal-body\" style=\"width:1200px; height: 400px; border-color: white;\">\r\n");
      out.write("                    <b style=\"font-size: 100px;\">search</b><br>\r\n");
      out.write("                    <input type=\"text\" name=\"searchWord\" placeholder=\"원하시는 검색어를 입력하세요.\"\r\n");
      out.write("                        style=\"font-size: 50px; color:grey; width: 1000px; height: 100px; border: white;\">\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <!-- Modal footer -->\r\n");
      out.write("                <div class=\"modal-footer\" style=\"border-color: white;\">\r\n");
      out.write("                        <input type=\"submit\" class=\"btn btn-secondary\" value=\"검색하기\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("            <!-- 헤더 END-->\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- body : 카테고리 페이지 바디 영역 --------------------------------------------->\r\n");
      out.write("    <div class=\"w_ body\">\r\n");
      out.write("        <br>\r\n");
      out.write("        \r\n");
      out.write("        <!-- body left(카테고리) & right(상품리스트)-->\r\n");
      out.write("        <table class=\"store_body\">\r\n");
      out.write("            <td class=\"body_l\">\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("     #leftNavi {\r\n");
      out.write("            list-style-type : none;\r\n");
      out.write("            margin : 0px;\r\n");
      out.write("            padding : 0px;\r\n");
      out.write("            height : 100%;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("        #leftNavi li {\r\n");
      out.write("            width : 100%;\r\n");
      out.write("            height : 11%;\r\n");
      out.write("            text-align : center;\r\n");
      out.write("        }\r\n");
      out.write("        .left_menu a {\r\n");
      out.write("            color: #000;\r\n");
      out.write("            text-decoration : none;\r\n");
      out.write("            margin:0;\r\n");
      out.write("            text-transform:uppercase; \r\n");
      out.write("            font-size : 20px;\r\n");
      out.write("            font-weight : bold;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .left_menu::after {\r\n");
      out.write("            display:block;\r\n");
      out.write("            content: '';\r\n");
      out.write("            border-bottom: solid 3px rgb(107, 50, 91);  \r\n");
      out.write("            transform: scaleX(0);  \r\n");
      out.write("            transition: transform 250ms ease-in-out;\r\n");
      out.write("        }\r\n");
      out.write("        .left_menu:hover::after { transform: scaleX(0.9); }\r\n");
      out.write("        #no1:hover::after { transform: scaleX(0.4); }\r\n");
      out.write("        #no2:hover::after { transform: scaleX(0.3); }\r\n");
      out.write("        #no3:hover::after { transform: scaleX(0.4); }\r\n");
      out.write("        #no4:hover::after { transform: scaleX(0.5); }\r\n");
      out.write("        #no5:hover::after { transform: scaleX(0.3); }\r\n");
      out.write("\r\n");
      out.write("        .search input {\r\n");
      out.write("        padding-left: 10px;\r\n");
      out.write("        width: 70%;\r\n");
      out.write("        height: 40px;\r\n");
      out.write("        font-size: 15px;\r\n");
      out.write("        border: none;\r\n");
      out.write("        border-bottom: 1px black solid;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .search button {\r\n");
      out.write("        font-size: 15px;\r\n");
      out.write("        border: none;\r\n");
      out.write("        background-color: rgb(107, 50, 91);\r\n");
      out.write("        width: 45px;\r\n");
      out.write("        height: 30px;\r\n");
      out.write("        border-radius: 15px;\r\n");
      out.write("        color: #fff;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("        } \r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"content\">\r\n");
      out.write("        <div id=\"content_1\" align=\"center\">\r\n");
      out.write("            <ul id=\"leftNavi\">\r\n");
      out.write("                <b style=\"font-size:24px;\">고객센터</b>\r\n");
      out.write("                <hr style=\"border: 1px solid black\">\r\n");
      out.write("                <li class=\"left_menu\" id=\"no1\"><a href=\"/winefine/list.no\">공지사항</a></li><hr>\r\n");
      out.write("                <li class=\"left_menu\" id=\"no2\"><a href=\"/winefine/list.ev\">이벤트</a></li><hr>\r\n");
      out.write("                <li class=\"left_menu\" id=\"no3\"><a href=\"/winefine/list.on\">1:1문의</a></li><hr>\r\n");
      out.write("                <li class=\"left_menu\" id=\"no4\"><a href=\"/winefine/list.co\">ContactUs</a></li><hr>\r\n");
      out.write("                <li class=\"left_menu\" id=\"no5\"><a href=\"/winefine/list.fa\">FAQ</a></li><br>\r\n");
      out.write("            </ul> \r\n");
      out.write("        \r\n");
      out.write("        <div id=\"content_2\"></div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("            </td>\r\n");
      out.write("            <td class=\"body_r\">\r\n");
      out.write("                <div class=\"delete\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <b style=\"font-size:24px;\">1:1문의</b>\r\n");
      out.write("                        \r\n");
      out.write("                        <hr style=\"border: 1px solid black\">\r\n");
      out.write("                        <br><br>\r\n");
      out.write("                        \r\n");
      out.write("                        <form id=\"oneQna-form\" action=\"\" method=\"post\">\r\n");
      out.write("                \r\n");
      out.write("                            <table align=\"center\">\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <th>* 이름(로그인시 자동입력)</th>\r\n");
      out.write("                                    <td><input type=\"text\" name=\"username\" required value=\"작성된이름\"></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <th>* 연락처(로그인시 자동입력)</th>\r\n");
      out.write("                                    <td><input type=\"text\" name=\"phone\" placeholder=\"(-)과 같이 입력해주세요.\" size=\"50px\" required></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <th>구분</th>\r\n");
      out.write("                                    <td><select style=\"width:386px\">\r\n");
      out.write("                                        <option value=\"상품관련\">상품관련</option>\r\n");
      out.write("                                        <option value=\"주문/결제관련\">주문/결제관련</option>\r\n");
      out.write("                                        <option value=\"반품/환불관련\">반품/환불관련</option>\r\n");
      out.write("                                        <option value=\"회원/정보관련\">회원/정보관련</option>\r\n");
      out.write("                                        <option value=\"기타관련\">기타관련</option>\r\n");
      out.write("                                    </select> \r\n");
      out.write("                                    </td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <th>* 제목</th>\r\n");
      out.write("                                    <td><input type=\"text\" name=\"title\" placeholder=\"제목을 입력해주세요.\" size=\"50px\" required></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <th>* 문의내용</th>\r\n");
      out.write("                                    <td><textarea name=\"content\" cols=\"52\" rows=\"10\"  placeholder=\"내용을 입력하시오.\" style=\"resize:none;\" required></textarea></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            </table>\r\n");
      out.write("                            <br><br>\r\n");
      out.write("                            <div align=\"center\">\r\n");
      out.write("                                <button type=\"submit\" class=\"btn1\">문의하기</button>\r\n");
      out.write("                            </div> \r\n");
      out.write("                        </form>\r\n");
      out.write("                \r\n");
      out.write("                        \r\n");
      out.write("                </div>\r\n");
      out.write("            </td>\r\n");
      out.write("        </table>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("        <!-- bottom : 푸터바 영역 ---------------------------------------------------->\r\n");
      out.write("        <div class=\"w_ bottom\">\r\n");
      out.write("            \r\n");
      out.write("            <!-- 푸터바 START-->\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title> WINEFINE :D </title>\r\n");
      out.write("    <style>\r\n");
      out.write("        /* 가이드라인*/\r\n");
      out.write("        div,table{\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("        body, p{\r\n");
      out.write("            margin: 0;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        /* 구조잡기*/\r\n");
      out.write("        .bottom{\r\n");
      out.write("            width: 1200px;\r\n");
      out.write("            /* 전체 height 1500px의 20%로 가정*/\r\n");
      out.write("            height: 300px;\r\n");
      out.write("            margin:auto;\r\n");
      out.write("        }\r\n");
      out.write("        .footer1, .footer3{\r\n");
      out.write("            width: 1200px;\r\n");
      out.write("            height: 15%;\r\n");
      out.write("        }\r\n");
      out.write("        .footer2{\r\n");
      out.write("            width: 1200px;\r\n");
      out.write("            height: 70%;\r\n");
      out.write("        }\r\n");
      out.write("        .left, .right{\r\n");
      out.write("            width: 25%;\r\n");
      out.write("            vertical-align: middle;\r\n");
      out.write("        }\r\n");
      out.write("        .center{\r\n");
      out.write("            width:50%;\r\n");
      out.write("        }\r\n");
      out.write("        #table{\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* 세부 사항 */\r\n");
      out.write("        .footer{\r\n");
      out.write("            background-color: black;\r\n");
      out.write("            border-bottom: 1px solid gray;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("        .table{\r\n");
      out.write("            color:grey;\r\n");
      out.write("        }\r\n");
      out.write("        .footer1{\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("        }\r\n");
      out.write("        .footer1, .footer3{\r\n");
      out.write("            line-height: 40px;\r\n");
      out.write("        }\r\n");
      out.write("        .text{\r\n");
      out.write("            color:white;\r\n");
      out.write("        }\r\n");
      out.write("        a{\r\n");
      out.write("            color: white;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("        }\r\n");
      out.write("        a:hover{\r\n");
      out.write("            color: gray;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("        }\r\n");
      out.write("        #logo{\r\n");
      out.write("            color: #6B325B;\r\n");
      out.write("        }\r\n");
      out.write("        .center, #copyright{\r\n");
      out.write("            font-size: 80%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <!-- 모든페이지 > bottom 영역에 들어갈 푸터바         -->\r\n");
      out.write("    <!-- 참고) 푸터바 영역은 전체 height:1500px의 20% 할당-->\r\n");
      out.write("    <div class=\"bottom\">\r\n");
      out.write("        <div class=\"footer footer1\">\r\n");
      out.write("            <span class=\"text\"><a href=\"\">브랜드소개</a> &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp; </span>\r\n");
      out.write("            <span class=\"text\"><a href=\"\">오시는 길</a> &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp; </span>  \r\n");
      out.write("            <span class=\"text\"><a href=\"\">이용약관</a> &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp; </span> \r\n");
      out.write("            <span class=\"text\"><a href=\"\">개인정보취급방침</a> &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp; </span> \r\n");
      out.write("            <span class=\"text\"><a href=\"\">고객센터</a> </span> \r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"footer footer2\">\r\n");
      out.write("            <table id=\"table\">\r\n");
      out.write("                <td class=\"left\">\r\n");
      out.write("                    <h1 id=\"logo\">WINEFINE</h1>\r\n");
      out.write("                </td>\r\n");
      out.write("                <td class=\"table center\">\r\n");
      out.write("                    (주)와인파인 대표자: WINEFINE<br>\r\n");
      out.write("                    사업자등록번호: [KH-452-02-00843] 통신판매업자신고번호: 제2022-서울 영등포 - NO4호<br>\r\n");
      out.write("                    대표번호: KH-1640-5091 주소: 서울특별시 영등포구 선유동2로 57 이레빌딩 19F, 20F<br>\r\n");
      out.write("                    개인정보관리자: KH(khlove@iei.co.kr)<br>\r\n");
      out.write("                    대표메일 winefine@iei.co.kr 사이트명: 와인파인<br>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    Bank Accounts : KH은행 027-142321-01-004 주식회사 와인파인<br>\r\n");
      out.write("                    CS Center : 1661-5091 AM 10:00 ~ PM 6:00<br>\r\n");
      out.write("                    (점심시간 PM 1:00~ 2:00) ( WEEKEND/HOLIDAY OFF )<br>\r\n");
      out.write("                </td>\r\n");
      out.write("                <td class=\"table right\">\r\n");
      out.write("                    <h5>고객센터 운영시간</h5>\r\n");
      out.write("                    평일 10:00 - 18:00<br>\r\n");
      out.write("                    점심시간 13:00 - 14:00<br>\r\n");
      out.write("                    주말 및 공휴일 휴무\r\n");
      out.write("                </td>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("            \r\n");
      out.write("        <div class=\"footer footer3\">\r\n");
      out.write("            <p id =\"copyright\" class=\"text\">Copyright © 2022 WINEFINE Information All Right Reserved</p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("            <!-- 푸터바 END-->\r\n");
      out.write("        \r\n");
      out.write("        </div>\r\n");
      out.write("    </div> \r\n");
      out.write("\r\n");
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
