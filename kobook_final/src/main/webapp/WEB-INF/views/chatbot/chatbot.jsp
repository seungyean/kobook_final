<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!-- <script src='//production-assets.codepen.io/assets/editor/live/console_runner-079c09a0e3b9ff743e39ee2d5637b9216b3545af0de366d4b9aad9dc87e26bfd.js'></script>
<script src='//production-assets.codepen.io/assets/editor/live/events_runner-73716630c22bbc8cff4bd0f07b135f00a0bdc5d14629260c3ec49e5606f98fdd.js'></script>
<script src='//production-assets.codepen.io/assets/editor/live/css_live_reload_init-2c0dc5167d60a5af3ee189d570b1835129687ea2a61bee3513dee3a50c115a77.js'></script> -->
<meta charset='UTF-8'><meta name="robots" content="noindex">
<link rel="shortcut icon" type="image/x-icon" href="//production-assets.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" />
<link rel="mask-icon" type="" href="//production-assets.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg" color="#111" />
<link rel="canonical" href="https://codepen.io/clemer/pen/xLqaKm?limit=all&page=4&q=uikit" />
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-beta.28/css/uikit.min.css'>
<style class="cp-pen-styles">

.uk-card-small.uk-card-body {
	padding: 5px 8px;
	font-size: 13px;
}

.uk-border-remove {
	border: 0 none;
}

.uk-margin-remove{
	margin:0!important;
}

textarea {
	background: none !important;
	resize: none;
}

@keyframes dot-anim {
	100% {
	  transform: translate(0, 0);
	}
	50% {
	  transform: translate(0, -6px);
	}
	0% {
	  transform: translate(0, 0);
	}
}
.etc i {
	width: 6px;
	height: 6px;
	background: #222;
	border-radius: 100%;
	display: inline-block;
	animation: dot-anim 1s infinite linear;
	transform: translate(0, 0);
}

.etc {
	display: block;
	position: relative;
}
.etc i + i {
	margin-left: 3px;
}
.etc i:nth-child(1) {
	animation-delay: .5s;
}
.etc i:nth-child(2) {
	animation-delay: .4s;
}
.etc i:nth-child(3) {
	animation-delay: .3s;
}

.uk-card {
	position: relative;
	z-index: 1;
}

.guest .uk-card:after, .me .uk-card:after {
	width: 10px;
	height: 45px;
	position: absolute;
	bottom: 0;
}

.guest .uk-card:after {
	background: #fff;
	left: -4px;
	clip-path: polygon(100% 70%, 0% 100%, 100% 100%);
}

.me .uk-card:after {
	background: #1e87f0;
	right: -4px;
	clip-path: polygon(0 70%, 0% 100%, 100% 100%);
}

.uk-scroll{
	overflow: auto;
	width: 500px;
	height: 400px;
}

.uk-width-larger{
	width: 600px;
}

.chat-div{
	max-width: 260px;
}

.chat-paragraph{
	white-space: normal;
}

</style>
</head>
<body>
	<div class="uk-section">
		<div class="uk-container uk-width-larger">			
			<div class="uk-card uk-card-default uk-border-rounded uk-margin-large-top" id="big-container">
				<div class="uk-card-body uk-padding-small uk-scroll" id="mid-container">
				
				<!-- 대화 내용 들어가는 자리 -->
				
				</div>
			
				<!-- 채팅 입력하는 부분 -->
				<div class="uk-card-footer uk-padding-remove">
					<div class="uk-grid-small uk-flex-middle" id="control-container" uk-grid>
						<div class="uk-width-auto">
							<a href="#" class="uk-icon-link uk-margin-small-left" uk-icon="icon: happy"></a>
						</div>
						<div class="uk-width-expand">
							<div class="uk-padding-small uk-padding-remove-horizontal">
								<textarea id="chatMsg" class="uk-textarea uk-padding-remove uk-border-remove" rows="1" placeholder="메시지를 입력해주세요"></textarea>
							</div>
						</div>
						
						<div class="uk-width-auto">
							<ul class="uk-iconnav uk-margin-small-right">
								<li>
									<button id="chatSendBtn">전송</button>									
								</li>
								<li>
									<a href="#" uk-icon="icon: image"></a>
								</li>
								<li>
									<a href="#" uk-icon="icon: location"></a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			
			</div>
		</div>
	</div>
