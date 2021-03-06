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
<title>Kobook/photoReview</title>
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

.uploadedList li {
	display: inline-block;
}

.fa-thumbs-o-up {
	color: blue;
}

.fa-thumbs-o-down {
	color: red;
}

.fa-heart {
	color: red;
}

.fa-heart-o {
	color: red;
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
							<h2>포토 리뷰 상세보기</h2>
						</div>
						<nav id="breadcrumbs">
							<ul>
								<li><a href="/">홈</a>/</li>
								<li>커뮤니티 /</li>
								<li>포토 리뷰</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</section>
		<!-- 여기서부터 -->
		<section class="content portfolio_single">
			<div class="container">
				<form role="form" action="photoReviewModify" method="post">
					<input type='hidden' name='photo_id' value="${photoVO.photo_id}">
					<input type='hidden' name='page' value="${cri.page}"> <input
						type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">
				</form>
				<div class="row sub_content">
					<div class="col-lg-8 col-md-8 col-sm-8">
						<!--Project Details Page-->

						<div class="porDetCarousel">
							<div class="carousel-content">
								<img class="thumbnail" alt="NO Thumbnail"
									src="/community/displayFile?fileName=${photoVO.photo_thumbnail }"
									height="500" width="700">
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-4 col-sm-4">
						<div class="project_details">
							<div class="widget_title">
								<h4>
									<span>${photoVO.photo_title }</span>
								</h4>
							</div>
							<ul class="details">
								<li><span><i class="fa fa-user"></i> 작성자 :</span>${writer}</li>
								<li><span><i class="fa fa-file-text"></i> 내용 :</span>
									${photoVO.photo_content }</li>
								<li><span><i class="fa fa-calendar"></i> 작성일 :</span> <fmt:formatDate
										value="${photoVO.photo_date }" pattern="MM月 dd日, yyyy年" /></li>
								<li><span><i class="fa fa-heart"></i> 좋아요 :</span>
									${photoVO.photo_heart }</li>
								<li><span><i class="fa fa-eye"></i> 조회수 :</span>${photoVO.photo_hit }</li>
							</ul>
							<c:if test="${person_id != -1 }">
								<c:if test="${photoVO.photo_heart==0 }">
									<button type="submit" id="heartUp">
										<i class="fa fa-heart"></i> <b> 추천</b>
									</button>
								</c:if>
								<c:if test="${photoVO.photo_heart>0 }">
									<button type="submit" id="heartUp">
										<i class="fa fa-heart"></i> <b> 추천</b>
									</button>
									<button type="submit" id="heartDown">
										<i class="fa fa-heart-o"> </i><b> 추천 </b>
									</button>
								</c:if>
							</c:if>
							<c:if test="${photoVO.person_id == person_id }">
								<button type="submit" class="btn btn-warning" id="modifyBtn">수정</button>
								<button type="submit" class="btn btn-danger" id="removeBtn">삭제</button>
							</c:if>
							<button type="submit" class="btn btn-primary" id="goListBtn">목록으로</button>
						</div>
					</div>
					<a href="javascript:photoPrev();">&lt;&nbsp;&nbsp;이전글</a>
					<div align="right">
						<a href="javascript:photoNext();">다음글&nbsp;&nbsp;&gt;</a>
					</div>
				</div>
				<div class='popup back' style="display: none;"></div>
				<div id="popup_front" class='popup front' style="display: none;">
					<img id="popup_img">
				</div>
				<ul class="mailbox-attachments clearfix uploadedList">
				</ul>
			</div>
		</section>
		<!-- 여기까지 -->
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
	<script type="text/javascript" src="/resources/js/styleswitch.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery.smartmenus.min.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery.smartmenus.bootstrap.min.js"></script>
	<!-- <script type="text/javascript" src="/resources/js/owl.carousel.js"></script> -->
	<script type="text/javascript" src="/resources/js/jflickrfeed.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery.magnific-popup.min.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery.isotope.min.js"></script>
	<script type="text/javascript" src="/resources/js/swipe.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery-scrolltofixed-min.js"></script>

	<script src="/resources/js/main.js"></script>
	<script type="text/javascript" src="/resources/js/upload.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<script id="templateAttach" type="text/x-handlebars-template">
<li data-src='{{fullName}}'>
<div class="mailbox-attachment-info">
<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}
  <span class="mailbox-attachment-icon has-img"><br><img src="{{imgsrc}}" alt="Attachment" height="200" width="200"></span>
