<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	int alarm_new=0;
%>

<% 
	String cur_id = "-1";
	
	if(session.getAttribute("person_id") != null){
		cur_id = (String)session.getAttribute("person_id")+"";
		
	}
	
	int person_id = Integer.parseInt(cur_id);
			
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

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
		window.open("/chatbot/chatbot","chatbotPage", "width=400, height=650, menubar=yes, statebar=yes, scrollbar=yes, left=800");
 		
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
</head>
<body>
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
                            <h1><a href="/kobook/index.do">KOBOOK</a></h1>
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
									
									<span>
									${person_email }님 로그인중 
										<c:forEach var="z" items="${alarmList }">
	    									<c:if test="${z.hit_yn == 'N' }">
	             								<% alarm_new += 1;%>
	        								</c:if> 
	    								</c:forEach>
										<a href="#" onclick="fn_newAlarm()">새로온 알림  [ <%=alarm_new %> ]</a> 
										<a href="#" onclick="fn_logout()"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 로그아웃</a>
  											<form action="/alarmUpdate" method="post" name="alarmUpdate"></form>
									</span> 
								</c:if>
							</div>
        					
        						

								<%-- <a href="#" onclick="fn_logout()">로그아웃</a>
								
								<c:choose>
									<c:when test="${person_email == 0}">
										<h4>관리자 로그인</h4>
										<form action="/kobook/admin/listUser.do">
            					  			<input type="hidden" name="person_id" value="${person_id }">
											<input type="submit" value="회원관리이동">
										</form>
									</c:when>
									<c:otherwise>
										<h4>${person_email }님  환영합니다앙~^0^</h4> 
											     <c:forEach var="z" items="${alarmList }">
	    											<c:if test="${z.hit_yn == 'N' }">
	             											<% alarm_new += 1;%>
	        										</c:if> 
	    										</c:forEach>
        								<h4>새로운 알람의 갯수 : [ <%=alarm_new %> ]</h4>
            					  		<form action="/kobook/recom/alarmListAction.do">
            					  			<input type="hidden" name="person_id" value="${person_id }">
											<input type="submit" value="알림">
										</form> 
									</c:otherwise>
								</c:choose>
								</c:if> --%>
        					
        					
        					
                            
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
                                    <li><a href="/">Home</a></li>

                                    <li><a href="/book/bookList">전체검색</a></li>
                                    <li><a href="/book/booklocationList">지역검색</a></li>

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
                                                    <li><a href="/mypage/mileageList">마일리지</a></li>
                                                    <li><a href="/mypage/pickList">찜 리스트</a></li>
                                                    <li><a href="/mypage/buyList">구매내역</a></li>
                                                    <li><a href="/mypage/sellList">판매내역</a></li>
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