<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<script src="/resources/script/validation-car.js"></script>
<c:import url="/header" />
<body>
	<div class='container'>
		<div class='allCar'>
			<c:forEach var="car" items="${carList}">
				<div class='carInfo'>
					<a href="/car?car_num=${car.code}"> <c:choose>
							<c:when test="${car.name eq ''}">
								<img src="">
							</c:when>
							<c:when test="${car.name eq ''}">
								<img
									src="">
							</c:when>
							<c:when test="${car.name eq ''}">
								<img src="">
							</c:when>
							<c:otherwise>
								<img
									src="">
							</c:otherwise>
						</c:choose>
					</a>

					<h4>${car.brand}${car.name }</h4>
					<h3 id='price'>
						<fmt:formatNumber value="${car.price}" pattern="#,###" />
					</h3>
					<p>${car.year}년식|${car.oil}</p>
					<input type="hidden" value="${car.code}">
				</div>
			</c:forEach>
		</div>
	</div>
</body>
<jsp:include page="/footer"></jsp:include>
</html>