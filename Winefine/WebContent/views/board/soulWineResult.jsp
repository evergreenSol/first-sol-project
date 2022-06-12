<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.winefine.store.model.vo.Product, java.util.ArrayList" %>
<%    
	//int sweetness = Integer.parseInt(request.getParameter("sweetness"));
	//int acidity = Integer.parseInt(request.getParameter("acidity"));
	//int body = Integer.parseInt(request.getParameter("body"));
	//int tannin = Integer.parseInt(request.getParameter("tannin"));
	
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("soulWineResultList");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> WINEFINE :D </title>



<style>
    div{
		box-sizing: border-box;
        /*border: 1px solid red;*/
	}
	.wrap{
		width: 1200px;
		height: 800px;
		margin: auto;
	}
	.w_{
		width: 100%;
	}
	
	.top{ 
      	height: 10%;

    }
    .body{
        /******************/
        height: auto;
        /*******************/
        width: 100%;
        margin: auto;
    }
    .bottom{
        height: 20%;
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

    #soulWineForm{
        height: 100%;
        /*border: 3px solid;*/
        margin-top: 100px;
        margin-bottom: 100px;
        
    }

    form table{
        margin: auto;
        width: 80%;
    }

    #buttonDiv{
        width: 15%;
        float: right;
        margin-top: 30px;
    }

	/* 상품부분*/
    .Pthumbnail{
        width: 210px;
        height: 270px;
        display: inline-block; /* 가로로 배치 */
        margin: 15px 20px;
    }
    .Pthumbnail img{
        width: 60px;
        height: 225px;
    }
    .Pthumbnail img:hover{
        cursor: pointer;
        opacity: 0.7;
    } 
    p{
        margin: 0px;
    }

    #btn{
        background-color: rgb(107, 50, 91);
        color: white;
        font-size: medium;
        border-radius: 15px;
        border: none;
        width: 130px;
        height: 50px;
        font-size: large;
        font-weight: 900;
    }

    #btn:hover{
        opacity: 0.7;
    }
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
            <br><br><br><br>
            <div class="videoT">

                <div class="img">
                    <video width="100%" height="auto" autoplay muted loop playsinline>
                        <source src="/winefine/resources/images/soul.mp4">
                    </video>
                </div>
                <h2 class="bg_dark">
                    <span>소울와인찾기결과</span>
                </h2>
            </div>
            
            <div style="width: 80%; height:auto; margin: auto">
                    <div style="height:auto; margin-bottom: 100px;">
                        <%if(!list.isEmpty()){ %>
                            <% for(Product p : list) { %>
                            <div class="Pthumbnail" align="center" >
                            <input type="hidden" value="<%= p.getProductNo() %>"> <!-- 상품번호 선택용 -->
                                <img src="<%= p.getThumbnail() %>">
                                <p>
                                    <b><%= p.getProductName() %></b><br>
                                    ₩ <%= p.getPrice() %> / <%= p.getProductType() %> 
                                </p>
                            
                            </div>
                            <%} %>
                        <%}else{ %>
							<div align="center">
                        		<img src="resources/images/soulWineFail.PNG">
	                        </div>
                            
                            <div align="center" style="margin-top: 30px;">
                                <button id="btn" onclick="location.href='views/board/soulWine.jsp'">다시하기
                            </div>

                        <% } %>
                    </div>
                    <!----------------------------------------------------->
                 
        </div>
        <!-- bottom : 푸터바 영역 ---------------------------------------------------->
        <div class="w_ bottom">
            
            <!-- 푸터바 START-->
            <%@ include file="../common/footer.jsp" %>
            <!-- 푸터바 END-->
         
        </div>
		
	<script>
       $(function(){
           $(".Pthumbnail").click(function(){
               var pno = $(this).children().eq(0).val();

               location.href="<%=contextPath%>/store.pr?pno="+pno;
           });
       });
   </script>
		
	</div>
</body>
</html>