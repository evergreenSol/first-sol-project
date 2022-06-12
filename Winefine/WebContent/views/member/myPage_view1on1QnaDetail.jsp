<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.winefine.oneqna.model.vo.Oneqna" %>

<% 
	Oneqna o = (Oneqna)request.getAttribute("o");

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
		height: 1500px;
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
        height: 100%;
    }
    
    table img {
        width: 100px;
        height: 100px;
    }

	#oneQ thead th{
		border-bottom: 1px solid black;
	}

	#oneQ tbody tr:hover {
		cursor: pointer;
		color: rgb(119, 45, 96);            
	}

	button {
		background-color: rgb(119, 45, 96); ;
		color: white;
		border: none;
	}

	button:hover {
		cursor: pointer;
	}

	textarea{
		width: 100%;
		height: 80%;
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
						<b style="font-size:24px;">1대1 문의 내역</b>
			    		<hr style="border: 1px solid black">
			
						<table id="detail-area" align="center">
							<tr>
								<td width="350"><%= o.getOneqnaWriter() %></td>
								<td width="350"align="right"><%= o.getCreateDate() %></td>
							</tr>
							<tr>
								<td colspan="2"><hr></td>
							</tr> 
							<tr>
								<td colspan="2"><%= o.getOneqnaTitle() %></td>
							</tr>
							<tr>
								<td colspan="2"><hr></td>
							</tr>
							<tr>
								<td colspan="2">
								<p style="height : 200px"><%= o.getOneqnaContent() %>
									
								</p>
								</td>
							</tr>
							<tr>
								<td colspan="2"><hr></td>
							</tr>
							<tr>
								<td colspan ="2" height="200"><textarea name="answer" placeholder="답변을 입력하세요." style="resize:none;" readonly><% if(o.getAnswer() == null) { %>답변이 아직 등록되지 않았습니다.
									<% } 
									   else { %><%= o.getAnswer() %>
									<% } %>
									
								</textarea></td>
								<!-- textarea 내부 텍스트 띄어쓰기 줄바꿈 다 적용되므로 스크립틀릿 사용시에도 붙여서 쓸것 -->
									
								</p>
								</td>
							</tr>
						</table>
			
			        <!-- <table border="1">
			            <thead>
			                <tr>
			                    <th width="600">제목</th>
			                    <th width="150">작성일</th>
			                    <th width="150">답변상태</th>
			                </tr>
			            </thead>
			            <tbody>
			                <tr height="300">
			                    <td colspan="3" style="text-align: center; font-size: 18px;">작성된 문의가 없습니다.</td>          
			                </tr>
			            </tbody>
			        </table> -->
			
						<br>
						<div align="center">
							
							<a href="<%= contextPath %>/list.on" class="btn btn-secondary" style="background-color: rgb(119, 45, 96); ;
								color: white; border: none;">1대1문의</a>
						</div>

		
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
	<script>

		// function toOne() {
		// 	location.href="<%= contextPath %>/list.on";
		// } 버튼이 안먹음???


		$(function () {
			$("tbody .nn").children().click(function () {
				// console.log("클릭")
				var ono = $(this).children().eq(0).text();

				location.href="<%= contextPath %>/view1On1.me?ono=" + ono;
				// 이동이 아니라 상세로 보게끔 모달창을 띄워야하나? ... 고민
			});

			//$("button[id=1on1]").click(function () {
				//console.log("클릭됨");
				//location.href="<%= contextPath %>/list.on";
				// 고객센터의 1대1 문의 화면으로 넘겨주기.
			//});
			
		});
	</script>
</body>
</html>