<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function closeWin(){
		window.opener.name = "main.jsp";
		document.loginForm.target = "main.jsp";
		document.loginForm.submit();
		document.getElementById("parentURI").value = window.opener.location.href;
		window.self.close();
	}
</script>
</head>
<body>
	<h1 style="text-align: center;">KOBOOK LOGIN</h1>
	<br>
	
	<form action="/person/loginPost" method="post" name="loginForm">
		<input type="hidden" id="parentURI" name="parentURI" value="">
		<input type="text" name="person_email" placeholder="아이디를 입력하세요." style="height: 30px; width: 250px; margin-left: 60px;"><br><br>
		<input type="password" name="person_pwd" placeholder="비밀번호를 입력하세요." style="height: 30px; width: 250px; margin-left: 60px;"><br><br>
		<input type="submit" value="로그인" style="margin-left: 150px; width: 60px; height: 30px" onclick="closeWin()">
	</form>
</body>
</html>