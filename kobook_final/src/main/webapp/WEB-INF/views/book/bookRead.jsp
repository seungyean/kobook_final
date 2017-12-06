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
<%
	int countstar = (int)request.getAttribute("countstar");
	int reviewcount = (int)request.getAttribute("reviewcount");
	int ceil=0;

	if(reviewcount>0){
	 ceil=countstar/reviewcount;
	}
	
%>
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

<style type="text/css">
/* body {
  padding-top: 70px;
} */
.btn-grey{
    background-color:#D8D8D8;
	color:#FFF;
}
.rating-block{
	background-color:#FAFAFA;
	border:1px solid #EFEFEF;
	padding:15px 15px 20px 15px;
	border-radius:3px;
}
.bold{
	font-weight:700;
}
.padding-bottom-7{
	padding-bottom:7px;
}

.review-block{
	background-color:#FAFAFA;
	border:1px solid #EFEFEF;
	padding:15px;
	border-radius:3px;
	margin-bottom:15px;
}
.review-block-name{
	font-size:12px;
	margin:10px 0;
}
.review-block-date{
	font-size:12px;
}
.review-block-rate{
	font-size:13px;
	margin-bottom:15px;
}
.review-block-title{
	font-size:15px;
	font-weight:700;
	margin-bottom:10px;
}
.review-block-description{
	font-size:13px;
}
</style>
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
							  <img alt="aa"  src="/book/displayFile?fileName=${bookVO.book_img}" width="700px" height="700px">	
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
								<li><span> 판매가:</span> ${bookVO.book_m_price}</li>
								<li><span> 할인율 :</span>${(bookVO.book_o_price-bookVO.book_m_price)/100}%</li>
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
                
                	
							
				<c:if test="${bookVO.person_id!=person_id}">
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
                       		</h2>
                    </div>
               </div>
		
		     
		<div class="container">
            
      <div class="row">
         <div class="col-md-6">
            <div class="rating-block">
               <h4>Average user rating</h4>
               
               
               <c:choose>
									<c:when test="${reviewcount<=0}">
									<h2 class="bold padding-bottom-7">0<small>/ 5</small></h2>
									<%
									for(int j=0;j<5;j++)
									{
									%>
									<button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
                 					<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
               					</button>
									<%		
									}
					               %>
									</c:when>
               <c:otherwise>
               <h2 class="bold padding-bottom-7"><fmt:formatNumber value="${countstar/reviewcount}" pattern=".0"/> <small>/ 5</small></h2>
               <%
				for(int j=0; j<ceil; j++){
				%>
					<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
                 		<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
               		</button>
				<%		
					}
					for(int j=ceil; j<5; j++){
				%>
					<button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
                 		<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
               		</button>
				<%		
				}
               %>
               </c:otherwise>
				</c:choose>
            </div>
         </div>
         <div class="col-sm-3">
            <h4>Rating breakdown</h4>
            <div class="pull-left">
               <div class="pull-left" style="width:35px; line-height:1;">
                  <div style="height:9px; margin:5px 0;">5 <span class="glyphicon glyphicon-star"></span></div>
               </div>
               <div class="pull-left" style="width:180px;">
                  <div class="progress" style="height:9px; margin:8px 0;">
                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="5" aria-valuemin="0" aria-valuemax="5" style="width: 1000%">
                     <span class="sr-only">80% Complete (danger)</span>
                    </div>
                  </div>
               </div>
               
               <div class="pull-right" style="margin-left:10px;">${fivestar}</div>
            </div>
            <div class="pull-left">
               <div class="pull-left" style="width:35px; line-height:1;">
                  <div style="height:9px; margin:5px 0;">4 <span class="glyphicon glyphicon-star"></span></div>
               </div>
               <div class="pull-left" style="width:180px;">
                  <div class="progress" style="height:9px; margin:8px 0;">
                    <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="4" aria-valuemin="0" aria-valuemax="5" style="width: 80%">
                     <span class="sr-only">80% Complete (danger)</span>
                    </div>
                  </div>
               </div>
              
                <div class="pull-right" style="margin-left:10px;">${fourstar}</div>
            </div>
            <div class="pull-left">
               <div class="pull-left" style="width:35px; line-height:1;">
                  <div style="height:9px; margin:5px 0;">3 <span class="glyphicon glyphicon-star"></span></div>
               </div>
               <div class="pull-left" style="width:180px;">
                  <div class="progress" style="height:9px; margin:8px 0;">
                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="3" aria-valuemin="0" aria-valuemax="5" style="width: 60%">
                     <span class="sr-only">80% Complete (danger)</span>
                    </div>
                  </div>
               </div>
                
                <div class="pull-right" style="margin-left:10px;">${threestar}</div>
            </div>
            <div class="pull-left">
               <div class="pull-left" style="width:35px; line-height:1;">
                  <div style="height:9px; margin:5px 0;">2 <span class="glyphicon glyphicon-star"></span></div>
               </div>
               <div class="pull-left" style="width:180px;">
                  <div class="progress" style="height:9px; margin:8px 0;">
                    <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="2" aria-valuemin="0" aria-valuemax="5" style="width: 40%">
                     <span class="sr-only">80% Complete (danger)</span>
                    </div>
                  </div>
               </div>
              
                <div class="pull-right" style="margin-left:10px;">${twostar}</div>
            </div>
            <div class="pull-left">
               <div class="pull-left" style="width:35px; line-height:1;">
                  <div style="height:9px; margin:5px 0;">1 <span class="glyphicon glyphicon-star"></span></div>
               </div>
               <div class="pull-left" style="width:180px;">
                  <div class="progress" style="height:9px; margin:8px 0;">
                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="1" aria-valuemin="0" aria-valuemax="5" style="width: 20%">
                     <span class="sr-only">80% Complete (danger)</span>
                    </div>
                  </div>
               </div>
                
                <div class="pull-right" style="margin-left:10px;">${onestar}</div>
            </div>
         </div>         
      </div>         
      
      
      
      
      
      
      <div class="row sub_content">
                    <div class="col-md-12">
                        <div class="dividerHeading">
                            <h4><span>판매자 후기</span></h4>
                        </div>
                        
                        <!-- <form> -->
									<table class="table table-hover">
										<thead>
											<tr>
												<td align="center">글번호</td>
												<td></td>
												<td align="center">제목</td>
												<td></td>
												<td align="center">별점</td>
												<td></td>
												<td align="center">작성자</td>
												
												<td align="center">날짜</td>
												
											</tr>
										</thead>
										
										<c:forEach var="rlist" items="${reviewList}">
												
												<tr>
													<td align="center" >${rlist.review_id}</td>
													<td align="center"colspan="4" class="flip">${rlist.review_title}</td>
													<td align="center">${rlist.review_star}</td>
													
													
													<td align="center">${reviewer}</td>
													<td align="center"><fmt:formatDate value="${rlist.review_date}" pattern='yyyy-MM-dd' /></td>
													
												</tr>
												
										
												
										
										<tbody class="section">	
										
												<tr align="center">
												<td align="center"></td>
												<td align="center">${rlist.review_content}</td>
												<td align="center"></td>
												<td align="center"></td>
												<td align="center"></td>
												</tr>
											</tbody>
										</c:forEach>
									</table>
									<!-- </form> --> 

                    </div>

           <div class="text-center">
			<ul class="pagination">

				<c:if test="${pageMaker.prev}">
					<li><a
						href="bookRead${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
				</c:if>

				<c:forEach begin="${pageMaker.startPage }"
					end="${pageMaker.endPage }" var="idx">
					<li
						<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
						<a href="bookRead${pageMaker.makeSearch(idx)}">${idx}</a>
					</li>
				</c:forEach>

				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li><a
						href="bookRead${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
				</c:if>

			</ul>
		</div>
               </div>
               
         
               
      <%-- <div class="row">
         <div class="col-sm-7">
            <hr/>
            <div class="review-block">
             <c:forEach var="rlist" items="${reviewList}">
               <div class="row">
                  <div class="col-sm-3">
                 
                  
                    
                     <div class="review-block-name"><a href="#">작성자: ${reviewer}</a></div>
                     <div class="review-block-date"><fmt:formatDate value="${rlist.review_date}" pattern='yyyy-MM-dd' /><br/></div>
                  </div>
                  <div class="col-sm-9">
                     <div class="review-block-rate">
                        <button type="button" class="btn btn-warning btn-xs" aria-label="Left Align">
                          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                        </button>
                        <button type="button" class="btn btn-warning btn-xs" aria-label="Left Align">
                          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                        </button>
                        <button type="button" class="btn btn-warning btn-xs" aria-label="Left Align">
                          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-grey btn-xs" aria-label="Left Align">
                          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-grey btn-xs" aria-label="Left Align">
                          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                        </button>
                     </div>
                     <div class="review-block-title">${rlist.review_title}</div>
                     <div class="review-block-description">${rlist.review_content }</div>
                  </div>
               </div>
               <hr/>
               </c:forEach>
            </div>
         </div>
      </div> --%>
      
    </div> <!-- /container -->
						
						<!--/여기까지  -->	
		
		
		        <%-- <div class="row sub_content">
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
                       		</h2>
                    </div>
               </div> --%>
                       		 
                       		 
                       		 
                  <%--      		 평점 :
                       		 <c:choose>
                       		 <fmt:formatNumber value="${countstar/reviewcount}" pattern="#.#"/><br>
                       		<c:when test="${reviewcount}<=0">
                       		등록된 후기 글이 없습니다.
                       		</c:when>

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
								
								</c:choose> --%>
								
                       		 
		
               
		     
		     
		     
		     
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
	<!--    $(document).ready(function() {
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
            // autoChange: true
          });
       });
    });  -->

	</script>
	
<script type="text/javascript">
$(function(){
	$('.section').hide();	
})

$('.flip').click(function() {
   /*  $(this).closest('tbody').next('.section').show('fast'); */
    $(this).closest('tbody').next('.section').slideToggle();
   /*  $(this).addClass('opened'); */
   
});

</script>

	
	 <script src="/resources/js/main.js"></script>
	<!-- Start Style Switcher -->
	<div class="switcher"></div>
	<!-- End Style Switcher -->
</body>
</html>
