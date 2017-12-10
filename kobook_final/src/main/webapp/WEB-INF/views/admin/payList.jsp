<%-- <%@page import="kobook.book.dao.BookDAO"%> --%>
<%-- <%@page import="kobook.book.domain.BookSearch"%>
<%@page import="kobook.book.domain.Book"%> --%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>매출통계</title>
<meta name="description" content="">
  

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
ul.tabs {
    margin: 0;
    padding: 0;
    float: left;
    list-style: none;
    height: 32px;
    border-bottom: 1px solid #eee;
    border-left: 1px solid #eee;
    width: 100%;
    font-family:"dotum";
    font-size:12px;
}
ul.tabs li {
    float: left;
    text-align:center;
    cursor: pointer;
    width:82px;
    height: 31px;
    line-height: 31px;
    border: 1px solid #eee;
    border-left: none;
    font-weight: bold;
    background: #fafafa;
    overflow: hidden;
    position: relative;
}
ul.tabs li.active {
    background: #FFFFFF;
    border-bottom: 1px solid #FFFFFF;
}
.tab_container {
    border: 1px solid #eee;
    border-top: none;
    clear: both;
    float: left;
    width: 1150px;
    background: #FFFFFF;
}
.tab_content {
	width: 600px;
    padding: 5px;
    font-size: 12px;
    display: none;
}
.tab_container .tab_content ul {
    width:100%;
    margin:0px;
    padding:0px;
}
.tab_container .tab_content ul li {
    padding:5px;
    list-style:none
}
;
 #container {
    width: 500px;
    margin: 0 auto;
}
</style>	
</head>
<body>

<!--Start Header-->
    <header id="header">
        <div id="top-bar">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 top-info hidden-xs">
                        <span><i class="fa fa-phone"></i>Phone: (123) 456-7890</span>
                        <span><i class="fa fa-envelope"></i>Email: mail@example.com</span>
                    </div>
                    <div class="col-sm-4 top-info">
                        <ul>
                            <li><a href="" class="my-tweet"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="" class="my-facebook"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="" class="my-skype"><i class="fa fa-skype"></i></a></li>
                            <li><a href="" class="my-pint"><i class="fa fa-pinterest"></i></a></li>
                            <li><a href="" class="my-rss"><i class="fa fa-rss"></i></a></li>
                            <li><a href="" class="my-google"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="logo-bar">
            <div class="container">
                <div class="row">
                    <!-- Logo / Mobile Menu -->
                    <div  class="col-lg-3 col-sm-3 ">
                        <div id="logo">
                           <h1><a href="/admin/adminMain">관리자WORLD</a></h1>
                        </div>
                    </div>
                    <!-- Navigation
    ================================================== -->
                    <div class="col-lg-9 col-sm-9">
                        <div class="navbar navbar-default navbar-static-top" role="navigation">
                            <!--  <div class="container">-->
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div class="navbar-collapse collapse">
                                <ul class="nav navbar-nav">
                                    <li><a href="/board/personList">회원관리</a>
                                    </li>

                                    <li><a href="/book/delivery">주문배송 관리</a>

                                    </li>

                                    <li><a href="/admin/notiList">게시판 관리</a>
                                         
                                    </li>

                                    <li><a href="/admin/payList">매출정산 관리</a>
                                        
                                    </li>

                                    <li><a href="/admin/analyze">접속통계 관리</a>
                                        
                                    </li>
                                   
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
<!--End Header-->
	
	<!--start wrapper-->
	<section class="wrapper">
        <section class="page_head">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <div class="page_title">
                            <h2>Our Services</h2>
                        </div>
                        <nav id="breadcrumbs">
                            <ul>
                                <li><a href="index.html">Home </a>/</li>
                                <li>Pages</li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </section>

	<section class="content faq">
		<div class="container">
			<div class="row">
				<div class="col-lg-8"></div>
			</div>

				<div id="container">
					<ul class="tabs">
						<li class="active" rel="tab1">월별매출</li>
					</ul>
					<div class="tab_container">
					<!-- #tab1 -->
						<div id="tab1" class="tab_content">
							
							<div>
								<select id="pay_date">
									<option value="2017">2017</option>
									<option value="2016">2016</option>
								</select>
			 					<input type="button" value="검색" id="year" onclick="selectButton()" />
							</div>
						
							<div id="month">
								<table id='month_deal' class='table table-bordered' style='text-align: center'>
									<tr height='20'>
										<td>월</td>
										<td>매출(원)</td>
										<td>전월대비</td>
									</tr>
								</table>
							</div>
						</div>
						
						<div id="chart_a"></div>
						
