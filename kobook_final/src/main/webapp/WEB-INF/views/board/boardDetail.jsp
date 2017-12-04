<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%
int cur_id = Integer.parseInt((String) session.getAttribute("person_id"));
System.out.println("리스트 cur_id: " + cur_id); 
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
<title>Electrify Responsive Multipurpose Template</title>
<meta name="description" content="">

<!-- CSS FILES -->
 <!-- CSS FILES -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css" media="screen" data-name="skins">
    <link rel="stylesheet" href="/resources/css/layout/wide.css" data-name="layout">

<link rel="stylesheet" type="/resources/text/css"
	href="/resources/css/switcher.css" media="screen" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="home">
	<!--Start Header-->
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
							<h2>FAQ</h2>
						</div>
						<nav id="breadcrumbs">
							<ul>
								<li><a href="/resources/admin/noti.jsp">Home</a>/</li>
								<li>Pages</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</section>
	</section>

	<section class="content faq">
		<div class="container">
			<div class="row">
				<div class="col-lg-8"></div>
			</div>


			<h4>공지사항 세부</h4>
			<pre>	
			<table class="table table-bordered" style="text-align: center;">
			<tr height="50">
					<td align="left" width="700">글제목 : ${boardVO.board_title }</td>
					<td width="200" align="right">날짜 : <fmt:formatDate
								value="${boardVO.board_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				<tr height="50">
					<td align="left" width="700">작성자 : ${boardVO.board_writer }</td>
					<td align="right" width="200">조회수 : ${boardVO.board_hit }</td>
				</tr>
				<tr height="300">
					<td colspan="2" align="left">${boardVO.board_content }</td>
				</tr>
			</table>
			</pre>


<%
	if(session.getAttribute("person_id") != null){
	int cur_id = Integer.parseInt((String) session.getAttribute("person_id"));
	if(cur_id==1){
%>	
			<div class="box-footer">			
			<form role="form" action="modify" method="post">
 					<input type='hidden' name='board_id' value="${boardVO.board_id }">
					<input type='hidden' name='page' value="${cri.page}">
					<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">
					<button type="submit" value="삭제" id="removeBtn">삭제</button>	
					<button type="submit" value="수정" id="modifyBtn">수정</button>			
			</form>
<%
	}
	}else{
%>
<%
	}
%>			
			
			<div align="center">
				<button type="submit" value="목록" onclick='history.back(-1); return false;'>목록</button> 
			</div>
			</div>
			
			<!--Sidebar Widget-->
			<div class="col-lg-4">
				<div class="sidebar">
					<div class="widget widget_search">
						<div class="site-search-area">
							<!-- <form method="get" id="site-searchform" action="#">
										<div>
											<input class="input-text" name="s" id="s" placeholder="Enter Search keywords..." type="text" />
											<input id="searchsubmit" value="Search" type="submit" />
										</div>
									</form> -->
						</div>
						<!-- end site search -->
					</div>
				</div>
			</div>
		</div>
	</section>

	<!--end wrapper-->


	<script type="text/javascript" src="/resources/js/jquery-1.10.2.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/jquery.easing.1.3.js"></script>
    <script src="/resources/js/retina-1.1.0.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.cookie.js"></script> <!-- jQuery cookie -->
    <script type="text/javascript" src="/resources/js/styleswitch.js"></script> <!-- Style Colors Switcher -->
    <script type="text/javascript" src="/resources/js/jquery.smartmenus.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.smartmenus.bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/js/jflickrfeed.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.magnific-popup.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="/resources/js/swipe.js"></script>
    <script type="text/javascript" src="/resources/js/jquery-scrolltofixed-min.js"></script>

	<script type="text/javascript" src="/resources/js/upload.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
    <script src="/resources/js/main.js"></script>

</body>
<script>
 
	var result = '${msg}';

if (result == 'SUCCESS') {
	alert("처리가  완료되었습니다.");
	location.replace(self.location);
}

$(document).ready(function(){
	var formObj = $("form[role='form']");
	console.log(formObj);
  	
 	$("#modifyBtn").on("click", function(){
 		formObj.attr("method", "get"); 
    	formObj.attr("action", "/board/boardModify"); 
		formObj.submit();
	}); 
	  
	$("#removeBtn").on("click", function(){
		formObj.attr("method", "post");
		formObj.attr("action", "/board/boardRemove");
		formObj.submit();
	});
});

</script>

</html>
