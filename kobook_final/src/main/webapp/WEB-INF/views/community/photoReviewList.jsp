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
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css" media="screen" data-name="skins">
    <link rel="stylesheet" href="/resources/css/layout/wide.css" data-name="layout">

    <link rel="stylesheet" type="text/css" href="/resources/css/switcher.css" media="screen" />
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
							<h2>포토 리뷰 게시판</h2>
						</div>
						<nav id="breadcrumbs">
							<ul>
								<li><a href="/">홈</a>/</li>
								<li>커뮤니티 /</li>
								<li>포토리뷰</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</section>
		<!-- 여기서부터 -->
		<section class="content portfolio medium-images">
			<div class="container">
				<!-- <div class="row sub_content"> -->
					<!--begin isotope -->
					<form action="/community/photoReviewRegist" method="get">
					<div class="col-lg-12 isotope">
					
                    <!--begin portfolio filter -->
<!--                     <ul id="filter">
                        <li data-filter="*" class="selected"><a href="#">All</a></li>
                        <li data-filter=".responsive"><a href="#">Responsive</a></li>
                        <li data-filter=".mobile"><a href="#">Mobile</a></li>
                        <li data-filter=".branding"><a href="#">Branding</a></li>
                    </ul> -->
                    <!--end portfolio filter -->
						<!--begin portfolio_masonry -->
						<ul id="list" class="portfolio_list clearfix ">
							<c:forEach var="photo" items="${list}">
						<li class="list_item col-lg-3 col-md-4 col-sm-6">
						<!-- <div class="mixed-container masonry_wrapper"> 
							<div class="item responsive">-->
								<div class="recent-item box">
									<figure class="touching ">
										<img src="/community/displayFile?fileName=${photo.photo_thumbnail}"
											alt="NO IMAGE" height="280" width="500" />
										<a href="/community/photoReviewRead${pageMaker.makeSearch(pageMaker.cri.page) }&rn=${photo.rn }&photo_id=${photo.photo_id }">
										</a>
										<div class="option inner">
											<div>
												<h5>${photo.photo_title }</h5>
												<a href="/community/displayFile?fileName=${photo.photo_thumbnail}"
													class="fa fa-search mfp-image"></a> <a
													href="/community/photoReviewRead${pageMaker.makeSearch(pageMaker.cri.page) }&rn=${photo.rn }&photo_id=${photo.photo_id}" class="fa fa-link"></a>
													<span>${userMap[photo.photo_id]}</span>
											</div>
										</div>
									</figure>
								</div>
							<!--</div>
						 </div> -->
						</li>
						
							</c:forEach>
						</ul>
							<input type="submit" value="글쓰기" class="btn-default">
						<!--end portfolio_masonry -->
					</div>
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
					</select><input type="text" name="keyword" id="keywordInput" value='${cri.keyword }' placeholder="Enter Search keywords..." size="25">
					<button id='searchBtn' class="btn-default">  <i class="fa fa-search"></i>  </button>
				</div>
				<!-- 페이징 -->
							<div class="col-sm-12 text-center">
								<ul class="pagination">
							<c:if test="${pageMaker.prev}">
								<li><a
									href="photoReviewList${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
							</c:if>
							<c:forEach begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }" var="idx">
								<li
									<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
									<a href="photoReviewList${pageMaker.makeSearch(idx)}">${idx}</a>
								</li>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a
									href="photoReviewList${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
							</c:if>
								</ul>
							</div>
				<!-- </div> -->
				<!--./row-->
			</div>
			<!--./div-->
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
	<!-- jQuery cookie -->
	<script type="text/javascript" src="/resources/js/styleswitch.js"></script>
	<!-- Style Colors Switcher -->
	<script src="/resources/js/jquery.fractionslider.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="/resources/js/jquery.smartmenus.min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.smartmenus.bootstrap.min.js"></script>
	<script type="text/javascript" src="/resources/js/owl.carousel.min.js"></script>
	<script type="text/javascript" src="/resources/js/jflickrfeed.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.magnific-popup.min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.isotope.min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.easypiechart.min.js"></script>
	<script type="text/javascript" src="/resources/js/swipe.js"></script>
	<script type="text/javascript" src="/resources/js/jquery-hoverdirection.min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.matchHeight-min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery-scrolltofixed-min.js"></script>

    <script src="/resources/js/main.js"></script>
    <script type="text/javascript">
	$(function() {
		$('#searchBtn').on("click", function(event) {
			self.location = "photoReviewList" + '${pageMaker.makeQuery(1)}'
							+ "&searchType=" + $("select option:selected").val()
							+ "&keyword=" + $('#keywordInput').val();
		});
	});
	</script>
<!-- 	<script>
    (function ($) {
        var $container = $('.masonry_wrapper'),
                colWidth = function () {
                    var w = $container.width(),
                            columnNum = 1,
                            columnWidth = 0;
                    if (w > 1200) {
                        columnNum  = 3;
                    } else if (w > 900) {
                        columnNum  = 3;
                    } else if (w > 600) {
                        columnNum  = 2;
                    } else if (w > 300) {
                        columnNum  = 1;
                    }
                    columnWidth = Math.floor(w/columnNum);
                    $container.find('.item').each(function() {
                        var $item = $(this),
                                multiplier_w = $item.attr('class').match(/item-w(\d)/),
                                multiplier_h = $item.attr('class').match(/item-h(\d)/),
                                width = multiplier_w ? columnWidth*multiplier_w[1]-4 : columnWidth-4,
                                height = multiplier_h ? columnWidth*multiplier_h[1]*0.5-4 : columnWidth*0.5-4;
                        $item.css({
                            width: width,
                            height: height
                        });
                    });
                    return columnWidth;
                }

        function refreshWaypoints() {
            setTimeout(function() {
            }, 1000);
        }
        function setPortfolio() {
            setColumns();
            $container.isotope('reLayout');
        }

        isotope = function () {
            $container.isotope({
                resizable: true,
                itemSelector: '.item',
                masonry: {
                    columnWidth: colWidth(),
                    gutterWidth: 0
                }
            });
        };
        isotope();
        $(window).smartresize(isotope);
    }(jQuery));
</script> -->
	<!-- Start Style Switcher -->
	<div class="switcher"></div>
	<!-- End Style Switcher -->
</body>
</html>