<!-- 						#tab2
						<div id="tab2" class="tab_content">
							<div>
								<select id="pay_day">
									<option value="01">1월</option>
									<option value="02">2월</option>
									<option value="03">3월</option>
									<option value="04">4월</option>
									<option value="05">5월</option>
									<option value="06">6월</option>
									<option value="07">7월</option>
									<option value="08">8월</option>
									<option value="09">9월</option>
									<option value="10">10월</option>
									<option value="11">11월</option>
									<option value="12">12월</option>
								</select>
			 					<input type="submit" value="검색" id="day" onclick="payDayButton()" />
							</div>	
						</div> -->
						
					</div>
			</div>
		</div>
		

			<!--Sidebar Widget-->
					<div class="col-lg-4">
						<div class="sidebar">
							<div class="widget widget_search">
								<div class="site-search-area">
									<!-- <form method="get" id="site-searchform" action="#">
										<div>
											<input class="input-text" name="s" id="s" placeholder="Enter Search keywords..." type="text" />
											<input id="searchsubmit" value="Search" type="submit" />
										</div>
									</form> -->
								</div>
								<!-- end site search -->
							</div>


						</div>
					</div></section>

<!--Sidebar Widget-->
			<div class="col-lg-4">
				<div class="sidebar">
					<div class="widget widget_search">
						<div class="site-search-area">
							<!-- <form method="get" id="site-searchform" action="#">
										<div>
											<input class="input-text" name="s" id="s" placeholder="Enter Search keywords..." type="text" />
											<input id="searchsubmit" value="Search" type="submit" />
										</div>
									</form> -->
						</div>
						<!-- end site search -->
					</div>
				</div>
	</div>
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
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

    <script src="/resources/js/main.js"></script>
	<script>
		var result = '${msg}';

		if (result == 'SUCCESS') {
			alert("처리가 완료되었습니다.");
			location.replace(self.location);
		}
	</script>
	
	<script type="text/javascript">
	function payDayButton() {
		
		var pay_date = $("#pay_day option:selected").val();
		var ob = new Object();
		ob.pay_date = pay_date;
		console.log(ob);
		$.ajax({
			type : "POST",
			url : "/pay/payDay",
			dataType : "json",
			data : ob,		
			success : function(data) {
				if(data == success){
					alert("성공");
				}
			}
		})
	}

	
	function selectButton() {
			
			var pay_date = $("#pay_date option:selected").val();
			var obj = new Object();
			obj.pay_date = pay_date;
		
			var html = "";

			$.ajax({
				type : "POST",
				url : "/pay/payList",
				dataType : "json",
				data : obj,			
				success : function(data) {
					
        			$("#month").empty();
					html += "<table id='month_deal' class='table table-bordered' style='text-align: center'><tr height='20'><td>월</td><td>매출(원)</td><td>전월대비</td></tr>";
					for(var i=1; i<=12; i++){
						
						html += "<tr><td>"+(i)+"</td>"
						html += "<td>"+data.month[i]+"</td>"
						if(i > 0){
							if(eval((data.month[i] - data.month[i-1]))>0){
								html += "<td>"+"+"+(data.month[i] - data.month[i-1])+"</td></tr>"
							}else {
								html += "<td>"+(data.month[i] - data.month[i-1])+"</td></tr>"
							}
						} else {
							html += "<td> \ </td></tr>"
						}
					}
				
					html +="</table>";
					$('#month').append(html);
					
					 $("td").each(function(){
							if ($(this).text().indexOf('-') > -1) {
								$(this).text($(this).text().replace('-','▼'));
								$(this).css("color", "red");
							} else if($(this).text().indexOf('+') > -1) {
								$(this).text($(this).text().replace('+','▲'));
								$(this).css("color", "blue");
							}
						})
					}
				})
			}		
	
	</script>
	<script> 
		
		$(function () {

		    $(".tab_content").hide();
		    $(".tab_content:first").show();

		    $("ul.tabs li").click(function () {
		        $("ul.tabs li").removeClass("active").css("color", "#333");
		        //$(this).addClass("active").css({"color": "darkred","font-weight": "bolder"});
		        $(this).addClass("active").css("color", "darkred");
		        $(".tab_content").hide()
		        var activeTab = $(this).attr("rel");
		        $("#" + activeTab).fadeIn()
		    });
		});
</script>
</body>
</html>
