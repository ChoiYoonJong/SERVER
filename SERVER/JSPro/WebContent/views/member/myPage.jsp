<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Member m = (Member)request.getAttribute("loginUser");

	String userId = m.getUserId();
	String userPwd = m.getUserPwd();
	String userName = m.getUserName();
	String phone = m.getPhone() !=null? m.getPhone() : "";// 필수가 아니기때문에 처리를 !=null? m.getPhone() : "" 핸준다 "" 은 빈값으로 해준다
	String email = m.getEmail() !=null? m.getEmail() : "";// 필수가 아니기때문에 처리를 !=null? m.getEmail() 핸준다 "" 은 빈값으로 해준다
	String address = m.getAddress() !=null? m.getAddress() : "";// 필수가 아니기때문에 처리를 !=null? m.getAddress() : "" 핸준다 "" 은 빈값으로 해준다
	String originPwd = (String)session.getAttribute("originPwd");
	
	String[] checkedInterest = new String[6];
	if(m.getInterest() !=null){
		String[] interests = m.getInterest().split(",");
		
		//checked 체크된것은 만약에 케이스에 일치하는 값이 있으면 각 배열에 방에다가 넣어주기때문에 해당하는 값이 체크가 된다.
		for(int i = 0; i < interests.length; i++){
			switch(interests[i]){
			case "운동" :checkedInterest[0] = "checked";break;//넣어준 순서대로 지정
			case "등산" :checkedInterest[1] = "checked";break;
			case "낚시" :checkedInterest[2] = "checked";break;
			case "요리" :checkedInterest[3] = "checked";break;
			case "게임" :checkedInterest[4] = "checked";break;
			case "기타" :checkedInterest[5] = "checked";break;
			
			}
		}
		
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		background:black;
		width:600px;
		height:500px;
		margin-top:50px;
		margin-left:auto;
		margin-right:auto;
		color:white;
	}
	#updateForm{
		/* border:1px solid white; */
		width:100%;
		margin-left:auto;
		margin-right:auto;
	}
	#updateForm td:nth-child(1){text-align:right;}
	#updateForm input{margin:3px;}
	
	#joinBtn{background:yellowgreen;}
	#goMain{background:orangered;}
</style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>

	<div class="outer">
		<br>
		
		<h2 align="center">마이페이지</h2>
		<input type="text" id="originPwd" name ="originPwd" value="<%=originPwd %>" readonly>
		<form id="updateForm" action="<%=request.getContextPath() %>/updateMember.do" method="post"> 
			<table>
				<tr>
					<td width="200px">* 아이디</td>
					<td><input type="text" maxlength="13" name="userId" value = "<%= userId %>" readonly></td>
					
				</tr>
				
				<tr>
					<td>* 이름</td>
					<td><input type="text" maxlength="5" name="userName" value = "<%= userName %>" required></td>
					<td></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="tel" maxlength="11" name="phone" value = "<%= phone %>" placeholder="(-없이)01012345678"></td>
					<td></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value = "<%= email %>"></td>
					<td></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value = "<%= address %>" ></td>
					<td></td>
				</tr>
				<tr>
					<td>관심분야</td>
					<td>
						<input type="checkbox" id="sports" name="interest" value="운동" <%= checkedInterest[0] %>>
						<label for="sports">운동</label>
						
						<input type="checkbox" id="climbing" name="interest" value="등산" <%= checkedInterest[1] %>>
						<label for="climbing">등산</label>
						
						<input type="checkbox" id="fishing" name="interest" value="낚시" <%= checkedInterest[2] %>>
						<label for="fishing">낚시</label>
						
						<input type="checkbox" id="cooking" name="interest" value="요리" <%= checkedInterest[3] %>>
						<label for="cooking">요리</label>
						
						<input type="checkbox" id="game" name="interest" value="게임" <%= checkedInterest[4] %>>
						<label for="game">게임</label>
						
						<input type="checkbox" id="etc" name="interest" value="기타" <%= checkedInterest[5] %>>
						<label for="etc">기타</label>
					</td>
					<td></td>
				</tr>
			</table>
			<br>
			
			<div class="btns" align="center">
				<button type="submit" id="updateBtn">수정하기</button>
				
				<button type="button" id = "pwdUpdateBtn" onclick="updatePwd();">비밀번호 변경</button>
				<button type="button" id = "deleteBtn" onclick="deleteMember();">탈퇴하기</button>
				
			</div>
		</form>
	</div>
	<script>
		function updatePwd(){ // 비밀번호 화면 호출
			window.open("<%= request.getContextPath()%>/updatePwdForm.do","비밀번호 변경창", "width=500, height=300")
		}
		function deleteMember(){
			var pwd = prompt("현재 비밀번호를 입력해주세요")
			var op = $("#originPwd").val();
			
			if(op === pwd){
				 
				var val = confirm("정말로 탈퇴하시겠습니까?"); //함수 클릭시 deleteMember.do 실행
				
				if(val){
					$("#updateForm").attr("action","<%=request.getContextPath()%>/deleteMember.do"); 
					$("#updateForm").submit();
				}else{
							
					alert("취소하였습니다.");
				}
			}
		}	
	</script>
	<%@ include file="../common/footer.jsp" %> <!-- footer  -->	
</body>
</html>