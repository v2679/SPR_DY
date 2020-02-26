<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dy.mapper.BoardMapperImpl"%>
<%@ page import="com.dy.model.BoardVO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>자유 게시판</h1>
<table cellspacing="0" border="1">
	<tr>
		<th>no</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성 일자</th>
		<th>조회수</th>
	</tr>
	<c:forEach var="board" items="${list}">
	<tr>
		<td>${board.no}</td>
		<td><a href='view?no=${board.no }'>${board.subject}</td>
		<td>${board.writer}</td>
		<td>${board.write_date}</td>
		<td>${board.cnt }</td>
	</tr>
	</c:forEach>
</table>
<a href="http://localhost:8080/kdy/member/write"><input type="button" value="글쓰기"></a>
</body>
</html>