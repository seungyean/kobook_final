<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html class="no-js" lang="en"> <!--<![endif]-->
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Electrify Responsive Multipurpose Template</title>
<meta name="description" content="">

<!-- CSS FILES -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resources/css/style.css">
<link rel="stylesheet" type="/resources/text/css"
	href="/resources/css/style.css" media="screen" data-name="skins">
<link rel="stylesheet" href="/resources/css/layout/wide.css"
	data-name="layout">

<link rel="stylesheet" type="/resources/text/css"
	href="/resources/css/switcher.css" media="screen" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
                           <h1><a href="index.html">관리자WORLD</a></h1>
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

                                    <li><a href="#">게시판 관리</a>
                                         
                                    </li>

                                    <li><a href="#">매출정산 관리</a>
                                        
                                    </li>

                                    <li><a href="#">접속통계 관리</a>
                                        
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
		
		<section class="content service">
			<div class="container">
				<div class="row sub_content">
                    <div class="col-sm-4">
                        <div class="serviceBox_1">
                            <div class="service-icon">
                                <i class="fa fa-money"></i>
                            </div>
                            <div class="service-content">
                                <h3>오늘 총 매출</h3>
                                <p>1,000,000,000 ${payVO.pay_price }</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="serviceBox_1">
                            <div class="service-icon">
                                <i class="fa fa-user"></i>
                            </div>
                            <div class="service-content">
                                <h3>오늘 가입자</h3>
                                <p>2명쯤 될라나?? 미구현${personVO.person_id }</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="serviceBox_1">
                            <div class="service-icon">
                                <i class="fa fa-android"></i>
                            </div>
                            <div class="service-content">
                                <h3>오늘 총 접속자</h3>
                                <p>${VisitVO.count } 명</p>
                            </div>
                        </div>
                    </div>
				</div>
				<div class="row sub_content">
                    <div class="col-md-3 col-sm-6">
                        <div class="serviceBox_2 blue">
                               <div id="chart_a"></div>
                        </div>
                    </div>
				</div>

                    <div class="container">
                       <!--  <div class="row sub_content"> -->
                            <div class="col-md-12 col-lg-12">
                            <div class="col-sm-4">
                                <div class="serviceBox_5">
                                    <div id="chart_div"></div>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="serviceBox_5">
                                       <div id="chart_divv"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
		</section>
		
	</section><!--end wrapper-->

	<!--start footer-->
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-3 col-lg-3">
                    <div class="widget_title">
                        <h4><span>About Us</span></h4>
                    </div>
                    <div class="widget_content">
                        <p>Donec earum rerum hic tenetur ans sapiente delectus, ut aut reiciendise voluptat maiores alias consequaturs aut perferendis doloribus asperiores.</p>
                        <ul class="contact-details-alt">
                            <li><i class="fa fa-map-marker"></i> <p><strong>Address</strong>: #2021 Lorem Ipsum</p></li>
                            <li><i class="fa fa-user"></i> <p><strong>Phone</strong>:(+91) 9000-12345</p></li>
                            <li><i class="fa fa-envelope"></i> <p><strong>Email</strong>: <a href="#">mail@example.com</a></p></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6 col-md-3 col-lg-3">
                    <div class="widget_title">
                        <h4><span>Recent Posts</span></h4>
                    </div>
                    <div class="widget_content">
                       <ul class="links">
                            <li><a href="#">Aenean commodo ligula eget dolor<span>November 07, 2015</span></a></li>
                            <li><a href="#">Temporibus autem quibusdam <span>November 05, 2015</span></a></li>
                            <li><a href="#">Debitis aut rerum saepe <span>November 03, 2015</span></a></li>
                            <li><a href="#">Et voluptates repudiandae <span>November 02, 2015</span></a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6 col-md-3 col-lg-3">
                    <div class="widget_title">
                        <h4><span>Twitter</span></h4>

                    </div>
                    <div class="widget_content">
                        <ul class="tweet_list">
                            <li class="tweet_content item">
                                <p class="tweet_link"><a href="#">@jquery_rain </a> Lorem ipsum dolor et, consectetur adipiscing eli</p>
                                <span class="time">29 September 2015</span>
                            </li>
                            <li class="tweet_content item">
                                <p class="tweet_link"><a href="#">@jquery_rain </a> Lorem ipsum dolor et, consectetur adipiscing eli</p>
                                <span class="time">29 September 2015</span>
                            </li>
                            <li class="tweet_content item">
                                <p class="tweet_link"><a href="#">@jquery_rain </a> Lorem ipsum dolor et, consectetur adipiscing eli</p>
                                <span class="time">29 September 2015</span>
                            </li>
                        </ul>
                    </div>
                    <div class="widget_content">
                        <div class="tweet_go"></div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-3 col-lg-3">
                    <div class="widget_title">
                        <h4><span>Flickr Gallery</span></h4>
                    </div>
                    <div class="widget_content">
                        <div class="flickr">
                            <ul id="flickrFeed" class="flickr-feed"></ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
	<!--end footer-->
	
	<section class="footer_bottom">
		<div class="container">
			<div class="row">
            <div class="col-sm-6">
                <p class="copyright">&copy; Copyright 2015 Electrify | Powered by  <a href="http://www.jqueryrain.com/">jQuery Rain</a></p>
            </div>

            <div class="col-sm-6 ">
                <div class="footer_social">
                    <ul class="footbot_social">
                        <li><a class="fb" href="#." data-placement="top" data-toggle="tooltip" title="Facebook"><i class="fa fa-facebook"></i></a></li>
                        <li><a class="twtr" href="#." data-placement="top" data-toggle="tooltip" title="Twitter"><i class="fa fa-twitter"></i></a></li>
                        <li><a class="dribbble" href="#." data-placement="top" data-toggle="tooltip" title="Dribbble"><i class="fa fa-dribbble"></i></a></li>
                        <li><a class="skype" href="#." data-placement="top" data-toggle="tooltip" title="Skype"><i class="fa fa-skype"></i></a></li>
                        <li><a class="rss" href="#." data-placement="top" data-toggle="tooltip" title="RSS"><i class="fa fa-rss"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
		</div>
	</section>

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
    <script type="text/javascript" src="/resources/js/jquery.matchHeight-min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery-scrolltofixed-min.js"></script>

    <script src="/resources/js/main.js"></script>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
   
       <script type="text/javascript">
    google.charts.load('current', {packages: ['corechart', 'line']});
    google.charts.setOnLoadCallback(drawBasic);
    function drawBasic() {
          var data = new google.visualization.DataTable();
          data.addColumn('number', 'X');
          data.addColumn('number', '접속자');
          data.addRows([
            
          ]);
          var options = {           
        	title : '접속자 현황',	  
        	width :'1100',
            height : '500'
          };
          var chart = new google.visualization.LineChart(document.getElementById('chart_a'));
          chart.draw(data, options);
        }
  </script> 

