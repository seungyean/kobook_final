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
<style>
.fileDrop {
	width: 80%;
	height: 100px;
	border: 1px dotted gray;
	background-color: lightslategrey;
	margin: auto;
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
								<li>포토리뷰</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</section>
		<!-- 여기서부터 -->
		<section class="content portfolio_single">
			<div class="container">
				<div class="row sub_content">
					<div class="col-lg-8 col-md-8 col-sm-8">
						<!--Project Details Page-->
						<div class="porDetCarousel">
							<div class="carousel-content">
								<img src="/community/displayFile?fileName=${photoVO.photo_thumbnail }" alt="NO IMAGE" height="500" width="700">
							</div>
						</div>
					</div>
					
					<form role="form" action="photoReviewModify" method="post" enctype="multipart/form-data">
					<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">
					<input type="hidden" name="photo_thumbnail" value="${photoVO.photo_thumbnail}">
					<input type="hidden" name="photo_id" value="${photoVO.photo_id }">
					<div class="col-lg-4 col-md-4 col-sm-4">
						<div class="project_details">
							<div class="widget_title">
								<h4>
									<span><input type="text" name="photo_title" value="${photoVO.photo_title}"></span>
								</h4>
							</div>
							<ul class="details">
								<li><span><i class="fa fa-pencil"></i>글번호 :</span>${rn}</li>
								<li><span><i class="fa fa-user"></i>작성자 :</span>${writer }</li>
								<li><span><i class="fa fa-file-text"></i>내용 :</span>
								<textarea cols="25" rows="2" name="photo_content"
												placeholder="${photoVO.photo_content }">${photoVO.photo_content }</textarea>
								</li>
								<li><span><i class="fa fa-calendar"></i>작성일 :</span> <fmt:formatDate
										value="${photoVO.photo_date }" pattern="MM月 dd日, yyyy年" /></li>
								<li><span><i class="fa fa-heart"></i>좋아요 :</span>
									${photoVO.photo_heart }</li>
								<li><span><i class="fa fa-eye"></i>조회수 :</span>${photoVO.photo_hit }</li>
							</ul>

							<%-- <input type="hidden" name="photo_img" value="${photo.photo_img }">
							<input type="file" name="photoUimg">
							<input type="submit" class="btn btn-lg btn-default" value="수정완료"> --%>
						</div>
					</div>
						<input type="file" name="file"><br> 
						<button type="submit" class="btn btn-primary">SAVE</button>
						<button type="submit" class="btn btn-warning">CANCEL</button>
					</form>
				</div>
				<button class="fileButton">파일 추가</button>
					<div class="form-group" id="fileAdd">
						<label for="exampleInputEmail1">추가 파일은 아래영역에 드래그하십시오.</label>
						<div class="fileDrop"></div>
						<button class="cancleFile">취소</button>
					</div>
 				<div class="box-footer">
					<div>
						<hr>
					</div>
<%-- 
					<figure class="post_img">
						<img class="thumbnail" alt="NO Thumbnail" 
							src="/community/displayFile?fileName=${photoVO.photo_thumbnail }" height="300" width="200">
					</figure> --%>
					<ul class="mailbox-attachments clearfix uploadedList">
					</ul>
								
				</div>
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
	
<script id="template" type="text/x-handlebars-template">
<li>
	<div class="mailbox-attachment-info">
<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}
  <span class="mailbox-attachment-icon has-img"><br><img src="{{imgsrc}}" alt="Attachment">
	</a>
	<a href="{{fullName}}" 
     class="btn btn-default btn-xs pull-right delbtn"><i class="fa fa-fw fa-remove"></i></a>
	</span>
  </div>
</li>
</script>

<script>
$(function(){
	 $("#fileAdd").hide();

	 $(".fileButton").on("click", function(){
	 	event.preventDefault();
	 	$("#fileAdd").show();
	 	$(this).hide();
	 });

	 $(".cancleFile").on("click", function(){
	 	event.preventDefault();
	 	$("#fileAdd").hide();
	 	$(".fileButton").show();
	 });
		
	var formObj = $("form[role='form']");
	
	formObj.submit(function(event){
		event.preventDefault();
		
		var that = $(this);
		
		var str ="";
		$(".uploadedList .delbtn").each(function(index){
			 str += "<input type='hidden' name='files["+index+"]' value='"+$(this).attr("href") +"'> ";
		});
		
		that.append(str);

		console.log(str);
		
		that.get(0).submit();
	});
	
	
	$(".btn-warning").on("click", function(){
	  self.location = "/community/photoReviewList?page=${cri.page}&perPageNum=${cri.perPageNum}"+
			  "&searchType=${cri.searchType}&keyword=${cri.keyword}";
	});
	
});




var template = Handlebars.compile($("#template").html());


$(".fileDrop").on("dragenter dragover", function(event){
	event.preventDefault();
});


$(".fileDrop").on("drop", function(event){
	event.preventDefault();
	
	var files = event.originalEvent.dataTransfer.files;
	
	var file = files[0];
	
	var formData = new FormData();
	
	formData.append("file", file);	
	
	$.ajax({
		  url: '/community/uploadAjax',
		  data: formData,
		  dataType:'text',
		  processData: false,
		  contentType: false,
		  type: 'POST',
		  success: function(data){
			  
			  var fileInfo = getFileInfo(data);
			  
			  var html = template(fileInfo);
			  
			  $(".uploadedList").append(html);
		  }
		});	
});


$(".uploadedList").on("click", ".delbtn", function(event){
	
	event.preventDefault();
	
	var that = $(this);
	 
	$.ajax({
	   url:"/community/deleteFile",
	   type:"post",
	   data: {fileName:$(this).attr("href")},
	   dataType:"text",
	   success:function(result){
		   if(result == 'deleted'){
			   that.closest("li").remove();
		   }
	   }
   });
});


var photo_id = ${photoVO.photo_id};
var template = Handlebars.compile($("#template").html());

$.getJSON("/community/photoGetAttach/"+photo_id,function(list){
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