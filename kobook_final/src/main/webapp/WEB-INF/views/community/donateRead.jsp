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
    .back { background-color: gray; opacity:0.5; width: 78%; height: 31%; overflow:hidden;  z-index:1101;}
    .front { 
       z-index:1110; opacity:1; boarder:1px; margin: auto; 
      }
     .show{
       position:relative;
       max-width: 900px; 
       max-height: 500px; 
       overflow: auto;       
     }
     #popup_img{
     	width: 500%;
     	height: 500%;
     }
  	
    </style>   
<script type="text/javascript">
	function fn_update() {
		location.href = "donateModify?donate_id=${donate.donate_id}";
	}
</script>
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
							<h2>무료 나눔 상세보기</h2>
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

		<section class="content blog">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
						<div class="blog_single">

    			<form role="form" action="donateModify" method="post">
					<input type='hidden' name='black_id' value="${donateVO.donate_id}">
					<input type='hidden' name='page' value="${cri.page}">
					<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">
				</form>
   
							<article class="post">
<!-- 								<form action="donateDelete" method="post"> -->
									<input type="hidden" name="donate_id"
										value="${donateVO.donate_id}">

									<div class="post_date">
										<span class="day">${donateVO.donate_id }</span>
									</div>
									<div class="post_content">
										<div class="post_meta">
											<h2>${donateVO.donate_title }</h2>
											<div class="metaInfo">
												<span><i class="fa fa-calendar"></i> <fmt:formatDate
														value="${donateVO.donate_date }" pattern="MMM dd, yyyy" />
												</span> <span><i class="fa fa-user"></i> By
													${donateVO.person_id} </span> <span><i class="fa fa-eye"></i>
													${donateVO.donate_hit} </span>
												<!-- <span><i class="fa fa-comments"></i> <a href="#">12 Comments</a></span>  -->
<!-- 												<input type="button"
													class="btn btn-lg btn-default" value="수정"
													onclick="fn_update()"> <input
													class="btn btn-lg btn-default" type="submit" value="삭제"> -->
										<c:if test="${donateVO.person_id == person_id }">
											<button type="submit" class="btn btn-warning" id="modifyBtn">수정</button>
											<button type="submit" class="btn btn-danger" id="removeBtn">삭제</button>
										</c:if>
										<button type="submit" class="btn btn-primary" id="goListBtn">목록으로</button>
											</div>
										</div>
										<blockquote class="default">
											${donateVO.donate_content }</blockquote>

									</div>
<!-- 								</form> -->
							</article>
					    <div class='popup back' style="display:none;"></div>
					    <div id="popup_front" class='popup front' style="display:none;">
					     <img id="popup_img">
					    </div>
									<figure class="post_img">
									<img class="thumbnail" alt="NO Thumbnail"
												 src="/community/displayFile?fileName=${donateVO.donate_thumbnail }" height="300" width="200">
									</figure>
							 <ul class="mailbox-attachments clearfix uploadedList">
							 </ul>
						</div>
<%-- 
						<!--News Comments-->
						<div class="news_comments">
							<div class="dividerHeading">
								<h4>
									<span>Comments</span>
								</h4>
							</div>

							<c:if test="${fn:length(replyList) > 0}">
								<div id="comment">
									<ul id="comment-list">
										<c:forEach var="reply" items="${replyList}">
											<li class="comment">
												<div class="comment-container">
													<h4 class="comment-author">
														<span>By, ${reply.person_id}</span>
													</h4>
													<div class="comment-meta">
														<a class="comment-date link-style1"><fmt:formatDate
																value="${reply.reply_date}" pattern="yy-MM-dd, HH:mm" /></a>
														<a
															href="donateReplyUpdateForm.do?donate_id=${reply.donate_id}&reply_id=${reply.reply_id}">
															수정</a> <a
															href="donateReplyDelete.do?reply_id=${reply.reply_id}">삭제</a>
														<!-- 댓글의 답글(추후보강) -->
														<!-- 		
														<a class="comment-reply-link link-style3" href="#respond">Reply &raquo;</a>
														-->
													</div>
													<div class="comment-body">
														<p>${reply.reply_content}</p>
													</div>
												</div>
											</li>
										</c:forEach>
									</ul>
								</div>
							</c:if>
							<!-- /#comments -->
							<div class="dividerHeading">
								<h4>
									<span>Leave a comment</span>
								</h4>
							</div>
							<form action="donateReply.do" method="post">

								<input type="hidden" name="rDonate_id"
									value="${donateVO.donate_id}" />
								<div class="comment_form">
									<div class="row">
										<div class="col-sm-4">
											<input class="col-lg-4 col-md-4 form-control" type="hidden"
												size="30" id="name" name="rperson_id" value="${person_id}"
												placeholder="person_id">
										</div>
									</div>
								</div>
								<div class="comment-box row">
									<div class="col-sm-12">
										<p>
											<textarea class="form-control" cols="60" rows="6"
												id="comments" name="reply_content" placeholder="Message"></textarea>
										</p>
									</div>
								</div>
								<input type="submit" class="btn btn-lg btn-default"
									value="댓글 작성" />
							</form>
						</div>
 --%>

					</div>
				</div>
				<!--/.row-->
			</div>
			<!--/.container-->
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
  <span class="mailbox-attachment-icon has-img"><br><img src="{{imgsrc}}" alt="Attachment" height="200" width="200"></span>
</a>
  </div>
</li>
</script> 
<script>
$(function(){
	var formObj = $("form[role='form']");
	 	
	$("#modifyBtn").on("click", function(){
		formObj.attr("action", "/community/donateModify");
		formObj.attr("method", "get");		
		formObj.submit();
	});

	
	$("#removeBtn").on("click", function(){		
		var arr = [];
		$(".uploadedList li").each(function(index){
			 arr.push($(this).attr("data-src"));
		});
		
		if(arr.length > 0){
			$.post("/community/deleteAllFiles",{files:arr}, function(){
				
			});
		}
		
		formObj.attr("action", "/community/donateRemove");
		formObj.submit();
	});	
	
	$("#goListBtn ").on("click", function(){
		formObj.attr("method", "get");
		formObj.attr("action", "/community/donateList");
		formObj.submit();
	});

	var donate_id = ${donateVO.donate_id};
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
	
	
	$(".thumbnail").on("click", function(event){
			event.preventDefault();
		var str = $(this).attr("src");
		var str2 = str.split("s_");
		var str3 = str2[0]+str2[1];
  		var imgTag = $("#popup_img");
		imgTag.attr("src", str3);
					
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