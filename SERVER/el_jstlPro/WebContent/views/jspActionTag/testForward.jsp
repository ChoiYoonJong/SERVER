<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">testForward.jsp입니다</h1>
	<h3 align="right"><%=request.getAttribute("name") %></h3>
	<h3 align="right"><%=request.getParameter("name") %></h3>
	<h3 align="right">${param.name}</h3>
	
	<h2>jsp:useBean 활용하기</h2>
	<%-- 
	<%
		com.uni.el.model.vo.Member m = new com.uni.el.model.vo.Member();
		m.setName("유재석");
		m.setAge(20);
		m.setPhone("010-1234-1234");
		m.setEmail("yu@naver.com");
	%>
	
	이름 : <%= m.getName() %>
	나이 : <%= m.getAge() %>
	전화번호 : <%= m.getPhone() %>
	이메일 : <%= m.getEmail() %>--%>
	
	<jsp:useBean id="m" class="com.uni.el.model.vo.Member" scope="page"/>
	<jsp:setProperty property="name" name="m" value="유재석"/>
	<jsp:setProperty property="age" name="m" value="20"/>
	<jsp:setProperty property="phone" name="m" value="010-1234-1234"/>
	<jsp:setProperty property="email" name="m" value="yu@naver.com"/>
	
	이름 : <jsp:getProperty property="name" name="m"/>
	나이 : <jsp:getProperty property="age" name="m"/>
	전화번호 : <jsp:getProperty property="phone" name="m"/>
	이메일 : <jsp:getProperty property="email" name="m"/>
</body>
</html>