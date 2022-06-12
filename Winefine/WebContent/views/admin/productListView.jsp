<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.winefine.store.model.vo.Product, com.winefine.common.model.vo.PageInfo" %>
    
<% 

	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list"); 
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	// 페이징바 관련 변수
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();


%>   
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> WINEFINE :D </title>
    <style>
        /* 전체 구조 잡기*/
        div{
            /* border: 1px solid red;  */
            /*가이드라인 용이니 다 쓰시고 지우면 됩니다 */
            box-sizing: border-box;
        }
        .wrap{
            width: 1200px; 
            height: 1200px; 
            margin: auto;
        }
        .w_{
            width: 100%;
        }
        .top {
            height: 240px; /* height: 240px */
        }
        .body {
            height: 800px;
        }
        .bottom{
            height: 100px;  /* height: 100px */
        }
        
        /* 상세 항목 */
        td{
            padding-right: 20px;
            padding-left: 20px;
        }
        .bottom{
            font-size: 14px;
            font-weight: 600;
        }
        .btn{
        	margin:5px 10px;
        }

        #productList {
            margin: auto;
            text-align: center;
        }

        thead>tr th {
            padding: 5px;
        }

        #productList>tbody>tr td {
            /* width: 60px; */
            text-align: center;
            padding: 5px;
        }
        
        #productList>tbody>tr:hover {
            cursor: pointer;
            color: rgb(119, 45, 96);
        }



    </style>
</head>

<body>
    <div class="wrap">

       <!-- top : hearder 삽입 영역 ------------------------------->
        <div class="w_ top">
            <div class="w_" style="height: 150px;">
                <!-- 헤더 START-->
                <%@ include file="../common/adminHeader.jsp" %>
                <!-- 헤더 END-->
            </div>
            
            <div class="w_" style="height: 90px;">
           		<br>
                <table>
                    <tr id="top_btn">
                        <td style="width:480px; font-size: 22px; font-weight: 600; text-align : left;">상품 전체 관리</td>
                        <td colspan="2" style="width: 720px; text-align: right;">
                            <button type="button" id="insertProduct">상품등록</button>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><hr></td>
                    </tr>
                </table>
            </div>
        </div>

        <!-- body : 바디 영역 --------------------------------------->
        <div class="w_ body">

            <br>

            <table id="productList" align="center" border="1">
                <thead>
                    <tr>
                        <th>상품번호</th>
                        <th width="200">상품명</th>
                        <th>종류</th>
                        <th>원산지</th>
                        <th>브랜드</th>
                        <th>가격</th>
                        <th>재고수량</th>
                        <th>도수</th>
                        <th>당도</th>
                        <th>산도</th>
                        <th>바디</th>
                        <th>탄닌</th>
                        <th>상태</th>
                    </tr>
                </thead>
                <tbody>

                <% for( Product p : list) { %>
                    <tr>
                    	<td><%= p.getProductNo() %></td>
                        <td><%= p.getProductName() %></td>
                        <td><%= p.getProductType() %></td>
                        <td><%= p.getOrigin() %></td>
                        <td><%= p.getBrand() %></td>
                        <td><%= p.getPrice() %></td>
                        <td><%= p.getStock() %></td>
                        <td><%= p.getAlcohol() %></td>
                        <td><%= p.getSweetness() %></td>
                        <td><%= p.getAcidity() %></td>
                        <td><%= p.getBody() %></td>
                        <td><%= p.getTannin() %></td>
                        <% if(p.getStatus().equals("Y")) { %>
                        <td>판매중</td>
                        <% }
                        else { %>
                        <td>판매중지</td>   
                        <% } %>
                    </tr>
                <% } %>

                </tbody>
            </table>
        </div>

       <!-- bottom : 하단 영역 --------------------------------------->
       <!-- 
       <div class="w_ bottom" align="center">
            <button type="button" class="btn btn-secondary">초기화</button>
            <button type="button" class="btn btn-secondary">수정하기</button>
       </div>
       -->
    
    </div> 
    <!-- 페이징바 -->
    <div align="center" class="paging-area">
        	
        <% if(currentPage != 1) { %>
            <button onclick="location.href='<%= contextPath %>/productView.admin?currentPage=<%= currentPage - 1 %>';">&lt;</button>
        <% } %>
        
        <% for(int p = startPage; p <= endPage; p++) { %>
            <% if(p != currentPage) { %>
                <button onclick="location.href='<%= contextPath %>/productView.admin?currentPage=<%= p %>';"><%= p %></button>
            <% } else { %>
                <!-- 현재 내가 보고있는 페이지일 경우는 클릭 안되게끔 -->
                <button disabled><%= p %></button>
            <% } %>
        <% } %>
        
        <% if(currentPage != maxPage) { %>
            <button onclick="location.href='<%= contextPath %>/productView.admin?currentPage=<%= currentPage + 1 %>';">&gt;</button>
        <% } %>
    </div>
    <br><br>
    
    

    <script>

        $(function () {

            $("#insertProduct").click(function () {
                location.href="views/admin/productInsert.jsp";
            });

            $("#productList>tbody tr").click(function () {
                location.href="/winefine/selectOneProduct.admin?pno=" + $(this).children().eq(0).text();
            });

        });

    </script>
   

</body>
</html>