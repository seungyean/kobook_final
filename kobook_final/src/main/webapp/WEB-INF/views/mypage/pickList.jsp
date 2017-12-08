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
	<title>찜리스트</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

    <!-- CSS FILES -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css" media="screen" data-name="skins">
    <link rel="stylesheet" href="/resources/css/layout/wide.css" data-name="layout">

    <link rel="stylesheet" type="text/css" href="/resources/css/switcher.css" media="screen" /></head>
	<script type="text/javascript" src="/resources/js/jquery-1.10.2.min.js"></script>


<script type="text/javascript">
	$(function() {

		var pick_id = "";
		var book_name = "";
		var book_m_price = "";
		var pay_amount = "";
		var total_pick_id = "";
		
		/* 체크박스 전체선택, 전체해제 */
		$("#checkAll").click(function(){
        //클릭되었으면
        if($("#checkAll").prop("checked")){
            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
            $("input[name=checkRow]").prop("checked",true);
            //클릭이 안되있으면
        }else{
            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
            $("input[name=checkRow]").prop("checked",false);
        }
    });
		
		//체크박스 선택 삭제 버튼 
		$(".btn-warning").click(
				function() {
					var checkRow = "";
					  $( "input[name='checkRow']:checked" ).each (function (){
						  checkRow = checkRow + $(this).parent().parent().find('td:first').text().trim()+"," ;
					  });
					  checkRow = checkRow.substring(0,checkRow.lastIndexOf( ",")); //맨끝 콤마 지우기
					  console.log("체크된 픽아이디 들 : " + checkRow);
					  if(checkRow == ''){
						    alert("삭제할 대상을 선택하세요.");
						    return false;
						  }
					  location.href = "/mypage/pickStateUpdate?pick_id="+ checkRow;
					
					
				});
		
		


		// 찜 삭제 버튼 
		$(".btn-danger").click(
				function() {
					var pick_id = $(this).parent().parent().find('td:first')
							.text().trim();
					location.href = "/mypage/pickStateUpdate?pick_id="
							+ pick_id;
				});

		// 주문 버튼 
		$(".btn-default").click(
				function() {
					var pick_id = $(this).parent().parent().find('td:first')
							.text().trim();
					var book_id = $(this).parent().parent().find('.bookId')
					.text().trim();
					console.log(book_id);
					location.href = "/mypage/order?book_id="+book_id+"&pick_id="+pick_id;
				});

		$("#use_mileage").keyup(function() {
			var use_mileage = $('#use_mileage').val();
			$('#total_price').val(book_m_price - use_mileage);
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
                            <h2>찜</h2>
                        </div>
                        <nav id="breadcrumbs">
                            <ul>
                                <li><a href="index.html">홈</a>/</li>
                                <li>마이페이지 /</li>
                                <li>찜</li>
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
							<h4><span>찜 리스트</span></h4>
							<br>
							<br>
							<c:choose>
									<c:when test="${empty pickList }">
										<div class="media-body">
											<div class="well" style="margin-left: 170px;">
												<h2 align="center">찜 상품이 존재하지 않습니다.</h2>
											</div>
										</div>
									</c:when>
									<c:otherwise>
								<form>
									<table class="table table-hover">
										<thead>
											<tr>
												<td align="center"><input type="checkbox"name="checkAll" id="checkAll" ></td>
												<td align="center">썸네일</td>
												<td>책 제목</td>
												<td align="center">가격</td>
												<td align="center">판매상태</td>
												
												<td></td>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="element" items="${pickList }" varStatus="s">
												<tr>
													<td align="center" hidden="">${element.PICK_ID }</td>
													<td align="center" hidden="" id="bookId" class="bookId">${element.BOOK_ID }</td>
													<td align="center"><input type="checkbox" name="checkRow"></td>
													<td align="center">	
													<img class="thumbnail" alt="NO IMAGE"
												 src="/mypage/displayFile?fileName=${element.BOOK_IMG  }" style="width: 72px; height: 72px;">
													 </td>
													<td>${element.BOOK_NAME }</td>
													<td align="center">${element.BOOK_M_PRICE }</td>
													<td align="center">
													<c:set var="name" value="${element.BOOK_SELL_STATE}" />
														<c:choose>
   															<c:when test="${element.BOOK_SELL_STATE eq 'I' }">
      														    판매중
   															</c:when>
   															<c:when test="${element.BOOK_SELL_STATE eq 'C' }">
     														   판매완료
  															</c:when>
  														</c:choose>
													</td>
													<td>
													<input type="button" value="삭제" class="btn btn-danger" id="del" style="color: white;" >
													<input type="button" value="주문" class="btn btn-default" id="order" style="color: white;">
													</td>
												</tr>
											</c:forEach>
										</tbody>
										</table>
										<span>
											선택 상품을&nbsp;<input type="button" value="삭제" class="btn btn-warning" id="del" style="color: white;" >
										</span>
									</form>
									</c:otherwise>
								</c:choose>
								
						</div>
						<div class="text-center">
							<ul class="pagination">

								<c:if test="${pageMaker.prev}">
									<li><a href="pickList?${pageMaker.startPage - 1 }">&laquo;</a></li>
								</c:if>

								<c:forEach begin="${pageMaker.startPage }"
									end="${pageMaker.endPage }" var="idx">
									<li
										<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
										<a href="pickList?page=${idx}">${idx}</a>
									</li>
								</c:forEach>

								<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
									<li><a href="pickList?page=${pageMaker.endPage + 1 }">&raquo;</a></li>
								</c:if>
							</ul>
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