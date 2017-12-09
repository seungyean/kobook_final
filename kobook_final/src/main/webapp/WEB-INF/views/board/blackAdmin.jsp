<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html class="no-js" lang="en"> <!--<![endif]-->
<head>
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
    
<script type="text/javascript">
function delete_fn(){
	location.href = "/kobook/admin/delete.do?person_id=${person.person_id}";
}
</script>    
    
</head>
<body>

<!--Start Header-->
    <header id="header">
        <div id="top-bar">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 top-info hidden-xs">
                        <span><i class="fa fa-phone"></i>Phone: (123) 456-7890</span>
                        <span><i class="fa fa-envelope"></i>Email: mail@example.com</span>
                    </div>
                    <div class="col-sm-4 top-info">
                        <ul>
                            <li><a href="" class="my-tweet"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="" class="my-facebook"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="" class="my-skype"><i class="fa fa-skype"></i></a></li>
                            <li><a href="" class="my-pint"><i class="fa fa-pinterest"></i></a></li>
                            <li><a href="" class="my-rss"><i class="fa fa-rss"></i></a></li>
                            <li><a href="" class="my-google"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="logo-bar">
            <div class="container">
                <div class="row">
                    <!-- Logo / Mobile Menu -->
                    <div  class="col-lg-3 col-sm-3 ">
                        <div id="logo">
                           <h1><a href="/admin/adminMain">관리자WORLD</a></h1>
                        </div>
                    </div>
                    <!-- Navigation
    ================================================== -->
                    <div class="col-lg-9 col-sm-9">
                        <div class="navbar navbar-default navbar-static-top" role="navigation">
                            <!--  <div class="container">-->
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div class="navbar-collapse collapse">
                                <ul class="nav navbar-nav">
                                    <li><a href="/board/personList">회원관리</a>
                                    </li>

                                    <li><a href="/book/delivery">주문배송 관리</a>

                                    </li>

                                    <li><a href="/admin/notiList">게시판 관리</a>
                                         
                                    </li>

                                    <li><a href="/admin/payList">매출정산 관리</a>
                                        
                                    </li>

                                    <li><a href="/admin/analyze">접속통계 관리</a>
                                        
                                    </li>
                                   
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
							<h2>블랙회원 관리</h2>
						</div>
						<nav id="breadcrumbs">
							<ul>
								<li><a href="/kobook/admin/blackUser.do">블랙회원</a>/</li>
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

		<form action="blackPerson" method="post">

		<table border="1" cellpadding ="0" cellspacing ="0" >
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
		<c:forEach var="b" items="${list }">
		<tr>
			<td align="center" height="30">${b.person_id }</td> 
			<td align="center" height="30">${b.person_email }</td>
			<td align="center" height="30">${b.person_name }</td>
			<td align="center" height="30"><a
			href="/kobook/admin/detail.do?person_id=${b.person_id}">${b.person_address}</a>
			<td align="center" height="30">${b.person_phone }</td>
			<td align="center" height="30">${b.person_mileage }</td>
			<td align="center" height="30">${b.person_sell_grade }</td>
			<td align="center" height="30">${b.person_kind }</td>
		</tr>	
		</c:forEach>
	</table>
	</form>

			<!-- 페이징 처리 영역 -->

			<!-- 이전(기준은 start page) -->
			<c:if test="${personModel.startPage > 5 }">
				<a
					href="/kobook/admin/blackUser.do?pageNum=${personModel.startPage - 1 }">[이전]</a>
			</c:if>

			<div id="tab1" >
					<select name="searchType" id="search">
						<option value="n"
							<c:out value="${cri.searchType == null?'selected':''}"/>>
							---</option>
						<option value="sin"
							<c:out value="${cri.searchType eq 'sin'?'selected':''}"/>>
							신고합니다.</option>
						<option value="mu"
							<c:out value="${cri.searchType eq 'mu'?'selected':''}"/>>
							무료나눔</option>
						<option value="pho"
							<c:out value="${cri.searchType eq 'pho'?'selected':''}"/>>
							포토리뷰</option>
						<option value="gong"
							<c:out value="${cri.searchType eq 'gong'?'selected':''}"/>>
							공지사항</option>
					</select> 
					<input type="text" name='keyword' id="keywordInput" value='${cri.keyword }'> 
					<input type="button" value="검색" id="search" onclick="selectButton()" />
			</div>

			<br>
<!-- 			<form action="/kobook/admin/listUser.do" method="post">
				<input type="hidden" name="temp" value="temp" /> <input
					type="checkbox" name="area" value="person_id" />아이디 <input
					type="checkbox" name="area" value="person_name" />회원이름 <input
					type="text" name="searchKey" size="10" placeholder="검색하세요"></input> <input
					type="submit" value="검색" />
			</form> -->

	
<%-- 	<br>
		회원삭제 
			<input type="button" value="회원삭제" onclick="delete_fn()"> 

	
		회원등급/분류 변경
			<input name="user_id" value="${user.user_id }" type="hidden"/>
			<input name="user_sell_grade" value="${user.user_sell_grade }" type="hidden"/>
			<input name="user_kind" value="${user.user_kind }" type="hidden" />
			<input type="submit" value="정보수정">
		</form> --%>

</body>
</html>