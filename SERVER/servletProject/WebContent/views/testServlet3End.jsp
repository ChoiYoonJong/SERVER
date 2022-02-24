<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = (String)request.getAttribute("name");
	String gender = (String)request.getAttribute("gender");
	String age = (String)request.getAttribute("age");
	String city = (String)request.getAttribute("city");
	String height = (String)request.getAttribute("height");
	String foods = (String)request.getAttribute("foods");

	
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h2{color:red;}
	span.name{color:orange; font-weight:bold;}
	span.gender{color:yellow; font-weight:bold; background-color:black;}
	span.age{color:green; font-weight:bold;}
	span.city{color:blue; font-weight:bold;}
	span.height{color:navy; font-weight:bold;}
	span.food{color:purple; font-weight:bold;}
	
</style>
</head>
<body>
	<h2>개인정보 결과(POST)화면</h2>
		<span class='name'><%= name %></span>님은 
		<span class='age'><%= age %></span>살이시며
		<span class='city'><%= city %></span>에 사는 
		키 <span class='height'><%= height %></span>
		<span class='gender'><%= gender %></span>입니다.
		좋아하는 음식은 <span class='food'><%= foods %></span>입니다.
</body>
</html>