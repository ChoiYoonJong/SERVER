<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
		com.uni.el.model.vo.Member member = 
				(com.uni.el.model.vo.Member) request.getAttribute("member");
	Member member = (Member)request.getAttribute("member");
	%>
	<!--기존방식-->
	이름 : <%= member.getName() %><br>
	나이 : <%= member.getAge() %><br>
	전화번호 : <%= member.getPhone() %><br>
	이메일 : <%= member.getEmail() %><br> --%>
	
	이름 :${requestScope.member.name} <br>
	나이 :${requestScope.member.age} <br>
	전화번호 :${requestScope.member.phone} <br>
	이메일 :${requestScope.member.email} <br>
	
	이름 :${member.name} <br>
	나이 :${member.age} <br>
	전화번호 :${member.phone} <br>
	이메일 :${member.email} <br>
	
	
	
</body>
</html>