<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/* session엔 string과 obejct만 등록이 가능하다.(int는 절대 안됨!!!!) */
	session.setAttribute("cur_id", "1");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">

	function popup(){
		var child = window.open('/message/sendMessageForm.jsp','childWindow', 'width=630, height=300, menubar=yes, statebar=yes, scrollbar=yes');
	}
	
</script>

<body>
	<br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="sendMessage" onclick="popup();" value="보내기" />
</body>
</html>