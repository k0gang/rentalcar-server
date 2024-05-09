<%@page import="rentalcarServer.board.model.BoardResponseDto"%>
<%@page import="java.util.List"%>
<%@page import="rentalcarServer.board.model.BoardDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<c:import url="/header" />
<body>
	<h1>게시글 확인</h1>
	<div>
		<p>board title : ${requestScope.board.title}</p>
		<p>board content : ${board.content}</p>
		<p>board userId : ${board.userId}</p>
		<p>user.userId : ${user.userId}</p>
		<p>${board}</p>
		
		<c:if test="${board.userId eq user.userId}">
		<form method="POST" action="">
			<input type="hidden" name="boardCode" value="${board.boardCode}">
			<button type="submit">수정하기</button>
		</form>
	</c:if>
	<c:if test="${board.userId eq user.userId}">
		<form method="POST" action="/DeleteBoardForm" >
			<input type="hidden" name="boardCode" value="${board.boardCode}">
			<button type="submit">삭제하기</button>
		</form>
	</c:if>
	</div>
</body>
<jsp:include page="/footer"></jsp:include>
</html>