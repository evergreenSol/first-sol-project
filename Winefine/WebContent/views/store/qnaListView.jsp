<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.winefine.store.model.vo.Product, java.util.ArrayList, com.winefine.store.model.vo.Qna, com.winefine.common.model.vo.PageNation" %>
<!-- 수화물찾기 -->

<%
	ArrayList<Qna> qnaList = (ArrayList<Qna>)request.getAttribute("qnaList");
	PageNation pn = (PageNation)request.getAttribute("pn");
	
	// 페이징바용 변수
	int currentPage = pn.getCurrentPage();
	int startPage = pn.getStartPage();
	int endPage = pn.getEndPage();
	int maxPage = pn.getMaxPage();
%>  
<% Product p = (Product)request.getAttribute("p");%>
  
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
            margin: auto;
            width:1200px;
            height: 1500px;
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
            margin-top: 30px;
            padding: 30px 100px;
            background-color: #f3f0f0;
        }
        .pairing{
            width: 100%;
            height: 250px;
            background-color: #f3f0f0;
        }

        .body_1 a{
            font-size: 30px;  
            color:#BDBDBD;
            text-decoration: none; 
        }
        .body_1 .btn{
            border: none;
            width: 240px;
            margin-top: 0px;
            margin-left: 10px;
        }
        .list{
            width: 100%;
            height: 35px;
            font-size: 14px;
            font-weight: 600;
            text-align: center;
            border-bottom: 1px solid #BDBDBD;
        }
        .qna{
            cursor: pointer; /* 마우스를 올리면 커서가 포인터로 바뀌게끔*/
            line-height: 30px; /* 글자위치 수직정렬 > 보통 부모의 길이만큼 주면 중간정렬됨*/
        }
        table{
            /* 표 td간 간격 없게 만들기*/
            margin-bottom: 35px;
            box-sizing: border-box;
            border-collapse: collapse;
        }
        .qna + tr{
            width: 100%;
            margin: 0px;/* p태그에는 자동으로 알게모르게 위/아래 margin이 잡혀있음 */
            padding: 10px;
            display: none;
            height: 200px;
            font-size: 14px;
            border-bottom: 1px solid #BDBDBD;
        }

        /* 페이징처리 버튼 */
        .btn-no{
            display: inline-block;
            border: none;
            border-radius: 100px;
            color: #5f5f5f;
            font-size: 14px;            
            background-color: #f3f0f0;
            margin-left: 10px;
        }
        .btn-no:disabled {
            color:white;
            background-color: #6B325B;
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
 
             <!-- body2 : 함께하면 좋은 음식(페어링)-->
             <!-- <div class="w_ body_2">
                 <div class="underline">
                     <b style="font-size:20px;">&nbsp;함께하면 좋은 음식</b>
                 </div>
                 <br>
                 <div>
                     <table class="pairing">
                         <td>
                          </td>
                         <td>
 
                         </td>
                         <td>
 
                         </td>
                         <td>
 
                         </td>
                         <td>
 
                         </td>
                     </table>
                 </div>
             </div> -->
 
             <!-- body3: 상세페이지-->
             <div class="w_ body_3">
                 <div class="underline" >
                 </div><br>
 
                 <div>
                     <!-- viewDetail-navi 영역 START :  쿼리스트링 나열 '&'로 해야함 주의 ★-->
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
                    <div style="border-bottom: 1px solid #BDBDBD;">
                        <br><br><br>
                            <b style="font-size:20px;">&nbsp; Q&A</b>
                           
                           <!--  로그인한 회원만 보이는 글 작성 버튼 -->
                            	<% if(loginUser != null) {%>    
                                    <a href="<%= contextPath %>/enrollform.qn?pno=<%= p.getProductNo()%>">
                                        <input type="button" class="btn-no" value="작성하기" style="float:right">
                                    </a>
                                <% } %>
                            <br><br>
                    </div>
        
                        <!-- QnA 내용물 영역 START-->
                        <table>
                          

                            <%if(qnaList.isEmpty()) {%>
                            <tr class="list qna">
                                <td class="qnaNo" style="width: 2%;"></td>
                                <td colspan="7" style="width: 1200px;">작성된 문의글이 없습니다.</td>
                            </tr>

                            
                            <% } else {%>
                                <tr class="list">
                                    <td class="qnaNo" style="width: 2%;"></td>
                                    <td class="qnaTitle" style="width: 48%; text-align: left;">제목</td>
                                    <td class="qnaOpen" style="width: 10%;"></td>
                                    <td class="qnaDate" style="width: 10%;">작성일자</td>
                                    <td class="qnaWriter" style="width: 20%;">작성자</td>
                                    <td class="qnaCount" ></td>
                                    <td class="AnswerYN" style="width: 10%;">답변여부</td>
                                </tr>
                                <% for(Qna q : qnaList) {%>
                                <tr class="list qna"> 
                                    <td class="qnaNo" style="width: 2%;">
                                        <input id="qno" name="qno" type="hidden" value="<%=q. getQnaNo()%>"></td>   
                                    <td class="qnaTitle" style="width: 48%; text-align: left;"><%= q.getQnaTitle() %></td>
                                    <td class="qnaOpen"></td>
                                    <td class="qnaDate"><%= q.getCreateDate() %></td>
                                    <td class="qnaWriter"><%= q.getQnaWriter() %></td>
                                    <td class="qnaCount"></td>
                                    <td class="AnswerYN"><%= q.getAnswerYn() %></td>
                                </tr>
                          
                                <tr>
                                    <td class="qnaNo" style="width: 2%;"></td>
                                    <td colspan="6">
                                   
                                     
                                                <!-- 답변이 있는 경우 -->
                                                <% if(q.getAnswerYn().equals("Y")) {%>
                                                        <% if(q.getQnaPhoto() != null){%>
                                                            <br><img src="<%= q.getQnaPhoto()%>" style="width:300px; height:300px"><br><br>
                                                                <%}%>
                                                 	                    <span><%= q.getQnaContent() %><br><br><hr>
                                                  	                         └▶ WINEFINE 답변 : <%= q.getAnswer()%></span> 
                                
                                                            <!-- 답변이 없는 경우 -->
                                                <%} else {%>
                                                            <% if(q.getQnaPhoto() != null){%>
                                                           	 <br><img src="<%= q.getQnaPhoto()%>" style="width:300px; height:300px"><br><br>
                                                            <%}%>
                                                             <%= q.getQnaContent() %><hr>
                                                            <% if(loginUser!=null) {%>
                                                            <%if(loginUser.getUserId().equals("admin")){%>
                                                            └▶ 관리자 &nbsp;:&nbsp; <input id="answer" name="answer" type="text" style="width:950px; height:130px;">
                                                            &nbsp;<input type="button" id="answerBtn" class="btn btn-sm btn-secondary" value="답변달기"><br>
                                                            <%}%>
                                                            <%}%>
                        
                                                <%}%> 
                                  
                                    </td>
                                </tr>
                        <%} %>
                    <%} %>
                 </table>
                <!-- QnA 내용물 영역 END-->
                    
                                                       <!-- 페이징바 영역 START-->
                        <div align="center" class="paging-area">
                                                            
                            <!-- 현재 페이지가 1이 아니라면 : "<" 버튼 보여주기 -->
                            <% if(currentPage != 1) {%>
                                <button class="btn-no" onclick="location.href='<%=contextPath%>/qna?currentPage=<%= currentPage-1 %>';">&lt;</button>
                            <%} %>

                                <!-- 페이징바 START -->
                                <% for(int pNum = startPage; pNum <= endPage; pNum++) { %>
                                    
                                    <% if(pNum != currentPage){ %>
                                            <button class="btn-no" onclick="location.href='<%=contextPath%>/qna?currentPage=<%= pNum %>';"><%= pNum %></button>
                                    <%} else { %>
                                            <button class="btn-no" disabled><%= pNum %></button>
                                        <% } %>
                                <% } %>

                            <!-- 현재 페이지가 마지막페이지가 아니라면 : ">"" 버튼 보여주기 -->    
                            <% if(currentPage != maxPage) {%>
                                <button class="btn-no" onclick="location.href='<%=contextPath%>/qna?currentPage=<%= currentPage+1 %>';">&gt;</button>
                            <% } %>
                        </div>
                        <!-- 페이징바 영역 END-->
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

   <script>
    $(function(){
    	//관리자 답변달기 function
    	$("#answerBtn").click(function(){
    		
    		var qno = $("#qno").val();
    		var answer = $("#answer").val();
    		
    		$.ajax({
    			url : "qna.admin_insertAnswer",
    			data :  {
    				qno:qno,
    				answer:answer},
    			type : "post",
    			success: function(result){
                    if(result>0){
                        alert("답변완료");
                    } else{
                        alert("답변실패");
                    }
    			}
    		});
    		
    	});
    	
    	//qna 상세보기 function
        $(".qna").click(function(){

            // $(this) : 현재 클릭이벤트가 발생한 요소 (타겟)
            // $(this).next() : 현재 클릭이벤트가 발생한 요소 바로 다음에 나오는 요소
            //         ㄴ 동위선택자 .next(): 바로 뒤에있는 녀석 하나만 가지고 오는 메소드

            var $tr = $(this).next(); // p 요소 자체를 변수에 담아두기
            //  ㄴjQuery 방식으로 선택된 요소를 변수에 담고자 할 때에는 관례상 변수명 앞에 $를 붙이곤 합니다. (생략가능)


            // 만약에 요소가 보이지 않는다면
            if($tr.css("display") == "none"){
                // css() 메소드 또한 속성명만 매개변수로 넘기게 된다면 해당 속성값을 반환해준다.
                // => ( getter / setter 역할 동시에 가능 ) 
                
                // 일단 기존에 열려있는 후기가 있는지 > 있다면 닫아주고서 
                $(this).siblings(".qna+tr").slideUp();
                // .siblings("선택자") : 나랑 같은 항렬의 녀석들을 전부 선택("선택자"는 생략가능 > 생략시 All ) 
                
                //보여지게끔
                $tr.slideDown();
            }
            else{
                $tr.slideUp();
            }
        });
    });
</script>
</body>
</html>
