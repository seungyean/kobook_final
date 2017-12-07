<%@page import="com.kobook.alarm.domain.AlarmVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html class="no-js" lang="en"> <!--<![endif]-->
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>KOBOOK</title>
    <meta name="description" content="">

    <!-- CSS FILES -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="resources/css/style.css" media="screen" data-name="skins">
    <link rel="stylesheet" href="resources/css/layout/wide.css" data-name="layout">

    <link rel="stylesheet" href="resources/css/fractionslider.css"/>
    <link rel="stylesheet" href="resources/css/style-fraction.css"/>
    <link rel="stylesheet" href="resources/css/animate.css"/>

    <link rel="stylesheet" type="text/css" href="resources/css/switcher.css" media="screen" />
</head>

<body class="home">	
    <!-- 헤더 -->
 		 <jsp:include page="/WEB-INF/views/include/header.jsp" />
  	<!-- /헤더 -->
    
    <section class="wrapper">
        <div class="slider-wrapper">
            <div class="slider">
                <div class="fs_loader"></div>
                
                <c:forEach var="x" begin="1" end="6">
	                <div class="slide">
	                    <img src="/resources/img/main/main${x }.png" width="1920" height="auto" data-in="fade" data-out="fade" />
	                </div>
                </c:forEach>
                


            </div>
        </div>
	</section>
		<br>
        
<%--         <h2>알림 리스트</h2>
        
        <h4>현재 사용자 : ${person_id}</h4>ㄹ
 	    <c:forEach var="z" items="${alarmList }">
	    	<c:if test="${z.hit_yn == 'N' }">
	             <% alarm_new += 1;%>
	        </c:if> 
	    </c:forEach>
        <h4>새로운 알람의 갯수 : [ <%=alarm_new %> ]</h4>
        
        <table border="1">
			<tr>
				<td>알람아이디</td>
				<td>알림종류</td>
				<td>알림내용</td>
				<td>회원아이디</td>
				<td>조회여부</td>

			</tr>	
			<c:forEach var="a" items="${alarmList }">
			<tr>
				<td>${a.alarm_id }</td>
				<td>${a.alarm_kind }</td>
				<td>${a.alarm_content }</td>
				<td>${a.person_id }</td>
				<td>${a.hit_yn }</td>

			</tr>
			</c:forEach>
		</table> --%>

