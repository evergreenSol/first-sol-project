<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList, com.winefine.store.model.vo.Review, com.winefine.common.model.vo.PageNation" %>
<!-- 수화물찾기 -->
<%
    ArrayList<Review> reviewList = (ArrayList<Review>)request.getAttribute("reviewList");
    PageNation pn = (PageNation)request.getAttribute("pn");

    // 페이징바용 변수
    int currentPage = pn.getCurrentPage();
    int startPage = pn.getStartPage();
    int endPage = pn.getEndPage();
    int maxPage = pn.getMaxPage();
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
                box-sizing: border-box;
            }
            .wrap{
                width: 1200px; 
                height: 1000px; 
                margin: auto;
            }
            .w_{
                width: 100%;
            }
            .top{
                height: 240px; /* height: 240px */
            }
            .body{
                height: 660px; /* height: 660px */
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
            /* 상세페이지 */
            .detailTable{
                width: 80%;
                height: 90%;
                margin: 50px 120px;
            }
            .menuTitle, .menuTitle>a{
                color: lightgray;
                font-size: 22px;
                font-weight: 600;
            }
            .menuTitle>a:hover{
                color: black;
                cursor: pointer;
            }
            .tableTitle{
                width: 18%;
                font-size: 20px;
                font-weight: 500;
                text-align: center;
            }
            textarea{
                width: 100%;
                height: 80%;
            }
            /* 상품후기 */
            .reviewTable{
                width: 1100px;
                margin: 20px 30px;
                border-collapse: collapse;
                text-align: center;
            }
            .checkPeriod{
                height: 60px;
                padding: 20px;
            }
            .reviewTable th{
                background-color: #e1e0e0;
            }
            .reviewTable tr{
                height: 40px;
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
                background-color: rgb(0, 0, 57);
            }
            /* tr 호버 */
            .reviewList:hover{
                color: rgb(37, 122, 192);
                cursor: pointer;
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
                                <td style="width:480px; font-size: 22px; font-weight: 600">상품후기</td>
                                <td colspan="2" style="width: 720px;" align="right">

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
            
                <!-- 조회기간 영역 START-->
                <div class="checkPeriod" align="right">
                    기간설정 : 
                    <input id="startDate" name="startDate" type="date"> ~ 
                    <input id="endDate" name="endDate" type="date">
                    <button id="checkDate" class="btn btn-secondary btn-sm">조회하기</button>
                </div>
                <!-- 조회기간 영역 END-->
                

                <!-- 후기 리스트 테이블 START-->
                <table class="reviewTable" align="center;">
                    <thead>
                        <tr>
                            <th class="pName">상품명</th>
                            <th class="oNo">주문번호</th>
                            <th class="rTitle" style="width:30%;">리뷰제목</th>
                            <th class="writer" style="width:15%;">작성자</th>
                            <th class="rCount" style="width:5%;">조회수</th>
                            <th class="rDate" style="width:12%;">작성일</th>
                            <th class="answerYn" style="width:8%;">답변여부</th>
                        </tr>
                    </thead>    

                    <tbody>
                        <%if(reviewList.isEmpty()) {%>
                            <tr>
                                <td class="null" colspan="8">작성된 후기가 없습니다.</td>
                            </tr>
                            <% } else {%>
                            <% for(Review r : reviewList) { %>
                                <tr class="reviewList" data-toggle="modal" data-target="#reviewModal">
                                    <td class="pName_date"><%=r.getProductNo()%></td>
                                    <td class="oNo_date"><%=r.getOrderNo()%></td>
                                    <td class="rTitle_date"><%=r.getReviewTitle()%></td>
                                    <td class="writer_date"><%=r.getReviewWriter()%></td>
                                    <td class="rCount_date"><%=r.getCount()%></td>
                                    <td class="rDate_date"><%=r.getCreateDate()%></td>
                                    
                                    <!-- 리스트에서는 안보이다가 모달에서만 보이게끔 display:none;-->
                                    <td class="rNo_date" style="display: none;"><%=r.getReviewNo()%></td>
                                    <td class="rContent_date" style="display: none;"><%=r.getReviewContent()%></td>
                                    <td class="answerYn_date"><%=r.getAnswerYn()%></td>
                                    <!-- 리스트에서는 안보이다가 모달에서만 보이게끔 display:none;-->
                                    <td class="answer_date" style="display: none;"><%=r.getAnswer()%></td>
                                </tr>
                            <%} %>
                        <%} %>
                    </tbody>  
                </table>
                <!-- 후기 리스트 테이블 END-->
                
                <!-- The Modal -->
                <div class="modal fade" id="reviewModal"> <!-- 여기는 모달 바깥 배경화면 영역-->
                    <div class="modal-dialog modal-lg" style="margin-top: 160px;">
                    <div class="modal-content" style="height: 500px;">
                    
                            <form action="review.admin_do" method="post">
                                <!-- Modal body -->
                                <div class="modal-body" style="height: 250px;">
                                    <input type="hidden" id="rno" name="rno">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <b> Product. <label id="l1"></label> </b> &nbsp;&nbsp;/ &nbsp; 주문번호 : <label id="l2"></label>
                                     
                                            <!-- 공개/비공개 처리 드롭다운-->
                                            <select name="reviewOpen" style="float: right; margin-right: 20px;">
                                                <option value="Y">공개</option> 
                                                <option value="N">비공개</option>   
                                            </select><br clear="both">

                                    후기번호 : <label id="l7"></label> < 제목 : <label id="l3"></label> > <br>
                                    작성자 : <label id="l4"></label> &nbsp;&nbsp;/ &nbsp;
                                    <!-- 여기만 회색-->
                                    <span style="color: grey;">
                                    조회수 : <label id="l5"></label> &nbsp;&nbsp;/ &nbsp;
                                    작성일 : <label id="l6"></label><br>
                                    </span>
                                    내용: <label id="l8"></label><br> 
                                    
                                </div>
                            
                                <!-- Modal footer -->
                                <div class="modal-footer" style="height: 250px;">
                                    <!-- 답변확인란-->
                                    <span style="width: 100%;">
                                    답변여부 : <label id="l9"></label><br>
                                    답변 : <label id="l10"></label><br>
                                    </span>
                                    <!-- 답변입력란 -->
                                    <textarea name="reviewAnswer" cols="5" style="height:100px; resize: none;"></textarea>
                                    <button type="submit" style="background-color:rgb(23, 108, 164); color: white;" class="btn btn-sm">답변달기</button>

                                    
                                </div>
                            
                            </form>
                    </div>
                    </div>
                </div>
                <!-- 후기 모달 영역 END-->
    
          </div>
        </div>
      </div>
                
                <br><br>
                
                <!-- 페이징바 영역 -->
                <div align="center" class="paging-area">
                                                            
                    <!-- '<' 표시를 태그로 잘못 인식할수 있으니 &lt; &gt;으로 대체-->
                    <% if(currentPage != 1) {%>
                        <button class="btn-no" onclick="location.href='<%=contextPath%>/review?currentPage=<%= currentPage-1 %>';">&lt;</button>
                    <%} %>

                        <% for(int pNum = startPage; pNum <= endPage; pNum++) { %>
                            <% if(pNum != currentPage){ %>
                                    <button class="btn-no" onclick="location.href='<%=contextPath%>/review?currentPage=<%= pNum %>';"><%= pNum %></button>
                            <%} else { %>
                                    <button class="btn-no" disabled><%= pNum %></button>
                                <% } %>
                        <% } %>
                        
                    <% if(currentPage != maxPage) {%>
                        <button class="btn-no" onclick="location.href='<%=contextPath%>/review?currentPage=<%= currentPage+1 %>';">&gt;</button>
                    <% } %>
                </div>
                <!-- 페이징바 내용물 영역 END-->
              	
           </div>

           <!-- bottom : 하단 영역 --------------------------------------->
           <div class="w_ bottom" align="center">
           		<!-- 버튼영역 생략 -->
           </div>
       
       </div> 

       <script>
     
       $(function(){
            $("#checkDate").click(function(){
                
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	
            	var startArray = startDate.split('-');
            	var endArray = endDate.split('-');
            	
            	var start_date = new Date(startArray[0],startArray[1],startArray[2]);
            	var end_date = new Date(endArray[0],endArray[1],endArray[2]);
            	
            	if(start_date.getTime() > end_date.getTime()){
            		alert("종료날짜보다 시작날짜가 작아야합니다.");
            	}
            	
            	else{
	                $.ajax({
	                        url : "review.admin_date",
	                        data : {
	                            startDate:startDate, 
	                            endDate:endDate,
	                            currentPage:1},
	                        type : "post",
	                        success : function(reviewListDate){
	                        	if(reviewListDate!=""){
			                      for (var i = 0; i<reviewListDate.length; i++){
					                        		$(".pName_date").html(reviewListDate[i].productNo);
					                        		$(".oNo_date").html(reviewListDate[i].orderNo);
					                        		$(".rTitle_date").html(reviewListDate[i].reviewTitle);
					                        		$(".writer_date").html(reviewListDate[i].reviewWriter);
					                        		$(".rCount_date").html(reviewListDate[i].count);
					                        		$(".rDate_date").html(reviewListDate[i].createDate);
					                        		$(".rNo_date").html(reviewListDate[i].reviewNo);
					                        		$(".rContent_date").html(reviewListDate[i].reviewContent);
					                        		$(".answerYn_date").html(reviewListDate[i].answerYn);
					                        		$(".answer_date").html(reivewListDate[i].asnwer);
					                        
			                      }
	                        	} else{
	                        		alert("기간 내 작성된 리뷰가 없습니다. 다시 입력해주세요.");
	                        	}
	                        }
	                
	                 });
            	}
            });

                // 후기리스트 요소 뽑아서 모달에 넣어주기 
                $(".reviewList").click(function(){
                    $.each($(this).children(), function(index, value){

                        // index : 순차적으로 접근할 때마다의 인덱스 수 
                        // value : 접근할 때마다의 값(td)
                        console.log("인덱스 : " + index + ", 요소 : " + value);

                        $("#l" + (index + 1)).text($(value).text());

                        var rno = $("#l7").text();
                        $("#rno").val(rno);
                    });
                });
        });
        </script>
    </body>
    </html>