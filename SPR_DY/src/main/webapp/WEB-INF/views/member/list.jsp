<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dy.mapper.BoardMapperImpl"%>
<%@ page import="com.dy.model.BoardVO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<header>
<h1>자유 게시판</h1>
	</header>
	<hr />
	
	<div>
		<%@include file="nav.jsp" %>
	</div>
	
	<section id="container">
		<form role="form" method="get">
<table class="table table-hover" cellspacing="0" border="1">
<thead>
	<tr>
		<th>no</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성 일자</th>
		<th>조회수</th>
	</tr>
</thead>
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
<table>
<tr>
		<c:catch>
          	<c:choose>
          	<c:when test="${ login.id==null}">
<td>
<p>          </p>
</td>
</c:when>
<c:otherwise>
<a href="http://localhost:8080/kdy/member/write"><input type="button" value="글쓰기"></a>
</c:otherwise>
</c:choose>
</c:catch>
<td>
<c:if test="${page.prev }">
                    			<a href="list?pageNum=${page.startPage - 1 }&amount=${page.cri.amount}&keyword=${page.cri.keyword}">Previous</a>
                    		</c:if>
                    		
                    		<c:forEach var="num" begin="${page.startPage }" end="${page.endPage }">
                    			<a href="list?pageNum=${num}&amount=${page.cri.amount}&keyword=${page.cri.keyword}">${num }</a>
                    	</c:forEach>
                    	
                    	<c:if test="${page.next }">
                    			<a href="list?pageNum=${page.endPage + 1 }&amount=${page.cri.amount}&keyword=${page.cri.keyword}">Next</a>
                    		</c:if>
</td>
</tr>
</table>
</form>
<!-- Topbar Search -->
          <form action="list" method="get"   class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
          <!--  BoardController에 list가 get타입이기 때문에 method="get"으로 맞춰준다 -->
            <div class="input-group">
            	
            	<input type="hidden" name="pageNum" value="${page.cri.getPageNum()}" }>
            	<input type="hidden" name="amount" value="${page.cri.getAmount()}" }>
            	
            	
              <input type="text" name="keyword" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
              <div class="input-group-append">
              <input type="submit" value="검색" class="btn btn-primary">
              
              </div>
            </div>
          </form>
</section>
</div>
</body>
</html>