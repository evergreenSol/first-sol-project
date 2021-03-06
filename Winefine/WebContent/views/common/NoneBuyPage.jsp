<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String errorMsg = (String)request.getAttribute("errorMsg"); %>

<!DOCTYPE html>
<html>
    <style>
        div{
            box-sizing: border-box;
           
        }

        .outer{
            width: 1200px;
            height: 700px;
            margin:auto;
            text-align: center;
        }

        .error{
            height:50%;
            width:100%;
            margin: 0px 0px 0px 0px;
            left:50%;
        }
        .error-{
            margin-top: 50px;
            margin-bottom: 20px;
        }

        img{
            width:320px;
            height:270px;
        }

    </style>
<head>
<meta charset="UTF-8">
<title> WINEFINE :D </title>
<!-- * 부트스트랩 영역 --------------------------------------------------------------------------->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
 <!-- menubar영역은 모든 페이지마다 넣어주기로 했으니 얘한테 한번 넣어두면 include 되는 모든페이지에서 쓸 수 있겠쥬 ! ☆  -->
</head>
<body>

<div class="outer">
    <div class="error">
        <div class="error- img">
            <img src="/winefine/resources/images/error.png">
        </div>

    </div>
    <div class="error- info">
        <div><h5>상품 구매 후 리뷰 작성이 가능합니다.<br>
<br>
                 WINEFINE 이용에 불편을 드려 대단히 죄송합니다(_ _)</h5>
        </div>
        <div><br>
            <button class="btn btn-outline-primary" onclick="goBack();">뒤로 이동</button>
            <button class="btn btn-primary" onclick="mainPage();">와인스토어로 이동</button>
        </div>
    </div>
    <script>
        function mainPage(){
            location.href="/winefine/store.th?currentPage=1"
        }

        function goBack(){
            history.back();
        }

    </script>

</div>

</body>
</html>