<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("person_id") != null){		// 로그인 했다면
		int cur_id = Integer.parseInt((String)session.getAttribute("person_id"));
		System.out.println("챗봇 팝업창에서의 cur_id: " + cur_id);
	} else {		//로그인을 안했다면
		System.out.println("로그인 안함");
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	채팅창
</body>
</html>