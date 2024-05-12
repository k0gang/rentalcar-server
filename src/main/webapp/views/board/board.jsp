<%@page import="rentalcarServer.board.model.BoardDao"%>
<%@page import="rentalcarServer.board.model.Board"%>
<%@page import="java.util.List"%>
<%@page import="rentalcarServer.board.model.BoardResponseDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<c:import url="/header" />
<body>
	<section id="board">
		<h1>게시판</h1>
		<table border="1">
			<tr>번호</tr>
			<tr>제목</tr>
			<tr>작성자</tr>
			<tr>작성일</tr>
		<tbody>
			<c:forEach var="board" items="${boardList }">
				<tr>
					<td>${board.boardCode }</td>
					<td><a href="/board/view?boardCode=${board.boardCode }">${board.title }</a></td>
					<td>${board.userId }</td>
					<td>${board.regDate }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	<button onclick="location.href='/write'">게시물 작성</button>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>