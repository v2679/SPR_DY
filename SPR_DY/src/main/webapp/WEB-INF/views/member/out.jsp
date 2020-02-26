<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
<h1>회원탈퇴</h1>
<form action="out" method="post">
	<table>
		<tr><td><input type="text" name="id" placeholder="아이디를 입력해주세요"></td></tr>
		<tr><td><input type="password" name="pw" placeholder="비밀번호를 입력해주세요"></td></tr>
		<tr><th><input type="submit" value="탈퇴하기"></th></tr>
	</table>
</form>
</body>
</html>