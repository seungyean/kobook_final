<%-- <%@page import="resources.admin.domain.PersonModel"%>
<%@page import="resources.admin.domain.ListModel"%>
<%@page import="resources.admin.domain.Search"%>
<%@page import="resources.admin.action.GradeUpdateAction"%>
<%@page import="resources.admin.action.ListPersonAction"%>

<%@page import="java.util.List"%>
<%@page import="resources.admin.domain.Person"%>
<%@page import="resources.admin.dao.PersonDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	PersonModel personModel = (PersonModel) request.getAttribute("personModel");
	request.getSession().getAttribute("person_id");
%> --%>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Electrify Responsive Multipurpose Template</title>
<meta name="description" content="">

<!-- CSS FILES -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resources/css/style.css">
<link rel="stylesheet" type="/resources/text/css"
	href="/resources/css/style.css" media="screen" data-name="skins">
<link rel="stylesheet" href="/resources/css/layout/wide.css"
	data-name="layout">

<link rel="stylesheet" type="/resources/text/css"
	href="/resources/css/switcher.css" media="screen" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!--Start Header-->
	<header id="header">
		<div id="top-bar">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 top-info hidden-xs">
						<span><i class="fa fa-phone"></i>Phone: (123) 456-7890</span> <span><i
							class="fa fa-envelope"></i>Email: mail@example.com</span>
					</div>
					<div class="col-sm-4 top-info">
						<ul>
							<li><a href="" class="my-tweet"><i class="fa fa-twitter"></i></a></li>
							<li><a href="" class="my-facebook"><i
									class="fa fa-facebook"></i></a></li>
							<li><a href="" class="my-skype"><i class="fa fa-skype"></i></a></li>
							<li><a href="" class="my-pint"><i
									class="fa fa-pinterest"></i></a></li>
							<li><a href="" class="my-rss"><i class="fa fa-rss"></i></a></li>
							<li><a href="" class="my-google"><i
									class="fa fa-google-plus"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="logo-bar">
			<div class="container">
				<div class="row">
					<!-- Logo / Mobile Menu -->
					<div class="col-lg-3 col-sm-3 ">
						<div id="logo">
							<h1>
								<a href="/resources/admin/noti.jsp"><img alt="resources - 관리자"
									src="/resources/images/logo.png" /></a>
							</h1>
						</div>
					</div>
					<!-- Navigation
    ================================================== -->
					<div class="col-lg-9 col-sm-9">
						<div class="navbar navbar-default navbar-static-top"
							role="navigation">
							<!--  <div class="container">-->
							<div class="navbar-header">
								<button type="button" class="navbar-toggle"
									data-toggle="collapse" data-target=".navbar-collapse">
									<span class="sr-only">Toggle navigation</span> <span
										class="icon-bar"></span> <span class="icon-bar"></span> <span
										class="icon-bar"></span>
								</button>
							</div>
							<div class="navbar-collapse collapse">
								<ul class="nav navbar-nav">
									<li><a href="/resources/admin/listUser.do">회원관리</a>
										<ul class="dropdown-menu">
											<li><a href="index.html">회원수정</a></li>
											<li><a href="index_2.html">회원등급</a></li>
											<li><a href="index_3.html">회원분류</a></li>
										</ul></li>

									<li><a href="#">게시판관리(미구현)</a>
										<ul class="dropdown-menu">
											<li><a href="elements.html">게시판 1</a></li>
											<li><a href="form-elements.html">게시판 2</a></li>
											<li><a href="columns.html">게시판 3</a></li>
										</ul></li>

									<li class="active"><a href="#">안전거래관리(미구현)</a>
										<ul class="dropdown-menu">
											<li><a href="about.html">About</a>
												<ul class="dropdown-menu">
													<li><a href="about.html">About Us 1</a></li>
													<li><a href="about-2.html">About Us 2</a></li>
												</ul></li>
											<li><a href="services.html">Services</a></li>
											<li class="active"><a href="faq.html">FAQ</a></li>
											<li><a href="sidebar-right.html">Right Sidebar</a></li>
											<li><a href="sidebar-left.html">Left Sidebar</a></li>
											<li><a href="404-page.html">404 Page</a></li>
										</ul></li>

									<li><a href="/resources/admin/notiAdmin.do">공지사항관리</a>
										<ul class="dropdown-menu">
											<li><a href="#">Portfolio Classic</a>
												<ul class="dropdown-menu">
													<li><a href="portfolio_2.html">Portfolio 2</a></li>
													<li><a href="portfolio_3.html">Portfolio 3</a></li>
													<li><a href="portfolio_4.html">Portfolio 4</a></li>
												</ul></li>
										</ul></li>

								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!--End Header-->

	<!--start wrapper-->
	<section class="wrapper">
		<section class="page_head">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="page_title">
							<h2>회원관리</h2>
						</div>
						<nav id="breadcrumbs">
							<ul>
								<li><a href="/resources/admin/blackUser.do">블랙회원</a>/</li>
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
				<div class="col-lg-8">
					<div class="panel-group accordion" id="accordion">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title"></h4>
							</div>

						</div>
					</div>
				</div>
			</div>

			<table border="1" cellpadding="0" cellspacing="0">
				<tr height="50">
					<td width="70" align="center" height="30">회원번호</td>
					<td width="200" align="center" height="30">이메일</td>
					<td width="80" align="center" height="30">이름</td>
					<td width="400" align="center" height="30">주소</td>
					<td width="100" align="center" height="30">번호</td>
					<td width="80" align="center" height="30">마일리지</td>
					<td width="60" align="center" height="30">회원등급</td>
					<td width="60" align="center" height="30">회원분류</td>
				</tr>
				<c:forEach var="p" items="${personModel.list}">
					<c:if test="${p.person_kind != null}">
						<tr>
							<c:choose>
								<c:when test="${p.person_kind != 'B'}">
									<td align="center" height="30">${p.person_id}</td>
									<td align="center" height="30">${p.person_email}</td>
									<td align="center" height="30">${p.person_name}</td>
									<td align="center" height="30"><a
										href="/resources/admin/detail.do?person_id=${p.person_id}">${p.person_address}</a></td>
									<td align="center" height="30">${p.person_phone}</td>
									<td align="center" height="30">${p.person_mileage}</td>
									<td align="center" height="30">${p.person_sell_grade}</td>
									<td align="center" height="30">${p.person_kind}</td>
								</c:when>
							</c:choose>
						</tr>
					</c:if>
				</c:forEach>
			</table>

			<!-- 페이징 처리 영역 -->

			<!-- 이전(기준은 start page) -->
			<c:if test="${personModel.startPage > 5 }">
				<a
					href="/resources/admin/listUser.do?pageNum=${personModel.startPage - 1 }">[이전]</a>
			</c:if>

			<!-- 페이지 목록 -->
			<c:forEach var="pageNo" begin="${personModel.startPage }"
				end="${personModel.endPage }">
				<c:if test="${personModel.requestPage == pageNo }">
					<b>
				</c:if>
				<a href="/resources/admin/listUser.do?pageNum=${pageNo }">[${pageNo }]</a>
				<c:if test="${personModel.requestPage == pageNo }">
					</b>
				</c:if>
			</c:forEach>
			<!-- 이후 -->
			<c:if test="${personModel.endPage < personModel.totalPageCount }">
				<a
					href="/resources/admin/listUser.do?pageNum=${personModel.endPage + 1 }">[이후]</a>
			</c:if>

			<br>
			<form action="/resources/admin/listUser.do" method="post">
				<input type="hidden" name="temp" value="temp" /> <input
					type="checkbox" name="area" value="person_id" />아이디 <input
					type="checkbox" name="area" value="person_name" />회원이름 <input
					type="text" name="searchKey" size="10"></input> <input
					type="submit" value="검색" />
			</form>
		</div>
	</section>

</body>
</html>