</a>
  </div>
</li>
</script>
	<script type="text/javascript">
		$(function() {
			var formObj = $("form[role='form']");

			$("#modifyBtn").on("click", function() {
				formObj.attr("action", "/community/photoReviewModify");
				formObj.attr("method", "get");
				formObj.submit();
			});

			$("#removeBtn").on("click", function() {
				var arr = [];
				$(".uploadedList li").each(function(index) {
					arr.push($(this).attr("data-src"));
				});

				if (arr.length > 0) {
					$.post("/community/deleteAllFiles", {
						files : arr
					}, function() {

					});
				}

				formObj.attr("action", "/community/photoReviewRemove");
				formObj.submit();
			});

			$("#goListBtn").on("click", function() {
				formObj.attr("method", "get");
				formObj.attr("action", "/community/photoReviewList");
				formObj.submit();
			});

			var photo_id = ${photoVO.photo_id};
			
			var template = Handlebars.compile($("#templateAttach").html());

			$("#heartUp").on("click", function() {
				event.preventDefault();
				if (confirm("추천하시겠습니까?")) {
					$.ajax({
						url : '/community/photoHeartUp/' + photo_id,
						type : 'POST',
						dataType : 'text',
						success : function(result) {
							if (result == 'success') {
								formObj.attr("action", "/community/photoReviewRead?photo_id=" + photo_id);
								formObj.attr("method", "get");
								formObj.submit();
							}
						}
					});
				} else {
					alert('추천하기 취소하셨습니다');
				}
				
			});

			$("#heartDown").on("click", function() {
				event.preventDefault();
				if (confirm("추천 해제하시겠습니까?")) {
					$.ajax({
						url : '/community/photoHeartDown/' + photo_id,
						type : 'POST',
						dataType : 'text',
						success : function(result) {
							if (result == 'success') {
								alert("추천 해제 성공");
								formObj.attr("action", "/community/photoReviewRead?photo_id=" + photo_id);
								formObj.attr("method", "get");
								formObj.submit();
							}
						}
					});
				} else {
					alert('추천상태가 유지됩니다');
				}
			});

			$.getJSON("/community/photoGetAttach/" + photo_id, function(list) {
				$(list).each(function() {

					var fileInfo = getFileInfo(this);

					var html = template(fileInfo);

					$(".uploadedList").append(html);

				});
			});

			$(".uploadedList").on("click", ".mailbox-attachment-info a",
					function(event) {

						var fileLink = $(this).attr("href");

						if (checkImageType(fileLink)) {

							event.preventDefault();

							var imgTag = $("#popup_img");
							imgTag.attr("src", fileLink);

							console.log(imgTag.attr("src"));

							$(".popup").show('slow');
							imgTag.addClass("show");
						}
					});

			$(".thumbnail").on("click", function(event) {
				event.preventDefault();
				var str = $(this).attr("src");
				var str2 = str.split("s_");
				var str3 = str2[0] + str2[1];
				var imgTag = $("#popup_img");
				imgTag.attr("src", str3);

				$(".popup").show('slow');
				imgTag.addClass("show");
			});

			$("#popup_img").on("click", function() {
				$(".popup").hide('slow');
			});

			$(".back").on("click", function() {
				$(".popup").hide('slow');
			});
		});

		var photo_id = ${photoVO.photo_id}

		function photoPrev() {
			$.ajax({
				type : 'GET',
				url : '/community/photoPrev/' + photo_id,
				dataType : 'text',
				success : function(data) {
					if (data != -1) {
						self.location = "/community/photoReviewRead?photo_id="
								+ data;
					} else {
						alert("이전 글이 존재하지 않습니다.");
					}
				}
			});
		}

		function photoNext() {
			$.ajax({
				type : 'GET',
				url : '/community/photoNext/' + photo_id,
				dataType : 'text',
				success : function(data) {
					if (data != -1) {
						self.location = "/community/photoReviewRead?photo_id=" + data;
					} else {
						alert("다음 글이 존재하지 않습니다.");
					}
				}
			});
		}
	</script>

	<!-- Start Style Switcher -->
	<div class="switcher"></div>
	<!-- End Style Switcher -->
</body>
</html>