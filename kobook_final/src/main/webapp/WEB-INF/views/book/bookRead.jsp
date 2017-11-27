<%-- <%@page import="kobook.book.domain.BookSearch"%>
<%@page import="kobook.book.domain.Book"%> --%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <% 
	int person_id = Integer.parseInt((String)(session.getAttribute("person_id")));

%> --%>

<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Portfolio Single - Electrify Responsive Multipurpose
	Template</title>
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<!-- <style type="text/css">
body {
  font-family:"Open Sans", Helvetica, Arial, sans-serif;
  color:#555;
  max-width:680px;
  margin:0 auto;
  padding:0 20px;
}

* {
  -webkit-box-sizing:border-box;
  -moz-box-sizing:border-box;
  box-sizing:border-box;
}

*:before, *:after {
-webkit-box-sizing: border-box;
-moz-box-sizing: border-box;
box-sizing: border-box;
}

.clearfix {
  clear:both;
}

.text-center {text-align:center;}

pre {
display: block;
padding: 9.5px;
margin: 0 0 10px;
font-size: 13px;
line-height: 1.42857143;
color: #333;
word-break: break-all;
word-wrap: break-word;
background-color: #F5F5F5;
border: 1px solid #CCC;
border-radius: 4px;
}

.header {
  padding:20px 0;
  position:relative;
  margin-bottom:10px;
  
}

.header:after {
  content:"";
  display:block;
  height:1px;
  background:#eee;
  position:absolute; 
  left:30%; right:30%;
}

.header h2 {
  font-size:3em;
  font-weight:300;
  margin-bottom:0.2em;
}

.header p {
  font-size:14px;
}

.success-box {
  margin:50px 0;
  padding:10px 10px;
  border:1px solid #eee;
  background:#f9f9f9;
}

.success-box img {
  margin-right:10px;
  display:inline-block;
  vertical-align:top;
}

.success-box > div {
  vertical-align:top;
  display:inline-block;
  color:#888;
}



/* Rating Star Widgets Style */
.rating-stars ul {
  list-style-type:none;
  padding:0;
  
  -moz-user-select:none;
  -webkit-user-select:none;
}
.rating-stars ul > li.star {
  display:inline-block;
  
}

/* Idle State of the stars */
.rating-stars ul > li.star > i.fa {
  font-size:2.5em; /* Change the size of the stars */
  color:#ccc; /* Color on idle state */
}

/* Hover state of the stars */
.rating-stars ul > li.star.hover > i.fa {
  color:#FFCC36;
}

/* Selected state of the stars */
.rating-stars ul > li.star.selected > i.fa {
  color:#FF912C;
}
</style> -->

     <!-- CSS FILES -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css" media="screen" data-name="skins">
    <link rel="stylesheet" href="/resources/css/layout/wide.css" data-name="layout">

    <link rel="stylesheet" type="text/css" href="/resources/css/switcher.css" media="screen" />
    
</head>


