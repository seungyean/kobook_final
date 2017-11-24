<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function closeWinAlarm(){
		window.opener.name = "main.jsp";
		document.alarmForm.target = "main.jsp";
		document.alarmForm.submit();
		window.self.close();
	}
</script>
</head>
<body>
	<h1 style="text-align: center;">AlARM LIST</h1>
	<br>
	
	<form action="/alarmUpdate" method="get" name="alarmForm">
<!-- 		<input type="hidden" id="parentURI" name="parentURI" value=""> -->
		<!-- <input type="text" name="person_email" placeholder="아이디를 입력하세요." style="height: 30px; width: 250px; margin-left: 60px;"><br><br>
		<input type="password" name="person_pwd" placeholder="비밀번호를 입력하세요." style="height: 30px; width: 250px; margin-left: 60px;"><br><br> -->
		
		<table border="1" align="center">
			<tr>
				<td>번호</td>
				<td>분류</td>
				<td>내용</td>

			</tr>	
			<c:forEach var="a" items="${alarmList }">
			<tr>
				<td>${a.alarm_id }</td>
				<td>${a.alarm_kind }</td>
				<td>${a.alarm_content }</td>
			</tr>
			</c:forEach>
		</table>
		
		<br><br>
		<input type="submit" value="확인" style="margin-left: 300px; width: 60px; height: 30px" onclick="closeWinAlarm()">
	</form>
</body>
</html>