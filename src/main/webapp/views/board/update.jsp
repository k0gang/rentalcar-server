<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<c:import url="/header" />
<body>
	<h2>게시글 작성</h2>
	<form method="POST" action="/UpdateBoardForm">
		<label for="title">제목:</label><br> <input type="text" id="title"
			name="title" required><br>
		<br> <label for="content">내용:</label><br>
		<textarea id="content" name="content" rows="5" cols="50" required></textarea>
		<br>
		<br> <input type="submit" value="게시물작성">
		
	</form>
	
	<%--
	String boardCode = request.getParameter("boardCode");
	String userId = request.getParameter("userId");
	session = request.getSession();
	session.setAttribute("boardCode", boardCode);
	session.setAttribute("userId", userId);
	System.out.println("userId : " + userId);
	--%>
	
</body>
<jsp:include page="/footer"></jsp:include>
</html>