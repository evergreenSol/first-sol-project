<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.winefine.oneqna.model.vo.*, java.util.ArrayList" %>    
<%
	ArrayList<Category> list = (ArrayList<Category>)request.getAttribute("list");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> WINEFINE :D </title>
<style>
    /* 전체 구조 잡기*/
    div{
        box-sizing: border-box;
    }
    .wrap{
            width: 1200px;
            height: 1500px;
            margin: auto;
    }
    .w_{
        width: 100%;
    }
    .top{
       height: 10%;
    }
    .body{
        height: 70%;
    }
    .bottom{
        height: 20%;
    }
    
    /* - 구조 : body 영역_ 좌측 & 우측 분할 */
    .sortArea{
        height: 3%;
        padding-right: 100px;
    }
    .store_body{
        width: 100%;
        height: 70%;
    }
    .store_body td.body_l{
        width: 20%;
        vertical-align: top;
    }
    .store_body td.body_r{
        width: 80%;
    }
    
    /* 상세 항목 */
    .sort{
        float: right;
        height: 100%;
    }

    .delete{
        padding-left: 5%;
        width: 90%;
        height: 100%;
    }
    /* body_r 영역 */
    #oneQna-form {
       margin: auto;
       width: 700px;   
    }

    #oneQna-form input, #oneQna-form textarea, #oneQna-form select {
        width: 100%;
        box-sizing: border-box;
        margin:10px
        
    }
    .btn1{
        background-color : rgb(107, 50, 91);
        color : white;
        cursor : pointer;
        width: 90px;
        height: 50px;
        font-size:medium;
        
    }  

    /* 영상 테스트 */

    .videoT {
        width: 100%; 
        overflow: hidden;
        margin: 0px auto; 
        position: relative;

    }
    .videoT.img {
        /* position: absolute; */
        top: 0;
        left: 50%;
        width: 100%;
        transform: translateX(-50%);
        /* z-index: 1; */
    }
    .videoT .bg_dark {
        position: absolute; 
        top: 35%;
        /* left: 50%; */
        width: 100%;
        text-align: center;
        /* z-index: 20; */
        
    }
    .videoT .bg_dark span {
        /* text-align: center;  */
        font-size: 30px; 
        color: #ffffff;
    }

    /**************************************************/
    </style>
    </head>
		

    <body>
    
    <div class="wrap">
    
        <!-- top : hearder 삽입 영역 ------------------------------->
        <div class="w_ top">

            <!-- 헤더 START-->
            <%@ include file="../common/header.jsp" %>
            <!-- 헤더 END-->

        </div>

    <!-- body : 카테고리 페이지 바디 영역 --------------------------------------------->
    <div class="w_ body">
        <br><br>
        <div class="videoT">

            <div class="img">
                <video width="100%" height="auto" autoplay muted loop playsinline>
                    <source src="/winefine/resources/images/wine.mp4">
                </video>
            </div>
            <h2 class="bg_dark">
                <span>고 객 센 터</span>
            </h2>
        </div>
        <br>
        
        <!-- body left(카테고리) & right(상품리스트)-->
        <table class="store_body">
            <td class="body_l">
                <%@ include file="../common/category-notice.jsp" %>
            </td>
            
            <td class="body_r">
                <div class="delete">


                        <b style="font-size:24px;">1:1문의</b>
                        
                        <hr style="border: 1px solid black">
                        <br><br>
                        
                        <form id="oneQna-form" action="<%= contextPath %>/insert.on" method="post">
                		
                		 <input type="hidden" name="userNo" value="<%= loginUser.getUserNo() %>">
                		 
                            <table align="center">
                                <tr>
                                    <th>* 아이디</th>
                                    <td><input type="text" name="username" required value="<%= loginUser.getUserId() %>" readonly></td>
                                </tr>
                                <tr>
                                    <th>* 연락처</th>
                                    <td><input type="text" name="phone" placeholder="(-)과 같이 입력해주세요." size="50px" required value="<%= loginUser.getPhone() %>" readonly></td>
                                </tr>
                                <tr>
                                    <th> 구분</th>
                                    <td><select name="category" style="width:386px">
                                        
                                        <% for(Category c : list)  { %>
                                        	<option value="<%= c.getCategoryNo()%>"><%= c.getCategoryName() %></option>
                                        <% } %>
                                    </select> 
                                    
                                    </td>
                                </tr>
                                <tr>
                                    <th>* 제목</th>
                                    <td><input type="text" name="title" placeholder="제목을 입력해주세요." size="50px" required></td>
                                </tr>
                                <tr>
                                    <th>* 문의내용</th>
                                    <td><textarea name="content" cols="52" rows="10"  placeholder="내용을 입력하시오." style="resize:none;" required></textarea></td>
                                </tr>
                            </table>
                            <br><br>
                            <div align="center">
                                <button type="submit" class="btn1">문의하기</button>
                            </div> 
                        </form>
                		
                        
                </div>
            </td>
        </table>
    </div>


    
        <!-- bottom : 푸터바 영역 ---------------------------------------------------->
        <div class="w_ bottom">
            
            <!-- 푸터바 START-->
            <%@ include file="../common/footer.jsp" %>
            <!-- 푸터바 END-->
        
        </div>
       
    </div> 
	
</body>
</html>