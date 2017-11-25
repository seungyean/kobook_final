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
<script type="text/javascript">
/* function fn_review(){
	
		window.name = "mainPage";
		window.open("/book/bookreviewRegist","reviewForm","width=400,height=300,left=550,top=200");
		document.reviewForm.action = "/book/bookreviewRegist";
		document.reviewForm.target = "messagePage";
		document.reviewForm.submit;
	
	
} */
</script>

<body>


	<!--start wrapper-->


	<h1 style="text-align: center;">후기 등록하기</h1>
	<br>

	<form action="/book/bookreviewRegist" method="post" name="reviewForm">
	<input type="hidden" name="pay_id" value="${pay_id}">
		<!-- <input type="hidden" id="parentURI" name="parentURI" value=""> -->
		<b> 책상태: </b>
			<select name="review_star">
			<option value="5" selected="selected">★★★★★</option>
			<option value="4">★★★★☆</option>
			<option value="3">★★★☆☆</option>
			<option value="2">★★☆☆☆</option>
			<option value="1">★☆☆☆☆</option>
		</select>
		<textarea name="review_content" placeholder="내용을  입력하세요." style="height: 30px; width: 250px; margin-left: 60px;"></textarea>
		<br>
		<br> 
		<input type="submit" value="글쓰기" style="margin-left: 150px; width: 60px; height: 30px" onclick="fn_review()">
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

	<!-- Start Style Switcher -->
	<div class="switcher"></div>
	<!-- End Style Switcher -->
</body>
</html>
