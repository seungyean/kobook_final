<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
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
    <link rel="stylesheet" type="text/css" href="/resources/css/switcher.css" media="screen" />

    <script type="text/javascript" src="/resources/js/jquery-1.10.2.min.js"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
   	<script>
   
   $(function(){
	   
	   var del_price = 2000;
	   $('#total_price').html(parseInt($('#book_price').text()) + del_price);
	   
	   // 마일리지 사용
	   $("#input_mile").keyup(function() {
		var book_price = parseInt($('#book_price').text());
   		var input_mile = parseInt($('#input_mile').val());
   		$('#total_price').html($('#book_price').text() - input_mile + del_price );
   		$('#sale_price').html($('#input_mile').val());
   		var total_mile = $('#totalMileage').html();
   		
   		if(input_mile > total_mile ){
   			alert("사용가능 마일리지 초과!!");
   			$('#input_mile').val(0);
   		}
   		
		});
	   
	   //결제버튼 클릭 
 	   $("#orderSuccess").click(function() {
		   var data = $('#bookID').html();
		   var data2 = $('#total_price').html();
		   var data3 = $('#dpostcode').attr("placeholder")+', ' + $('#daddr1').attr("placeholder")+', ' + $('#daddr2').attr("placeholder"); 
		   var data4 = $('#omessage').val();
		   var data5 = $('#mileageAvg').html();
		   var data6 = $('#input_mile').val();
		   
		   $('#total_price2').val(data2);
		   $('#addr').val(data3);
		   $('#msg').val(data4);
		   $('#mileageAvg2').val(data5);
		   $('#input_mile2').val(data6);
		   $("#form1").attr("action", "/mypage/order");
		   $("#form1").attr("method", "post");
		   $("#form1").submit();
		});
	   
	   // 우편번호 api
  	  $("#btn_post").on("click",function(){
	   new daum.Postcode({
		   oncomplete: function(data) {
               // 각 주소의 노출 규칙에 따라 주소를 조합한다.
               // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
               var fullAddr = ''; // 최종 주소 변수
               var extraAddr = ''; // 조합형 주소 변수

               // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
               if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                   fullAddr = data.roadAddress;
               } else { // 사용자가 지번 주소를 선택했을 경우(J)
                   fullAddr = data.jibunAddress;
               }

               // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
               if(data.userSelectedType === 'R'){
                   //법정동명이 있을 경우 추가한다.
                   if(data.bname !== ''){
                       extraAddr += data.bname;
                   }
                   // 건물명이 있을 경우 추가한다.
                   if(data.buildingName !== ''){
                       extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                   }
                   // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                   fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
               }

               // 우편번호와 주소 정보를 해당 필드에 넣는다.
               document.getElementById('dpostcode').value = data.zonecode; //5자리 새우편번호 사용
               document.getElementById('daddr1').value = fullAddr;

               // 커서를 상세주소 필드로 이동한다.
               document.getElementById('daddr2').focus();
           }
	    }).open();
	   }); 
	   
	 //배송지 정보 : 새로운배송지 라디오 버튼 클릭시
	   $("#newDel").on("click",function(){
			   $('#dname').attr("placeholder", " ");
			   $('#dpostcode').attr("placeholder", " ");
			   $('#daddr1').attr("placeholder", " ");
			   $('#daddr2').attr("placeholder", " ");
			   $('#dphone1_1').attr("placeholder", " ");
			   $('#dphone1_2').attr("placeholder", " ");
			   $('#dphone1_3').attr("placeholder", " ");
		   }); 
   
 	//배송지 정보 : 주문자 동일 라디오 버튼 클릭시
	   $("#orderDel").on("click",function(){
		   $('#dname').attr("placeholder", $('#oname').attr("placeholder"));
		   $('#dpostcode').attr("placeholder", $('#opostcode').attr("placeholder"));
		   $('#daddr1').attr("placeholder", $('#oaddr1').attr("placeholder"));
		   $('#daddr2').attr("placeholder", $('#oaddr2').attr("placeholder"));
		   $('#dphone1_1').attr("placeholder", $('#ophone1_1').attr("placeholder"));
		   $('#dphone1_2').attr("placeholder", $('#ophone1_2').attr("placeholder"));
		   $('#dphone1_3').attr("placeholder", $('#ophone1_3').attr("placeholder"));
		   
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
							<h4><img src="/resources/img/order.PNG" style="width: 1000px; margin-left: 85px "></h4><br><br>
							<!-- 주문정보 -->
							<div class="container">
							    <div class="row">
							        <div class="col-sm-12 col-md-10 col-md-offset-1">
							            <h3>주문 내역</h3>
							            <form id="form1" action="/mypage/order2" method="post">
							            <input type="hidden" name="book_id" value="${oneBook.book_id }">
							            <input type="hidden" id="total_price2" name="total_price2" value="">
							            <input type="hidden" id="addr" name="addr" value="">
							            <input type="hidden" id="msg" name="msg" value="">
							            <input type="hidden" id="mileageAvg2" name="mileageAvg2" value="">
							            <input type="hidden" id="input_mile2" name="input_mile2" value="">
							            </form>
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
													<tr>
								                        <td class="col-sm-8 col-md-6">
									                        <div class="media">
									                            <a class="thumbnail pull-left" href="#"> 
									                            	<img class="thumbnail" alt="NO IMAGE" src="/mypage/displayFile?fileName=${oneBook.book_img}" style="width: 72px; height: 72px;">
									                            </a>
									                            <div class="media-body">
									                                <h4 class="media-heading"><a href="#">&nbsp;&nbsp;${oneBook.book_name }</a></h4>
									                                <h5 class="media-heading"><a href="#">&nbsp;&nbsp;&nbsp;${oneBook.book_publish }</a></h5>
									                            </div>
									                        </div>
								                        </td>
								                        <td class="col-sm-1 col-md-1 text-center" id="m_price" ><strong>${oneBook.book_m_price }</strong><strong>원</strong></td>
								                        <td class="col-sm-1 col-md-1 text-center" id="bookID" style="display:none;" >${oneBook.book_id }</td>
								                        <td class="col-sm-1 col-md-1 text-center"><strong>1</strong></td>
								                        <td class="col-sm-1 col-md-1 text-center">
								                       <fmt:parseNumber var="avg" value="${oneBook.book_m_price /100}" integerOnly="true" />
								                        	<strong id="mileageAvg">${avg}</strong>
								                        	<strong>P</strong>
								                        </td>
								                        <td class="col-sm-1 col-md-1 text-center"><strong>2000원</strong></td>
								                    </tr>
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
															<td>
																<input type="radio" value="Y" name="sameAddr" id="orderDel">&nbsp;주문자 정보와 동일 &nbsp;
																<input type="radio" value="N" name="sameAddr" id="newDel">&nbsp;새로운 배송지
															</td>
														</tr>
      														    <tr>
															<th scope="row">받으시는 분 <img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif"alt="필수"></th>
															<td><input id="dname" name="dname" class="inputTypeText" size="15" value=""type="text"placeholder="${personVO.person_name}" ></td>
														</tr>
														
														<tr>
															<th scope="row">주소 <img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif" alt="필수"></th>
															<td><input id="dpostcode" name="dpostcode" class="inputTypeText" placeholder="${personVO.person_postcode}" size="6" maxlength="6" readonly="readonly" value="" type="text">
																<input id="dzipcode2" name="dzipcode2" class="inputTypeText" placeholder="" size="6" maxlength="6" readonly="readonly" value="" type="text" style="display: none;"> 
																<a href="#none" id="btn_post"><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/btn_zipcode.gif" alt="우편번호"></a>
																<br> 
																<input id="daddr1" name="daddr1" class="inputTypeText" placeholder="${personVO.person_address}" size="40" readonly="readonly" value="" type="text"> 
																<spanclass="grid">기본주소</span><br> 
																<input id="daddr2" name="daddr2" class="inputTypeText" placeholder="${personVO.person_address2}" size="40" value="" type="text" > <span class="grid">나머지주소</span>
															</td>
														</tr>
														
														<tr>
															<th scope="row">휴대전화 <img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/ico_required.gif" alt="필수"></th>
															<td>
															
																<select id="dphone1_1" name="dphone1_[]" >
																	<c:choose>
																		<c:when test="${phone0 eq ' ' }">
					      												  <option value="010" selected="selected">010</option>
					      												  <option value="010" >011</option>
					      												  <option value="010" >016</option>
					      												  <option value="010" >017</option>
					      												  <option value="010" >018</option>
					      												  <option value="010" >019</option>
					   													</c:when>
					   													<c:when test="${phone0 eq '010' }">
					      												  <option value="010" selected="selected">010</option>
					      												  <option value="010" >011</option>
					      												  <option value="010" >016</option>
					      												  <option value="010" >017</option>
					      												  <option value="010" >018</option>
					      												  <option value="010" >019</option>
					   													</c:when>
					   													<c:when test="${phone0 eq '011' }">
					      												  <option value="010" >010</option>
					      												  <option value="010" selected="selected">011</option>
					      												  <option value="010" >016</option>
					      												  <option value="010" >017</option>
					      												  <option value="010" >018</option>
					      												  <option value="010" >019</option>
					   													</c:when>
					   													<c:when test="${phone0 eq '016' }">
					      												  <option value="010" >010</option>
					      												  <option value="010" >011</option>
					      												  <option value="010" selected="selected">016</option>
					      												  <option value="010" >017</option>
					      												  <option value="010" >018</option>
					      												  <option value="010" >019</option>
					   													</c:when>
					   													<c:when test="${phone0 eq '017' }">
					      												  <option value="010" >010</option>
					      												  <option value="010" >011</option>
					      												  <option value="010" >016</option>
					      												  <option value="010" selected="selected">017</option>
					      												  <option value="010" >018</option>
					      												  <option value="010" >019</option>
					   													</c:when>
					   													<c:when test="${phone0 eq '018' }">
					      												  <option value="010" >010</option>
					      												  <option value="010" >011</option>
					      												  <option value="010" >016</option>
					      												  <option value="010" >017</option>
					      												  <option value="010" selected="selected">018</option>
					      												  <option value="010" >019</option>
					   													</c:when>
					   													<c:when test="${phone0 eq '019' }">
					      												  <option value="010" >010</option>
					      												  <option value="010" >011</option>
					      												  <option value="010" >016</option>
					      												  <option value="010" >017</option>
					      												  <option value="010" >018</option>
					      												  <option value="010" selected="selected" >019</option>
					   													</c:when>
					  												</c:choose>
																</select>
															- <input id="dphone1_2" name="dphone2_[]" maxlength="4" size="4" value="" type="text" placeholder="${phone1 }" >
															- <input id="dphone1_3" name="dphone2_[]" maxlength="4" size="4" value="" type="text"  placeholder="${phone2 }" ></td>
														</tr>
														<tr>
														<th scope="row">배송메시지</th>
														   <td>
														      <textarea id="omessage" name="omessage"  maxlength="255" cols="70" ></textarea>                        
														      <div class="message displaynone">
															      <ul>
																	<li>배송메시지란에는 배송시 참고할 사항이 있으면 적어주십시오.</li>
																	<li>50자 내외로 입력해주십시오.</li>
															      </ul>						
															  </div>
														    </td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
							        </div>
							    </div>
							</div>
							<!-- /배송자 정보 -->
							
							<!-- 결제예정, 마일리지 -->
							<div class="container">
							    <div class="row">
							        <div class="col-sm-12 col-md-10 col-md-offset-1">
							            <h3>결제 예정 금액</h3>
							            <p class="required">
							            <div class="totalArea">
											<div class="boardWrite">
												<table  summary="" class="table table-hover" >
													<thead>
														<tr>
															<th scope="col" style="width: 400px; text-align: center;" >
																<span>총 주문 금액</span>
															</th>
															<th scope="col" style="width: 400px; text-align: center;">
																<span>총 </span>
																<span id="total_addsale_text" class="">할인</span>
															</th>
															<th scope="col" style="width: 400px; text-align: center;">
																<span>총 </span>
																<span id="total_addsale_text" class="">배송비</span>
															</th>
															<th scope="col" style="width: 400px; text-align: center;" >총 결제예정 금액</th>
														</tr>
													</thead>
													<tbody class="address_form ">
															<tr>
																<td class="price">
																	<div style="text-align: center;">
																		<strong id="book_price">${oneBook.book_m_price }</strong>
																		<strong>원</strong>
																	</div>
																</td>
																<td class="option ">
																	<div style="text-align: center;">
																		<strong>-&nbsp;</strong><strong id="sale_price">0</strong>
																		<strong>원</strong>
																	</div>
																</td>
																<td class="option ">
																	<div style="text-align: center;" >
																		<strong>+&nbsp;</strong><strong id="del_price">2000원</strong>
																	</div>
																</td>
																<td class="total">
																	<div style="text-align: center;">
																		<strong>=&nbsp;</strong><strong id="total_price">0</strong>
																		<strong>원</strong>
																	</div>
																</td>
															</tr>
													</tbody>
												</table>
												<table  summary="" class="table table-hover" >
													<tbody class="address_form ">
														<tr>
																<th scope="row" style="text-align: center;">적립금</th>
																<td >
																	<p>
																		<input id="input_mile" name="input_mile" class="inputTypeText" placeholder="" size="10" value="0" type="text" /> 
																		원 (총 사용가능 적립금 : <strong class="point" id="totalMileage">${mileageTotal - mileageUse }</strong>원)
																	</p>
																	<ul class="info">
																		<li id="mileage_max_unlimit" class="">최대 사용금액은 제한이 없습니다.</li>
																		<li id="mileage_max_limit" class="displaynone">1회 구매시 적립금 최대 사용금액은 입니다.</li>
																		<li>적립금으로만 결제할 경우, 결제금액이 0으로 보여지는 것은 정상이며 [결제하기] 버튼을 누르면 주문이 완료됩니다.</li>
																		<li id="mileage_shipfee" class="displaynone">적립금 사용시 배송비는 적립금으로 사용 할 수 없습니다.</li>
																	</ul>
																</td>
															</tr>
													</tbody>
												</table>
											</div>
										</div>
							        </div>
							    </div>
							</div>
							
							<!-- 결제 -->
							<div class="container">
							    <div class="row">
							        <div class="col-sm-12 col-md-10 col-md-offset-1">
							            <h3>결제 수단</h3>
							            <p class="required">
							            <div class="totalArea">
											<div class="boardWrite">
												<table  summary="" class="table table-hover" >
													<caption>무통장입금</caption>
													<tbody>
													<tr>
														<th scope="row">입금자명</th>
													    <td><input id="pname" name="pname" class="inputTypeText" placeholder="" size="15" maxlength="20" value="" type="text"  /></td>
													</tr>
													<tr>
														<th scope="row">입금은행</th>
														<td>
													       <select id="bankaccount" name="bankaccount">
															<option value="-1">::: 입금은행 선택 :::</option>
															<option value="bank_01">기업은행:06806792001027 코북</option>
															<option value="bank_02">국민은행:42173704015601 코북</option>
														   </select>                            
													     </td>
													</tr>
													</tbody>
													</table>
											</div>
										</div>
							        </div>
							    </div>
							</div>

							<div class="col-lg-2 col-md-2 col-xs-12" style="float: right;">
								<!-- Standard button -->
								<button class="btn btn-default btn-lg btn-block" type="submit" id="orderSuccess">
									결제하기
								</button>
							</div>
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