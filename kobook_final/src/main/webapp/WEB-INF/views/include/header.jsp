<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% 
	String cur_id = "0";
	
	if(session.getAttribute("person_id") != null){
		cur_id = (String)session.getAttribute("person_id")+"";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function popup(){
		
		window.name = "mainPage";
		window.open("/message/messageSend","messagePage", "width=630, height=300, menubar=yes, statebar=yes, scrollbar=yes");
	}
	
</script>
</head>
<body>
<header id="header">
        <div id="top-bar">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 top-info hidden-xs">
                        <span><i class="fa fa-phone"></i>Phone: (123) 456-7890</span>
                        <span><i class="fa fa-envelope"></i>Email: kobook@kobook.com</span>
                        <span><%= cur_id %></span>
                    </div>
                    <div class="col-sm-4 top-info">
                        <ul>
                            <li><a href="" class="my-envelope"><i class="fa fa-envelope" onclick="popup()"></i></a></li>
                            <li><a href="" class="my-facebook"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="" class="my-skype"><i class="fa fa-skype"></i></a></li>
                            <li><a href="" class="my-pint"><i class="fa fa-pinterest"></i></a></li>
                            <li><a href="" class="my-rss"><i class="fa fa-rss"></i></a></li>
                            <li><a href="" class="my-google"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="logo-bar">
            <div class="container">
                <div class="row">
                    <!-- Logo / Mobile Menu -->
                    <div  class="col-lg-3 col-sm-3 ">
                        <div id="logo">
                            <h1><a href="/kobook/index.do">KOBOOK</a></h1>
                        </div>
                    </div>
                    <!-- Navigation
    ================================================== -->
                    <div class="col-lg-9 col-sm-9">
                        <div class="navbar navbar-default navbar-static-top" role="navigation">
                            <!--  <div class="container">-->
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div class="navbar-collapse collapse">
                                <ul class="nav navbar-nav">
                                    <li ><a href="/">Home</a>
                                    </li>

                                    <li><a href="/book/bookList">전체검색</a></li>
                                    <li><a href="/book/locationAction?check=1">지역검색</a></li>

                                    <li><a href="/community/blackList" >커뮤니티</a>
                                        <ul class="dropdown-menu">
                                            <li><a href="/community/blackList">신고합니다</a></li>
                                            <li><a href="/community/donateList">무료나눔</a></li>
                                            <li><a href="/community/photoReviewList">포토리뷰</a></li>
                                            <li><a href="/admin/noti">공지사항</a></li>
                                            <li><a href="/community/qna">자주묻는질문</a></li>
                                        </ul>
                                    </li>
                                    
                                    <li><a href="/mypage/userUpdate" >마이페이지</a>
                                        <ul class="dropdown-menu">
                                            		<li><a href="/mypage/userUpdate">회원정보수정</a></li>
                                                    <li><a href="/mypage/mileage">마일리지</a></li>
                                                    <li><a href="/mypage/pickList">찜 리스트</a></li>
                                                    <li><a href="/mypage/buyList?person_id="${person_id}>구매내역</a></li>
                                                    <li><a href="/mypage/sellList?person_id="${person_id}>판매내역</a></li>
                                                    <li><a href="/mypage/reviewList">판매후기</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
</body>
</html>