<%-- <%@page import="kobook.book.domain.BookSearch"%>
<%@page import="kobook.book.domain.Book"%> --%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% 
	/* int person_id = Integer.parseInt((String)(session.getAttribute("person_id"))); */
	//session.setAttribute("person_id", 5);
%>
<%-- <%
	Book book = (Book)request.getAttribute("book");
%> --%>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Portfolio Single - Electrify Responsive Multipurpose
	Template</title>
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />


     <!-- CSS FILES -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css" media="screen" data-name="skins">
    <link rel="stylesheet" href="/resources/css/layout/wide.css" data-name="layout">

    <link rel="stylesheet" type="text/css" href="/resources/css/switcher.css" media="screen" />
</head>


<body>
	<!-- 헤더 -->
 		<%--  <jsp:include page="/include/header.jsp" /> --%>
  	<!-- /헤더 -->

	<!--start wrapper-->
	<section class="wrapper">
		<section class="page_head">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="page_title">
							<h2>도서 상세보기</h2>
						</div>
						<nav id="breadcrumbs">
							<ul>
								<li><a href="index.html">Home</a>/</li>
								<li>상세보기</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</section>






		<section class="content portfolio_single">
			<div class="container">
				<div class="row sub_content">
			
			
				<form role="form" action="/book/bookModify/${bookVO.book_id}" method="post">
				<%-- <input type="hidden" name="book_id" value="${bookVO.book_id}"> --%>
                	<input type="hidden" name="page" value="${cri.page}">
                	<input type="hidden" name="perPageNum" value="${cri.perPageNum}">
                
                	
                	
					<div class="col-lg-8 col-md-8 col-sm-8">
						<!--Project Details Page-->
						<div class="porDetCarousel">
							<div class="carousel-content">
							
				
							
						
									<%-- <img alt="" class="carousel-item" src="/kobook/upload/${bookVO.book_img}" width="10px" height="800px"> --%>
								<!--<img class="carousel-item" src="images/portfolio/portfolio_slider1.png" alt="">
								<img class="carousel-item" src="images/portfolio/portfolio_slider2.png" alt="">
								<img class="carousel-item" src="images/portfolio/portfolio_slider3.png" alt=""> -->
									
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-4 col-sm-4">
						<div class="project_description">
							<div class="widget_title">
								<h4><span>내용</span></h4>
							</div>
						<p>${bookVO.book_content}</p>
						</div>

					<div class="project_details">
							<div class="widget_title">
								<h4><span>상세내용</span></h4>
							</div>
							
					<ul class="details">
								<li><span>책이름 :</span>${bookVO.book_name}</li>
								<li><span>책종류 :</span>${bookVO.book_kind}</li>
								<li><span>부가설명 :</span>${bookVO.book_hash}</li>
								<li><span> 원가:</span> ${bookVO.book_o_price}</li>
								<li><span> 판매가:</span> ${bookVO.book_m_price} 할인:<b>${(bookVO.book_o_price-bookVO.book_m_price)/100}%</b></li>
								<li><span> 판 :</span>${bookVO.book_edition}</li>
								<li><span>출판사 :</span>${bookVO.book_publish}</li>
								<li><span>안심여부사용 :</span>${bookVO.book_safe_yn}</li>
								<li><span>책상태 :</span>
								<c:choose>
								<c:when test="${bookVO.book_status=='A'}">
								양호
								</c:when>
								<c:when test="${bookVO.book_status=='B'}">
								보통
								</c:when>
								<c:when test="${bookVO.book_status=='C'}">
								나쁨
								</c:when>
								</c:choose>
								</li>
		
								<li><span>판매상태</span>
								<c:choose>
								<c:when test="${bookVO.book_sell_state=='I'}">
								판매중
								</c:when>
								<c:when test="${bookVO.book_sell_state=='C'}">
								판매완료
								</c:when>
								</c:choose>
								</li>
						</ul> 
				</div>  <!--/project_details  -->
		</div>  <!--/col-lg-4 col-md-4 col-sm-4  -->
  
								<span><input type="submit" value="수정하기" id="submit" class="btn btn-default btn-lg button"></span>
							</form>
									
						<%-- <form action="/kobook/book/pickAction.do" method="post">
							<input type="hidden" name="book_id" value="${BookVO.book_id}" />
							<input type="hidden" name = "person_id" value="${BookVO.person_id}" >
							<span>
							<input type="submit" value="찜하기" id="submit" class="btn btn-default btn-lg button">
							</span>
						</form> --%>
							
		</div>  <!--/row sub_content  -->
		
