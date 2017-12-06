<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
/* if(session.getAttribute("person_id")!=null){
	int person_id=Integer.parseInt((String)(session.getAttribute("person_id")));
} */

%>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html class="no-js" lang="en"> <!--<![endif]-->
<head>
	    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>main</title>
    <meta name="description" content="">

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
                            <h2>도서검색</h2>
                        </div>
                        <nav id="breadcrumbs">
                            <ul>
                                <li><a href="index.html">Home</a>/</li>
                                <!-- <li>책등록</li> -->
                            </ul>
                        </nav>
                    </div>
                    
                </div>
            </div>
        </section>
<div class="container">
        <div class="row sub_content">
         
	<div class="col-lg-6 col-sm-6">
                <div class="dividerHeading">
                    <h4><span>Book Register</span></h4>
                </div>
   
                <form action="/book/bookRegist" id="subscribe"  name="subscribe" method="post" enctype="multipart/form-data">
                	 <input type="hidden" class="form-control" name="person_id" value="${person_id}"> 
             <b>책이름:</b>     <input type="text" name="book_name" id="name" class="form-control" placeholder="책이름">
           <b>  해시태그:</b>        <input type="text" name="book_hash" id="hash" class="form-control" placeholder="부가설명(간단검색어를 입력하세요)">
          <b>  원가: </b>        <input type="text" name="book_o_price" id="name" class="form-control" placeholder="원가">
            <b>  판매가: </b>           <input type="text" name="book_m_price" id="name" class="form-control" placeholder="판매가">
            <b>  판: </b>            <input type="text" name="book_edition" id="name" class="form-control" placeholder="판(없는경우 0으로 적어주세요)">
             <b>  출판사: </b>            <input type="text" name="book_publish" id="name" class="form-control" placeholder="출판사">
             <b>  내용: </b>          <textarea rows="10" cols="70" name="book_content"id="name" class="form-control" placeholder="내용을 입력하세요"></textarea>
                    
               <b>    안심여부:</b> <input type="radio" name="book_safe_yn" value="Y" checked="checked">Y 
					<input type="radio" name="book_safe_yn" value="N">N &nbsp&nbsp
					
			<b> 	책상태: </b><select name="book_status" id="status">
					<option value="B" selected="selected">보통</option>
					<option value="A">양호</option>
					<option value="C">미흡</option>
			</select> &nbsp&nbsp
			
			<b> 	판매상태: </b><select name="book_sell_state" id="sell_state">
					<option value="I" selected="selected">판매중</option>
					<option value="C">판매완료</option>
					</select> &nbsp&nbsp
			
		<b> 	책종류: </b><select name="book_kind" id="kind">
					<option value="사회과학계열" selected="selected">사회과학계열</option>
					<option value="법학계열">법학계열</option>
					<option value="의학간호계열">의학간호계열</option>
					<option value="공학계열">공학계열</option>
					<option value="자연과학계열">자연과학계열</option>
					<option value="예체능계열">예체능계열</option>
					<option value="어문학계열">어문학계열</option>
					</select><br>
			
			
			<b> 파일: </b><input type="file" name="file">
					
                    <div class="pull-right">
                       <input type="submit" value="Subscribe" id="submit" class="btn btn-default btn-lg button">
                    </div>
                </form>
            </div>
</div></div></section>
		
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

  <script src="/resources/js/main.js"></script>

    <!-- Start Style Switcher -->
    <div class="switcher"></div>
    <!-- End Style Switcher -->
</body>
</html>
