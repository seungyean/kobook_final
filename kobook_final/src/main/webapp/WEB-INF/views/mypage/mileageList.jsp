<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="no-js" lang="en"> 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>마일리지</title>
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
		    height: 130px;
		    -webkit-margin-start: 2px;
		    -webkit-margin-end: 2px;
		    -webkit-padding-before: 0.85em;
		    -webkit-padding-start: 0.75em;
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
								<h2>마일리지</h2>
							</div>
							<nav id="breadcrumbs">
								<ul>
									<li><a href="index.html">홈</a>/</li>
									<li>마이페이지 /</li>
									<li>마일리지</li>
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
								<span>마일리지 내역</span>
							</h4>
							<br> <br>
							<div class="media-body">
								<form method="GET" id="OrderHistoryForm" name="OrderHistoryForm">
									<div
										class="xans-element- xans-myshop xans-myshop-orderhistoryhead ">
										<fieldset>
											<div class="col-sm-3" style="margin: 20px">
												<table>
													<tr>
														<td class="col-sm-3" style="text-align: right;">총 적립금:</td>
														<td class="col-sm-2">${mileageTotal}&nbsp;원</td>
													</tr>
													<tr>
														<td class="col-sm-4" style="text-align: right;">사용 가능 적립금 :</td>
														<td class="col-sm-2">${mileageTotal - mileageUse}&nbsp;원</td>
													</tr>
													<tr>
														<td class="col-sm-3" style="text-align: right;">사용 적립금 :</td>
														<td class="col-sm-2">${mileageUse}&nbsp;원</td>
													</tr>
												</table>
											</div>
										</fieldset>
										<br>
										<ul>
										</ul>
									</div>
								</form>
							</div>
							<br> <br>
							<table class="table">
								<thead>
									<tr>
										<td align="center">적립날짜</td>
										<td align="center">적립내용</td>
										<td align="center">마일리지</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="element" items="${mileageList }">
										<tr>
											<td align="center">${element.ORDER_DATE  }</td>
											<c:set var="name" value="${element.MILEAGE_KIND  }" />
											<c:choose>
												<c:when test="${name eq 'P' }">
													<td align="center">안심결제 구매에 의한 적립</td>
												</c:when>
												<c:when test="${name eq 'R' }">
													<td align="center">포토리뷰에 의한 적립</td>
												</c:when>
												<c:when test="${name eq 'M' }">
													<td align="center">안심결제 마일리지 사용</td>
												</c:when>
											</c:choose>
											<td align="center">${element.MILEAGE_POINT }P</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</section><!-- /content typography -->
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
</html>