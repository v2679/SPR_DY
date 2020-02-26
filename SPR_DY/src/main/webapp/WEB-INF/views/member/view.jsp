<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<form id="" method="get">
	<table>
		<tr>
			<td>번호</td><td><input type="text" name="no" value=${view.no} readonly></td>
		</tr>
		<tr>
			<td>제목</td><td><input type="text" name="subject" value="${view.subject }"></td>
		</tr>
		<tr>
			<td>내용</td><td><textarea name="content" >${view.content }</textarea></td>
		</tr>
		<tr>
			<td>작성자</td><td><input type="text" name="writer" value="${view.writer }" readonly></td>
		</tr>
		<tr>
			<td>작성일자</td><td><input type="text" name="write_date" value="${view.write_date }" readonly></td>
		</tr>
		
		<tr><td>파일 목록</td></tr>
		<div>
			<c:forEach var="file" items="${file }">
				<a href="#" onclick="filedown('${file.file_no}'); return false;">${file.filename }</a>(${file.file_size }kb)
			</c:forEach>	
		</div>
		
		
		
		<tr>
			<td>
			<a href='change?no=${view.no }'>수정</a>
			<a href='delete?no=${view.no }'>삭제</a>
			</td>
		</tr>
	</table>
</form>


<!-- 댓글 작성 -->
<div>
	<div>
		<input type="hidden" name="no" id="reno" value="${view.no}">
	</div>
	<div>
		댓글 작성자 : <input type="text" name="replyer" id="rewriter">
	</div>
	<div>
		댓글 내용 : <textarea name="rtext" id="retext"></textarea>
	</div>
	<input type="button" id="replyadd" value="댓글 작성">
</div>
<!-- 댓글 수정  -->
<div id="modDiv">
	<div class="title"></div>
	<div><input type="text" id="rtext"></div>
	<div>
		<button id="replyMod">수정</button>
		<button id="replyDel">삭제</button>
	</div>
</div>

<ul id="replies">
</ul>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="../resources/js/reply.js"></script>
</body>
</html>