<%-- 		
<h2>추천도서</h2>
		<table border="1">
			<tr>
				<td>책이름</td>
				<td>책ID</td>
				<td>분야이름</td>
				<td>회원ID</td>
				<td>회원전공여부</td>
				<td>우선순위</td>
				<td>이미지</td>
			</tr>	
			<c:forEach var="f" items="${list }">
			<tr>
				<td>${f.book_name }</td>
				<td>${f.book_id }</td>
				<td>${f.favorite_name }</td>
				<td>${f.person_id }</td>
				<td>${f.favorite_major }</td>
				<td>${f.favorite_rank }</td>
				<td>${f.book_img }</td>

			</tr>
			</c:forEach>
		</table>
		
				<h2>책의 정보</h2>
		<table border="1">
			<tr>
				<td>책이름</td>
				<td>책ID</td>
				<td>이미지</td>

			</tr>	
			<c:forEach var="p" items="${bookList }">
			<tr>
				<td>${p.book_name }</td>
				<td>${p.book_id }</td>
				<td>${p.book_img }</td>

			</tr>
			</c:forEach>
		</table>
		 --%>
		
		<section class="super_sub_content">
            <div class="dividerHeading text-center">
            	<c:choose>
            		<c:when test="${(person_id == 1) || (person_id == -1)}">
            			<h4><span>새로 등록된 도서</span></h4>
            			
			            <div class="portfolio-centered">
				            <div class="recentitems portfolio">
									<c:forEach var="i" items="${bookList }">
										<div class="portfolio-item mockups">
										  <div class="box">
										    	<img src="/book/displayFile?fileName=${i.book_img }" alt="" style="width: 300px; height: 300px;">
										              <div class="option inner">
										                  <div>
										                     <h5>상세보기</h5>
										                     <a href="/book/displayFile?fileName=${i.book_img }" class="fa fa-search mfp-image"></a>
										                     <a href="/book/bookRead?book_id=${i.book_id}" class="fa fa-link"></a>	                  </div>
										               </div>
								     	  </div>
										</div>
									</c:forEach>
							</div>
				        </div>  
            		</c:when>
            		
            		<c:otherwise>
            			<h4>${person_name }님을 위한 추천도서</h4>
            			
            			 <nav class="clearfix">
                			<ul id="filter">
                    			<li data-filter="*" class="selected"><a href="#">전체보기</a></li>
                    			<li data-filter=".mockups"><a href="#">전공</a></li>
                    			<li data-filter=".graphic-design"><a href="#">기타</a></li>
                			</ul>
            			</nav>
            			
			            <div class="portfolio-centered">
			                <div class="recentitems portfolio">
				                <c:forEach var="f" items="${list }">
				
					                <c:if test="${f.favorite_major == 'M' }">
						                	<div class="portfolio-item mockups">
						                        <div class="box">
						                            <img src="/book/displayFile?fileName=${f.book_img }" alt="" style="width: 300px; height: 300px;">
						                            <div class="option inner">
						                                <div>
						                                    <h5>전공 상세보기</h5>
						                                    <a href="/book/displayFile?fileName=${f.book_img }" class="fa fa-search mfp-image"></a>
						                                    <a href="/book/bookRead?book_id=${f.book_id}" class="fa fa-link"></a>
						                                    <a href="/deleteRecom?book_id=${f.book_id }&favorite_major=${f.favorite_major}&favorite_name=${f.favorite_name}" class="fa fa-times"></a>
						                                </div>
						                            </div>
						                        </div>
						                    </div>
			
					                </c:if>
					                
					                
					                <c:if test="${f.favorite_major == 'O' }">
									
									<input type="hidden" id="book_id" value="${f.book_id }">
									
					                	<div class="portfolio-item graphic-design">
					                        <div class="box">
					                            <img src="/book/displayFile?fileName=${f.book_img }" alt="" style="width: 300px; height: 300px;">
					                            <div class="option inner">
					                                <div>
					                                    <h5>기타 상세보기</h5>
					                                    <a href="/book/displayFile?fileName=${f.book_img }" class="fa fa-search mfp-image"></a>
					                                    <a href="/book/bookRead?book_id=${f.book_id}" class="fa fa-link"></a>
					                                    <a href="/deleteRecom?book_id=${f.book_id }&favorite_major=${f.favorite_major}&favorite_name=${f.favorite_name}" class="fa fa-times"></a>
					                                </div>
					                            </div>
					                        </div>
					                    </div>
					                </c:if>
				                	
				                </c:forEach>  
			               </div>
			            </div>
            		</c:otherwise>
            	</c:choose>
            </div>
		</section>

        <div class="container">
            <div class="row super_sub_content">
                <div class="col-md-12">
                    <div class="dividerHeading">
                        <h4><span>Recent news</span></h4>
                    </div>
						<div id="post-slider" class="owl-carousel">
							<c:forEach var="b" items="${boardList }">
		                        <div class="post-slide">	
		                            <h5 class="post-title"><a href="blog-post.html">${b.board_title }</a></h5>
		                            <div class="post-date">
		                                <i class="fa fa-calendar"></i> ${b.board_date }
		                            </div>
		                            <p>${b.board_content }</p>
		                            <a class="readmore" href="/board/boardDetail?board_id=${b.board_id }">Read more</a>
		                        </div>
	                        </c:forEach>
                    	</div>
                </div>
            </div>
        </div>

     <!-- 푸터 -->
 		 <jsp:include page="/WEB-INF/views/include/footer.jsp" />
  	<!-- /푸터 --> 


    <script type="text/javascript" src="resources/js/jquery-1.10.2.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/jquery.easing.1.3.js"></script>
    <script src="resources/js/retina-1.1.0.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery.cookie.js"></script> <!-- jQuery cookie -->
    <script type="text/javascript" src="resources/js/styleswitch.js"></script> <!-- Style Colors Switcher -->
    <script src="resources/js/jquery.fractionslider.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="resources/js/jquery.smartmenus.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery.smartmenus.bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/owl.carousel.min.js"></script>
    <script type="text/javascript" src="resources/js/jflickrfeed.js"></script>
    <script type="text/javascript" src="resources/js/jquery.magnific-popup.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery.easypiechart.min.js"></script>
    <script type="text/javascript" src="resources/js/swipe.js"></script>
    <script type="text/javascript" src="resources/js/jquery-hoverdirection.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery.matchHeight-min.js"></script>
    <script type="text/javascript" src="resources/js/jquery-scrolltofixed-min.js"></script>

    <script src="resources/js/main.js"></script>

    <!-- Start Style Switcher -->
    <div class="switcher"></div>
    <!-- End Style Switcher -->

        <script>
            /*Portfolio*/
            (function($) {
                "use strict";
                var $container = $('.portfolio'),
                        $items = $container.find('.portfolio-item'),
                        portfolioLayout = 'fitRows';

                if( $container.hasClass('portfolio-centered') ) {
                    portfolioLayout = 'masonry';
                }

                $container.isotope({
                    filter: '*',
                    animationEngine: 'best-available',
                    layoutMode: portfolioLayout,
                    animationOptions: {
                        duration: 750,
                        easing: 'linear',
                        queue: false
                    },
                    masonry: {
                    }
                }, refreshWaypoints());

                function refreshWaypoints() {
                    setTimeout(function() {
                    }, 1000);
                }

                $('ul#filter li').on('click', function() {
                    var selector = $(this).attr('data-filter');
                    $container.isotope({ filter: selector }, refreshWaypoints());
                    $('ul#filter li').removeClass('selected');
                    $(this).addClass('selected');
                    return false;
                });

                function getColumnNumber() {
                    var winWidth = $(window).width(),
                            columnNumber = 1;

                    if (winWidth > 1200) {
                        columnNumber = 5;
                    } else if (winWidth > 950) {
                        columnNumber = 4;
                    } else if (winWidth > 600) {
                        columnNumber = 3;
                    } else if (winWidth > 400) {
                        columnNumber = 2;
                    } else if (winWidth > 250) {
                        columnNumber = 1;
                    }
                    return columnNumber;
                }

                function setColumns() {
                    var winWidth = $(window).width(),
                            columnNumber = getColumnNumber(),
                            itemWidth = Math.floor(winWidth / columnNumber);

                    $container.find('.portfolio-item').each(function() {
                        $(this).css( {
                            width : itemWidth + 'px'
                        });
                    });
                }

                function setPortfolio() {
                    setColumns();
                    $container.isotope('reLayout');
                }

                $container.imagesLoaded(function () {
                    setPortfolio();
                });

                $(window).on('resize', function () {
                    setPortfolio();
                });
            })(jQuery);
        </script>


    <!-- WARNING: Wow.js doesn't work in IE 9 or less -->
    <!--[if gte IE 9 | !IE ]><!-->
    <script type="text/javascript" src="resources/js/wow.min.js"></script>
    <script>
        // WOW Animation
        new WOW().init();
    </script>
    <![endif]-->

</body>
</html>