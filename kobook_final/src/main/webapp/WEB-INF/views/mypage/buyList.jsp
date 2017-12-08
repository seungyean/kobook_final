<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>구매내역</title>
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
							<h2>구매내역</h2>
						</div>
						<nav id="breadcrumbs">
							<ul>
								<li><a href="index.html">홈</a>/</li>
								<li>마이페이지 /</li>
								<li>구매내역</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</section><!-- /page_head -->

		<section class="content typography">
			<div class="container">
				<div class="row sub_content">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="dividerHeading">
							<h4>
								<span>구매내역 리스트</span>
							</h4>
							<br> <br>
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
											<input type="date" id="start_date" name="start_date" value="${cri.start_date }"> 
												~ 
											<input type="date" id="end_date" name="end_date" value="${cri.end_date }">
											<button id="searchBtn">조회</button>
										</fieldset>
										<br>
										<ul>
											<li>&nbsp;&nbsp;- 기본적으로 최근 3개월간의 자료가 조회되며, 기간 검색시 지난 판매내역을 조회하실 수 있습니다.</li>
											<li>&nbsp;&nbsp;- 주문번호를 클릭하시면 해당 주문에 대한 상세내역을 확인하실 수 있습니다.</li>
										</ul>
									</div>
								</form>
							</div>
							<br>
							<br>
							<c:choose>
								<c:when test="${empty buyList }">
									<div class="media-body">
										<div class="well" style="margin-left: 50px;">
											<h2 align="center">구매 상품이 존재하지 않습니다.</h2>
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<table class="table table-hover">
										<thead>
											<tr>
												<td align="center">No</td>
												<td align="center">이미지</td>
												<td>책 제목</td>
												<td align="center">결제가격</td>
												<td align="center">주문날짜</td>
												<td></td>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="element" items="${buyList }" varStatus="s">
												<tr>
													<td align="center" id="pi" data-rno="${element.PAY_ID}">${element.PAY_ID}</td>
													<td align="center">
														<img class="thumbnail" alt="NO IMAGE" src="/mypage/displayFile?fileName=${element.BOOK_IMG}" style="width: 72px; height: 72px;">
													</td>
													<td>${element.BOOK_NAME}</td>
													<td align="center">${element.PAY_AMOUNT}</td>
													<td align="center">${element.ORDER_DATE}</td>
													<td>
														<input type="button" value="후기작성" class="btn-default" style="color: white;">
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</c:otherwise>
							</c:choose>
						</div> <!-- /dividerHeading -->
						
						<!-- 페이지네이션 -->
						<div class="text-center">
						 <ul class="pagination">

								<c:if test="${pageMaker.prev}">
									<li><a
										href="buyList${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
								</c:if>

								<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
									<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
										<a href="buyList${pageMaker.makeSearch(idx)}">${idx}</a>
									</li>
								</c:forEach>

								<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
									<li><a
										href="buyList${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
								</c:if>

							</ul> 
							
						</div>
						 <!-- /페이지네이션 -->
					</div>
				</div>
			</div>
		</section>
	</section><!--/wrapper-->

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
	

		$(function() {

			$(".btn-default").on(
					"click",
					function(event) {
						event.preventDefault();
						console.log($(this).val());
						var i = $(this).parent().parent().find("td:eq(0)").attr("data-rno");
						window.open("/book/bookreviewRegist?pay_id=" + i, "","width=400,height=300,left=550,top=200");
					});
		});
	</script>
	
    <!-- Start Style Switcher -->
    <div class="switcher"></div>
    <!-- End Style Switcher -->
</body>
</html>