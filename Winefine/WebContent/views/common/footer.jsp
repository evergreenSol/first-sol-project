<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> WINEFINE :D </title>
    <style>
        /* 가이드라인*/
        div,table{
            box-sizing: border-box;
        }
        body, p{
            margin: 0;
        }
        
        /* 구조잡기*/
        .bottom{
            width: 1200px;
            /* 전체 height 1500px의 20%로 가정*/
            height: 300px;
            margin:auto;
            /* position: absolute; */
        }
        .footer1, .footer3{
            width: 1200px;
            height: 15%;
        }
        .footer2{
            width: 1200px;
            height: 70%;
        }
        .left, .right{
            width: 25%;
            vertical-align: middle;
        }
        .center{
            width:50%;
        }
        #table{
            width: 100%;
            height: 100%;
        }

        /* 세부 사항 */
        .footer{
            background-color: #333;
            border-bottom: 1px solid gray;
            text-align: center;
        }
        .table{
            color:grey;
        }
        .footer1{
            font-weight: 600;
        }
        .footer1, .footer3{
            line-height: 40px;
        }
        .text{
            color:white;
        }
        a{
            color: white;
            text-decoration: none;
        }
        a:hover{
            color: gray;
            text-decoration: none;
        }
        #logo{
            color: #6B325B;
        }
        .center, #copyright{
            font-size: 80%;
        }

        /* 잡기술 */
        .bottom .hidden_info {
        position: relative;
        }

        .bottom .hidden_info {
            display: block;
        }

        .bottom .hidden_info .hidden_info_close {
            width: 100px;
            margin-left: -50px;
            border: none;
        }

        .bottom .hidden_info .hidden_info_close {
            position: absolute;
            height: 30px;
            top: -30px;
            left: 50%;
            line-height: 30px;
            background: #333 url("/winefine/resources/images/btn_hidden_info_close.png") no-repeat 50%;
            border-radius: 5px 5px 0 0;
            overflow: hidden;
            text-indent: -9999px;
        }

        #copyright:hover {
            cursor: pointer;
        } 

    </style>
</head>

<body>

    <!-- 모든페이지 > bottom 영역에 들어갈 푸터바         -->
    <!-- 참고) 푸터바 영역은 전체 height:1500px의 20% 할당-->
    <div class="bottom">
        <br><br>
        <div class="hidden_info">
            <button type="button" class="hidden_info_close" onclick="footClose();"></button>

            <div class="footer footer1">
                <span class="text"><a href="/winefine/prepare.do">브랜드소개</a> &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp; </span>
                <span class="text"><a href="/winefine/list.co">오시는 길</a> &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp; </span>  
                <span class="text"><a href="/winefine/prepare.do">이용약관</a> &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp; </span> 
                <span class="text"><a href="/winefine/prepare.do">개인정보취급방침</a> &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp; </span> 
                <span class="text"><a href="/winefine/list.no">고객센터</a> </span> 
            </div>
    
            <div class="footer footer2">
                <table id="table">
                    <td class="left">
                        <h1 id="logo">WINEFINE</h1>
                    </td>
                    <td class="table center">
                        (주)와인파인 대표자: WINEFINE<br>
                        사업자등록번호: [KH-452-02-00843] 통신판매업자신고번호: 제2022-서울 영등포 - NO4호<br>
                        대표번호: KH-1640-5091 주소: 서울특별시 영등포구 선유동2로 57 이레빌딩 19F, 20F<br>
                        개인정보관리자: KH(khlove@iei.co.kr)<br>
                        대표메일 winefine@iei.co.kr 사이트명: 와인파인<br>
                        <br>
                        Bank Accounts : KH은행 027-142321-01-004 주식회사 와인파인<br>
                        CS Center : 1661-5091 AM 10:00 ~ PM 6:00<br>
                        (점심시간 PM 1:00~ 2:00) ( WEEKEND/HOLIDAY OFF )<br>
                    </td>
                    <td class="table right">
                        <h5>고객센터 운영시간</h5>
                        평일 10:00 - 18:00<br>
                        점심시간 13:00 - 14:00<br>
                        주말 및 공휴일 휴무
                    </td>
                </table>
            </div>
        </div>
            
        <div class="footer footer3" id="copy" >
            <p id ="copyright" class="text" onclick="footOpen();">Copyright © 2022 WINEFINE Information All Right Reserved</p>
        </div>
    </div>

    <script>

        function footClose() {

            // $(".hidden_info").css("display", "none");
            $(".hidden_info").css("visibility", "hidden");
            // $(".hidden_info").hide();
        }
        
        function footOpen() {
            // $(".hidden_info").css("display", "block");
            $(".hidden_info").css("visibility", "visible");
            // $(".hidden_info").show();
        }

        $(function() {

        });
        
    </script>
</body>
</html>