<body>
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
							<h2>도서 상세보기</h2>
						</div>
						<nav id="breadcrumbs">
							<ul>
								<li><a href="index.html">Home</a>/</li>
								<li>상세보기</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</section>






		<section class="content portfolio_single">
			<div class="container">
				<div class="row sub_content">
			
			
				<form role="form" action="/book/bookModify"  name="modifyForm" method="get">
					<input type="hidden" name="book_id" value="${bookVO.book_id}"> 
				  	
                	
					<div class="col-lg-8 col-md-8 col-sm-8">
						<!--Project Details Page-->
						<div class="porDetCarousel">
							<div class="carousel-content">
							  <img alt="aa" class="carousel-item" src="displayFile?fileName=${bookVO.book_img}" width="10px" height="800px">	
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-4 col-sm-4">
						<div class="project_description">
							<div class="widget_title">
								<h4><span>내용</span></h4>
							</div>
						<p>${bookVO.book_content}</p>
						</div>

					<div class="project_details">
							<div class="widget_title">
								<h4><span>상세내용</span></h4>
							</div>
					   <ul class="details">
								<li><span>책이름 :</span>${bookVO.book_name}</li>
								<li><span>책종류 :</span>${bookVO.book_kind}</li>
								<li><span>해시태그 :</span>${bookVO.book_hash}</li>
								<li><span> 원가:</span> ${bookVO.book_o_price}</li>
								<li><span> 판매가:</span> ${bookVO.book_m_price} 할인:<b>${(bookVO.book_o_price-bookVO.book_m_price)/100}%</b></li>
								<li><span> 판 :</span>${bookVO.book_edition}</li>
								<li><span>출판사 :</span>${bookVO.book_publish}</li>
								<li><span>안심여부사용 :</span>${bookVO.book_safe_yn}</li>
								<li><span>날짜: </span><fmt:formatDate value="${bookVO.book_date}" pattern='yyyy-MM-dd' /></li>
								<li><span>책상태 :</span>
								<c:choose>
								<c:when test="${bookVO.book_status=='A'}">
								양호
								</c:when>
								<c:when test="${bookVO.book_status=='B'}">
								보통
								</c:when>
								<c:when test="${bookVO.book_status=='C'}">
								나쁨
								</c:when>
								</c:choose>
								</li>
		
								<li><span>판매상태</span>
								<c:choose>
								<c:when test="${bookVO.book_sell_state=='I'}">
								판매중
								</c:when>
								<c:when test="${bookVO.book_sell_state=='C'}">
								판매완료
								</c:when>
								</c:choose>
								</li>
						</ul> 
				    </div>  <!--/project_details  -->
								
						<c:if test="${bookVO.person_id==person_id}">
					 	<button id="modifyBtn" class="btn btn-default btn-lg button">수정하기</button>
					 	</c:if>
					 	
					 	</form>
                 	<%--<input type="hidden" name="page" value="${cri.page}">
                		<input type="hidden" name="perPageNum" value="${cri.perPageNum}"> --%>
                
                	
							
				<c:if test="${bookVO.person_id==person_id}">
				<form action="/book/pick" method="post" name="pick">	
                     <input type="hidden" name="book_id" value="${bookVO.book_id}">
                     <input type="hidden" name = "person_id" value="${person_id}">
                     <input type="submit" value="찜하기" class="btn btn-default btn-lg button">
                 </form>
                 </c:if>
	   		</div>  <!--/col-lg-4 col-md-4 col-sm-4  -->		
		</div>  <!--/row sub_content  -->
		
		     
		
		       <div class="row sub_content">
                    <div class="col-md-12">
                        <div class="dividerHeading">
                            <h4><span>판매자정보</span></h4>
                        </div>
  
                      		 <h2> 이메일 : ${s.person_email} &nbsp;&nbsp;
                       		 등급 :
                       		 	<c:choose>
								<c:when test="${s.person_sell_grade=='U'}">
								<img alt="" src="/resources/img/vip.jpg">
								</c:when>
								<c:when test="${s.person_sell_grade=='M'}">
								<img alt="" src="/resources/img/gold.jpg">
								</c:when>
								<c:when test="${s.person_sell_grade=='D'}">
								<img alt="" src="/resources/img/green.jpg">
								</c:when>
								</c:choose> &nbsp;&nbsp;
                       		 
                       		 평점 :
                       		 <c:choose>
                       		<%--  <fmt:formatNumber value="${countstar/reviewcount}" pattern="#.#"/><br> --%>
                       		<c:when test="${reviewcount}<=0">
                       		no 
                       		</c:when>
                       		<%-- ${s.person_avg}=${countstar/reviewcount} --%>
                       		
                       		
								<c:when test="${countstar/reviewcount=='5'}">
								<img alt="" src="/resources/img/5.PNG">
								</c:when>
								<c:when test="${countstar/reviewcount=='4'}">
								<img alt="" src="/resources/img/4.PNG">
								</c:when>
								<c:when test="${countstar/reviewcount=='3'}">
								<img alt="" src="/resources/img/3.PNG">
								</c:when>
								<c:when test="${countstar/reviewcount=='2'}">
								<img alt="" src="/resources/img/2.PNG">
								</c:when>
								<c:when test="${countstar/reviewcount=='1'}">
								<img alt="" src="/resources/img/1.png">
								</c:when>
								<c:otherwise>
								test
								</c:otherwise>
								
								</c:choose>
								
                       		 
							</h2>
                    </div>
               </div>
               
               
		     
		     
		     
		     
		     <div class="row sub_content">
                    <div class="col-md-12">
                        <div class="dividerHeading">
                            <h4><span>판매자의 다른도서 상품</span></h4>
                        </div>
                         
                        <div id="recent-work-slider" class="owl-carousel">
                            <c:forEach var="b" items="${slist}">
                               <figure class="touching ">
                                  <div class="recent-item box">
                              
                                   <img src="displayFile?fileName=${b.book_img}" alt="aa" height="150" width="210"></img>
									<a href="/book/bookRead?book_id=${b.book_id}"></a>
                                    <div class="option inner">
                                        <div>
                                            <h5>${b.book_name}</h5>
                                          <a href="displayFile?fileName=${b.book_img}" class="fa fa-search mfp-image"></a> 
                                          <a href="/book/bookRead?book_id=${b.book_id}" class="fa fa-link"></a>
										  <span>${b.book_m_price}원</span>
                                        </div>
                                    </div>
                               
                                 </div><!--/판매자다른 상품 recent-item box  -->
                                 </figure>
                             </c:forEach>
                         </div><!--/판매자다른 상품 recent-work-slider  -->
                         
                    </div> <!--/판매자다른 상품 col-md-12  -->
              </div> <!--/판매자다른 상품 row sub_content  -->
		

			</div> <!--/container  -->
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

	<script type="text/javascript">
    $(document).ready(function() {
       $.fn.carousel = function(op) {
          var op, ui = {};
          op = $.extend({
             speed: 500,
             autoChange: false,
             interval: 5000
          }, op);
          ui.carousel = this;
          ui.items    = ui.carousel.find('.carousel-item');
          ui.itemsLen = ui.items.length;

          // CREATE CONTROLS
          ui.ctrl    = $('<div />', {'class': 'carousel-control'});
          ui.prev    = $('<div />', {'class': 'carousel-prev'});
          ui.next    = $('<div />', {'class': 'carousel-next'});
          ui.pagList  = $('<ul />', {'class': 'carousel-pagination'});
          ui.pagItem  = $('<li></li>');
          for (var i = 0; i < ui.itemsLen; i++) {
             ui.pagItem.clone().appendTo(ui.pagList);
          }
          ui.prev.appendTo(ui.ctrl);
          ui.next.appendTo(ui.ctrl);
          ui.pagList.appendTo(ui.ctrl);
          ui.ctrl.appendTo(ui.carousel);
          ui.carousel.find('.carousel-pagination li').eq(0).addClass('active');
          ui.carousel.find('.carousel-item').each(function() {
             $(this).hide();
          });
          ui.carousel.find('.carousel-item').eq(0).show().addClass('active');
          
          
          // CHANGE ITEM
          var changeImage = function(direction, context) {
             var current = ui.carousel.find('.carousel-item.active');

             if (direction == 'index') {
                if(current.index() === context.index())
                   return false;

                context.addClass('active').siblings().removeClass('active');

                ui.items.eq(context.index()).addClass('current').fadeIn(op.speed, function() {
                   current.removeClass('active').hide();
                   $(this).addClass('active').removeClass('current');
                });
             } 

             if (direction == 'prev') {
                if (current.index() == 0) {
                   ui.carousel.find('.carousel-item:last').addClass('current').fadeIn(op.speed, function() {
                      current.removeClass('active').hide();
                      $(this).addClass('active').removeClass('current');
                   });
                }
                else {
                   current.prev().addClass('current').fadeIn(op.speed, function() {
                      current.removeClass('active').hide();
                      $(this).addClass('active').removeClass('current');
                   });
                }
             }

             if (direction == undefined) {
                if (current.index() == ui.itemsLen - 1) {
                   ui.carousel.find('.carousel-item:first').addClass('current').fadeIn(300, function() {
                      current.removeClass('active').hide();
                      $(this).addClass('active').removeClass('current');
                   });
                }
                else {
                   current.next().addClass('current').fadeIn(300, function() {
                      current.removeClass('active').hide();
                      $(this).addClass('active').removeClass('current');
                   });
                }
             }
             ui.carousel.find('.carousel-pagination li').eq( ui.carousel.find('.carousel-item.current').index() ).addClass('active').siblings().removeClass('active');
          };

          ui.carousel
             .on('click', 'li', function() {
                changeImage('index', $(this));
             })
             .on('click', '.carousel-prev', function() {
                changeImage('prev');
             })
             .on('click', '.carousel-next', function() {
                changeImage();
             });
          
          // AUTO CHANGE
          if (op.autoChange) {
             var changeInterval = setInterval(changeImage, op.interval);
             ui.carousel
                .on('mouseenter', function() {
                   clearInterval(changeInterval);
                })
                .on('mouseleave', function() {
                   changeInterval = setInterval(changeImage, op.interval);
                });
          }
          return this;
       };
       
       $('.porDetCarousel').each(function() {
          $(this).carousel({
             autoChange: true
          });
       });
    });
		
	</script>
	
<!-- 	<script type="text/javascript">
    function modifyForm(){
    	modifyForm.attr("action","/book/bookModify");
        modifyForm.subtmit();
    };
    </script> -->
	
	 <script src="/resources/js/main.js"></script>
	<!-- Start Style Switcher -->
	<div class="switcher"></div>
	<!-- End Style Switcher -->
</body>
</html>
