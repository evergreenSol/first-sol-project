<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.winefine.order.model.vo.Order, com.winefine.order.model.vo.OrderProduct" %>
<%
	String pickup = (String)request.getAttribute("pickup"); // 수령인
	String locationName = (String)request.getAttribute("locationName"); // 수령장소
	String orderDate = (String)request.getAttribute("orderDate"); // 수령일자 [[[Date -> String??]]]
	String payment = (String)request.getAttribute("payment"); // 결제방법

	ArrayList<Order> orderAll = (ArrayList<Order>)request.getAttribute("orderAll");
	ArrayList<OrderProduct> opList = (ArrayList<OrderProduct>)request.getAttribute("opList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> WINEFINE :D </title>
<style>

	div{
		box-sizing: border-box;
	}
	.wrap{
		width: 1200px;
		/* height: 1500px; */
		margin: auto;
	}
	.w_{
		/* border: 1px solid red; */
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
    .myPage-body{
        width: 100%;
        height: 97%;
    }
    .myPage-body td.body_l{
        width: 20%;
        vertical-align: top;
    }
    .myPage-body td.body_r{
        width: 80%;
    }
    
    /* 상세 항목 */

    .delete{
        padding-left: 5%;
        width: 90%;
        height: 97%;
    }
    
    table img {
        width: 100px;
        height: 100px;
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
            <!-- body left(카테고리) & right(내용)-->
            <table class="myPage-body">
                <td class="body_l">
                <%@ include file="../common/category-myPage.jsp" %>
                </td>
                <td class="body_r">
                    <div class="delete">
                        <!-- <h2>상품 주문내역</h2> -->
						<b style="font-size:24px;">상품주문내역</b>
			    		<hr style="border: 1px solid black">
			
			
						<% if(orderAll.isEmpty() || opList.isEmpty()) { %>
							<table style="text-align: center">
								<tr>
									<td height="300" width="900" >주문내역이 없습니다.</td>
								</tr>
							</table>
						<% } 
							else { %>
									
							
								<% for(int i = 0; i < orderAll.size(); i++) { %> 
									
									<table>
										<tr>
											<td colspan="4"></td>    
										</tr>
										<tr>
											<!-- <td rowspan="3" width="100" height="100"><img src=""></td>   -->
											<th width="80">주문번호</th>
											<td width="10"></td>
											<td class="orderNo" width="80">
												<%= orderAll.get(i).getOrderNo() %>
											</td>
										</tr>
										<tr>
											<th>결제금액</th>
											<td></td>
											<td><%= orderAll.get(i).getTotalPrice() %>원</td>
											<td width="650" align="right"><button type="button" class="moreBtn">더보기</button></td>
										</tr>
										<tr>
											<th>주문상태</th>
											<td></td>
											<td><%= orderAll.get(i).getOrderStatus() %></td>
										</tr>
									</table>
							
									<hr>
								<% } %>
						<% } %>
                   </div>
                </td>
            </table>
        </div>
       
       <script>
       $(function () {

			var orderNo = ""

    	   $(".moreBtn").click(function () {
    		//    console.log(orderNo[0]);
    		//    console.log(orderNo[1]);
			orderNo = $(this).parent().parent().prev().children(".orderNo").text();
				console.log()
    		   location.href="<%= contextPath %>/orderDetail.me?orderNo=" + orderNo;
    	   });
       });
       </script>

   
       <br><br>
        <!-- bottom : 푸터바 영역 ---------------------------------------------------->
        <div class="w_ bottom">
            
            <!-- 푸터바 START-->
            <%@ include file="../common/footer.jsp" %>
            <!-- 푸터바 END-->
         
        </div>
		
	</div>
</body>
</html>