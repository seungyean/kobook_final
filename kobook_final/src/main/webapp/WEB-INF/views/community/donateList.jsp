<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Kobook/donate</title>
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />

 <!-- CSS FILES -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css" media="screen" data-name="skins">
    <link rel="stylesheet" href="/resources/css/layout/wide.css" data-name="layout">

    <link rel="stylesheet" type="text/css" href="/resources/css/switcher.css" media="screen" />
    <style type="text/css">
    .popup {position: absolute;}
    .back { background-color: gray; opacity:0.5; width: 100%; height: 300%; overflow:hidden;  z-index:1101;}
    .front { 
       z-index:1110; opacity:1; boarder:1px; margin: auto; 
      }
     .show{
       position:relative;
       max-width: 900px; 
       max-height: 500px; 
       overflow: auto;       
     } 
  	
    </style>
</head>
<body class="home">
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
							<h2>무료 나눔 게시판</h2>
						</div>
						<nav id="breadcrumbs">
							<ul>
								<li><a href="/">홈</a>/</li>
								<li>커뮤니티 /</li>
								<li>무료나눔</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</section>

		<section class="content typography">
			<div class="container">
				<div class="row sub_content">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="dividerHeading">
							<h4>
								<span>무료 나눔 리스트</span>
							</h4>
							<br> <br>
    <div class='popup back' style="display:none;"></div>
    <div id="popup_front" class='popup front' style="display:none;">
     <img id="popup_img">
    </div>
    
												
							<form action="/community/donateRegist" method="get">
								<table class="table table-hover">
									<thead>
										<tr>
											<td align="center">No</td>
											<td align="center">이미지</td>
											<td>글 제목</td>
											<td align="center">작성자</td>
											<td align="center">작성일</td>
											<td align="center">조회수</td>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="donate" items="${list}">
											<tr>
												<td align="center">${donate.donate_id}</td>
												<%-- <td align="center"><a
													href="/community/donateRead?donate_id=${donate.donate_id}"> <c:if
															test="${donate.donate_img != null }">
															<c:set var="head"
																value="${fn:substring(donate.donate_img, 0, fn:length(donate.donate_img)-4) }"></c:set>
															<c:set var="pattern"
																value="${fn:substring(donate.donate_img, fn:length(head) +1, fn:length(donate.donate_img)) }"></c:set>

															<c:choose>
																<c:when
																	test="${pattern == 'jpg' || pattern == 'gif' || pattern == 'png'}">
																	<img src="../upload/${head }_small.${pattern}" height="100" width="120">
																</c:when>
															</c:choose>
														</c:if> <c:if test="${donate.donate_img == null }">
															<img alt="NO IMAGE" src="">
														</c:if>
												</a></td> --%>
												<td><a
													href="/community/donateRead?donate_id=${donate.donate_id}">${donate.donate_title }</a></td>
												<td align="center">${donate.person_id}</td>
												<td align="center"><fmt:formatDate
														value="${donate.donate_date }" pattern="yyyy-MM-dd" /></td>
												<td align="center">${donate.donate_hit }</td>

											</tr>
										</c:forEach>
									</tbody>
								</table>
								<input type="submit" value="글쓰기" class="btn-default">
							</form>
							<ul class="mailbox-attachments clearfix uploadedList">
							 					</ul>
				<!-- Search Form -->
				<div class='box-body' align="right">

					<select name="searchType">
						<option value="n"
							<c:out value="${cri.searchType == null?'selected':''}"/>>
							---</option>
						<option value="t"
							<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
							제목</option>
						<option value="c"
							<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
							내용</option>
						<option value="tc"
							<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
							제목 + 내용</option>
					</select><input type="text" name="keyword" id="keywordInput" value='${cri.keyword }' placeholder="Enter Search keywords..." size="25">
					<button id='searchBtn' class="btn-default">  <i class="fa fa-search"></i>  </button>
				</div>
				
				<!-- 페이징 -->
							<div class="col-sm-12 text-center">
								<ul class="pagination">
							<c:if test="${pageMaker.prev}">
								<li><a
									href="donateList${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }" var="idx">
								<li
									<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
									<a href="donateList${pageMaker.makeSearch(idx)}">${idx}</a>
								</li>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a
									href="donateList${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
							</c:if>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
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
	
	<script type="text/javascript" src="/resources/js/upload.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>   
<script id="templateAttach" type="text/x-handlebars-template">
<li data-src='{{fullName}}'>
<div class="mailbox-attachment-info">
<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}
  <span class="mailbox-attachment-icon has-img"><br><img src="{{imgsrc}}" alt="Attachment"></span>
</a>
  </div>
</li>
</script>
    <script type="text/javascript">
	$(function() {
				$('#searchBtn').on(
						"click",
						function(event) {

							self.location = "donateList"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keywordInput').val();

						});

			});

 	var donate_id = 11;
	var template = Handlebars.compile($("#templateAttach").html());
	
	$.getJSON("/community/donateGetAttach/"+donate_id,function(list){
		$(list).each(function(){
			
			var fileInfo = getFileInfo(this);
			
			var html = template(fileInfo);
			
			 $(".uploadedList").append(html);
			
		});
	});

	$(".uploadedList").on("click", ".mailbox-attachment-info a", function(event){
		
		var fileLink = $(this).attr("href");
		
		if(checkImageType(fileLink)){
			
			event.preventDefault();
					
			var imgTag = $("#popup_img");
			imgTag.attr("src", fileLink);
			
			console.log(imgTag.attr("src"));
					
			$(".popup").show('slow');
			imgTag.addClass("show");		
		}	
	});
	
	$("#popup_img").on("click", function(){
		
		$(".popup").hide('slow');
		
	});
	</script>
	<!-- Start Style Switcher -->
	<div class="switcher"></div>
	<!-- End Style Switcher -->
</body>
</html>