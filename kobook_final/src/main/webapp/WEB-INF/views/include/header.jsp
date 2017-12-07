<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% 
	String cur_id = "-1";
	
	if(session.getAttribute("person_id") != null){
		cur_id = (String)session.getAttribute("person_id")+"";
		
	}
	
	int person_id = Integer.parseInt(cur_id);
	request.setAttribute("person_id", person_id);
			
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>
  
<script type="text/javascript">

	$(function(){
		$.getJSON('/alarmCount',function(data){
			$("#alarm_new").html(data);
		})
	});

	function popupMessage(){
		
		if(<%=person_id%> >  0){
		
			window.name = "mainPage";
			window.open("/message/messageSend","messagePage", "width=630, height=300, menubar=yes, statebar=yes, scrollbar=yes");
	 		
			document.session_id.action = "/message/messageSend";
			document.session_id.target = "messagePage";
			document.session_id.submit;
		
		} else alert("로그인이 필요합니다");
		
	}
	
	function popupChat(){
		
		window.name = "mainPage";
		window.open("/chatbot/chatbot","chatbotPage", "width=560, height=620, menubar=yes, statebar=yes, scrollbar=yes, left=600");
 		
		if(<%=person_id%> > 0){
			document.session_id.action = "/chatbot/chatbot";
			document.session_id.target = "chatbotPage";
			document.session_id.submit;	
		}
		
	}
	
	function fn_newAlarm() {		
		window.open("/alarmList","","width=500,height=300,left=550,top=200");

	}
	
	function fn_login(){
		window.open("/person/login","","width=400,height=300,left=550,top=200");
	}
	
	function fn_logout(){
		location.href="/person/logout";
	}
	
</script>
<script type="text/javascript">
//sidebar 관련 script
	$(function(){
			$.ajax({
				url:'/include/todayDonateViewList',
				dataType:"json",
				success:function(list){
					$.each(list, function(index) {
						$("#today-list").append(
								"<li class='viewList' data-rno='"+this.TODAY_ID+"'><img alt='NO IMAGE' src='/community/displayFile?fileName="+this.DONATE_THUMBNAIL
										+"' width='80px' height='50px'><br>"
										+"<a href='/community/donateRead?donate_id="+this.DONATE_ID+"'>"
										+"<b>"+this.DONATE_TITLE+"</b><br>"+"</a><small>무료 나눔 게시판</small></li>")
					});
				}
			});
			
			$.ajax({
				url:'/include/todayBookViewList',
				dataType:"json",
				success:function(list){
					$.each(list, function(index) {
						$("#today-list").append(
								"<li class='viewList' data-rno='"+this.TODAY_ID+"'><img alt='NO IMAGE' src='/book/displayFile?fileName="+this.BOOK_IMG
										+"' width='80px' height='50px'><br>"
										+"<a href='/book/bookRead?book_id="+this.BOOK_ID+"'>"
										+"<b>" +this.BOOK_NAME+"</b><br>"+"</a><small>도서</small></li>");
					});
				}
			});
			
			$("#today-list").on("mouseenter",".viewList",function(event){
				event.preventDefault();
				$(this).before("<button type='button' class='today-btn'>x</button>");
			});
			
			$("#today-list").on("mouseleave",".viewList",function(event){
				event.preventDefault();
				$(this).parent().find("button").remove();
			});
			
			$(document).on("click", ".today-btn", function(event) {
				event.preventDefault();
				var that = $(this).parent();
				var today_id = $(this).parent().attr("data-rno");
 				
				$.ajax({
					url:'/include/todayRemove/'+today_id,
					dataType: 'text',
					success : function(data) {
						if( data == "success"){
							that.remove();
						}						
					}
				});
			});
	});

 var stmnLEFT = 6; // 오른쪽 여백 
 var stmnGAP1 = 0; // 위쪽 여백 
 var stmnGAP2 = 270; // 스크롤시 브라우저 위쪽과 떨어지는 거리 
 var stmnBASE = 270; // 스크롤 시작위치 
 var stmnActivateSpeed = 5; //스크롤을 인식하는 딜레이 (숫자가 클수록 느리게 인식)
 var stmnScrollSpeed = 5; //스크롤 속도 (클수록 느림)
 var stmnTimer; 
 
 function RefreshStaticMenu() {
	 var stmnStartPoint, stmnEndPoint;
	 stmnStartPoint = parseInt(document.getElementById('STATICMENU').style.top, 10);
	 stmnEndPoint = Math.max(document.documentElement.scrollTop, document.body.scrollTop) + stmnGAP2;
	 
	 if (stmnEndPoint < stmnGAP1) {
		 stmnEndPoint = stmnGAP1;
	 }
	 
	 if (stmnStartPoint != stmnEndPoint) {
		 stmnScrollAmount = Math.ceil( Math.abs( stmnEndPoint - stmnStartPoint ) / 15 );
		 
		 document.getElementById('STATICMENU').style.top =
			 parseInt(document.getElementById('STATICMENU').style.top, 10)
			 + ( ( stmnEndPoint<stmnStartPoint ) ? -stmnScrollAmount : stmnScrollAmount )
			 + 'px';
		 
		 stmnRefreshTimer = stmnScrollSpeed;
	 }
	 
	 stmnTimer = setTimeout("RefreshStaticMenu();", stmnActivateSpeed);
	 
 }
 
 function InitializeStaticMenu() {
	 document.getElementById('STATICMENU').style.right = stmnLEFT + 'px';  //처음에 오른쪽에 위치
	 document.getElementById('STATICMENU').style.top = document.body.scrollTop + stmnBASE + 'px';
	 
	 RefreshStaticMenu();
	
 }