<script type="text/javascript">
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {

  var data = new google.visualization.DataTable();
  data.addColumn('string', 'Pizza');
  data.addColumn('number', 'Populartiy');
  data.addRows([
    ['Pepperoni', 33],
    ['Hawaiian', 26],
    ['Mushroom', 22],
    ['Sausage', 10], // Below limit.
    ['Anchovies', 9] // Below limit.
  ]);

  var options = {
    title: '주문배송 접수 / 처리',
    sliceVisibilityThreshold: .2,
    width :'500',
    height : '500'
  };

  var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
  chart.draw(data, options);
}
</script>


<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">
</script>

<script>
	google.charts.load('current', {packages:['corechart']});
	google.charts.setOnLoadCallback(drawChart);

	// 차트 옵션을 전역으로 설정했습니다. 설정을 바꿔보는 예제를 만들기 위해서요.
	var chart_options = {
		title : '회원가입 현황',
		width : 500,
		height : 400,
		bar : {
			groupWidth : '50%'
		},
		isStacked : true // 그래프 쌓기(스택), 기본값은 false
	};

	function drawChart(){

		// 차트 데이터
		var data = new google.visualization.arrayToDataTable([
			['년대', '항목1', '항목2', '항목3', '항목4'], // 제목 그리고 항목들
			['1950', 10, 20, 30, 40], // 제목과 항목수를 맞춰주어야 합니다.
			['1960', 15, 30, 35, 20],
			['1970', 20, 25, 40, 30],
			['1980', 10, 30, 20, 50],
			['1990', 5, 10, 25, 55]
		]);

		var chart = new google.visualization.ColumnChart(document.getElementById('chart_divv'));
		chart.draw(data, chart_options);
	}
</script>


</body>
</html>