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
<title>배송조회</title>
<meta name="description" content="">

<!-- CSS FILES -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resources/css/style.css">
<link rel="stylesheet" type="/resources/text/css" href="/resources/css/style.css" media="screen" data-name="skins">
<link rel="stylesheet" href="/resources/css/layout/wide.css"data-name="layout">
<link rel="stylesheet" type="/resources/text/css" href="/resources/css/switcher.css" media="screen" />
	
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
                            <h2>주문배송 관리</h2>
                        </div>
                        <nav id="breadcrumbs">
                            <ul>
                                <li><a href="index.html">홈</a>/</li>
                                <li>관리자 /</li>
                                <li>안전거래 배송관리</li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </section>
        
        <!-- 통계 -->
        <section class="content typography">
			<div class="container">
			
				<div class="row sub_content">
				
                    <div class="col-sm-4">
                        <div class="serviceBox_1">
                            <div class="service-icon">
                                <i class="fa fa-money"></i>
                            </div>
                            <div class="service-content">
                                <h3>오늘 총 매출</h3>
                                <h4>${todayMoney}원</h4>
                            </div>
                        </div>
                    </div>
				</div>
				
				
			<div class="row sub_content">
				<!-- <div class="container"> -->
                    <div class="col-md-6">
                       	<div class="serviceBox_2 blue">
                              <div id="chart_a">
	                                   <div data-rno="${janmonth}" id="janmonth"></div> 
	                                   <div data-rno="${febmonth}" id="febmonth"></div> 
	                            	   <div data-rno="${marmonth}" id="marmonth"></div> 
		                               <div data-rno="${aprmonth}" id="aprmonth"></div>
		                               <div data-rno="${maymonth}" id="maymonth"></div>
		                               <div data-rno="${junmonth}" id="junmonth"></div>
		                               <div data-rno="${julmonth}" id="julmonth"></div>
		                               <div data-rno="${augmonth}" id="augmonth"></div>
		                               <div data-rno="${sepmonth}" id="sepmonth"></div>
		                               <div data-rno="${octmonth}" id="octmonth"></div>
		                               <div data-rno="${novmonth}" id="novmonth"></div>
		                               <div data-rno="${decmonth}" id="decmonth"></div> 
	                          </div>
	                    </div>
	                </div>
	                          
	                   
                        <div class="col-md-6">
                        	<div class="serviceBox_2 blue">
	                              <div id="chart_div">
										<div data-rno="${wpercent}" id="w"></div> 
										<div data-rno="${ipercent}" id="i"></div> 
	                                    <div data-rno="${cpercent}" id="c"></div> 
	                               </div>
                       		 </div>
                       	</div>	 
             </div>        
         </div>
	</section>
        <!--/통계  -->
        

		<section class="content typography">
			<div class="container">
			
	<%-- 	 	 <div class="row sub_content">
                    <div class="col-md-12">
                        <div class="dividerHeading">
                            <h4><span>검색</span></h4>
                        </div>
                        
                        <!-- <form> -->
						<div class='box-body' align="center" >
									<select name="searchType">
										<option value="n"
											<c:out value="${cri.searchType == null?'selected':''}"/>>
											검색방법</option>
										<option value="t"
											<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
											주문자이름</option>
										<option value="c"
											<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
											책제목</option>
										
									</select> 
									<input type="text" name="keyword" id="keywordInput"
										value='${cri.keyword }' placeholder="Enter Search keywords..."
										size="25">
									<button id='searchBtn' class="btn-default">
										<i class="fa fa-search"></i>
									</button>
						
						
						
									<select id="sortType">
						
										<option value="n"
											<c:out value="${cri.searchType == null?'selected':''}"/>>
											정렬방법</option>
						
						
										<option value="d"
											<c:out value="${cri.sortType eq 'd'?'selected':''}"/>>
											날짜순</option>
										<option value="s"
											<c:out value="${cri.sortType eq 's'?'selected':''}"/>>
											안심거래순</option>
										<option value="p"
											<c:out value="${cri.sortType eq 'p'?'selected':''}"/>>가격순</option>
										<option value="b"
											<c:out value="${cri.sortType eq 'b'?'selected':''}"/>>
											책상태순</option>
									</select>
						
								</div>
						<!-- </form> --> 
                    </div>
                    </div> --%>
                    <!--검색 row-sub-content  -->
                    
                    
                    
          <!-- // 1. Datepicker(데이트피커) 사용하기 -->
        
		<input type="text" id="startday" placeholder="시작 날짜를 선택하세요">
		<input type="text" id="endday" placeholder="끝 날짜를 선택하세요">
		<input name="submit" type="submit" value="확인" id="datePick" />
		 
		 
		
			
		
		<!-- 날짜조회 -->
	<%-- 	<div class="row sub_content">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="dividerHeading">
							<h4><span>날짜조회 리스트</span></h4>
							<br>
							<br>
										<!-- <form> -->
									<table class="table table-hover">
										<thead>
											<tr>
												<td align="center">번호</td>
												<td align="center">책이름</td>
												<td align="center">주문자</td>
												<td align="center">총 주문액</td>
												<td align="center">배송 주소</td>
												<td align="center">결제 날짜</td>
												<td align="center">배송 상태</td>
												<td align="center">배송 메세지</td>
												<td></td>
											</tr>
										</thead>
										<tbody id="dtable">
											<c:forEach var="sl" items="${selectDateList}">
												<tr>
													<td align="center" data-rno="${sl.DELIVERY_ID}" >${sl.DELIVERY_ID}</td>
													<td align="center">${sl.BOOK_NAME}</td>
													<td align="center">${sl.PERSON_NAME}</td>
													<td align="center">${sl.PAY_AMOUNT}</td>
													<td align="center">${sl.DELIVERY_ADDRESS}</td>
													<td align="center"><fmt:formatDate value="${sl.PAY_DATE}" pattern='yyyy-MM-dd' /></td>
													<td align="center" >
												 	<c:if test="${sl.DELIVERY_STATE eq 'W'}"></c:if>>배송준비중 &nbsp;&nbsp;
													<c:if test="${sl.DELIVERY_STATE eq 'I'}"></c:if>>배송중 &nbsp;&nbsp;
													<c:if test="${sl.DELIVERY_STATE eq 'C'}"></c:if>>배송완료 &nbsp;&nbsp;
													</td>
													<td align="center">
													<c:choose>
													<c:when test="${empty sl.DELIVERY_MSG}">
													</c:when>
													<c:otherwise>
													<img alt="" src="/resources/img/msg.png" data-rno="${sl.DELIVERY_MSG}" class="msgimg" width="22px" height="15px">
													</c:otherwise>
													</c:choose>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<!-- </form> -->
						</div>
					</div>
				</div>  --%>
		<!--/날짜조회  -->
			



		
				<div class="row sub_content">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="dividerHeading">
							<h4><span>안심거래 배송 리스트</span></h4>
							<br>
							<br>
							
							<c:choose>
								<c:when test="${empty dlist }">
									<div class="media-body">
										<div class="well" style="margin-left: 50px;">
											<h2 align="center">안심거래 배송 리스트가 존재하지 않습니다.</h2>
										</div>
									</div>
								</c:when>
								<c:otherwise>
								
									<input type="button" value="변경" class="btn-default" id="update" onclick="change()">
									
										<!-- <form> -->
									<table class="table table-hover">
										<thead>
											<tr>
												<td align="center">번호</td>
												<td align="center">책이름</td>
												<td align="center">주문자</td>
												<td align="center">총 주문액</td>
												<td align="center">배송 주소</td>
												<td align="center">결제 날짜</td>
												<td align="center">배송 상태</td>
												<td align="center">배송 메세지</td>
												<td></td>
											</tr>
										</thead>
										<tbody id="dtable">
											<c:forEach var="d" items="${dlist}">
												<tr>
													<td align="center" id="d_id" data-rno="${d.DELIVERY_ID}" >${d.DELIVERY_ID}</td>
													<td align="center">${d.BOOK_NAME}</td>
													<td align="center">${d.PERSON_NAME}</td>
													<td align="center">${d.PAY_AMOUNT}</td>
													<td align="center">${d.DELIVERY_ADDRESS}</td>
													<td align="center"><fmt:formatDate value="${d.PAY_DATE}" pattern='yyyy-MM-dd' /></td>
													<td align="center" >
														<input type="radio" class="status" name="delState${d.DELIVERY_ID}" etc="W" value="W" <c:if test="${d.DELIVERY_STATE eq 'W'}">checked="checked"</c:if>>배송준비중 &nbsp;&nbsp;
														<input type="radio"  class="status" name="delState${d.DELIVERY_ID}" etc="I" value="I" <c:if test="${d.DELIVERY_STATE eq 'I'}">checked="checked"</c:if>>배송중 &nbsp;&nbsp;
														<input type="radio"class="status"  name="delState${d.DELIVERY_ID}" etc="C" value="C" <c:if test="${d.DELIVERY_STATE eq 'C'}">checked="checked"</c:if>>배송완료 &nbsp;&nbsp;
													</td>
													<td align="center">
														<c:choose>
															<c:when test="${empty d.DELIVERY_MSG}">
															</c:when>
															<c:otherwise>
																<img alt="" src="/resources/img/msg.png" data-rno="${d.DELIVERY_MSG}" class="msgimg" width="22px" height="15px">
															</c:otherwise>
														</c:choose>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								<!-- </form> -->
								</c:otherwise>
							</c:choose>	
						</div>
					</div>
				</div> <!--안심거래 배송리스트 row-sub-content  -->
			</div>
		</section>
		
		
		  <!-- 모달 -->
	
   <div class="modal fade" id="delModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content">
            <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal">
                  <span aria-hidden="true">×</span><span class="sr-only">취소</span>
               </button>
               <h3 class="modal-title" id="lineModalLabel">메세지</h3>
            </div>
            <div class="modal-body">
               <!-- content goes here -->
               <form>
                  <div class="form-group">
                     <label id="place">   </label>
                  </div>
               </form>
            </div>
			<div class="modal-footer">
				<div class="btn-group btn-group-justified" role="group" aria-label="group button">
		            <div class="btn-group" role="group">
		               <button type="button" class="btn btn-default" data-dismiss="modal"  role="button">취소</button>
		            </div>
		            <div class="btn-group btn-delete hidden" role="group">
		               <button type="button" id="delImage" class="btn btn-default btn-hover-red" data-dismiss="modal"  role="button">취소</button>
		            </div>
	          <!--   <div class="btn-group" role="group">
	               <button type="button" id="pay_success" class="btn btn-default btn-hover-green" data-action="save" role="button">결제</button>
	            </div> -->
	            </div>
			</div>
         </div>
      </div>
   </div>
   <!--modal끝  -->
		
		
		
	<!-- 페이징 -->
	<div class="col-sm-12 text-center">
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li><a
					href="delivery${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
			</c:if>
			<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
				<li<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
					<a href="delivery${pageMaker.makeSearch(idx)}">${idx}</a>
				</li>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a
					href="delivery${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
			</c:if>
		</ul>
	</div>
	<!--/페이징  -->
		
		
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
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<!-- <script src="//code.jquery.com/jquery-1.10.2.js"></script> -->
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script src="/resources/js/main.js"></script>