<%--  <img src="/kobook/upload/${b.book_img}" alt="aa" height="280" />
                                 <a href="/kobook/book/detailAction.do?book_id=${b.book_id}"></a> --%>
 	<%-- 
			<div class="row sub_content">
                    <div class="col-md-12">
                        <div class="dividerHeading">
                            <h4><span>Recent Work</span></h4>
                        </div>
                        <div id="recent-work-slider" class="owl-carousel">
                            <div class="recent-item box">
                                <figure class="touching ">
                                	<c:forEach var="b" items="${listModel.list}">
                                    <img src="/kobook/upload/${b.book_img}" alt=""/>
                                    <div class="option inner">
                                        <div>
                                            <h5>${b.book_name}</h5>
                                            <a href="/kobook/upload/${b.book_img}" class="fa fa-search mfp-image"></a> 
                                      		<a href="/kobook/book/detailAction.do?book_id=${b.book_id}" class="fa fa-link"></a> 
                                            <span>${b.book_m_price}원</span>
                                        </div>
                                    </div>
                                     </c:forEach>
                                </figure>
                            </div> <!--/recent-item box  -->
                            
                        </div> <!--/recent-work-slider  -->
                    </div> <!--/col-md-12  -->
                </div> <!--/row sub_content  -->
                --%>
			</div> <!--/container  -->
		</section>
	</section>
	<!--end wrapper-->

	<!-- 푸터 -->
 		<%--  <jsp:include page="/include/footer.jsp" /> --%>
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

 

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$.fn.carousel = function(op) {
								var op, ui = {};
								op = $.extend({
									speed : 500,
									autoChange : false,
									interval : 5000
								}, op);
								ui.carousel = this;
								ui.items = ui.carousel.find('.carousel-item');
								ui.itemsLen = ui.items.length;

								// CREATE CONTROLS
								ui.ctrl = $('<div />', {
									'class' : 'carousel-control'
								});
								ui.prev = $('<div />', {
									'class' : 'carousel-prev'
								});
								ui.next = $('<div />', {
									'class' : 'carousel-next'
								});
								ui.pagList = $('<ul />', {
									'class' : 'carousel-pagination'
								});
								ui.pagItem = $('<li></li>');
								for (var i = 0; i < ui.itemsLen; i++) {
									ui.pagItem.clone().appendTo(ui.pagList);
								}
								ui.prev.appendTo(ui.ctrl);
								ui.next.appendTo(ui.ctrl);
								ui.pagList.appendTo(ui.ctrl);
								ui.ctrl.appendTo(ui.carousel);
								ui.carousel.find('.carousel-pagination li').eq(
										0).addClass('active');
								ui.carousel.find('.carousel-item').each(
										function() {
											$(this).hide();
										});
								ui.carousel.find('.carousel-item').eq(0).show()
										.addClass('active');

								// CHANGE ITEM
								var changeImage = function(direction, context) {
									var current = ui.carousel
											.find('.carousel-item.active');

									if (direction == 'index') {
										if (current.index() === context.index())
											return false;

										context.addClass('active').siblings()
												.removeClass('active');

										ui.items.eq(context.index()).addClass(
												'current').fadeIn(
												op.speed,
												function() {
													current.removeClass(
															'active').hide();
													$(this).addClass('active')
															.removeClass(
																	'current');
												});
									}

									if (direction == 'prev') {
										if (current.index() == 0) {
											ui.carousel
													.find('.carousel-item:last')
													.addClass('current')
													.fadeIn(
															op.speed,
															function() {
																current
																		.removeClass(
																				'active')
																		.hide();
																$(this)
																		.addClass(
																				'active')
																		.removeClass(
																				'current');
															});
										} else {
											current
													.prev()
													.addClass('current')
													.fadeIn(
															op.speed,
															function() {
																current
																		.removeClass(
																				'active')
																		.hide();
																$(this)
																		.addClass(
																				'active')
																		.removeClass(
																				'current');
															});
										}
									}

									if (direction == undefined) {
										if (current.index() == ui.itemsLen - 1) {
											ui.carousel
													.find(
															'.carousel-item:first')
													.addClass('current')
													.fadeIn(
															300,
															function() {
																current
																		.removeClass(
																				'active')
																		.hide();
																$(this)
																		.addClass(
																				'active')
																		.removeClass(
																				'current');
															});
										} else {
											current
													.next()
													.addClass('current')
													.fadeIn(
															300,
															function() {
																current
																		.removeClass(
																				'active')
																		.hide();
																$(this)
																		.addClass(
																				'active')
																		.removeClass(
																				'current');
															});
										}
									}
									ui.carousel
											.find('.carousel-pagination li')
											.eq(
													ui.carousel
															.find(
																	'.carousel-item.current')
															.index()).addClass(
													'active').siblings()
											.removeClass('active');
								};

								ui.carousel.on('click', 'li', function() {
									changeImage('index', $(this));
								}).on('click', '.carousel-prev', function() {
									changeImage('prev');
								}).on('click', '.carousel-next', function() {
									changeImage();
								});

								// AUTO CHANGE
								if (op.autoChange) {
									var changeInterval = setInterval(
											changeImage, op.interval);
									ui.carousel.on('mouseenter', function() {
										clearInterval(changeInterval);
									}).on(
											'mouseleave',
											function() {
												changeInterval = setInterval(
														changeImage,
														op.interval);
											});
								}
								return this;
							};

							$('.porDetCarousel').each(function() {
								$(this).carousel({
									autoChange : true
								});
							});
						});
	</script>
	 <script src="/resources/js/main.js"></script>
	<!-- Start Style Switcher -->
	<div class="switcher"></div>
	<!-- End Style Switcher -->
</body>
</html>
