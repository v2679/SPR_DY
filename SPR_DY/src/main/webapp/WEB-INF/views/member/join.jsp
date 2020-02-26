<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script  src="../resources/js/join.js"></script>
</head>
<body>
<h1>회원 가입</h1>
<form action="join" method="post">
<table>
	<tr>
		<td>아이디</td>
	</tr>
	<tr>
		<td><input type="text" placeholder="아이디를 입력해주세요" id="id" name="id" maxlength="12"   required> <input onclick="ovcheck()" type="button" value="중복확인"></td>
		<td><label id="idcheck">5~12자 영문 대 소문자,숫자를 사용하세요</label></td>
	</tr>
	<tr>
		<td>비밀번호</td>
	</tr>
	<tr>
		<td><input type="password" placeholder="비밀번호를 입력해주세요" id="pw" name="pw" maxlength="12"  required></td>
		<td><label id="pwcheck">6~12자 영문 대 소문자,숫자를 사용하세요</label></td>
	</tr>
	<tr>
		<td>비밀번호 재확인</td>
	</tr>
	<tr>
		<td><input type="password" placeholder="비밀번호를 입력해주세요" id="repw" name="repw" maxlength="12"  required></td>
		<td><label id="repwck">6~12자 영문 대 소문자,숫자를 사용하세요</label></td>
	</tr>
	<tr>
		<td>닉네임</td>
	</tr>
	<tr>
		<td><input type="text" name="name"  required></td>
	</tr>
	<tr>
		<td>이메일</td>
	</tr>
	
	<tr>
		<td><input type="text" name="email"  required></td>
	</tr>
	
	  <!-- 
	<tr>
		<td>
		<input type="text"> @ <input type="text">
		</td>  
		<td> 
		<select>
		<option value="">직접입력</option>
		<option value="daum.net">daum.net</option>
		<option value="naver.com">naver.com</option>
		<option value="nate.com">nate.com</option>
		<option value="gmail.com">gmail.com</option>
		</select>
		</td>
	</tr>
	 -->
	<tr>
	<th><input type="submit" value="가입하기"></th>
	</tr>
</table>
</form>
</body>
</html>