</script>

<style type="text/css">
	#STATICMENU { 
		margin: 0pt;
		padding: 0pt;
		position: absolute;
		right: 0px;
		top: 0px;
		z-index: 3000;
	}
	
	#today-list {
		background-color:white;
		z-index: 2900;
	}
	
	.viewList {
		background-color:white;
		z-index: 2900;
	}
	
</style>


</head>
<body onload="InitializeStaticMenu();">
	<c:if test="${person_email != null }">
    	<div id="STATICMENU" class="col-sm-1 col-md-1 col-lg-1">
    		<div class="sidebar">
				<div class="widget widget_tab">
					<div class="velocity-tab sidebar-tab">
    					<ul class="nav nav-tabs">
                        	<li class="active"><a href="#Recent"> 오늘 본 상품 </a></li>
                        </ul>
                        <div class="tab-pane active in" id="Recent">
                        	<ul class="recent_tab_list" id="today-list">
		    				</ul>
		    			</div>
    				</div>
    			</div>
    		</div>
    	</div>
    </c:if>

	<header id="header">
		
		<!-- 팝업창으로 session값을 post로 보내는 과정 -->
		<form method="post" name="session_id">
			<input type="hidden" name="person_id" value="<%=person_id %>">
		</form>
        <div id="top-bar">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 top-info hidden-xs">
                        <span><i class="fa fa-phone"></i>Phone: (123) 456-7890</span>
                        <span><i class="fa fa-envelope"></i>Email: kobook@kobook.com</span>
                    </div>
                    <div class="col-sm-4 top-info">
                        <ul>
                            <li><a href="" class="my-envelope"><i class="fa fa-envelope" onclick="popupMessage()"></i></a></li>
                            <li><a href="" class="my-comment"><i class="fa fa-comment" onclick="popupChat()"></i></a></li>
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
	                        <c:choose>
	                        	<c:when test="${(person_id == 1) || (person_id == -1)}">
                        			<h1><a href="/main">KOBOOK</a></h1>
                        		</c:when>
                        		<c:otherwise>
                        		 <h1><a href="/recom">KOBOOK</a></h1>
                        		</c:otherwise>
	                        </c:choose>
                        </div>
                    </div>
                    <!-- Navigation
    ================================================== -->
    
            
                    <div class="col-lg-9 col-sm-9">
                    	<div class="navbar navbar-default navbar-static-top" role="navigation">
                            <!--  <div class="container">-->
                            
                            <div style="margin-left: 400px; font-size: small;">
        						
        						<c:if test="${person_email == null }">
									<a href="#" onclick="fn_login()">로그인</a>
								</c:if>	
							</div>
							
							<div style="margin-left: 80px;">
								<c:if test="${person_email != null }">
									<span> ${person_name }님 로그인중 
										<a href="#" onclick="fn_newAlarm()">새로온 알림  [ </a> 
										<a href="#" id="alarm_new"></a> 
										<a href="#"> ]</a> 
										<a href="#" onclick="fn_logout()"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 로그아웃</a>
									</span> 
									<form action="/alarmUpdate" method="post" name="alarmUpdate"></form>
								</c:if>
							</div>

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
                                	<c:choose>
                                		<c:when test="${(person_id == 1) || (person_id == '-1')}">
	                        		 		<li><a href="/main">Home</a></li>
	                        			</c:when>
			                        	<c:otherwise>
			                        		 <li><a href="/recom">Home</a></li>
			                        	</c:otherwise>
                                	</c:choose>
	                                	
                                    <li><a href="/book/bookList">전체검색</a></li>
                                    <li><a href="/book/booklocationList">지역검색</a></li>

                                    <li><a href="/community/blackList" >커뮤니티</a>
                                        <ul class="dropdown-menu">
                                            <li><a href="/community/blackList">신고합니다</a></li>
                                            <li><a href="/community/donateList">무료나눔</a></li>
                                            <li><a href="/community/photoReviewList">포토리뷰</a></li>
                                            <li><a href="/board/boardList">공지사항</a></li>
                                            <li><a href="/community/qna">자주묻는질문</a></li>
                                        </ul>
                                    </li>
                                    
                                    <c:if test="${person_email == null }">
	                                    <li class="hidden"><a href="/mypage/userUpdate" >마이페이지</a>
	                                        <ul class="dropdown-menu">
	                                        	<li><a href="/mypage/userUpdate">회원정보수정</a></li>
	                                        	<li><a href="/mypage/mileageList">마일리지</a></li>
	                                        	<li><a href="/mypage/pickList">찜 리스트</a></li>
	                                        	<li><a href="/mypage/buyList">구매내역</a></li>
	                                        	<li><a href="/mypage/sellList">판매내역</a></li>
	                                        	<li><a href="/mypage/messageBox">쪽지보관함</a></li>
	                                        </ul>
	                                    </li>
                                    </c:if>
                                    <c:if test="${person_email != null }">
	                                    <li><a href="/mypage/userUpdate" >마이페이지</a>
	                                        <ul class="dropdown-menu">
	                                        	<li><a href="/mypage/userUpdate">회원정보수정</a></li>
	                                        	<li><a href="/mypage/mileageList">마일리지</a></li>
	                                        	<li><a href="/mypage/pickList">찜 리스트</a></li>
	                                        	<li><a href="/mypage/buyList">구매내역</a></li>
	                                        	<li><a href="/mypage/sellList">판매내역</a></li>
	                                        	<li><a href="/mypage/messageBox">쪽지보관함</a></li>
	                                        </ul>
	                                    </li>
                                    </c:if>
                                    
                                    
                                    
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