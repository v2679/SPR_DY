<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">


<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../resources/js/view.js"></script>
</head>
<body>
<div class="container">
<header>
<h1>게시판</h1>
</header>
<hr />
<section id="container">
	<form name="readForm" role="form" method="post">
		<input type="hidden" id="FILE_NO" name="FILE_NO" value="">
	</form>
</section>

<div class="form-group">
	<label for="title" class="col-sm-2 control-label">제목</label>
	<input type="text" class="form-control" name="subject" value="${view.subject }" readonly>
</div>
<div class="form-group">
	<label for="content" class="col-sm-2 control-label">내용</label>
	<textarea name="content" class="form-control" readonly>${view.content }</textarea>
</div>
<div class="form-group">
	<label for="writer" class="col-sm-2 control-label">작성자</label>
	<input type="text" name="writer" class="form-control" value="${view.writer }" readonly>
</div>
<div class="form-group">
	<label for="write_date" class="col-sm-2 control-label">작성일자</label>
	<input type="text" name="write_date" value="${view.write_date }" readonly>
</div>



<!-- 
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
		
		 -->
		 
		 <div>
		 	<a href='change?no=${view.no }'><button type="button" class="update_btn btn btn-warning">수정</button></a>
			<a href='delete?no=${view.no }'><button type="button" class="update_btn btn btn-warning">삭제</button></a>
			<a href="http://localhost:8080/kdy/member/list"><button type="button" class="update_btn btn btn-warning">목록</button></a>
		 </div>
		 
		 
		<!-- 
		<tr>
			<td>
			<a href='change?no=${view.no }'>수정</a>
			<a href='delete?no=${view.no }'>삭제</a>
			</td>
		</tr>
		
	</table>
</form>
 -->

<!-- 댓글 작성 -->
<div>
	<div>
		<input type="hidden" name="no" id="reno" value="${view.no}">
	</div>
	<div>
	<c:catch>
          	<c:choose>
          	<c:when test="${ login.id==null}">
		<td>
		<p></p>
		</td>
	</c:when>
	<c:otherwise>
	<table>
		<tr><td>댓글 작성자: <input type="text" name="replyer" id="rewriter" value="${login.id }" readonly></td></tr>
		<tr><td>댓글 내용  : <textarea rows="5" cols="60" name="rtext" id="retext"></textarea></td></tr>
	</table>
	</div>
	<input type="button" id="replyadd" value="댓글 작성">
	</c:otherwise>
	</c:choose>
	</c:catch>
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