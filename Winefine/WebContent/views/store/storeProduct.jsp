<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.winefine.store.model.vo.Product" %>
<% 
	Product p = (Product)request.getAttribute("p");
	//userNo 필요함/////////////////////////////////////////////////////////////////////////////////
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="styleshhet" href="css/header.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> WINEFINE :D </title>
    <style>
        /* 전체 구조 잡기*/
        div{
            box-sizing: border-box;
        }
        .wrap{
            width:1200px;
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
            height: 300px;
        }

        /* - 구조 : body 영역 _ 4분할 */
        .body_1{
            height: 300px;
        }
        .body_2{
            height: 300px;
        }

       
        /* 테이블 */
        .float{
            float: left;
        }
        .float>table{
            width: 90%;
        }
        .summery{
            width: 100%;
            font-size: 14px;
            font-weight: 600;
            box-sizing: border-box;
        }
        td{
            padding:5px;
            width: 200px;
        }
        image{
            width: 10px;
            height: 10px;
        }

        /* 세부 사항 */
        .underline{
            width: 100%;
            height: 50px;
            border-bottom: 1px solid #BDBDBD;
        } 
        .body2area{
            width: 100%;
            height: 180px;
            border-radius: 10px;
            margin-top: 30px;
            background-color: #f3f0f0;
            padding: 30px 100px;
        }
        .pairing{
            background-color: #f3f0f0;
            width: 100%;
            height: 250px;
        }

        .body_1 a{
            color:#BDBDBD;
            font-size: 30px;  
            text-decoration: none; 
        }
        .body_1 .btn{
            border: none;
            width: 240px;
            margin-left: 10px;
            margin-top: 0px;
        }

        /* viewDetail-navi 세부사항 */
        #viewDetail-navi a{
            text-decoration: none;
            color: white;
            display: block;
        }
        #viewDetail-navi{
            width:1200px;
            margin : 0px;
            padding :0px;
        }
        #viewDetail-navi > li{
            width: 20%;
            font-size: 14px;
            line-height: 25px;
            background-color: black;
            border: 1px solid white;
            box-sizing: border-box;
            float: left;
            list-style-type : none;
            text-align: center;
        }
        #viewDetail-navi > li :hover{
            display: block;
            background-color: #6B325B;
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
		<br>
            <!-- body1 : 상품이미지 & 상품명 -->
            <div class="w_ body_1" >
                <div class="float" style="width: 45%; padding-left: 150px;" >
                    <img src="<%= p.getThumbnail() %>" style="height: 300px;" >
                    
                </div>
                <div class="float" style="width: 55%; padding: 20px;">
                    <table align="center;">
                        <tr>
                            <td style="border-bottom: 1px solid #BDBDBD; font-size: 12px;"> WINEFINE > <%= p.getProductType()%> > <%= p.getProductName()%></td>
                        </tr>
                        <tr>
                            <td><br><h2><b><%= p.getProductName()%></b></h2></td>
                        </tr>
                        <tr>
                            <td><%= p.getOrigin()%> / <%= p.getBrand()%></td>
                        </tr>
                        <tr>
                            <td style="text-align: center;"><h4>₩ <%= p.getPrice()%></h4></td>
                        </tr>
                        <tr>
                            <td style="border-bottom: 1px solid #BDBDBD;">도수 : <%= p.getAlcohol()%> % <br><br></td>
                        </tr>
                        
                        <tr>
                            <td>

                               <div align="center">
                                
                                <% if(loginUser != null) { %>
	                                &nbsp;&nbsp;
	                                <input type="button" class="btn btn-secondary" style="background-color: #BDBDBD;" value="장바구니 담기"
	                                data-toggle="modal" data-target="#myModal" >
                                    <% }
                                    else { %>
                                        &nbsp;&nbsp;
	                                <input type="button" class="btn btn-secondary" style="background-color: #BDBDBD;" value="장바구니 담기"
	                                data-toggle="modal" data-target="#myModal" disabled>
                                    <% } %>
                                </div>
                                    <!-- 장바구니 모달 영역 START -->
                                    <div class="modal fade" id="myModal">
                                        <div class="modal-dialog modal-lg">
                                        <div class="modal-content">
                                        
                                            <!-- Modal Header -->
                                            <div class="modal-header" style="background-color: #f3f0f0;">
                                                <b class="modal-title" style="font-size: 22px;">주문상품  </b>
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            </div>
                                            
                                            <form action="/winefine/insertList.ca" method="post">
                                            <input type="hidden" name="productNo" value="<%= p.getProductNo() %>">
                                            <%--<input type="hidden" name="userNo" value="<%= loginUser.getUserNo() %>"> --%>
                                            <input type="hidden" name="price" value="<%= p.getPrice() %>">
                                            <!-- Modal body -->
                                            <div class="modal-body" style="background-color: #f3f0f0;">
                                                <table align="center">
                                                    <tr>
                                                        <td>
                                                        	<!-- 와인이름 갖고오기 -->
                                                            <b><%= p.getProductName() %></b>
                                                        </td>
                                                        <td>
                                                            <!-- <input type="number" min="0" required; placeholder="1">  -->
                                                            <input name="bottle" type="number" min="0" required placeholder="How many?">
                                                        </td>
                                                        <td>
                                                            <b> ₩ <%= p.getPrice() %></b>
                                                        </td>
                                                    </tr>
                                                    
                                                </table>
                                                <br><br><br><br><br><br><br><br>
                                            </div>
                                            
                                            <!-- Modal footer -->
                                            <div class="modal-footer" style="background-color: #f3f0f0;">
                                                <table>
                                                    <tr>
                                                        <td>
                                                            <!-- <input type="button" class="btn btn-secondary" style="background-color: #BDBDBD;" value="장바구니에 담기">  -->
                                                            <button type="submit">장바구니 담기</button>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                            </form>
                                            
                                        </div>
                                        </div>
                                    </div>
                                    <!-- 장바구니 모달 영역 END-->

                            </td>
                        </tr>
                    </table>
                </div>
                <br clear="both">
            </div>

            <!-- body2 : 상품 요약 정보 -->
            <div class="w_ body_2">
                <div class="underline">
                </div>
                <div class="body2area">
                    <table class="summery">
                        <tr>
                            <td><li>생산지역</li></td>
                            <td><%= p.getOrigin() %></td>

                            <td><li>와인타입</li></td>
                            <td><%= p.getProductType() %></td>

                            <td rowspan="3">
                                <img src="<%=contextPath%>/resources/images/vivino-logo.png">
                            </td>
                        </tr>
                        <tr>
                            <td><li>브랜드</li></td>
                            <td><%= p.getBrand() %></td>

                            <td><li>당도</li></td>
                            <td><%= p.getSweetness() %></td>

                        </tr>
                        <tr>
                            <td><li>와인도수</li></td>
                            <td><%= p.getAlcohol() %> %</td>

                            <td><li>바디</li></td>
                            <td><%= p.getBody() %></td>

                        </tr>
                        <tr>
                            <td></td>
                            <td></td>

                            <td><li>탄닌</li></td>
                            <td><%= p.getAcidity() %></td>
                            <td>&nbsp;&nbsp;출처 : 비비노</td>
                        </tr>
                    </table>
                </div>
            </div>
            <br>


            <!-- body3: 상세페이지-->
            <div class="w_ body_3">
                <div class="underline" >
                </div><br>

                <div>
                    <!-- viewDetail-navi 영역 START -->
                    <!-- 쿼리스트링 나열 '&'로 해야함 주의 ★-->
                    <ul id="viewDetail-navi">
                        <li class="pr1"><a href="<%=contextPath%>/store.pr?pno=<%= p.getProductNo()%>">상세페이지</a></li>
                        <li class="pr2"><a href="<%=contextPath%>/store.in?pno=<%= p.getProductNo()%>">상품정보</a></li>
                        <li class="pr3"><a href="<%=contextPath%>/store.re?pno=<%= p.getProductNo()%>">교환 및 반품 안내</a></li>
                        <li class="pr4"><a href="<%=contextPath%>/review?pno=<%=p.getProductNo()%>&currentPage=1">상품후기</a></li>
                        <li class="pr5"><a href="<%=contextPath%>/qna?pno=<%=p.getProductNo()%>&currentPage=1">Q & A</a></li>
                    </ul> 

                    <br clear="both">
                    <!-- viewDetail-navi 영역 END-->
                </div>

                <div>
                    <!-- viewDetail-content 영역-->
                    <div class="pairing" align="center" style="height: 1000px;">
                        <br><br><br> <img src="<%= p.getContentPhoto1() %>">
                    </div>
                </div>

            </div>

            <br><br>
            
            <!-- bottom : 푸터바 영역 ---------------------------------------------------->
            <div class="w_ bottom">
            <!-- 푸터바 START-->
            <%@ include file="../common/footer.jsp" %>
            <!-- 푸터바 END-->
            </div>

       </div>
   </div>

</body>
</html>

