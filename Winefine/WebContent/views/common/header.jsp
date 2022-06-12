<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.winefine.member.model.vo.Member" %>
<% 
	// 로그인한 사용자 정보 뽑기
	Member loginUser = (Member)session.getAttribute("loginUser"); 
	// 서블릿에서 보낸 메세지 뽑기
	String alertMsg = (String)session.getAttribute("alertMsg");
	// 메인 화면으로 이동하는 경로 뽑기
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> WINEFINE :D </title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- * 부트스트랩 영역 --------------------------------------------------------------------------->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
 <!-- menubar영역은 모든 페이지마다 넣어주기로 했으니 얘한테 한번 넣어두면 include 되는 모든페이지에서 쓸 수 있겠쥬 ! ☆  -->

<!-- swiper.js -->
<link
  rel="stylesheet"  
  href="https://unpkg.com/swiper@8/swiper-bundle.min.css"
/>

<script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>

<style>

    .topWrap {
        padding : 22px 0 21px;
    }

    .logo {
        width: 400px;
        float: left;
    }

    .logo>a {
        margin-left: 30px; /* 로고의 왼쪽 여백 설정 */
    }
    
    .top_right_menu { float: right;}

    .top_right_menu .top_menu{
        list-style-type: none;
        float: left;
        margin-right: 10px;
        padding-right: 15px;
        padding-left: 15px;
    }
    #top_service>a { margin-right: 30px;} /* 우측 상단 아이콘의 오른쪽 여백 설정 */

    .menu {
        display: table-cell;
        height: 30px;
        width: 200px;
    }

    .menu a {
        text-decoration: none;
        color: black;
        font-size: 20px;
        font-weight: bold;
        display: block; 
        width: 100%;
        height: 100%;
        line-height: 30px; /* 장평조절: 위~ 아래에서 가운데 조정 */
    }

    .menu a:hover {
        color:#6B325B;
    }

    .menu:after {
            display:block;
            content: '';
            border-bottom: solid 4px #6B325B;  
            transform: scaleX(0);  
            transition: transform 250ms ease-in-out;
            padding: 0px;
    }

    .menu:hover:after { transform: scaleX(0.6); }

    #top_mypage {
        position: relative;
    }

    #top_mypage button {
        padding-right: 17px;
        background: url("/winefine/resources/images/pc_gray_arrow.png") no-repeat 100% 50%;
        border: 0;
        outline: none;
        cursor: pointer;
    }

    .mp_layer {
        display: none;
        position: absolute;
        top: 150%;
        transform: translateX(-25%);
        border: 1px solid #ddd;
        z-index: 200;
    }

    .noLogin {
        width: 80px;
        background: #fff;
        padding: 10px 8px;
        text-align: center;
    }

    li .mp_layer .noLogin a:first-child {
        margin-bottom: 5px;
    }

    .noLogin a{
        display: block;
        font-size: 12px;
        color: #555;
    }

    /* 로그인후 */
    li .mp_layer {
        display: none;
        position: absolute;
        top: 150%;
        transform: translateX(-25%);
        border: 1px solid #ddd;
        z-index: 200;
    }

    li .mp_layer .onLogin {
        width: 180px;
        background: #fff;
        padding: 10px 0 20px;
    }

    .mp_layer .onLogin ul {
        padding-left: 10px;
    }

    .mp_layer .onLogin ul li {
        width: 100%;
        padding-top: 10px;
        margin: 0;
        overflow: hidden;
        text-align: left;
    }

    .mp_layer .onLogin ul li .top_line {
        border-top: 1px solid black;
        padding-bottom: 10px;
    }


    .mp_layer .onLogin .btn_txt {
        margin: 5px 10px 0 !important;
        padding-right: 0 !important;
        width: calc( 100% - 20px) !important;
        height: 30px !important;
        font-size: 13px !important;
        line-height: 30px !important;
        font-weight: 700 !important;
        background:#6B325B !important;
        display: inline-block !important;
        color: white;
    }


