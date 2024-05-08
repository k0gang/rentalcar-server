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
	<%
	String boardCode = request.getParameter("boardCode");
	String userId = request.getParameter("userid");
	
	System.out.println("userId : " + userId);
	System.out.println("sessin userId : " + session.getAttribute("userId"));
	
	if (boardCode != null) {
		BoardDao boardDao = BoardDao.getInstance();
		BoardResponseDto board = boardDao.findBoard(Integer.parseInt(boardCode));
		if (board != null) {
			String boardTitle = board.getTitle();
			String boardContent = board.getContent();
	%>
	<div>
		<p><%=boardTitle%></p>
		<p><%=boardContent%></p>
		<%
		System.out.println("userId : " + userId);
		System.out.println("sessin userId : " + session.getAttribute("userId"));
		%>
	</div>
	<%
	}
	}
	%>
</body>
<jsp:include page="/footer"></jsp:include>
</html>