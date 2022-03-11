<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  <!-- menubar 요소 -->
<%@ page import="com.uni.member.model.vo.Member" %><!-- import -->
<%
	Member loginUser = (Member)session.getAttribute("loginUser");//object 타입으로 넘어와서 형변환
	
	String msg = (String)session.getAttribute("msg");//(String) 으로 형변환
	
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> <!-- jQuery 사용 js를 cdm 방식으로 작성, 지금은 js 하나이기때문에 head
																							나중에 읽어들이는 속도가 차이 혹은 잘안되면  body 제이 아래 붙여도 좋다. -->
<style>
	body{
		background:url('<%=request.getContextPath() %>/resources/images/bg.jpg') no-repeat; 
		background-size:cover;
	}
	/* 로그인 폼 관련 스타일*/
	#loginForm, #userInfo{float:right;}
	.btns button{border-radius:5px;}
	#enrollBtn, #mypageBtn{background-color:yellowgreen;}
	#loginBtn, #logoutBtn{background-color:orangered;}
	#userInfo a{text-decoration:none;color:white;}
	
	/* 메뉴영역 관련 스타일*/
	.navWrap{background-color:black; width:100%; height:50px}
	.navWrap>.nav{width:600px;margin:auto;}
	.menu{text-align:center;color:white;font-weight:bold;width:150px;height:50px;display:table-cell;font-size:20px;vertical-align:middle;}
	.menu:hover{background-color:darkgray;}
	
</style>
</head>
<script>
	
	$(function(){
		var msg = "<%=msg%>";
		if(msg !="null"){ //null 이 아니면 메세지 값이 들어 있다.
			alert(msg);
			<%session.removeAttribute("msg");%>// 다띄우고 나면 남길 필요가 없다. 그래서 remobeAttribute 이용
		}
	});
	
	function loginValidate(){
		if($("#userId").val().trim().length === 0 ){// userId 에 val 값을 가져오고 trim을 하고 length 길이가 === 0 이랑 같다면 
			alert("아이디를 입력하세요 "); // 만약에 0 이랑 같으면 아이디를 입력하세요 메세지가 띄어진다.
			$("#userId").focus();// userId 에 포커스가 된다.
			return false;//return 은 안되었기때문에 false가 된다.
		}
		if($("#userPwd").val().trim().length === 0 ){// userPwd 에 val 값을 가져오고 trim을 하고 length 길이가 === 0 이랑 같다면 
			alert("비밀번호를 입력하세요 ");// 만약에 0 이랑 같으면 아이디를 입력하세요 메세지가 띄어진다.
			$("#userPwd").focus();// userPwd 에 포커스가 된다.
			return false;//return 은 안되었기때문에 false가 된다.
		}
		
		return true; // 이도 저도 아닐때는 return true..
	}
</script>																					
</head>
<body>
	<h1 align="center" style="color:black;">welcome JSP World!</h1>
	<div class="loginArea">
	
	<% if ( loginUser == null ) {%> <!-- 로그인 유저가 null 일때 -->
		<form id = "loginForm" action="<%=request.getContextPath()%>/loginMember.do" method="post" onsubmit="return loginValidate();"> 
		<!-- loginMenber.do 를 호출하고 있다. --> 
		<!-- 일일이 project 명을 쓰는것보다. requset.getContextPath() 사용 -->
			<table>
					<tr>
						<th><label for = "userId" style="color:white;">아이디</label></th> <!-- 로그인 정보이기때문에 아이디 비밀번호를  get 방식이 아닌 post 방식으로 넘겨준다. -->
						<td><input id="userId" type="text" name="userId"></td>
					</tr>
					<tr>
						<th><label for = "userPwd" style="color:white;">비밀번호</label></th>
						<td><input id="userPwd" type="text" name="userPwd"></td>
					</tr>
				</table>
				<div class ="btns" align="center">
					
					<button id = "loginBtn" type="submit">로그인</button>
				    <button id = "enrollBtn" type="button" onclick="enrollPage();">회원가입</button>
				</div>
			
			</form>
	<% } else{ %> <!-- 로그인 유저가 Null 이 아닌경우 -->
			<div id = "userInfo">
				<b style = "color:white;"><%=loginUser.getUserName() %> 님 </b> 의 방문을 환영합니다.
				<br><br>
				<div class ="btns" align="center">
					<a href = "<%=request.getContextPath() %>/mypageMember.do">마이페이지</a>
					<a href = "<%=request.getContextPath() %>/logoutMember.do">로그아웃</a>
				</div>
			
			
			</div>
	<%} %>
	</div>
	<script type="text/javascript">
		function enrollPage(){//함수를 클릭했을때 ContextPath()에 enrollFormMember.do 를 호출해준다. 
			location.href="<%= request.getContextPath()%>/enrollFormMember.do";
		}
	
	
	</script>
	<br clear="both">
		
		<div class="navWrap">
			<div class="nav">
				<div class="menu" onclick="goMain();">HOME</div>
				<div class="menu" onclick="goNotice();">공지사항</div>
				<div class="menu" onclick="goBoard();">게시판</div>
				<div class="menu" onclick="goThumbnail();">사진게시판</div>
				
			</div>
		</div>
		<script>
		function goMain(){//home
			location.href="<%= request.getContextPath()%>";
		}
		function goNotice(){//공지사항
			location.href="<%= request.getContextPath()%>/listNotice.do";
		}
		function goBoard(){//
			location.href="<%= request.getContextPath()%>/listBoard.do";
		}
		function goThumbnail(){
			location.href="<%= request.getContextPath()%>/listThumb.do";
		}
		</script>
</body>
</html>