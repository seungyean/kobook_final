 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Electrify Responsive Multipurpose Template</title>
<meta name="description" content="">

<!-- CSS FILES -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="/kresources/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css"
	media="screen" data-name="skins">
<link rel="stylesheet" href="/resources/css/layout/wide.css"
	data-name="layout">

<link rel="stylesheet" type="text/css" href="/resources/css/switcher.css"
	media="screen" />
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
							<h2>지역검색</h2>
						</div>
						<nav id="breadcrumbs">
							<ul>
								<li><a href="index.html">Home</a>/</li>
								<li>지역검색</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</section>

		<div class="row sub_content">
			<div class="col-lg-12 col-md-12 col-sm-12">
				<div class="dividerHeading">
					<h4>
						<span>Tables</span>
					</h4>
				</div>
			</div>
			<div class="col-lg-12 col-md-12 col-sm-12">
				<div class="table-responsive">


	
		<form action="/book/booklocationList" method="get">
			<!-- <input type="hidden" name="temp" value="temp">
					<input type="hidden" name="check" value="-1"> -->
			<input type="text" name="keyword" id="keywordInput" value='${cri.keyword}' placeholder="지역을 입력하세요." size="25">
			<input type="hidden" class="form-control" name="person_id" value="${person_id}"> 
			<button id='searchBtn' class="btn-default"><i class="fa fa-search"></i></button>
		</form>

							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th>글번호</th>
										<th>책제목</th>
										<th>책상태</th>
										<th>판매상태</th>
										<th>책가격</th>
										<th>안심유무</th>
										<th>날짜</th>
									</tr>
								</thead>
								
								
								<c:forEach var="b" items="${list}">
									<tr>
										<td>${b.book_id}</td>
										<td><a href="/book/bookRead?book_id=${b.book_id}">${b.book_name}</a></td>
										<td><c:if test="${b.book_status !=null}">
												<c:choose>
													<c:when test="${b.book_status=='A'}">양호</c:when>
													<c:when test="${b.book_status=='C'}">나쁨</c:when>
													<c:otherwise>보통</c:otherwise>
												</c:choose>
											</c:if>
										</td>
										<td><c:if test="${b.book_sell_state !=null}">
												<c:choose>
													<c:when test="${b.book_sell_state=='I'}">판매중</c:when>
													<c:when test="${b.book_sell_state=='C'}">판매완료</c:when>
												</c:choose>
											</c:if>
										</td>
										<td>${b.book_m_price}</td>
										<td>${b.book_safe_yn}</td>
										<td><fmt:formatDate value="${b.book_date}"pattern='yyyy-MM-dd' /></td>
									</tr>
								</c:forEach>
							</table>
				</div>
				<!--/table-responsive -->
			</div>
				<!--/col-lg-12 col-md-12 col-sm-12  -->
		</div>
		<!--/row sub_content  -->

		<div class="text-center">
			<ul class="pagination">

				<c:if test="${pageMaker.prev}">
					<li><a
						href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
				</c:if>

				<c:forEach begin="${pageMaker.startPage }"
					end="${pageMaker.endPage }" var="idx">
					<li
						<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
						<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
					</li>
				</c:forEach>

				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li><a
						href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
				</c:if>

			</ul>
		</div>



	</section>
	<!--end wrapper-->

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
	
	
	
		<script>
		$(document).ready(
				function() {

					$('#searchBtn').on(
							"click",
							function(event) {

								self.location = "bookList"
										+ '${pageMaker.makeQuery(1)}'
										+ "&searchType="
										+ $("select option:selected").val()
										+ "&keyword="
										+ $('#keywordInput').val();

							});

				});
		</script>
	
	<!-- Start Style Switcher -->
	<div class="switcher"></div>
	<!-- End Style Switcher -->
</body>
</html>