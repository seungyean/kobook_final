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
<title>매출통계</title>
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
							<h2>Our Services</h2>
						</div>
						<nav id="breadcrumbs">
							<ul>
								<li><a href="index.html">Home </a>/</li>
								<li>Pages</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</section>

		<section class="content faq">
		<form action="modify">

			<div class="container">
				<div class="row">
					<div class="col-lg-8"></div>
				</div>

			<div id="container">
				<div>
				<h2 class="title">게시물 관리</h2>
				</div>
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
					<div id="total">
						<div id="noti"></div>
					</div>

					<button type="button" value="삭제" id="removeBtn" onclick="deleteAction()">삭제</button>

					<div class="box-footer" align="center">
						<div class="text-center">
							<ul class="pagination">

								<c:if test="${pageMaker.prev}">
									<li><a
										href="result${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
								</c:if>

								<c:forEach begin="${pageMaker.startPage }"
									end="${pageMaker.endPage }" var="idx">
									<li
										<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
										<a href="result${pageMaker.makeSearch(idx)}">${idx}</a>
									</li>
								</c:forEach>

								<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
									<li><a
										href="result${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</form>



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
		</section>

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
    <script type="text/javascript" src="/resources/js/jquery.smartmenus.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.smartmenus.bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/js/jflickrfeed.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.magnific-popup.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="/resources/js/swipe.js"></script>
    <script type="text/javascript" src="/resources/js/jquery-scrolltofixed-min.js"></script>
    <script src="/resources/js/main.js"></script>
	
	<script type="text/javascript">

	function selectButton(){
		
			var html = "";
			var noti_select = $("#search option:selected").val();
			var all_check = "";
			var checked = "";

			$.ajax({
						type : "POST",
						url : "/pay/notiList",
						dataType : "json",
						data : {
							noti_select : noti_select
						},
						success : function(data) {

							//선택한것이 신고합니다 일경우 List출력
							if (noti_select == "sin") {

								$("#noti").empty();
								html += "<table class='table table-bordered' style='text-align:center'><tr><td style='width: 10px'><input type='checkbox' id='top_check'></td><td style='width: 5px'>BNO</td><td style='width: 320px'>TITLE</td><td style='width: 20px'>DATE</td><td style='width: 20px'>WRITER</td></tr>";

								$.each(data, function(index, result) {
											html += "<tr><td>" + "<input type='checkbox' id='sub_check' name='sub_check' class='sub_check' value='" + result.black_id + "'>" + "</td>"
											html += "<td>" + result.black_id + "</td>"
											html += "<td><a href='/community/blackRead${pageMaker.makeSearch(pageMaker.cri.page) }&result.black_id=${result.black_id }'>" + result.black_title + "</a>" + "</td>"
											html += "<td>" + result.black_date + "</td>"
											html += "<td>" + result.black_email	+ "</td></tr>"
								});
								html += "</table>";
								$('#noti').append(html);
								
						        //최상단 체크박스 클릭
						        //모든 체크박스 체크
						         $("#top_check").click(function(){
						        	 all_check = $("#top_check").prop("checked");
											$("input[name=sub_check]").prop("checked", all_check);
											
								//최상단 체크박스 클릭시 각 리스트 BNO값			
								$("input[name=sub_check]:checked").each(function(){
									checked = $(this).parent().next().text();
									})
						        })
						        
						        //선택한 체크박스 BNO값 불러오기
						        $("input[name=sub_check]").click(function(){
						        	 $(this).each(function(){
						        		 checked = $(this).parent().next().text();
						        	}) 
						        })    
						        
							} else if (noti_select == "gong") {

								$("#noti").empty();
								html += "<table class='table table-bordered' style='text-align:center'><tr><td style='width: 10px'><input type='checkbox' id='top_check'></td><td style='width: 5px'>BNO</td><td style='width: 320px'>TITLE</td><td style='width: 20px'>DATE</td><td style='width: 20px'>WRITER</td></tr>";
								$.each(data, function(index, result) {
									html += "<tr><td>" + "<input type='checkbox' name='sub_check' class='sub_check' value='" + result.board_id + "'>" + "</td>"
									html += "<td>" + result.board_id + "</td>"
									html += "<td>" + result.board_title	+ "</td>"
									html += "<td>" + result.board_date	+ "</td>"
									html += "<td>" + result.board_writer + "</td></tr>"
								});
								html += "</table>";
								$('#noti').append(html);
								
						        $("#top_check").click(function(){
									var check = $("#top_check").prop("checked");
												$("input[name=sub_check]").prop("checked", check);
							        })

							} else if (noti_select == "mu") {

								$("#noti").empty();
								html += "<table class='table table-bordered' style='text-align:center'><tr><td style='width: 10px'><input type='checkbox' id='top_check'></td><td style='width: 5px'>BNO</td><td style='width: 320px'>TITLE</td><td style='width: 20px'>DATE</td><td style='width: 20px'>WRITER</td></tr>";
								$.each(data, function(index, result) {
									html += "<tr><td>" + "<input type='checkbox' name='sub_check' class='sub_check' value='" + result.donate_id + "'>" + "</td>"
									html += "<td>" + result.donate_id + "</td>"
									html += "<td>" + result.donate_title	+ "</td>"
									html += "<td>" + result.donate_date + "</td>"
									html += "<td>" + result.person_id + "</td></tr>"
									
								});
								html += "</table>";
								$('#noti').append(html);
								
						        $("#top_check").click(function(){
									var check = $("#top_check").prop("checked");
												$("input[name=sub_check]").prop("checked", check);

							        })
							}
						}
					});

		}

	//삭제 버튼을 누를경우 	
	function deleteAction(){
		var myArray = [];
		var noti_select = $("#search option:selected").val();
		var count = 0;
		
		checkList = document.getElementsByName("sub_check");
		
		for(var i=0; i<checkList.length; i++){ 
			if(checkList[i].checked){
				var val = checkList[i].value;
				console.log("val: " + val);
				
				$.ajax({
					type : "POST",
					url : "/pay/notiRemove",
					dataType : "json",
					data : {kind:noti_select, num:val},
					success : function(data){
							if(data == 'SUCCESS'){
								alert("씨발");
								
							}
						}
					});
				}
			}	
			
			selectButton();
		 
		}
	</script>
	
</body>
</html>
