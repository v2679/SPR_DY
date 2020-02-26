<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="change" method="post">
	<table>
		<tr>
			<td>번호</td><td><input type="text" name="no" value= ${change.no}></td>
		</tr>
		<tr>
			<td>제목</td><td><input type="text" name="subject" value="${change.subject }"></td>
		</tr>
		<tr>
			<td>내용</td><td><textarea name="content" >${change.content }</textarea></td>
		</tr>
		<tr>
			<td>작성자</td><td>${change.writer }</td>
		</tr>
		<tr>
			<td>작성일자</td><td>${change.write_date }</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="수정">
			</td>
		</tr>
	</table>
</form>
</body>
</html>