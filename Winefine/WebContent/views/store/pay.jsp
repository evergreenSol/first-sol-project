<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.winefine.member.model.vo.Member" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("UTF-8");
    Member loginUser = (Member)request.getSession().getAttribute("loginUser");
    
    // user 정보 받아오기 // pay api에 필요한 정보들
    String name = loginUser.getUserName();
    String email = loginUser.getEmail();
    String phone = loginUser.getPhone();
    //System.out.println(name);
    //System.out.println(email);
    //System.out.println(phone);

    // 주문목록페이지에 필요한 정보들
    String pickup = (String)request.getAttribute("pickup"); // 수령인
	String pickupDate = (String)request.getAttribute("pickupDate"); // 수령일자 [[[Date -> String??]]]
	String locationCode = (String)request.getAttribute("locationCode"); // 수령장소
	String paymentCode = (String)request.getAttribute("paymentCode"); // 결제방법
	int totalPrice = (int)request.getAttribute("totalPrice"); // 총결제금액
    
    //System.out.println("pay.jsp : " + orderUser);
	//System.out.println("pay.jsp : " + locationName);
	//System.out.println("pay.jsp : " + orderDate);
	//System.out.println("pay.jsp : " + payment);
	//System.out.println("pay.jsp : " + totalPrice);
    
%>
<html>
<head>
<meta charset="UTF-8">
<title> WINEFINE :D </title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
	
    <!-- 다음페이지로 넘길 정보들-------------------------------------------------- -->
    <form id="present" action="/insertOrder.me" method="post">
        <input type="hidden" id="pickup" name="pickup" value="<%= pickup %>">
        <input type="hidden" id="locationCode" name="locationCode" value="<%= locationCode %>">
        <input type="hidden" id="pickupDate" name="pickupDate" value="<%= pickupDate %>">
        <input type="hidden" id="paymentCode" name="paymentCode" value="<%= paymentCode %>">
        <input type="hidden" id="totalPrice" name="totalPrice" value="<%= totalPrice %>">
    </form>

    <script>
        $(function(){
            $("#present").submit(function(){
                var pickup = $("#pickup").val();
                var locationName = $("#locationName").val();
                var orderDate = $("#orderDate").val();
                var payment = $("#payment").val();
                var totalPrice = $("#totalPrice").val();
                //var name = $("#name").val();
                //$("#inputData").append('<p>' + '이름: '+ name + '</p>');
                //var email = $("#email").val();
                //$("#inputData").append('<p>' + '이메일: ' + email + '</p>');
                return false; // false는 왜 리턴해주는가???????????????????????????????????????????
            }); // end submit()
        }); // end ready()
    </script>
    <!---------------------------------------------------------------------------->


	<script>
    $(function(){
        var IMP = window.IMP; // 생략가능
        IMP.init('imp54187810'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid : 'wine_' + new Date().getTime(),
            name : 'WINE FINE',
            amount : <%=totalPrice%>, 
            buyer_email : '<%=email%>',
            buyer_name : '<%=name%>',
            buyer_tel : '<%=phone%>'
            //buyer_postcode : '123-456',
            //m_redirect_url : 'http://www.naver.com'
        }, function(rsp) {
            if ( rsp.success ) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                jQuery.ajax({
                    url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid
                        //기타 필요한 데이터가 있으면 추가 전달
                    }
                }).done(function(data) {
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                    if ( everythings_fine ) {
                        msg = '결제가 완료되었습니다.';
                        msg += '\n고유ID : ' + rsp.imp_uid;
                        msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                        msg += '\결제 금액 : ' + rsp.paid_amount;
                        msg += '카드 승인번호 : ' + rsp.apply_num;
                        
                        alert(msg);
                    } else {
                        //[3] 아직 제대로 결제가 되지 않았습니다.
                        //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                    }
                });
                //성공시 이동할 페이지 => 마이페이지의 주문내역으로 // 서블릿
                location.href="/winefine/insertOrder.me?pickup=<%= pickup %>&pickupDate=<%= pickupDate %>&locationCode=<%= locationCode %>&paymentCode=<%= paymentCode %>";
                
                // 구매한 장바구니의 제품 삭제 
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~ payThenDelete.ca 서블릿 만들어서 지울것
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지 sendredirect 사용해보자
                location.href="/winefine/list.ca";
                alert(msg);
            }
        });
        
    });
    </script>

</body>
</html>