<script type="text/javascript">
	$(function(){	
		
		// 모달 
	    $(".msgimg").click(function(){
	    	console.log($(this).attr("data-rno"));
	    	$('#place').text("");
	    	$('#place').append($(this).attr("data-rno"));
	        $('#delModal').modal();
	
	     });
		
		
		$('#searchBtn').on("click", function(event) {

					self.location = "delivery"
							+ '${pageMaker.makeQuery(1)}'
							+ "&searchType="
							+ $("select option:selected").val()
							+ "&keyword="
							+ $('#keywordInput').val();
		});
		
	});

	function change() {
		var statusObject = new Object();
	
	 	$("input:radio[class='status']:checked").each(function (index) {
	 		statusObject.check = $(this).attr('etc');
	 		statusObject.d_id = $(this).parent().parent().find("td:eq(0)").attr("data-rno");
	 		
	 		$.ajax({
	 			url:"/book/deliveryAjax",
	 			type: "POST",
	 			data: statusObject,
	 			dataType:"json",
	 			
	 			success: function(data){
	 				//$('#dtable').empty();
	 				alert('gggg');
		 			},
	 			error:function(request,status,error){
	 				alert('error');
	 				}
	 		});
	 	})
	}

	$('#datePick').on("click",function(event){
		event.preventDefault();
	
		/*   var jsonData=new Object();
		jsonData.startday=$('#startday').val();
		jsonData.endday=$('#endday').val();   */
		
		
		var startday = $('#startday').val();
		var endday = $('#endday').val(); 
		
	    console.log($('#startday').val());
	    console.log($('#endday').val());
	       
	    
		$.ajax({
			type:'post',
			url:'/book/deliverydateAjax',
			headers: { 
			      "Content-Type": "application/json",
			      "X-HTTP-Method-Override": "POST" },
			dataType:'text',
			//data : JSON.stringify(jsonData), 
			data: JSON.stringify({startday:startday, endday:endday}),
			success:function(data){
				console.log("data : " + data);
				//alert('성공');
			},
			error:function(e){  
	            alert("에러"+e.responseText);  
	        }  
		});

	});

	
	
    google.charts.load('current', {packages: ['corechart', 'line']});
    google.charts.setOnLoadCallback(drawBasic);

    var janmonth=$('#janmonth').attr("data-rno");
    var febmonth=$('#febmonth').attr("data-rno");
    var marmonth=$('#marmonth').attr("data-rno");
    var aprmonth=$('#aprmonth').attr("data-rno");
    var maymonth=$('#maymonth').attr("data-rno");
    var junmonth=$('#junmonth').attr("data-rno");
    var julmonth=$('#julmonth').attr("data-rno");
    var augmonth=$('#augmonth').attr("data-rno");
    var sepmonth=$('#sepmonth').attr("data-rno");
    var octmonth=$('#octmonth').attr("data-rno");
    var novmonth=$('#novmonth').attr("data-rno");
    var decmonth=$('#decmonth').attr("data-rno"); 
    

    var date = new Date();
    var year  = date.getFullYear();
  //  var month = date.getMonth()-10;

