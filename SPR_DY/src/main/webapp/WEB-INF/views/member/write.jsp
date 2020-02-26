<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
<h1>글쓰기</h1>
<form action="write" method="post" enctype="multipart/form-data">
<table>
	<tr><td>제목</td></tr><tr><td><input type="text" name="subject"></td></tr>
	<tr><td>내용</td></tr><tr><td><textarea name="content"></textarea></td></tr>
	<tr><td>글쓴이</td></tr><tr><td><input type="text" name="writer" value="${login.id }" readonly></td></tr>
	<tr><td><input type="file" name="file"></td></tr>
	<tr><td><input type="submit" value="글쓰기"></td></tr>
</table>
</form>
</body>
</html>