<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html class="no-js" lang="en"> <!--<![endif]-->
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>Electrify Responsive Multipurpose Template</title>
	<meta name="description" content="">

   <!-- CSS FILES -->
    <link rel="stylesheet" href="/kobook/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/kobook/css/style.css">
    <link rel="stylesheet" type="text/css" href="/kobook/css/style.css" media="screen" data-name="skins">
    <link rel="stylesheet" href="/kobook/css/layout/wide.css" data-name="layout">

    <link rel="stylesheet" type="text/css" href="/kobook/css/switcher.css" media="screen" />
</head>
<body>
	<!-- 헤더 -->
 		<%--  <jsp:include page="/include/header.jsp" /> --%>
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
   
                <form action="insertForm" id="subscribe"  name="subscribe" method="post" enctype="multipart/form-data">
                	<input type="hidden" class="form-control" name="person_id" value="${BookVO.person_id}">
             <b>책이름:</b>     <input type="text" name="name" id="name" class="form-control" placeholder="책이름">
           <b>  부가설명:</b>        <input type="text" name="hash" id="hash" class="form-control" placeholder="부가설명(간단검색어를 입력하세요)">
          <b>  원가: </b>        <input type="text" name="o_price" id="name" class="form-control" placeholder="원가">
            <b>  판매가: </b>           <input type="text" name="m_price" id="name" class="form-control" placeholder="판매가">
            <b>  판: </b>            <input type="text" name="edition" id="name" class="form-control" placeholder="판(빈칸도 좋아용)">
             <b>  출판사: </b>            <input type="text" name="publish" id="name" class="form-control" placeholder="출판사">
             <b>  내용: </b>          <textarea rows="10" cols="70" name="content"id="name" class="form-control" placeholder="내용을 입력하세요"></textarea>
                    
               <b>    안심여부:</b> <input type="radio" name="safe_yn" value="Y" checked="checked">Y 
					<input type="radio" name="safe_yn" value="N">N &nbsp&nbsp
					
			<b> 	책상태: </b><select name="status" id="status">
					<option value="B" >보통</option>
					<option value="A">양호</option>
					<option value="C">미흡</option>
			</select> &nbsp&nbsp
			
			<b> 	판매상태: </b><select name="sell_state" id="sell_state">
					<option value="I">판매중</option>
					<option value="C">판매완료</option>
					</select> &nbsp&nbsp
			
		<b> 	책종류: </b><select name="kind" id="kind">
					<option value="사회계열">사회계열</option>
					<option value="법학계열">법학계열</option>
					<option value="의학계열">의학계열</option>
					<option value="공학계열">공학계열</option>
					<option value="자연계열">자연계열</option>
					<option value="예체능계열">예체능계열</option>
					<option value="어문학계열">어문학계열</option>
					</select><br>
			
			
			<b> 파일: </b><input type="file" name="img">
					
                    <div class="pull-right">
                       <input type="submit" value="Subscribe" id="submit" class="btn btn-default btn-lg button">
                    </div>
                </form>
            </div>
</div></div></section>
<!-- <section class="content contact">
        <div class="container">
            <div class="row sub_content">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <div class="maps">
                        <div id="page_maps"></div>
                    </div>
                </div>
            </div>

            <div class="row sub_content">
                <div class="col-lg-8 col-md-8 col-sm-8">
                    <div class="dividerHeading">
                        <h4><span>책등록</span></h4>
                    </div>
                    <p>Vidit nulla errem ea mea. Dolore apeirian insolens mea ut, indoctum consequuntur hasi. No aeque dictas dissenti as tusu, sumo quodsi fuisset mea in. Ea nobis populo interesset cum, ne sit quis elit officiis, min im tempor iracundia sit anet. Facer falli aliquam nec te. In eirmod utamur offendit vis, posidonium instructior sed te.</p>

                    <div class="alert alert-success hidden alert-dismissable" id="contactSuccess">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <strong>Success!</strong> Your message has been sent to us.
                    </div>

                    <div class="alert alert-error hidden" id="contactError">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <strong>Error!</strong> There was an error sending your message.
                    </div>

                    <form id="contactForm" action="" novalidate="novalidate">
                        <div class="row">
                            <div class="form-group">
                                <div class="col-lg-6 ">
                                    <input type="text" id="name" name="name" class="form-control" maxlength="100" data-msg-required="Please enter your name." value="" placeholder="책이름" >
                                </div>
                                <div class="col-lg-6 ">
                                    <input type="email" id="email" name="email" class="form-control" maxlength="100" data-msg-email="Please enter a valid email address." data-msg-required="Please enter your email address." value="" placeholder="" >
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <input type="text" id="subject" name="subject" class="form-control" maxlength="100" data-msg-required="Please enter the subject." value="" placeholder="Subject">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <textarea id="message" class="form-control" name="message" rows="10" cols="50" data-msg-required="Please enter your message." maxlength="5000" placeholder="Message"></textarea>

                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <input type="submit" data-loading-text="Loading..." class="btn btn-default btn-lg" value="Send Message">
                            </div>
                        </div>
                    </form>
                </div>
		</div>
</div>
</section> -->
		
	<!--end wrapper-->

	<!-- 푸터 -->
 		 <%-- <jsp:include page="/include/footer.jsp" /> --%>
  	<!-- /푸터 -->
	
    <script type="text/javascript" src="/kobook/js/jquery-1.10.2.min.js"></script>
    <script src="/kobook/js/bootstrap.min.js"></script>
    <script src="/kobook/js/jquery.easing.1.3.js"></script>
    <script src="/kobook/js/retina-1.1.0.min.js"></script>
    <script type="text/javascript" src="/kobook/js/jquery.cookie.js"></script> <!-- jQuery cookie -->
    <script type="text/javascript" src="/kobook/js/styleswitch.js"></script> <!-- Style Colors Switcher -->
    <script type="text/javascript" src="/kobook/js/jquery.smartmenus.min.js"></script>
    <script type="text/javascript" src="/kobook/js/jquery.smartmenus.bootstrap.min.js"></script>
        <script type="text/javascript" src="/kobook/js/jflickrfeed.js"></script>
    <script type="text/javascript" src="/kobook/js/jquery.magnific-popup.min.js"></script>
    <script type="text/javascript" src="/kobook/js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="/kobook/js/swipe.js"></script>
    <script type="text/javascript" src="/kobook/js/jquery-scrolltofixed-min.js"></script>

    <script src="/kobook/js/main.js"></script>

    <!-- Start Style Switcher -->
    <div class="switcher"></div>
    <!-- End Style Switcher -->
</body>
</html>