/*  //이번달
  var month=date.getMonth()+1;
  if(month==12){
		 var next_month=1;
	 }
 //다음달
 var next_month=((date.getMonth()+1)%12)+1;

 //저번달
 var prev_month=date.getMonth();
 
 //12월이면 다음달 1월
 //12월이면 내년 1월
 if(year==12){
  var year=date.getFullYear()+1;
 } */
    
/* 	console.log("저번달"+prev_month);
	console.log("이번달"+month);
	console.log("다음달"+next_month);
    console.log("년"+year);
    console.log("월"+month); */
    
    
    function drawBasic() {
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'X');
          data.addColumn('number', '총금액');
          data.addRows([
        	  
        		[eval(year)+'년 1월', eval(janmonth) ],
        	    [eval(year)+'년 2월', eval(febmonth)],
        	    [eval(year)+'년 3월', eval(marmonth)],
        	    [eval(year)+'년 4월', eval(aprmonth)],
        	    [eval(year)+'년 5월', eval(maymonth)],
        	    [eval(year)+'년 6월', eval(junmonth)],
        	    [eval(year)+'년 7월', eval(julmonth)],
        	    [eval(year)+'년 8월', eval(augmonth)],
        	    [eval(year)+'년 9월', eval(sepmonth)],
        	    [eval(year)+'년 10월', eval(octmonth)],
        	    [eval(year)+'년 11월', eval(novmonth)],
        	    [eval(year)+'년 12월', eval(decmonth)],
            
          ]);
          var options = {           
        	title : '월별매출 비교',	  
        	width :'600',
            height : '500'
          };
          var chart = new google.visualization.LineChart(document.getElementById('chart_a'));
          chart.draw(data, options);
        }

	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);
	
	console.log($('#w').attr("data-rno"));
	var w=$('#w').attr("data-rno");
	var i=$('#i').attr("data-rno");
	var c=$('#c').attr("data-rno");
	
	console.log(c);


	function drawChart() {
	
	  var data = new google.visualization.DataTable();
	  data.addColumn('string', 'state');
	  data.addColumn('number', 'p');
	  data.addRows([
	    ['배송중',  eval(w)],
	    ['배송완료', eval(i)],
	    ['배송준비중', eval(c)],
	  //  ['Sausage', 10], // Below limit.
	  //  ['Anchovies', 9] // Below limit.
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

	$("#startday").datepicker({
	    showButtonPanel : false,
	    dateFormat : "yymmdd",
	   // altField : '#startday'
	    altField: ".selecter"
	    
	 });
	 
	 $("#endday").datepicker({
	    dateFormat : "yymmdd",
	  //  altField : '#endday'
	    altField: ".selecter"
	 });
               
</script>

         
<!-- <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script> -->
		
    <!-- Start Style Switcher -->
    <div class="switcher"></div>
    <!-- End Style Switcher -->
</body>
</html>


