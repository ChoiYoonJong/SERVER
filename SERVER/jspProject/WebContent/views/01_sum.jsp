<%-- directive page 페이지 지시자 태그 (페이지에 대한 설정 ) errorPage = "errorPage.jsp" --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Html 주석 : 개발자도구 탭에 노출됨 (클라이언트에게 전달됨) -->
<%-- jsp 주석 : 개발자 도구 탬에 노출 안됨 (클라이언트에게 전달안됨) --%>

<%--<%! private int age = 20; --%>

<%--<% 시작해서 %> 끝나는것을 스크립틀릿 라고 부른다. 자바문법을 작성 한다.--%>
<%
	int total = 0;
	for(int i = 1; i <=10; i++){
		total+=i;
	}
%>
	<h4>1부터 10까지의 합은 <span style="color:red; font-size:16pt;"><%= total %></span>입니다. </h4>
	<h4>1부터 10까지의 합은 <span style="color:red; font-size:16pt;"><% out.print(total); %></span>입니다. </h4>
</body>
</html>