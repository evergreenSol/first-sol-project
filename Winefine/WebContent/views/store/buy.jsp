<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
    String totalPrice = request.getParameter("totalPrice");
    //System.out.println(totalPrice);
    
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
        height: 70%;
        width: 1100px;
        margin: auto;
    }
    .bottom{
        height: 20%;
    }
    /**************************************************/

    #buybtn{
        background-color: rgb(107, 50, 91);
        color: white;
        font-size: medium;
        border-radius: 5px;
        border: none;
        width: 130px;
        height: 30px;
    }
    table, td, th {
        border : 1px solid black;
        border-collapse : collapse;
        text-align: center;
    };
    

    #content {
        height: auto;
    }

    #content>div {
        height : 100%;
        float : left;
        padding-left: 20px;
        padding-right: 20px;
    }

    #content_1 {
        width : 50%;
    }
    #content_1>table{
        width: 100%;
    }
    #content_1 input{
        border: none;
        text-align: center;
    }
    #content_1 th{
        background-color: lightgray;
    }

    #content_2 {
        width : 50%;
    }
    #content_2>table{
        width: 100%;
    }
    #content_2 th{
        background-color: lightgray;
    }
    option{
        text-align: center;
    }

    #content_3{
        width: 100%;
    }
    #content_3>table{
        width: 100%;
    }
    #content_3 th{
        background-color: lightgray;
    }
    
    .hidden{
        display: none;
    }

    #content_4{
        width: 100%;
        text-align: right;
        padding-top: 20px;
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
		
        <!-- DataPicker -->
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
        <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

        <script>
            $(function () {
                $("#datepicker").datepicker({ dateFormat: "yy-mm-dd", minDate:0 });
            });
        </script>

        <script>
            $.datepicker.setDefaults({
                dateFormat: 'yy-mm-dd',
                prevText: '이전 달',
                nextText: '다음 달',
                monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
                monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
                dayNames: ['일', '월', '화', '수', '목', '금', '토'],
                dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
                dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
                showMonthAfterYear: true,
                yearSuffix: '년'
            });

            
        </script>
        <!-- DataPicker -->

		<!-- body : 카테고리 페이지 바디 영역 --------------------------------------------->
        <br><br><br><br>
        <form id="buyForm" action="<%= contextPath %>/buyToPay.st" method="post">
	        <div class="w_ body">
	            <div id="content">
	                
	                <h2>구매 / 결제</h2>
	                <hr>
	
	                <div id="content_1">
	                    
	                    <h2>구매자 정보</h2>
	                    
	                    <table>
	                        <tr>
	                            <th>이름</th>
	                            <td><input type="text" value="<%= loginUser.getUserName() %>" readonly></td>
	                        </tr>
	                        <tr>
	                            <th>연락처</th>
	                            <td><input type="text" value="<%= loginUser.getPhone() %>" readonly></td>
	                        </tr>
	                    </table>
	
	                </div>
				
				
                	<div id="content_2">
	                    <h2>픽업 정보</h2>
	                    <table>
	                        <tr>
	                            <th>수령일자</th>
	                            
	                            <td style="width: auto;">
	                                <!--
	                                <img src="https://previews.123rf.com/images/photoplotnikov/photoplotnikov1510/photoplotnikov151000051/46960190-%ED%8F%89%EB%A9%B4-%EB%94%94%EC%9E%90%EC%9D%B8-%EC%8A%A4%ED%83%80%EC%9D%BC%EC%9D%98-%EB%8B%AC%EB%A0%A5-%EC%95%84%EC%9D%B4%EC%BD%98-%EB%B2%A1%ED%84%B0-%EC%9D%BC%EB%9F%AC%EC%8A%A4%ED%8A%B8-%EB%A0%88%EC%9D%B4%EC%85%98.jpg" style="width: 30px;">
	                                <input type="text" class="icon" id="datepicker" style="box-sizing: border-box; border: none; width: 80px;">
	                                -->       
	                                
	                                <label for="datepicker" >
	                                    <img src="https://previews.123rf.com/images/photoplotnikov/photoplotnikov1510/photoplotnikov151000051/46960190-%ED%8F%89%EB%A9%B4-%EB%94%94%EC%9E%90%EC%9D%B8-%EC%8A%A4%ED%83%80%EC%9D%BC%EC%9D%98-%EB%8B%AC%EB%A0%A5-%EC%95%84%EC%9D%B4%EC%BD%98-%EB%B2%A1%ED%84%B0-%EC%9D%BC%EB%9F%AC%EC%8A%A4%ED%8A%B8-%EB%A0%88%EC%9D%B4%EC%85%98.jpg" style="width: 40px;">
	                                </label>
	                                <input name="pickupDate" required type="text" class="icon" id="datepicker" style="box-sizing: border-box; border: none; width: 120px; height: 100%;">
	                                
	
	                            </td>
	                        </tr>
	
	                        <tr>
	                            <th>수령장소</th>
	                            <td>
	                                <!-- pay.jsp로 넘길 서블릿 buyToPay.ca
	                                수령인 수령장소 수령일자 결제방법 totlaPrice -->
	                                <select name="locationCode" style="height: 100%;" class="form-control" id="loc" >
	                                    <option value="1">당산</option>
	                                    <option value="2">종로</option>
	                                    <option value="3">강남</option>
	                                </select>
	                                
	                            </td>
	                        </tr>
	
	                        <tr>
	                            <th>수령인</th>
	                            <td>
	                                <input name="pickup" required type="text" placeholder="수령인 성함을 입력하세요" style="border: none;" align="center" required;>
	                            </td>
	                        </tr>
	                    </table>
	                </div>
	
	
	                <div id="content_3">
	                    <h2>결제 정보</h2>
	                    <table >
	                        <tr>
	                            <th>총상품가격</th>
	                            
	                            <td>
	                                <input name="totalPrice" value="<%= totalPrice %>" style="border:none; font-weight: 900; text-align: center; width:100px;" readonly>
	                                ₩
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>결제방법</th>
	                            <td>
	                                <!-- 카카오페이 선택후 구매하기 버튼 누를시 결제api로 연결 ( buy.jsp -> buyToPay.java-> pay.jsp -->
	                                <input type="radio" name="paymentCode" value="1" id="kakaopay" checked><label for="kakaopay">카카오페이</label>
	                                <!-- 햔장결제 선택후 구매하기 버튼 누를시 주문내역 페이지로 연결 ( buy.jsp -> buyToPay.java -> 주문내역페이지) -->
	                                <input type="radio" name="paymentCode" value="2" id="cash"><label for="cash">현장결제</label>
									
	
	                            </td>
	                        </tr>
	                    </table>
	                </div>
	                
	                <div id="content_4">
	                	<!--  -->
	                    <button id="buybtn" type="submit"> 구매하기 </button>
	                </div>
				
				
            	</div>

       		</div>
   		</form>
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