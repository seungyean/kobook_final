<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 

<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html class="no-js" lang="en"> <!--<![endif]-->
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>쪽지보관함</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

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
                            <h2>쪽지보관함</h2>
                        </div>
                        <nav id="breadcrumbs">
                            <ul>
                                <li><a href="index.html">홈</a>/</li>
                                <li>마이페이지 /</li>
                                <li>쪽지보관함</li>
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
							<br>
							<br>
							<c:choose>
									<c:when test="${empty receivedMsgTotal }">

									<div class="media-body">
										<div class="well" style="margin-left: 50px;">
											<h2 align="center">쪽지가 존재하지 않습니다.</h2>
										</div>
									</div>
									</c:when>
									<c:otherwise>
										<!-- <form> -->
									<table class="table table-hover">
										<thead>
											<tr>
												<td align="center">No</td>
												<td align="center">보낸이</td>
												<td align="center">내용</td>
												<td align="center">상태</td>
												<td align="center"></td>
												<td></td>
											</tr>
										</thead>
										
										<tbody>
											<c:forEach var="element" items="${receivedMsgTotal}" varStatus="s">
												<tr>
												<td align="center">${element.message_id}</td>
<%-- 												<td align="center">${element.MESSAGE_ID}</td> --%>
												<td align="center">${element.person_id}</td>
												<td align="center">${element.message_content}</td>
												<td align="center">
												<c:set var="name" value="${element.message_hit}" />
														<c:choose>
   															<c:when test="${element.message_hit eq '0' }">
      														    안읽음
   															</c:when>
   															<c:when test="${element.message_hit eq '1' }">
     														   	읽음
  															</c:when>
  														</c:choose>
												</td>
												<td align="center"><input  type="button" value="답장보내기"  class="btn-default" style="color: white;"></td>
												</tr>
									</c:forEach>
										</tbody>
										</table>
									<!-- </form> -->
									</c:otherwise>
								</c:choose>
						</div>
					</div>
				</div>
			</div>
		</section>
		
		
        <section class="promo_box">
            <div class="container">
                <div class="row">
                    <div class="col-sm-9 col-md-9 col-lg-9">
                        <div class="promo_content">
                            <h3>Electrify is awesome responsive template, with clean design.</h3>
                            <p>Lorem ipsum dolor sit amet, cons adipiscing elit. Aenean commodo ligula eget dolor. </p>
                        </div>
                    </div>
                    <div class="col-sm-3 col-md-3 col-lg-3">
                        <div class="pb_action">
                            <a class="btn btn-lg btn-default" href="#fakelink">
                                <i class="fa fa-shopping-cart"></i>
                                Download Now
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
	</section><!--end wrapper-->

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

    <script src="/resources/js/main.js"></script>
	<script type="text/javascript">
	
	
	$(function(){
		$(".btn-default").on("click",function(event){
			event.preventDefault();
			console.log($(this).val());
			
	 		
window.name = "mainPage";
window.open("/message/messageSend","messagePage", "width=630, height=300, menubar=yes, statebar=yes, scrollbar=yes");
	
document.session_id.action = "/message/messageSend";
document.session_id.target = "messagePage";
document.session_id.submit;
			
		});
	});
	
	
		
</script>
    <!-- Start Style Switcher -->
    <div class="switcher"></div>
    <!-- End Style Switcher -->
</body>
</html>