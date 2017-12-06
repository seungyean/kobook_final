<%@ page import="com.kobook.mypage.domain.*" %>
<%@ page import="com.kobook.mypage.persistence.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html class="no-js" lang="en"> <!--<![endif]-->
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>판매내역</title>
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
                            <h2>판매 내역</h2>
                        </div>
                        <nav id="breadcrumbs">
                            <ul>
                                <li><a href="index.html">홈</a>/</li>
                                <li>마이페이지 /</li>
                                <li>판매내역</li>
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
							<h4><span>판매내역 리스트</span></h4>
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
										<input type="date" id="start_date" name="start_date" value="${cri.start_date }"> 
										~ <input type="date" id="end_date" name="end_date" value="${cri.end_date }"> 
<!-- 										<input alt="조회" id="order_search_btn" type="button" class="btn-warning" value="조회"/> -->
												<button id="searchBtn">조회</button>
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
							<br>
							<br>
							<c:choose>
									<c:when test="${empty sellList }">

									<div class="media-body">
										<div class="well" style="margin-left: 50px;">
											<h2 align="center">판매 상품이 존재하지 않습니다.</h2>
										</div>
									</div>
									</c:when>
									<c:otherwise>
										<form action="sellStateUpdate" method="post">
										<input type="submit" value="변경" class="btn-default" style="margin-left: 1050px">
										<br>
										<br>
									<table class="table table-hover">
										<thead>
											<tr>
												<td align="center">No</td>
												<td align="center">이미지</td>
												<td>책 제목</td>
												<td align="center">등록날짜</td>
												<td align="center">가격</td>
												<td align="center">판매상태 변경</td>
												<td align="center">현재상태</td>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="bookSellList" items="${sellList }" >
											<tr>
												<td align="center">${bookSellList.book_id }</td>
												<td align="center">
													<img class="thumbnail" alt="NO IMAGE"
												 src="/mypage/displayFile?fileName=${bookSellList.book_img}" style="width: 72px; height: 72px;"></td>
												<td>${bookSellList.book_name  }</td>
												<td align="center">${bookSellList.book_date  }</td>
												<td align="center">${bookSellList.book_m_price }</td>
												<td align="center">
													<c:set var="name" value="${bookSellList.book_sell_state}" />
														<c:choose>
   															<c:when test="${name eq 'I' }">
      														    <input type="radio" name="${bookSellList.book_id}" value="I" checked>판매중 &nbsp;&nbsp;
																<input type="radio" name="${bookSellList.book_id}" value="C">판매완료 &nbsp;&nbsp;
   															</c:when>
   															<c:when test="${name eq 'C' }">
     												 		    <input type="radio" name="${bookSellList.book_id}" value="I">판매중 &nbsp;&nbsp;
																<input type="radio" name="${bookSellList.book_id}" value="C" checked>판매완료 &nbsp;&nbsp;
  															</c:when>
  														</c:choose>
												</td>
												<td align="center">
												<c:set var="name" value="${bookSellList.book_sell_state}" />
												<c:choose>
   													<c:when test="${bookSellList.book_sell_state eq 'I' }">
      												    판매중
   													</c:when>
   													<c:when test="${bookSellList.book_sell_state eq 'C' }">
     												   판매완료
  													</c:when>
  												</c:choose>
												</td>
											</tr>
										</c:forEach>
										</tbody>
										</table>
								</form>
									</c:otherwise>
								</c:choose>
						</div>
						<div class="text-center">
						 <ul class="pagination">

								<c:if test="${pageMaker.prev}">
									<li><a
										href="sellList${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
								</c:if>

								<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
									<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
										<a href="sellList${pageMaker.makeSearch(idx)}">${idx}</a>
									</li>
								</c:forEach>

								<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
									<li><a
										href="sellList${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
								</c:if>

							</ul> 
							
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
    <script src="resources/js/jquery.fractionslider.js" type="text/javascript" charset="utf-8"></script>
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

    <script src="resources/js/main.js"></script>

    <!-- Start Style Switcher -->
    <div class="switcher"></div>
    <!-- End Style Switcher -->
</body>

<script>
	

</script>
</html>