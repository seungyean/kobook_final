
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/* if(session.getAttribute("person_id")!=null){
		int person_id=Integer.parseInt((String)(session.getAttribute("person_id")));
	} */
%>
<%-- <%

	int pay_id=Integer.parseInt((String)(session.getAttribute("pay_id")));
	System.out.print(pay_id);

%> --%>
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
<title>main</title>
<meta name="description" content="">
<style type="text/css">
body {
	font-family: "Open Sans", Helvetica, Arial, sans-serif;
	color: #555;
	max-width: 680px;
	margin: 0 auto;
	padding: 0 20px;
}

* {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

*:before, *:after {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.clearfix {
	clear: both;
}

.text-center {
	text-align: center;
}

pre {
	display: block;
	padding: 9.5px;
	margin: 0 0 10px;
	font-size: 13px;
	line-height: 1.42857143;
	color: #333;
	word-break: break-all;
	word-wrap: break-word;
	background-color: #F5F5F5;
	border: 1px solid #CCC;
	border-radius: 4px;
}

.header {
	padding: 20px 0;
	position: relative;
	margin-bottom: 10px;
}

.header:after {
	content: "";
	display: block;
	height: 1px;
	background: #eee;
	position: absolute;
	left: 30%;
	right: 30%;
}

.header h2 {
	font-size: 3em;
	font-weight: 300;
	margin-bottom: 0.2em;
}

.header p {
	font-size: 14px;
}

.success-box {
	margin: 50px 0;
	padding: 10px 10px;
	border: 1px solid #eee;
	background: #f9f9f9;
}

.success-box img {
	margin-right: 10px;
	display: inline-block;
	vertical-align: top;
}

.success-box>div {
	vertical-align: top;
	display: inline-block;
	color: #888;
}

/* Rating Star Widgets Style */
.rating-stars ul {
	list-style-type: none;
	padding: 0;
	-moz-user-select: none;
	-webkit-user-select: none;
}

.rating-stars ul>li.star {
	display: inline-block;
}

/* Idle State of the stars */
.rating-stars ul>li.star>i.fa {
	font-size: 2.5em; /* Change the size of the stars */
	color: #ccc; /* Color on idle state */
}

/* Hover state of the stars */
.rating-stars ul>li.star.hover>i.fa {
	color: #FFCC36;
}

/* Selected state of the stars */
.rating-stars ul>li.star.selected>i.fa {
	color: #FF912C;
}
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



<body>


	<!--start wrapper-->



	<br>

	<form action="/book/bookreviewRegist" method="post" id="reviewForm">
		<input type="hidden" name="pay_id" value="${pay_id}">
		<header class='header text-center'>
			<h2>후기 등록하기</h2>
			<p>판매자 또는 도서에 대한 후기를 남겨주세용</p>
		</header>
		<input type="text" name="review_title" id="name"
			class="form-control" placeholder="리뷰제목">
		<section class='rating-widget'>
			<!-- Rating Stars Box -->
			<div class='rating-stars text-center'>
				<ul id='stars'>
					<li class='star' title='Poor' data-value='1'><i
						class='fa fa-star fa-fw'></i></li>
					<li class='star' title='Fair' data-value='2'><i
						class='fa fa-star fa-fw'></i></li>
					<li class='star' title='Good' data-value='3'><i
						class='fa fa-star fa-fw'></i></li>
					<li class='star' title='Excellent' data-value='4'><i
						class='fa fa-star fa-fw'></i></li>
					<li class='star' title='WOW!!!' data-value='5'><i
						class='fa fa-star fa-fw'></i></li>
				</ul>
			</div>

			<div class='success-box'>
				<div class='clearfix'></div>
				<img alt='tick image' width='32'
					src='https://i.imgur.com/3C3apOp.png' />
				<div class='text-message'></div>
				<div class='clearfix'></div>
			</div>

		</section>
		<textarea rows="10" cols="70" name="review_content" id="name"
			class="form-control" placeholder="내용을 입력하세요"></textarea>
		<input type="submit" value="글쓰기" id="submit"
			class="btn btn-default btn-lg button">
	</form>









	<!--end wrapper-->



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
		$(document)
				.ready(
						function() {

							/* 1. Visualizing things on Hover - See next part for action on click */
							$('#stars li')
									.on(
											'mouseover',
											function() {
												var onStar = parseInt($(this)
														.data('value'), 10); // The star currently mouse on

												// Now highlight all the stars that's not after the current hovered star
												$(this)
														.parent()
														.children('li.star')
														.each(
																function(e) {
																	if (e < onStar) {
																		$(this)
																				.addClass(
																						'hover');
																	} else {
																		$(this)
																				.removeClass(
																						'hover');
																	}
																});

											})
									.on(
											'mouseout',
											function() {
												$(this)
														.parent()
														.children('li.star')
														.each(
																function(e) {
																	$(this)
																			.removeClass(
																					'hover');
																});
											});

							/* 2. Action to perform on click */
							$('#stars li')
									.on(
											'click',
											function() {
												var onStar = parseInt($(this)
														.data('value'), 10); // The star currently selected
												var stars = $(this).parent()
														.children('li.star');

												for (i = 0; i < stars.length; i++) {
													$(stars[i]).removeClass(
															'selected');
												}

												for (i = 0; i < onStar; i++) {
													$(stars[i]).addClass(
															'selected');
												}

												// JUST RESPONSE (Not needed)
												var review_star = parseInt($(
														'#stars li.selected')
														.last().data('value'),
														10);
												var msg = "";
												if (review_star > 1) {
													msg = "Thanks! You rated this "
															+ review_star
															+ " stars.";
													$('#reviewForm')
															.append(
																	'<input type="hidden" name="review_star" value="'+review_star +'">');

												} else {
													msg = "We will improve ourselves. You rated this "
															+ review_star
															+ " stars.";
												}
												responseMessage(msg);

											});

						});

		function responseMessage(msg) {
			$('.success-box').fadeIn(200);
			$('.success-box div.text-message').html("<span>" + msg + "</span>");
		}
	</script>

	<!-- Start Style Switcher -->
	<div class="switcher"></div>
	<!-- End Style Switcher -->
</body>
</html>
