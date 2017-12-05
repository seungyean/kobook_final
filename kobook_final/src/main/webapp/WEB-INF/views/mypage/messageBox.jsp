<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 

<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html class="no-js" lang="en"> <!--<![endif]-->
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>쪽지보관함</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

     <!-- CSS FILES -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css" media="screen" data-name="skins">
    <link rel="stylesheet" href="/resources/css/layout/wide.css" data-name="layout">

    <link rel="stylesheet" type="text/css" href="/resources/css/switcher.css" media="screen" />
    <style type="text/css">
fieldset {
	display: block;
	height: 80px;
	-webkit-margin-start: 2px;
	-webkit-margin-end: 2px;
	-webkit-padding-before: 1.35em;
	-webkit-padding-start: 1.75em;
	-webkit-padding-end: 0.75em;
	-webkit-padding-after: 0.625em;
	min-width: -webkit-min-content;
	border-width: 2px;
	border-style: groove;
	border-color: threedface;
	border-image: initial;
}
</style>
    </head>
<body>
	<!-- 헤더 -->
 		  <jsp:include page="/WEB-INF/views/include/header.jsp" />
  	<!-- /헤더 -->
	
	<!--start wrapper-->
	<section class="wrapper">
        <section class="page_head">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <div class="page_title">
                            <h2>쪽지보관함</h2>
                        </div>
                        <nav id="breadcrumbs">
                            <ul>
                                <li><a href="index.html">홈</a>/</li>
                                <li>마이페이지 /</li>
                                <li>쪽지보관함</li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </section>

		<section class="content typography">
			<div class="container">
				<div class="row sub_content">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="dividerHeading">
							<br>
							<br>
							<div class="media-body">
							<form method="GET" id="OrderHistoryForm" name="OrderHistoryForm">
								<div class="xans-element- xans-myshop xans-myshop-orderhistoryhead ">
									<fieldset>
										<span> 
										<a href="#none" class="btnNormal" days="00">
										<img src="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1.gif" alt="오늘" />
										</a> 
										<a href="#none" class="btnNormal" days="07">
										<img src="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2.gif" alt="1주일" />
										</a> 
										<a href="#none" class="btnNormal" days="30">
										<img src="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3.gif" alt="1개월" />
										</a> 
										<a href="#none" class="btnNormal" days="90">
										<img src="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4.gif" alt="3개월" />
										</a> 
										<a href="#none" class="btnNormal" days="180">
										<img src="http://img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5.gif" alt="6개월" />
										</a>
										</span> 
										<input type="date" id="start_date" name="start_date" value=""> 
										~ <input type="date" id="end_date" name="end_date" value=""> 
										<input alt="조회" id="order_search_btn" type="submit" class="btn-warning" value="조회"/>
									</fieldset>
									<br>
									<ul>
										<li>&nbsp;&nbsp;- 기본적으로 최근 3개월간의 자료가 조회되며, 기간 검색시 지난 판매내역을 조회하실 수 있습니다.</li>
										<li>&nbsp;&nbsp;- 주문번호를 클릭하시면 해당 주문에 대한 상세내역을 확인하실 수 있습니다.</li>
									</ul>
								</div>
