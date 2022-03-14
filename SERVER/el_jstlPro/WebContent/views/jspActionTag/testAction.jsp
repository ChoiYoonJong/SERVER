<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  지시자 include -jsp 파일을 class(java) 파일로 변환할떄 처리 
		        - 현재 파일에 삽입
		        - 페이지내의 변수를 선언한후 변수에 값저장 하여 전달
		        - 다수 jsp 페이지에서 공통으로 사용되는 코드 처리
	엑션태그 include - 요청한 시간에 처리(런타임)
	              - 별도의 파일 요청 처리
	              - request 기본 객체나 jsp:param 을 이용한 파라미터 전달 
	              - 화면의 레이아웃 일부분을 모듈화
-->

	<%-- <%@ include file = "common.jsp" %> --%>
	<jsp:include page="common.jsp"/> 
	<h1 align="center">testAction.jsp 내용입니다.</h1>
	<%
		request.setAttribute("name", "유재석");// 원래 사용했었던 방식
		//request.getRequestDispatcher("testForward.jsp").forward(request,response);
	%>
	
	<%--jsp 방식 // parameter 까지 같이 전송. 뭔가 값을 전달할때 끝에 마무리하는게 있다면 끝에 글을 분리해서 안에 작성한다. --%>
	<jsp:forward page="testForward.jsp">
	<jsp:param value="ej" name="name"/>
	</jsp:forward>
	
</body>
</html>