<!-- <script src='//production-assets.codepen.io/assets/common/stopExecutionOnTimeout-b2a7b3fe212eaa732349046d8416e00a9dec26eb7fd347590fbced3ab38af52e.js'></script> -->
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-beta.28/js/uikit.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-beta.28/js/uikit-icons.min.js'></script>
<script src='https://code.jquery.com/jquery-2.2.4.js'></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<script id="user-template" type="text/x-handlebars-template">
<div class="me uk-grid-small uk-flex-bottom uk-flex-right uk-text-right chat-container" uk-grid>
	<div class="uk-width-auto">
		<div class="uk-card uk-card-body uk-card-small uk-card-primary uk-border-rounded chat-div">
			<p class="uk-margin-remove chat-paragraph">{{chatlog_content}}</p>
		</div>
	</div>
	<div class="uk-width-auto">
		<img class="uk-border-circle" width="32" height="32" src="https://getuikit.com/docs/images/avatar.jpg">
	</div>
</div>
</script>

<script id="com-template" type="text/x-handlebars-template">
<div class="guest uk-grid-small uk-flex-bottom uk-flex-left chat-container" uk-grid>
	<div class="uk-width-auto">
		<img class="uk-border-circle" width="32" height="32" src="https://getuikit.com/docs/images/avatar.jpg">
	</div>
	<div class="uk-width-auto">
		<div class="uk-card uk-card-body uk-card-small uk-card-default uk-border-rounded chat-div">
			<p class="uk-margin-remove chat-paragraph">{{chatlog_content}}</p>
		</div>
	</div>
</div>
</script>

<script type="text/javascript">

	Handlebars.registerHelper("prettifyDate", function(timeValue) {
		var dateObj = new Date(timeValue);
/* 		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate(); */
		var hour = dateObj.getHours();
		var minute = dateObj.getMinutes();
		return hour + ":" + minute;
	});
	
	var printData = function(chatWindow, templateObject){
		var template = Handlebars.compile(templateObject.html());
		var html = template(chatWindow);
		return html;
	}

	$(function(){
		
		getList("/chat/" + "<%= Integer.parseInt((String)session.getAttribute("person_id"))%>");
	
		$('#chatSendBtn').on('click', function(){
			
			var chatlog_contentObj = $('#chatMsg');
			var chatlog_content = chatlog_contentObj.val();
			var person_id = "<%= Integer.parseInt((String)session.getAttribute("person_id"))%>";
			var chatlog_speaker = "U";
			
			console.log("====================채팅창");
			console.log("chatlog_content: " + chatlog_content);
			console.log("person_id: " + person_id);
			console.log("chatlog_speaker: " + chatlog_speaker);
			
			if(chatlog_content == ""){
				
			} else {
				$.ajax({
					type:'post',
					url:'/chat/',
					headers: { 
					      "Content-Type": "application/json",
					      "X-HTTP-Method-Override": "POST" },
					dataType:'text',
					data: JSON.stringify({chatlog_content:chatlog_content, person_id:person_id, chatlog_speaker:chatlog_speaker}),
					success:function(result){
						console.log("result : " + result);
						if(result == 'SUCCESS'){
							chatlog_contentObj.val("");

							// 유저가 입력한 문장을 즉각적으로 보여주기 위해 리프레시
							getList("/chat/" + person_id);
							
							// 방금 입력한 문장을 분석 및 로직처리 하기 위해
							chatProcess(person_id, chatlog_content);
						}
					}
				});
			}
			
		});
		
	});
	
	function getList(chatInfo){
		
		$.getJSON(chatInfo, function(data){		// "/chat/{person_id}" 로부터 나오는 전체 데이터 (array)
			console.log(data);
			var html = "";
			for(i=0; i< data.length; i++){
				if(data[i].chatlog_speaker == 'C'){
					html += printData(data[i], $('#com-template'));
				} else {
					html += printData(data[i], $('#user-template'));
				}
			}
			$('.chat-container').remove();
			$('#mid-container').append(html);
		});
		
	}
	
	function chatProcess(person_id, chatlog_content){
		
		$.ajax({
			type:'post',
			url:'/chat/chatProcess',
			headers: { 
			      "Content-Type": "application/json",
			      "X-HTTP-Method-Override": "POST" },
			dataType:'text',
			data: JSON.stringify({person_id:person_id, chatlog_content:chatlog_content}),
			success:function(result){
				console.log("result : " + result);
				if(result == 'SUCCESS'){
					getList("/chat/" + person_id);
				}
			}
		});
	}
	

</script>

</body>
</html>