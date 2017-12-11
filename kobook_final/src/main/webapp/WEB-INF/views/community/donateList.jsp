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
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css"
	media="screen" data-name="skins">
<link rel="stylesheet" href="/resources/css/layout/wide.css"
	data-name="layout">

<link rel="stylesheet" type="text/css"
	href="/resources/css/switcher.css" media="screen" />

<style type="text/css">
.popup {
	position: absolute;
}

.back {
	background-color: gray;
	opacity: 0.5;
	width: 78%;
	height: 31%;
	overflow: hidden;
	z-index: 1101;
}

.front {
	z-index: 1110;
	opacity: 1;
	boarder: 1px;
	margin: auto;
}

.show {
	position: relative;
	max-width: 900px;
	max-height: 500px;
	overflow: auto;
}

#popup_img {
	width: 500%;
	height: 500%;
}

a:HOVER {
	color: red;
}

.layer1 {
	position: absolute;
	padding: 5px;
	filter: alpha(opacity = 50);
	background-color: white;
	border: 2px #000000 solid;
	border-radius: 10px;
	text-align: center;
	width: auto;
	height: auto;
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

							<form action="/community/donateRegist" method="get">
								<table class="table table-hover">
									<thead>
										<tr>
											<td align="center">No</td>
											<td align="center">이미지
												<div id="popup_front" class='popup front'
													style="display: none;">
													<img id="popup_img">
												</div>
											</td>
											<td>글 제목</td>
											<td align="center">작성자</td>
											<td align="center">작성일</td>
											<td align="center">조회수</td>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="donate" items="${list}" varStatus="st">
											<tr class="article" id="${donate.donate_id}">
												<td align="center">${donate.rn}</td>
												<td align="center"><img class="thumbnail"
													alt="NO IMAGE"
													src="/community/displayFile?fileName=${donate.donate_thumbnail }"
													height="100" width="200"></td>
												<td><a class="readMove"
													href="/community/donateRead${pageMaker.makeSearch(pageMaker.cri.page) }&donate_id=${donate.donate_id }">${donate.donate_title }
														<strong>[ ${donate.reply_count} ]</strong>
												</a></td>
												<td align="center">${userMap[donate.donate_id]}</td>
												<td align="center"><fmt:formatDate
														value="${donate.donate_date }" pattern="yyyy-MM-dd" /></td>
												<td align="center"><span class="badge bg-red">${donate.donate_hit }</span></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<c:if test="${person_id != -1 }">
									<input type="submit" value="글쓰기" class="btn-default">
								</c:if>
							</form>
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
								</select><input type="text" name="keyword" id="keywordInput"
									value='${cri.keyword }' placeholder="Enter Search keywords..."
									size="25">
								<button id='searchBtn' class="btn-default">
									<i class="fa fa-search"></i>
								</button>
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
	<script type="text/javascript" src="/resources/js/jquery.cookie.js"></script>
	<!-- jQuery cookie -->
	<script type="text/javascript" src="/resources/js/styleswitch.js"></script>
	<!-- Style Colors Switcher -->
	<script type="text/javascript"
		src="/resources/js/jquery.smartmenus.min.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery.smartmenus.bootstrap.min.js"></script>
	<script type="text/javascript" src="/resources/js/jflickrfeed.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery.magnific-popup.min.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery.isotope.min.js"></script>
	<script type="text/javascript" src="/resources/js/swipe.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery-scrolltofixed-min.js"></script>

	<script src="/resources/js/main.js"></script>

	<script type="text/javascript">
	$(function() {
		$('#searchBtn').on("click", function(event) {
			self.location = "donateList" + '${pageMaker.makeQuery(1)}'
							+ "&searchType=" + $("select option:selected").val()
							+ "&keyword=" + $('#keywordInput').val();
		});
		
		// 모든 글의 a 태그에 마우스 오버 바인딩
		$('.article').mouseenter(function(event) {
			contentprev($(this).attr('id'), event);
		});
		
		$('.article').mouseleave(function(event) {
			event.preventDefault();
			$('.layer1').remove();
		})
		
		// 마우스 오버시 바인딩 될 function
		function contentprev(donate_id, event) {
			
			$.ajax({
				type: 'GET',
				url: '/community/donatePreviewContent?donate_id=' + donate_id,
				dataType: 'text',
				success: function(data) {
					showlayer(data, event);
				}
			});
		}
		
		// showlayer 가 호출된 후 전달받은 마우스 이벤트의 좌표로 레이어를 이동
		function moveTooltip(event) {
			var posX = event.pageX;
			var posY = event.pageY + 20;
			
			$('.layer1').css({top: posY, left: posX});
		}
		
		// 기존 레이어를 삭제 후 새로 레이어를 생성
			function showlayer(value, event) {
			
			$('.layer1').remove();
			$('<div class="layer1">  <b> 본문 내용 </b> : ' + value.replace(/\r\n/gi, '<br>') + '</div>').appendTo('body');
			moveTooltip(event);
		}
		
		
 		$(".thumbnail").on("click", function(event){
 			event.preventDefault();
			var str = $(this).attr("src");
			var str2 = str.split("s_");
			var str3 = str2[0]+str2[1];
	  		var imgTag = $("#popup_img");
	  		
	  		if(str2.length > 1) {
	  			imgTag.attr("src", str3);
	  		}else {
				imgTag.attr("src", str);
			}
			
			$(".popup").show('slow');
			imgTag.addClass("show");
		}); 
	
		$("#popup_img").on("click", function(){		
			$(".popup").hide('slow');		
		});
		
		$(".back").on("click", function(){		
			$(".popup").hide('slow');		
		});
	});
	</script>

	<!-- Start Style Switcher -->
	<div class="switcher"></div>
	<!-- End Style Switcher -->
</body>
</html>