<!-- 								<input id="mode" name="mode" value="" type="hidden" />  -->
<!-- 								<input id="term" name="term" value="" type="hidden" /> -->
							</form>
							</div>
							<c:choose>
									<c:when test="${empty receivedMsgTotal }">

									<div class="media-body">
										<div class="well" style="margin-left: 50px;">
											<h2 align="center">쪽지가 존재하지 않습니다.</h2>
										</div>
									</div>
									</c:when>
									<c:otherwise>
										<!-- <form> -->
										<input  type="button" value="새쪽지보내기"  class="btn btn-success" style="color: white; float: right; margin-right: 50px;">
										
									<table class="table">
										<thead>
											<tr>
												<td align="center">No</td>
												<td align="center">보낸이</td>
												<td align="center">받은 날짜</td>
												<td align="center">내용</td>
												<td align="center">상태</td>
												<td align="center"></td>
												<td></td>
											</tr>
										</thead>
										
										<tbody>
											<c:forEach var="element" items="${receivedMsgTotal}" varStatus="s">
												<tr>
												<td align="center" id="msg_id" class="msg_id">${element.MESSAGE_ID}</td>
												<td align="center" id="msg_person" class="msg_person">${element.P_NAME}/${element.PERSON_EMAIL}</td>
												<td align="center" id="msg_person" class="msg_person">${element.MESSAGE_DATE}</td>
												<td align="center" ><a id="msg_content" class="msg_content">${element.MESSAGE_CONTENT}</a></td>
												<td align="center">
												<c:set var="name" value="${element.MESSAGE_HIT}" />
														<c:choose>
   															<c:when test="${element.MESSAGE_HIT eq '0' }">
      														    <img alt="" src="/resources/img/c.png" style="width: 20px; height: 20px;">
   															</c:when>
   															<c:when test="${element.MESSAGE_HIT eq '1' }">
     														   	 <img alt="" src="/resources/img/o.png" style="width: 20px; height: 20px;">
  															</c:when>
  														</c:choose>
												</td>
												<td align="center">
													<input  type="button" value="답장보내기"  class="btn btn-default" style="color: white;" id="send">
													<input type="button" value="삭제" class="btn btn-danger" id="del" style="color: white;" >
												</td>
												</tr>
									</c:forEach>
										</tbody>
										</table>
									<!-- </form> -->
									</c:otherwise>
								</c:choose>
						</div>
					</div>
				</div>
			</div>
		</section>
		
			<!-- 모달 -->
							<div class="modal fade" id="content" tabindex="-1" role="dialog"
								aria-labelledby="modalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">
												<span aria-hidden="true">×</span><span class="sr-only">취소</span>
											</button>
											<h3 class="modal-title" id="lineModalLabel" style="text-align: center;">쪽지상세보기</h3>
										</div>
										<div class="modal-body">
											<!-- content goes here -->
											<br>
						<table class="table">
							<tr>
								<td>보낸 사람</td>
								<td><input type="text" id="modal_person" value="" style="width: 300px;"></td>
								<td><input type="hidden" id="modal_id" value=""></td>
							</tr>
							<tr>
								<td>내용</td>
								<td><textarea rows="10" cols="70"  id="modal_content"></textarea></td>
							</tr>
						</table>
						<br>
										</div>
										<div class="modal-footer">
											<div class="btn-group btn-group-justified" role="group"
												aria-label="group button">
												<div class="btn-group" role="group">
													<button type="button" class="btn btn-primary"
														data-dismiss="modal" role="button " id="modal_close">닫기</button>
												</div>
												<div class="btn-group btn-delete hidden" role="group">
													<button type="button" id="delImage"
														class="btn btn-default btn-hover-red" data-dismiss="modal"
														role="button">취소</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
		
        <section class="promo_box">
            <div class="container">
                <div class="row">
                    <div class="col-sm-9 col-md-9 col-lg-9">
                        <div class="promo_content">
                            <h3>Electrify is awesome responsive template, with clean design.</h3>
                            <p>Lorem ipsum dolor sit amet, cons adipiscing elit. Aenean commodo ligula eget dolor. </p>
                        </div>
                    </div>
                    <div class="col-sm-3 col-md-3 col-lg-3">
                        <div class="pb_action">
                            <a class="btn btn-lg btn-default" href="#fakelink">
                                <i class="fa fa-shopping-cart"></i>
                                Download Now
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
	</section><!--end wrapper-->

	<!-- 푸터 -->
 	 <jsp:include page="/WEB-INF/views/include/footer.jsp" />
  	<!-- /푸터 -->
	
	

   <script type="text/javascript" src="/resources/js/jquery-1.10.2.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/jquery.easing.1.3.js"></script>
    <script src="/resources/js/retina-1.1.0.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.cookie.js"></script> <!-- jQuery cookie -->
    <script type="text/javascript" src="/resources/js/styleswitch.js"></script> <!-- Style Colors Switcher -->
    <script src="/resources/js/jquery.fractionslider.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="/resources/js/jquery.smartmenus.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.smartmenus.bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/js/owl.carousel.min.js"></script>
    <script type="text/javascript" src="/resources/js/jflickrfeed.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.magnific-popup.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.easypiechart.min.js"></script>
    <script type="text/javascript" src="/resources/js/swipe.js"></script>
    <script type="text/javascript" src="/resources/js/jquery-hoverdirection.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.matchHeight-min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery-scrolltofixed-min.js"></script>

    <script src="/resources/js/main.js"></script>
	<script type="text/javascript">
	
	
	$(function(){
		
		// 답장버튼 클릭
		$(".btn-default").on(	"click",	function(event) {
								event.preventDefault();
								console.log("답장 클릭");

								window.name = "mainPage";
								window.open("/message/messageSend","messagePage",
																		 "width=630, height=300, menubar=yes, statebar=yes, scrollbar=yes");
								document.session_id.action = "/message/messageSend";
								document.session_id.target = "messagePage";
								document.session_id.submit;
							});
		
		// 새쪽지버튼 클릭
		$(".btn-success").on(	"click",	function(event) {
			event.preventDefault();
			console.log("새쪽지 클릭");

			window.name = "mainPage";
			window.open("/message/messageSend","messagePage",
													 "width=630, height=300, menubar=yes, statebar=yes, scrollbar=yes");
			document.session_id.action = "/message/messageSend";
			document.session_id.target = "messagePage";
			document.session_id.submit;
		});
		
		var p = $("#modal_person");
		var ta = $("#modal_content");
		var id = $("#modal_id");
		
		//쪽지 상세보기
		$(".msg_content").on(	"click",	function(event) {
			console.log("내용 클릭");
			console.log("쪽지내용: "+$(this).html());
			console.log("회원번호: "+$(this).parent().parent().find($(".msg_person")).text().trim());
			console.log("쪽지번호: "+$(this).parent().parent().find($(".msg_id")).text().trim());
			
			ta.val($(this).html());
			p.val($(this).parent().parent().find($(".msg_person")).text().trim());
			id.val($(this).parent().parent().find($(".msg_id")).text().trim());
			console.log("내용 클릭");
			$('#content').modal();
		});
		
		//쪽지 모달 닫기 버튼 클릭시
		$(".btn-primary").on(	"click",	function(event) {
			console.log("닫기 클릭");
			console.log(id.val());
			location.href = "/mypage/msgUpdate?message_id="+ id.val();
			
		});
		
		// 쪽지 삭제 버튼 
		$(".btn-danger").click(
				function() {
					var message_id = $(this).parent().parent().find('td:first')
							.text().trim();
					location.href = "/mypage/msgDelete?message_id="
							+ message_id;
				});

		
		
		
		
		
		
		
		
		});
	</script>
    <!-- Start Style Switcher -->
    <div class="switcher"></div>
    <!-- End Style Switcher -->
</body>
</html>

