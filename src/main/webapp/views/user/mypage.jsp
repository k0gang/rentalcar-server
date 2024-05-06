<%@page import="rentalcarServer.user.model.UserResponseDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<c:import url="/header" />
<body>
   <c:if test="${empty user}">
      <c:redirect url="/login"	/>
   </c:if>
   
	<section id="root">
		<h1>${user.userName}님환영합니다!</h1>

		<button onclick="location.href='/updateUser'">회원정보 수정</button>
		<button onclick="location.href='/deleteUser'">회원 탈퇴</button>
	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>