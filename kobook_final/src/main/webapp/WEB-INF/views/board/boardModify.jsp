<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Electrify Responsive Multipurpose Template</title>
<meta name="description" content="">

<!-- CSS FILES -->
 <!-- CSS FILES -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css" media="screen" data-name="skins">
    <link rel="stylesheet" href="/resources/css/layout/wide.css" data-name="layout">

<link rel="stylesheet" type="/resources/text/css"
	href="/resources/css/switcher.css" media="screen" />
	
	
  </head>
<body>
	<!--Start Header-->
	<!-- 헤더 -->
	<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<!-- /헤더 -->
	
	
               <!-- 나중에 로그인되면 아래 User_id의 value는 sessionid로 변경 -->
               <div class="dividerHeading">
                    <h4><span>공지사항 글작성</span></h4>
                </div>
                <form action="/board/boardModify" method="post">
                 	<input type='hidden' name='board_id' value="${boardVO.board_id }">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="관리자" disabled="disabled">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="제목" name ="board_title">
                    </div>
                    <div class="form-group">
                        <textarea rows="6" class="form-control" cols="70" placeholder="내용" name="board_content"></textarea>
                        <input type="submit" value="등록">
                    </div>    
                 </form>   

    <!-- jQuery 2.1.4 -->
    <script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="/resources/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
   
   <script type="text/javascript">
   
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("수정이  완료되었습니다.");
		location.replace(self.location);
	}
   	
   </script>
  </body>
</html>