<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="css/style.css" media="screen" data-name="skins">
    <link rel="stylesheet" href="resources/css/layout/wide.css" data-name="layout">

    <link rel="stylesheet" type="text/css" href="css/switcher.css" media="screen" />

<script type="text/javascript">
	function closeWinAlarm(){
		//window.opener.name = "main.jsp";
		document.alarmForm.target = "main.jsp";
		document.alarmForm.submit();
		window.self.close();
	}
</script>
</head>
<body>
	<!-- <h1 style="text-align: center;">AlARM LIST</h1> -->
	<br>
	
	<form action="/alarmUpdate" method="get" name="alarmForm">	 

		<div class="container">
			<div class="row sub_content">
	            <div class="col-lg-12 col-md-12 col-sm-12">
	                <div class="dividerHeading">
	                    <h4><span>ALARM LIST</span></h4>
	                </div>
	            </div>
	            <div class="col-lg-12 col-md-12 col-sm-12">
	                <div class="table-responsive">
	                    <table class="table table-striped table-hover">
	                        <thead>
	                        <tr>
	                            <th>번호</th>
	                            <th>분류</th>
	                            <th>내용</th>
	                        </tr>
	                        </thead>
	                        <tbody>
								<c:forEach var="a" items="${alarmList }">
								<tr>
									<td>${a.alarm_id }</td>
									<td>${a.alarm_kind }</td>
									<td>${a.alarm_content }</td>
								</tr>
								</c:forEach>
	                        </tbody>
	                    </table>
	                </div>
	            </div>
	        </div> <!--./row-->
		</div>
		        
		
		<div class="row sub_content">
            <div class="col-lg-2 col-md-2 col-xs-12">
                <!-- <button class="btn btn-default btn-sm btn-block" type="button">Small Button</button> -->
                <input type="submit" class="btn btn-default btn-sm btn-block"  style="margin-left: 220px; width: 60px; height: 30px"  value="close" onclick="closeWinAlarm()">
            </div>
        </div>
	
	</form>
</body>
</html>