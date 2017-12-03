<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html class="no-js" lang="en"> <!--<![endif]-->
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>회원 정보</title>
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

                                    <li><a href="#">주문배송 관리</a>

                                    </li>

                                    <li><a href="/admin/notiList">게시판 관리</a>
                                         
                                    </li>

                                    <li><a href="#">매출정산 관리</a>
                                        
                                    </li>

                                    <li><a href="#">접속통계 관리</a>
                                        
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
							<h2>회원등급</h2>
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

	<!-- 	<form action="/board/personDetail" method="post"> -->


			<form role="form" action="personModify" method="post">		
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
			<tr>
		<tr>
 			<td align="center" height="30">${personVO.person_id }</td>
			<td align="center" height="30">${personVO.person_email }</td>
			<td align="center" height="30">${personVO.person_name }</td>
			<td align="center" height="30">${personVO.person_address }</td>
			<td align="center" height="30">${personVO.person_phone }</td>
			<td align="center" height="30">${personVO.person_mileage }</td>
			<td align="center" height="30">
				<select id="person_sell_grade" >
					<option value="U">U</option>	
					<option value="M">M</option>	
					<option value="D">D</option>	
               </select>
               
   															
               	<br>
               </td>
			<td align="center">
				<select id="person_kind" >
                       <option value="A">A</option>
<%--                        <option value="A"<c:out value="${person_kind eq 'A'?'selected':'' }" />>A</option> --%>
                       <option value="N">N</option>
<%--                        <option value="N"<c:out value="${person_kind eq 'N'?'selected':'' }" />>N</option> --%>
                       <option value="B">B</option>
                      <%--  <option value="B"<c:out value="${person_kind eq 'B'?'selected':'' }" />>B</option> --%>
                       <option value="R">R</option>
                      <%--  <option value="R"<c:out value="${person_kind eq 'R'?'selected':'' }" />>R</option> --%>
               </select>
            </td>
	</table>


 					<input type='hidden' name='person_id' value="${personVO.person_id }">
  					<input type='hidden' name='person_kind' value="${personVO.person_kind }">
 					<input type='hidden' name='person_sell_grade' value="${personVO.person_sell_grade }"> 
 					<input type='hidden' name='page' value="${cri.page}">
					<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}"> 
					<button type="submit" value="정보수정" id="modifyBtn">수정</button>		
					<button type="submit" value="회원삭제" id="removeBtn">삭제</button>	
			</form>
		
			<div align="center">
				<button type="submit" value="목록" onclick='history.back(-1); return false;'>목록</button> 
			</div>		
		</div>
	</section>
	
	
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

  	
 		$("#modifyBtn").on("click", function(){
 			var formObj = $("form[role=form]").serialize();
			var person_sell_grade = $("#person_sell_grade option:selected").val();
			var person_kind = $("#person_kind option:selected").val();
 
			
		 	var data = {
					person_sell_grade :  person_sell_grade,
					person_kind : person_kind
			};  
 			 
 			alert(data.person_sell_grade);
			alert(data.person_kind);   
			
			
		 	formObj.attr("data", "data");
 			formObj.attr("method", "post");
			formObj.attr("action", "/board/personModify");  
			formObj.submit();
			
			
			/* $.ajax({
				type : "POST",
				url : "/board/personModify",
				dataType : "json",
				data : data,
				headers : {
	                     "Content-Type": "application/json",
	                     "X-HTTP-Method-Override": "POST"
				},
				success : function(data) {
					console.log(data);
					if(data == success){
						alert("성공");
					}
				}
			}) */
			
			
			
 			/*  $.ajax({
 				type : "POST",
 				url : "/board/personModify",
 				dataType : "text",
 				data: JSON.stringify({
					person_sell_grade : person_sell_grade,
					person_kind : person_kind
			}),
 				success : function(result){
 					console.log(result);
 					if(result == 'SUCCESS'){
 						alert("등록");
 					}
 				}
 			})  */
 			
		/* 	
		    formObj.attr("data", data);
			formObj.attr("method", "post");
			formObj.attr("action", "/board/personModify");  
			formObj.submit();	 */		
			
		}); 
	  
		 $("#removeBtn").on("click", function(){
			formObj.attr("method", "post");
			formObj.attr("action", "/board/personRemove");
			formObj.submit();
	}); 
});

</script>

</html>