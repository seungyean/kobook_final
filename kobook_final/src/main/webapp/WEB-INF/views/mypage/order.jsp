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
	<title>주문</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

    <!-- CSS FILES -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css" media="screen" data-name="skins">
    <link rel="stylesheet" href="/resources/css/layout/wide.css" data-name="layout">

    <link rel="stylesheet" type="text/css" href="/resources/css/switcher.css" media="screen" /></head>
   <script type="text/javascript">
   
   $(function(){
	   
	   
	   /* var name = '';
	    
	   $("#del").prop(function(){
		   
		   $("#delivery").val($("#order").val())
		   var name = $('#oname').val();
		   $('').val(name);
		   
	   }); */
	   
	   
	   $("input:radio[name='del']").change(function(e) {

	       var rVal = $(this).val();
	       console.log(rVal);

	       if(rVal != "Y"){
	          $("#oname").val($("#dname").val())
	          $("#opostcode").val($("#dpostcode").val())
	       }else{
	        /*  $('#상위div아이디 input[type="text"]').val("");
	         $('#상위div아이디 input[type="number"]').val(""); */
	      }

	    });
	      
	   
	   
	   
	   
		
	   
	   
	});

   
   
   </script>
   
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
                            <h2>주문</h2>
                        </div>
                        <nav id="breadcrumbs">
                            <ul>
                                <li><a href="index.html">홈</a>/</li>
                                <li>주문 </li>
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
						<div >
							<h4><img src="/resources/img/order.PNG" style="width: 1000px; margin-left: 85px "></h4>
							<br>
							<br>
							
							<!-- 주문정보 -->
							<div class="container">
							    <div class="row">
							        <div class="col-sm-12 col-md-10 col-md-offset-1">
							            <h3>주문 내역</h3>
							            	<table class="table table-hover">
								                <thead>
								                    <tr>
								                        <th>이미지</th>
								                        <th class="text-center">판매가</th>
								                        <th class="text-center">수량</th>
								                        <th class="text-center">적립금</th>
								                        <th class="text-center">배송비</th>
								                    </tr>
								                </thead>
								                <tbody>
								                    <c:forEach var="element" items="${orderList }" varStatus="s">
													<tr>
								                        <td class="col-sm-8 col-md-6">
									                        <div class="media">
									                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png" style="width: 72px; height: 72px;"> </a>
									                            <div class="media-body">
									                                <h4 class="media-heading"><a href="#">&nbsp;&nbsp;${element.BOOK_NAME }</a></h4>
									                                <h5 class="media-heading"><a href="#">&nbsp;&nbsp;&nbsp;${element.BOOK_PUBLISH }</a></h5>
									                            </div>
									                        </div>
								                        </td>
								                        <td class="col-sm-1 col-md-1 text-center" id="m_price" ><strong>${element.BOOK_M_PRICE }</strong></td>
								                        <td class="col-sm-1 col-md-1 text-center"><strong>1</strong></td>
								                        <td class="col-sm-1 col-md-1 text-center"><strong>${bookMileage}P</strong></td>
								                        <td class="col-sm-1 col-md-1 text-center"><strong>2000원</strong></td>
								                    </tr>
												</c:forEach>
								                </tbody>
							            </table>
							        </div>
							    </div>
							</div>
							<!-- /주문정보 -->
							
							<!-- 주문자 정보 -->
							<div class="container">
							    <div class="row">
							        <div class="col-sm-12 col-md-10 col-md-offset-1">
							            <h3>주문자 정보</h3>
							            <p class="required">
							            <img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif" alt="필수"> 필수입력사항</p>
							            <div class="orderArea">
											<div class="boardWrite">
												<table  summary="" class="table table-hover"  id="order">
													<tbody class="address_form ">
													
														<tr>
															<th scope="row">주문하시는 분 <img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif"alt="필수"></th>
															<td><input id="oname" name="oname" class="inputTypeText" placeholder="${personVO.person_name}" size="15" value=""type="text" readonly="readonly"></td>
														</tr>
														
														<tr>
															<th scope="row">주소 <img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif" alt="필수"></th>
															<td><input id="opostcode" name="opostcode" class="inputTypeText" placeholder="${personVO.person_postcode}" size="6" maxlength="6" readonly="readonly" value="" type="text">
																<input id="ozipcode2" name="ozipcode2" class="inputTypeText" placeholder="" size="6" maxlength="6" readonly="readonly" value="" type="text" style="display: none;"> 
																<a href="#none" id="btn_search_ozipcode"><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/btn_zipcode.gif" alt="우편번호"></a>
																<br> 
																<input id="oaddr1" name="oaddr1" class="inputTypeText" placeholder="${personVO.person_address}" size="40" readonly="readonly" value="" type="text"> 
																<spanclass="grid">기본주소</span><br> 
																<input id="oaddr2" name="oaddr2" class="inputTypeText" placeholder="${personVO.person_address2}" size="40" value="" type="text" readonly="readonly"> <span class="grid">나머지주소</span>
															</td>
														</tr>
														
														<tr>
															<th scope="row">휴대전화 <img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif" alt="필수"></th>
															<td>
															
															<c:set var="name" value="${phone0}" />
																<select id="ophone1_1" name="ophone1_[]" >
																	<c:choose>
					   													<c:when test="${phone0 eq '010' }">
					      												  <option value="010" selected="selected">010</option>
					   													</c:when>
					   													<c:when test="${phone0 eq '011' }">
					      												  <option value="010" selected="selected">011</option>
					   													</c:when>
					   													<c:when test="${phone0 eq '016' }">
					      												  <option value="010" selected="selected">016</option>
					   													</c:when>
					   													<c:when test="${phone0 eq '017' }">
					      												  <option value="010" selected="selected">017</option>
					   													</c:when>
					   													<c:when test="${phone0 eq '018' }">
					      												  <option value="010" selected="selected">018</option>
					   													</c:when>
					   													<c:when test="${phone0 eq '019' }">
					      												  <option value="010" selected="selected">019</option>
					   													</c:when>
					  												</c:choose>
																</select>
															- <input id="ophone1_2" name="ophone2_[]" maxlength="4" size="4" value="" type="text" placeholder="${phone1 }" >
															- <input id="ophone1_3" name="ophone2_[]" maxlength="4" size="4" value="" type="text"  placeholder="${phone2 }" ></td>
														</tr>
														<tr>
															<th scope="row">이메일 <img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif" alt="필수"></th>
															<td>
																<input id="oemail1" name="oemail1" value="" type="text" readonly="readonly" placeholder="${email0 }">@
																<input id="oemail2" name="oemail2" readonly="readonly" value="" type="text" placeholder="${email1 }">
																	<select id="oemail3">
																		<option value="" selected="selected">- 이메일 선택 -</option>
																		<option value="naver.com">naver.com</option>
																		<option value="daum.net">daum.net</option>
																		<option value="nate.com">nate.com</option>
																		<option value="hotmail.com">hotmail.com</option>
																		<option value="yahoo.com">yahoo.com</option>
																		<option value="empas.com">empas.com</option>
																		<option value="korea.com">korea.com</option>
																		<option value="dreamwiz.com">dreamwiz.com</option>
																		<option value="gmail.com">gmail.com</option>
																		<option value="etc">직접입력</option>
																	</select>
																<p class="grid">
																	이메일을 통해 주문처리과정을 보내드립니다.<br>이메일 주소란에는 반드시 수신가능한
																	이메일주소를 입력해 주세요.
																</p></td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
							        </div>
							    </div>
							</div>
							<!-- /주문자 정보 -->
							
							<!-- 배송자 정보 -->
							<div class="container">
							    <div class="row">
							        <div class="col-sm-12 col-md-10 col-md-offset-1">
							            <h3>배송지 정보</h3>
							            <p class="required">
							            <img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif" alt="필수"> 필수입력사항</p>
							            <div class="orderArea">
											<div class="boardWrite">
												<table  summary="" class="table table-hover" id="delivery">
													<tbody class="address_form ">
														<tr>
															<th scope="row">배송지 선택</th>	
															<td><input type="radio" value="Y" name="del">&nbsp;주문자 정보와 동일 &nbsp;<input type="radio" value="N" name="del">&nbsp;새로운 배송지</td>
														</tr>
      														    <tr>
															<th scope="row">받으시는 분 <img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif"alt="필수"></th>
															<td><input id="dname" name="dname" class="inputTypeText" size="15" value=""type="text"placeholder="" ></td>
														</tr>
														
														<tr>
															<th scope="row">주소 <img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif" alt="필수"></th>
															<td><input id="dpostcode" name="dpostcode" class="inputTypeText" size="6" maxlength="6"  value="" type="text">
																<input id="ozipcode2" name="ozipcode2" class="inputTypeText" size="6" maxlength="6"  value="" type="text" style="display: none;"> 
																<a href="#none" id="btn_search_ozipcode"><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/btn_zipcode.gif" alt="우편번호"></a>
																<br> 
																<input id="daddr1" name="daddr1" class="inputTypeText" size="40"  value="" type="text"> 
																<spanclass="grid">기본주소</span><br> 
																<input id="daddr2" name="daddr2" class="inputTypeText" " size="40" value="" type="text"><span class="grid">나머지주소</span>
															</td>
														</tr>
														
														<tr>
															<th scope="row">휴대전화 <img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif" alt="필수"></th>
															<td>
																<select id="dphone1_1" name="ophone2_[]">
																		<option value="010">010</option>
																		<option value="011">011</option>
																		<option value="016">016</option>
																		<option value="017">017</option>
																		<option value="018">018</option>
																		<option value="019">019</option>
																</select>
															- <input id="dphone1_2" name="ophone2_[]" maxlength="4" size="4" value="" type="text">
															- <input id="dphone1_3" name="ophone2_[]" maxlength="4" size="4" value="" type="text"></td>
														</tr>
														<tr>
															<th scope="row">이메일 <img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif" alt="필수"></th>
															<td>
																<input id="demail1" name="oemail1" value="" type="text">@
																<input id="demail2" name="oemail2" readonly="readonly" value="" type="text">
																	<select id="demail3">
																		<option value="" selected="selected">- 이메일 선택 -</option>
																		<option value="naver.com">naver.com</option>
																		<option value="daum.net">daum.net</option>
																		<option value="nate.com">nate.com</option>
																		<option value="hotmail.com">hotmail.com</option>
																		<option value="yahoo.com">yahoo.com</option>
																		<option value="empas.com">empas.com</option>
																		<option value="korea.com">korea.com</option>
																		<option value="dreamwiz.com">dreamwiz.com</option>
																		<option value="gmail.com">gmail.com</option>
																		<option value="etc">직접입력</option>
																	</select>
																<p class="grid">
																	이메일을 통해 주문처리과정을 보내드립니다.<br>이메일 주소란에는 반드시 수신가능한
																	이메일주소를 입력해 주세요.
																</p></td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
							        </div>
							    </div>
							</div>
							<!-- /배송자 정보 -->
							
							<!-- 결제 -->
							<div class="container">
							    <div class="row">
							        <div class="col-sm-12 col-md-10 col-md-offset-1">
							            <h3>결제</h3>
							            <table class="table table-hover">
							                <thead>
							                    <tr>
							                        <th>이미지</th>
							                        <th class="text-center">판매가</th>
							                        <th class="text-center">수량</th>
							                        <th class="text-center">적립금</th>
							                        <th class="text-center">배송비</th>
							                    </tr>
							                </thead>
							                <tbody>
							                    <c:forEach var="element" items="${orderList }" varStatus="s">
												<tr>
							                        <td class="col-sm-8 col-md-6">
								                        <div class="media">
								                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png" style="width: 72px; height: 72px;"> </a>
								                            <div class="media-body">
								                                <h4 class="media-heading"><a href="#">&nbsp;&nbsp;${element.BOOK_NAME }</a></h4>
								                                <h5 class="media-heading"><a href="#">&nbsp;&nbsp;&nbsp;${element.BOOK_PUBLISH }</a></h5>
								                            </div>
								                        </div>
							                        </td>
							                        <td class="col-sm-1 col-md-1 text-center" id="m_price" ><strong>${element.BOOK_M_PRICE }</strong></td>
							                        <td class="col-sm-1 col-md-1 text-center"><strong>1</strong></td>
							                        
							                        <td class="col-sm-1 col-md-1 text-center"><strong>${element.BOOK_M_PRICE }P</strong></td>
							                        <td class="col-sm-1 col-md-1 text-center"><strong>2000원</strong></td>
							                    </tr>
											</c:forEach>
							                </tbody>
							            </table>
							        </div>
							    </div>
							</div>
							<!-- /결제 -->
							
							
							
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

    <!-- Start Style Switcher -->
    <div class="switcher"></div>
    <!-- End Style Switcher -->
</body>
</html>