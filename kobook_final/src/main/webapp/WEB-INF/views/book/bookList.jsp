<%-- <%@page import="kobook.book.dao.BookDAO"%> --%>
<%-- <%@page import="kobook.book.domain.BookSearch"%>
<%@page import="kobook.book.domain.Book"%> --%>
<%@page import="java.util.List"%>
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
<title>전체검색[전공]</title>
<meta name="description" content="">
<style type="text/css">
.block {border:2px solid #d81f25; padding:0 5px; height:26px; overflow:hidden; background:#fff; width:220px; font-family:Gulim; font-size:17px; margin-left: 600px; margin-top: 10px;}
.block ul,
.block li {margin:0; padding:0; list-style:none;}
.block li a {display:block; height:20px; line-height:20px; color:#555; text-decoration:none;}
.block li span {padding:2px 5px; background:#d81f25; color:#fff; font-weight:bold; margin-right:3px;}
</style>
<!-- CSS FILES -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css"
	media="screen" data-name="skins">
<link rel="stylesheet" href="/resources/css/layout/wide.css"
	data-name="layout">

<link rel="stylesheet" type="text/css"
	href="/resources/css/switcher.css" media="screen" />
</head>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
$(function()
		{
		    var ticker = function()
		    {
		        setTimeout(function(){
		            $('#ticker li:first').animate( {marginTop: '-20px'}, 400, function()
		            {
		                $(this).detach().appendTo('ul#ticker').removeAttr('style');
		            });
		            ticker();
		        }, 3000);
		    };
		    ticker();
		});
</script>

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
							<h2>도서목록</h2>
						</div>
						<nav id="breadcrumbs">
							<ul>
								<li><a href="index.html">홈</a>/</li>
								<li>전체검색</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</section>

		<div class='box-body' align="center">
		<form action="/book/rankingRegist" method="post" name="rankingForm" > 

			<select name="searchType">
				<option value="n"
					<c:out value="${cri.searchType == null?'selected':''}"/>>
					검색방법</option>
				<option value="t"
					<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
					제목</option>
				<option value="c"
					<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
					내용</option>
				<option value="w"
					<c:out value="${cri.searchType eq 'w'?'selected':''}"/>>
					해시태그</option>
				<option value="tc"
					<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
					제목 + 내용</option>
				<option value="tw"
					<c:out value="${cri.searchType eq 'tw'?'selected':''}"/>>
					제목 + 해시태그</option>
				<option value="tcw"
					<c:out value="${cri.searchType eq 'tcw'?'selected':''}"/>>
					제목 + 내용 + 해시태그</option>
			</select> 
			<input type="text" name="keyword" id="keywordInput"
				value="${review_keyword}"  data-rno="${review_keyword}" placeholder="Enter Search keywords..."
				size="25">
			<button id='searchBtn' class="btn-default">
				<i class="fa fa-search"></i>
			</button>

		</div>


			<div class="block">
			    <ul id="ticker">
			    <c:forEach var="rl" items="${rankingList}" varStatus="status">
			        <li><a href="#"><span><c:out value="${status.count}"/></span> ${rl.ranking_keyword}</a></li>
					</c:forEach>
			    </ul>
			</div>

		<section class="content portfolio small-images">
		<div class="container">
			<form action="/book/bookRegist" method="get">
				<!--begin isotope -->
				<div class="isotope col-lg-12">
					<!--begin portfolio filter -->
					<ul id="filter" class="option-set clearfix">
						<!-- <li data-filter="*" class="selected"><a href="#">All</a></li> -->
						<li data-filter=".*" class="selected"><a href="#">All</a></li>
						<li data-filter=".Social"><a href="#">사회과학계열</a></li>
						<li data-filter=".Law"><a href="#">법학계열</a></li>
						<li data-filter=".Medical"><a href="#">의학간호계열</a></li>
						<li data-filter=".Engineering"><a href="#">공학계열</a></li>
						<li data-filter=".Science"><a href="#">자연과학계열</a></li>
						<li data-filter=".Art"><a href="#">예체능계열</a></li>
						<li data-filter=".Language"><a href="#">어문학계열</a></li>

					</ul>

					<!--  <img src="/resources/test.jpg" alt="aa" height="280" /> -->

					<!--begin portfolio_list -->
					<ul id="list" class="portfolio_list clearfix ">

						<!--begin List Item -->
						<c:forEach var="b" items="${list}">
							<%-- <c:set var="b.book_kind" value="Social" /> --%>
							<c:if test="${b.book_kind=='사회과학계열'}">
								<li class="list_item col-lg-3 col-md-4 col-sm-6 Social">
									<div class="recent-item box">
										<figure class="touching ">

								
											<img src="/book/displayFile?fileName=${b.book_img}" alt="aa" height="280"></img>
											<a href="/book/bookRead?book_id=${b.book_id}"></a>

											<div class="option inner">
												<div>
													<h5>${b.book_name}</h5>
													<a href="displayFile?fileName=${b.book_img}" class="fa fa-search mfp-image"></a> 
														<a href="/book/bookRead?book_id=${b.book_id}" class="fa fa-link"></a> 
													<span>${b.book_m_price}원</span>

													<c:choose>
														<c:when test="${b.book_sell_state=='I'}">
															<span>판매중</span>
														</c:when>

														<c:when test="${b.book_sell_state=='C'}">
															<span>판매완료</span>
														</c:when>

													</c:choose>
													<!--     <span>Business</span> -->
												</div>
											</div>
										</figure>
									</div>
								</li>
							</c:if>
						</c:forEach>
						<!--end List Item -->



						<!--begin List Item -->
						<c:forEach var="b" items="${list}">
							<%-- <c:set var="b.book_kind" value="Law" /> --%>
							<c:if test="${b.book_kind=='법학계열'}">
								<li class="list_item col-lg-3 col-md-4 col-sm-6 Law">
									<div class="recent-item box">
										<figure class="touching ">

											<img src="displayFile?fileName=${b.book_img}" alt="aa"
												height="280"></img>
											<a href="/book/bookRead?book_id=${b.book_id}"></a>
											<div class="option inner">
												<div>
													<h5>${b.book_name}</h5>
													<a href="displayFile?fileName=${b.book_img}"
														class="fa fa-search mfp-image"></a> <a
														href="/book/bookRead?book_id=${b.book_id}"
														class="fa fa-link"></a> <span>${b.book_m_price}원</span>
													<c:choose>
														<c:when test="${b.book_sell_state=='I'}">
															<span>판매중</span>
														</c:when>
														<c:when test="${b.book_sell_state=='C'}">
															<span>판매완료</span>
														</c:when>

													</c:choose>
													<!-- <span>Economy</span> -->
												</div>
											</div>
										</figure>
									</div>
								</li>
							</c:if>
						</c:forEach>
						<!--end List Item -->

						<!--begin List Item -->
						<c:forEach var="b" items="${list}">
							<%-- <c:set var="b.book_kind" value="Medical" /> --%>
							<c:if test="${b.book_kind=='의학간호계열'}">
								<li class="list_item col-lg-3 col-md-4 col-sm-6 Medical">
									<div class="recent-item box">
										<figure class="touching ">

											<img src="displayFile?fileName=${b.book_img}" alt="aa"
												height="280"></img>
											<a href="/book/bookRead?book_id=${b.book_id}"></a>
											<div class="option inner">
												<div>
													<h5>${b.book_name}</h5>
													<a href="displayFile?fileName=${b.book_img}"
														class="fa fa-search mfp-image"></a> <a
														href="/book/bookRead?book_id=${b.book_id}"
														class="fa fa-link"></a> <span>${b.book_m_price}원</span>
													<c:choose>
														<c:when test="${b.book_sell_state=='I'}">
															<span>판매중</span>
														</c:when>
														<c:when test="${b.book_sell_state=='C'}">
															<span>판매완료</span>
														</c:when>
													</c:choose>
													<!-- <span>Computer</span> -->
												</div>
											</div>
										</figure>
									</div>
								</li>
							</c:if>
						</c:forEach>
						<!--end List Item -->

						<!--begin List Item -->
						<c:forEach var="b" items="${list}">
						<%-- 	<c:set var="b.book_kind" value="Engineering" /> --%>
							<c:if test="${b.book_kind=='공학계열'}">
								<li class="list_item col-lg-3 col-md-4 col-sm-6 Engineering">
									<div class="recent-item box">
										<figure class="touching ">
											<img src="displayFile?fileName=${b.book_img}" alt="aa"
												height="280"></img>
											<a href="/book/bookRead?book_id=${b.book_id}"></a>
											<div class="option inner">
												<div>
													<h5>${b.book_name}</h5>
													<a href="displayFile?fileName=${b.book_img}"
														class="fa fa-search mfp-image"></a> <a
														href="/book/bookRead?book_id=${b.book_id}"
														class="fa fa-link"></a> <span>${b.book_m_price}원</span>
													<c:choose>
														<c:when test="${b.book_sell_state=='I'}">
															<span>판매중</span>
														</c:when>
														<c:when test="${b.book_sell_state=='C'}">
															<span>판매완료</span>
														</c:when>
													</c:choose>
													<!-- <span>Deutsch</span> -->
												</div>
											</div>
										</figure>
									</div>
								</li>
							</c:if>
						</c:forEach>
						<!--end List Item -->

						<!--begin List Item -->
						<c:forEach var="b" items="${list}">
							<%-- <c:set var="b.book_kind" value="Science" /> --%>
							<c:if test="${b.book_kind=='자연과학계열'}">
								<li class="list_item col-lg-3 col-md-4 col-sm-6 Science">
									<div class="recent-item box">
										<figure class="touching ">

											<img src="displayFile?fileName=${b.book_img}" alt="aa"
												height="280"></img>
											<a href="/book/bookRead?book_id=${b.book_id}"></a>
											<div class="option inner">
												<div>
													<h5>${b.book_name}</h5>
													<a href="displayFile?fileName=${b.book_img}"
														class="fa fa-search mfp-image"></a> <a
														href="/book/bookRead?book_id=${b.book_id}"
														class="fa fa-link"></a> <span>${b.book_m_price}원</span>
													<c:choose>
														<c:when test="${b.book_sell_state=='I'}">
															<span>판매중</span>
														</c:when>
														<c:when test="${b.book_sell_state=='C'}">
															<span>판매완료</span>
														</c:when>
													</c:choose>
													<!-- <span>Law</span> -->
												</div>
											</div>
										</figure>
									</div>
								</li>
							</c:if>
						</c:forEach>
						<!--end List Item -->

						<!--begin List Item -->
						<c:forEach var="b" items="${list}">
							<%-- <c:set var="b.book_kind" value="Art" /> --%>
							<c:if test="${b.book_kind=='예체능계열'}">
								<li class="list_item col-lg-3 col-md-4 col-sm-6 Art">
									<div class="recent-item box">
										<figure class="touching ">

											<img src="displayFile?fileName=${b.book_img}" alt="aa"
												height="280"></img>
											<a href="/book/bookRead?book_id=${b.book_id}"></a>
											<div class="option inner">
												<div>
													<h5>${b.book_name}</h5>
													<a href="displayFile?fileName=${b.book_img}"
														class="fa fa-search mfp-image"></a> <a
														href="/book/bookRead?book_id=${b.book_id}"
														class="fa fa-link"></a> <span>${b.book_m_price}원</span>
													<c:choose>
														<c:when test="${b.book_sell_state=='I'}">
															<span>판매중</span>
														</c:when>
														<c:when test="${b.book_sell_state=='C'}">
															<span>판매완료</span>
														</c:when>
													</c:choose>
													<!-- <span>History</span> -->
												</div>
											</div>
										</figure>
									</div>
								</li>
							</c:if>
						</c:forEach>
						<!--end List Item -->

						<!--begin List Item -->
						<c:forEach var="b" items="${list}">
							<%-- <c:set var="b.book_kind" value="Language" /> --%>
							<c:if test="${b.book_kind=='어문학계열'}">
								<li class="list_item col-lg-3 col-md-4 col-sm-6 Language">
									<div class="recent-item box">
										<figure class="touching ">

											<img src="displayFile?fileName=${b.book_img}" alt="aa"
												height="280"></img>
											<a href="/book/bookRead?book_id=${b.book_id}"></a>
											<div class="option inner">
												<div>
													<h5>${b.book_name}</h5>
													<a href="displayFile?fileName=${b.book_img}"
														class="fa fa-search mfp-image"></a> <a
														href="/book/bookRead?book_id=${b.book_id}"
														class="fa fa-link"></a> <span>${b.book_m_price}원</span>
													<c:choose>
														<c:when test="${b.book_sell_state=='I'}">
															<span>판매중</span>
														</c:when>
														<c:when test="${b.book_sell_state=='C'}">
															<span>판매완료</span>
														</c:when>
													</c:choose>
													<!-- <span>Physics</span> -->
												</div>
											</div>
										</figure>
									</div>
								</li>
							</c:if>
						</c:forEach>
						<!--end List Item -->
					</ul>
					<!--end portfolio_list -->
				</div>
				<!--end isotope -->

				<input type="submit" value="글쓰기" class="btn-default" />
			</form>
			</div>
		</section>
		<!--end small images  -->



		<div class="text-center">
			<ul class="pagination">
				<c:if test="${pageMaker.prev}">
					<li><a
						href="bookList${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
				</c:if>

				<c:forEach begin="${pageMaker.startPage }"
					end="${pageMaker.endPage }" var="idx">
					<li
						<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
						<a href="bookList${pageMaker.makeSearch(idx)}">${idx}</a>
					</li>
				</c:forEach>

				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li><a
						href="bookList${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
				</c:if>

			</ul>
		</div>
		<!-- /.box-footer-->




	</section>
	<!--end wrapper-->
	<!-- 푸터 -->
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	<!-- /푸터 -->

	<script type="text/javascript" src="/resources/js/jquery-1.10.2.min.js"></script>
	<script src="/resources/js/bootstrap.min.js"></script>
	<script src="/resources/js/jquery.easing.1.3.js"></script>
	<script src="/resources/js/retina-1.1.0.min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.cookie.js"></script>
	<!-- jQuery cookie -->
	<script type="text/javascript" src="/resources/js/styleswitch.js"></script>
	<!-- Style Colors Switcher -->
	<script src="/resources/js/jquery.fractionslider.js"
		type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript"
		src="/resources/js/jquery.smartmenus.min.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery.smartmenus.bootstrap.min.js"></script>
	<script type="text/javascript" src="/resources/js/owl.carousel.min.js"></script>
	<script type="text/javascript" src="/resources/js/jflickrfeed.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery.magnific-popup.min.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery.isotope.min.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery.easypiechart.min.js"></script>
	<script type="text/javascript" src="/resources/js/swipe.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery-hoverdirection.min.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery.matchHeight-min.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery-scrolltofixed-min.js"></script>
	<script src="/resources/js/main.js"></script>
	<script type="text/javascript">
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
										
								var key_word=$('#keywordInput').attr("data-rno");
								console.log("키워드: "+key_word);
							});

				});
	</script>
	<!-- Start Style Switcher -->
	<div class="switcher"></div>
	<!-- End Style Switcher -->
</body>
</html>