</style>
</head>
<body>
    <div class="top" >
        <div class="topWrap">

            <div class="logo">
                <a href="<%= contextPath %>/main.do"><img src="<%= contextPath %>/resources/images/winefine_logo.png" width="250px"></a>
            </div>
            <ul class="top_right_menu">
                <li class="top_menu" id="top_search"><img src="<%= contextPath %>/resources/images/icon_search.png" class="btn" data-toggle="modal" data-target="#searchModal"
                    style="padding:0px"></li>
                <% if(loginUser == null) { %>
                    <li class="top_menu" id="top_cart"><a href="<%= contextPath %>/loginForm.me"><img src="<%= contextPath %>/resources/images/icon_cart.png"></a></li>
                <% }
                   else { %>
                    <li class="top_menu" id="top_cart"><a href="<%= contextPath %>/list.ca"><img src="<%= contextPath %>/resources/images/icon_cart.png"></a></li>
                <% } %>
                
                <!-- 로그인 된 상태가 아니라면 보일것-->
                <% if(loginUser == null) { %>
                    <li class="top_menu" id="top_mypage">
                        <button type="button"><img src="<%= contextPath %>/resources/images/icon_mypage.png"></button>
                        <div class="mp_layer">
                            <div class="noLogin">
                                <a href="<%= contextPath %>/loginForm.me">로그인</a>
                                <a href="<%= contextPath %>/enrollInfo.me">회원가입</a>
                            </div>
                        </div>
                    </li>
                <% }
                   else if(!loginUser.getUserId().equals("admin")) { %>
                    <!-- 로그인한 사람이 admin이 아니라면 보일것-->
                    <li class="top_menu" id="top_mypage">
                        <button type="button"><img src="<%= contextPath %>/resources/images/icon_mypage.png"></button>
                        <div class="mp_layer">
                            <div class="onLogin">
                                <ul>
                                    <li><b><%= loginUser.getUserName() %>님</b></li>
                                    <li><b>WineFine입니다.</b></li>
                                </ul>
                                <button class="btn_txt" onclick="location.href='<%= contextPath %>/myPage.me'">마이페이지</button>
                                <br>
                                <button class="btn_txt" onclick="location.href='<%= contextPath %>/logout.me'">로그아웃</button>
                            </div>
                        </div>
                    </li>
                <% }
                   else { %>
                    <!-- 만약 로그인한 사람이 admin이라면 보일것 -->
                    <li class="top_menu" id="top_mypage"><a href="<%= contextPath %>/main.admin"><img src="<%= contextPath %>/resources/images/icon_admin.png"></a></li>
                <% } %>
                
                
                
                <li class="top_menu" id="top_service"><a href="<%= contextPath %>/list.no"><img src="<%= contextPath %>/resources/images/icon_center.png"></a></li>
                <!-- <li><a href="<%= contextPath %>/logout.me">로그아웃</a></li> -->
            </ul>
        </div>
    </div>

    <br clear="both">
    <hr>


       
    <div class="nav-area" align="center">
        <div class="menu"><a href="<%= contextPath %>/store.th?currentPage=1">와인스토어</a></div>
        <div class="menu"><a href="<%= contextPath %>/views/board/soulWine.jsp">소울와인찾기</a></div>
        <div class="menu"><a href="<%= contextPath %>/list.th?boardType=wine">게시판</a></div>
        <div class="menu"><a href="<%= contextPath %>/list.no">고객센터</a></div>
    </div>
<br>
    
    <!-- The Modal -->
    <div class="modal fade" id="searchModal" style="background-color: white; ">
        <div class="modal-dialog modal-xl">
        <div class="modal-content" style="border-color: white;">
        
            <!-- Modal Header -->
            <div class="modal-header" style="border-color: white;">
            <h4 class="modal-title"></h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            
            <!-- Modal body -->
            <form action="<%= contextPath %>/search.pr" method="get">
                <div class="modal-body" style="width:1200px; height: 400px; border-color: white;">
                    <b style="font-size: 100px;">search</b><br>
                    <input type="text" name="searchWord" placeholder="원하시는 검색어를 입력하세요."
                        style="font-size: 50px; color:grey; width: 1000px; height: 100px; border: white;">
                </div>
                
                <!-- Modal footer -->
                <div class="modal-footer" style="border-color: white;">
                        <input type="submit" class="btn btn-secondary" value="검색하기">
                </div>
            </form>
        </div>
        </div>
    </div>

    
    

    <script>
    	
        var message = "<%= alertMsg %>";
        
        if(message != "null") { //로그인 정보가 넘어온 경우
            
            alert(message);
        
            <% session.removeAttribute("alertMsg"); %>
        }

        $(function () {
            $("#top_mypage button").click(function () {
                if( $(".mp_layer").css("display") == "none") {

                    $(".mp_layer").css("display", "block");
                }
                else {
                    $(".mp_layer").css("display", "none");
                }
            });

            $(".btn_txt").css("background-image", "url('')");
            $(".btn_txt").css("padding-right", 0);
            $(".btn_txt").css("padding-left", 0);
            $(".btn_txt").css("outline", "auto");
            $(".btn_txt").css("outline", "auto");

        });


        
    </script>


</body>
</html>